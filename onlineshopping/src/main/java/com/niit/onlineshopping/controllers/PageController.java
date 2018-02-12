package com.niit.onlineshopping.controllers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value="/")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		return mv;
	}
	
	
	@RequestMapping(value="/test")
	//public ModelAndView test(@RequestParam("greeting")String greeting){
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting){
		ModelAndView mv=new ModelAndView("page");
		if(greeting==null){
			greeting="Hello";
		}
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView testWithPathVariable(@PathVariable("greeting")String greeting){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
}
