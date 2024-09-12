package com.example.julyamazon.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.julyamazon.model.OrderProduct;
import com.example.julyamazon.projection.BuyerHistory;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
	@Query(value = "SELECT o.id,p.name,p.description,p.price,p.discount,o.quantity,o.amount as total,p.id as productid FROM julyamazon.order_product as o join julyamazon.my_order as m on o.myorderid=m.id join julyamazon.product as p on p.id=o.productid where m.userid=:userid;", nativeQuery = true)
	public List<BuyerHistory> getProductHistory(@Param("userid") int userid);

}
