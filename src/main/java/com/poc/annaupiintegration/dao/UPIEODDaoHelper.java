package com.poc.annaupiintegration.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UPIEODDaoHelper {
	
	@Value("${anna.username}")
	private String annaUserName;

	@Value("${anna.password}")
	private String annaPassword;

	@Value("${anna.upi.endpoints}")
	private String[] annaUPIEndpoints;

	@Autowired
	private RestTemplate restTemplate;
	
	public List<String> fetchUPIEODRecordForDemo() {
		var records = new ArrayList<String>();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("anna-upi-sample.record");
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			var line = reader.readLine();
			while (!StringUtils.isEmpty(line)) {
				log.debug("Line From File {}", line);
				records.add(line);
				line = reader.readLine();
			}
		} catch (Exception e) {
			log.error("Exception While Fetching Data From ANNA UPI", e);
		}
		return records;
	}

	public List<String> fetchUPIEODRecordsFromAnna() {
		var records = new ArrayList<String>();

		var now = LocalDate.now();

		if (!now.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
			
			var dateFromatter = DateTimeFormatter.ofPattern("YYYYMMdd");
			var yearFormatter = DateTimeFormatter.ofPattern("YYYY");

			for (String annaUPIEndpoint : annaUPIEndpoints) {
				try {
					var headers = new HttpHeaders();
					headers.add("Authorization", "Basic "
							+ Base64.getEncoder().encodeToString((annaUserName + ":" + annaPassword).getBytes()));

					var endpoint = String.format(annaUPIEndpoint, yearFormatter.format(now), dateFromatter.format(now),
							dateFromatter.format(now));

					var response = restTemplate.exchange(endpoint, HttpMethod.GET, new HttpEntity<String>(headers),
							String.class);

					if (!ObjectUtils.isEmpty(response) && response.getStatusCode() == HttpStatus.OK) {
						records.addAll(Arrays.asList(response.getBody().split("\n")));
					}
				} catch (Exception e) {
					log.error("Exception While Fetching Data From ANNA UPI", e);
				}
			}
		}

		return records;
	}
}
