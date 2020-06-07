import java.io.*; 
import java.net.*;
import java.util.Scanner;
import java.util.LinkedList;
public class SimpleClient {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private Socket socketAttribue;
	private LinkedList<Contact> cList;
	private LoginGUI loginGUI;
	private InscriptionGUI inscriGUI;
	private ChatRoomGUI chatGUI;
	public void connect(String ip)
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
            
            //System.out.println("Tapez 1 pour créer un compte ou tapez 2 pour vous connecter");
            //choix1User = scan.nextInt();
            //while(choix1User != 1 && choix1User != 2) {
            //    System.out.println("Tapez 1 pour créer un compte ou tapez 2 pour vous connecter");
            //    choix1User = scan.nextInt();
            //}
        	//Envoi au serveur l'info qu'on veut se connecter ou creer un compte
            while(loginGUI.loginButton == false && loginGUI.creerButton == false) {
            	System.out.println("attente 1");
            }
            System.out.println("kebab ");
    		
    		
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
    			//System.out.println("text sent to the server: " + textToSend2);
    			//output.writeObject(textToSend2);		//serialize and write the String to the stream
    			
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
    			monUser = (User) input.readObject();
    			 System.out.println("Received user id: " + monUser.getId() + " and user pseudo:" + monUser.getPseudo() + " from server");
            
          
            	
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
    			
    			
    			monUser = (User) input.readObject();
    			 System.out.println("Received user id: " + monUser.getId() + " and user pseudo:" + monUser.getPseudo() + " from server");
            }
            chatGUI = new ChatRoomGUI();
            chatGUI.setVisible(true);
            
            System.out.println("Voici la liste de vos contacts");
            cList = (LinkedList<Contact>) input.readObject();
            for(int num=0; num<cList.size(); num++)
            {
          	  System.out.println(cList.get(num).getContactPseudo() );//.getContactPseudo());
            }
            
            System.out.println("Vous allez envoyer un message indiquez l'id de la personne a contacter:");
            int idContact = scan.nextInt();
            output.writeObject(idContact);
            System.out.println("Voici l'historique de vos messages avec cette personne:");
            mList = (LinkedList<Message>) input.readObject();
            for(int num=0; num<mList.size(); num++)
            {
          	  System.out.println(mList.get(num).getDateSQL() +" "+ mList.get(num).getEnvoyeur() +"   "+ mList.get(num).getTxt() );//.getContactPseudo());
            }
            
            System.out.println("Entrez le texte du message à envoyer:");
            scan.nextLine();
            String textToSend = scan.nextLine();
            output.writeObject(textToSend);
			
            
            
            
            
            
            
            
            
            
			
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
	}

}
