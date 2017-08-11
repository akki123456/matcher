package com.swipejobs.matcher.model;

import java.util.Date;
import java.util.List;

public class Job {

	String jobId;
	String jobTitle;
	String guid;
	int workersRequired;
	Location location;  
	List<String> requiredCertificates;
	boolean driverLicenseRequired;
	Date startDate;
	String about;
	String company;
	String billRate;
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getWorkersRequired() {
		return workersRequired;
	}
	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}
	public float getBillRateInDollars() {
		float billRateInDollars = Float.parseFloat(billRate.substring(1));
		return billRateInDollars;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<String> getRequiredCertificates() {
		return requiredCertificates;
	}
	public void setRequiredCertificates(List<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}
	public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}
	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public double getLatitude(){
		return location.latitude;
	}
	public double getLongitude(){
		return location.longitude;
	}
}
class Location{
	double longitude;
	double latitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("longitude=").append(longitude).append(";")
		.append("latitude=").append(latitude);
		return sb.toString();
	}
}
