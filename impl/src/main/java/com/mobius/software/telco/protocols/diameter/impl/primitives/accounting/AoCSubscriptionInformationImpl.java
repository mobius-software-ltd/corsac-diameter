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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCFormat;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCFormatEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCService;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCSubscriptionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PreferredAoCCurrency;

/**
*
* @author yulian oifa
*
*/
public class AoCSubscriptionInformationImpl extends DiameterAvpImpl implements AoCSubscriptionInformation
{
	private List<AoCService> aocService;
	private AoCFormat aocFormat;
   	private PreferredAoCCurrency preferredAoCCurrency;
   	
   	public AoCSubscriptionInformationImpl()
   	{
   		
   	}
   	
   	public List<AoCService> getAoCService()
   	{
   		return aocService;
   	}
	
   	public void setAoCService(List<AoCService> value)
   	{
   		this.aocService = value;
   	}
	
   	public AoCFormatEnum getAoCFormat()
   	{
		if(aocFormat==null)
			return null;
		
		return aocFormat.getEnumerated(AoCFormatEnum.class);
	}
	
   	public void setAoCFormat(AoCFormatEnum value)
   	{
		if(value==null)
			this.aocFormat = null;
		else
			this.aocFormat = new AoCFormatImpl(value, null, null);			
	}
	
   	public Long getPreferredAoCCurrency()
   	{
		if(preferredAoCCurrency==null)
			return null;
		
		return preferredAoCCurrency.getUnsigned();
	}
	
   	public void setPreferredAoCCurrency(Long value)
   	{
		if(value==null)
			this.preferredAoCCurrency = null;
		else
			this.preferredAoCCurrency = new PreferredAoCCurrencyImpl(value, null, null);			
	}
}