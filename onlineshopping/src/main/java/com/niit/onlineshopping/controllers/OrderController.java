package com.niit.onlineshopping.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.AddressDAO;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.OrderDAO;
import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.Order;
import com.niit.backend.dto.User;

@Controller
public class OrderController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	AddressDAO addressDao;
	
	@Autowired
	CartDAO cartDao;
	
	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value={"/cart/deliver"})
	public ModelAndView getBillingDetails(@RequestParam("addrId")int addrId,HttpSession session){
	
		String email=(String)session.getAttribute("email");
		
		double totalAmount=cartDao.calculateTotal(email);
		
		session.setAttribute("billingAddress", addressDao.getAddressById(addrId));
		session.setAttribute("totalAmount", totalAmount);
		
		
		ModelAndView mv=new ModelAndView("billing");
		mv.addObject("title","Billing");
		mv.addObject("totalAmount",totalAmount);
		mv.addObject("message","Show Payment Form");
		mv.addObject("orderObj",new Order());
		
		return mv;
	}
	
	@RequestMapping(value={"/cart/makePayment"})
	public ModelAndView makePayment(@ModelAttribute("orderObj")Order orderObj,HttpSession session){
		
		String email=(String)session.getAttribute("email");
		double amount=(double)session.getAttribute("totalAmount");
		
		Address address=(Address)session.getAttribute("billingAddress");
		User userObj=userDao.getUserById(email);
		
		
		orderObj.setTotalPrice(amount);
		orderObj.setAddress(address);
		orderObj.setUser(userObj);
		
		int orderId=0;
		
		List<Cart> items=cartDao.getAllItemsForUser(email);
		for(Cart item:items){
			int quantityasked=item.getCartQuantity();
			int productIdAsked=item.getCardProductId();
			
			productDao.updateQuantity(productIdAsked, quantityasked);
			cartDao.changeStatus(email);
			
			orderId=orderDao.makeOrder(orderObj);
			
		}
		
		
		
		ModelAndView mv=new ModelAndView("billing");
		mv.addObject("title","Billing");
		mv.addObject("orderId",orderId);
		mv.addObject("message","Show Invoice");
		mv.addObject("orderObj",orderObj);
		
		
		
		return mv;
	}
}











