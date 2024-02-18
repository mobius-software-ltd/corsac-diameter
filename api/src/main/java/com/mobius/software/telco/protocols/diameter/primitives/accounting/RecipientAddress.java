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
 * 	7.2.167	Recipient-Address AVP
	The Recipient-Address AVP (AVP code 1201) is of type Grouped. Its purpose is to identify the recipient of a message.
	It has the following ABNF grammar:

	Recipient-Address :: = 	< AVP Header: 1201 >
		[ Address-Type ]
		[ Address-Data ]
		[ Address-Domain ]
		[ Addressee-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RECEPIENT_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "Recipient-Address")
public interface RecipientAddress extends DiameterAvp
{
	AddressTypeEnum getAddressType();
	
	void setAddressType(AddressTypeEnum value);
	
	String getAddressData();
	
	void setAddressData(String value);
	
	AddressDomain getAddressDomain();
	
	void setAddressDomain(AddressDomain value);
	
	AddresseeTypeEnum getAddresseeType();
	
	void setAddresseeType(AddresseeTypeEnum value);
}