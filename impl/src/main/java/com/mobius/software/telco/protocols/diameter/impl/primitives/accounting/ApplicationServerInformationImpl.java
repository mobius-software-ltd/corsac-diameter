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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationProvidedCalledPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationServer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationServerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StatusASCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StatusASCodeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 850L, vendorId = KnownVendorIDs.TGPP_ID)
public class ApplicationServerInformationImpl implements ApplicationServerInformation
{
	private ApplicationServer applicationServer;
	private List<ApplicationProvidedCalledPartyAddress> applicationProvidedCalledPartyAddress;
	private StatusASCode statusASCode;
			
	public ApplicationServerInformationImpl()
	{
		
	}
	
	public String getApplicationServer()
	{
		if(applicationServer==null)
			return null;
		
		return applicationServer.getString();
	}
	
	public void setApplicationServer(String value)
	{
		if(value==null)
			this.applicationServer = null;
		else
			this.applicationServer = new ApplicationServerImpl(value, null, null);			
	}
	
	public List<String> getApplicationProvidedCalledPartyAddress()
	{
		if(applicationProvidedCalledPartyAddress==null || applicationProvidedCalledPartyAddress.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ApplicationProvidedCalledPartyAddress curr:applicationProvidedCalledPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setApplicationProvidedCalledPartyAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.applicationProvidedCalledPartyAddress = null;
		else
		{
			this.applicationProvidedCalledPartyAddress = new ArrayList<ApplicationProvidedCalledPartyAddress>();
			for(String curr:value)
				this.applicationProvidedCalledPartyAddress.add(new ApplicationProvidedCalledPartyAddressImpl(curr, null, null));
		}
	}	
	
	public StatusASCodeEnum getStatusASCode()
	{
		if(statusASCode==null)
			return null;
		
		return statusASCode.getEnumerated(StatusASCodeEnum.class);
	}
	
	public void setStatusASCode(StatusASCodeEnum value)
	{
		if(value==null)
			this.statusASCode = null;
		else
			this.statusASCode = new StatusASCodeImpl(value, null, null);			
	}
}