package com.services.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.services.exception.ResourceNotFoundException;
import com.services.model.Category;
import com.services.model.Services;
import com.services.service.ServicesService;

@Component
public class ServiceBusiness {

	@Autowired
	public ServicesService serviceservice;

	public List<Category> readAllCategory() {
		return serviceservice.readAllCategory();
	}

	public List<Services> updateCategory(long categoryid, Category category) throws ResourceNotFoundException {
		return serviceservice.updateCategory(categoryid, category);
	}

	public List<?> deleteCategory(long categoryid) throws Exception {
		return serviceservice.deleteCategory(categoryid);

	}

	public List<Services> readAllService(long categoryid) {
		return serviceservice.readAllService(categoryid);

	}

	public Services addService(long categoryid, @Valid Services service) throws ResourceNotFoundException {
		return serviceservice.addService(categoryid, service);

	}

	public List<Services> updateService(long categoryid, long serviceid, Services service)
			throws ResourceNotFoundException {
		return serviceservice.updateService(categoryid, serviceid, service);

	}

	public List<?> deleteService(long serviceid) throws ResourceNotFoundException {
		return serviceservice.deleteService(serviceid);

	}

	public Category addCategory(@Valid Category category) {
		return serviceservice.addCategory(category);
	}
}
