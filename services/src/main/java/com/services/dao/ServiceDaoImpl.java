package com.services.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.services.exception.ResourceNotFoundException;
import com.services.model.Category;
import com.services.model.Services;
import com.services.repository.CategoryRepository;
import com.services.repository.ServicesRepository;

@Component
@Qualifier("ServiceDao")
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	public ServicesRepository servicesrepository;

	@Autowired
	public CategoryRepository categoryrepository;

	/**
	 * show all category
	 */
	public List<Category> readAllCategory() {
		return categoryrepository.findAll();

	}

	public Category addCategory(@Valid Category categoryname) {
		return categoryrepository.save(categoryname);
	}

	public List<Services> updateCategory(@PathVariable(value = "categoryid") long categoryid,
			@Valid @RequestBody Category categorydetails) throws ResourceNotFoundException {
		Category cg = categoryrepository.findById(categoryid)
				.orElseThrow(() -> new ResourceNotFoundException("categoryid not found on : " + categoryid));
		cg.setServiceCategoryName(categorydetails.getServiceCategoryName());
		final Services updatedServices = servicesrepository.save(cg);
		return categoryrepository.ok(updatedServices);

	}

	public List<?> deleteCategory(@PathVariable(value = "categoryid") long categoryid) throws Exception {
		Category category = categoryrepository.findById(categoryid)
				.orElseThrow(() -> new ResourceNotFoundException(" customer not found  on : " + categoryid));
		return categoryrepository.deleteByCategoryId(categoryid);
	}

	public List<Services> readAllService(@PathVariable(value = "categoryid") long categoryid) {
		return servicesrepository.findByCategoryId(categoryid);
	}

	public Services addService(@PathVariable(value = "categoryid") long categoryid,
			@Valid @RequestBody Services service) throws ResourceNotFoundException {
		return categoryrepository.findById(categoryid).map(category -> {
			service.setCategory(category);
			return servicesrepository.save(service);
		}).orElseThrow(() -> new ResourceNotFoundException("category  " + categoryid + " not found"));

	}

	public List<Services> updateService(@PathVariable(value = "categoryid") long categoryid,
			@PathVariable(value = "serviceid") long serviceid, @Valid @RequestBody Services service)
			throws ResourceNotFoundException {

		if (!categoryrepository.existsById(categoryid)) {
			throw new ResourceNotFoundException("category  " + categoryid + " not found");
		}
		Services sg = servicesrepository.findById(serviceid)
				.orElseThrow(() -> new ResourceNotFoundException("services not found on : " + serviceid));

		sg.setServiceDuration(service.getServiceDuration());
		sg.setServiceName(service.getServiceName());
		sg.setServiceCost(service.getServiceCost());
		sg.setAdditionalCharge(service.getAdditionalCharge());
		sg.setServiceDetails(service.getServiceDetails());

		final Services updatedServices = servicesrepository.save(sg);
		return categoryrepository.ok(updatedServices);
	}

	public List<?> deleteService(@PathVariable(value = "serviceid") long serviceid)
			throws ResourceNotFoundException {
		Services service = servicesrepository.findById(serviceid)
				.orElseThrow(() -> new ResourceNotFoundException(" service not found  on : " + serviceid));
		
		return servicesrepository.deleteByserviceId(serviceid);
	}

}
