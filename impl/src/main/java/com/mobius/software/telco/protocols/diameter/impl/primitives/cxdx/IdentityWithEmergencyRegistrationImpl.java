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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IdentityWithEmergencyRegistration;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;

/**
*
* @author yulian oifa
*
*/
public class IdentityWithEmergencyRegistrationImpl extends DiameterGroupedAvpImpl implements IdentityWithEmergencyRegistration
{
	private UserName userName;
	
	private PublicIdentity publicIdentity;
	
	protected IdentityWithEmergencyRegistrationImpl()
	{
		
	}
	
	public IdentityWithEmergencyRegistrationImpl(String userName,String publicIdentity) throws MissingAvpException
	{
		setUserName(userName);
		
		setPublicIdentity(publicIdentity);
	}
	
	public String getUserName()
	{
		if(userName==null)
			return null;
		
		return userName.getString();
	}
	
	public void setUserName(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Name is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
			
		this.userName = new UserNameImpl(value, null, null);
	}
	
	public String getPublicIdentity()
	{
		if(publicIdentity==null)
			return null;
		
		return publicIdentity.getString();
	}
	
	public void setPublicIdentity(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Public-Identity is required", Arrays.asList(new DiameterAvp[] { new PublicIdentityImpl() }));
			
		this.publicIdentity = new PublicIdentityImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(userName==null)
			return new MissingAvpException("User-Name is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		if(publicIdentity==null)
			return new MissingAvpException("Public-Identity is required", Arrays.asList(new DiameterAvp[] { new PublicIdentityImpl() }));
		
		return null;
	}
}