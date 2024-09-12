package com.example.julyamazon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.julyamazon.model.Cart;
import com.example.julyamazon.model.MyOrder;
import com.example.julyamazon.model.OrderProduct;
import com.example.julyamazon.model.Product;
import com.example.julyamazon.model.Ratings;
import com.example.julyamazon.projection.BuyerHistory;
import com.example.julyamazon.projection.CartProduct;
//import com.example.julyamazon.projection.ProductUI;
import com.example.julyamazon.projection.ProductUIBuyer;
import com.example.julyamazon.repo.CartRepo;
import com.example.julyamazon.repo.MyOrderRepo;
import com.example.julyamazon.repo.OrderProductRepo;
import com.example.julyamazon.repo.ProductRepo;
import com.example.julyamazon.repo.RatingRepo;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("buyer")
public class BuyerController {
	
	@Autowired 
	ProductRepo productRepo;
	
	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	OrderProductRepo orderProductRepo;

	@Autowired
	MyOrderRepo myOrderRepo;
	
	@RequestMapping("getProductsByFilter")
	public List<ProductUIBuyer> getProductByFilter(@RequestBody int[] a){
		System.out.println(a[0]+" "+ a[1] +" "+a[2]+" "+a[3]+" ");
		return productRepo.getProductByFilter(a[0], a[1], a[2], a[3]);
	}
	
	@RequestMapping("addRating")
	public int countByUseridAndProductId(@RequestBody int[] a) {
	try {	
		int userid = a[0];
		int productid = a[1];
		int stars =a[2];
		System.out.println(a[1]);
		int count = ratingRepo.countByUseridAndProductId(userid, productid);
		
		if(count ==1) {
			Ratings rev = ratingRepo.findByProductidAndUserid(userid, productid);
			rev.setStars(stars);
			rev.setDate(new Date());
			ratingRepo.save(rev);
		}
		
		else if(count ==0) {
			Ratings r = new Ratings();
			r.setDate(new Date());
			r.setUserid(userid);
			r.setProductid(productid);
			r.setStars(stars);
			ratingRepo.save(r);
		}
		else {
			return 0;
		}
		
		double avg = ratingRepo.getAvgRatingByProductid(productid);
		Product product  = productRepo.findById(productid).get();
		product.setRating(avg);
		productRepo.save(product);
		
		return 1;
	}
	catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
	}
	
	@RequestMapping("addToCart{userid}and{productid}")
	public int addToCart(@PathVariable int userid, @PathVariable int productid) {
		
		try {
			int count = cartRepo.countByProductidAndUserid(userid, productid);
			if(count  ==0) {
				Cart cart = new Cart();
				cart.setProductid(productid);
				cart.setUserid(userid);
				cartRepo.save(cart);
				return 1;
			}
			else {
				return 0;
			}
			
		}
		catch(Exception e) {
			e.getStackTrace();
			return 0;
		}
	}
	@RequestMapping("getCart/{id}")
	public List<CartProduct> getCartProduct(@PathVariable int id){
		return cartRepo.findCartProductByUserId(id);
	}
	
	@RequestMapping("placeOrder/{id}")
	public int placeOrder(@PathVariable int id,@RequestBody int[][] a) {
		try {
			MyOrder order = new MyOrder();
			order.setDate(new Date());
			order.setUserid(id);
			myOrderRepo.save(order);
			
			double totalAmount = 0;
			
			for(int i=0 ; i < a.length ; i++) {
				int[] a1 = a[i];
				int cartid = a1[0];
				int quantity = a1[1];
				Cart cart = cartRepo.findById(cartid).get();
				
				int productid = cart.getProductid();
				Product product = productRepo.findById(productid).get();
				OrderProduct obj = new OrderProduct();
				
				double amount = product.getPrice()*quantity;
				
				amount = amount - (amount*product.getDiscount()/100);
				obj.setAmount(amount);
				totalAmount += amount;
				
				obj.setDate(new Date());
				obj.setProductid(productid);
				obj.setMyorderid(order.getId());
				obj.setQuantity(quantity);
				
				orderProductRepo.save(obj);
				
				cartRepo.delete(cart);
			}
			
			order.setAmount(totalAmount);
			myOrderRepo.save(order);
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
			
		}
	}
	
	@RequestMapping("history/{id}")
	public List<BuyerHistory> historyProduct(@PathVariable int id){
		return orderProductRepo.getProductHistory(id);
	}

}
