package com.mobius.software.telco.protocols.diameter.primitives.eap;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.1.3.  EAP-Master-Session-Key AVP

   The EAP-Master-Session-Key AVP (AVP Code 464) is of type OctetString.
   It contains keying material for protecting the communications between
   the user and the NAS.  Exactly how this keying material is used
   depends on the link layer in question, and is beyond the scope of
   this document.
 */
@DiameterAvpDefinition(code = AvpCodes.EAP_MASTER_SESSION_KEY, vendorId = -1L, name = "EAP-Master-Session-Key")
public interface EAPMasterSessionKey extends DiameterOctetString
{
}