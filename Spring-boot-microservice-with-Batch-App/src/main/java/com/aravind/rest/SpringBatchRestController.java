package com.aravind.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBatchRestController {
	
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job job;
	
	@GetMapping("/import")
	public String loadDataToDB() {
	    try {
	        JobParameters jobParams = new JobParametersBuilder()
	                .addLong("startAt", System.currentTimeMillis())
	                .toJobParameters();
	        launcher.run(job, jobParams);
	        return "Batch job started successfully.";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Batch job failed: " + e.getMessage();
	    }
	}

}
