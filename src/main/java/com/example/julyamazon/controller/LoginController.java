package com.example.julyamazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.julyamazon.model.LoginReturn;
import com.example.julyamazon.model.User;
import com.example.julyamazon.repo.UserRepo;

@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("getName{id}")
	public String[] getName(@PathVariable int id ) {
		User user = userRepo.findById(id).get();
		String [] sa = new String[1];
		sa[0] =user.getName();
		return sa;
	}
	
	@RequestMapping("log")
	public LoginReturn login(@RequestBody String[] sa) {
		
		if(sa == null) {
			return new LoginReturn(-1,-1,"currupt Data");
		}
		String username = sa[0];
		if(username == null || username.length()<1) {
			return new LoginReturn(-1,-1,"Enter Username");
		}
		String password = sa[1];
		if(password == null || password.length()<1) {
			return new LoginReturn(-1,-1,"Enter Password");
		}
		int count = userRepo.countByUsername(username);
		
		if(count ==0) {
			return new LoginReturn(-1,-1,"UserNameWrong");
		}
		
		if(count >1) {
			return new LoginReturn(-1,-1,"something is wrong with Username");
		}
		
		User user = userRepo.findByUsername(username);
		if(user.getPassword().equals(password)) {
			return new LoginReturn(user.getId(), user.getAccountType(), null);
		}
		else {
			return new LoginReturn(-1,-1,"PasswordWrong");
		}
	}
	
	@RequestMapping("register")
	public int login(@RequestBody User user) {
		if(user==null) {
			return 0;
		}
		String username=user.getUsername();
		if (username==null || username.length()<1) {
			return 1;
		}
		String password=user.getPassword();
		if (password==null || password.length()<1) {
			return 2;
		}
		
		int count = userRepo.countByUsername(username);
		
		if (count==0) {
			userRepo.save(user);
			return 4;
		}else {
			return  3;
		}

	}


}
