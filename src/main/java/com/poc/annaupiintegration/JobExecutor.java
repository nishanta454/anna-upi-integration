package com.poc.annaupiintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import com.poc.annaupiintegration.job.UPIEODJob;

@Profile("!test")
public class JobExecutor implements CommandLineRunner  {

	@Autowired
	private UPIEODJob upiEodJob;
	
	@Override
    public void run(String... args) {
    	upiEodJob.execute();
    }
}
