package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.SIPAORImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPNumberAuthItemsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPServerURIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.SIPAOR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPMethod;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPNumberAuthItems;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerURI;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
public class MultimediaAuthRequestImpl extends Rfc4740RequestImpl implements MultimediaAuthRequest
{
	
	
	private SIPAOR sipAOR;
	
	private SIPMethod sipMethod;
	
	private SIPServerURI sipServerURI;
	
	private SIPNumberAuthItems sipNumberAuthItems;
	
	private SIPAuthDataItem sipAuthDataItem;
	
	protected MultimediaAuthRequestImpl() 
	{
		super();
	}
	
	public MultimediaAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState,String sipAOR, String sipMethod) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId,authSessionState);
		
		setSIPAOR(sipAOR);
		
		setSIPMethod(sipMethod);
	}

	@Override
	public String getSIPAOR()
	{
		if(sipAOR == null)
			return null;
		
		return sipAOR.getString();
	}
	
	@Override
	public void setSIPAOR(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SIP-AOR is required", Arrays.asList(new DiameterAvp[] { new SIPAORImpl() }));
		
		this.sipAOR = new SIPAORImpl(value, null, null);
	}
	
	@Override
	public String getSIPMethod()
	{
		if(sipMethod == null)
			return null;
		
		return sipMethod.getString();
	}
	
	@Override
	public void setSIPMethod(String value) throws MissingAvpException
	{
		if(sipMethod == null)
			throw new MissingAvpException("SIP-Method is required", Arrays.asList(new DiameterAvp[] { new SIPMethodImpl() }));
		
		this.sipMethod = new SIPMethodImpl(value, null, null);
	}
	
	@Override
	public String getSIPServerURI()
	{
		if(sipServerURI == null)
			return null;
		
		return sipServerURI.getString();
	}
	
	@Override
	public void setSIPServerURI(String value)
	{
		if(value == null)
			this.sipServerURI = null;
		else
			this.sipServerURI = new SIPServerURIImpl(value, null, null);
	}
	
	@Override
	public Long getSIPNumberAuthItems()
	{
		if(sipNumberAuthItems == null)
			return null;
		
		return sipNumberAuthItems.getUnsigned();
	}
	
	@Override
	public void setSIPNumberAuthItems(Long value)
	{
		if(value == null)
			this.sipNumberAuthItems = null;
		else
			this.sipNumberAuthItems = new SIPNumberAuthItemsImpl(value, null, null);
	}
	
	@Override
	public SIPAuthDataItem getSIPAuthDataItem()
	{
		return this.sipAuthDataItem;
	}
	
	@Override
	public void setSIPAuthDataItem(SIPAuthDataItem value)
	{
		this.sipAuthDataItem = value;
	} 
	
	@DiameterValidate
	public DiameterException validate()
	{
		
		if(sipAOR == null)
			return new MissingAvpException("SIP-AOR is required", Arrays.asList(new DiameterAvp[] { new SIPAORImpl() }));
		
		if(sipMethod == null)
			return new MissingAvpException("SIP-Method is required", Arrays.asList(new DiameterAvp[] { new SIPMethodImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(sipAOR);
		result.add(sipMethod);
		result.add(destinationHost);
		result.add(username);
		result.add(sipServerURI);
		result.add(sipNumberAuthItems);
		result.add(sipAuthDataItem);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}