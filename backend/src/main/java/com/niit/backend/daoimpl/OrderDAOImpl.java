package com.niit.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.AddressDAO;
import com.niit.backend.dao.OrderDAO;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int makeOrder(Order order) {
		return (int) getSession().save(order);
		
	}

}
