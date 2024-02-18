package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFDestinationHost;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFDestinationRealm;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;

/**
*
* @author yulian oifa
*
*/
public class TDFInformationImpl implements TDFInformation
{
	private TDFDestinationRealm tdfDestinationRealm;
	private TDFDestinationHost tdfDestinationHost;
	private TDFIPAddress tdfIPAddress;
		
	public TDFInformationImpl()
	{
		
	}
	
	public String getTDFDestinationRealm()
	{
		if(tdfDestinationRealm==null)
			return null;
		
		return tdfDestinationRealm.getIdentity();
	}
	
	public void setTDFDestinationRealm(String value)
	{
		if(value==null)
			this.tdfDestinationRealm = null;
		else
			this.tdfDestinationRealm = new TDFDestinationRealmImpl(value, null, null);			
	}
	
	public String getTDFDestinationHost()
	{
		if(tdfDestinationHost==null)
			return null;
		
		return tdfDestinationHost.getIdentity();
	}
	
	public void setTDFDestinationHost(String value)
	{
		if(value==null)
			this.tdfDestinationHost = null;
		else
			this.tdfDestinationHost = new TDFDestinationHostImpl(value, null, null);			
	}
	
	public InetAddress getTDFIPAddress()
	{
		if(tdfIPAddress==null)
			return null;
		
		return tdfIPAddress.getAddress();
	}
	
	public void setTDFIPAddress(InetAddress value)
	{
		if(value==null)
			this.tdfIPAddress = null;
		else
			this.tdfIPAddress = new TDFIPAddressImpl(value, null, null);			
	}
}