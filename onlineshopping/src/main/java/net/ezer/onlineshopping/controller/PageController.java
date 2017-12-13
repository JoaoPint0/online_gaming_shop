package net.ezer.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ezer.shoppingbackend.dao.CategoryDAO;
import net.ezer.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		
		mv.addObject("categories",categoryDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = {"/contacts"})
	public ModelAndView contacts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContacts",true);
		return mv;
	}
	
	/* Methods to load products and categories*/
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView allProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("userClickAllProducts",true);
		
		mv.addObject("categories",categoryDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView categoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		category = categoryDAO.get(id);
	
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/product/{productId}"})
	public ModelAndView categoryProducts(@PathVariable("id") int id, @PathVariable("productId") int productId) {
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		category = categoryDAO.get(id);
	
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickSingleProduct",true);
		return mv;
	}
	

	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting) {
		if(greeting==null) greeting = "hello world";
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}*/
	
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting) {
		if(greeting==null) greeting = "hello world";
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}*/
}
