package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.5	ProSe-Request-Type AVP
	The ProSe-Request-Type AVP (AVP code 3603) is of type Unsigned32, and contains the reason for sending the PX-Request message or XA-Request message.
	The following values are defined:

	0 (APPLICATION_REGISTRATION_FOR_PROSE):
	The ProXimity-Action-Request message is sent to initiate an application registration for ProSe procedure.

	1 (PROSE_MAP_REQUEST):
	The ProXimity-Action-Request message is sent to initiate a Proximity map request procedure.

	2 (AUTHORIZATION_ANNOUNCE):
	The ProXimity-Action-Request message is sent to initiate an announce authorization procedure for restricted discovery.

	3 (AUTHORIZATION_ANNOUNCE_ACE):
	The ProXimity-Action-Request message is sent to initiate an announce authorization procedure for restricted discovery with application-controlled extension.

	4 (AUTHORIZATION_MONITOR):
	The ProXimity-Action-Request message is sent to initiate a monitor authorization procedure for restricted discovery.

	5 (AUTHORIZATION_MONITOR_ACE):
	The ProXimity-Action-Request message is sent to initiate a monitor authorization procedure for restricted discovery with application-controlled extension.

	6 (MONITOR_PERMISSION):
	The ProXimity-Action-Request message is sent to initiate an inquiry for the discovery permissions between two RPAUIDs used in restricted ProSe direct discovery monitoring model A.

	7 (AUTHORIZATION_RESPONSE):
	The ProXimity-Action-Request message is sent to initiate an authorization for Discoveree Request procedure.
	
	8 (AUTHORIZATION_QUERY):
	The ProXimity-Action-Request message is sent to initiate an authorization for Discoverer Request procedure.

	9 (AUTHORIZATION_MATCH_REPORT):
	The ProXimity-Action-Request message is sent to initiate an authorization for Match Report procedure in model A or model B.

	10 (QUERY_PERMISSION)
	The ProXimity-Action-Request message is sent to initiate an inquiry for the discovery permissions between two RPAUIDs used in restricted ProSe direct discovery model B discoverer operation.

	11 (AUTHORIZATION_UPDATE)
	The ProXimity-Action-Request message or ProXimity-Application-Request message is sent for the purpose of discovery authorization update.

	12 (AUTHORIZATION_ANNOUNCE_ACE_OPEN):
	The ProXimity-Action-Request message is sent to initiate an announce authorization procedure for open discovery with application-controlled extension.

	13 (AUTHORIZATION_MONITOR_ACE_OPEN):
	The ProXimity-Action-Request message is sent to initiate a monitor authorization procedure for open discovery with application-controlled extension.  
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_REQUEST_TYPE, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Request-Type")
public interface ProSeRequestType extends DiameterEnumerated<ProSeRequestTypeEnum>
{
}