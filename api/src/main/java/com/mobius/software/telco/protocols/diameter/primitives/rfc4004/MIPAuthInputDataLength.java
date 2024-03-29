package com.mobius.software.telco.protocols.diameter.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.6.2.  MIP-Auth-Input-Data-Length AVP

   	The MIP-Auth-Input-Data-Length AVP (AVP Code 338) is of type
   	Unsigned32 and contains the length, in bytes, of the Registration
   	Request data (data portion of MIP-Reg-Request AVP) that should be
   	used as input to the algorithm, as indicated by the MN-AAA-SPI AVP,
   	used to determine whether the Authenticator Data supplied by the
   	mobile node is valid..  	   
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_AUTH_INPUT_DATA_LENGTH, vendorId = -1, name = "MIP-Auth-Input-Data-Length")
public interface MIPAuthInputDataLength extends DiameterUnsigned32
{
}