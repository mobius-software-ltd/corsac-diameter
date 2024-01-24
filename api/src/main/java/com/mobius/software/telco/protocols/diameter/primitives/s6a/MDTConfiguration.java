package com.mobius.software.telco.protocols.diameter.primitives.s6a;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.136	MDT-Configuration
	The MDT-Configuration AVP is of type Grouped. It shall contain MDT related information as specified in 3GPP TS 32.422 [23].
	The AVP format shall conform to:
	
	MDT-Configuration ::= <AVP header: 1622 10415>
			 { Job-Type }
			 [ Area-Scope ]
			 [ List-Of-Measurements ]
			 [ Reporting-Trigger ]
			 [ Report-Interval ]
			 [ Report-Amount ]
			 [ Event-Threshold-RSRP ]
			 [ Event-Threshold-RSRQ ]
			 [ Logging-Interval ]
			 [ Logging-Duration ]
			 [ Measurement-Period-LTE ]
			 [ Measurement-Period-UMTS ]
			 [ Collection-Period- RRM-LTE ]
			 [ Collection-Period-RRM-UMTS ]
			 [ Positioning-Method ]
			 [ Measurement-Quantity]
			 [ Event-Threshold-Event-1F ]
			 [ Event-Threshold-Event-1I ]
			*[ MDT-Allowed-PLMN-Id ]
			*[ MBSFN-Area ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1622L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MDT-Configuration")
public interface MDTConfiguration extends DiameterGroupedAvp
{
	JobTypeEnum getJobType();
	
	void setJobType(JobTypeEnum value);	
	
	AreaScope getAreaScope();
	
	void setAreaScope(AreaScope value);
	
	ListOfMeasurements getListOfMeasurements();
	
	void setListOfMeasurements(ListOfMeasurements value);
	
	ReportingTrigger getReportingTrigger();
	
	void setReportingTrigger(ReportingTrigger value);
	
	ReportIntervalEnum getReportInterval();
	
	void setReportInterval(ReportIntervalEnum value);
	
	ReportAmountEnum getReportAmount();
	
	void setReportAmount(ReportAmountEnum value);
	
	Long getEventThresholdRSRP();
	
	void setEventThresholdRSRP(Long value);
	
	Long getEventThresholdRSRQ();
	
	void setEventThresholdRSRQ(Long value);
	
	LoggingIntervalEnum getLoggingInterval();
	
	void setLoggingInterval(LoggingIntervalEnum value);
	
	LoggingDurationEnum getLoggingDuration();
	
	void setLoggingDuration(LoggingDurationEnum value);
	
	MeasurementPeriodLTEEnum getMeasurementPeriodLTE();
	
	void setMeasurementPeriodLTE(MeasurementPeriodLTEEnum value);
	
	MeasurementPeriodUMTSEnum getMeasurementPeriodUMTS();
	
	void setMeasurementPeriodUMTS(MeasurementPeriodUMTSEnum value);
	
	CollectionPeriodRRMLTEEnum getCollectionPeriodRRMLTE();
	
	void setCollectionPeriodRRMLTE(CollectionPeriodRRMLTEEnum value);
	
	CollectionPeriodRRMUMTSEnum getCollectionPeriodRRMUMTS();
	
	void setCollectionPeriodRRMUMTS(CollectionPeriodRRMUMTSEnum value);
	
	Long getPositioningMethod();
	
	void setPositioningMethod(Long value);
	
	Long getMeasurementQuantity();
	
	void setMeasurementQuantity(Long value);
	
	Integer getEventThresholdEvent1F();
	
	void setEventThresholdEvent1F(Integer value);
	
	Integer getEventThresholdEvent1I();
	
	void setEventThresholdEvent1I(Integer value);
	
	List<ByteBuf> getMDTAllowedPLMNId();
	
	void setMDTAllowedPLMNId(List<ByteBuf> value);
	
	List<MBSFNArea> getMBSFNArea();
	
	void setMBSFNArea(List<MBSFNArea> value);	
}