package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.3.18	Requested-Retransmission-Time
	The Requested-Retransmission-Time is of type Time and in shall contain the timestamp (in UTC) at which the SMS-GMSC is requested to retransmit the MT Short Message.
 */
@DiameterAvpDefinition(code = 3331L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Requested-Retransmission-Time")
public interface RequestedRetransmissionTime extends DiameterTime
{
}