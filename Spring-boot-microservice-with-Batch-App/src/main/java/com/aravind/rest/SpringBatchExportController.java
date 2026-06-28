package com.aravind.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SpringBatchExportController {
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("exportJob")
	private Job exportJob;

	@GetMapping("/export")
	public void exportCsv() throws Exception {
	    JobParameters params = new JobParametersBuilder()
	            .addLong("time", System.currentTimeMillis())
	            .toJobParameters();
	    jobLauncher.run(exportJob, params);
	}

}
