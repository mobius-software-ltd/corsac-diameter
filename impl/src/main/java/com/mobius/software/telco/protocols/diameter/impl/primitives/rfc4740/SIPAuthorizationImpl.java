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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestCNonceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestEntityBodyHashImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestNonceCountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestNonceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestOpaqueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestQopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestURIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestUsernameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestAlgorithm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestAuthParam;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestCNonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestEntityBodyHash;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestMethod;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestNonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestNonceCount;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestOpaque;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestQop;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestRealm;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestResponse;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestURI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestUsername;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthorization;

/**
*
* @author yulian oifa
*
*/
public class SIPAuthorizationImpl extends DiameterGroupedAvpImpl implements SIPAuthorization
{
	private DigestUsername digestUsername;
	
	private DigestRealm digestRealm;
	
	private DigestNonce digestNonce;
	
	private DigestURI digestURI;
	
	private DigestResponse digestResponse;
	
	private DigestAlgorithm digestAlgorithm;
	
	private DigestCNonce digestCNonce;
	
	private DigestOpaque digestOpaque;
	
	private DigestQop digestQop;
	
	private DigestNonceCount digestNonceCount;
	
	private DigestMethod digestMethod;
	
	private DigestEntityBodyHash digestEntityBodyHash;
	
	private List<DigestAuthParam> digestAuthParam;
	
	protected SIPAuthorizationImpl()
	{
		
	}
	
	public SIPAuthorizationImpl(String digestUsername,String digestRealm,String digestNonce,String digestURI,String digestResponse) throws MissingAvpException
	{
		setDigestUsername(digestUsername);
		
		setDigestRealm(digestRealm);
		
		setDigestNonce(digestNonce);
		
		setDigestURI(digestURI);
		
		setDigestResponse(digestResponse);		
	}
	
	public String getDigestUsername()
	{
		if(digestUsername==null)
			return null;
		
		return digestUsername.getString();
	}
	
	public void setDigestUsername(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Digest-Username is required is required", Arrays.asList(new DiameterAvp[] { new DigestUsernameImpl() }));
		
		this.digestUsername = new DigestUsernameImpl(value, null, null);
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
	
	public void setDigestNonce(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Digest-Nonce is required is required", Arrays.asList(new DiameterAvp[] { new DigestNonceImpl() }));
			
		this.digestNonce = new DigestNonceImpl(value, null, null);
	}
	
	public String getDigestURI()
	{
		if(digestURI==null)
			return null;
		
		return digestURI.getString();
	}
	
	public void setDigestURI(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Digest-URI is required is required", Arrays.asList(new DiameterAvp[] { new DigestURIImpl() }));
			
		this.digestURI = new DigestURIImpl(value, null, null);
	}
	
	public String getDigestResponse()
	{
		if(digestResponse==null)
			return null;
		
		return digestResponse.getString();
	}
	
	public void setDigestResponse(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Digest-Response is required is required", Arrays.asList(new DiameterAvp[] { new DigestResponseImpl() }));
			
		this.digestResponse = new DigestResponseImpl(value, null, null);
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
	
	public String getDigestCNonce()
	{
		if(digestCNonce==null)
			return null;
		
		return digestCNonce.getString();
	}
	
	public void setDigestCNonce(String value)
	{
		if(value==null)
			this.digestCNonce = null;
		else
			this.digestCNonce = new DigestCNonceImpl(value, null, null);
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
	
	public String getDigestQoP()
	{
		if(digestQop==null)
			return null;
		
		return digestQop.getString();
	}
	
	public void setDigestQoP(String value)
	{
		if(value==null)
			this.digestQop = null;
		else
			this.digestQop = new DigestQopImpl(value, null, null);
	}
	
	public String getDigestNonceCount()
	{
		if(digestNonceCount==null)
			return null;
		
		return digestNonceCount.getString();
	}
	
	public void setDigestNonceCount(String value)
	{
		if(value==null)
			this.digestNonceCount = null;
		else
			this.digestNonceCount = new DigestNonceCountImpl(value, null, null);
	}
	
	public String getDigestMethod()
	{
		if(digestMethod==null)
			return null;
		
		return digestMethod.getString();
	}
	
	public void setDigestMethod(String value)
	{
		if(value==null)
			this.digestMethod = null;
		else
			this.digestMethod = new DigestMethodImpl(value, null, null);
	}
	
	public String getDigestEntityBodyHash()
	{
		if(digestEntityBodyHash==null)
			return null;
		
		return digestEntityBodyHash.getString();
	}
	
	public void setDigestEntityBodyHash(String value)
	{
		if(value==null)
			this.digestEntityBodyHash = null;
		else
			this.digestEntityBodyHash = new DigestEntityBodyHashImpl(value, null, null);
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
		if(digestUsername == null)
			return new MissingAvpException("Digest-Username is required is required", Arrays.asList(new DiameterAvp[] { new DigestUsernameImpl() }));
		
		if(digestRealm == null)
			return new MissingAvpException("Digest-Realm is required is required", Arrays.asList(new DiameterAvp[] { new DigestRealmImpl() }));
		
		if(digestNonce == null)
			return new MissingAvpException("Digest-Nonce is required is required", Arrays.asList(new DiameterAvp[] { new DigestNonceImpl() }));
		
		if(digestURI == null)
			return new MissingAvpException("Digest-URI is required is required", Arrays.asList(new DiameterAvp[] { new DigestURIImpl() }));
		
		if(digestResponse == null)
			return new MissingAvpException("Digest-Response is required is required", Arrays.asList(new DiameterAvp[] { new DigestResponseImpl() }));
		
		return null;
	}		
}