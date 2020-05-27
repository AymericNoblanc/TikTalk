import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;

//import sun.util.calendar.BaseCalendar.Date;


public class Message implements Serializable		 //must implement Serializable in order to be sent over a Socket
{

 int id;
 int envoyeur;
 int recever;
 DateFormat time;
 String txt;

public Message(int id,int envoyeur, int recever, DateFormat time, String txt) {
	this.id=id;
	this.envoyeur=envoyeur;
	this.recever=recever;
	this.time=time;
	this.txt=txt;
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

public DateFormat getTime() {
	return time;
}

public void setTime(DateFormat time) {
	this.time = time;
}

public String getTxt() {
	return txt;
}

public void setTxt(String txt) {
	this.txt = txt;
}



}
