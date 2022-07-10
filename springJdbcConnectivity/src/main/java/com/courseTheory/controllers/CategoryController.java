package com.courseTheory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courseTheory.models.Category;
import com.courseTheory.models.User;
import com.courseTheory.services.CategoryService;


@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	

    // Create Category Handler
	@RequestMapping(value="/create-category",method=RequestMethod.POST)
	public Category createCategory(@RequestBody Category category) {
		
		return this.categoryService.createCategory(category);
	}
	
	
	// Update Category Handler
	@RequestMapping(value="/update-category",method= RequestMethod.POST)
	public void updateCategory(Category category, int cid) {
		
		categoryService.updateCategory(category, cid);
	}
	
	
	
	// Delete by ID Category Handler
	@RequestMapping(value="/delete-categoryById",method=RequestMethod.DELETE)
	public void deleteCategory(@RequestParam int cid) {
		
		categoryService.deleteCategory(cid);
	}
	
	
	// Delete All Category Handler
	@RequestMapping(value="/delete-category",method=RequestMethod.DELETE)
	public void deleteCategory() {
		categoryService.deleteAll();
	}
	
	
	//Get Single Category Handler
	@RequestMapping(value="get-categoryById",method=RequestMethod.GET)
	public Category getCategory( int cid) {
		Category c = categoryService.getCategory(cid);
		return c;
	}
	
	
	// Get all Category Handler
	@RequestMapping(value="/get-category",method=RequestMethod.GET)
	public List<Category> getCategory(){
		
		
		List<Category> allcategory = categoryService.getAllCategory();
		return allcategory;
		
		
	}

}
