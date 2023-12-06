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
/* 	3.2.144  Notice-Information AVP
	
	AVP Name
	Notice-Information

	AVP Code
	20394

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the SM notification assembled by the OCS.
	The OCS is responsible for assembling the SM notification contents, that is, the MessageContent1 AVP to MessageContent6 AVP, and for arraying all the message contents closely ahead. For example, if the MessageContent4 AVP is null, the MessageContent5 AVP must be null. After receiving the notification SM from the OCS, the third party such as VSCP can send the SM to the SMSC directly. The additional processing such as message size checking and re-assembling is not required.
	The Notice-Information AVP is an AVP group. The detailed ABNF syntax is as follows:

	Notice-Information ::= <AVP Header:20394> 
                       [MessageCount] 
                       [MessageContent1] 
                       [MessageContent2] 
                       [MessageContent3] 
                       [MessageContent4] 
                       [MessageContent5] 
                       [MessageContent6] 
                       [ReceiveMessageAddr] 

	NOTE
	VSCP: Value-added Service Control Point
*/
@DiameterAvpDefinition(code = 20394L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Notice-Information")
public interface NoticeInformation extends DiameterAvp 
{
	Long getMessageCount();
	
	void setMessageCount(Long value);
	
	String getMessageContent1();
	
	void setMessageContent1(String value);
	
	String getMessageContent2();
	
	void setMessageContent2(String value);
	
	String getMessageContent3();
	
	void setMessageContent3(String value);
	
	String getMessageContent4();
	
	void setMessageContent4(String value);
	
	String getMessageContent5();
	
	void setMessageContent5(String value);
	
	String getMessageContent6();
	
	void setMessageContent6(String value);
	
	String getReceiveMessageAddr();
	
	void setReceiveMessageAddr(String value);	
}