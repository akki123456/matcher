package com.swipejobs.matcher.sort;

import java.util.List;

import com.swipejobs.matcher.model.JobForWorker;

public abstract class ScoreCalculator {
	
	int maxScore=-1;
	int minValue=-1;
	int maxValue=-1;
	float slope=-1;
	
	public ScoreCalculator(int maxScore) {
		this.maxScore=maxScore;
	}
	
	public abstract void addScore(JobForWorker job);
	
       public int calculateScore(int value){
//    	   if(maxScore==-1){
//    		   populateScoreHelpersByTraversing(jobs);
//    	   }
    	   return (int) (slope*(value-minValue));
       }
       
       public void populateScoreHelper(int maxScore,int minValue, int maxValue){
    	   this.maxScore =maxScore;
   		this.maxValue=maxValue;
   		this.minValue=minValue;
   		slope = maxValue==minValue?0:(float)(maxScore ) / (maxValue - minValue);   
       }
       public abstract void populateScoreHelpersByTraversing(List<JobForWorker> jobs);
       
    	   
//       public static void main(String args[]){
//    	   int maxscore = 30; int maxValue = 1490; int minValue = 544;
//    	   
//    	   float slope = (float)maxscore / (maxValue - minValue)
//    			   ;
//    	   System.out.println(slope);
//       }
}
