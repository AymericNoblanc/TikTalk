import java.io.Serializable;
public class Contact implements Serializable{
int contactID;
String contactPseudo;


public Contact(int contactID, String contactPseudo){
	this.contactID = contactID;
	this.contactPseudo = contactPseudo;
}


public int getContactID() {
	return contactID;
}


public void setContactID(int contactID) {
	this.contactID = contactID;
}


public String getContactPseudo() {
	return contactPseudo;
}


public void setContactPseudo(String contactPseudo) {
	this.contactPseudo = contactPseudo;
}

}
