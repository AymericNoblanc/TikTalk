package controller;
import java.text.DateFormat;
import java.util.Date;

public class MainControllerC {
	int reponseClient = 1;
	
	public MainControllerC(){
		System.out.println("Hello World !");
		launchClient();
	}

	public static void main(String[] args) {
		MainControllerC mainControllerC = new MainControllerC();
	}
	    public void launchClient() {
	    	while(reponseClient == 1) {
	    	SimpleClient c1 = new SimpleClient();
			reponseClient = c1.connect("localhost");
			System.out.println("L'etat de fin du client est : " + reponseClient);
	    	}
	    }
}
