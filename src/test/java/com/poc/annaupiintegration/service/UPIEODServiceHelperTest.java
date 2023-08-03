package com.poc.annaupiintegration.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.poc.annaupiintegration.model.UPIEODRecord;

@ExtendWith(SpringExtension.class)
class UPIEODServiceHelperTest {

	@InjectMocks
	private UPIEODServiceHelper upiEodServiceHelper;
	
	@Test
	void testCreateUPIEODEntityNull() {
		assertNull(upiEodServiceHelper.createUPIEODEntity(null));
	}
	
	@Test
	void testCreateUPIEODEntityAllNonNull() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		upiEodModel.setHeader(new UPIEODRecord.Header());
		upiEodModel.setIdentifier(new UPIEODRecord.Identifier());
		upiEodModel.setDerived(new UPIEODRecord.Derived());
		var attributes = new UPIEODRecord.Attributes();
		attributes.setUnderlying(new UPIEODRecord.Underlying());
		attributes.setOtherLegUnderlying(new UPIEODRecord.OtherLegUnderlying());
		upiEodModel.setAttributes(attributes);
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullHeader() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		upiEodModel.setHeader(new UPIEODRecord.Header());
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullIdentifier() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		upiEodModel.setIdentifier(new UPIEODRecord.Identifier());
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullDerived() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		upiEodModel.setDerived(new UPIEODRecord.Derived());
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullAttributes() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		var attributes = new UPIEODRecord.Attributes();
		attributes.setUnderlying(new UPIEODRecord.Underlying());
		attributes.setOtherLegUnderlying(new UPIEODRecord.OtherLegUnderlying());
		upiEodModel.setAttributes(attributes);
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullUnderlying() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		var attributes = new UPIEODRecord.Attributes();
		attributes.setUnderlying(new UPIEODRecord.Underlying());
		upiEodModel.setAttributes(attributes);
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
	
	@Test
	void testCreateUPIEODEntityNonNullOtherLegUnderlying() {
		UPIEODRecord upiEodModel = new UPIEODRecord();
		var attributes = new UPIEODRecord.Attributes();
		attributes.setOtherLegUnderlying(new UPIEODRecord.OtherLegUnderlying());
		upiEodModel.setAttributes(attributes);
		assertNotNull(upiEodServiceHelper.createUPIEODEntity(upiEodModel));
	}
}
