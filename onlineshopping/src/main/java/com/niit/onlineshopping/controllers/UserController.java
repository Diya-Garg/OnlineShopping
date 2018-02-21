package com.niit.onlineshopping.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Product;
import com.niit.backend.dto.User;
import com.niit.backend.validators.PasswordValidator;

@Controller
public class UserController {

	
	@Autowired
	@Qualifier("passwordValidator")
	private Validator validator;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	
	/*@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}*/
	
	
	
	
	
	@RequestMapping(value="/listProducts")
	public ModelAndView getAllProducts(@RequestParam(name="category",required=false)String category) {
		
		System.out.println("Category = "+category);
		ModelAndView mv=new ModelAndView("anonymoususer");
		List<Product> productList=null;
		
		if(category==null){
			productList=productDao.getProducts();
		}
		
		else {
			productList=productDao.getProducts(category);
		}
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
	
	@RequestMapping(value="/changePassword")
	public ModelAndView changePasswordForm(){
		ModelAndView mv=new ModelAndView("ChangePassword");
		mv.addObject("userObj",new User());
		mv.addObject("title","Change Password");
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
	public ModelAndView signUpProcess(@Valid @ModelAttribute("userObj")User userObj,BindingResult result){
		
		
		validator.validate(userObj, result);
		if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("SignUpForm");
			mv.addObject("title","SignUpForm");
			return mv;
			
		}
		ModelAndView mv=new ModelAndView("login");
		
		userObj.setRole("ROLE_USER");
		userObj.setEnabled(true);
		
		userDao.registerUser(userObj);
		mv.addObject("title","SignUpForm");
		mv.addObject("message1","registrationDone");
		return mv;
	}
	
	
}
