package com.niit.backend.dao;

import java.util.List;
import java.util.Set;

import com.niit.backend.dto.Cart;

public interface CartDAO {
	
	public void addItem(Cart cart);
	public List<Cart> getAllItems();
	public List<Cart> getAllItemsForUser(String emailID);
	
	//will update the quantity
	public void updateCart(int cartId,int quantity);
	public void deleteCart(int cartId);
	public double calculateTotal(String email);
	
}
