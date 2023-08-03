package com.poc.annaupiintegration.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.poc.annaupiintegration.service.UPIEODService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UPIEODJob implements Job {

	@Autowired
	private UPIEODService upiEodService;

	@Override
	public void execute() {
		log.debug("Executing UPIEODJob");
		try {
			var upiEodRecords = upiEodService.fetchUPIEODRecords();
			if (!ObjectUtils.isEmpty(upiEodRecords)) {
				log.debug("Found Valid Records to Process");
				upiEodRecords.parallelStream().forEachOrdered(upiEodRecord -> {
					log.debug("Processing Record {}", upiEodRecord);
					upiEodService.processUPIEODRecord(upiEodRecord);
					log.debug("Record {} has been processed", upiEodRecord);
				});
			} else {
				log.debug("No Records to Process");
			}
		} catch (Exception ex) {
			log.error("Exception While Executing UPIEODJob", ex);
		}
		log.debug("UPIEODJob Executed");
	}
}
