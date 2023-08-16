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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.10 Online AVP (All access types)
	The Online AVP (AVP code 1009) is of type Enumerated.
	If the Online AVP is embedded within a Charging-Rule-definition AVP, it defines whether the online charging interface
	from the PCEF for the associated PCC rule shall be enabled. The absence of this AVP within the first provisioning of
	the Charging-Rule-Definition AVP of a new PCC rule indicates that the default charging method for online shall be
	used.
	If the Online AVP is embedded within the initial CCR on command level, it indicates the default charging method for
	online pre-configured at the PCEF is applicable as default charging method for online. The absence of this AVP within
	the initial CCR indicates that the charging method for online pre-configured at the PCEF is not available.
	If the Online AVP is embedded within the initial CCA on command level, it indicates the default charging method for
	online. The absence of this AVP within the initial CCA indicates that the charging method for online pre-configured at
	the PCEF is applicable as default charging method for online.
	The default charging method provided by the PCRF shall take precedence over any pre-configured default charging
	method at the PCEF.
	The following values are defined:

	DISABLE_ONLINE (0)
 		This value shall be used to indicate that the online charging interface for the associated PCC rule shall be
		disabled.
	ENABLE_ONLINE (1)
 		This value shall be used to indicate that the online charging interface for the associated PCC rule shall be
		enabled.
 * 
 */
@DiameterAvpDefinition(code = 1009L, vendorId = KnownVendorIDs.TGPP_ID, name = "Online")
public interface Online extends DiameterEnumerated<OnlineEnum>
{
}