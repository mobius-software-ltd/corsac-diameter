package com.mobius.software.telco.protocols.diameter.commands.slg;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredMTLRData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DelayedLocationReportingData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoSClassEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LocationEventEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PseudonymIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.3	Location-Report-Request (LRR) Command
	The Location-Report-Request (LRR) command, indicated by the Command-Code field set to 8388621 and the 'R' bit set in the Command Flags field, is sent by the MME or SGSN in order to provide subscriber location data to the GMLC.
	Message Format
	
	< Location-Report-Request> ::=	< Diameter Header: 8388621, REQ, PXY, 16777255 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 { Destination-Host }
					 { Destination-Realm }
					 { Location-Event }
					 [ LCS-EPS-Client-Name ]
					 [ User-Name ]
					 [ MSISDN ]
					 [ IMEI ]
					 [ Location-Estimate ]
					 [ Accuracy-Fulfilment-Indicator ]
					 [ Age-Of-Location-Estimate ]
					 [ Velocity-Estimate ]
					 [ EUTRAN-Positioning-Data ]
					 [ ECGI ]
					 [ GERAN-Positioning-Info ]
					 [ Cell-Global-Identity ]
					 [ UTRAN-Positioning-Info ]
					 [ Service-Area-Identity ]
					 [ LCS-Service-Type-ID ]
					 [ Pseudonym-Indicator ]
					 [ LCS-QoS-Class ]
					 [ Serving-Node ]
					 [ LRR-Flags ]
					 [ LCS-Reference-Number ]
					 [ Deferred-MT-LR-Data ]
					 [ GMLC-Address ]
					 [ Reporting-Amount ]
					 [ Periodic-LDR-Information ]
					 [ ESMLC-Cell-Info ]
					 [ 1xRTT-RCID ] ]
					 [ Delayed-Location-Reporting-Data ]
					 [ Civic-Address ]
					 [ Barometric-Pressure ]
					*[ Supported-Features ]
					*[ AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777255, commandCode = 8388621, request = true, proxyable = true, name="Location-Report-Request")
public interface LocationReportRequest extends SlgRequest
{
	LocationEventEnum getLocationEvent();
	 
	void setLocationEvent(LocationEventEnum value);
	 		
	LCSEPSClientName getLCSEPSClientName();
	
	void setLCSEPSClientName(LCSEPSClientName value);
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getIMEI();
	 
	void setIMEI(String value);
	
	ByteBuf getLocationEstimate();
	
	void setLocationEstimate(ByteBuf value);
	
	AccuracyFulfilmentIndicatorEnum getAccuracyFulfilmentIndicator();
	
	void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicatorEnum value);
	
	Long getAgeOfLocationEstimate();
	
	void setAgeOfLocationEstimate(Long value);	
	
	ByteBuf getVelocityEstimate();
	
	void setVelocityEstimate(ByteBuf value);	
	
	ByteBuf getEUTRANPositioningData();
	
	void setEUTRANPositioningData(ByteBuf value);
	
	ByteBuf getECGI();
	 
	void setECGI(ByteBuf value);
		
	GERANPositioningInfo getGERANPositioningInfo();
	 
	void setGERANPositioningInfo(GERANPositioningInfo value);
	
	ByteBuf getCellGlobalIdentity();
	 
	void setCellGlobalIdentity(ByteBuf value);
	
	UTRANPositioningInfo getUTRANPositioningInfo();
	 
	void setUTRANPositioningInfo(UTRANPositioningInfo value);
	
	ByteBuf getServiceAreaIdentity();
	 
	void setServiceAreaIdentity(ByteBuf value);
	
	Long getLCSServiceTypeID();
	
	void setLCSServiceTypeID(Long value);	
	
	PseudonymIndicatorEnum getPseudonymIndicator();
	
	void setPseudonymIndicator(PseudonymIndicatorEnum value);	
	
	LCSQoSClassEnum getLCSQoSClass();
	
	void setLCSQoSClass(LCSQoSClassEnum value);	
	
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
	
	LRRFlags getLRRFlags();
	
	void setLRRFlags(LRRFlags value);	
	
	ByteBuf getLCSReferenceNumber();
	
	void setLCSReferenceNumber(ByteBuf value);
	
	DeferredMTLRData getDeferredMTLRData();
	
	void setDeferredMTLRData(DeferredMTLRData value);	
	
	InetAddress getGMLCAddress();
	
	void setGMLCAddress(InetAddress value);
	
	Long getReportingAmount();
	
	void setReportingAmount(Long value);	
	
	PeriodicLDRInfo getPeriodicLDRInformation();
	
	void setPeriodicLDRInformation(PeriodicLDRInfo value);			
	
	ESMLCCellInfo getESMLCCellInfo();
	
	void setESMLCCellInfo(ESMLCCellInfo value);	
	
	ByteBuf getOnexRTTRCID();
	
	void setOnexRTTRCID(ByteBuf value);	
	
	DelayedLocationReportingData getDelayedLocationReportingData();
	 
	void setDelayedLocationReportingData(DelayedLocationReportingData value);
	
	String getCivicAddress();
	 
	void setCivicAddress(String value);
	
	Long getBarometricPressure();
	 
	void setBarometricPressure(Long value);	
}