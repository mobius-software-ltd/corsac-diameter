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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.UPRFlags;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.5	Update-ProSe-Subscriber-Data-Request (UPR) Command
	The Update-ProSe Subscriber Data-Request (UPR) command, indicated by the Command-Code field set to 8388665 and the 'R' bit set in the Command Flags field, is sent from the HSS to the ProSe Function. 
	Message Format when used over the PC4a application:

	< Update-ProSe-Subscriber-Data-Request > ::=	< Diameter Header: 8388665, REQ, PXY, 16777336 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			 { User-Name }
			*[ Supported-Features ]
			 [ ProSe Subscription-Data ]
			 [ Visited-PLMN-Id ]
			 { UPR-Flags }
			*[ Reset-ID ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777336, commandCode = 8388665, request = true, proxyable = true, name="Update-ProSe-Subscriber-Data-Request")
public interface UpdateProSeSubscriberDataRequest extends Pc4aRequest
{
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);

	ProSeSubscriptionData getProSeSubscriptionData();
	 
	void setProSeSubscriptionData(ProSeSubscriptionData value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
		
	UPRFlags getUPRFlags();
	
	void setUPRFlags(UPRFlags value);
	
	List<ByteBuf> getResetID();
	 
	void setResetID(List<ByteBuf> value);			 
}