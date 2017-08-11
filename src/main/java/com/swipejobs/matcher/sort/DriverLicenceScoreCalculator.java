package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public class DriverLicenceScoreCalculator extends ScoreCalculator {

	public DriverLicenceScoreCalculator(int maxScore) {
		super(maxScore);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addScore(JobForWorker job) {
		int score = (job.isDriverLicenseRequired())?this.maxScore:0;
		 score = job.getScore()+ score;
		job.setScore(score);
		
	}

	@Override
	public void populateScoreHelpersByTraversing(List<JobForWorker> jobs) {
		// TODO Auto-generated method stub
		
	}

}
