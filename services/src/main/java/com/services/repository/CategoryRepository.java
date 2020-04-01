package com.services.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.services.model.Category;
import com.services.model.Services;

@Repository
public interface CategoryRepository 
extends JpaRepository<Category, Long>{

	Category save(@Valid String categoryname);
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM categories WHERE categoryid = ?1", nativeQuery = true)
	List<?> deleteByCategoryId(@Param("categoryid") long categoryid);
	List<Services> ok(Services updatedServices);	

}
