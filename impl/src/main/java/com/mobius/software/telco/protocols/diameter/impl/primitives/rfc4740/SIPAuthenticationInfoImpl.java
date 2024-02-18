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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestCNonceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestNextnonceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestNonceCountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestQopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.DigestResponseAuthImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestCNonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestNextnonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestNonceCount;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestQop;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.DigestResponseAuth;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationInfo;

/**
*
* @author yulian oifa
*
*/
public class SIPAuthenticationInfoImpl extends DiameterGroupedAvpImpl implements SIPAuthenticationInfo
{
	private DigestNextnonce digestNextnonce;
	
	private DigestQop digestQoP;
	
	private DigestResponseAuth digestResponseAuth;
	
	private DigestCNonce digestCNonce;
	
	private DigestNonceCount digestNonceCount;
	
	public SIPAuthenticationInfoImpl()
	{
		
	}
	
	public String getDigestNextnonce()
	{
		if(digestNextnonce==null)
			return null;
		
		return digestNextnonce.getString();
	}
	
	public void setDigestNextnonce(String value)
	{
		if(value==null)
			this.digestNextnonce = null;
		else
			this.digestNextnonce = new DigestNextnonceImpl(value, null, null);
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
	
	public String getDigestResponseAuth()
	{
		if(digestResponseAuth==null)
			return null;
		
		return digestResponseAuth.getString();
	}
	
	public void setDigestResponseAuth(String value)	
	{
		if(value==null)
			this.digestResponseAuth = null;
		else
			this.digestResponseAuth = new DigestResponseAuthImpl(value, null, null);
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
}