package com.niit.shoppingCart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDao;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private Category category;
	
	/*@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Start of method to list the categories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDao.list());
		model.addAttribute("adminClickedCategory", "true");
		log.debug("End of method to list the categories");
		return "/index";
	}*/

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		log.debug("Start of method add category");
		
		if (categoryDao.addOrUpdate(category) == true) {
			model.addAttribute("messgae", "Successfully created or updated the category");
		} else {
			model.addAttribute("message", "not able to add/update the category");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDao.list());
		model.addAttribute("adminClickedCategory", "true");
		log.debug("End of method add category");
		return "redirect:./";
	}
	
	@RequestMapping("deletecategory/{id}" )
	public String deleteCategory(@PathVariable("id") String id, Model model)throws Exception{
		log.debug("start of method delete category");
		boolean flag=categoryDao.delete(category);
		String msg="Successfully deleted";
		if(flag!=true)
			msg="Failure of delete";
		model.addAttribute("msg",msg);
		
		log.debug("End of method delete category");
		return "forward:/";
	}
	
	@RequestMapping("updatecategory/{id}" )
	public String updateCategory(@PathVariable("id") int id, Model model)throws Exception{
		log.debug("start of method delete category");
		category=categoryDao.get(id);
		model.addAttribute("category", category);
		log.debug("End of method update category");
		return "forward:/";
	}
	
}