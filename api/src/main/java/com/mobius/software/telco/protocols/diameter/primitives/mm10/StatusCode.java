package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	6.3.20	Status-Code AVP
	The Status-Code AVP (AVP code 1117) is of type UTF8String. It contains the trigger event specific response code to qualify the outcome of the message processing. The UTF8String identifying the Status-Code shall be represented according to the following ABNF definition:
	Status-Code = ( Response-status-value / Retrieve-status-value / StatusCode )
	Response-status-value; it contains the numerical octet value of the M-send.conf X-Mms-Response-Status header defined in [6]. This Status-Code value shall be used by the MSCF if the Trigger-Event of the Message-Process-Request referred to MM1 Message Submission.
	Retrieve-status-value; it contains the numerical octet value of the M-Retrieve.conf X-Mms-Retrieve-Status header defined in [6]. This Status-Code value shall be used by the MSCF if the Trigger-Event of the Message-Process-Request referred to MM1 Message Delivery.
	StatusCode; it contains the numerical value of the MM7_submit.RES StatusCode element defined in [1]. This Status-Code value shall be used by the MSCF if the Trigger-Event of the Message-Process-Request referred to MM7 Message Submission.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.STATUS_CODE, vendorId = VendorIDs.TGPP_ID, name = "Status-Code")
public interface StatusCode extends DiameterUTF8String
{
}