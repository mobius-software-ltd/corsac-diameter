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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSDataCodingScheme;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSRequestorID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSRequestorIDString;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1239L, vendorId = KnownVendorIDs.TGPP_ID)
public class LCSRequestorIDImpl implements LCSRequestorID
{
	private LCSDataCodingScheme lcsDataCodingScheme;
	private LCSRequestorIDString lcsRequestorIDString;
		
	public LCSRequestorIDImpl()
	{
		
	}
	
	public String getLCSDataCodingScheme()
	{
		if(lcsDataCodingScheme==null)
			return null;
		
		return lcsDataCodingScheme.getString();
	}
	
	public void setLCSDataCodingScheme(String value)
	{
		if(value==null)
			this.lcsDataCodingScheme = null;
		else
			this.lcsDataCodingScheme = new LCSDataCodingSchemeImpl(value, null, null);			
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
}