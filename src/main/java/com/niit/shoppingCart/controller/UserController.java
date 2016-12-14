package com.niit.shoppingCart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Supplier supplier;

	@Autowired
	Category category;
	
	@Autowired
	Product product;
	
	@Autowired
	User user;

	@Autowired
	private HttpSession session;

	@RequestMapping("/user")
	public ModelAndView onLoad ()
	{
		log.debug("start of onload");
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)

	public ModelAndView login(@RequestParam(value = "email") String id,
			@RequestParam(value = "password") String password, HttpSession session) {
		System.out.println("sample");
		log.debug("Start of login method");
		
		ModelAndView mv = new ModelAndView("/index" ,"command",new User());
		user = userDao.isValidUser(id, password);
		

		if (user != null) {
			log.debug("Valid credentials");

            log.debug("User "+user.getRole());
            if (user.getRole()==1) {
				log.debug("Logged in as admin");

				mv.addObject("isAdmin", "true");

				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDao.list());

				session.setAttribute("category", category);
				session.setAttribute("categoryList", categoryDao.list());
				mv.addObject("categoryList", categoryDao.list());
				mv.addObject("supplierList", supplierDao.list());
			} else {
				log.debug("Logged in as user");

				mv.addObject("isAdmin", "false");
				session.setAttribute("category", category);
				session.setAttribute("categoryList", categoryDao.list());
				session.setAttribute("product", product);
				session.setAttribute("productList", productDao.list());
				
				mv.addObject("categoryList", categoryDao.list());
				mv.addObject("productList", productDao.list());
				
				/*cart = cartDAO.get(id);
				mv.addObject("cart", cart);
				List<Cart> cartList = cartDAO.list(id);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());*/

			}} else {
			log.debug("Invalid credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "invalidCredentials");

		}
		log.debug("end of login");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.debug("start of logout method");
		ModelAndView mv = new ModelAndView("/index");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDao.list());

		mv.addObject("logoutMesssage", "Succesfully logged out");
		mv.addObject("loggedOut", "true");
		log.debug("end of log method");

		return mv;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		log.debug("Start of register method");
			user.setRole(0);
			//user.setId(101);
			System.out.println("User "+user.getId());
			userDao.saveOrUpdate(user);
			log.debug("Succesfully registered");
			ModelAndView mv = new ModelAndView("/index","command",new User());
			mv.addObject("successMessage", "Successfully registered");
		log.debug("End of register method");
		return mv;
	}
	
	
	
}
