package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnosticEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.3	Device-Notification AVP
	The Device-Notification AVP (AVP code 3002) is of type Grouped. It is used by the MTC-IWF to report any action requested by the SCS.
	AVP Format:
	Device-Notification ::=             < AVP Header: 3002 >
			 [ External-Id ]
			 [ MSISDN ]
			 [ SCS-Identity ]
			 { Reference-Number }
			 { Action-Type }
			 [ Request-Status ]
			 [ MTC-Error-Diagnostic ]
			 [ Delivery-Outcome ]
			 [ SM-RP-UI ]
			 [ Application-Port-Identifier ]
 			*[ AVP ]
 */
@DiameterAvpDefinition(code = 3002L, vendorId = KnownVendorIDs.TGPP_ID, name = "Device-Notification")
public interface DeviceNotification extends DiameterGroupedAvp
{
	String getExternalID();
	
	void setExternalID(String value);	
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	ByteBuf getSCSIdentity();
	
	void setSCSIdentity(ByteBuf value);
	
	Long getReferenceNumber();
	
	void setReferenceNumber(Long value);
	
	ActionTypeEnum getActionType();
	
	void setActionType(ActionTypeEnum value);
	
	RequestStatusEnum getRequestStatus();
	
	void setRequestStatus(RequestStatusEnum value);
	
	MTCErrorDiagnosticEnum getMTCErrorDiagnostic();
	
	void setMTCErrorDiagnostic(MTCErrorDiagnosticEnum value);
	
	DeliveryOutcomeEnum getDeliveryOutcome();
	
	void setDeliveryOutcome(DeliveryOutcomeEnum value);
	
	ByteBuf getSMRPUI();
	
	void setSMRPUI(ByteBuf value);
	
	Long getApplicationPortIdentifier();
	
	void setApplicationPortIdentifier(Long value);
}