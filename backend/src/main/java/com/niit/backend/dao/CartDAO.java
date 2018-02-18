package com.niit.backend.dao;

import java.util.List;
import java.util.Set;

import com.niit.backend.dto.Cart;

public interface CartDAO {
	
	public void addItem(Cart cart);
	public List<Cart> getAllItems();
}
