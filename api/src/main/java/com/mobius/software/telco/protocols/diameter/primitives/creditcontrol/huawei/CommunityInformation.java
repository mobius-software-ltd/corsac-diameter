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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.327  Community-Information AVP

	AVP Name
	Community-Information

	AVP Code
	21204

	AVP Data Type
	Grouped

	Vendor-ID
	2011

	Description
	-
	
	The Community-Information AVP is an AVP group. The detailed ABNF syntax is as follows: 
	Community-Information ::= <AVP Header: 21204> 
                [S-Caller-Number-Type]
				[S-Caller-VPN-Phone-Flags]
				[S-Caller-PBX-Display-Number]
				[S-Caller-Hunting-Main-Number]
				[S-Called-Number-Type]
				[S-Called-VPN-Phone-Flags]
				[S-Called-PBX-Display-Number]
				[S-Called-Hunting-Main-Number]
				[S-Caller-Group-Number]
				[S-Caller-Top-Group-Number]
				[S-Caller-Short-Number]
				[S-Called-Group-Number]
				[S-Called-Top-Group-Number]
				[S-Called-Long-Number]
				[Member-Screen-Class]
				[Screen-Zone-ID]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.COMMUNITY_INFORMATION, vendorId = VendorIDs.HUAWEI_ID, name = "Community-Information")
public interface CommunityInformation extends DiameterAvp 
{
	ByteBuf getSCallerNumberType();
	
	void setSCallerNumberType(ByteBuf value);		
	
	ByteBuf getSCallerVPNPhoneFlags();
	
	void setSCallerVPNPhoneFlags(ByteBuf value);		
	
	ByteBuf getSCallerPBXDisplayNumber();
	
	void setSCallerPBXDisplayNumber(ByteBuf value);		
	
	ByteBuf getSCallerHuntingMainNumber();
	
	void setSCallerHuntingMainNumber(ByteBuf value);
	
	ByteBuf getSCalledNumberType();
	
	void setSCalledNumberType(ByteBuf value);		
	
	ByteBuf getSCalledVPNPhoneFlags();
	
	void setSCalledVPNPhoneFlags(ByteBuf value);		
	
	ByteBuf getSCalledPBXDisplayNumber();
	
	void setSCalledPBXDisplayNumber(ByteBuf value);
	
	ByteBuf getSCalledHuntingMainNumber();
	
	void setSCalledHuntingMainNumber(ByteBuf value);		
	
	ByteBuf getSCallerGroupNumber();
	
	void setSCallerGroupNumber(ByteBuf value);		
	
	ByteBuf getSCallerTopGroupNumber();
	
	void setSCallerTopGroupNumber(ByteBuf value);		
	
	ByteBuf getSCallerShortNumber();
	
	void setSCallerShortNumber(ByteBuf value);
	
	ByteBuf getSCalledGroupNumber();
	
	void setSCalledGroupNumber(ByteBuf value);		
	
	ByteBuf getSCalledTopGroupNumber();
	
	void setSCalledTopGroupNumber(ByteBuf value);		
	
	ByteBuf getSCalledLongNumber();
	
	void setSCalledLongNumber(ByteBuf value);
	
	String getMemberScreenClass();
	
	void setMemberScreenClass(String value);
	
	Integer getScreenZoneID();
	
	void setScreenZoneID(Integer value);	
}