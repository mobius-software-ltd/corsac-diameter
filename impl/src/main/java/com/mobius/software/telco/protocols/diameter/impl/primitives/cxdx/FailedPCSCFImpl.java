package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FailedPCSCF;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PCSCFFQDN;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PCSCFIPAddress;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 664L, vendorId = KnownVendorIDs.TGPP_ID)
public class FailedPCSCFImpl extends DiameterGroupedAvpImpl implements FailedPCSCF
{
	private PCSCFFQDN pcscfFQDN;
	private List<PCSCFIPAddress> pcscfIPAddress;
	
	public FailedPCSCFImpl()
	{
		
	}
	
	public String getPCSCFFQDN()
	{
		if(pcscfFQDN==null)
			return null;
		
		return pcscfFQDN.getIdentity();
	}
	
	public void setPCSCFFQDN(String value)
	{
		if(value == null)
			this.pcscfFQDN = null;
		else
			this.pcscfFQDN = new PCSCFFQDNImpl(value, null, null);
	}
	
	public List<InetAddress> getPCSCFIPAddress()
	{
		if(pcscfIPAddress==null || pcscfIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new  ArrayList<InetAddress>();
		for(PCSCFIPAddress curr:pcscfIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setPCSCFIPAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.pcscfIPAddress = null;
		else
		{
			this.pcscfIPAddress = new ArrayList<PCSCFIPAddress>();
			for(InetAddress curr:value)
				this.pcscfIPAddress.add(new PCSCFIPAddressImpl(curr, null, null));
		}
	}
}