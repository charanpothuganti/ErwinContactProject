package com.erwin.demos.contactbookapp;

import java.io.Serializable;


public class Contact implements Serializable{
	String name;
	long phnnum;
	String email;

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phnnum=" + phnnum + ", email=" + email + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhnnum() {
		return phnnum;
	}
	public void setPhnnum(long phnnum) {
		this.phnnum = phnnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

    

