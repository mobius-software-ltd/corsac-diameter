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
/* 	3.2.314  POS-Account-Notify AVP

	AVP Name
	POS-Account-Notify

	AVP Code
	21182

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	-
	
	The POS-Account-Notify AVP is an AVP group. The detailed ABNF syntax is as follows: 
	POS-Account-Notify ::= <AVP Header: 21182> 
                 [POS-Notify-Mode] 
                 [POS-Used-Credit]
                 [PPOx-Credit]
                 [Next-Bill-Date] 
*/
@DiameterAvpDefinition(code = 21182L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "POS-Account-Notify")
public interface POSAccountNotify extends DiameterAvp 
{
	Integer getPOSNotifyMode();
	
	void setPOSNotifyMode(Integer value);		
	
	Long getPOSUsedCredit();
	
	void setPOSUsedCredit(Long value);	
	
	Long getPOSMaxCredit();
	
	void setPOSMaxCredit(Long value);	
	
	ByteBuf getNextBillDate();
	
	void setNextBillDate(ByteBuf value);	
}