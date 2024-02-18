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

import java.net.InetAddress;

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
 * 	7.2.178B	SCS-AS-Address AVP
	The SCS-AS-Address AVP (AVP code 3940) is of type Grouped and holds the Address of SCS/AS.
	It has the following ABNF grammar:
	
	SCS-AS-Address :: = < AVP Header: 3940>
		[ SCS-Realm ]
		[ SCS-Address ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SCS_AS_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "SCS-AS-Address")
public interface SCSASAddress extends DiameterAvp
{
	String getSCSRealm();
	
	void setSCSRealm(String value);
	
	InetAddress getSCSAddress();
	
	void setSCSAddress(InetAddress value);
}