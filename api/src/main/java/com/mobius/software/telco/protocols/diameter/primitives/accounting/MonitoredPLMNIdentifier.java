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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.111Aa Monitored-PLMN-Identifier AVP
	The Monitored-PLMN-Identifier AVP (AVP code 3430) is of type UTF8String and carries Monitored PLMN ID in
	MATCH_REPORT request. It corresponds to the Announcing UE VPLMN Identifier when roaming and Announcing
	UE HPLMN Identifier when non-roaming. It is referred to as "Monitored PLMN ID” in TS 23.303 [235]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MONITORING_PLMN_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "Monitored-PLMN-Identifier")
public interface MonitoredPLMNIdentifier extends DiameterUTF8String
{
}