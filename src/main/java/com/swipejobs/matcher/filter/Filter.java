package com.swipejobs.matcher.filter;

import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.model.Worker;

public interface Filter {

	/*
	 * return job with additional fields calculated for
	 *  filtering but to be used later for sorting
	 *  returns null if the worker does not meet the requirement. 
	 */
	
	JobForWorker filter(Worker worker, JobForWorker job);
}
