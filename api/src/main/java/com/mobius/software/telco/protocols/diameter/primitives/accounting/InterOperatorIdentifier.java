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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.80	Inter-Operator-Identifier AVP
	The Inter-Operator-Identifier AVP (AVP code 838) is of type Grouped and holds the identification of the network neighbours (originating and terminating) as exchanged via SIP signalling and described in RFC 7315 [404].
	It has the following ABNF grammar:
	
	<Inter-Operator-Identifier>:: =  < AVP Header: 838 >
		[ Originating-IOI ]
		[ Terminating-IOI ]
 */
@DiameterAvpDefinition(code = 838L, vendorId = KnownVendorIDs.TGPP_ID, name = "Inter-Operator-Identifier")
public interface InterOperatorIdentifier extends DiameterAvp
{
	String getOriginatingIOI();
	
	void setOriginatingIOI(String value);
	
	String getTerminatingIOI();
	
	void setTerminatingIOI(String value);
}