package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/* 	3.1.3 Other-Party-Id AVP
	The Other-Party-Id AVP (AVP code 1075) holds an identifier of the other party
	involved in a session in addition to the Subscription-Id. The other party is
	related to the session but not charged for the session. The other party could
	be for example a calling party, a called party, a redirecting party, a sender or a
	receiver; depending on service. The Other-Party-Id AVP is a grouped AVP as
	specified below.

	Other-Party-Id ::= < AVP Header: 1075, Vendor Id: 193 >
		{ Other-Party-Id-Type }
		{ Other-Party-Id-Data }
		[ Other-Party-Id-Nature ]
		*[ AVP ]
		
	The Other-Party-Id AVP is in this service context defined as ‘static’ and ‘cached’.
	The serving element is not allowed to use the *[AVP] part of the Other-Party-Id
	since it’s reserved for internal use within the Service.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.OTHER_PARTY_ID, vendorId = VendorIDs.ERICSSON_ID, name = "Other-Party-Id")
public interface OtherPartyId extends DiameterGroupedAvp 
{
	OtherPartyIdTypeEnum getOtherPartyIdType();
	
	void setOtherPartyIdType(OtherPartyIdTypeEnum value) throws MissingAvpException;
	
	String getOtherPartyIdData();
	
	void setOtherPartyIdData(String value) throws MissingAvpException;
	
	OtherPartyIdNatureEnum getOtherPartyIdNature();
	
	void setOtherPartyIdNature(OtherPartyIdNatureEnum value);
}