package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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

import java.text.ParseException;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.1.  SIP-Accounting-Information AVP

   	The SIP-Accounting-Information (AVP Code 368) is of type Grouped, and
   	contains the Diameter addresses of those nodes that are able to
   	collect accounting information.

   	The SIP-Accounting-Information AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

    	SIP-Accounting-Information ::= < AVP Header: 368 >
                                   * [ SIP-Accounting-Server-URI ]
                                   * [ SIP-Credit-Control-Server-URI ]
                                   * [ AVP]                             
 */
@DiameterAvpDefinition(code = 368L, vendorId = -1L, name = "SIP-Accounting-Information")
public interface SIPAccountingInformation extends DiameterGroupedAvp
{
	List<String> getSIPAccountingServerURI();
	
	void setSIPAccountingServerURI(List<String> value) throws ParseException;
	
	List<String> getSIPCreditControlServerURI();
	
	void setSIPCreditControlServerURI(List<String> value) throws ParseException;			
}