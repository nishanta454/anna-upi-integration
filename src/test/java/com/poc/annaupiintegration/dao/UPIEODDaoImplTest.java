package com.poc.annaupiintegration.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.annaupiintegration.Constant;
import com.poc.annaupiintegration.model.UPIEODRecord;

@ExtendWith(SpringExtension.class)
class UPIEODDaoImplTest {

	@Mock
	private UPIEODDaoHelper upiEodDaoHelper;
	
	@Mock
	private ObjectMapper objectMapper;

	@InjectMocks
	private UPIEODDaoImpl upiEodDaoImpl;
	
	@Test
	void testFetchUPIEODRecords() throws JsonMappingException, JsonProcessingException {
		when(upiEodDaoHelper.fetchUPIEODRecordForDemo()).thenReturn(List.of(Constant.SAMPLE_VALUE));
		when(upiEodDaoHelper.fetchUPIEODRecordsFromAnna()).thenReturn(List.of(Constant.SAMPLE_VALUE));
		when(objectMapper.readValue(Constant.SAMPLE_VALUE, UPIEODRecord.class)).thenReturn(new UPIEODRecord());
		assertEquals(1, upiEodDaoImpl.fetchUPIEODRecords().size());
	}
	
	@Test
	void testFetchUPIEODRecordsWithException() throws JsonMappingException, JsonProcessingException {
		when(upiEodDaoHelper.fetchUPIEODRecordForDemo()).thenReturn(List.of(Constant.SAMPLE_VALUE));
		when(upiEodDaoHelper.fetchUPIEODRecordsFromAnna()).thenReturn(List.of(Constant.SAMPLE_VALUE));
		when(objectMapper.readValue(Constant.SAMPLE_VALUE, UPIEODRecord.class)).thenThrow(new RuntimeException());
		assertEquals(0, upiEodDaoImpl.fetchUPIEODRecords().size());
	}
}
