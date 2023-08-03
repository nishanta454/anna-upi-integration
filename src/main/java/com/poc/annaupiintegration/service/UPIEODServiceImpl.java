package com.poc.annaupiintegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.poc.annaupiintegration.dao.UPIEODDao;
import com.poc.annaupiintegration.model.UPIEODRecord;
import com.poc.annaupiintegration.repository.UPIEODRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UPIEODServiceImpl implements UPIEODService {

	@Autowired
	private UPIEODDao upiEodao;

	@Autowired
	private UPIEODRepository upiEodRepository;
	
	@Autowired
	private UPIEODServiceHelper upiEODServiceHelper;

	@Override
	public List<UPIEODRecord> fetchUPIEODRecords() {
		return upiEodao.fetchUPIEODRecords();
	}

	@Override
	public void processUPIEODRecord(UPIEODRecord upiEodModel) {
		log.debug("Processing Model {}", upiEodModel);
		var entity = upiEODServiceHelper.createUPIEODEntity(upiEodModel);
		if (!ObjectUtils.isEmpty(entity)) {
			log.debug("Processing Entity {}", entity);
			entity = upiEodRepository.save(entity);
			log.debug("Processed Entity {}", entity);
		}
		log.debug("Exiting Method");
	}
}
