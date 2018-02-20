package com.niit.onlineshopping.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Product;
import com.niit.backend.dto.User;

@Controller
public class UserController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/listProducts")
	public ModelAndView getAllProducts() {
		ModelAndView mv=new ModelAndView("anonymoususer");
		List<Product> productList=productDao.getProducts();
		mv.addObject("productList",productList);
		mv.addObject("title","OurShop.com");
		mv.addObject("message","listAllProducts");
		return mv;
	}
	
	@RequestMapping(value="/getProductById")
	public ModelAndView getProductById(@RequestParam(name="prodid")String prodid) {
		ModelAndView mv=new ModelAndView("anonymoususer");
		Product product=productDao.getProductById(Integer.parseInt(prodid));
		mv.addObject("productObj",product);
		mv.addObject("title","OurShop.com");
		mv.addObject("message","ViewProductDetails");
		return mv;
	}
	
	@RequestMapping(value="/getSignUpForm")
	public ModelAndView getSignUpForm(){
		ModelAndView mv=new ModelAndView("SignUpForm");
		mv.addObject("userObj",new User());
		mv.addObject("title","SignUpForm");
		return mv;
	}
	

	@RequestMapping(value="/signupprocess")
	public ModelAndView signUpProcess(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("login");
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		System.out.println(Integer.parseInt(request.getParameter("houseNo")));
		System.out.println(request.getParameter("locality"));
		System.out.println(request.getParameter("city"));
		System.out.println(request.getParameter("state"));
		
		
		User userObj=new User();
		userObj.setName(request.getParameter("name"));
		userObj.setPassword(request.getParameter("password"));
		userObj.setPhone(request.getParameter("phone"));
		userObj.setRole("ROLE_USER");
		userObj.setEnabled(true);
		userObj.setEmail(request.getParameter("email"));
		
		
		Address addr=new Address();
		addr.setHouseNumber(Integer.parseInt(request.getParameter("houseNo")));
		addr.setLocality(request.getParameter("locality"));
		addr.setCity(request.getParameter("city"));
		addr.setState(request.getParameter("state"));
		addr.setUser(userObj);
		
		System.out.println("Pin Code : "+request.getParameter("pinCode"));
		addr.setPinCode(request.getParameter("pinCode"));
		userObj.getAddresses().add(addr);
		
		
		userDao.registerUser(userObj);
		mv.addObject("title","SignUpForm");
		mv.addObject("message1","registrationDone");
		return mv;
	}
	
	
}
