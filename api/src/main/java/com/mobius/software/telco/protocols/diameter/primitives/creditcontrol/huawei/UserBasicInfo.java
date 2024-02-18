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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.325  User-Basic-Info AVP

	AVP Name
	User-Basic-Info

	AVP Code
	21196

	AVP Data Type
	grouped

	Vendor-ID
	2011

	Description
	Basic information about a subscriber. The OCG can obtain basic information about the subscriber from the CBP to bypass the SDU.
	
	The Charge-Money AVP is an AVP group. The detailed ABNF syntax is as follows: 
	User-Basic-Info ::= <AVP Header: 21196> 
                [I-Sub-COSID]
				[I-User-Type]
				[I-Tenant-ID]
				[I-Language-Type]
				[I-SMS-Language-Type]
				[I-Brand-ID]
				[I-Saas-Tenant-ID]
				[I-First-Call-Flag]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.USER_BASIC_INFO, vendorId = VendorIDs.HUAWEI_ID, name = "User-Basic-Info")
public interface UserBasicInfo extends DiameterAvp 
{
	Integer getISubCOSID();
	
	void setISubCOSID(Integer value);		
	
	Integer getIUserType();
	
	void setIUserType(Integer value);	
	
	Integer getITenantID();
	
	void setITenantID(Integer value);	
	
	Integer getILanguageType();
	
	void setILanguageType(Integer value);		
	
	Integer getISMSLanguageType();
	
	void setISMSLanguageType(Integer value);	
	
	Integer getIBrandID();
	
	void setIBrandID(Integer value);	
	
	Integer getISaasTenantID();
	
	void setISaasTenantID(Integer value);	
	
	String getIFirstCallFlag();
	
	void setIFirstCallFlag(String value);	
}