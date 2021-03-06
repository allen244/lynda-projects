package com.avs.data.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUEST")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUEST_ID")
	private long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static void main(String[] args) throws ParseException {
		//Mon, 30 Oct 2017 16:17:59 -0400
		  //Thu Sep 28 20:29:30 JST 2000
		String s = "Mon, 30 Oct 2017 16:17:59 -0400";
		Date d1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:s Z").parse(s);
		System.out.println(d1);

	}
}