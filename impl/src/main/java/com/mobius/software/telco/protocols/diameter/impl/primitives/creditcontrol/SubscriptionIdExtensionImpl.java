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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class SubscriptionIdExtensionImpl extends DiameterGroupedAvpImpl implements SubscriptionIdExtension
{
	private SubscriptionIdE164 e164;
	
	private SubscriptionIdIMSI imsi;
	
	private SubscriptionIdSIPURI sipURI;
	
	private SubscriptionIdNAI nai;
	
	private SubscriptionIdPrivate uePrivate;
	
	public SubscriptionIdExtensionImpl() 
	{
	}
	
	public SubscriptionIdExtensionImpl(String e164,String imsi,String sipURI,String nai,String uePrivate) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		Integer itemsDefined = 0;
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>(); 
		if(e164!=null)
		{
			itemsDefined ++;
			this.e164 = new SubscriptionIdE164Impl(e164, null, null);
			avps.add(this.e164);
		}
		
		if(imsi!=null)
		{
			itemsDefined ++;
			this.imsi = new SubscriptionIdIMSIImpl(imsi, null, null);
			avps.add(this.imsi);
		}
		
		if(sipURI!=null)
		{
			itemsDefined ++;
			this.sipURI = new SubscriptionIdSIPURIImpl(sipURI, null, null);
			avps.add(this.sipURI);
		}
		
		if(nai!=null)
		{
			itemsDefined ++;
			this.nai = new SubscriptionIdNAIImpl(nai, null, null);
			avps.add(this.nai);
		}
		
		if(uePrivate!=null)
		{
			itemsDefined ++;
			this.uePrivate = new SubscriptionIdPrivateImpl(uePrivate, null, null);
			avps.add(this.uePrivate);
		}
		
		if(itemsDefined==0)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
			
		if(itemsDefined>0)
			throw new AvpOccursTooManyTimesException("Subscription-Id-Extension requires exactly one child to be defined", avps);		
	}
	
	public String getE164()
	{
		if(e164==null)
			return null;
		
		return e164.getString();
	}
	
	public void setE164(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		this.e164 = new SubscriptionIdE164Impl(value, null, null);				
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
	
	public void setIMSI(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		this.imsi = new SubscriptionIdIMSIImpl(value, null, null);				
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
	
	public void setSIPURI(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		this.sipURI = new SubscriptionIdSIPURIImpl(value, null, null);				
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
	
	public void setNAI(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		this.nai = new SubscriptionIdNAIImpl(value, null, null);				
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
	
	public void setPrivate(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		this.uePrivate = new SubscriptionIdPrivateImpl(value, null, null);				
		this.e164 = null;
		this.imsi = null;
		this.sipURI = null;
		this.nai = null;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		Integer itemsDefined = 0;
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
		
		if(e164!=null)
		{
			itemsDefined ++;
			avps.add(e164);
		}
		
		if(imsi!=null)
		{
			itemsDefined ++;
			avps.add(imsi);
		}
		
		if(sipURI!=null)
		{
			itemsDefined ++;
			avps.add(sipURI);
		}
		
		if(nai!=null)
		{
			itemsDefined ++;
			avps.add(nai);
		}
		
		if(uePrivate!=null)
		{
			itemsDefined ++;
			avps.add(uePrivate);
		}
		
		if(itemsDefined==0)
			return new MissingAvpException("Subscription-Id-Extension is required is required", Arrays.asList(new DiameterAvp[] {  }));
		
		if(itemsDefined!=1)
			return new AvpOccursTooManyTimesException("Subscription-Id-Extension requires exactly one child to be defined", avps);
		
		return null;
	}
}