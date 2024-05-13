package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumUnitValue;

/**
*
* @author yulian oifa
*
*/
public class CumMoneyImpl extends DiameterAvpImpl implements CumMoney
{
	private CumUnitValue cumUnitValue;
	
	protected CumMoneyImpl()
	{
		
	}
	
	public CumMoneyImpl(CumUnitValue cumUnitValue) throws MissingAvpException
	{
		setCumUnitValue(cumUnitValue);
	}
	
	@Override
	public CumUnitValue getCumUnitValue()
	{
		return this.cumUnitValue;
	}
	
	@Override
	public void setCumUnitValue(CumUnitValue value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Cum-Unit-Value is required", Arrays.asList(new DiameterAvp[] { new CumUnitValueImpl() }));
			
		this.cumUnitValue = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(cumUnitValue==null)
			return new MissingAvpException("Cum-Unit-Value is required", Arrays.asList(new DiameterAvp[] { new CumUnitValueImpl() }));
		
		return null;
	}
}