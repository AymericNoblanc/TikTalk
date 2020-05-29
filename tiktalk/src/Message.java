import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;

//import sun.util.calendar.BaseCalendar.Date;


public class Message implements Serializable		 //must implement Serializable in order to be sent over a Socket
{

int id;
int envoyeur;
int recever;
java.sql.Timestamp dateSQL;
String txt;

public Message(int id,int envoyeur, int recever,java.sql.Timestamp dateSQL, String txt) {
	this.id=id;
	this.envoyeur=envoyeur;
	this.recever=recever;
	this.dateSQL=dateSQL;
	this.txt=txt;
}
public void setId(int id) {
	this.id = id;
}

public int getId() {
	return id;
}

public int getEnvoyeur() {
	return envoyeur;
}

public void setEnvoyeur(int envoyeur) {
	this.envoyeur = envoyeur;
}

public int getRecever() {
	return recever;
}

public void setRecever(int recever) {
	this.recever = recever;
}





public java.sql.Timestamp getDateSQL() {
	return dateSQL;
}
public void setDateSQL(java.sql.Timestamp dateSQL) {
	this.dateSQL = dateSQL;
}
public String getTxt() {
	return txt;
}

public void setTxt(String txt) {
	this.txt = txt;
}



}
