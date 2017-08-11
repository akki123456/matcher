package com.swipejobs.matcher.model;

import java.util.List;

public class Worker {

	String userId;
	String guid;
	String age;
	Name name;
	String email;
	String phone;
	Availability[] availability;
	boolean hasDriverLicence;
	String transportation;
	JobSearchLoc jobSearchAddress;
	String[] skills;
	List<String> certificates;
	boolean isActive;
	int rating;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Availability[] getAvailability() {
		return availability;
	}
	public void setAvailability(Availability[] availability) {
		this.availability = availability;
	}
	public boolean isHasDriverLicence() {
		return hasDriverLicence;
	}
	public void setHasDriverLicence(boolean hasDriverLicence) {
		this.hasDriverLicence = hasDriverLicence;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public JobSearchLoc getJobSearchAddress() {
		return jobSearchAddress;
	}
	public void setJobSearchAddress(JobSearchLoc jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public List<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getLongitude(){
		return jobSearchAddress.longitude;
	}
	public double getLatitude(){
		return jobSearchAddress.latitude;
	}
	public int getDistanceinKm(){
		if(jobSearchAddress.unit.equalsIgnoreCase("km")) {
			return jobSearchAddress.maxJobDistance;
		}else {
			return 0;
		}
	}
}
class Name{
	String first;
	String last;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
}
class Availability{
	String title;
	int dayIndex;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDayIndex() {
		return dayIndex;
	}
	public void setDayIndex(int dayIndex) {
		this.dayIndex = dayIndex;
	}
}
class JobSearchLoc{
	String unit;
	int maxJobDistance;
	double longitude;
	double latitude;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getMaxJobDistance() {
		return maxJobDistance;
	}
	public void setMaxJobDistance(int maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}
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
		sb.append("unit=").append(unit).append(";")
		.append("maxJobDistance=").append(maxJobDistance).append(";")
		.append("longitude=").append(longitude).append(";")
		.append("latitude=").append(latitude);
		
		return sb.toString();
	}
}

