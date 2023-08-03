package com.poc.annaupiintegration.service;

import java.util.List;

import com.poc.annaupiintegration.model.UPIEODRecord;

public interface UPIEODService {
	List<UPIEODRecord> fetchUPIEODRecords();

	void processUPIEODRecord(UPIEODRecord upiEodRecord);
}
