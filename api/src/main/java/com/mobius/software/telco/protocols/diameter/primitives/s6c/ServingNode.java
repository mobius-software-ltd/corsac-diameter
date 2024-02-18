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
 * 	5.3.3.6	Serving-Node
	The Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the targeted SMS user. It is originally defined in 3GPP TS 29.173 [10].

	AVP format

		Serving-Node ::=	<AVP header: 2401 10415>
			 [ SGSN-Name ]
			 [ SGSN-Realm ]
			 [ SGSN-Number ]
			 [ MME-Name ]
			 [ MME-Realm ]
			 [ MME-Number-for-MT-SMS ]
			 [ MSC-Number ]
			 [ IP-SM-GW-Number ]
			 [ IP-SM-GW-Name ]
			 [ IP-SM-GW-Realm ]
			 [ IP-SM-GW-SBI-Support-Indicator ]
			*[AVP]

	The following combinations are allowed:

	a) SGSN-Number

	b) SGSN-Name & SGSN-Realm & SGSN-Number if the HSS supports the "Gdd in SGSN" feature and has received the "Gdd in SGSN" indication over S6a or Gr interface from the SGSN (cf. 3GPP TS 29.272 [4] and 3GPP TS 29.002 [9])

	c) MME-Name & MME-Realm & MME-Number-for-MT-SMS
	
	d) MSC-Number

	e) MSC-Number & MME-Name & MME-Realm

	f) IP-SM-GW-Number

	g) IP-SM-GW-Number & IP-SM-GW-Name.

	h) IP-SM-GW-Number & IP-SM-GW-SBI-Support-Indicator

	i) IP-SM-GW-Number & IP-SM-GW-Name & IP-SM-GW-SBI-Support-Indicator.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVING_NODE, vendorId = VendorIDs.TGPP_ID, name = "Serving-Node")
public interface ServingNode extends DiameterGroupedAvp
{
	String getSGSNName();
	
	void setSGSNName(String value);	
	
	String getSGSNRealm();
	
	void setSGSNRealm(String value);
	
	String getSGSNNumber();
	
	void setSGSNNumber(String value);
	
	String getMMEName();
	
	void setMMEName(String value);	
	
	String getMMERealm();
	
	void setMMERealm(String value);
	
	String getMMENumberForMTSMS();
	
	void setMMENumberForMTSMS(String value);
	
	String getMSCNumber();
	
	void setMSCNumber(String value);
	
	String getIPSMGWNumber();
	
	void setIPSMGWNumber(String value);
	
	String getIPSMGWName();
	
	void setIPSMGWName(String value);
	
	String getIPSMGWRealm();
	
	void setIPSMGWRealm(String value);
	
	IPSMGWSBISupportIndicatorEnum getIPSMGWSBISupportIndicator();
	
	void setIPSMGWSBISupportIndicator(IPSMGWSBISupportIndicatorEnum value);
}