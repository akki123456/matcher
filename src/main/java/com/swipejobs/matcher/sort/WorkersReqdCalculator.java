package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public class WorkersReqdCalculator extends ScoreCalculator{

	public WorkersReqdCalculator(int maxScore) {
		super(maxScore);
	}

	@Override
	public void addScore(JobForWorker job) {
		int score = job.getScore()+
				calculateScore(job.getWorkersRequired());
		job.setScore(score);
		
	}

	@Override
	public void populateScoreHelpersByTraversing(List<JobForWorker> jobs) {
		int minValue=(jobs.get(0).getWorkersRequired());
		int maxValue=(jobs.get(0).getWorkersRequired());
		for(JobForWorker job: jobs){
			int value = (job.getWorkersRequired());
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
