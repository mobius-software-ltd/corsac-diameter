package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
 * 	17.7.5	MBMS-StartStop-Indication AVP
	The MBMS-StartStop-Indication AVP (AVP code 902) is of type Enumerated. The following values are supported:

	START (0)
	The message containing this AVP is indicating an MBMS session start procedure.

	STOP	(1)
	The message containing this AVP is indicating an MBMS session stop procedure.

	UPDATE (2)
	The message containing this AVP i.s indicating an MBMS session update procedure.

	HEARTBEAT (3)
	The message containing this AVP is indicating an MBMS heartbeat procedure.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_START_STOP_INDICATOR, vendorId = VendorIDs.TGPP_ID, name = "MBMS-StartStop-Indication")
public interface MBMSStartStopIndication extends DiameterEnumerated<MBMSStartStopIndicationEnum>
{
}