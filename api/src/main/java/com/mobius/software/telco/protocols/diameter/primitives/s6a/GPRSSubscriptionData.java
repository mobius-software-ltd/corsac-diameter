package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.72	GPRS-Subscription-Data
	The GPRS-Subscription-Data AVP is of type Grouped. It shall contain the information related to the user profile relevant for GPRS.
	AVP format:

	GPRS-Subscription-Data ::= <AVP header: 1467 10415>
			 { Complete-Data-List-Included-Indicator }
		1*50 {PDP-Context}
		*	 [AVP]

	NOTE:	The max number of PDP-Context AVP aligns with the value of maxNumOfPDP-Contexts as defined in 3GPP TS 29.002 [24].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.GPRS_SUBSCRIPTION_DATA, vendorId = VendorIDs.TGPP_ID, name = "GPRS-Subscription-Data")
public interface GPRSSubscriptionData extends DiameterGroupedAvp
{
	CompleteDataListIncludedIndicatorEnum getCompleteDataListIncludedIndicator();
	
	void setCompleteDataListIncludedIndicator(CompleteDataListIncludedIndicatorEnum value) throws MissingAvpException;	
	
	List<PDPContext> getPDPContext();
	
	void setPDPContext(List<PDPContext> value) throws MissingAvpException, AvpOccursTooManyTimesException;
}