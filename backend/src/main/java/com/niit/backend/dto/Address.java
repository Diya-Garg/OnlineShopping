package com.niit.backend.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserAddressTable")
public class Address {

	@Id
	@GeneratedValue
	private int id;
	private int houseNumber;
	private String locality;
	private String city;
	private String state;
	private String pinCode;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="email")
	private User user;
	
	
	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNumber=" + houseNumber
				+ ", locality=" + locality + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + ", user=" + user + "]";
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
		
}
