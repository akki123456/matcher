package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public class CertificateScoreCalculator extends ScoreCalculator{

	public CertificateScoreCalculator(int maxScore) {
		super(maxScore);
	}

	@Override
	public void addScore(JobForWorker job) {
		int score = job.getScore()+
				calculateScore(job.getNumberofMatchedCertificates());
		job.setScore(score);
		
	}

	@Override
	public void populateScoreHelpersByTraversing(List<JobForWorker> jobs) {
		int minValue=(int) (jobs.get(0).getNumberofMatchedCertificates());
		int maxValue=(int) (jobs.get(0).getNumberofMatchedCertificates());
		for(JobForWorker job: jobs){
			int value = (int) (job.getNumberofMatchedCertificates());
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
