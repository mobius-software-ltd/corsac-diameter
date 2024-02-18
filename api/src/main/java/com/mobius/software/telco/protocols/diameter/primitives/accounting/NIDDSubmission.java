package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.112aA	NIDD-Submission  AVP
	The NIDD-Submission AVP (AVP code 3928) is of type Grouped and holds information about the NIDD submission for CP data transfer. 
	It has the following ABNF grammar:
	
	NIDD-Submission  :: = 	  < AVP Header: 3928>
			[ Submission-Timestamp ]
			[ Event-Timestamp ]
			[ Accounting-Input-Octets ]
			[ Accounting-Output-Octets ]
			[ Change-Condition ]

	Editor’s Note: AVP for result of NIDD submission is ffs.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NIDD_SUBMISSION, vendorId = VendorIDs.TGPP_ID, name = "NIDD-Submission")
public interface NIDDSubmission extends DiameterAvp
{
	Date getSubmissionTime();
	
	void setSubmissionTime(Date value);
	
	Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long value);
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);
	
	Long getChangeCondition();
	
	void setChangeCondition(Long value);
}