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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.11	MT-Data-Request (TDR) Command
	The MT-Data-Request (TDR) command, indicated by the Command-Code field set to 8388734 and the "R" bit set in the Command Flags field, is sent from:
			-	the SCEF to the MME or SGSN;
			-	the SCEF to the IWK-SCEF and
			-	the IWK-SCEF to the MME or SGSN.

	For the T6a/b, T6ai/bi, T7 interfaces, the MT-Data-Request command format is specified as following:
	Message Format:

	< MT-Data-Request > ::=   < Diameter Header: 8388734, REQ, PXY, 16777346 >
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
					 [ SCEF-Wait-Time ]
					 [ Maximum-Retransmission-Time ]
					*[ Proxy-Info ]
					*[ Route-Record ]
					*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777346, commandCode = 8388734, request = true, proxyable = true, name="MT-Data-Request")
public interface MTDataRequest extends T6aRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value);
	
	ByteBuf getBearerIdentifier();
	
	void setBearerIdentifier(ByteBuf value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 
	
	ByteBuf getNonIPData();
	
	void setNonIPData(ByteBuf value);
	
	Date getSCEFWaitTime();
	
	void setSCEFWaitTime(Date value);
	
	Date getMaximumRetransmissionTime();
	
	void setMaximumRetransmissionTime(Date value);	
}