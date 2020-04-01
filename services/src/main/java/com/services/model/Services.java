package com.services.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "services")
@Access(value = AccessType.FIELD)
@EntityListeners(AuditingEntityListener.class)
public class Services {

	/*
	 * @Id
	 * 
	 * @Column(name = "categoryid", unique = true, nullable = false)
	 * 
	 * @GeneratedValue(generator = "gen")
	 * 
	 * @GenericGenerator(name = "gen", strategy = "foreign", parameters = {
	 * 
	 * @Parameter(name = "property", value = "service") }) private long serviceId;
	 */	
	@Id
	@JsonIgnore 
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long serviceId;
	

	@Column(name = "service_duration", nullable = false)
	private int serviceDuration;

	@Column(name = "service_name", nullable = false)
	private String serviceName;
	
	

	@Column(name = "service_cost", nullable = false)
	private double serviceCost;

	@Column(name = "additional_charge", nullable = false)
	private double additionalCharge;

	@Column(name = "service_details", nullable = false)
	private String serviceDetails;

	//@PrimaryKeyJoinColumn
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "frn_categoryid",referencedColumnName = "categoryid")
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Category category;

	public Services() {
		super();
	}

	public Services(long serviceId, int serviceDuration, String serviceName, double serviceCost,
			double additionalCharge, String serviceDetails, Category category) {
		super();
		this.serviceId = serviceId;
		this.serviceDuration = serviceDuration;
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
		this.additionalCharge = additionalCharge;
		this.serviceDetails = serviceDetails;
		this.category = category;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public int getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(int serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}

	public String getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceDuration=" + serviceDuration + ", serviceName="
				+ serviceName + ", serviceCost=" + serviceCost + ", additionalCharge=" + additionalCharge
				+ ", serviceDetails=" + serviceDetails + ", category=" + category + "]";
	}

	
	
}
