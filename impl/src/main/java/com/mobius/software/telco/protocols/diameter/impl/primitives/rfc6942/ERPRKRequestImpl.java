package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc6942;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRKRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRealm;

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

/**
*
* @author yulian oifa
*
*/
public class ERPRKRequestImpl extends DiameterGroupedAvpImpl implements ERPRKRequest
{
	private ERPRealm erpRealm;
	
	protected ERPRKRequestImpl() 
	{
		super();
	}
	
	public ERPRKRequestImpl(String erpRealm) throws MissingAvpException
	{
		setERPRealm(erpRealm);
	}
	
	public String getERPRealm()
	{
		if(erpRealm==null)
			return null;
		
		return this.erpRealm.getIdentity();
	}
	
	public void setERPRealm(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ERP-Realm is required", Arrays.asList(new DiameterAvp[] { new ERPRealmImpl() }));
			
		this.erpRealm = new ERPRealmImpl(value, null, null);	
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(erpRealm == null)
			return new MissingAvpException("ERP-Realm is required", Arrays.asList(new DiameterAvp[] { new ERPRealmImpl() }));
		
		return null;
	}
}