import java.io.*; 
import java.net.*;
import java.util.Scanner;

public class SimpleClient {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;

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
            
            System.out.println("Entrez votre pseudo ");
			String textToSend = scan.nextLine();
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
