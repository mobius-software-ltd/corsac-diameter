package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.3.25	TWAN-Connection-Mode
	The TWAN-Connection-Mode AVP (AVP Code 1527) is of type Unsigned32 and it shall contain a 32 bit flags field which is used to indicate the connection modes supported by the TWAN (when this AVP is used in the request commands) and the selected TWAN connection mode the 3GPP AAA Server has authorized (when this AVP is used in the response commands).
	Table 5.2.3.25/1: TWAN-Connection-Mode

	Bit Name
	Description

	0 TSC-MODE
	This bit, when set by the TWAN, indicates to the 3GPP AAA Server that the TWAN supports the TSCM.

	1 SC-MODE
	This bit, when set by the TWAN, indicates to the 3GPP AAA Server that the TWAN supports the SCM.
	This bit, when set by the 3GPP AAA Server, indicates to the TWAN that the SCM shall be used.

	2 MC-MODE
	This bit, when set by the TWAN, indicates to the 3GPP AAA Server that the TWAN supports the MCM.
	This bit, when set by the 3GPP AAA Server, indicates to the TWAN that the MCM shall be used.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TWAN_CONNECTION_MODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "TWAN-Connection-Mode")
public interface TWANConnectionMode extends DiameterUnsigned32
{
}