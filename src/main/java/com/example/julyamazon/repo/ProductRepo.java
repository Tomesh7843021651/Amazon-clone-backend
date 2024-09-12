package com.example.julyamazon.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.julyamazon.model.Product;
import com.example.julyamazon.projection.ProductUI;
import com.example.julyamazon.projection.ProductUIBuyer;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByUserid(int userid);
	
	/*//NativeQuery
	@Query(value = "select email from patient_details where name=:name" , nativeQuery=true)
	public List<String> namePatient(@Param("name") String name);*/
	
	@Query(value = "SELECT p.id,p.name,p.description,p.price,p.quantity,p.rating,p.discount,c.name as catName FROM julyamazon.product p join julyamazon.category c on p.categoryid = c.id where p.userid = ?1;", nativeQuery = true)
	List<ProductUI> getCatNameById(int userid);
	
	@Query(value = "SELECT id,p.name,p.price,p.rating,p.discount,p.description,p.quantity, datediff(now(),date) as days FROM julyamazon.product as p where categoryid=?1 and price >?2 and price < ?3 and rating >= ?4;",nativeQuery = true)
	List<ProductUIBuyer> getProductByFilter(int categoryid, int minprice, int maxprice, int minrating);

}
