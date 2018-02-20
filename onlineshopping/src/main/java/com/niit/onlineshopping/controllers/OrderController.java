package com.niit.onlineshopping.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.AddressDAO;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.User;

@Controller
public class OrderController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	AddressDAO addressDao;
	
	@Autowired
	CartDAO cartDao;
	
	@RequestMapping(value={"/cart/deliver"})
	public ModelAndView getBillingDetails(@RequestParam("addrId")int addrId,HttpSession session){
		
		String email=(String)session.getAttribute("email");
		User userObj=userDao.getUserById(email);
		Address addressObj=addressDao.getAddressById(addrId);
		
		ModelAndView mv=new ModelAndView("billing");
		mv.addObject("userObj",userObj);
		mv.addObject("addressObj",addressObj);
		mv.addObject("title","Billing");
		mv.addObject("totalAmount",cartDao.calculateTotal(email));
		
		
		
		return mv;
	}
}
