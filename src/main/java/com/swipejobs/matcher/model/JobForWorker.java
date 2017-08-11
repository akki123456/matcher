package com.swipejobs.matcher.model;

import java.util.ArrayList;
import java.util.List;

public class JobForWorker extends Job{
	public JobForWorker(Job job) {
		this.jobId = job.jobId;
		this.jobTitle = job.jobTitle;
		this.guid = job.guid;
		this.workersRequired = job.workersRequired;
		this.location = job.location;
		this.requiredCertificates = job.requiredCertificates;
		this.driverLicenseRequired = job.driverLicenseRequired;
		this.startDate = job.startDate;
		this.about = job.about;
		this.company = job.company;	
		this.billRate= job.billRate;
		//default values 
		this.distanceInKm =-1;
		this.matchedCertificates = new ArrayList<String>();
	}
	int distanceInKm;
	List<String> matchedCertificates;
	int score=0;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(int distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public List<String> getMatchedCertificates() {
		return matchedCertificates;
	}
	public void setMatchedCertificates(List<String> matchedCertificates) {
		this.matchedCertificates = matchedCertificates;
	}
	
	public int getNumberofMatchedCertificates(){
		return matchedCertificates.size();
	}
	
}
