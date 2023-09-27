package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GMLCNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSPrivacyException;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MOLR;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1473L, vendorId = KnownVendorIDs.TGPP_ID)
public class LCSInfoImpl extends DiameterGroupedAvpImpl implements LCSInfo
{
	private List<GMLCNumber> gmlcNumber;
	
	private List<LCSPrivacyException> lcsPrivacyException;
	
	private List<MOLR> moLR;
	
	public LCSInfoImpl()
	{
		
	}
	
	public List<String> getGMLCNumber()
	{
		if(gmlcNumber==null || gmlcNumber.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(GMLCNumber curr:gmlcNumber)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setGMLCNumber(List<String> value)
	{
		if(value == null || value.size()==0)
			this.gmlcNumber = null;
		else
		{
			this.gmlcNumber = new ArrayList<GMLCNumber>();
			for(String curr:value)
				this.gmlcNumber.add(new GMLCNumberImpl(curr));
		}
	}
	
	public List<LCSPrivacyException> getLCSPrivacyException()
	{
		return lcsPrivacyException;
	}
	
	public void setLCSPrivacyException(List<LCSPrivacyException> value)
	{
		this.lcsPrivacyException = value;
	}
	
	public List<MOLR> getMOLR()
	{
		return moLR;
	}
	
	public void setMOLR(List<MOLR> value)
	{
		this.moLR=value;
	}
}