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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.521  CC-Credit AVP (473)
	
	AVP Name
	CC-Credit

	AVP Code
	473

	AVP Data Type
	Grouped

	Vendor ID
	2011
	
	Description
	Indicates the credit of an account.
	The CC-Credit AVP is an AVP group. The detailed ABNF syntax is as follows:
	
	CC-Credit ::= <AVP Header: 473> 
              {Unit-Value} 
              [Currency-Code] 
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.CC_CREDIT, vendorId = VendorIDs.HUAWEI_ID, name = "CC-Credit")
public interface CCCredit extends DiameterAvp 
{
	UnitValue getUnitValue();
	
	void setUnitValue(UnitValue value) throws MissingAvpException;
	
	Long getCurrencyCode();
	
	void setCurrencyCode(Long value);	
}