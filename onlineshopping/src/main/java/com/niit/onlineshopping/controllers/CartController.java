package com.niit.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.Product;



@Controller
public class CartController {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value={"/addToCart"})
	public ModelAndView index(@RequestParam(name="prodid",required=false)String prodid){
		int productId=Integer.parseInt(prodid);
		
		Product product=productDao.getProductById(productId);
		
		Cart cartObj=new Cart();
		cartObj.setCardProductId(product.getProductId());
		cartObj.setCartImage(product.getImgname());
		cartObj.setCartPrice(productId);
		
		
		ModelAndView mv=new ModelAndView("login");
		//if(error!=null){
			mv.addObject("message","username or password is incorrect");
		//}
		//if(logout!=null){
			mv.addObject("message","User has succesfully logged out!!");
		//}
		mv.addObject("title","Login");
		return mv;
	}

}