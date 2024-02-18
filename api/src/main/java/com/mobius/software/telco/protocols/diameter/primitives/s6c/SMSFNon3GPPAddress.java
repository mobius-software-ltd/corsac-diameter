package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
 * 	5.3.3.36	SMSF-Non-3GPP-Address
	The SMSF-Non-3GPP-Address AVP is of type Grouped. This AVP shall contain the information about the SMSF serving the targeted user for Non-3GPP access.
	AVP format

	SMSF-Non-3GPP-Address ::=	<AVP header: 3345 10415>
		 [ SMSF-Non-3GPP-Number ]
		 [ SMSF-Non-3GPP-Name ]
		 [ SMSF-Non-3GPP-Realm ]
		 [ SMSF-Non-3GPP-SBI-Support-Indicator ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SMSF_NON_3GPP_ADDRESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "SMSF-Non-3GPP-Address")
public interface SMSFNon3GPPAddress extends DiameterGroupedAvp
{
	String getSMSFNon3GPPNumber();
	
	void setSMSFNon3GPPNumber(String value);
	
	String getSMSFNon3GPPName();
	
	void setSMSFNon3GPPName(String value);	
	
	String getSMSFNon3GPPRealm();
	
	void setSMSFNon3GPPRealm(String value);
	
	SMSFNon3GPPSBISupportIndicatorEnum getSMSFNon3GPPSBISupportIndicator();
	
	void setSMSFNon3GPPSBISupportIndicator(SMSFNon3GPPSBISupportIndicatorEnum value);
}