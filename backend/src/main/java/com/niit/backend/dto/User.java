package com.niit.backend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name="UserTable")
public class User {

	@Id
	private String email;
	private String name;
	private String password;
	private Address address;
	private String phone;
	private String role;
	private boolean enabled;
	
	@ElementCollection
	@JoinTable(name="UserAddressTable",joinColumns=@JoinColumn(name="email"))
	private Set<Address> addresss=new HashSet<>();
	
	public Set<Address> getAddresss() {
		return addresss;
	}
	public void setAddresss(Set<Address> addresss) {
		this.addresss = addresss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
