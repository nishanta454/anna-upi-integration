package com.poc.annaupiintegration.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.annaupiintegration.model.UPIEODRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UPIEODDaoImpl implements UPIEODDao {

	@Value("${spring.profiles.active:test}")
	private String activeProfile;

	@Autowired
	private UPIEODDaoHelper upiEodDaoHelper;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public List<UPIEODRecord> fetchUPIEODRecords() {
		var upiEodRecordList = new ArrayList<UPIEODRecord>();

		var upiEodRecords = "test".equals(activeProfile) ? upiEodDaoHelper.fetchUPIEODRecordForDemo() : upiEodDaoHelper.fetchUPIEODRecordsFromAnna();

		if (!ObjectUtils.isEmpty(upiEodRecords)) {
			for (String upiEodRecordStr : upiEodRecords) {
				try {
					if (!ObjectUtils.isEmpty(upiEodRecordStr)) {
						log.debug("Processing Record {}", upiEodRecordStr);
						UPIEODRecord upiEodRecord = objectMapper.readValue(upiEodRecordStr, UPIEODRecord.class);
						if (!ObjectUtils.isEmpty(upiEodRecord)) {
							log.debug("Converted Valid Record {}", upiEodRecord);
							upiEodRecordList.add(upiEodRecord);
						}
					}
				} catch (Exception e) {
					log.error("Exception While Processing Record {}", upiEodRecordStr, e);
				}
			}
		}

		return upiEodRecordList;
	}
}
