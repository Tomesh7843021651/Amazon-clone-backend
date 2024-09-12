package com.example.julyamazon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.julyamazon.model.Product;
import com.example.julyamazon.projection.ProductUI;
import com.example.julyamazon.repo.ProductRepo;

@RestController
@CrossOrigin
@RequestMapping("seller")
public class ProductController {
	@Autowired
	ProductRepo productRepo;
	
	@RequestMapping("getAllProducts{userid}")
	public List<ProductUI> getAllProducts(@PathVariable int userid){
		//System.out.println(productRepo.findByUserid(userid));
		List<ProductUI> test1=productRepo.getCatNameById(userid);
		System.out.println(test1);
		return productRepo.getCatNameById(userid);
	}
	
	@RequestMapping("addNewProduct")
	public Product addNewProduct(@RequestBody Product obj) {
		obj.setDate(new Date());
		return productRepo.save(obj);
	}

}
