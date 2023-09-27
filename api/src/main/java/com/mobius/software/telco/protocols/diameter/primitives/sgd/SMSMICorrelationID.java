package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.3.13	SMSMI-Correlation-ID
	The SMSMI-Correlation-ID AVP is of type Grouped. It shall contain information identities used in the context of MSISDN-less SMS delivery in IMS (see 3GPP TS 23.204 [17]).
	The AVP format shall conform to:
	
	SMS-MI-Correlation-ID  ::= <AVP header: 3324 10415>
		 [ HSS-ID ]
		 [ Originating-SIP-URI ]
		 [ Destination-SIP-URI ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 3324L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "SMS-MI-Correlation-ID")
public interface SMSMICorrelationID extends DiameterGroupedAvp
{
	String getHSSID();
	
	void setHSSID(String value);	
	
	String getOriginatingSIPURI();
	
	void setOriginatingSIPURI(String value);
	
	String getDestinationSIPURI();
	
	void setDestinationSIPURI(String value);
}