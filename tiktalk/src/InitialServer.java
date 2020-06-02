
import java.io.*;
import java.net.*;
import java.util.UUID;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.*;
/**
 * This thread is responsible to handle client connection.
 */
public class InitialServer extends Thread {
    private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;

    public InitialServer(Socket socket) {
        this.socket = socket;
    }

    Date now = new Date();
    Dates dates = new Dates();
    Random rand = new Random(); 
    int port; 
    int portInitial = 1000; 
    LinkedList<Integer> usedSockets = new LinkedList<Integer>();


    public void run() {
        try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
        	
        	while(true) {
     			String text = (String)input.readObject();  //read the object received through the stream and deserialize it
    			System.out.println("server received a text:" + text);
    			
    			port = rand.nextInt(8998)+1001;
    			output.writeObject(port); 
    			
    			ServerSocket ss2;
    			ss2 = new ServerSocket (port);
    			Socket socket2 = ss2.accept();
    			new ServerThread(socket2).start();
    			
    			input.close();
    			output.close();
    			socket.close();
                //connection au nouveau socket
    			socket = new Socket("localhost", portInitial);
    			output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
        	}
        	
        	
        	
			//create the streams that will handle the objects coming through the sockets




			//Message message = new Message(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),dates.nowDate(), "john.doe");
			
	///		output.writeObject(message);		//serialize and write the Student object to the stream

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
    }
}
