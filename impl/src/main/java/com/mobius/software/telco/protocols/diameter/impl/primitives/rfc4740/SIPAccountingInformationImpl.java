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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAccountingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAccountingServerURI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPCreditControlServerURI;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 368L, vendorId = -1L)
public class SIPAccountingInformationImpl extends DiameterGroupedAvpImpl implements SIPAccountingInformation
{
	private List<SIPAccountingServerURI> sipAccountingServerURI;
	
	private List<SIPCreditControlServerURI> sipCreditControlServerURI;
	
	public SIPAccountingInformationImpl()
	{
		
	}
	
	public List<String> getSIPAccountingServerURI()
	{
		if(sipAccountingServerURI==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SIPAccountingServerURI curr:sipAccountingServerURI)
			result.add(curr.getUri());
		
		return result;
	}
	
	public void setSIPAccountingServerURI(List<String> value) throws ParseException
	{
		if(value == null)
			this.sipAccountingServerURI = null;
		else
		{
			this.sipAccountingServerURI =  new ArrayList<SIPAccountingServerURI>();
			for(String curr: value)
				this.sipAccountingServerURI.add(new SIPAccountingServerURIImpl(curr, null, null));
		}
	}
	
	public List<String> getSIPCreditControlServerURI()
	{
		if(sipCreditControlServerURI==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SIPCreditControlServerURI curr:sipCreditControlServerURI)
			result.add(curr.getUri());
		
		return result;
	}
	
	public void setSIPCreditControlServerURI(List<String> value) throws ParseException
	{
		if(value == null)
			this.sipCreditControlServerURI = null;
		else
		{
			this.sipCreditControlServerURI =  new ArrayList<SIPCreditControlServerURI>();
			for(String curr: value)
				this.sipCreditControlServerURI.add(new SIPCreditControlServerURIImpl(curr, null, null));
		}
	}
}