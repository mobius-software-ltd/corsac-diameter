package com.mobius.software.telco.protocols.diameter.commands.sh;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.7	Push-Notification-Request (PNR) Command
	The Push-Notification-Request (PNR) command, indicated by the Command-Code field set to 309 and the 'R' bit set in the Command Flags field, is sent by a Diameter server to a Diameter client in order to notify changes in the user data in the server.
	Message Format

	< Push-Notification-Request > ::=	< Diameter Header:  309, REQ, PXY, 16777217 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			*[ Supported-Features ]
			 { User-Identity }
			 [ Wildcarded-Public-Identity ]
			 [ Wildcarded-IMPU ]
			 [ User-Name ]
			 { User-Data }
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777217, commandCode = 309, request = true, proxyable = true, name="Push-Notification-Request")
public interface PushNotificationRequest extends ShRequest
{
	public ByteBuf getUserData();
	
	void setUserData(ByteBuf value);
}