package com.mobius.software.telco.protocols.diameter.primitives.cip;

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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/*	
  	4.4.5 CIP-IP-Version AVP
	The CIP-IP-Version AVP (AVP Code 1083) is of type UTF8String and is used to
	indicate the version of the CIP-IP protocol used. Omitting the AVP indicates
	that the first version, “R1A”, of CIP-IP is being used.
	A receiver of this AVP shall check that the received value represents a
	supported version of the protocol.
	If the receiver is a CIP-IP server (i.e. the SDP) the same version shall be used
	in the response.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.CIP_IP_VERSION, vendorId = VendorIDs.ERICSSON_ID, name = "CIP-IP-Version")
public interface CIPIPVersion extends DiameterUTF8String
{
	
}