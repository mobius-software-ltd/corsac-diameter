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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.2	Device-Action AVP
	The Device-Action AVP (AVP code 3001) is of type Grouped. It is used by the SCS to request a specific action for a device.
	AVP Format:
	
	Device-Action ::=                   < AVP Header: 3001 >
			 [ External-Id ]
			 [ MSISDN ]
			 [ SCS-Identity ]
			 { Reference-Number }
			 [ Old-Reference-Number ]
			 { Action-Type }
			 [ Trigger-Data ]
			 [ Validity-Time ]
 			*[ AVP ]
 */
@DiameterAvpDefinition(code = 3001L, vendorId = KnownVendorIDs.TGPP_ID, name = "Device-Action")
public interface DeviceAction extends DiameterGroupedAvp
{
	String getExternalID();
	
	void setExternalID(String value);	
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	ByteBuf getSCSIdentity();
	
	void setSCSIdentity(ByteBuf value);
	
	Long getReferenceNumber();
	
	void setReferenceNumber(Long value);
	
	Long getOldReferenceNumber();
	
	void setOldReferenceNumber(Long value);
	
	ActionTypeEnum getActionType();
	
	void setActionType(ActionTypeEnum value);
	
	TriggerData getTriggerData();
	
	void setTriggerData(TriggerData value);
	
	Long getValidityTime();
	
	void setValidityTime(Long value);
}