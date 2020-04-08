package com.timbuchalka.springdemo.domain.test;

public class OrganizationRegistration {
	
	private String orgName;
	private String country;
	private String turnover;
	private String type;
	private String serviceLength;
	private boolean registeredPreviously = true;
	private String like;
	private String[] optionalServices;
	private String[] premiumServices;
	private String overseasOperations;
	private String employeeStrength;
	

	public String getEmployeeStrength() {
		return employeeStrength;
	}

	public void setEmployeeStrength(String employeeStrength) {
		this.employeeStrength = employeeStrength;
	}

	public String getOverseasOperations() {
		return overseasOperations;
	}

	public void setOverseasOperations(String overseasOperations) {
		this.overseasOperations = overseasOperations;
	}

	public String[] getPremiumServices() {
		return premiumServices;
	}

	public void setPremiumServices(String[] premiumServices) {
		this.premiumServices = premiumServices;
	}

	public String[] getOptionalServices() {
		return optionalServices;
	}

	public void setOptionalServices(String[] optionalServices) {
		this.optionalServices = optionalServices;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public boolean isRegisteredPreviously() {
		return registeredPreviously;
	}

	public void setRegisteredPreviously(boolean registeredPreviously) {
		this.registeredPreviously = registeredPreviously;
	}

	public String getServiceLength() {
		return serviceLength;
	}

	public void setServiceLength(String serviceLength) {
		this.serviceLength = serviceLength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	

}
