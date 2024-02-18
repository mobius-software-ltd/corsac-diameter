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
 * 	7.2.235	Trigger AVP
	The Trigger AVP (AVP code 1264) is of type Grouped and holds the trigger types. The presence of the Trigger AVP without any Trigger-Type AVP in a CCA allows OCS to disable all the triggers. The presence of the Trigger AVP in the CCR identifies the event(s) triggering the CCR.
	It has the following ABNF grammar:
	
	Trigger  :: = < AVP Header: 1264 >
 		* [ Trigger-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TRIGGER, vendorId = VendorIDs.TGPP_ID, name = "Trigger")
public interface Trigger extends DiameterAvp
{
	List<TriggerTypeEnum> getTriggerType();
	
	void setTriggerType(List<TriggerTypeEnum> value);
}