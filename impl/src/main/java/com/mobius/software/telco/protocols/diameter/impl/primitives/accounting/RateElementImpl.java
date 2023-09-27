package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcUnitTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargeReasonCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargeReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateElement;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitType;
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
@DiameterAvpImplementation(code = 2058L, vendorId = KnownVendorIDs.TGPP_ID)
public class RateElementImpl implements RateElement
{
	private CcUnitType ccUnitType;
	private ChargeReasonCode chargeReasonCode;
	private UnitValue unitValue;
	private UnitCost unitCost;
	private UnitQuotaThreshold unitQuotaThreshold;
			 
	protected RateElementImpl() 
	{
	}
	
	public RateElementImpl(CcUnitTypeEnum ccUnitType)
	{
		if(ccUnitType==null)
			throw new IllegalArgumentException("CC-Unit-Type is required");
		
		this.ccUnitType = new CcUnitTypeImpl(ccUnitType, null, null);						
	}
	
	public CcUnitTypeEnum getCcUnitType()
	{
		if(ccUnitType==null)
			return null;
		
		return ccUnitType.getEnumerated(CcUnitTypeEnum.class);
	}
	
	public void setCcUnitType(CcUnitTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Unit-Type is required");
		
		this.ccUnitType = new CcUnitTypeImpl(value, null, null);						
	}
	
	public ChargeReasonCodeEnum getChargeReasonCode()
	{
		if(chargeReasonCode==null)
			return null;
		
		return chargeReasonCode.getEnumerated(ChargeReasonCodeEnum.class);
	}
	
	public void setChargeReasonCode(ChargeReasonCodeEnum value)
	{
		if(value==null)
			this.chargeReasonCode = null;
		else
			this.chargeReasonCode = new ChargeReasonCodeImpl(value, null, null);			
	}
	
	public UnitValue getUnitValue()
	{
		return this.unitValue;
	}
	
	public void setUnitValue(UnitValue value)
	{
		this.unitValue = value;
	}
	
	public UnitCost getUnitCost()
	{
		return this.unitCost;
	}
	
	public void setUnitCost(UnitCost value)
	{
		this.unitCost = value;
	}
	
	public Long getUnitQuotaThreshold()
	{
		if(unitQuotaThreshold==null)
			return null;
		
		return unitQuotaThreshold.getUnsigned();
	}
	
	public void setUnitQuotaThreshold(Long value)
	{
		if(value==null)
			this.unitQuotaThreshold = null;
		else
			this.unitQuotaThreshold = new UnitQuotaThresholdImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ccUnitType==null)
			return "CC-Unit-Type is required";
		
		return null;
	}
}