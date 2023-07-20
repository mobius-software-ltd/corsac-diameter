package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdE164;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdNAI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdPrivate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdSIPURI;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 659L, vendorId = -1)
public class SubscriptionIdExtensionImpl extends DiameterGroupedAvpImpl implements SubscriptionIdExtension
{
	private SubscriptionIdE164 e164;
	
	private SubscriptionIdIMSI imsi;
	
	private SubscriptionIdSIPURI sipURI;
	
	private SubscriptionIdNAI nai;
	
	private SubscriptionIdPrivate uePrivate;
	
	protected SubscriptionIdExtensionImpl() 
	{
	}
	
	public SubscriptionIdExtensionImpl(String e164,String imsi,String sipURI,String nai,String uePrivate)
	{
		Integer itemsDefined = 0;
		if(e164!=null)
		{
			itemsDefined ++;
			this.e164 = new SubscriptionIdE164Impl(e164, null, null);
		}
		
		if(imsi!=null)
		{
			itemsDefined ++;
			this.imsi = new SubscriptionIdIMSIImpl(imsi, null, null);
		}
		
		if(sipURI!=null)
		{
			itemsDefined ++;
			this.sipURI = new SubscriptionIdSIPURIImpl(sipURI, null, null);
		}
		
		if(nai!=null)
		{
			itemsDefined ++;
			this.nai = new SubscriptionIdNAIImpl(nai, null, null);
		}
		
		if(uePrivate!=null)
		{
			itemsDefined ++;
			this.uePrivate = new SubscriptionIdPrivateImpl(uePrivate, null, null);
		}
		
		if(itemsDefined!=1)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");		
	}
	
	public String getE164()
	{
		if(e164==null)
			return null;
		
		return e164.getString();
	}
	
	public void setE164(String e164)
	{
		if(this.e164!=null && e164==null)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");
		
		this.e164 = new SubscriptionIdE164Impl(e164, null, null);				
		this.imsi = null;
		this.sipURI = null;
		this.nai = null;
		this.uePrivate = null;
	}
	
	public String getIMSI()
	{
		if(imsi==null)
			return null;
		
		return imsi.getString();
	}
	
	public void setIMSI(String imsi)
	{
		if(this.imsi!=null && imsi==null)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");
		
		this.imsi = new SubscriptionIdIMSIImpl(imsi, null, null);				
		this.e164 = null;
		this.sipURI = null;
		this.nai = null;
		this.uePrivate = null;
	}
	
	public String getSIPURI()
	{
		if(sipURI==null)
			return null;
		
		return sipURI.getString();
	}
	
	public void setSIPURI(String sipURI)
	{
		if(this.sipURI!=null && sipURI==null)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");
		
		this.sipURI = new SubscriptionIdSIPURIImpl(sipURI, null, null);				
		this.e164 = null;
		this.imsi = null;
		this.nai = null;
		this.uePrivate = null;
	}
	
	public String getNAI()
	{
		if(nai==null)
			return null;
		
		return nai.getString();
	}
	
	public void setNAI(String nai)
	{
		if(this.nai!=null && nai==null)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");
		
		this.nai = new SubscriptionIdNAIImpl(nai, null, null);				
		this.e164 = null;
		this.imsi = null;
		this.sipURI = null;
		this.uePrivate = null;
	}
	
	public String getPrivate()
	{
		if(uePrivate==null)
			return null;
		
		return uePrivate.getString();
	}
	
	public void setPrivate(String uePrivate)
	{
		if(this.uePrivate!=null && uePrivate==null)
			throw new IllegalArgumentException("Subscription-Id-Extension requires exactly one child to be defined");
		
		this.uePrivate = new SubscriptionIdPrivateImpl(uePrivate, null, null);				
		this.e164 = null;
		this.imsi = null;
		this.sipURI = null;
		this.nai = null;
	}
	
	@DiameterValidate
	public String validate()
	{
		Integer itemsDefined = 0;
		if(e164!=null)
			itemsDefined ++;
		
		if(imsi!=null)
			itemsDefined ++;
		
		if(sipURI!=null)
			itemsDefined ++;
		
		if(nai!=null)
			itemsDefined ++;
		
		if(uePrivate!=null)
			itemsDefined ++;
		
		if(itemsDefined!=1)
			return "Subscription-Id-Extension requires exactly one child to be defined";
		
		return null;
	}
}