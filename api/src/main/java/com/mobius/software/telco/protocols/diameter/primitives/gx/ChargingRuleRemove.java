package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3	Charging-Rule-Remove AVP (All access types)
	The Charging-Rule-Remove AVP (AVP code 1002) is of type Grouped, and it is used to deactivate or remove PCC rules from an IP CAN session.
	Charging-Rule-Name AVP is a reference for a specific PCC rule at the PCEF to be removed or for a specific PCC rule predefined at the PCEF to be deactivated. The Charging-Rule-Base-Name AVP is a reference for a group of PCC rules predefined at the PCEF to be deactivated.
	Required-Access-Info AVP may be included if the AF requests the PCRF to report user access network information and the PCRF is removing PCC rules based on the AF requests.AVP Format.
	If Resource-Release-Notification AVP is included then it applies to all the rules within the Charging-Rule-Remove AVP. If a Charging-Rule-Remove AVP does not include the Resource-Release-Notification AVP, the resource release shall not be notified by the PCEF.

	Charging-Rule-Remove ::= < AVP Header: 1002 >
		*[ Charging-Rule-Name ]
		*[ Charging-Rule-Base-Name ]
		*[ Required-Access-Info ]
		 [ Resource-Release-Notification ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHARGING_RULE_REMOVE, vendorId = VendorIDs.TGPP_ID, name = "Charging-Rule-Remove")
public interface ChargingRuleRemove extends DiameterGroupedAvp
{
	List<ByteBuf> getChargingRuleName();
	
	void setChargingRuleName(List<ByteBuf> value);	
	
	List<String> getChargingRuleBaseName();
	
	void setChargingRuleBaseName(List<String> value);	
	
	List<RequiredAccessInfoEnum> getRequiredAccessInfo();
	
	void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value);	
	
	ResourceReleaseNotificationEnum getResourceReleaseNotification();
	
	void setResourceReleaseNotification(ResourceReleaseNotificationEnum value);	  
}