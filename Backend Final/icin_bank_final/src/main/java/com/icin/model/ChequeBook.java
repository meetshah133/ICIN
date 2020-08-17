package com.icin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ChequeBook {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private boolean accepted;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public ChequeBook() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ChequeBook [id=" + id + ", accepted=" + accepted + ", user=" + user + "]";
	}
	

}
