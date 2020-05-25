
import java.io.*;
import java.net.*;
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

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    Date now = new Date();
    Dates dates = new Dates();




    public void run() {
        try {
			//create the streams that will handle the objects coming through the sockets
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());

 			String text = (String)input.readObject();  //read the object received through the stream and deserialize it
			System.out.println("server received a text:" + text);

			Message message = new Message(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),dates.nowDate(), "john.doe");
			output.writeObject(message);		//serialize and write the Student object to the stream

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
