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

import java.util.List;

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
 * 	7.2.171Ab	Related-Trigger AVP
	The Related-Trigger AVP (AVP code 3926) is of type Grouped and holds the trigger types for a related trigger for another access in a multi-access PDN connection. This AVP is only included when the Trigger AVP contains a Trigger-Type AVP with value of "indirect change condition" which is applicable charging per IP can session for a multi-accessPDN connection.
	It has the following ABNF grammar:
	
	Related-Trigger  :: = < AVP Header: 3926 >
 		* [ Trigger-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RELATED_TRIGGER, vendorId = VendorIDs.TGPP_ID, name = "Related-Trigger")
public interface RelatedTrigger extends DiameterAvp
{
	List<TriggerTypeEnum> getTriggerType();
	
	void setTriggerType(List<TriggerTypeEnum> value);
}