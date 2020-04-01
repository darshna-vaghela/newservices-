package com.services.service;

import java.util.List;

import javax.validation.Valid;

import com.services.exception.ResourceNotFoundException;
import com.services.model.Category;
import com.services.model.Services;

public interface ServicesService {

	public List<Category> readAllCategory();

	public List<Services> updateCategory(long categoryid, Category category) throws ResourceNotFoundException;

	public List<?> deleteCategory(long categoryid) throws Exception;

	public List<Services> readAllService(long categoryid);

	public Services addService(long categoryid, @Valid Services services) throws ResourceNotFoundException;

	public List<Services> updateService(long categoryid, long serviceid, Services service) throws ResourceNotFoundException;

	public List<?> deleteService(long serviceid) throws ResourceNotFoundException;

	public Category addCategory(@Valid Category category);

}
