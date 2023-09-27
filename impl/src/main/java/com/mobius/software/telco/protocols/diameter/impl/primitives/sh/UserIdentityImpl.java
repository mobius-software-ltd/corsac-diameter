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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 700L, vendorId = KnownVendorIDs.TGPP_ID)
public class UserIdentityImpl extends DiameterGroupedAvpImpl implements UserIdentity
{
	private PublicIdentity publicIdentity;
	
	private MSISDN msisdn;
	
	private ExternalIdentifier externalIdentifier;
	
	protected UserIdentityImpl() 
	{
		super();
	}
	
	public UserIdentityImpl(String publicIdentity, String msisdn, String externalIdentifier)
	{
		int count=0;
		if(publicIdentity != null)
			count++;
		
		if(msisdn != null)
			count++;
		
		if(externalIdentifier != null)
			count++;
		
		if(count!=1)
			throw new IllegalArgumentException("User-Identity requires exactly one child to be defined");
		
		this.publicIdentity = new PublicIdentityImpl(publicIdentity, null, null);
		
		this.msisdn = new MSISDNImpl(msisdn);
		
		this.externalIdentifier = new ExternalIdentifierImpl(externalIdentifier, null, null);
	}
	
	public String getPublicIdentity()
	{
		if(publicIdentity==null)
			return null;
		
		return publicIdentity.getString();
	}
	
	public void setPublicIdentity(String value)
	{
		if(value==null && msisdn == null && externalIdentifier == null)
			throw new IllegalArgumentException("User-Identity requires exactly one child to be defined");
		else if(value == null )
			this.publicIdentity = null;
		else
		{
			this.publicIdentity = new PublicIdentityImpl(value, null, null);
			this.msisdn = null;
			this.externalIdentifier = null;
		}
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value==null && publicIdentity == null && externalIdentifier == null)
			throw new IllegalArgumentException("User-Identity requires exactly one child to be defined");
		else if(value == null )
			this.msisdn = null;
		else
		{
			this.publicIdentity = null;
			this.msisdn = new MSISDNImpl(value);
			this.externalIdentifier = null;
		}
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value==null && publicIdentity == null && msisdn == null)
			throw new IllegalArgumentException("User-Identity requires exactly one child to be defined");
		else if(value == null )
			this.msisdn = null;
		else
		{
			this.publicIdentity = null;
			this.msisdn = null;
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		int count=0;
		if(publicIdentity != null)
			count++;
		
		if(msisdn != null)
			count++;
		
		if(externalIdentifier != null)
			count++;
		
		if(count!=1)
			return "User-Identity requires exactly one child to be defined";
				
		return null;
	}
}