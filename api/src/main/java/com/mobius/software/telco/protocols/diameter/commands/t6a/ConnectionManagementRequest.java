package com.mobius.software.telco.protocols.diameter.commands.t6a;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ConnectionActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ExtendedPCO;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TerminalInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.7	Connection-Management-Request (CMR) Command
	The Connection-Management-Request (CMR) command, indicated by the Command-Code field set to 8388732 and the "R" bit set in the Command Flags field, is sent from:
		-	the MME or SGSN to the SCEF;
		-	the MME or SGSN to the SCEF via the IWK-SCEF for roaming cases;
		-	the SCEF to the MME or SGSN;
		-	the SCEF to the MME or SGSN via the IWK-SCEF for roaming cases.

	For the T6a/b, T6ai/bi, T7 interfaces, the Connection-Management-Request command format is specified as following:
	Message Format:

	< Connection-Management-Request > ::=   < Diameter Header: 8388732, REQ, PXY, 16777346 >
				 < Session-Id >
				 < User-Identifier >
				 < Bearer-Identifier >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 [ OC-Supported-Features ]
				 [ CMR-Flags ]
				 [ Maximum-UE-Availability-Time ]
				*[ Supported-Features ]
				 [ Connection-Action ]
				 [ Service-Selection ]
				 [ Serving-PLMN-Rate-Control ]
				 [ Extended-PCO ]
				 [ 3GPP-Charging-Characteristics ]
				 [ RAT-Type ]
				 [ Terminal-Information ]
				 [ Visited-PLMN-Id ]
				 [ APN-Rate-Control-Status ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777346, commandCode = 8388732, request = true, proxyable = true, name="Connection-Management-Request")
public interface ConnectionManagementRequest extends T6aRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 
	
	Long getCMRFlags();
	
	void setCMRFlags(Long value);
	
	MaximumUEAvailabilityTime getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(MaximumUEAvailabilityTime value);
	
	ConnectionActionEnum getConnectionAction();
	
	void setConnectionAction(ConnectionActionEnum value);
	
	ServiceSelection getServiceSelection();
	
	void setServiceSelection(ServiceSelection value);	
	
	ServingPLMNRateControl getServingPLMNRateControl();
	
	void setServingPLMNRateControl(ServingPLMNRateControl value);
	
	ExtendedPCO getExtendedPCO();
	
	void setExtendedPCO(ExtendedPCO value);
	
	TGPPChargingCharacteristics getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(TGPPChargingCharacteristics value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	APNRateControlStatus getAPNRateControlStatus();
	
	void setAPNRateControlStatus(APNRateControlStatus value);
}