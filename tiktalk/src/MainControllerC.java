import java.text.DateFormat;
import java.util.Date;

public class MainControllerC {

	public MainControllerC(){
		System.out.println("Hello World !");
		launchClient();
	}

	public static void main(String[] args) {
		MainControllerC mainControllerC = new MainControllerC();
	}
	    public void launchClient() {
	    	SimpleClient c1 = new SimpleClient();
			c1.connect("localhost");
	    }
}
