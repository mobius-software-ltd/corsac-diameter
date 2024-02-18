package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSFormatIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSNameStringImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSFormatIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSFormatIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSNameString;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;

/**
*
* @author yulian oifa
*
*/
public class LCSEPSClientNameImpl implements LCSEPSClientName
{
	private LCSNameString lcsNameString;
	
	private LCSFormatIndicator lcsFormatIndicator;
	
	public LCSEPSClientNameImpl()
	{
		
	}
	
	public String getLCSNameString()
	{
		if(lcsNameString==null)
			return null;
		
		return lcsNameString.getString();
	}
	
	public void setLCSNameString(String value)
	{
		if(value==null)
			this.lcsNameString = null;
		else
			this.lcsNameString = new LCSNameStringImpl(value, null, null);			
	}
	
	public LCSFormatIndicatorEnum getLCSFormatIndicator()
	{
		if(lcsFormatIndicator==null)
			return null;
		
		return lcsFormatIndicator.getEnumerated(LCSFormatIndicatorEnum.class);
	}
	
	public void setLCSFormatIndicator(LCSFormatIndicatorEnum value)
	{
		if(value==null)
			this.lcsFormatIndicator = null;
		else
			this.lcsFormatIndicator = new LCSFormatIndicatorImpl(value, null, null);			
	}
}