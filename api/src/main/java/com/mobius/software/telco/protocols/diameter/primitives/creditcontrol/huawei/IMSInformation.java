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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.564  IMS-Information AVP

	AVP Name
	IMS-Information

	AVP Code
	876

	AVP Data Type
	Grouped

	Vendor ID
	10415

	Description
	Indicates the IP multimedia subsystem(IMS) information.

	The IMS-Information AVP is an AVP group. The detailed ABNF syntax is as follows:
	IMS-Information ::= <AVP Header: 876> 
                    [Event-Type] 
                    [Message-Body] 
                    [Role-of-Node] 
                    [User-Session-Id] 
                    [Calling-Party-Address] 
                    [Called-Party-Address] 
                    [Time-stamps] 
                    [Inter-Operator-Identifier] 
                    [IMS-Charging-Identifier] 
                   *[SDP-Session-Description] 
                   *[SDP-Media-component] 
                    [SDP-Media-Identifier] 
                    [Diversion-Reason] 
                    [Requested-Party-Address] 
                    [UUS-Data] 
                    [Cause] 
                    [Service-ID] 
                    [Service-Specific-Data]
*/
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "IMS-Information")
public interface IMSInformation extends com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSInformation 
{
	DiversionReasonEnum getDiversionReason();
	
	void setDiversionReason(DiversionReasonEnum value);
	
	Long getDiversionCount();
	
	void setDiversionCount(Long value);
	
	SDPMediaIdentifierEnum getSDPMediaIdentifier();
	
	void setSDPMediaIdentifier(SDPMediaIdentifierEnum value);	
}