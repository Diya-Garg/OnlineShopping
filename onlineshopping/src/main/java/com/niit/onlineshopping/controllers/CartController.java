package com.niit.onlineshopping.controllers;

import java.security.Principal;

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
import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.Product;
import com.niit.backend.dto.User;



@Controller
public class CartController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDAO cartDao;
	
	@Autowired
	AddressDAO addressDao;
	
	@RequestMapping(value="/cart/addToCart")
	public ModelAndView index(@RequestParam(name="prodid",required=false)String prodid,@RequestParam(name="quantity",required=false)String quantity,
			HttpSession session)
	{
		System.out.println("Quantity : "+quantity);
		System.out.println("PRoduct Id :" +prodid); 
		
		
		//String email=principal.getName();
		String email=(String)session.getAttribute("email");
		
		Product product=productDao.getProductById(Integer.parseInt(prodid));
		
		System.out.println("Email Address : "+email);
		
		session.setAttribute("userEmail", email);
		
		Cart cartObj=new Cart();
		cartObj.setCardProductId(product.getProductId());
		cartObj.setCartImage(product.getImgname());
		cartObj.setCartPrice(product.getPrice());
		cartObj.setCartProductName(product.getProductName());
		cartObj.setCartQuantity(Integer.parseInt(quantity));
		cartObj.setCartUserDetails(userDao.getUserById(email));
		cartObj.setStatus("Not Paid");
		
		cartDao.addItem(cartObj);
		
		
		ModelAndView mv=new ModelAndView("anonymoususer");
		mv.addObject("message","Item added in cart");
		mv.addObject("title","Cart");
		mv.addObject("cart",cartDao.getAllItemsForUser(email));
		mv.addObject("amountToPay",cartDao.calculateTotal(email));
		return mv;
	}
	
	@RequestMapping(value="/cart/processCart")
	public ModelAndView processCart(HttpServletRequest request,HttpSession session){
		
		ModelAndView mv=new ModelAndView("anonymoususer");
		
		int cartId=Integer.parseInt(request.getParameter("cartId"));
		String btn1=request.getParameter("btn1");
		String btn2=request.getParameter("btn2");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String email=(String)session.getAttribute("email");
		
		if(btn1!=null){
			
			//do the Remove
			cartDao.deleteCart(cartId);
			mv.addObject("message","Item Removed");
		}
		if(btn2!=null){
			
			//do the Update
			cartDao.updateCart(cartId, quantity);
			mv.addObject("message","Cart Updated");
		}
		
		
		mv.addObject("title","Cart");
		
		double amtToPay=cartDao.calculateTotal(email);
		mv.addObject("amountToPay",amtToPay);
		mv.addObject("cart",cartDao.getAllItemsForUser(email));
		return mv;
		
	}
	
	@ModelAttribute
	public void getEmailAddress(Principal principal,HttpSession session){
		String email=principal.getName();
		session.setAttribute("email",email);
		
	}
	
	@RequestMapping(value="/cart/viewCart")
	public ModelAndView viewCart(HttpSession session){
		
		//String email=principal.getName();
		String email=(String)session.getAttribute("email");
		
		ModelAndView mv=new ModelAndView("anonymoususer");
		mv.addObject("title","Cart");
		mv.addObject("message","Your Cart");
		mv.addObject("cart",cartDao.getAllItemsForUser(email));
		double amtToPay=cartDao.calculateTotal(email);
		mv.addObject("amountToPay",amtToPay);
		return mv;
		
	}
	
	@RequestMapping(value="/cart/checkOut")
	public ModelAndView checkOut(HttpSession session){
		
		String email=(String)session.getAttribute("email");
		User userObj=userDao.getUserById(email);		
		
		ModelAndView mv=new ModelAndView("CheckOut");
		mv.addObject("userObj",userObj);
		mv.addObject("message","Select a Delivery Address");
		mv.addObject("title","CheckOut");
		return mv;
	}
	
	@RequestMapping(value="/cart/addNewAddress")
	public ModelAndView showAddressForm(){
		
		ModelAndView mv=new ModelAndView("AddressForm");
		mv.addObject("message","Select a Delivery Address");
		mv.addObject("addressObj",new Address());
		mv.addObject("title","CheckOut");
		return mv;
	}
	
	
	@RequestMapping(value="/cart/addAddressProcess")
	public ModelAndView processAddressForm(HttpSession session,@ModelAttribute("addressObj")Address addressObj){
		
		String email=(String)session.getAttribute("email");
		
		User userObj=userDao.getUserById(email);
		
		addressObj.setUser(userObj);
		userObj.getAddresses().add(addressObj);
		
		addressDao.insertAddress(addressObj);
		
		ModelAndView mv=new ModelAndView("CheckOut");
		mv.addObject("message","New Address Added Succesfully");
		mv.addObject("title","CheckOut");
		mv.addObject("userObj",userObj);
		return mv;
	}
	
	@RequestMapping(value="/cart/editAddress")
	public ModelAndView editAddressForm(@RequestParam("addrId")String addrId){
		
		
		int addressId=Integer.parseInt(addrId);
		
		Address obj=addressDao.getAddressById(addressId);		
		
		
		ModelAndView mv=new ModelAndView("CheckOut");
		mv.addObject("addressObj",obj);
		mv.addObject("message","Edit Form");
		mv.addObject("title","CheckOut");
		
		return mv;
	}
	
	@RequestMapping(value="/cart/addAddressEditProcess")
	public ModelAndView editAddressFormProcess(HttpSession session,@ModelAttribute("addressObj")Address addressObj){
		
		
		String email=(String)session.getAttribute("email");
		User userObj=userDao.getUserById(email);
		
		
		addressObj.setUser(userObj);
		addressDao.updateAddress(addressObj);
		
		
		ModelAndView mv=new ModelAndView("CheckOut");	
		mv.addObject("message","Address Updated Succesfully");
		mv.addObject("title","CheckOut");
		mv.addObject("userObj",userDao.getUserById(email));
		return mv;
	}
	
}














