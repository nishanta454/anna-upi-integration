package com.poc.annaupiintegration.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.poc.annaupiintegration.dao.UPIEODDao;
import com.poc.annaupiintegration.entity.UPIEODEntity;
import com.poc.annaupiintegration.model.UPIEODRecord;
import com.poc.annaupiintegration.repository.UPIEODRepository;

@ExtendWith(SpringExtension.class)
class UPIEODServiceImplTest {
	
	@Mock
	private UPIEODDao upiEodao;

	@Mock
	private UPIEODRepository upiEodRepository;
	
	@Mock
	private UPIEODServiceHelper upiEODServiceHelper;
	
	@InjectMocks
	private UPIEODServiceImpl upiEodServiceImpl;
	
	@Test
	public void testFetchUPIEODRecords() {
		when(upiEodao.fetchUPIEODRecords()).thenReturn(new ArrayList<UPIEODRecord>());
		assertNotNull(upiEodServiceImpl.fetchUPIEODRecords());
	}
	
	@Test
	public void testProcessUPIEODRecord() {
		when(upiEODServiceHelper.createUPIEODEntity(any(UPIEODRecord.class))).thenReturn(new UPIEODEntity());
		assertDoesNotThrow(() -> upiEodServiceImpl.processUPIEODRecord(new UPIEODRecord()));
	}
	
	@Test
	public void testProcessUPIEODRecordWithNull() {
		when(upiEODServiceHelper.createUPIEODEntity(any(UPIEODRecord.class))).thenReturn(null);
		assertDoesNotThrow(() -> upiEodServiceImpl.processUPIEODRecord(null));
	}
}
