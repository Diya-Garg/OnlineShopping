package com.niit.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dto.Product;

@Controller
public class UserController {

	@Autowired
	ProductDao productDao;
	
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

}
