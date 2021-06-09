package com.HibernateDemo.HibernateORM;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User { // POJOs

	@Id
	private int userID;
	private String userName;
	private int age;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return userID + " | " + userName + " | " + age;
	}
	
	
	
}
