package com.poc.annaupiintegration.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.poc.annaupiintegration.entity.UPIEODEntity;
import com.poc.annaupiintegration.model.UPIEODRecord;
import com.poc.annaupiintegration.util.CommonUtil;

@Component
public class UPIEODServiceHelper {
	
	public UPIEODEntity createUPIEODEntity(UPIEODRecord upiEodModel) {
		UPIEODEntity entity = null;
		if (!ObjectUtils.isEmpty(upiEodModel)) {
			entity = new UPIEODEntity();
			if (!ObjectUtils.isEmpty(upiEodModel.getHeader())) {
				BeanUtils.copyProperties(upiEodModel.getHeader(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getHeader()));
			}
			if (!ObjectUtils.isEmpty(upiEodModel.getIdentifier())) {
				BeanUtils.copyProperties(upiEodModel.getIdentifier(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getIdentifier()));
			}
			if (!ObjectUtils.isEmpty(upiEodModel.getDerived())) {
				BeanUtils.copyProperties(upiEodModel.getDerived(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getDerived()));
			}
			if (!ObjectUtils.isEmpty(upiEodModel.getAttributes())) {
				BeanUtils.copyProperties(upiEodModel.getAttributes(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getAttributes()));
				if (!ObjectUtils.isEmpty(upiEodModel.getAttributes().getOtherLegUnderlying())) {
					BeanUtils.copyProperties(upiEodModel.getAttributes().getOtherLegUnderlying(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getAttributes().getOtherLegUnderlying()));
				}
				if (!ObjectUtils.isEmpty(upiEodModel.getAttributes().getUnderlying())) {
					BeanUtils.copyProperties(upiEodModel.getAttributes().getUnderlying(), entity, CommonUtil.getNullPropertyNames(upiEodModel.getAttributes().getUnderlying()));
				}
			}
		}
		return entity;
	}
}
