package com.swipejobs.matcher.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swipejobs.matcher.model.JobForWorker;

public class ScoreChain {

	
private List<ScoreCalculator> scoreChain ;
	
	@Autowired
	public void setScoreChain(List<ScoreCalculator> scoreChain) {
	      this.scoreChain = scoreChain;
	  }
	
	public void calculateTotalScore(JobForWorker job){	
		for(ScoreCalculator scoreCalc  : scoreChain){
			scoreCalc.addScore(job);
		}
	}
	public void populateScoreHelpers(List<JobForWorker> jobs){
		for(ScoreCalculator scoreCalc  : scoreChain){
			scoreCalc.populateScoreHelpersByTraversing(jobs);
		}
	}
	
}
