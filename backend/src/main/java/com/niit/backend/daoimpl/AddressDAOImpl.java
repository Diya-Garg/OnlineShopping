package com.niit.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.AddressDAO;
import com.niit.backend.dto.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void insertAddress(Address address) {
		getSession().save(address);
		
	}


	@Override
	public Address getAddressById(int addressId) {
		Address addr=getSession().get(Address.class,addressId);
		return addr;
	}


	@Override
	public void updateAddress(Address address) {
		getSession().update(address);
		
	}


	@Override
	public void deleteAddress(int addressId) {
		Address addr=getSession().get(Address.class, addressId);
		getSession().delete(addr);
		
	}

}
