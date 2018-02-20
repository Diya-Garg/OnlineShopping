package com.niit.backend.dao;

import com.niit.backend.dto.Address;

public interface AddressDAO {

	public void insertAddress(Address address);
	public Address getAddressById(int addressId);
	public void updateAddress(Address address);
	public void deleteAddress(int addressId);
}
