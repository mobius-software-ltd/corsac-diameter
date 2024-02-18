package com.mobius.software.telco.protocols.diameter.primitives.accounting;
import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
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
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.216 Stop-Time AVP
	The Stop-Time AVP (AVP Code 2042) is of type Time and holds the time in UTC format which represents the
	termination of a user session at the S-GW/P-GW or the termination of a voice call in the MSC. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.STOP_TIME, vendorId = VendorIDs.TGPP_ID, name = "Stop-Time")
public interface StopTime extends DiameterTime
{
}