package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.161	Rate-Element AVP
	The Rate-Element AVP (AVP code 2058) is of type Grouped and holds simple rate element of one dimension. Possible dimensions are the CC-Unit-Type.
	Example: CC-Unit-Type AVP TIME, Unit-Value AVP 6 and Unit-Cost AVP 10 with Exponent AVP 2 should read: 
	10 cents per 6 seconds time. The currency is context dependent.
	IF CC-Unit-Type AVP is MONEY, this is a fixed fee and Unit-Value is ignored.
	It has the following ABNF grammar:

	Rate-Element :: =  < AVP Header: 2058 >
		 { CC-Unit-Type }
		 [ Charge- Reason-Code ]
		 [ Unit-Value ]
		 [ Unit-Cost ]
		 [ Unit-Quota-Threshold ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RATE_ELEMENT, vendorId = VendorIDs.TGPP_ID, name = "Rate-Element")
public interface RateElement extends DiameterAvp
{
	CcUnitTypeEnum getCcUnitType();
	
	void setCcUnitType(CcUnitTypeEnum value) throws MissingAvpException;
	
	ChargeReasonCodeEnum getChargeReasonCode();
	
	void setChargeReasonCode(ChargeReasonCodeEnum value);
	
	UnitValue getUnitValue();
	
	void setUnitValue(UnitValue value);
	
	UnitCost getUnitCost();
	
	void setUnitCost(UnitCost value);
	
	Long getUnitQuotaThreshold();
	
	void setUnitQuotaThreshold(Long value);
}