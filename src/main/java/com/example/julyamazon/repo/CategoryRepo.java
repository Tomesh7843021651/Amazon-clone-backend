package com.example.julyamazon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.julyamazon.model.Category;
import com.example.julyamazon.projection.CategoryUi;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	@Query(value="select c.id,c.name,user.name as addedBy from julyamazon.category c join julyamazon.user  on c.userid=user.id;" ,nativeQuery = true)
	List<CategoryUi>GetAllCategoryByUserId();
}
