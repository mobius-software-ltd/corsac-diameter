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
/* 	3.2.308  Credit-Use-Notification AVP

	AVP Name
	Credit-Use-Notification

	AVP Code
	21176

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Credit usage notification.
	
	The Charge-Money AVP is an AVP group. The detailed ABNF syntax is as follows: 
	Credit-Use-Notification ::= <AVP Header: 21176> 
                 [PPS-Account-Notify] 
                 [POS-Account-Notify] 
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.CREDIT_USE_NOTIFICATION, vendorId = VendorIDs.HUAWEI_ID, name = "Credit-Use-Notification")
public interface CreditUseNotification extends DiameterAvp 
{
	PPSAccountNotify getPPSAccountNotify();
	
	void setPPSAccountNotify(PPSAccountNotify value);		
	
	POSAccountNotify getPOSAccountNotify();
	
	void setPOSAccountNotify(POSAccountNotify value);	
}