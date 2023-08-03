package com.poc.annaupiintegration.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.poc.annaupiintegration.model.UPIEODRecord;

class CommonUtilTest {
    @Test
    void null_property_names_success() {
    	UPIEODRecord upiEodModel = new UPIEODRecord();
        assertEquals(CommonUtil.getNullPropertyNames(upiEodModel).length, 5);
    }

    @Test
    void null_property_names_zero() {
        assertThrows(RuntimeException.class, () -> CommonUtil.getNullPropertyNames(null));
    }
}
