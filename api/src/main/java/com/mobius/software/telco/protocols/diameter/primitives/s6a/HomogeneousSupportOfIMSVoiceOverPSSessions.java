package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.107	Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions
	The Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions AVP is of type Enumerated. The following values are defined:

	NOT_SUPPORTED (0)
	This value indicates that "IMS Voice over PS Sessions" is not supported, homogeneously, in any of the TAs or RAs associated to the serving node for the served subscribers including consideration on roaming relationship for IMS Voice over PS.

	SUPPORTED (1)
	This value indicates that "IMS Voice over PS Sessions" is supported, homogeneously, in all of the TAs or RAs associated to the serving node for the served subscriber including consideration on roaming relationship for IMS Voice over PS.
	
	If this AVP is not present in the command, it indicates that there is no homogeneous support of IMS Voice Over PS Sessions on all the TA/RAs of the serving node, or that the homogeneity of this support is unknown to the serving node.

	NOTE:	In order to ensure the T-ADS by HPLMN, MME or SGSN is expected to either set "Homogenous Support of IMS Voice over PS Sessions" AVP to "NOT_SUPPORTED (0)", or not to set this AVP for inbound roaming subscribers if there is no IMS Voice over PS roaming relationship with the HPLMN.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.HOMOGENEOUS_SUPPORT_OF_IMS_VOICE_OVER_PS_SESSIONS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions")
public interface HomogeneousSupportOfIMSVoiceOverPSSessions extends DiameterEnumerated<HomogeneousSupportOfIMSVoiceOverPSSessionsEnum>
{
}