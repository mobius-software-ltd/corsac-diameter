package com.mobius.software.telco.protocols.diameter.primitives.e4;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.23 QoS-Profile-ID AVP
	The QoS-Profile-ID AVP (AVP code 315 13019) is of type Unsigned32 and contains a pointer to a pre-defined set of
	QoS profile information. 
 */
@DiameterAvpDefinition(code = 315L, vendorId = KnownVendorIDs.ETSI_ID, must = false, name = "QoS-Profile-ID")
public interface QoSProfileID extends DiameterUTF8String
{
}