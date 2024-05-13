package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPMandatoryCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPOptionalCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerURI;

/**
*
* @author yulian oifa
*
*/
public class SIPServerCapabilitiesImpl extends DiameterGroupedAvpImpl implements SIPServerCapabilities
{
	private List<SIPMandatoryCapability> sipMandatoryCapability;
	
	private List<SIPOptionalCapability> sipOptionalCapability;
	
	private List<SIPServerURI> sipServerURI;
	
	public SIPServerCapabilitiesImpl()
	{
		
	}
	
	public List<Long> getSIPMandatoryCapability()
	{
		if(sipMandatoryCapability==null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SIPMandatoryCapability curr:sipMandatoryCapability)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSIPMandatoryCapability(List<Long> value)
	{
		if(value == null)
			this.sipMandatoryCapability = null;
		else
		{
			this.sipMandatoryCapability =  new ArrayList<SIPMandatoryCapability>();
			for(Long curr: value)
				this.sipMandatoryCapability.add(new SIPMandatoryCapabilityImpl(curr, null, null));
		}
	}
	
	public List<Long> getSIPOptionalCapability()
	{
		if(sipOptionalCapability==null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SIPOptionalCapability curr:sipOptionalCapability)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSIPOptionalCapability(List<Long> value)
	{
		if(value == null)
			this.sipOptionalCapability = null;
		else
		{
			this.sipOptionalCapability =  new ArrayList<SIPOptionalCapability>();
			for(Long curr: value)
				this.sipOptionalCapability.add(new SIPOptionalCapabilityImpl(curr, null, null));
		}
	}
	
	public List<String> getSIPServerURI()
	{
		if(sipServerURI==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SIPServerURI curr:sipServerURI)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setSIPServerURI(List<String> value)
	{
		if(value == null)
			this.sipServerURI = null;
		else
		{
			this.sipServerURI =  new ArrayList<SIPServerURI>();
			for(String curr: value)
				this.sipServerURI.add(new SIPServerURIImpl(curr, null, null));
		}
	}	
}