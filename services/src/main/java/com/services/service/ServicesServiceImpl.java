package com.services.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.dao.ServiceDao;
import com.services.exception.ResourceNotFoundException;
import com.services.model.Category;
import com.services.model.Services;

@Service("ServicesService")
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	public ServiceDao servicedao;

	public List<Category> readAllCategory() {
		return servicedao.readAllCategory();

	}

	public Category addCategory(@Valid Category category) {
		return servicedao.addCategory(category);
	}

	public List<Services> updateCategory(long categoryid, Category category)
			throws ResourceNotFoundException {
		return servicedao.updateCategory(categoryid, category);

	}

	public List<?> deleteCategory(long categoryid) throws Exception {
		return servicedao.deleteCategory(categoryid);

	}

	public List<Services> readAllService(long categoryid) {
		return servicedao.readAllService(categoryid);
	}

	public Services addService(long categoryid, @Valid Services services) throws ResourceNotFoundException {
		return servicedao.addService(categoryid, services);

	}

	public List<Services> updateService(long categoryid, long serviceid, Services service)
			throws ResourceNotFoundException {
		return servicedao.updateService(categoryid, serviceid, service);

	}

	public List<?> deleteService(long serviceid) throws ResourceNotFoundException {
		return servicedao.deleteService(serviceid);

	}

}
