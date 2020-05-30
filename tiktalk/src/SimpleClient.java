import java.io.*; 
import java.net.*;
import java.util.Scanner;
import java.util.LinkedList;
public class SimpleClient {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;
	private LinkedList<Contact> cList;
	public void connect(String ip)
	{
		int port = 6666;
        try  {
			//create the socket; it is defined by an remote IP address (the address of the server) and a port number
			socket = new Socket(ip, port);

			//create the streams that will handle the objects coming and going through the sockets
			output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            Scanner scan = new Scanner(System.in);
            int choix1User;
            
            User monUser;
            System.out.println("Tapez 1 pour créer un compte ou tapez 2 pour vous connecter");
            choix1User = scan.nextInt();
            while(choix1User != 1 && choix1User != 2) {
                System.out.println("Tapez 1 pour créer un compte ou tapez 2 pour vous connecter");
                choix1User = scan.nextInt();
            }
        	//Envoi au serveur l'info qu'on veut se connecter ou creer un compte
    		output.writeObject(choix1User);
    		
            if(choix1User == 1) {

         	   
                System.out.println("Entrez votre pseudo ");
    			String textToSend = scan.nextLine();
    			textToSend = scan.nextLine();
    			System.out.println("text sent to the server: " + textToSend);
    			output.writeObject(textToSend);
    			
    			System.out.println("Entrez un mot de passe ");
    			String textToSend2 = scan.nextLine();
    			System.out.println("text sent to the server: " + textToSend2);
    			output.writeObject(textToSend2);		//serialize and write the String to the stream
    			

    			String reponseCreation = (String) input.readObject();
    			System.out.println("Le server indique le message: "+ reponseCreation);
            	
    			while(!reponseCreation.equals("utilisateurCree")) {
    				
    				System.out.println("Entrez votre pseudo ");
    				textToSend = scan.nextLine();
    				System.out.println("text sent to the server: " + textToSend);
    				output.writeObject(textToSend);		//serialize and write the String to the stream
    				
    				System.out.println("Entrez un mot de passe ");
    				textToSend2 = scan.nextLine();
    				System.out.println("text sent to the server: " + textToSend2);
    				output.writeObject(textToSend2);		//serialize and write the String to the stream
    				
    				reponseCreation = (String) input.readObject();
    				System.out.println("Le server indique le message: "+ reponseCreation);
    			}
    			monUser = (User) input.readObject();
    			 System.out.println("Received user id: " + monUser.getId() + " and user pseudo:" + monUser.getPseudo() + " from server");
            
          
            	
            }else {
    
    	
            	   
                System.out.println("Entrez votre pseudo ");
    			String textToSend = scan.nextLine();
    			textToSend = scan.nextLine();
    			System.out.println("text sent to the server: " + textToSend);
    			output.writeObject(textToSend);		//serialize and write the String to the stream
    			 System.out.println("Entrez votre mot de passe ");
    			String textToSend2 = scan.nextLine();
    			System.out.println("text sent to the server: " + textToSend2);
    			output.writeObject(textToSend2);		//serialize and write the String to the stream
    			
    			
    			
    			
    			String reponseConnection = (String) input.readObject();
    			System.out.println("Le server indique le message: "+ reponseConnection);
    			
    			while(!reponseConnection.equals("ConnectionAcceptee")) {
    				
    				System.out.println("Entrez votre pseudo ");
    				textToSend = scan.nextLine();
    				System.out.println("text sent to the server: " + textToSend);
    				output.writeObject(textToSend);		//serialize and write the String to the stream
    				
    				System.out.println("Entrez votre mot de passe ");
    				textToSend2 = scan.nextLine();
    				System.out.println("text sent to the server: " + textToSend2);
    				output.writeObject(textToSend2);		//serialize and write the String to the stream
    				
    				reponseConnection = (String) input.readObject();
    				System.out.println("Le server indique le message: "+ reponseConnection);
    			}
    			monUser = (User) input.readObject();
    			 System.out.println("Received user id: " + monUser.getId() + " and user pseudo:" + monUser.getPseudo() + " from server");
            }
            
            System.out.println("Voici la liste de vos contacts");
            cList = (LinkedList<Contact>) input.readObject();
            for(int num=0; num<cList.size(); num++)
            {
          	  System.out.println(cList.get(num).getContactPseudo() );//.getContactPseudo());
            }
            
            System.out.println("Vous allez envoyer un message indiquez l'id de la personne a contacter:");
           
            int idContact = scan.nextInt();
            output.writeObject(idContact);
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
