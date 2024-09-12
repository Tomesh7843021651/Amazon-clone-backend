package com.example.julyamazon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.julyamazon.model.Cart;
import com.example.julyamazon.projection.CartProduct;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	int countByProductidAndUserid(int userid, int productid);
	
	
	@Query(value="select c.id,p.name,p.price,p.quantity,p.description,p.discount,p.rating from julyamazon.product as p join julyamazon.cart as c on c.productid=p.id where c.userid=:userid", nativeQuery = true)
	List<CartProduct> findCartProductByUserId(@Param("userid") int id);

}
