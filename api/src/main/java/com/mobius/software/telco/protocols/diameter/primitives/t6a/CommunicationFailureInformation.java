package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.4	Communication-Failure-Information
	The Communication-Failure-Information AVP is of type Grouped. It shall contain the reason for communication failure.
	AVP format:

	Communication-Failure-Information ::= <AVP header: 4300 10415>
			 [ Cause-Type ]
			 [ S1AP-Cause ]
			 [ RANAP-Cause ]
			 [ BSSGP-Cause ]
			 [ GMM-Cause ]
			 [ SM-Cause ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.COMMUNICATION_FAILURE_IFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Communication-Failure-Information")
public interface CommunicationFailureInformation extends DiameterGroupedAvp
{
	CauseTypeEnum getCauseType();
	
	void setCauseType(CauseTypeEnum value);
	
	Long getS1APCause();
	
	void setS1APCause(Long value);
	
	Long getRANAPCause();
	
	void setRANAPCause(Long value);
	
	Long getBSSGPCause();
	
	void setBSSGPCause(Long value);
	
	Long getGMMCause();
	
	void setGMMCause(Long value);
	
	Long getSMCause();
	
	void setSMCause(Long value);
}