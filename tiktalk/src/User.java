import java.io.Serializable;

public class User  implements Serializable{

     int id;
     String pseudo;
     String password;
     String ip;
     
    public User(int id, String pseudo, String password, String ip) {
        this.id=id;
        this.pseudo=pseudo;
        this.password=password;
        this.ip=ip;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}