package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.3.26	TWAN-Connectivity-Parameters
	The TWAN-Connectivity-Parameters AVP is of type Grouped.
	AVP Format:

	TWAN-Connectivity-Parameters ::=	< AVP Header: 1528 10415 >
			[ Connectivity-Flags ]
			[ Service-Selection ]
			[ PDN-Type ]
		* 2 [ Served-Party-IP-Address ]
		 	[ TWAN-PCO ]
		 	[ TWAG-UP-Address ]
		 	[ TWAN-S2a-Failure-Cause ]
		 	[ SM-Back-Off-Timer ]
		*	[ AVP ]

	The Service-Selection AVP indicates the APN requested by the UE (requested connectivity parameters) or the APN selected by the TWAN (provided connectivity parameters). It shall contain both the network identifier part and the operator identifier part of the Access Point Name.
	The PDN-Type AVP indicates the PDN type requested by the UE (requested connectivity parameters) or the PDN type allocated by the network (provided connectivity parameter). It may be set to IPv4, IPv6 or IPv4v6.
	The UE's Served-Party-IP-Address AVP may be present 0, 1 or 2 times. These AVPs shall be present if the S2a connection was successfully established, and they shall contain either of:
	-	an IPv4 address, or
	-	an IPv6 interface identifier, or
	-	both, an IPv4 address and an IPv6 interface identifier.

	For the IPv6 interface identifier, the higher 64 bits of the address shall be set to zero.
	The TWAN-S2a-Failure-Cause AVP may be present to indicate the cause of S2a connectivity establishment failure.
	The SM-Back-Off-Timer AVP may be present to provide a Session Management back-off timer to be sent to the UE. The exact value of the SM-Back-Off-Timer is operator dependant.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TWAN_CONNECTIVITY_PARAMETERS, vendorId = VendorIDs.TGPP_ID, must = false, name = "TWAN-Connectivity-Parameters")
public interface TWANConnectivityParameters extends DiameterGroupedAvp
{
	ConnectivityFlags getConnectivityFlags();
	
	void setConnectivityFlags(ConnectivityFlags value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);
	
	PDNTypeEnum getPDNType();
	
	void setPDNType(PDNTypeEnum value);
	
	List<InetAddress> getServedPartyIPAddress();
	
	void setServedPartyIPAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	ByteBuf getTWANPCO();
	
	void setTWANPCO(ByteBuf value);
	
	String getTWAGUPAddress();
	
	void setTWAGUPAddress(String value);
	
	Long getTWANS2aFailureCause();
	
	void setTWANS2aFailureCause(Long value);
	
	Long getSMBackOffTimer();
	
	void setSMBackOffTimer(Long value);
}