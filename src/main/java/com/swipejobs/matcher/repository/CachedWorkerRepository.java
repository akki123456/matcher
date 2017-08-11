package com.swipejobs.matcher.repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.swipejobs.matcher.model.Worker;

@Repository("workerRepository")
public class CachedWorkerRepository implements WorkerRepository {

	@Value("${matcher.workersApi.url}")
	String workerApiUrl;
	
	public String getWorkerApiUrl() {
		return workerApiUrl;
	}


	public void setWorkerApiUrl(String workerApiUrl) {
		this.workerApiUrl = workerApiUrl;
	}

	Map<String, Worker> workerMap = new HashMap<String, Worker>();
	
	public Worker getWorkerById(String workerId) {
		if(workerMap.isEmpty())
			populateWorkerMap();
		return workerMap.get(workerId);	
	}

	
	private void populateWorkerMap(){
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Worker>> responseType = 
				new ParameterizedTypeReference<List<Worker>>() {};
		ResponseEntity<List<Worker>> resp = restTemplate.
				exchange(workerApiUrl, HttpMethod.GET, null, responseType);
		List<Worker> workers = resp.getBody();
		for(Worker worker : workers){
			workerMap.put(worker.getUserId(), worker);
		}
	}
	
	public static void main(String args[]){
		CachedWorkerRepository cwr = new CachedWorkerRepository();
		cwr.populateWorkerMap();
	}
}
