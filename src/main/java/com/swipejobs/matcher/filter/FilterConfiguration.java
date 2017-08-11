package com.swipejobs.matcher.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Filter Configuration class . Any new filter added needs to be initiated here.
 */
@Configuration
public class FilterConfiguration {

	@Bean
	public MatchedCertFilter getMatchedCertFilter(){
		return new MatchedCertFilter();
	}
	@Bean
	public DriverLicenseFilter getDriverLicenceFilter(){
		return new DriverLicenseFilter();
	}

	@Bean
	public LocationFilter getLocationFilter(){
		return new LocationFilter();
	}
	@Bean 
	public CertificatesFilter getCertificatesFilter(){
		return new CertificatesFilter();
	}
	
	@Bean
	public FilterChain getFilterChain(){
		return new FilterChain();
	}
	

}
