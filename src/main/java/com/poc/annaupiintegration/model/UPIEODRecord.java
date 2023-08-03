package com.poc.annaupiintegration.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UPIEODRecord {
	
	@JsonProperty(value =  "TemplateVersion")
    private Integer templateVersion;
	
	@JsonProperty(value =  "Header")
    private Header header;
	
	@JsonProperty(value =  "Identifier")
    private Identifier identifier;
	
	@JsonProperty(value =  "Derived")
    private Derived derived;

	@JsonProperty(value =  "Attributes")
	private Attributes attributes;
	
	@Data
	public static class Header {
		@JsonProperty(value =  "AssetClass")
		private String assetClass;
		
		@JsonProperty(value =  "InstrumentType")
		private String instrumentType;
		
		@JsonProperty(value =  "UseCase")
		private String product;
		
		@JsonProperty(value =  "Level")
		private String level;
	}
	
	@Data
	public static class Identifier {
		@JsonProperty( value =  "UPI")
		private String upi;
		
		@JsonProperty(value =  "Status")
		private String status;
		
		@JsonProperty(value =  "StatusReason")
		private String statusReason;
		
		@JsonProperty(value =  "LastUpdateDateTime")
		private Date lastUpdateDateTime;
	}
	
	@Data
	public static class Derived {
		@JsonProperty(value =  "ClassificationType")
		private String classificationType;
		
		@JsonProperty(value =  "ShortName")
		private String shortName;
		
		@JsonProperty(value =  "UnderlierName")
		private String underlierName;
		
		@JsonProperty(value =  "UnderlyingAssetType")
		private String underlyingAssetType;
		
		@JsonProperty(value =  "ReturnorPayoutTrigger")
		private String returnorPayoutTrigger;
		
		@JsonProperty(value =  "DeliveryType")
		private String deliveryType;
		
		@JsonProperty(value =  "CFIDeliveryType")
		private String cfiDeliveryType;
		
		@JsonProperty(value =  "CFIOptionStyleandType")
		private String cfiOptionStyleandType;
		
		@JsonProperty(value =  "SingleorMultiCurrency")
		private String singleOrMultiCurrency;
		
		@JsonProperty(value =  "ValuationMethodorTrigger")
		private String valuationMethodorTrigger;
	}
	
	@Data
	public static class Attributes {
		@JsonProperty(value =  "NotionalCurrency")
		private String notionalCurrency;
		
		@JsonProperty(value =  "OtherNotionalCurrency")
		private String otherNotionalCurrency;
		
		@JsonProperty(value =  "DeliveryType")
		private String deliveryType;
		
		@JsonProperty(value =  "OptionType")
		private String optionType;
		
		@JsonProperty(value =  "UnderlyingAssetType")
		private String underlyingAssetType;
		
		@JsonProperty(value =  "SettlementCurrency")
		private String settlementCurrency;
		
		@JsonProperty(value =  "ReturnorPayoutTrigger")
		private String returnorPayoutTrigger;
		
		@JsonProperty(value = "PlaceofSettlement")
		private String placeofSettlement;

		@JsonProperty(value = "OptionExerciseStyle")
		private String optionExerciseStyle;
		
		@JsonProperty(value = "ReferenceRate")
		private String referenceRate;
		
		@JsonProperty(value = "ReferenceRateTermValue")
		private String referenceRateTermValue;
		
		@JsonProperty(value = "ReferenceRateTermUnit")
		private String referenceRateTermUnit;
		
		@JsonProperty(value = "NotionalSchedule")
		private String notionalSchedule;
		
		@JsonProperty(value = "UnderlyingInstrumentIndex")
		private String underlyingInstrumentIndex;
		
		@JsonProperty(value = "UnderlyingInstrumentIndexTermValue")
		private String underlyingInstrumentIndexTermValue;
		
		@JsonProperty(value = "UnderlyingInstrumentIndexTermUnit")
		private String underlyingInstrumentIndexTermUnit;
		
		@JsonProperty(value = "Underlying")
		private Underlying underlying;
		
		@JsonProperty(value = "OtherLegUnderlying")
		private OtherLegUnderlying otherLegUnderlying;
	}
	
	@Data
	public static class Underlying {
		@JsonProperty(value = "UnderlierCharacteristic")
		private String underlyingInstrumentIndexTermValue;
		
		@JsonProperty(value = "ReferenceRate")
		private String referenceRate;
		
		@JsonProperty(value = "ReferenceRateTermValue")
		private String referenceRateTermValue;
		
		@JsonProperty(value = "ReferenceRateTermUnit")
		private String referenceRateTermUnit;
	}
	
	@Data
	public static class OtherLegUnderlying {
		@JsonProperty(value = "OtherLegUnderlierCharacteristic")
		private String otherLegUnderlierCharacteristic;
		
		@JsonProperty(value = "OtherLegReferenceRate")
		private String otherLegReferenceRate;
		
		@JsonProperty(value = "OtherLegReferenceRateTermValue")
		private String otherLegReferenceRateTermValue;
		
		@JsonProperty(value = "OtherLegReferenceRateTermUnit")
		private String otherLegReferenceRateTermUnit;
	}
}