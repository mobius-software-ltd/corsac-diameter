package com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.MultiRoundTimeOutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPKeyNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPReissuedPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ChargeableUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.MultiRoundTimeOut;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPKeyName;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPReissuedPayload;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
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
@DiameterCommandImplementation(applicationId = 5, commandCode = 268, request = false)
public class EAPAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private EAPReissuedPayload eapReissuedPayload;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private EAPKeyName eapKeyName;
	
	private MultiRoundTimeOut multiRoundTimeOut;

	private List<MIPMobileNodeAddress> mipMobileNodeAddress;
    
	private MIP6FeatureVector mip6FeatureVector;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private ServiceSelection serviceSelection;
    
	private List<QoSResources> qosResources;
	
	private ChargeableUserIdentity chargeableUserIdentity;
    
	protected EAPAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public EAPAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setAuthRequestType(authRequestType);
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
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload==null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf value) 
	{
		if(value == null)
			this.eapPayload = null;
		else
			this.eapPayload = new EAPPayloadImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPReissuedPayload() 
	{
		if(eapReissuedPayload==null)
			return null;
		
		return eapReissuedPayload.getValue();
	}

	@Override
	public void setEAPReissuedPayload(ByteBuf value) 
	{
		if(value == null)
			this.eapReissuedPayload = null;
		else
			this.eapReissuedPayload = new EAPReissuedPayloadImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPMasterSessionKey() 
	{
		if(eapMasterSessionKey==null)
			return null;
		
		return eapMasterSessionKey.getValue();
	}

	@Override
	public void setEAPMasterSessionKey(ByteBuf value) 
	{
		if(value == null)
			this.eapMasterSessionKey = null;
		else
			this.eapMasterSessionKey = new EAPMasterSessionKeyImpl(value, null, null);
	}

	@Override
	public ByteBuf getEAPKeyName() 
	{
		if(eapKeyName==null)
			return null;
		
		return eapKeyName.getValue();
	}

	@Override
	public void setEAPKeyName(ByteBuf value) 
	{
		if(value == null)
			this.eapKeyName = null;
		else
			this.eapKeyName = new EAPKeyNameImpl(value, null, null);
	}
	
	@Override
	public Long getMultiRoundTimeOut() 
	{
		if(multiRoundTimeOut == null)
			return null;
		
		return multiRoundTimeOut.getUnsigned();
	}

	@Override
	public void setMultiRoundTimeOut(Long value) 
	{
		if(value == null)
			this.multiRoundTimeOut = null;
		else
			this.multiRoundTimeOut = new MultiRoundTimeOutImpl(value, null, null);
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
	public List<QoSResources> getQoSResources() 
	{
		return qosResources;
	}

	@Override
	public void setQoSResources(List<QoSResources> value) 
	{
		this.qosResources = value;
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
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		if(mipMobileNodeAddress.size()>2)
			throw new IllegalArgumentException("Up to 2 MIP Mobile Node Address allowed");
		
		return super.validate();
	}
}