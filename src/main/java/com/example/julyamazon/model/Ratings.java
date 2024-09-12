package com.example.julyamazon.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
public class Ratings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int userid;
	
	int productid;
	int stars;
	Date date;
	

}
