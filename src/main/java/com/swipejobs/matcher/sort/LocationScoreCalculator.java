package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public class LocationScoreCalculator extends ScoreCalculator{

	public LocationScoreCalculator(int maxScore) {
		super(maxScore);
	}

	@Override
	public void addScore(JobForWorker job) {
		int score = job.getScore()+
				calculateScore(job.getDistanceInKm());
		job.setScore(score);
		
	}

	@Override
	public void populateScoreHelpersByTraversing(List<JobForWorker> jobs) {
		int minValue= (jobs.get(0).getDistanceInKm());
		int maxValue= (jobs.get(0).getDistanceInKm());
		for(JobForWorker job: jobs){
			int value =  (job.getDistanceInKm());
			if(value>maxValue){
				maxValue = value;
			}
			if(value<minValue){
				minValue = value;
			}
			

	}
		populateScoreHelper(maxScore, minValue, maxValue);
	}
}
