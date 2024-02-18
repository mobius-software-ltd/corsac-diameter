package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.36	SIP-Digest-Authenticate AVP
	The SIP-Digest-Authenticate is of type Grouped and it contains a reconstruction of either the SIP WWW-Authenticate or Proxy-Authentication header fields specified in IETF RFC 7616 [29].
	AVP format

		SIP-Digest-Authenticate ::= < AVP Header: 635 10415>
			{ Digest-Realm }
		 	[ Digest-Algorithm ]
			{ Digest-QoP }
			{ Digest-HA1}
			[ Alternate-Digest-Algorithm ]
			[ Alternate-Digest-HA1 ]
		   *[ AVP ]   
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SIP_DIGEST_AUTHENTICATE, vendorId = VendorIDs.TGPP_ID, must = false, name = "SIP-Digest-Authenticate")
public interface SIPDigestAuthenticate extends DiameterGroupedAvp
{
	String getDigestRealm();
	
	void setDigestRealm(String value) throws MissingAvpException;	
	
	String getDigestAlgorithm();
	
	void setDigestAlgorithm(String value);
	
	String getDigestQoP();
	
	void setDigestQoP(String value);		
	
	String getDigestHA1();
	
	void setDigestHA1(String value);		
	
	String getAlternateDigestAlgorithm();
	
	void setAlternateDigestAlgorithm(String value);
	
	String getAlternateDigestHA1();
	
	void setAlternateDigestHA1(String value);
}