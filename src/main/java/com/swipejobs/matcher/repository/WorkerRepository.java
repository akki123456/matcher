package com.swipejobs.matcher.repository;

import com.swipejobs.matcher.model.Worker;

public interface WorkerRepository {

	
	public Worker getWorkerById(String workerId);
}
