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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcUnitTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	public RateElementImpl(CcUnitTypeEnum ccUnitType) throws MissingAvpException
	{
		setCcUnitType(ccUnitType);
	}
	
	public CcUnitTypeEnum getCcUnitType()
	{
		if(ccUnitType==null)
			return null;
		
		return ccUnitType.getEnumerated(CcUnitTypeEnum.class);
	}
	
	public void setCcUnitType(CcUnitTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CC-Unit-Type is required is required", Arrays.asList(new DiameterAvp[] { new CcUnitTypeImpl() }));
		
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
	public DiameterException validate()
	{
		if(ccUnitType==null)
			return new MissingAvpException("CC-Unit-Type is required is required", Arrays.asList(new DiameterAvp[] { new CcUnitTypeImpl() }));
		
		return null;
	}
}