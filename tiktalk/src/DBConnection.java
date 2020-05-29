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
	public void addUserToDB(String userPseudo, String userPassword, String userIP) throws SQLException {
	dbUpdate("INSERT INTO users (userPseudo, userPassword, userIp) VALUES (\"" + userPseudo + "\", \"" + userPassword + "\", \"" + userIP + "\")");
	}
	
	
	public LinkedList<Message> fetchMessage(int user1ID, int user2ID) throws SQLException{
		
		LinkedList<Message> mList = new LinkedList<Message>();
		
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        
        Message mess = new Message(1,1,1,sqlTimeStamp,"a");
		ResultSet rs = dbSelect("SELECT * FROM messages WHERE (envoyeurID =\"" + user1ID + "\" and receveurID =\"" + user2ID + "\") or (envoyeurID =\"" + user2ID + "\" and receveurID =\"" + user1ID + "\");");
	
		while(rs.next()) {
			mess.id= rs.getInt("messageID");
			mess.envoyeur= rs.getInt("envoyeurID");
			mess.recever= rs.getInt("receveurID");
			mess.dateSQL= rs.getTimestamp("date");
			mess.txt= rs.getString("text");
			mList.addFirst(mess);
			System.out.println("message ajouté dans la liste");
		}
		
		return mList;
	}
	
	public void addMessage(int envoyeurID, int receveurID, java.sql.Timestamp sqlTimeStamp,String text) throws SQLException{
			dbUpdate("INSERT INTO messages (envoyeurID,receveurID,date,text) VALUES (\"" + envoyeurID+ "\", \"" + receveurID + "\",\"" + sqlTimeStamp +  "\", \"" + text + "\");");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
