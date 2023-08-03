package com.poc.annaupiintegration.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.poc.annaupiintegration.Constant;

@ExtendWith(SpringExtension.class)
class UPIEODDaoHelperTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private UPIEODDaoHelper upiEodDaoHelper;

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(upiEodDaoHelper, "annaUserName", Constant.SAMPLE_VALUE);
		ReflectionTestUtils.setField(upiEodDaoHelper, "annaPassword", Constant.SAMPLE_VALUE);
		ReflectionTestUtils.setField(upiEodDaoHelper, "annaUPIEndpoints", new String[] { Constant.SAMPLE_VALUE });
	}

	@Test
	void testFetchUPIEODRecordsFromAnna() {
		var response = new ResponseEntity<String>(Constant.SAMPLE_VALUE, HttpStatusCode.valueOf(200));
		when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)))
				.thenReturn(response);
		assertNotNull(upiEodDaoHelper.fetchUPIEODRecordsFromAnna());
	}

}
