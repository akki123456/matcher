package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public class BillRateScoreCalculator extends ScoreCalculator {

	

	public BillRateScoreCalculator(int maxScore) {
		super(maxScore);
	}

	@Override
	public void addScore(JobForWorker job) {
		int score = job.getScore()+
				calculateScore((int)job.getBillRateInDollars()*100);
		job.setScore(score);
		
	}

	@Override
	public void populateScoreHelpersByTraversing(List<JobForWorker> jobs) {
		int minValue=(int) (jobs.get(0).getBillRateInDollars()*100);
		int maxValue=(int) (jobs.get(0).getBillRateInDollars()*100);
		for(JobForWorker job: jobs){
			int value = (int) (job.getBillRateInDollars()*100);
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
