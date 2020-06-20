import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*; 
import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.LinkedList;
import java.time.*;
public class SimpleClient {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private Socket socketAttribue;
	private LinkedList<Contact> cList;
	private LinkedList<Contact> cList2;
	private LoginGUI loginGUI;
	private InscriptionGUI inscriGUI;
	private ChatRoomGUI chatGUI;
	private LinkedList<Message> MList;
	private int idSelected;
	private LocalDateTime now;
	private Period period;
	private long seconds;
	private boolean exitButtonValue;

	public int connect(String ip)
	{
		int port = 1000;
		int portAttribue;
		try  {
			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			Scanner scan = new Scanner(System.in);
			int choix1User;
			LinkedList<Message> mList = new LinkedList<Message>();
			User monUser;



			// RECEPTION DU PORT ET CHANGEMENT DE CANAL

			output.writeObject("packet de demande de connection"); //envoi du premier message au server

			portAttribue = (int) input.readObject();
			System.out.println("Le port de connection est : "+ portAttribue);

			input.close();
			output.close();
			socket.close();
			//connection au nouveau socket
			socketAttribue = new Socket(ip, portAttribue);
			output = new ObjectOutputStream(socketAttribue.getOutputStream());
			input = new ObjectInputStream(socketAttribue.getInputStream());

			loginGUI = new LoginGUI();

			loginGUI.setVisible(true);

			while(!loginGUI.loginButton && !loginGUI.creerButton && !loginGUI.closeButtonValue) {
				System.out.println("attente 1");
			}


			if(loginGUI.creerButton == true) {

				loginGUI.dispose();
				inscriGUI = new InscriptionGUI();
				inscriGUI.setVisible(true);
				
				
				output.writeObject(1);
				String reponseCreation ="NON";



				//   System.out.println("Entrez votre pseudo ");

				String textToSend = inscriGUI.champPseudo;

				//System.out.println("text sent to the server: " + textToSend);
				//output.writeObject(textToSend);

				//System.out.println("Entrez un mot de passe ");
				String textToSend2 = inscriGUI.champMDP;

				while(!reponseCreation.equals("utilisateurCree")) {

					System.out.println("attente3");



					//String reponseCreation = (String) input.readObject();
					//System.out.println("Le server indique le message: "+ reponseCreation);


					if(inscriGUI.validerButton == true) {
						//System.out.println("Entrez votre pseudo ");
						textToSend = inscriGUI.champPseudo;
						System.out.println("text sent to the server: " + textToSend);
						output.writeObject(textToSend);		//serialize and write the String to the stream

						//System.out.println("Entrez un mot de passe ");
						textToSend2 = inscriGUI.champMDP;
						System.out.println("text sent to the server: " + textToSend2);
						output.writeObject(textToSend2);		//serialize and write the String to the stream

						reponseCreation = (String) input.readObject();
						System.out.println("Le server indique le message: "+ reponseCreation);
						inscriGUI.validerButton = false;
					}


				}
				inscriGUI.dispose();



			}else if (loginGUI.loginButton == true) {
				output.writeObject(2);


				//System.out.println("Entrez votre pseudo ");
				String textToSend = loginGUI.champPseudo;
				System.out.println("text sent to the server: " + loginGUI.champPseudo);
				output.writeObject(loginGUI.champPseudo);		//serialize and write the String to the stream


				//System.out.println("Entrez votre mot de passe ");
				String textToSend2 = loginGUI.champMDP;
				System.out.println("text sent to the server: " + loginGUI.champMDP);
				output.writeObject(loginGUI.champMDP);		//serialize and write the String to the stream




				String reponseConnection = (String) input.readObject();
				System.out.println("Le server indique le message: "+ reponseConnection);

				while(!reponseConnection.equals("ConnectionAcceptee")) {
					if(loginGUI.loginButton == true) {
						//System.out.println("Entrez votre pseudo ");
						textToSend = loginGUI.champPseudo;
						//System.out.println("text sent to the server: " + textToSend);
						output.writeObject(textToSend);		//serialize and write the String to the stream

						//System.out.println("Entrez votre mot de passe ");
						textToSend2 = loginGUI.champMDP;
						//System.out.println("text sent to the server: " + textToSend2);
						output.writeObject(textToSend2);		//serialize and write the String to the stream

						reponseConnection = (String) input.readObject();
						//System.out.println("Le server indique le message: "+ reponseConnection);
						loginGUI.loginButton =false;
					}
				}
				System.out.println("Connection reussie a l'utilisateur");
				loginGUI.dispose();


				
			}else if(loginGUI.closeButtonValue == true) {
				output.writeObject(3);
				return 0;
			}
			monUser = (User) input.readObject();
			
			System.out.println("Received user id: " + monUser.getId() + " and user pseudo:" + monUser.getPseudo() + " from server");
			chatGUI = new ChatRoomGUI();
			chatGUI.lblNewLabel.setText("Chatroom de " + monUser.getPseudo());
			chatGUI.cList = cList;
			chatGUI.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e) {
			         int Answer = JOptionPane.showConfirmDialog(chatGUI, "You want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			         if (Answer == JOptionPane.YES_OPTION) {
			        	 exitButtonValue = true;
			        	 chatGUI.dispose();
			             }
			    }
			});
			chatGUI.setVisible(true);

			System.out.println("Voici la liste de vos contacts");
			cList = (LinkedList<Contact>) input.readObject();
			for(int num=0; num<cList.size(); num++)
			{
				System.out.println(cList.get(num).getContactPseudo() );//.getContactPseudo());
				chatGUI.model.addElement(cList.get(num));
			}
			/////////////////////////////////////////////////////////////////////////////////////////////////////


			//chatGUI.indexSelected = 
			idSelected = -1;
			now = LocalDateTime.now();
			seconds = now.atZone(ZoneId.systemDefault()).toEpochSecond();
			while(!exitButtonValue && !chatGUI.disconnectButtonValue) {

				if(chatGUI.addContactButtonValue == true) {
					output.writeObject(3);
					output.writeObject(chatGUI.addContactField.getText());
					chatGUI.addContactField.setText("Tentative d'ajout en cours");
					chatGUI.addContactButtonValue = false;
					boolean reussite = (boolean)input.readObject();
					if(reussite) {
						chatGUI.addContactField.setText("Ajouter un autre contact");
						chatGUI.addContactField.setBackground(Color.WHITE);
					}else {
						chatGUI.addContactField.setText("Pseudo incorrect");
						chatGUI.addContactField.setBackground(Color.RED);
					}
				}
				
				
		
				
				
				if(chatGUI.cJList.getSelectedIndex() != -1) {

					if(idSelected != chatGUI.cJList.getSelectedValue().getContactID()) {
						output.writeObject(1);
						
						idSelected = chatGUI.cJList.getSelectedValue().getContactID();
						System.out.println("id selected:" + idSelected);
						output.writeObject(idSelected);
						mList = (LinkedList<Message>)input.readObject();

						chatGUI.modelMessage.clear();
						for(int num=0; num<mList.size(); num++)
						{
							//	  System.out.println(mList.get(num).getContactPseudo() );//.getContactPseudo());
							chatGUI.modelMessage.addElement(mList.get(num));
							if(mList.get(num).getEnvoyeur() == monUser.getId())   
								chatGUI.mJList.setSelectedIndex(num);

						}



					}else if(chatGUI.boutonEnvoyer == true) {
						output.writeObject(2);
						output.writeObject(chatGUI.msg_text.getText());
						chatGUI.msg_text.setText("");
						chatGUI.boutonEnvoyer = false;
					}else {
						System.out.println("attente3" );


					}
				}



				if(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond() - seconds > 0) {
					System.out.println("time = " + seconds);

					if(chatGUI.cJList.getSelectedIndex() != -1) {
						output.writeObject(1);

						idSelected = chatGUI.cJList.getSelectedValue().getContactID();
						System.out.println("id selected:" + idSelected);
						output.writeObject(idSelected);
						mList = (LinkedList<Message>)input.readObject();

						chatGUI.modelMessage.clear();
						for(int num=0; num<mList.size(); num++){
							//		  System.out.println(mList.get(num).getContactPseudo() );//.getContactPseudo());
							chatGUI.modelMessage.addElement(mList.get(num));
							if(mList.get(num).getEnvoyeur() == monUser.getId())   
								chatGUI.mJList.setSelectedIndex(num);

						}

					}

					output.writeObject(4);
					//cList2.clear();
					cList2 = (LinkedList<Contact>) input.readObject();
					if(cList.size() != cList2.size()) {
						cList.clear();
						cList.addAll(cList2);
						chatGUI.model.clear();
						for(int num=0; num<cList.size(); num++)
						{
							System.out.println(cList.get(num).getContactPseudo() );//.getContactPseudo());
							chatGUI.model.addElement(cList.get(num));
						}
					}

					now = LocalDateTime.now();
					seconds = now.atZone(ZoneId.systemDefault()).toEpochSecond();

				}




				for(int num=0; num<mList.size(); num++)
				{
					System.out.println(mList.get(num).getDateSQL() +" "+ mList.get(num).getEnvoyeur() +"   "+ mList.get(num).getTxt() );//.getContactPseudo());
				}

			}
			output.writeObject(5);






		} catch  (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch  (IOException ioe) {
			ioe.printStackTrace();
		}
		catch  (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		finally {
			try {
				input.close();
				output.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		if(exitButtonValue) {
			return 0;
		}else {
			return 1;
		}
	}

}
