package com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.EAPRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ChargeableUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ChargeableUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 5, commandCode = 268, request = true)
public class EAPRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase implements EAPRequest
{
	private AuthRequestType authRequestType;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPortType nasPortType;
	
	private EAPPayload eapPayload;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private List<MIPMobileNodeAddress> mipMobileNodeAddress;
    
	private ChargeableUserIdentity chargeableUserIdentity;
    
	private ServiceSelection serviceSelection;
    
	private QoSCapability qosCapability;
    
	private List<QoSResources> qosResources;
        		   
	protected EAPRequestImpl() 
	{
		super();
	}
	
	public EAPRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType, ByteBuf eapPayload)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthRequestType(authRequestType);
		
		setEAPPayload(eapPayload);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}

	@Override
	public String getNASIdentifier() 
	{
		if(nasIdentifier == null)
			return null;
		
		return nasIdentifier.getString();
	}

	@Override
	public void setNASIdentifier(String value) 
	{
		if(value == null)
			this.nasIdentifier = null;
		else
			this.nasIdentifier = new NASIdentifierImpl(value, null, null);
	}

	@Override
	public InetAddress getNASIPAddress() 
	{
		if(nasIPAddress == null)
			return null;
		
		return nasIPAddress.getAddress();
	}

	@Override
	public void setNASIPAddress(Inet4Address value) 
	{
		if(value == null)
			this.nasIPAddress = null;
		else
			this.nasIPAddress = new NASIPAddressImpl(value);
	}

	@Override
	public InetAddress getNASIPv6Address() 
	{
		if(nasIPv6Address == null)
			return null;
		
		return nasIPv6Address.getAddress();
	}

	@Override
	public void setNASIPv6Address(Inet6Address value) 
	{
		if(value == null)
			this.nasIPv6Address = null;
		else
			this.nasIPv6Address = new NASIPv6AddressImpl(value);
	}

	@Override
	public NASPortTypeEnum getNASPortType() 
	{
		if(nasPortType == null)
			return null;
		
		return nasPortType.getEnumerated(NASPortTypeEnum.class);
	}

	@Override
	public void setNASPortType(NASPortTypeEnum value) 
	{
		if(value == null)
			this.nasPortType = null;
		else
			this.nasPortType = new NASPortTypeImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload == null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf value) 
	{
		if(value==null)
			throw new IllegalArgumentException("EAP-Payload is required");
			
		this.eapPayload = new EAPPayloadImpl(value, null, null);
	}

	@Override
	public Long getMIP6FeatureVector() 
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}

	@Override
	public void setMIP6FeatureVector(Long value) 
	{
		if(value == null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}

	@Override
	public MIP6AgentInfo getMIP6AgentInfo() 
	{
		return mip6AgentInfo;
	}

	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value) 
	{
		this.mip6AgentInfo = value;
	}

	@Override
	public List<InetAddress> getMIPMobileNodeAddress() 
	{
		if(mipMobileNodeAddress==null || mipMobileNodeAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(MIPMobileNodeAddress curr:mipMobileNodeAddress)
			result.add(curr.getAddress());
		
		return result;
	}

	@Override
	public void setMIPMobileNodeAddress(List<InetAddress> value) 
	{
		if(value == null || value.size()==0)
			this.mipMobileNodeAddress = null;
		else if(mipMobileNodeAddress.size()>2)
			throw new IllegalArgumentException("Up to 2 MIP Mobile Node Address allowed");		
		else
		{
			this.mipMobileNodeAddress = new ArrayList<MIPMobileNodeAddress>();
			for(InetAddress curr:value)
				this.mipMobileNodeAddress.add(new MIPMobileNodeAddressImpl(curr, null, null));
		}
	}

	@Override
	public ByteBuf getChargeableUserIdentity() 
	{
		if(chargeableUserIdentity == null)
			return null;
		
		return chargeableUserIdentity.getValue();
	}

	@Override
	public void setChargeableUserIdentity(ByteBuf value) 
	{
		if(value == null)
			this.chargeableUserIdentity = null;
		else
			this.chargeableUserIdentity = new ChargeableUserIdentityImpl(value, null, null);
	}

	@Override
	public String getServiceSelection() 
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}

	@Override
	public void setServiceSelection(String value) 
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@Override
	public QoSCapability getQoSCapability() 
	{
		return qosCapability;
	}

	@Override
	public void setQoSCapability(QoSCapability value) 
	{
		this.qosCapability = value;
	}

	@Override
	public List<QoSResources> getQoSResources() 
	{
		return qosResources;
	}

	@Override
	public void setQoSResources(List<QoSResources> value) 
	{
		this.qosResources = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");
		
		if(eapPayload==null)
			return "EAP-Payload is required";
		
		if(mipMobileNodeAddress.size()>2)
			throw new IllegalArgumentException("Up to 2 MIP Mobile Node Address allowed");
		
		return super.validate();
	}
}