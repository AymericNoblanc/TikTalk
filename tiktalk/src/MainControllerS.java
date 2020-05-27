import java.io.*;
import java.net.*;
import java.sql.*;

public class MainControllerS {

	
	DBConnection dbc;
	
	public  MainControllerS() throws SQLException  {
		System.out.println("Hello World !");
		dbc = new DBConnection();
		//dbc.getConnection();
		
		
		
		
		//ResultSet result = dbc.dbSelect("select * from users");
		//result.next();

		//User user = dbc.fetchUser("Arnul");
		//System.out.println(loginAttempt(dbc, "Arnul", "arun12345"));
		
		
		
		//launchServer();
		
		
		
		
	}


//	public static void main(String[] args) throws SQLException {
//		MainControllerS mcs = new MainControllerS();
		
//	}



	//public void launchServer() {
	//	AbstractServer as = new FirstServer();
	//	String ip = "localhost";
	//	as.connect(ip);
	//}
	
	public boolean loginAttempt(DBConnection dbc, String userPseudo, String userPassword) throws SQLException {
		if(dbc.verifUserExists(userPseudo) == true) {
			System.out.println("pseudo trouv� dans la bd");
			if(dbc.verifUserLogin(userPseudo,userPassword)) {
				System.out.println("informations de connection correctes");
				return true;
			}else {
				System.out.println("mot de passe incorrect");
				return false;
			}
		}else {
			System.out.println("pseudo incorrect");
			return false;
		}
	}

	
	public boolean addNewUser(DBConnection dbc, String userPseudo, String userPassword, String userIP) throws SQLException {
		if(dbc.verifUserExists(userPseudo) == false) {
			dbc.addUserToDB(userPseudo,userPassword,userIP);
			if(dbc.verifUserExists(userPseudo) == true) {
				System.out.println("Utilisateur cr�� dans la base de donn�e");
				return true;
			}else {
				System.out.println("Erreur d'ajout dans la base de donn�e");
				return false;
			}
		}else {
			System.out.println("L'utilisateur �xiste d�j�");
			return false;
		}
	}
}
