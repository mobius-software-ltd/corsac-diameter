package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CalledAssertedIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CalledPartyAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RequestedPartyAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledAssertedIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestedPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 565L, vendorId = KnownVendorIDs.TGPP_ID)
public class CalleeInformationImpl extends DiameterGroupedAvpImpl implements CalleeInformation
{
	private CalledPartyAddress calledPartyAddress;
	
	private List<RequestedPartyAddress> requestedPartyAddress;
	
	private List<CalledAssertedIdentity> calledAssertedIdentity;
	
	public CalleeInformationImpl()
	{
		
	}
	
	public String getCalledPartyAddress()
	{
		if(calledPartyAddress == null)
			return null;
		
		return calledPartyAddress.getString();
	}
	
	public void setCalledPartyAddress(String value)
	{
		if(value==null)
			this.calledPartyAddress = null;
		else
			this.calledPartyAddress = new CalledPartyAddressImpl(value, null, null);	
	}
	
	public List<String> getRequestedPartyAddress()
	{
		if(requestedPartyAddress == null || requestedPartyAddress.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(RequestedPartyAddress curr:requestedPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setRequestedPartyAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.requestedPartyAddress = null;
		else
		{
			this.requestedPartyAddress = new ArrayList<RequestedPartyAddress>();
			for(String curr:value)
				this.requestedPartyAddress.add(new RequestedPartyAddressImpl(curr, null, null));
		}
	}
	
	public List<String> getCalledAssertedIdentity()
	{
		if(calledAssertedIdentity == null || calledAssertedIdentity.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(CalledAssertedIdentity curr:calledAssertedIdentity)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setCalledAssertedIdentity(List<String> value)
	{
		if(value==null || value.size()==0)
			this.calledAssertedIdentity = null;
		else
		{
			this.calledAssertedIdentity = new ArrayList<CalledAssertedIdentity>();
			for(String curr:value)
				this.calledAssertedIdentity.add(new CalledAssertedIdentityImpl(curr, null, null));
		}
	}
}