package com.niit.shoppingCart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.dao.SupplierDao;
import com.niit.shoppingcart.dao.UserDao;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private Category category;
	
	@Autowired 
	private Supplier supplier;
	
	@Autowired 
	private Product product;
	
	@Autowired
	private User user;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired 
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public ModelAndView onLoad (HttpSession session)
	{
		log.debug("start of onload");
		ModelAndView mv=new ModelAndView("/index");
		
		log.debug("end of onload");
		
	return mv;
	} 

	@RequestMapping("/login")
	public ModelAndView login()
	{
		log.debug("start of login");
		ModelAndView mv= new ModelAndView("/login","command",user);
		mv.addObject("user", user);
		mv.addObject("isUserClickedLogin", "true");
		log.debug("end oflogin");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register()
	{
		log.debug("start of register");
		ModelAndView mv=new ModelAndView("/index","command",new User());
	//	mv.addObject("user", user);
		mv.addObject("isUserClickedRegister","true");
		log.debug("end of register");
		return mv;
	}
	
	@RequestMapping(value="/Category",method=RequestMethod.GET)
	public ModelAndView category()
	{
		log.debug("start of category");
		ModelAndView mv=new ModelAndView("/index","command",new Category());
		mv.addObject("adminClickedCategory","True");
		
		log.debug("end of category");
		return mv;
	}
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView product()
	{
		log.debug("start of product");
		ModelAndView mv=new ModelAndView( "/index","command",new Product());
		mv.addObject("userClickedProduct","true");
		List<Category> category = categoryDao.list();
		List<Supplier> supplier = supplierDao.list();
		mv.addObject("Category", category);
		mv.addObject("Supplier", supplier);
		log.debug("end of product");
		return mv;
	}
	@RequestMapping("/supplier")
	public ModelAndView supplier()
	{
		log.debug("start of supplier");
		ModelAndView mv=new ModelAndView("/index","command",new Supplier());
		mv.addObject("adminClickedSupplier","True");
		log.debug("end of supplier");
		return mv;
	}
	
}
