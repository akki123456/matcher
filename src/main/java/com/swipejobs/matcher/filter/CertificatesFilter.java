package com.swipejobs.matcher.filter;

import java.util.HashSet;
import java.util.Set;

import com.swipejobs.matcher.model.JobForWorker;
import com.swipejobs.matcher.model.Worker;

public class CertificatesFilter implements Filter {

	@Override
	public JobForWorker filter(Worker worker, JobForWorker job) {
		if(worker.getCertificates()==null){
				if(job.getRequiredCertificates()==null||job.getRequiredCertificates().size()==0){
					return job;
				}else{
					return null;
				}
		}
		Set<String> certicatesOwned= new HashSet<String>( worker.getCertificates());
		for(String certificate: job.getRequiredCertificates()){
			if(!certicatesOwned.contains(certificate)){
				return null;
			}else{
				job.getMatchedCertificates().add(certificate);
			}
		}
		return job;
	}

}
