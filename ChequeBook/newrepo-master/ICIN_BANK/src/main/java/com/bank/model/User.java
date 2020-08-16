package com.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String uemail;
	private String ucontact;
	private String upan;
	private String upass;
	@Transient
	private String cpass;
	private String udob;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUcontact() {
		return ucontact;
	}

	public void setUcontact(String ucontact) {
		this.ucontact = ucontact;
	}

	public String getUpan() {
		return upan;
	}

	public void setUpan(String upan) {
		this.upan = upan;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getUdob() {
		return udob;
	}

	public void setUdob(String udob) {
		this.udob = udob;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", ucontact=" + ucontact + ", upan="
				+ upan + ", upass=" + upass + ", cpass=" + cpass + ", udob=" + udob + "]";
	}

	

	
	

}
