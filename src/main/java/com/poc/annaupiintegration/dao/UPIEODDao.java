package com.poc.annaupiintegration.dao;

import java.util.List;

import com.poc.annaupiintegration.model.UPIEODRecord;

public interface UPIEODDao {
	List<UPIEODRecord> fetchUPIEODRecords();
}
