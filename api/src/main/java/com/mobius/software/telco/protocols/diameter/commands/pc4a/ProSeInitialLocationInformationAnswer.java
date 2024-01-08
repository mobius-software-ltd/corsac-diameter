package com.mobius.software.telco.protocols.diameter.commands.pc4a;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeInitialLocationInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.12	ProSe-Initial-Location-Information-Answer (PSA) Command
	The ProSe-Initial-Location-Information-Answer (PSA) command, indicated by the Command-Code field set to 8388713 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the ProSe Function. 
	Message Format

	< ProSe-Subscriber-Information-Answer > ::=	< Diameter Header: 8388713, PXY, 16777336 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ ProSe-Initial-Location-Information ]
			 [ Visited-PLMN-Id ]
			*[ Supported-Features ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777336, commandCode = 8388713, request = false, proxyable = true, name="ProSe-Subscriber-Information-Answer")
public interface ProSeInitialLocationInformationAnswer extends Pc4aAnswer
{
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);

	ProSeInitialLocationInformation getProSeInitialLocationInformation();
	 
	void setProSeInitialLocationInformation(ProSeInitialLocationInformation value);
	 		
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
}