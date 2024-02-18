package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 *	6.3.16	Deregistration-Reason AVP
	The Deregistration-Reason AVP is of type Grouped, and indicates the reason for a de-registration operation.
	AVP format

		Deregistration-Reason :: = < AVP Header : 615 10415 >
			{ Reason-Code }
			[ Reason-Info ]
			* [AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEREGISTRATION_REASON, vendorId = VendorIDs.TGPP_ID, name = "Deregistration-Reason")
public interface DeregistrationReason extends DiameterGroupedAvp
{
	ReasonCodeEnum getReasonCode();
	
	void setReasonCode(ReasonCodeEnum value) throws MissingAvpException;
	
	String getReasonInfo();
	
	void setReasonInfo(String value);
}