package com.poc.annaupiintegration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.poc.annaupiintegration.job.UPIEODJob;
import com.poc.annaupiintegration.repository.UPIEODRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class BootstrapTest {

	@Autowired
	private UPIEODJob upiEodJob;
	
	@Autowired
	private UPIEODRepository upiEodRepository;
	
	@Test
    void testRun() {
		var records = upiEodRepository.findAll();
		log.info("Records Before Insertion {}", records);
		assertEquals(records.size(), 0);
    	upiEodJob.execute();
    	records = upiEodRepository.findAll();
    	log.info("Records After Insertion {}", records);
    	assertEquals(records.size(), 9);
    }
}
