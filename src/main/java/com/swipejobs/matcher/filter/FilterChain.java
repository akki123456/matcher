package com.swipejobs.matcher.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swipejobs.matcher.model.Job;
import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.model.Worker;

public class FilterChain {
	
	@Autowired
	public List<Filter> filters ;
	
	public void setfilterChain(List<Filter> filters) {
	      this.filters = filters;
	  }
	
	public JobForWorker filter(Worker worker,Job job){
		JobForWorker  jobforWorker = new JobForWorker(job);
		for(Filter filter  : filters){
			if(filter.filter(worker, jobforWorker)==null)
				return null;
		}
		return jobforWorker;
	}
}
