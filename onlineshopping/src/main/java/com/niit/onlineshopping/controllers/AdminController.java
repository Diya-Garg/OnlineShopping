package com.niit.onlineshopping.controllers;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDao;
import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.SupplierDao;
import com.niit.backend.dto.Category;
import com.niit.backend.dto.Product;
import com.niit.backend.dto.Supplier;

@Controller
public class AdminController {

	@Autowired
	CategoryDao categoryDAO;
	
	@Autowired
	ProductDao productDAO;
	
	@Autowired
	SupplierDao supplierDAO;
	
	@RequestMapping(value={"/login"})
	public ModelAndView index(@RequestParam(name="error",required=false)String error,@RequestParam(name="logout",required=false)String logout){
		
		ModelAndView mv=new ModelAndView("login");
		if(error!=null){
			mv.addObject("message","username or password is incorrect");
		}
		if(logout!=null){
			mv.addObject("message","User has succesfully logged out!!");
		}
		mv.addObject("title","Login");
		return mv;
	}
	
	
	@RequestMapping(value="/error")
	public String error() {
		return "redirect:/login?error";
	}
	
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		//first we are going to fetch the authentication
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
	
	

	@RequestMapping(value="/admin/add")
	public ModelAndView addingOptions(){
		ModelAndView mv=new ModelAndView("AdminAdding");
		
		mv.addObject("categoryObj",new Category());
		mv.addObject("supplierObj",new Supplier());
		
		
		List<Category> categories=categoryDAO.listCategories();
		List<Supplier> suppliers=supplierDAO.listSuppliers();
		
		
		mv.addObject("categoryList",categories);
		mv.addObject("supplierList",suppliers);
		
		mv.addObject("productObj",new Product());
		
		
		
		mv.addObject("title","Admin");
		return mv;
	}
	
	

	@RequestMapping(value="/admin/addCategory")
	public ModelAndView addCategory(@ModelAttribute("categoryObj")Category categoryObj) {
		ModelAndView mv=new ModelAndView("adminpage");
		categoryDAO.insertCategory(categoryObj);
		mv.addObject("title","Admin");
		mv.addObject("message","Category Added Succesfully");
		mv.addObject("categoryObj",new Category());
		
		
		return mv;
	}

	@RequestMapping(value="/admin/addSupplier")
	public ModelAndView addSupplier(@ModelAttribute("supplierObj")Supplier supplierObj) {
		ModelAndView mv=new ModelAndView("adminpage");
		supplierDAO.insertSupp(supplierObj);
		mv.addObject("title","Admin");
		mv.addObject("message","Supplier Added Succesfully");
		return mv;
	}
	
	@RequestMapping(value="/admin/addProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest request,@RequestParam("file")MultipartFile file){
		
		Product product=new Product();
		product.setProductName(request.getParameter("productName"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		
		Category c=categoryDAO.getCategoryById(Integer.parseInt(request.getParameter("category")));
		Supplier s=supplierDAO.getSupplierById(Integer.parseInt(request.getParameter("supplier")));
		
		product.setCategory(c);
		product.setSupplier(s);
		
		String filePathString=request.getSession().getServletContext().getRealPath("/");
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		
		product.setImgname(fileName);
		
		productDAO.insertProduct(product);
		
		
		
		try{
			
			//String ABS_PATH="C:/Users/hp/Desktop/DevopsTraining/git/OnlineShopping/onlineshopping/src/main/webapp/assets/images/";
			//String REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
			
			
			
			byte[] imageBytes=file.getBytes();
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(filePathString+"/resources/images/"+fileName));
			bos.write(imageBytes);
			bos.close();
			
			System.out.println(filePathString);
			
			/*BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(REAL_PATH+fileName));
			bos.write(imageBytes);
			bos.close();*/
			
			//file.transferTo(new File(ABS_PATH));
			//file.transferTo(new File(REAL_PATH));
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	
		ModelAndView mv=new ModelAndView("adminpage");
		mv.addObject("title","Admin");
		mv.addObject("message","Product Added Succesfully");
		return mv;
	}
	
	
	@RequestMapping(value="/admin/listProducts")
	public ModelAndView fetchProducts(){
		ModelAndView mv=new ModelAndView("adminpage");
		List<Product> productList=productDAO.getProducts();
		mv.addObject("productList",productList);
		mv.addObject("message","productList");
		mv.addObject("title","Admin");
		return mv;
	}
	
	@RequestMapping(value="/admin/updateProduct")
	public ModelAndView updateProduct(@RequestParam("prodid")String prodid){
		ModelAndView mv=new ModelAndView("adminpage");
	
		Product prod=productDAO.getProductById(Integer.parseInt(prodid));
		List<Category> categories=categoryDAO.listCategories();
		List<Supplier> suppliers=supplierDAO.listSuppliers();
		mv.addObject("categoryList",categories);
		mv.addObject("supplierList",suppliers);
		mv.addObject("productObj",prod);
		mv.addObject("title","Admin");
		mv.addObject("message","showProductForm");
		return mv;
	}
	
	@RequestMapping(value="/admin/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("prodid")String prodid){
		
		System.out.println("I m here in Delete Product method...");
		ModelAndView mv=new ModelAndView("adminpage");
		
		boolean result=productDAO.deleteProduct(Integer.parseInt(prodid));
		if(result){
			mv.addObject("message","Product deleted succesfully...");
		}
		mv.addObject("title","Admin");
		return mv;
	}
	
	@RequestMapping(value="/admin/updateProductProcess",method=RequestMethod.POST)
	public ModelAndView updateProductProcess(HttpServletRequest request,@RequestParam("file")MultipartFile file){
		
		Product product=new Product();
		product.setProductName(request.getParameter("productName"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		int catId=Integer.parseInt(request.getParameter("category"));
		int suppId=Integer.parseInt(request.getParameter("supplier"));
		
		System.out.println("Category Id : "+catId);
		System.out.println("Supplier Id : "+suppId);
		
		Category c=categoryDAO.getCategoryById(catId);
		Supplier s=supplierDAO.getSupplierById(suppId);
		
		product.setCategory(c);
		product.setSupplier(s);
		
		String filePathString=request.getSession().getServletContext().getRealPath("/");
		
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		
		product.setImgname(fileName);
		
		productDAO.updateProduct(product);
		
		try{
			byte[] imageBytes=file.getBytes();
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(filePathString+"\\"+fileName));
			bos.write(imageBytes);
			bos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		ModelAndView mv=new ModelAndView("adminpage");
		mv.addObject("title","Admin");
		mv.addObject("message","Product Updated Succesfully");
		return mv;
	}

	
}






