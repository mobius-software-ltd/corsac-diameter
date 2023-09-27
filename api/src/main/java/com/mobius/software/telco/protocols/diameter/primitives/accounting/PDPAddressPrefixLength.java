package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.137A PDP-Address-Prefix-Length AVP
	The PDP-Address-Prefix-Length AVP (AVP code 2606) is of type Unsigned32 and contains the prefix length of an
	IPv6 typed PDP-Address AVP. The omission of this AVP for an IPv6 typed IP address implicitly means prefix length
	of 64 bits, as in this case the 64 bit prefix length default shall be assumed. 
 */
@DiameterAvpDefinition(code = 2606L, vendorId = KnownVendorIDs.TGPP_ID, name = "PDP-Address-Prefix-Length")
public interface PDPAddressPrefixLength extends DiameterUnsigned32
{
}