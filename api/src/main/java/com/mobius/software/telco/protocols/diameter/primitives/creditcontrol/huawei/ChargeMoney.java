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
/* 	3.2.110  Charge-Money AVP

	AVP Name
	Charge-Money

	AVP Code
	20344

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the value of recharge.

	The Charge-Money AVP is an AVP group. The detailed ABNF syntax is as follows: 
	Charge-Money ::= <AVP Header: 20344> 
                 [Money-Value] 
                 [New-Money]
                 [Active-Day]                  
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.CHARGE_MONEY, vendorId = VendorIDs.HUAWEI_ID, name = "Charge-Money")
public interface ChargeMoney extends DiameterAvp 
{
	Long getMoneyValue();
	
	void setMoneyValue(Long value);	
	
	Long getNewMoney();
	
	void setNewMoney(Long value);	
	
	Long getActiveDay();
	
	void setActiveDay(Long value);		
}