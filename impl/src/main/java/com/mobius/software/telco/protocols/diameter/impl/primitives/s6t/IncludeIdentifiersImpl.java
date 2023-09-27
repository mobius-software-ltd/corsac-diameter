package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IncludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3189L, vendorId = KnownVendorIDs.TGPP_ID)
public class IncludeIdentifiersImpl extends DiameterGroupedAvpImpl implements IncludeIdentifiers
{ 
	private List<ExternalIdentifier> externalIdentifier;
	
	private List<MSISDN> msisdn;
	
	public IncludeIdentifiersImpl()
	{
		
	}
	
	public List<String> getExternalIdentifier()
	{
		if(externalIdentifier==null || externalIdentifier.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ExternalIdentifier curr:externalIdentifier)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setExternalIdentifier(List<String> value)
	{
		if(value==null || value.size()==0)
			this.externalIdentifier = null;
		else
		{
			this.externalIdentifier = new ArrayList<ExternalIdentifier>();
			for(String curr:value)
				this.externalIdentifier.add(new ExternalIdentifierImpl(curr, null, null));
		}
	}
	
	public List<String> getMSISDN()
	{
		if(msisdn==null || msisdn.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(MSISDN curr:msisdn)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setMSISDN(List<String> value)
	{
		if(value==null || value.size()==0)
			this.msisdn = null;
		else
		{
			this.msisdn = new ArrayList<MSISDN>();
			for(String curr:value)
				this.msisdn.add(new MSISDNImpl(curr));
		}
	}
}