package com.mobius.software.telco.protocols.diameter.primitives.t4;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.3	Serving-Node
	The Serving-Node AVP is of type Grouped and it shall contain the name/number of the serving node to be used for T4-triggering. It is originally defined in 3GPP TS 29.173 [8].
	
	Serving-Node ::=	<AVP header: 2401 10415>
			 [ SMSF-3GPP-Name ]
			 [ SMSF-3GPP-Realm ]
			 [ SMSF-3GPP-Number ]
			 [ SMSF-Non-3GPP-Name ]
			 [ SMSF-Non-3GPP-Realm ]
			 [ SMSF-Non-3GPP-Number ]
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
			*[AVP]

	The following combinations are allowed:
	
	a) SGSN-Number

	b) SGSN-Name & SGSN-Realm & SGSN-Number
	
	c) MME-Name & MME-Realm & MME-Number-for-MT-SMS

	d) MSC-Number

	e) MSC-Number & MME-Name & MME-Realm

	f) IP-SM-GW-Number

	g) IP-SM-GW-Number & IP-SM-GW-Name & IP-SM-GW-Realm

	h) SMSF-3GPP-Number

	i) SMSF-3GPP-Name & SMSF-3GPP-Realm & SMSF-3GPP-Number

	j) SMSF-Non-3GPP-Number

	k) SMSF-Non-3GPP-Name & SMSF-Non-3GPP-Realm & SMSF-Non-3GPP-Number
 */
@DiameterAvpDefinition(code = 2401L, vendorId = KnownVendorIDs.TGPP_ID, name = "Serving-Node")
public interface ServingNode extends DiameterGroupedAvp
{
	String getSMSF3GPPName();
	
	void setSMSF3GPPName(String value);	
	
	String getSMSF3GPPRealm();
	
	void setSMSF3GPPRealm(String value);
	
	String getSMSF3GPPNumber();
	
	void setSMSF3GPPNumber(String value);
	
	String getSMSFNon3GPPName();
	
	void setSMSFNon3GPPName(String value);	
	
	String getSMSFNon3GPPRealm();
	
	void setSMSFNon3GPPRealm(String value);
	
	String getSMSFNon3GPPNumber();
	
	void setSMSFNon3GPPNumber(String value);
	
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
}