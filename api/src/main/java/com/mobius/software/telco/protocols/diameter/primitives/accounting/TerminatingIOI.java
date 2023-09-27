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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.225 Terminating-IOI AVP
	The Terminating-IOI AVP (AVP code 840) is of type UTF8String (alphanumeric string) and holds the Inter Operator
	Identifier (IOI) for the terminating network as generated by the IMS Network Element which takes responsibility for
	populating this parameter in a SIP response as described in RFC 7315 [404] and TS 24.229 [202].
	The Terminating IOI contains the following values:

	Type 1 IOI
	- IOI of the home network where the S-CSCF is located for SIP responses directed to
	the P-CSCF in the visited network when request was initiated by the served user
	- IOI of the visited network where the TRF is located for SIP responses directed to
	the S-CSCF in the home network when request was initiated by the served user and "VPLMN routing" is applied
	in a Roaming Architecture for Voice over IMS with Local breakout.
	- IOI of the visited network where the P-CSCF is located for SIP responses directed to
	the S-CSCF in the home network when request was terminated at the served user.

	Type 2 IOI 
	- IOI of the home network of the terminating end user where the S-CSCF is located in case a
	session is initiated toward the IMS. In case of redirection by the S-CSCF, Terminating-IOI AVP indicates the
	terminating party's network operator to which the session is redirected.
	- IOI of the terminating network where the MGCF is located in case a session is initiated from the IMS toward
	the PSTN.

	Type 3 IOI
	- IOI of the service provider network (originating side or terminating side) where the AS (proxy, terminating
	UA or redirect server or B2BUA) is located when receiving a SIP request as described in TS 24.229 [202].
	- IOI of the home network operator contacted by an AS when an AS (originating UA or B2BUA) initiates a
	SIP request as described in TS 24.229 [202].

	For further details on the Type 1, Type 2 and Type 3 IOIs, please refer to TS 32.240 [1]. 
 */
@DiameterAvpDefinition(code = 840L, vendorId = KnownVendorIDs.TGPP_ID, name = "Terminating-IOI")
public interface TerminatingIOI extends DiameterUTF8String
{
}