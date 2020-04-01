package com.services.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.services.model.Services;


@Repository
@Transactional(readOnly = true)
public class ServicesRepositoryImpl implements ServicesRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Services> findByCategoryId(long categoryid) {
		Query query = entityManager.createNativeQuery("SELECT em.* FROM serviceitem as em " +
                "WHERE em.category_id LIKE ?", Services.class);
        query.setParameter(1, categoryid + "%");
        
        
        return query.getResultList();
	}

}
