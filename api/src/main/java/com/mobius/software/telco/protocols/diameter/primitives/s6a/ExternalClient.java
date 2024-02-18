package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.90	External-Client
	The External-Client AVP is of type Grouped. This AVP shall contain the identities of the external clients that are allowed to locate a target UE for a MT-LR.
	AVP format

	External-Client ::= <AVP header: 1479 10415>
			 { Client-Identity }
			 [ GMLC-Restriction ]
			 [ Notification-To-UE-User ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EXTERNAL_CLIENT, vendorId = VendorIDs.TGPP_ID, name = "External-Client")
public interface ExternalClient extends DiameterGroupedAvp
{
	String getClientIdentity();
	
	void setClientIdentity(String value) throws MissingAvpException;	
	
	GMLCRestrictionEnum getGMLCRestriction();
	
	void setGMLCRestriction(GMLCRestrictionEnum value);
	
	NotificationToUEUserEnum getNotificationToUEUser();
	
	void setNotificationToUEUser(NotificationToUEUserEnum value);	
}