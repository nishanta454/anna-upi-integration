package com.poc.annaupiintegration.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="UPI_EOD")
@Data
public class UPIEODEntity {
	@Id
	@Column(name = "UPI", length=15)
	private String upi;
	
	
	@Column(name = "AssetClass", length=20)
	private String assetClass;
	
	@Column(name = "InstrumentType", length=255)
	private String instrumentType;
	
	@Column(name = "Product", length=100)
	private String product;
	
	@Column(name = "Level", length=100)
	private String level;
	
	
	@Column(name = "Status", length=20)
	private String status;
	
	@Column(name = "StatusReason", length=255)
	private String statusReason;
	
	@Column(name = "LastUpdateDateTime")
	private Date lastUpdateDateTime;
	
	
	@Column(name = "ClassificationType", length=100)
	private String classificationType;
	
	@Column(name = "ShortName", length=255)
	private String shortName;
	
	@Column(name = "UnderlierName", length=255)
	private String underlierName;
	
	@Column(name = "UnderlyingAssetType", length=100)
	private String underlyingAssetType;
	
	@Column(name = "ReturnorPayoutTrigger", length=255)
	private String returnorPayoutTrigger;
	
	@Column(name = "DeliveryType", length=100)
	private String deliveryType;
	
	@Column(name = "CFIDeliveryType", length=100)
	private String cfiDeliveryType;
	
	@Column(name = "CFIOptionStyleandType", length=100)
	private String cfiOptionStyleandType;
	
	@Column(name =  "SingleorMultiCurrency", length=100)
	private String singleOrMultiCurrency;
	
	@Column(name =  "ValuationMethodorTrigger", length=100)
	private String valuationMethodorTrigger;
	
	
	@Column(name = "NotionalCurrency", length=5)
	private String notionalCurrency;
	
	@Column(name = "OtherNotionalCurrency", length=5)
	private String otherNotionalCurrency;
	
	@Column(name = "ReferenceRate", length=100)
	private String referenceRate;
	
	@Column(name = "ReferenceRateTermValue", length=100)
	private String referenceRateTermValue;
	
	@Column(name = "ReferenceRateTermUnit", length=5)
	private String referenceRateTermUnit;
	
	@Column(name = "NotionalSchedule", length=100)
	private String notionalSchedule;
	
	@Column(name = "UnderlyingInstrumentIndex", length=100)
	private String underlyingInstrumentIndex;
	
	@Column(name = "UnderlyingInstrumentIndexTermValue", length=100)
	private String underlyingInstrumentIndexTermValue;
	
	@Column(name = "UnderlyingInstrumentIndexTermUnit", length=5)
	private String underlyingInstrumentIndexTermUnit;
	
	@Column(name = "SettlementCurrency", length=5)
	private String settlementCurrency;
	
	@Column(name =  "OptionType", length=100)
	private String optionType;
	
	@Column(name = "PlaceofSettlement", length=255)
	private String placeofSettlement;
	
	@Column(name = "OptionExerciseStyle", length=255)
	private String optionExerciseStyle;
	
	@Column(name = "OtherLegUnderlierCharacteristic", length=100)
	private String otherLegUnderlierCharacteristic;
	
	@Column(name = "OtherLegReferenceRate", length=100)
	private String otherLegReferenceRate;
	
	@Column(name = "OtherLegReferenceRateTermValue", length=100)
	private String otherLegReferenceRateTermValue;
	
	@Column(name = "OtherLegReferenceRateTermUnit", length=5)
	private String otherLegReferenceRateTermUnit;
}
