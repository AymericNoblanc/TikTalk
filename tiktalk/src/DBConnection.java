import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.time.*;
import java.util.*;
public class DBConnection {

	Connection conn;

	public DBConnection() {
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiktalk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "javaAccess", "java" );

		System.out.println("Connection établie avec la base de données");
	}
	catch(Exception exc){
		exc.printStackTrace();
		System.out.println("Erreur de connection avec la base de données");
	}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public ResultSet dbSelect(String statementText) throws SQLException {
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(statementText);
		return rs;
	}
	
	public void dbUpdate(String statementText) throws SQLException {
		Statement stat = conn.createStatement();
		stat.executeUpdate(statementText);
	}
	
	public boolean verifUserLogin(String userPseudo, String userPassword) throws SQLException {
		ResultSet rs = dbSelect("SELECT EXISTS(SELECT * FROM users WHERE userPseudo =\"" + userPseudo + "\" and userPassword = \"" + userPassword + "\") as ex;");
		rs.next();
		if ((rs.getInt("ex")) == 1) {
			return true;
	}
	else {
		return false;
	}
	}
	
	public boolean verifUserExists(String userPseudo) throws SQLException {
		ResultSet rs = dbSelect("SELECT EXISTS(SELECT * FROM users WHERE userPseudo =\"" + userPseudo + "\") as ex;");
		rs.next();
		if ((rs.getInt("ex")) == 1) {
			return true;
	}
	else {
		return false;
	}
	}
	
	public User fetchUser(String userPseudo) throws SQLException {
		ResultSet rs = dbSelect("SELECT * FROM users WHERE userPseudo =\"" + userPseudo + "\";");
		rs.next();
		User user = new User(rs.getInt("userID"),userPseudo,rs.getString("userPassword"), rs.getString("userIP"));
		return user;
	}
	
	public String fetchPseudo(int Id) throws SQLException {
		ResultSet rs = dbSelect("SELECT * FROM users WHERE userID =\"" + Id + "\";");
		rs.next();
		String pseudo= rs.getString("userPseudo");
		return pseudo;
	}
	
	
	
	public void addUserToDB(String userPseudo, String userPassword, String userIP) throws SQLException {
	dbUpdate("INSERT INTO users (userPseudo, userPassword, userIp) VALUES (\"" + userPseudo + "\", \"" + userPassword + "\", \"" + userIP + "\")");
	}
	
	
	public LinkedList<Message> fetchMessage(int user1ID, int user2ID) throws SQLException{
		
		LinkedList<Message> mList = new LinkedList<Message>();
		
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        
        
		ResultSet rs = dbSelect("SELECT * FROM messages WHERE (envoyeurID =\"" + user1ID + "\" and receveurID =\"" + user2ID + "\") or (envoyeurID =\"" + user2ID + "\" and receveurID =\"" + user1ID + "\") ORDER BY date DESC;");
		int messageID;
		int envoyeurID;
		int receveurID;
		java.sql.Timestamp dateSQL;
		String txt;
		String pseudoEnvoyeur;
		
		while(rs.next()) {
			messageID= rs.getInt("messageID");
			envoyeurID= rs.getInt("envoyeurID");
			receveurID= rs.getInt("receveurID");
			dateSQL= rs.getTimestamp("date");
			txt= rs.getString("text");
			pseudoEnvoyeur= rs.getString("pseudoEnvoyeur");
			Message mess = new Message(messageID,envoyeurID,receveurID,dateSQL,txt, pseudoEnvoyeur);
			mList.addFirst(mess);
			//System.out.println("message ajouté dans la liste");
		}
		
		return mList;
	}
	
	public void addMessage(int envoyeurID, int receveurID, java.sql.Timestamp sqlTimeStamp,String text) throws SQLException{
			
		if(fetchPseudo(receveurID).startsWith("group")) {
			LinkedList<Contact> cList = new LinkedList<Contact>();
			cList = getContactList(receveurID);
			for (int num=0; num<cList.size(); num++)
		    {
				dbUpdate("INSERT INTO messages (envoyeurID,receveurID,date,text,pseudoEnvoyeur) VALUES (\"" + receveurID+ "\", \"" + cList.get(num).getContactID() + "\",\"" + sqlTimeStamp +  "\", \"" + text +  "\", \"" + fetchPseudo(envoyeurID) + "\");");
		    }
		}
		else {
		dbUpdate("INSERT INTO messages (envoyeurID,receveurID,date,text,pseudoEnvoyeur) VALUES (\"" + envoyeurID+ "\", \"" + receveurID + "\",\"" + sqlTimeStamp +  "\", \"" + text +  "\", \"" + fetchPseudo(envoyeurID) + "\");");
		}
	
	}
	
	
	public LinkedList<Contact> getContactList(int userID) throws SQLException{
	LinkedList<Contact> cList = new LinkedList<Contact>();
	
	ResultSet rs = dbSelect("SELECT receveurID FROM messages where envoyeurID = \""+ userID +"\" UNION SELECT envoyeurID FROM messages where receveurID=\"" + userID + "\";");
	int contactID;
	String contactPseudo;
	while(rs.next()) {
		 contactID = rs.getInt("receveurID");
		 contactPseudo = fetchPseudo(rs.getInt("receveurID"));
		
		Contact contact = new Contact(contactID,contactPseudo);
		cList.add(contact);
		//System.out.println("contacts trouvés:" + contact.getContactID() + contact.getContactPseudo());
	}
    for(int num=0; num<cList.size(); num++)
    {
  	//  System.out.println(num + ":" +cList.get(num).getContactPseudo() );//.getContactPseudo());
    }
	return cList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
