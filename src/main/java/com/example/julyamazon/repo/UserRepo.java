package com.example.julyamazon.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.julyamazon.model.User;

public interface UserRepo  extends JpaRepository<User, Integer>{
	int countByUsername(String username);
	User findByUsername(String username);

}
