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

	@Override
	public List<Cart> getAllItemsForUser(String emailID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Cart> query=getSession().createQuery("from com.niit.backend.dto.Cart where cartUserDetails.email=:a");
		query.setParameter("a",emailID);
		List<Cart> list=query.getResultList();
		return list;
	}

	@Override
	public void updateCart(int cartId, int quantity) {
		Cart obj=getSession().load(Cart.class,cartId);
		obj.setCartQuantity(quantity);
		System.out.println("Cart Quantity updated");
		
	}

	@Override
	public void deleteCart(int cartId) {
		Cart obj=getSession().load(Cart.class,cartId);
		getSession().delete(obj);
		System.out.println("Item deleted from the cart");
		
	}

	@Override
	public double calculateTotal(String emailId) {
		System.out.println("Email ID  : "+emailId);
		double amt=0;
		@SuppressWarnings("unchecked")
		TypedQuery<Cart> query=getSession().createQuery("from com.niit.backend.dto.Cart where cartUserDetails.email=:a and status=:status");
		query.setParameter("a",emailId);
		query.setParameter("status","Not Paid");
		List<Cart> list=query.getResultList();
		System.out.println(list);
		for(Cart obj:list){
			amt=obj.getCartPrice()*obj.getCartQuantity()+amt;
		}
		System.out.println("Amount : "+amt);
		return amt;
	}

}
