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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.6	Subscribe-Notifications-Answer (SNA) Command
	The Subscribe-Notifications-Answer command, indicated by the Command-Code field set to 308 and the 'R' bit cleared in the Command Flags field, is sent by a server in response to the Subscribe-Notifications-Request command. The Result-Code or Experimental-Result AVP may contain one of the values defined in clause 6.2 or in 3GPP TS 29.229 [6].
	Message Format

	< Subscribe-Notifications-Answer > ::=	< Diameter Header: 308, PXY, 16777217 >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Auth-Session-State }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Origin-Host }
				 { Origin-Realm }
				 [ Wildcarded-Public-Identity ]
				 [ Wildcarded-IMPU ]
				*[ Supported-Features ]
				 [ User-Data ]
				 [ Expiry-Time ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
*/
@DiameterCommandDefinition(applicationId = ApplicationIDs.SH, commandCode = CommandCodes.SUBSCRIBE_NOTIFICATION, request = false, proxyable = true, name="Subscribe-Notifications-Answer")
public interface SubscribeNotificationsAnswer extends ShAnswer
{
	public String getWildcardedPublicIdentity();
	
	void setWildcardedPublicIdentity(String value);

	public String getWildcardedIMPU();
	
	void setWildcardedIMPU(String value);
	
	public ByteBuf getUserData();
	
	void setUserData(ByteBuf value);
	
	Date getExpiryTime();
	
	void setExpiryTime(Date value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	 		
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);		
}