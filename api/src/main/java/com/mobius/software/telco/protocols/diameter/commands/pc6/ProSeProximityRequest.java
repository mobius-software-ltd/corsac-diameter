package com.mobius.software.telco.protocols.diameter.commands.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateTrigger;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.11	ProSe-Proximity-Request (PRR) Command
	The ProSe-Proximity-Request (PRR) Command, indicated by the Command-Code field set to 8388672 and the "R" bit set in the Command Flags field, is sent from the ProSe Function in the HPLMN to the ProSe Function of another PLMN.
	Message Format

	< ProSe-Proximity-Request > ::=	< Diameter Header: 8388672, REQ, PXY, 16777340 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 { PRR-Flags }
			 { Requesting-EPUID }
			 { Targeted-EPUID }
			 { Time-Window }
			 { Location-Estimate }
			 [ Location-Update-Trigger ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777340, commandCode = 8388672, request = true, proxyable = true, name="ProSe-Proximity-Request")
public interface ProSeProximityRequest extends Pc6Request
{
	Long getPRRFlags();
	
	void setPRRFlags(Long value);
	
	String getRequestingEPUID();
	
	void setRequestingEPUID(String value);
	
	String getTargetedEPUID();
	
	void setTargetedEPUID(String value);
	
	Long getTimeWindow();
	
	void setTimeWindow(Long value);
		
	ByteBuf getLocationEstimate();
	
	void setLocationEstimate(ByteBuf value);
	
	LocationUpdateTrigger getLocationUpdateTrigger();
	
	void setLocationUpdateTrigger(LocationUpdateTrigger value);
}