package com.icin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Admin {

	@Id
	@GeneratedValue
	private int id;
	private String emailid;
	private String password;
	
	public Admin()
	{
		
	}
	
	public Admin(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailid == null) ? 0 : emailid.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (emailid == null) {
			if (other.emailid != null)
				return false;
		} else if (!emailid.equals(other.emailid))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [emailid=" + emailid + ", password=" + password + "]";
	}
	
	
}
