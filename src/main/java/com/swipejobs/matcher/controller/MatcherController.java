package com.swipejobs.matcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.service.MatcherService;

@RestController
public class MatcherController {

	@Autowired
	MatcherService matcherService;
	
	@Value("${matcher.maxResultCount:3}")
	int maxResultCount;
	
	 public int getMaxResultCount() {
		return maxResultCount;
	}

	public void setMaxResultCount(int maxResultCount) {
		this.maxResultCount = maxResultCount;
	}

	@RequestMapping(value="/matches/{workerId}", method= RequestMethod.GET,produces="application/json" )
	    public List<JobForWorker> getMatches(@PathVariable("workerId") 
	    String workerId)   {
	    	return matcherService.getSortedMatchesForWorker(workerId, maxResultCount);
		 
	    }
	
	
}
