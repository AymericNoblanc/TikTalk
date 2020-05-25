import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		System.out.println("ex = " + rs.getString("ex"));
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
		System.out.println("ex = " + rs.getString("ex"));
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
}
