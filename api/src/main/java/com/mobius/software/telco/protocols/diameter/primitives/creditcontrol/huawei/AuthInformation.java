package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.450  Auth-Information AVP

	AVP Name
	Auth-Information

	AVP Code
	30800

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the group that is used to return the internal authentication result of the OCS system.
	For the charging services that are interconnected with the Huawei OCG, the group information is returned. The OCG processes the charging according to the group information. For the charging services that are interconnected with the devices of other device providers, whether to return the group information needs to be confirmed during interconnection.

	Auth-Information ::= <AVP Header: 30800> 
                     [Auth-Result-Code] 
                     [Auth-User-State] 
                     [Auth-Action] 
                     [Auth-Voice-ID] 
                     [Auth-Message-ID] 
                     [Auth-Sub-Service-Key] 


*/
@DiameterAvpDefinition(code = 30800L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Auth-Information")
public interface AuthInformation extends DiameterAvp 
{
	Long getAuthResultCode();
	
	void setAuthResultCode(Long value);		
	
	String getAuthUserState();
	
	void setAuthUserState(String value);		
	
	String getAuthAction();
	
	void setAuthAction(String value);		
	
	Long getAuthVoiceID();
	
	void setAuthVoiceID(Long value);		
	
	Long getAuthMessageID();
	
	void setAuthMessageID(Long value);		
	
	String getAuthSubServiceKey();
	
	void setAuthSubServiceKey(String value);	
}