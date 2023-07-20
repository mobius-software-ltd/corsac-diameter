package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * The Redirect-Server AVP is defined as follows (per grouped-avp-def as
   defined in [RFC6733]):

         Redirect-Server ::= < AVP Header: 434 >
                             { Redirect-Address-Type }
                             { Redirect-Server-Address }
 */
@DiameterAvpDefinition(code = 434L, vendorId = -1, name = "Redirect-Server")
public interface RedirectServer extends DiameterAvp 
{
	RedirectAddressTypeEnum getRedirectAddressType();
	
	void setRedirectAddressType(RedirectAddressTypeEnum redirectAddressType);
	
	String getRedirectServerAddress();
	
	void setRedirectServerAddress(String redirectServerAddress);
}