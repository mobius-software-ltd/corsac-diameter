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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestAlgorithmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestHA1Impl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestQopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AlternateDigestAlgorithm;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AlternateDigestHA1;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPDigestAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestAlgorithm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestHA1;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestQop;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestRealm;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 635L, vendorId = KnownVendorIDs.TGPP_ID)
public class SIPDigestAuthenticateImpl extends DiameterGroupedAvpImpl implements SIPDigestAuthenticate
{
	private DigestRealm digestRealm;
	
	private DigestAlgorithm digestAlgorithm;
	
	private DigestQop digestQoP;
	
	private DigestHA1 digestHA1;
	
	private AlternateDigestAlgorithm alternateDigestAlgorithm;
	
	private AlternateDigestHA1 alternateDigestHA1;
	
	protected SIPDigestAuthenticateImpl()
	{
		
	}
	
	public SIPDigestAuthenticateImpl(String digestRealm)
	{
		if(digestRealm==null)
			throw new IllegalArgumentException("Digest-Realm is required");
		
		this.digestRealm = new DigestRealmImpl(digestRealm, null, null);
	}
	
	public String getDigestRealm()
	{
		if(digestRealm==null)
			return null;
		
		return digestRealm.getString();
	}
	
	public void setDigestRealm(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Digest-Realm is required");
		
		this.digestRealm = new DigestRealmImpl(value, null, null);
	}
	
	public String getDigestAlgorithm()
	{
		if(digestAlgorithm==null)
			return null;
		
		return digestAlgorithm.getString();
	}
	
	public void setDigestAlgorithm(String value)
	{
		if(value == null)
			this.digestAlgorithm = null;
		else
			this.digestAlgorithm = new DigestAlgorithmImpl(value, null, null);
	}
	
	public String getDigestQoP()
	{
		if(digestQoP==null)
			return null;
		
		return digestQoP.getString();
	}
	
	public void setDigestQoP(String value)
	{
		if(value == null)
			this.digestQoP = null;
		else
			this.digestQoP = new DigestQopImpl(value, null, null);
	}
	
	public String getDigestHA1()
	{
		if(digestHA1==null)
			return null;
		
		return digestHA1.getString();
	}
	
	public void setDigestHA1(String value)
	{
		if(value == null)
			this.digestHA1 = null;
		else
			this.digestHA1 = new DigestHA1Impl(value, null, null);
	}
	
	public String getAlternateDigestAlgorithm()
	{
		if(alternateDigestAlgorithm==null)
			return null;
		
		return alternateDigestAlgorithm.getString();
	}
	
	public void setAlternateDigestAlgorithm(String value)
	{
		if(value == null)
			this.alternateDigestAlgorithm = null;
		else
			this.alternateDigestAlgorithm = new AlternateDigestAlgorithmImpl(value, null, null);
	}
	
	public String getAlternateDigestHA1()
	{
		if(alternateDigestHA1==null)
			return null;
		
		return alternateDigestHA1.getString();
	}
	
	public void setAlternateDigestHA1(String value)
	{
		if(value == null)
			this.alternateDigestHA1 = null;
		else
			this.alternateDigestHA1 = new AlternateDigestHA1Impl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(digestRealm==null)
			return "Digest-Realm is required";
		
		return null;
	}	
}