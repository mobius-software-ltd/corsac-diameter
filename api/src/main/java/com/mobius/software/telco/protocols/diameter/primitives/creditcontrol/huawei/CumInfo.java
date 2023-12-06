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
/* 	3.2.269  Cum-Info AVP

	AVP Name
	Cum-Info

	AVP Code
	20853

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Accumulated consumption information about a subscriber. A maximum of 13 records can be saved.

	Cum-Info ::= <AVP Header: 20853> 
                 [Cum-Money]
                 [CumId]
*/
@DiameterAvpDefinition(code = 20853L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Cum-Info")
public interface CumInfo extends DiameterAvp 
{
	CumMoney getCumMoney();
	
	void setCumMoney(CumMoney value);		
	
	ByteBuf getCumId();
	
	void setCumId(ByteBuf value);	
}