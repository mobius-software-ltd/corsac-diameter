package com.mobius.software.telco.protocols.diameter.commands.s6m;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceIDEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceParameters;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.3	Subscriber-Information-Request (SIR) Command
	The Subscriber-Information-Request (SIR) command, indicated by the Command-Code field set to 8388641 and the "R" bit set in the Command Flags field, is sent from the MTC-IWF to the HSS or from the MTC-AAA to the HSS.
	Message Format:

	< Subscriber-Information-Request> ::=	< Diameter Header: 8388641, REQ, PXY, 16777310 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Identifier }
				 [ Service-ID ]
				 [ SCS-Identity ]
				 [ Service-Parameters ]
				 { SIR-Flags }
				 [ OC-Supported-Features ]
				*[ Supported-Features ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777310, commandCode = 8388641, request = true, proxyable = true, name="Subscriber-Information-Request")
public interface SubscriberInformationRequest extends S6mRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	ServiceIDEnum getServiceID();
	
	void setServiceID(ServiceIDEnum value);
	
	ByteBuf getSCSIdentity();
	
	void setSCSIdentity(ByteBuf value);	
	
	ServiceParameters getServiceParameters();
	
	void setServiceParameters(ServiceParameters value);	
	
	SIRFlags getSIRFlags();
	
	void setSIRFlags(SIRFlags value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 			
}