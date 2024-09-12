package com.example.julyamazon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.julyamazon.model.Ratings;

public interface RatingRepo extends JpaRepository<Ratings, Integer>{
	
	@Query(value = "select * from julyamazon.ratings where userid =?1 and productid =?2;", nativeQuery = true)
	Ratings findByProductidAndUserid(int userid, int productid );
	
	@Query(value = "select count(*) from julyamazon.ratings where userid =?1 and productid =?2;", nativeQuery = true)
	int countByUseridAndProductId(int userid, int productid);
	
	@Query(value = "select avg(stars) from julyamazon.ratings where productid = ?1;", nativeQuery = true)
	double getAvgRatingByProductid(int productid);
	
	

}
