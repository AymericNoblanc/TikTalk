
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.UUID;
import java.text.DateFormat;
import java.util.Date;


/**
 * This thread is responsible to handle client connection.
 */
public class ServerThread extends Thread {
    private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private MainControllerS mcs;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    Date now = new Date();
    Dates dates = new Dates();




    public void run() {
    	try {
			mcs = new MainControllerS();
			boolean connectionAccepted =false;
			 try {
					//create the streams that will handle the objects coming through the sockets
					input = new ObjectInputStream(socket.getInputStream());
					output = new ObjectOutputStream(socket.getOutputStream());

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
					output.writeObject("ConnectionAcceptee");
					
					//Message message = new Message(1,1,1,dates.nowDate(), "john.doe");
					//output.writeObject(message);		//serialize and write the Student object to the stream

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
