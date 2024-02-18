package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.5	SCEF-ID
	The SCEF- ID AVP is of type DiameterIdentity and it shall contain the identity of the SCEF which has originated the service request towards the HSS, i.e. when sent within a Monitoring-Event-Configuration AVP in S6t-CIR, SCEF-ID AVP and Origin-Host AVP shall have the same value.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SCEF_ID, vendorId = VendorIDs.TGPP_ID, name = "SCEF-ID")
public interface SCEFID extends DiameterIdentity
{
}