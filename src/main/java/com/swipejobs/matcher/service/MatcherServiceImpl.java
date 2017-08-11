package com.swipejobs.matcher.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swipejobs.matcher.filter.FilterChain;
import com.swipejobs.matcher.model.Job;
import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.model.Worker;
import com.swipejobs.matcher.repository.JobRepository;
import com.swipejobs.matcher.repository.WorkerRepository;
import com.swipejobs.matcher.sort.ScoreChain;

@Service("matcherService")
public class MatcherServiceImpl implements MatcherService{
	
	@Autowired
	JobRepository jobRepository;
	@Autowired
	WorkerRepository workerRepository;
	
	@Autowired
	FilterChain filterChain;
	
	@Autowired
	ScoreChain scoreChain;
	

	private List<JobForWorker> getUnSortedMatchesForWorker(String workerId) {
		Worker worker = workerRepository.getWorkerById(workerId);
		List<Job> allJobs = jobRepository.getAllJobs();
		List<JobForWorker> jobsToBeSorted = new ArrayList<JobForWorker>();
		for(Job job : allJobs){
			JobForWorker jfw =filterChain.filter(worker, job);
			if(jfw!=null){
				jobsToBeSorted.add(jfw);
			}
		}
		return jobsToBeSorted;
	}
	
	
	public List<JobForWorker> getSortedMatchesForWorker(String workerId, int maxCount) {
		List<JobForWorker> jobsToBeSorted = getUnSortedMatchesForWorker(workerId);
		scoreChain.populateScoreHelpers(jobsToBeSorted);
		for(JobForWorker job : jobsToBeSorted){
			 scoreChain.calculateTotalScore(job);
		}
		Comparator<JobForWorker> comparator = Comparator.comparing(JobForWorker::getScore,
				Comparator.reverseOrder());
		
		jobsToBeSorted = jobsToBeSorted.stream().sorted(comparator).limit(maxCount)
				.collect(Collectors.toList());
		
		return jobsToBeSorted;
		
	}

	/*
	 * Sorting using following values in order
	 * 1)BillRate   Maximum first
	 * 2)MatchedCertificates  Max first (Only those jobs for which worker has all 
	 * the certificates) 
	 * 3)If worker has licence , the job needing licence will be shown 
	 * first given the other signficant values to be same
	 * 4)Location  Nearest first (Only jobs which are not more than max distance away) 
	 * 5)Workers Required More first (More chances of getting the job)
	 */


//	public List<JobForWorker> getSortedMatchesForWorker(String workerId, int maxCount) {
//		List<JobForWorker> jobsToBeSorted = getUnSortedMatchesForWorker(workerId);
//		Comparator<JobForWorker> comparator = Comparator.comparing(JobForWorker::getBillRateInDollars,
//				Comparator.reverseOrder());
//		comparator = comparator.thenComparing(JobForWorker::getNumberofMatchedCertificates,
//				Comparator.reverseOrder());
//		comparator = comparator.thenComparing(JobForWorker::isDriverLicenseRequired, 
//				Comparator.reverseOrder());
//		comparator = comparator.thenComparing(JobForWorker::getDistanceInKm,
//				Comparator.naturalOrder());
//		comparator = comparator.thenComparing(JobForWorker::getWorkersRequired,
//				Comparator.reverseOrder());
//		
//		jobsToBeSorted = jobsToBeSorted.stream().sorted(comparator).limit(maxCount)
//				.collect(Collectors.toList());
//		
//		return jobsToBeSorted;
//		
//	}

	//private List<Job> sortJobs(String)
}
