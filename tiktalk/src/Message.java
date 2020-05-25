import java.util.Date;
import java.util.UUID;
import java.io.Serializable;
import java.text.DateFormat;

//import sun.util.calendar.BaseCalendar.Date;


public class Message implements Serializable		 //must implement Serializable in order to be sent over a Socket
{

 UUID id;
 UUID envoyeur;
 UUID recever;
 DateFormat time;
 String txt;

public Message(UUID id,UUID envoyeur, UUID recever, DateFormat time, String txt) {
	this.id=id;
	this.envoyeur=envoyeur;
	this.recever=recever;
	this.time=time;
	this.txt=txt;
}


public UUID getId() {
	return id;
}

public UUID getEnvoyeur() {
	return envoyeur;
}

public void setEnvoyeur(UUID envoyeur) {
	this.envoyeur = envoyeur;
}

public UUID getRecever() {
	return recever;
}

public void setRecever(UUID recever) {
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
