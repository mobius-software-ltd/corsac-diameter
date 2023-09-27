package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginRealm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 347L, vendorId = -1L)
public class MIPOriginatingForeignAAAImpl extends DiameterGroupedAvpImpl implements MIPOriginatingForeignAAA
{
	private OriginHost originHost;
	
	private OriginRealm originRealm;
	
	protected MIPOriginatingForeignAAAImpl()
	{
		
	}
	
	public MIPOriginatingForeignAAAImpl(String originHost,String originRealm)
	{
		if(originHost==null)
			throw new IllegalArgumentException("Origin-Host is required");
		
		if(originRealm==null)
			throw new IllegalArgumentException("Origin-Realm is required");
		
		this.originHost = new OriginHostImpl(originHost, null, null);		
		
		this.originRealm = new OriginRealmImpl(originHost, null, null);
	}
	
	public String getOriginHost()
	{
		if(originHost == null)
			return null;
		
		return originHost.getIdentity();
	}
	
	public void setOriginHost(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Origin-Host is required");
		
		this.originHost = new OriginHostImpl(value, null, null);		
	}
	
	public String getOriginRealm()
	{
		if(originRealm == null)
			return null;
		
		return originRealm.getIdentity();
	}
	
	public void setOriginRealm(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Origin-Realm is required");
		
		this.originRealm = new OriginRealmImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(originHost==null)
			return "Origin-Host is required";
		
		if(originRealm==null)
			return "Origin-Realm is required";
		
		return null;
	}
}