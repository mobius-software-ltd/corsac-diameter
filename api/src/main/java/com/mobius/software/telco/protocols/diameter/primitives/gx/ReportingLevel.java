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
 * 	5.3.12 Reporting-Level AVP (All access types)
	The Reporting-Level AVP (AVP code 1011) is of type Enumerated, and it defines on what level the PCEF reports the
	usage for the related PCC rule. The following values are defined:

	SERVICE_IDENTIFIER_LEVEL (0)
		This value shall be used to indicate that the usage shall be reported on service id and rating group combination
		level, and is applicable when the Service-Identifier and Rating-Group have been provisioned within the
		Charging-Rule-Definition AVP.
	RATING_GROUP_LEVEL (1)
 		This value shall be used to indicate that the usage shall be reported on rating group level, and is applicable when
		the Rating-Group has been provisioned within the Charging-Rule-Definition AVP.
	SPONSORED_CONNECTIVITY_LEVEL (2)
		This value shall be used to indicate that the usage shall be reported on sponsor identity and rating group
		combination level, and is applicable when the Sponsor-IdentityAVP, Application-Service-Provider-Identity AVP
		and Rating-Group AVP have been provisioned within the Charging-Rule-Definition AVP. Applicable for offline
		charging.
		If the Reporting-Level AVP is omitted but has been supplied previously, the previous information remains valid. If the
		Reporting-Level AVP is omitted and has not been supplied previously, the reporting level pre-configured at the PCEF is
		applicable as default reporting level. 
 */
@DiameterAvpDefinition(code = 1011L, vendorId = KnownVendorIDs.TGPP_ID, name = "Reporting-Level")
public interface ReportingLevel extends DiameterEnumerated<ReportingLevelEnum>
{
}