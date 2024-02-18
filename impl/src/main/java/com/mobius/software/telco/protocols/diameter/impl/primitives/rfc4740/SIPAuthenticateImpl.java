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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestAlgorithmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestAuthParamImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestDomainImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestHA1Impl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestNonceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestOpaqueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestQopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestStaleImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestAlgorithm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestAuthParam;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestDomain;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestHA1;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestNonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestOpaque;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestQop;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestRealm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestStale;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticate;

/**
*
* @author yulian oifa
*
*/
public class SIPAuthenticateImpl extends DiameterGroupedAvpImpl implements SIPAuthenticate
{
	private DigestRealm digestRealm;
	
	private DigestNonce digestNonce;
	
	private DigestDomain digestDomain;
	
	private DigestOpaque digestOpaque;
	
	private DigestStale digestStale;
	
	private DigestAlgorithm digestAlgorithm;
	
	private DigestQop digestQoP;
	
	private DigestHA1 digestHA1;
	
	private List<DigestAuthParam> digestAuthParam;
	
	protected SIPAuthenticateImpl()
	{
		
	}
	
	public SIPAuthenticateImpl(String digestRealm) throws MissingAvpException
	{
		setDigestRealm(digestRealm);
	}
	
	public String getDigestRealm()
	{
		if(digestRealm==null)
			return null;
		
		return digestRealm.getString();
	}
	
	public void setDigestRealm(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Digest-Realm is required is required", Arrays.asList(new DiameterAvp[] { new DigestRealmImpl() }));
		
		this.digestRealm = new DigestRealmImpl(value, null, null);
	}

	public String getDigestNonce()
	{
		if(digestNonce==null)
			return null;
		
		return digestNonce.getString();
	}
	
	public void setDigestNonce(String value)
	{
		if(value==null)
			this.digestNonce = null;
		else
			this.digestNonce = new DigestNonceImpl(value, null, null);
	}
	
	public String getDigestDomain()
	{
		if(digestDomain==null)
			return null;
		
		return digestDomain.getString();
	}
	
	public void setDigestDomain(String value)
	{
		if(value==null)
			this.digestDomain = null;
		else
			this.digestDomain = new DigestDomainImpl(value, null, null);
	}
	
	public String getDigestOpaque()
	{
		if(digestOpaque==null)
			return null;
		
		return digestOpaque.getString();
	}
	
	public void setDigestOpaque(String value)
	{
		if(value==null)
			this.digestOpaque = null;
		else
			this.digestOpaque = new DigestOpaqueImpl(value, null, null);
	}
	
	public String getDigestStale()
	{
		if(digestStale==null)
			return null;
		
		return digestStale.getString();
	}
	
	public void setDigestStale(String value)
	{
		if(value==null)
			this.digestStale = null;
		else
			this.digestStale = new DigestStaleImpl(value, null, null);
	}
	
	public String getDigestAlgorithm()
	{
		if(digestAlgorithm==null)
			return null;
		
		return digestAlgorithm.getString();
	}
	
	public void setDigestAlgorithm(String value)
	{
		if(value==null)
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
		if(value==null)
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
		if(value==null)
			this.digestHA1 = null;
		else
			this.digestHA1 = new DigestHA1Impl(value, null, null);
	}
	
	public List<String> getDigestAuthParam()
	{
		if(digestAuthParam==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(DigestAuthParam curr:digestAuthParam)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setDigestAuthParam(List<String> value)
	{
		if(value == null)
			this.digestAuthParam = null;
		else
		{
			this.digestAuthParam =  new ArrayList<DigestAuthParam>();
			for(String curr: value)
				this.digestAuthParam.add(new DigestAuthParamImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(digestRealm == null)
			return new MissingAvpException("Digest-Realm is required is required", Arrays.asList(new DiameterAvp[] { new DigestRealmImpl() }));
		
		return null;
	}	
}