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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSFormatIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSRequestorIDStringImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSFormatIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSFormatIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSRequestorIDString;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSRequestorName;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2502L, vendorId = KnownVendorIDs.TGPP_ID)
public class LCSRequestorNameImpl implements LCSRequestorName
{
	private LCSRequestorIDString lcsRequestorIDString;
	
	private LCSFormatIndicator lcsFormatIndicator;
	
	public LCSRequestorNameImpl()
	{
		
	}
	
	public String getLCSRequestorIDString()
	{
		if(lcsRequestorIDString==null)
			return null;
		
		return lcsRequestorIDString.getString();
	}
	
	public void setLCSRequestorIDString(String value)
	{
		if(value==null)
			this.lcsRequestorIDString = null;
		else
			this.lcsRequestorIDString = new LCSRequestorIDStringImpl(value, null, null);			
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