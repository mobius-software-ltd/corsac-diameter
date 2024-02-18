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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 7.6.  MIP-MN-AAA-Auth AVP

   The MN-AAA-Auth AVP (AVP Code 322) is of type Grouped and contains
   some ancillary data to simplify processing of the authentication data
   in the Mobile IPv4 Registration Request [MOBILEIP, MIPCHAL] by the
   target AAA server.  Its value has the following ABNF grammar:

         MIP-MN-AAA-Auth ::= < AVP Header: 322 >
                             { MIP-MN-AAA-SPI }
                             { MIP-Auth-Input-Data-Length }
                             { MIP-Authenticator-Length }
                             { MIP-Authenticator-Offset }
                           * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_MN_AA_AUTH, vendorId = -1L, name = "MIP-MN-AAA-Auth")
public interface MIPMNAAAAuth extends DiameterGroupedAvp
{
	Long getMIPMNAAASPI();
	
	void setMIPMNAAASPI(Long value) throws MissingAvpException;	
	
	Long getMIPAuthInputDataLength();
	
	void setMIPAuthInputDataLength(Long value) throws MissingAvpException;	
	
	Long getMIPAuthenticatorLength();
	
	void setMIPAuthenticatorLength(Long value) throws MissingAvpException;	
	
	Long getMIPAuthenticatorOffset();
	
	void setMIPAuthenticatorOffset(Long value) throws MissingAvpException;	
}