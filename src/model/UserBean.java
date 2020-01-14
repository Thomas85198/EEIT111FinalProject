package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "UsersTable")
@Component
public class UserBean {

	// Variables, matches table columns
	private int userID;
	private String userEmail;
	private String userPwd;
	private int admin;
	
	// Constructors
	public UserBean() {
	}
	
	public UserBean(String newUserEmail, String newUserPwd) {
		this.userEmail = newUserEmail;
		this.userPwd = newUserPwd;
	}

	// Get/Set Methods
	@Id
	@Column(name="userID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return userID;
	}
	public void setId(int newUserID) {
		this.userID = newUserID;
	}

	@Column(name="userEmail")
	public String getUserEmail() {
		return userEmail;
	}
	public void setUsername(String newUserEmail) {
		this.userEmail = newUserEmail;
	}

	@Column(name="userPwd")
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String newUserPwd) {
		this.userPwd = newUserPwd;
	}

	@Column(name="admin")
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int newAdmin) {
		this.admin=newAdmin;
	}
	
}
