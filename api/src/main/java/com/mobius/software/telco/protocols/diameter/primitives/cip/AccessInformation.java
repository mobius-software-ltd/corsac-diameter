package com.mobius.software.telco.protocols.diameter.primitives.cip;
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
import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;

/*	4.4.1 Access-Information AVP
	The Access-Information AVP (AVP code 1063) includes information received
	from the incoming access to the Charging System. The Access-Information
	AVP is a grouped AVP as specified below.
		
	Access-Information ::= <AVP Header: 1063>
			[ Auth-Application-Id ]
			[ Origin-Host ]
			[ CC-Request-Number ]
			[ CC-Request-Type ]
			[ Event-Timestamp ]
			[ Origin-Realm ]
			[ *AVP ]
*/
@DiameterAvpDefinition(code = EricssonAvpCodes.ACCESS_INFORMATION, vendorId = VendorIDs.ERICSSON_ID, name = "Access-Information")
public interface AccessInformation extends DiameterGroupedAvp 
{
	Long getAuthApplicationId();
	
	void setAuthApplicationId(Long value);
	
	String getOriginHost();
	
	void setOriginHost(String value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	String getOriginRealm();
	
	void setOriginRealm(String value);
	
}