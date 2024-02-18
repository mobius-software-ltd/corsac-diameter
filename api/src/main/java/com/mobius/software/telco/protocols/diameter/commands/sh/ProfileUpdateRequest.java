package com.mobius.software.telco.protocols.diameter.commands.sh;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;

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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.3	Profile-Update-Request (PUR) Command
	The Profile-Update-Request (PUR) command, indicated by the Command-Code field set to 307 and the 'R' bit set in the Command Flags field, is sent by a Diameter client to a Diameter server in order to update user data in the server.
	Message Format

	< Profile-Update-Request > ::=	< Diameter Header: 307, REQ, PXY, 16777217 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			*[ Supported-Features ]
			 { User-Identity }
			 [ Wildcarded-Public-Identity ]
			 [ Wildcarded-IMPU ]
			 [ User-Name ]
			*{ Data-Reference }
			 { User-Data }
			 [ OC-Supported-Features ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]

	NOTE:	More than one Data-Reference AVP may be present in the message only if both the AS and the HSS support the Update-Eff-Enhance feature. How the AS knows whether the HSS supports the Update-Eff-Enhance feature is implementation issue, e.g. the AS can get the information from a previous PUA message.
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SH, commandCode = CommandCodes.PROFILE_UPDATE, request = true, proxyable = true, name="Profile-Update-Request")
public interface ProfileUpdateRequest extends ShRequest
{
	public List<DataReferenceEnum> getDataReference();
	 
	void setDataReference(List<DataReferenceEnum> value) throws MissingAvpException;
	
	public ByteBuf getUserData();
	
	void setUserData(ByteBuf value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	
}