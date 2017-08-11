package com.swipejobs.matcher.sort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Filter Configuration class . Any new filter added needs to be initiated here.
 */
@Configuration
public class ScoreChainConfiguration {
	/*
	 *Different Score calculators are configured here with different maxScore. 
	 *The more the maxScore the more weightage that attribute has on total score.
	 */
	
	@Bean
	public BillRateScoreCalculator getBillRateScoreCalculator(){
		return new BillRateScoreCalculator(30);
	}

	@Bean
	public LocationScoreCalculator getLocationScoreCalculator(){
		return new LocationScoreCalculator(30);
	}
	@Bean 
	public CertificateScoreCalculator getCertificatesFilter(){
		return new CertificateScoreCalculator(20);
	}
	@Bean 
	public WorkersReqdCalculator getWorkersReqdCalculator(){
		return new WorkersReqdCalculator(10);
	}
	@Bean 
	public DriverLicenceScoreCalculator getDriverLicenceScoreCalculator(){
		return new DriverLicenceScoreCalculator(10);
	}
	
	@Bean
	public ScoreChain getScoreChain(){
		return new ScoreChain();
	}
}
