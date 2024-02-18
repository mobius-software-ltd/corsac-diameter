package com.mobius.software.telco.protocols.diameter.commands.t4;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.3	Device-Trigger-Request (DTR) Command
	The Device-Trigger-Request (DTR) command, indicated by the Command-Code field set to 8388643 and the "R" bit set in the Command Flags field, is sent from the MTC-IWF to the SMS-SC.
	Message Format

	< Device-Trigger-Request > ::=	< Diameter Header: 8388643, REQ, PXY, 16777311 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Identifier }
				 { SM-RP-SMEA }
				 { Payload }
				 [ Serving-Node ]
				*[ Additional-Serving-Node ]
				 [ Reference-Number ]
				 [ Validity-Time ]
				 [ Priority-Indication ]
				 [ SMS-Application-Port-ID ]
				 [ Old-Reference-Number ]
				 [ Trigger-Action ]
				*[ Supported-Features ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.T4, commandCode = CommandCodes.DEVICE_TRIGGER, request = true, proxyable = true, name="Device-Trigger-Request")
public interface DeviceTriggerRequest extends T4Request
{
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value) throws MissingAvpException;
	
	ByteBuf getSMRPSMEA();
	
	void setSMRPSMEA(ByteBuf value) throws MissingAvpException;
	 		
	ByteBuf getPayload();
	
	void setPayload(ByteBuf value) throws MissingAvpException;
	
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
	
	List<AdditionalServingNode> getAdditionalServingNode();
	 
	void setAdditionalServingNode(List<AdditionalServingNode> value);
	
	Long getReferenceNumber();
	
	void setReferenceNumber(Long value);
	
	Long getValidityTime();
	
	void setValidityTime(Long value);	
	
	PriorityIndicationEnum getPriorityIndication();
	
	void setPriorityIndication(PriorityIndicationEnum value);	
	
	Long getSMSApplicationPortID();
	
	void setSMSApplicationPortID(Long value);	
	
	Long getOldReferenceNumber();
	
	void setOldReferenceNumber(Long value);	
	
	TriggerActionEnum getTriggerAction();
	
	void setTriggerAction(TriggerActionEnum value);		
}