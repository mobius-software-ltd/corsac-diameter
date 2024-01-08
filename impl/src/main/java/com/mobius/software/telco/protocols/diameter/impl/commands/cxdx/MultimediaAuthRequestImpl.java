package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPNumberAuthItemsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPNumberAuthItems;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 303, request = true)
public class MultimediaAuthRequestImpl extends CxDxRequestWithHostBase implements MultimediaAuthRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private PublicIdentity publicIdentity;
	
	private SIPNumberAuthItems sipNumberAuthItems;
	
	private SIPAuthDataItem sipAuthDataItem;
	
	private ServerName serverName;
	
	protected MultimediaAuthRequestImpl() 
	{
		super();
	}
	
	public MultimediaAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState,String username, String publicIdentity,Long sipNumberAuthItems,SIPAuthDataItem sIPAuthDataItem, String serverName)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
		
		setUsername(username);
		setPublicIdentity(publicIdentity);
		setSIPNumberAuthItems(sipNumberAuthItems);
		setSIPAuthDataItem(sIPAuthDataItem);
		setServerName(serverName);
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	public String getPublicIdentity()
	{
		if(publicIdentity == null)
			return null;
		
		return publicIdentity.getString();
	}
	 
	public void setPublicIdentity(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Public-Identity is required");
		
		this.publicIdentity = new PublicIdentityImpl(value, null, null);
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
			throw new IllegalArgumentException("SIP-Number-Auth-Items is required");
		
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
		if(value == null)
			throw new IllegalArgumentException("SIP-Auth-Data-Item is required");
		
		this.sipAuthDataItem = value;
	} 
	
	@Override
	public String getServerName()
	{
		if(serverName == null)
			return null;
		
		return serverName.getString();
	}
	
	@Override
	public void setServerName(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Server-Name is required");
		
		this.serverName = new ServerNameImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
		if(publicIdentity == null)
			return "Public-Identity is required";
		
		if(sipNumberAuthItems == null)
			return "SIP-Number-Auth-Items is required";
		
		if(sipAuthDataItem == null)
			return "SIP-Auth-Data-Item is required";
		
		if(serverName == null)
			return "Server-Name is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		/*< Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { User-Name }
			 [ OC-Supported-Features ]
			*[ Supported-Features ]
			 { Public-Identity }
			 { SIP-Auth-Data-Item }
			 { SIP-Number-Auth-Items }
			 { Server-Name }
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]*/
		
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(username);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(publicIdentity);
		result.add(sipAuthDataItem);
		result.add(sipNumberAuthItems);
		result.add(serverName);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}