import java.io.*;
import java.net.*;
import java.sql.*;

public class MainControllerS {

	public  MainControllerS() throws SQLException  {
		System.out.println("Hello World !");
		DBConnection dbc = new DBConnection();
		dbc.getConnection();
		ResultSet result = dbc.dbSelect("select * from users");
		result.next();
		System.out.println("Le mot de passe de " + result.getString("userPseudo") +" est " + result.getString("userPassword"));
		
		System.out.println(dbc.verifUserLogin("Arnul","arun12345"));
		System.out.println(dbc.verifUserExists("Arngul"));
		User user = dbc.fetchUser("Arnul");
		System.out.println("User id = " + user.getId());
		
		
		dbc.addUserToDB("Duke", "ilovegouter", "123684");
		launchServer();
		
	}


	public static void main(String[] args) throws SQLException {
		MainControllerS mcs = new MainControllerS();
		
	}



	public void launchServer() {
		AbstractServer as = new FirstServer();

		String ip = "localhost";
		as.connect(ip);
	}
	
}
