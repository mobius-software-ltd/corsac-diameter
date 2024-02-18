package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
	7.4.55	Termination-Cause
	The Termination-Cause AVP is of type Unsigned32. The following values are defined:

	"Normal"		0
	"Error Undefined"		1
	"Internal Timeout"		2
	"Congestion"		3
	"MT_LR_Restart"		4
	"Privacy Violation"		5
	"Shape of Location Estimate Not Supported"	6
	"Subscriber Termination"	7
	"UE Termination"		8
	"Network Termination"	9
	"MT_LR_Restart" cause code shall be used to trigger the GMLC to restart the location procedure, either because the sending node knows that the terminal has moved under coverage of another SGSN or MME, or because the subscriber has been deregistered due to a Cancel Location received from HSS.
	Any unrecognized value of Termination-Cause shall be treated the same as value 1 ("Error Undefined"). 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TERMINATION_CAUSE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Termination-Cause")
public interface TerminationCause extends DiameterUnsigned32
{
}