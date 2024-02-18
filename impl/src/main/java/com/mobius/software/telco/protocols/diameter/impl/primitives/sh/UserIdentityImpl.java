package com.mobius.software.telco.protocols.diameter.impl.primitives.sh;
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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

/**
*
* @author yulian oifa
*
*/
public class UserIdentityImpl extends DiameterGroupedAvpImpl implements UserIdentity
{
	private PublicIdentity publicIdentity;
	
	private MSISDN msisdn;
	
	private ExternalIdentifier externalIdentifier;
	
	public UserIdentityImpl() 
	{
		super();
	}
	
	public UserIdentityImpl(String publicIdentity, String msisdn, String externalIdentifier) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
		int count=0;
		if(publicIdentity != null)
		{
			count++;
			this.publicIdentity = new PublicIdentityImpl(publicIdentity, null, null);
			avps.add(this.publicIdentity);
		}
		
		if(msisdn != null)
		{
			count++;
			this.msisdn = new MSISDNImpl(msisdn);
			avps.add(this.msisdn);
		}
		
		if(externalIdentifier != null)
		{
			count++;
			this.externalIdentifier = new ExternalIdentifierImpl(externalIdentifier, null, null);
			avps.add(this.externalIdentifier);
		}
		
		if(count==0)
			throw new MissingAvpException("User-Identity requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { }));
		
		if(count>1)
			throw new AvpOccursTooManyTimesException("User-Identity requires exactly one child to be defined", avps);		
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
			throw new MissingAvpException("User-Identity requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { }));
		
		this.publicIdentity = new PublicIdentityImpl(value, null, null);
		this.msisdn = null;
		this.externalIdentifier = null;		
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Identity requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { }));
		
		this.publicIdentity = null;
		this.msisdn = new MSISDNImpl(value);
		this.externalIdentifier = null;		
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Identity requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { }));
		
		this.publicIdentity = null;
		this.msisdn = null;
		this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);		
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		int count=0;
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
		if(publicIdentity != null)
		{
			count++;
			avps.add(publicIdentity);
		}
		
		if(msisdn != null)
		{
			count++;
			avps.add(msisdn);
		}
		
		if(externalIdentifier != null)
		{
			count++;
			avps.add(externalIdentifier);
		}
		
		if(count==0)
			return new MissingAvpException("User-Identity requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] { }));
					
		if(count!=1)
			return new AvpOccursTooManyTimesException("User-Identity requires exactly one child to be defined", avps);
				
		return null;
	}
}