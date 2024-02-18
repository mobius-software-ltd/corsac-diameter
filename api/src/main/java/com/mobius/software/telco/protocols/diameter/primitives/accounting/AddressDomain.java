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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.8	Address-Domain AVP
	The Address-Domain AVP (AVP code 898) is of type Grouped and indicates the domain/network to which the associated address resides. If this AVP is present, at least one of the AVPs described within the grouping shall be included.
	It has the following ABNF:

	Address-Domain :: =  < AVP Header: 898 >
			[ Domain-Name ]
			[ 3GPP-IMSI-MCC-MNC ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADDRESS_DOMAIN, vendorId = VendorIDs.TGPP_ID, name = "Address-Domain")
public interface AddressDomain extends DiameterAvp
{
	String getDomainName();
	
	void setDomainName(String value);
	
	String getTGPPIMSIMCCMNC();
	
	void setTGPPIMSIMCCMNC(String value);
}