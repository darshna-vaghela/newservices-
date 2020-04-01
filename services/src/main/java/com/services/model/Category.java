package com.services.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "servicedata")
public class Category implements Serializable {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "categoryid")
	private long categoryid;

	@Column(name = "service_category_name", nullable = false)
	private String serviceCategoryName;

	@Column(name = "service_category_id", nullable = false)
	private String serviceCategoryId;

	@OneToMany(targetEntity=Services.class,mappedBy = "serviceId",fetch = FetchType.LAZY)
	@JoinColumn(name="frn_serviceid",referencedColumnName = "serviceId")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<Services> services;

	public Category() {
		super();
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getServiceCategoryName() {
		return serviceCategoryName;
	}

	public void setServiceCategoryName(String serviceCategoryName) {
		this.serviceCategoryName = serviceCategoryName;
	}

	public String getServiceCategoryId() {
		return serviceCategoryId;
	}

	public void setServiceCategoryId(String serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public Category(long categoryid, String serviceCategoryName, String serviceCategoryId, List<Services> services) {
		super();
		this.categoryid = categoryid;
		this.serviceCategoryName = serviceCategoryName;
		this.serviceCategoryId = serviceCategoryId;
		this.services = services;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", serviceCategoryName=" + serviceCategoryName
				+ ", serviceCategoryId=" + serviceCategoryId + ", services=" + services + "]";
	}

	
}
