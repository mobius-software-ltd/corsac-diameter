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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCSASAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCSAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCSRealm;

/**
*
* @author yulian oifa
*
*/
public class SCSASAddressImpl implements SCSASAddress
{
	private SCSRealm scsRealm;
	private SCSAddress scsAddress;
		
	public SCSASAddressImpl()
	{
		
	}
	
	public String getSCSRealm()
	{
		if(scsRealm==null)
			return null;
		
		return scsRealm.getIdentity();
	}
	
	public void setSCSRealm(String value)
	{
		if(value==null)
			this.scsRealm = null;
		else
			this.scsRealm = new SCSRealmImpl(value, null, null);			
	}
	
	public InetAddress getSCSAddress()
	{
		if(scsAddress==null)
			return null;
		
		return scsAddress.getAddress();
	}
	
	public void setSCSAddress(InetAddress value)
	{
		if(value==null)
			this.scsAddress = null;
		else
			this.scsAddress = new SCSAddressImpl(value, null, null);			
	}
}