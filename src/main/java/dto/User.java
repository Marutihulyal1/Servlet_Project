package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	String Name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String Email;
	long Mobno;
	String Password;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobno() {
		return Mobno;
	}
	public void setMobno(long mobno) {
		Mobno = mobno;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
