package com.poc.annaupiintegration.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.annaupiintegration.model.UPIEODRecord;

@ExtendWith(SpringExtension.class)
class UPIEODDaoImplTest {

	@Mock
	private UPIEODDaoHelper upiEodDaoHelper;
	
	@Mock
	private ObjectMapper objectMapper;

	@InjectMocks
	private UPIEODDaoImpl upiEodDaoImpl;
	
	@BeforeAll
	static void beforeAll() {
		System.setProperty("spring.profiles.active", "test");
	}
	
	void testFetchUPIEODRecords() throws JsonMappingException, JsonProcessingException {
		when(upiEodDaoHelper.fetchUPIEODRecordForDemo()).thenReturn(List.of("sample_record"));
		when(objectMapper.readValue(anyString(), UPIEODRecord.class)).thenReturn(new UPIEODRecord());
		assertEquals(upiEodDaoImpl.fetchUPIEODRecords().size(), 1);
	}
	
	void testFetchUPIEODRecordsWithException() throws JsonMappingException, JsonProcessingException {
		when(upiEodDaoHelper.fetchUPIEODRecordForDemo()).thenReturn(List.of("sample_record"));
		when(objectMapper.readValue(anyString(), UPIEODRecord.class)).thenThrow(new RuntimeException());
		assertEquals(upiEodDaoImpl.fetchUPIEODRecords().size(), 0);
	}
}
