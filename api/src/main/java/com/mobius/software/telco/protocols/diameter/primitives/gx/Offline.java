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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.9 Offline AVP (All access types)
	The Offline AVP (AVP code 1008) is of type Enumerated.
	If the Offline AVP is embedded within a Charging-Rule-definition AVP it defines whether the offline charging
	interface from the PCEF for the associated PCC rule shall be enabled. The absence of this AVP within the first
	provisioning of the Charging-Rule-definition AVP of a new PCC rule indicates that the default charging method for
	offline shall be used.
	If the Offline AVP is embedded within the initial CCR on command level, it indicates the default charging method for
	offline pre-configured at the PCEF is applicable as default charging method for offline. The absence of this AVP within
	the initial CCR indicates that the charging method for offline pre-configured at the PCEF is not available.
	If the Offline AVP is embedded within the initial CCA on command level, it indicates the default charging method for
	offline. The absence of this AVP within the initial CCA indicates that the charging method for offline pre-configured at
	the PCEF is applicable as default charging method for offline.
	The default charging method provided by the PCRF shall take precedence over any pre-configured default charging
	method at the PCEF.
	The following values are defined:
	
	DISABLE_OFFLINE (0)
 		This value shall be used to indicate that the offline charging interface for the associated PCC rule shall be
		disabled.
	ENABLE_OFFLINE (1)
 		This value shall be used to indicate that the offline charging interface for the associated PCC rule shall be
		enabled. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.OFFLINE, vendorId = VendorIDs.TGPP_ID, name = "Offline")
public interface Offline extends DiameterEnumerated<OfflineEnum>
{
}