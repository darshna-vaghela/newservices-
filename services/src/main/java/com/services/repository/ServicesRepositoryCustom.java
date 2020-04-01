package com.services.repository;

import java.util.List;

import com.services.model.Services;

public interface ServicesRepositoryCustom {
	
	List<Services> findByCategoryId(long categoryid);

}
