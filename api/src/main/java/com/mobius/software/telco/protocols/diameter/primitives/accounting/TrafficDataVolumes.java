package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.233	Traffic-Data-Volumes AVP
	The Traffic-Data-Volumes AVP (AVP code 2046) is of type Grouped. Its purpose is to allow the transmission of the IP-CAN bearer container, on encountering change on charging condition for this IP-CAN bearer.This container  reports the volume count (separated for uplink and downlink). The 3GPP-Charging-Id AVP for the IP-CAN bearer is included when charging per IP-CAN session is active.
	It has the following ABNF grammar:

	Traffic-Data-Volumes :: = 	  < AVP Header: 2046>
		    [ QoS-Information ]
		    [ Accounting-Input-Octets ]
		    [ Accounting-Output-Octets ]
		    [ Change-condition ]
		    [ Change-Time ]
		    [ 3GPP-User-Location-Info ]
		    [ UWAN-User-Location-Info ]
		    [ 3GPP-Charging-Id ]
		    [ Presence-Reporting-Area-Status ] 
 		* 	[ Presence-Reporting-Area-Information ]
		    [ User-CSG-Information ] 
		    [ 3GPP-RAT-Type ]
		    [ Access-Availability-Change-Reason ]
		    [ Related-Change-Condition-Information ]
		    [ Diagnostics ]
		    [ Enhanced-Diagnostics ]
		    [ CP-CIoT-EPS-Optimisation-Indicator ]
		    [ Serving-PLMN-Rate-Control ]
		    [ APN-Rate-Control ]
 */
@DiameterAvpDefinition(code = 2046L, vendorId = KnownVendorIDs.TGPP_ID, name = "Traffic-Data-Volumes")
public interface TrafficDataVolumes extends DiameterAvp
{
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long value);
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);
	
	Long getChangeCondition();
	
	void setChangeCondition(Long value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
	
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);
	
	UWANUserLocationInfo getUWANUserLocationInfo();
	
	void setUWANUserLocationInfo(UWANUserLocationInfo value);
	
	ByteBuf get3GPPChargingId();
	
	void set3GPPChargingId(ByteBuf value);
	
	PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus();
	
	void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value);
	
	List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value);
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	ByteBuf get3GPPRATType();
	
	void set3GPPRATType(ByteBuf value);
	
	AccessAvailabilityChangeReasonEnum getAccessAvailabilityChangeReason();
	
	void setAccessAvailabilityChangeReason(AccessAvailabilityChangeReasonEnum value);
	
	RelatedChangeConditionInformation getRelatedChangeConditionInformation();
	
	void setRelatedChangeConditionInformation(RelatedChangeConditionInformation value);
	
	Integer getDiagnostics();
	
	void setDiagnostics(Integer value);
	
	EnhancedDiagnostics getEnhancedDiagnostics();
	
	void setEnhancedDiagnostics(EnhancedDiagnostics value);
	
	CPCIoTEPSOptimisationIndicatorEnum getCPCIoTEPSOptimisationIndicator();
	
	void setCPCIoTEPSOptimisationIndicator(CPCIoTEPSOptimisationIndicatorEnum value);
	
	ServingPLMNRateControl getServingPLMNRateControl();
	
	void setServingPLMNRateControl(ServingPLMNRateControl value);
	
	APNRateControl getAPNRateControl();
	
	void setAPNRateControl(APNRateControl value);
}