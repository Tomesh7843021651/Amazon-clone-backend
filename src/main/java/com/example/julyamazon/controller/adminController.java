package com.example.julyamazon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.julyamazon.model.Category;
import com.example.julyamazon.projection.CategoryUi;
import com.example.julyamazon.repo.CategoryRepo;

@RestController
@CrossOrigin 
@RequestMapping("admin")
public class adminController {
	
	@Autowired
	CategoryRepo categoryRepo;
	
//	@RequestMapping("getAllCategories")
//	public List<Category> getAllCatgories(){
//		return categoryRepo.findAll();
//	}
	
	 @RequestMapping("getAllCategories")

     public List<CategoryUi> getAllCategories()

     {
		 List<CategoryUi> test=categoryRepo.GetAllCategoryByUserId();
		 System.out.println(test);

                  return categoryRepo.GetAllCategoryByUserId();

     }
	
	@RequestMapping("addNewCategory{userid}")
	public Category addNewCategory(@PathVariable int userid,@RequestBody String name) {
		Category c = new Category();
		c.setDate(new Date());
		c.setName(name);
		c.setUserid(userid);
		return categoryRepo.save(c);
	}
	
	
	

}
