package com.swipejobs.matcher.filter;

import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.model.Worker;

public class DriverLicenseFilter implements Filter{

	public JobForWorker filter(Worker worker, JobForWorker job) {
		if(!job.isDriverLicenseRequired()||worker.isHasDriverLicence()) return job;
		return null;
	}

}
