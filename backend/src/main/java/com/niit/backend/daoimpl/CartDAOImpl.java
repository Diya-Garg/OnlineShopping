package com.niit.backend.daoimpl;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.CartDAO;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addItem(Cart cart) {
		getSession().save(cart);
	}

	@Override
	public List<Cart> getAllItems() {
		@SuppressWarnings("unchecked")
		TypedQuery<Cart> query=getSession().createQuery("from com.niit.backend.dto.Cart");
		List<Cart> list=query.getResultList();
		System.out.println("List of Categories : "+list);
		return list;
	}

}