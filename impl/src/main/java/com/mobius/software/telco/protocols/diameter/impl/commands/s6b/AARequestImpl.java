package com.mobius.software.telco.protocols.diameter.impl.commands.s6b;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6b.AARequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPMNHASPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6b.MaximumWaitTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6b.OriginationTimeStampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.MaximumWaitTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.OriginationTimeStamp;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 265, request = true)
public class AARequestImpl extends S6bRequestImpl implements AARequest
{
	private AuthRequestType authRequestType;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	private QoSCapability qosCapability;
	
	private ServiceSelection serviceSelection;
	
	private List<SupportedFeatures> supportedFeatures;
	 
	private MIPMNHASPI mipMNHASPI;
	
	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OriginationTimeStamp originationTimeStamp;
	
	private MaximumWaitTime maximumWaitTime;
	
	private EmergencyServices emergencyServices;
	
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
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
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return this.mip6AgentInfo;
	}
	
	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
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
	public ByteBuf getVisitedNetworkIdentifier() 
	{
		if(visitedNetworkIdentifier==null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	@Override
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value == null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);
	}
	
	@Override
	public QoSCapability getQoSCapability()
	{
		return this.qosCapability;
	}
	
	@Override
	public void setQoSCapability(QoSCapability value)
	{
		this.qosCapability = value;
	}
	
	@Override
	public String getServiceSelection()
	{
		if(serviceSelection==null)
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
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;				
	}
			 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}

	@Override
	public Long getMIPMNHASPI()
	{
		if(mipMNHASPI==null)
			return null;
		
		return mipMNHASPI.getUnsigned();
	}
	
	@Override
	public void setMIPMNHASPI(Long value)
	{
		if(value == null)
			this.mipMNHASPI = null;
		else
			this.mipMNHASPI = new MIPMNHASPIImpl(value, null, null);
	}

	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public Long getOriginationTimeStamp()
	{
		if(originationTimeStamp==null)
			return null;
		
		return originationTimeStamp.getLong();
	}
	
	@Override
	public void setOriginationTimeStamp(Long value)
	{
		if(value == null)
			this.originationTimeStamp = null;
		else
			this.originationTimeStamp = new OriginationTimeStampImpl(value, null, null);
	}
	
	@Override
	public Long getMaximumWaitTime()
	{
		if(maximumWaitTime==null)
			return null;
		
		return maximumWaitTime.getUnsigned();
	}
	
	@Override
	public void setMaximumWaitTime(Long value)
	{
		if(value == null)
			this.maximumWaitTime = null;
		else
			this.maximumWaitTime = new MaximumWaitTimeImpl(value, null, null);
	}
					 
	@Override
	public Long getEmergencyServices()
	{
		if(emergencyServices==null)
			return null;
		
		return emergencyServices.getUnsigned();
	}
	
	@Override
	public void setEmergencyServices(Long value)
	{
		if(value == null)
			this.emergencyServices = null;
		else
			this.emergencyServices = new EmergencyServicesImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
}