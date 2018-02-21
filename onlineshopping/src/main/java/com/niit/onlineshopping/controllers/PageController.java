package com.niit.onlineshopping.controllers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDao;
import com.niit.backend.dto.User;


@Controller
public class PageController {

	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value={"/","home"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDao.listCategories());
		mv.addObject("userClicksHome",true);
		return mv;
	}
	
	@RequestMapping(value={"about"})
	public ModelAndView about(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value={"contact"})
	public ModelAndView contact(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value={"/goToLogin"})
	public ModelAndView goToLogin(){
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("title","Login Page");
		mv.addObject("userObj",new User());
		return mv;
	}
	
	@RequestMapping(value={"/admin/Home"})
	public String adminLogin(Model m){
		m.addAttribute("title","Admin Home");
		return "adminpage";
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	

	
	
}
