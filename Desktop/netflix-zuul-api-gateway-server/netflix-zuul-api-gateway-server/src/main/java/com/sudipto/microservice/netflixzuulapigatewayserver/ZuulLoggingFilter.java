package com.sudipto.microservice.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//Abstract methods in Zuul filter needs to be implemented
	@Override
	public boolean shouldFilter() {
		// Should the filter be executed
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//entire logic goes. 
		
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {} request uri -> {}", request,request.getRequestURI());
		
		
		return null;
	}

	@Override
	public String filterType() {
		// to indicate if the filter to be executed before or after the request is executed.
		return "pre";
	}

	@Override
	public int filterOrder() {
		//to set up priority order
		return 1;
	}

}
