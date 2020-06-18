
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.UUID;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;


/**
 * This thread is responsible to handle client connection.
 */
public class ServerThread extends Thread {
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private MainControllerS mcs;
	private java.sql.Timestamp sqlTimeStamp;
	private String textToSend;

	Date now = new Date();
	Dates dates = new Dates();
	User clientUser;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}


	public void run() {
		try {
			mcs = new MainControllerS();
			boolean connectionAccepted =false;
			boolean userCreated =false;
			try {
				//create the streams that will handle the objects coming through the sockets
				input = new ObjectInputStream(socket.getInputStream());
				output = new ObjectOutputStream(socket.getOutputStream());

				// test
				java.util.Date date = new java.util.Date();


				/*
					LinkedList<Message> mList = mcs.dbc.fetchMessage(1, 7);
					 for(int num=0; num<mList.size(); num++)
			            {
			          	  System.out.println("message "+num + ": " +mList.get(num).getTxt() );//.getContactPseudo());
			            }*/
				//Message mess = mList.peek();
				//System.out.println("Dans la liste: " + mess.getId() + mess.getRecever() + mess.getEnvoyeur() + mess.getDateSQL() + mess.getTxt());

				int user1Choice= (int)input.readObject();
				if(user1Choice==1) {
					System.out.println("L'utilisateur souhaite créer un compte");


					String text = (String)input.readObject();  
					System.out.println("server received a text:" + text);
					String text2 = (String)input.readObject(); 
					System.out.println("server received a text:" + text2);
					userCreated =	mcs.addNewUser(mcs.dbc, text, text2, "14.30");
					while(userCreated == false) {

						output.writeObject("Nom d'utilisateur non disponible");

						text = (String)input.readObject();
						System.out.println("server received a text:" + text);

						text2 = (String)input.readObject();
						System.out.println("server received a text:" + text2);

						userCreated =	mcs.addNewUser(mcs.dbc, text, text2, "14.30");
					}
					clientUser = mcs.dbc.fetchUser(text);
					output.writeObject("utilisateurCree");
					output.writeObject(clientUser);
				}



				else{
					System.out.println("L'utilisateur souhaite se connecter à un compte existant");

					String text = (String)input.readObject();  //read the object received through the stream and deserialize it
					System.out.println("server received a text:" + text);
					String text2 = (String)input.readObject();  //read the object received through the stream and deserialize it
					System.out.println("server received a text:" + text2);
					connectionAccepted =	mcs.loginAttempt(mcs.dbc, text, text2);

					while(connectionAccepted == false) {

						output.writeObject("Connection refusée");

						text = (String)input.readObject();
						System.out.println("server received a text:" + text);

						text2 = (String)input.readObject();
						System.out.println("server received a text:" + text2);

						connectionAccepted =	mcs.loginAttempt(mcs.dbc, text, text2);
					}
					clientUser = mcs.dbc.fetchUser(text);
					output.writeObject("ConnectionAcceptee");
					output.writeObject(clientUser);
				}

				output.writeObject(mcs.dbc.getContactList(clientUser.getId()));
				int idContact;
				int changed = -1;
				String pseudoContact;
				idContact = 0;


				while(changed != 5) {
					changed = (int)input.readObject();
					if(changed == 1) {
						idContact = (int)input.readObject();
						output.writeObject(mcs.dbc.fetchMessage(clientUser.getId(), idContact));
					}
					else if(changed == 2) {
						date = new java.util.Date();
						sqlTimeStamp = new java.sql.Timestamp(date.getTime());

						textToSend = (String)input.readObject();
						//	output.writeObject(mcs.dbc.fetchMessage(clientUser.getId(), idContact));

						mcs.dbc.addMessage(clientUser.getId(), idContact, sqlTimeStamp, textToSend);
					}
					else if(changed == 3) {
						pseudoContact = (String)input.readObject();
						date = new java.util.Date();
						sqlTimeStamp = new java.sql.Timestamp(date.getTime());


						if(mcs.dbc.verifUserExists(pseudoContact)) {
							textToSend = "L'urilisateur : " +clientUser.getPseudo() + " souhaite vous contacter.";
							//	output.writeObject(mcs.dbc.fetchMessage(clientUser.getId(), idContact));
							mcs.dbc.addMessage(clientUser.getId(), mcs.dbc.fetchUser(pseudoContact).getId(), sqlTimeStamp, textToSend);
							output.writeObject(true); // on envoi réussite a l'utilisateur
						}else {
							output.writeObject(false);
						}

					}
					else if(changed == 4) {
						output.writeObject(mcs.dbc.getContactList(clientUser.getId()));
					}
					
				}



			} catch (IOException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
				

			} catch (ClassNotFoundException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
			} finally {
				try {
					output.close();
					input.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
