package com.aravind.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
//	@Scheduled(fixedDelay  = 3000)
//	public void generateReport() {
//		System.out.println("report generated..!");
//	}
	
//	@Scheduled(fixedRate   = 3000)
//	public void generateReport() {
//		System.out.println("report generated..!");
//	}
	
	@Scheduled(cron = "59 59 23 31 12 7")
	public void generateReport() {
		System.out.println("report generated..!");
	}
}
