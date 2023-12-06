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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.309  PPS-Account-Notify AVP
	
	AVP Name
	PPS-Account-Notify

	AVP Code
	21177

	AVP Data Type
	Grouped

	Vendor ID
	2011
	
	Description
	–
	
	The PPS-Account-Notify AVP is an AVP group. The detailed ABNF syntax is as follows: 
	PPS-Account-Notify ::= <AVP Header: 21177> 
                 [PPS-Notify-Mode] 
                 [PPS-Used-Credit]
                 [PPS-Max-Credit]
                 [Validity-Date-2] 
*/
@DiameterAvpDefinition(code = 21177L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "PPS-Account-Notify")
public interface PPSAccountNotify extends DiameterAvp 
{
	Integer getPPSNotifyMode();
	
	void setPPSNotifyMode(Integer value);		
	
	Long getPPSUsedCredit();
	
	void setPPSUsedCredit(Long value);	
	
	Long getPPSMaxCredit();
	
	void setPPSMaxCredit(Long value);	
	
	ByteBuf getValidityDate2();
	
	void setValidityDate2(ByteBuf value);	
}