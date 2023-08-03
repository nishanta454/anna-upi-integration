package com.poc.annaupiintegration.job;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.poc.annaupiintegration.service.UPIEODService;

@ExtendWith(SpringExtension.class)
class UPIEODJobTest {

	@Mock
	private UPIEODService upiEodService;

	@InjectMocks
	private UPIEODJob upiEodJob;
	
	@Test
	void testExecuteWithNullRecords() {
		when(upiEodService.fetchUPIEODRecords()).thenReturn(null);
		upiEodJob.execute();
	}
	
	@Test
	void testExecuteWithException() {
		when(upiEodService.fetchUPIEODRecords()).thenThrow(new RuntimeException());
		upiEodJob.execute();
	}
}
