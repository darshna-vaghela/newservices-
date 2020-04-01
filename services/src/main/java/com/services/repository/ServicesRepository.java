package com.services.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.services.model.Category;
import com.services.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>, ServicesRepositoryCustom {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM serviceitem WHERE serviceid = ?1", nativeQuery = true)
	List<?> deleteByserviceId(@Param("serviceid") long serviceid);

	@Query(value = "SELECT * FROM serviceitem WHERE serviceid = ?1 AND category_id = ?2", nativeQuery = true)
	Optional<Services> findByIdAndCategoryId(@Param("serviceid") long serviceid, @Param("category_id") long categoryid);

	Services save(Category cg);


}
