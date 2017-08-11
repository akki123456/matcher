package com.swipejobs.matcher.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.swipejobs.matcher.model.Job;

@Repository("jobRepository")
public class CachedJobRepository implements JobRepository {
	
	

	@Value("${matcher.jobsApi.url}")
	String jobApiUrl;
	
	public String getJobApiUrl() {
		return jobApiUrl;
	}


	public void setJobApiUrl(String jobApiUrl) {
		this.jobApiUrl = jobApiUrl;
	}

	Map<String, Job> jobMap = new HashMap<String, Job>();
	
	private void populateJobMap(){
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Job>> responseType = 
				new ParameterizedTypeReference<List<Job>>() {};
		ResponseEntity<List<Job>> resp = restTemplate.
				exchange(jobApiUrl, HttpMethod.GET, null, responseType);
		List<Job> jobs = resp.getBody();
		for(Job job : jobs){
			jobMap.put(job.getJobId(), job);
		}
	}

	
	public List<Job> getAllJobs() {
		if(jobMap.isEmpty()) populateJobMap();
		return new ArrayList<Job>(jobMap.values());
	}

	public static void main(String args[]){
		CachedJobRepository cjr = new CachedJobRepository();
		List<Job> jj = cjr.getAllJobs();
		
		for(Job j : jj){
			System.out.println(j.getLocation()+";;;"+ j.getLatitude());
			System.out.println(j.getBillRate());
			System.out.println(j.getBillRateInDollars());
			//System.out.println(j.getRequiredCertificates());
		}
		
	
	}
}
