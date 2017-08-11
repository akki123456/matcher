package com.swipejobs.matcher.service;

import java.util.List;

import com.swipejobs.matcher.model.Job;
import com.swipejobs.matcher.model.JobForWorker;

public interface MatcherService {

	List<JobForWorker> getSortedMatchesForWorker(String workerId,int maxCount);
}
