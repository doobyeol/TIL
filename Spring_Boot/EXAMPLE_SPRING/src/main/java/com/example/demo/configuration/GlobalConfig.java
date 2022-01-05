package com.example.demo.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class GlobalConfig {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired ApplicationContext context;
	
	@Autowired ResourceLoader resourceLoader;
	
	private String uploadFilePath;
	private String schedulerCronExample1;
	
	private boolean local;
	private boolean dev;
	private boolean prod;
	
	@PostConstruct
	public void init() {
		logger.info("init");
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		String activeProfile = "local";
		if (ObjectUtils.isNotEmpty(activeProfiles)) {
			activeProfile = activeProfiles[0];
		}
		
		String resourcePath = String.format("classpath:globals/global-%s.properties", activeProfile);
		try {
			Resource resource = resourceLoader.getResource(resourcePath);
			Properties Properties = PropertiesLoaderUtils.loadProperties(resource);
			this.uploadFilePath = Properties.getProperty("uploadFile.path");
			this.schedulerCronExample1 = Properties.getProperty("uploadFile.path");
			this.local = activeProfile.equals("local");
			this.dev = activeProfile.equals("dev");
			this.prod = activeProfile.equals("prod");
		} catch (Exception e) {
			logger.error("e",e);
		}
	}
	
	public String getUploadFilePath() {
		return uploadFilePath;
	}
	
	public String getSchedulerCronExample1() {
		return schedulerCronExample1;
	}
	
	public boolean isLocal() {
		return local;
	}
	public boolean isDev() {
		return dev;
	}
	public boolean isProd() {
		return prod;
	}

}
