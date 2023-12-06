package com.mobius.software.telco.protocols.diameter.commands.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataDeletion;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.15	Reset-Request (RSR) Command
	The Reset-Request (RSR) command, indicated by the Command-Code field set to 322 and the 'R' bit set in the Command Flags field, is sent from HSS or CSS to MME or SGSN.
	Message Format when used over the S6a/S6d application:

	< Reset-Request> ::=	< Diameter Header: 322, REQ, PXY, 16777251 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 { Destination-Host }
					 { Destination-Realm }
					*[ Supported-Features ]
					*[ User-Id ]
					*[ Reset-ID ]
					 [ Subscription-Data ]
					 [ Subscription-Data-Deletion ]
					*[ AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 322, request = true, proxyable = true, name="Reset-Request")
public interface ResetRequest extends S6aRequest
{
	List<String> getUserId();
	 
	void setUserId(List<String> value);
	
	List<ByteBuf> getResetID();
	 
	void setResetID(List<ByteBuf> value);
	
	SubscriptionData getSubscriptionData();
	 
	void setSubscriptionData(SubscriptionData value);
		
	SubscriptionDataDeletion getSubscriptionDataDeletion();
	 
	void setSubscriptionDataDeletion(SubscriptionDataDeletion value);	
}