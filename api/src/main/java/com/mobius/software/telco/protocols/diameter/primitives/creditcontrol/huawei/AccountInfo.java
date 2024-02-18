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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.120  AccountInfo AVP
	
	AVP Name
	AccountInfo

	AVP Code
	20356

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	This AVP is used to record account information before and after the recharge, account information before and after call, and the call fee information.
	The account information includes detailed account information and main account information. A maximum of 20 groups of account information is sent.

	Account-Info ::= <AVP Header:20356> 
                [Account-Id] 
                [Account-Type] 
                [CC-Money] 
                [CC-Credit] 
                [Account-Date] 
                [LifeCycle-State]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACCOUNT_INFO, vendorId = VendorIDs.HUAWEI_ID, name = "Account-Info")
public interface AccountInfo extends DiameterAvp 
{
	ByteBuf getAccountID();
	
	void setAccountID(ByteBuf value);
	
	Long getAccountType();
	
	void setAccountType(Long value);
	
	CCMoney getCCMoney();
	
	void setCCMoney(CCMoney value);	
	
	CCCredit getCCCredit();
	
	void setCCCredit(CCCredit value);	
	
	ByteBuf getAccountDate();
	
	void setAccountDate(ByteBuf value);
	
	Long getLifeCycleState();
	
	void setLifeCycleState(Long value);			
}