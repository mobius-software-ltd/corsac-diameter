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
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.9	MO-Data-Request (ODR) Command
	The MO-Data-Request (ODR) command, indicated by the Command-Code field set to 8388733 and the "R" bit set in the Command Flags field, is sent from:
		-	the MME or SGSN to the SCEF;
		-	the MME or SGSN to the IWK-SCEF and
		-	the IWK-SCEF to the SCEF.

	For the T6a/b, T6ai/bi, T7 interfaces, the MO-Data-Request command format is specified as following:
	Message Format:

	< MO-Data-Request > ::=   < Diameter Header: 8388733, REQ, PXY, 16777346 >
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
				*[ Supported-Features ]
				 [ Non-IP-Data ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ RRC-Cause-Counter ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777346, commandCode = 8388733, request = true, proxyable = true, name="MO-Data-Request")
public interface MODataRequest extends T6aRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 
	
	ByteBuf getNonIPData();
	
	void setNonIPData(ByteBuf value);
	
	RRCCauseCounter getRRCCauseCounter();
	
	void setRRCCauseCounter(RRCCauseCounter value);
}