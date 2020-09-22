package com.sudipto.microservice.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sudipto.microservice.limitsservice.bean.LimitConfiguration;


@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	
	@RequestMapping(value="/limits",method=RequestMethod.GET)
	public LimitConfiguration  retrievalLimit() {
		
		return new LimitConfiguration(9,1);
	}	
	
	@RequestMapping(value="/limit",method=RequestMethod.GET)
	public LimitConfiguration  retrievalLimitFromConfiguration() {
		
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
	
	
}