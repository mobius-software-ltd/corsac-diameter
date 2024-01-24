package com.mobius.software.telco.protocols.diameter.impl.commands.sh;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sh.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SessionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.CurrentLocationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.DSAITagImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.DataReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.IdentitySetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.LocalTimeZoneIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.PrePagingSupportedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.RequestedDomainImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.ServiceIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.ServingNodeIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CurrentLocation;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CurrentLocationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DSAITag;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReference;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySet;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySetEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.LocalTimeZoneIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sh.LocalTimeZoneIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.PrePagingSupported;
import com.mobius.software.telco.protocols.diameter.primitives.sh.PrePagingSupportedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedDomain;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedDomainEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedNodes;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServiceIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServingNodeIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServingNodeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

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
@DiameterCommandImplementation(applicationId = 16777217, commandCode = 306, request = true)
public class UserDataRequestImpl extends ShRequestImpl implements UserDataRequest
{
	private ServerName serverName;
	
	private List<ServiceIndication> serviceIndication;
	 
	private List<DataReference> dataReference;
	 
	private List<IdentitySet> identitySet;
	 
	private RequestedDomain requestedDomain;
	
	private CurrentLocation currentLocation;
	
	private List<DSAITag> dsaiTag;
	
	private SessionPriority sessionPriority;
	
	private RequestedNodes requestedNodes;
	
	private ServingNodeIndication servingNodeIndication;
	
	private PrePagingSupported prePagingSupported;
	
	private LocalTimeZoneIndication localTimeZoneIndication;
	
	private UDRFlags udrFlags;
	
	private CallReferenceInfo callReferenceInfo;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected UserDataRequestImpl() 
	{
		super();
	}
	
	public UserDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, UserIdentity userIdentity, List<DataReferenceEnum> dataReference)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState, userIdentity);		
		
		setDataReference(dataReference);
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
			this.serverName = null;
		else
			this.serverName = new ServerNameImpl(value, null, null);
	}
	
	public List<ByteBuf> getServiceIndication()
	{
		if(serviceIndication==null || serviceIndication.size()==0)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(ServiceIndication curr:serviceIndication)
			result.add(curr.getValue());
		
		return result;
	}
	 
	public void setServiceIndication(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.serviceIndication = null;
		else
		{
			this.serviceIndication = new ArrayList<ServiceIndication>();
			for(ByteBuf curr:value)
				this.serviceIndication.add(new ServiceIndicationImpl(curr, null, null));
		}
	}
	
	public List<DataReferenceEnum> getDataReference()
	{
		if(dataReference==null || dataReference.size()==0)
			return null;
		
		List<DataReferenceEnum> result=new ArrayList<DataReferenceEnum>();
		for(DataReference curr:dataReference)
			result.add(curr.getEnumerated(DataReferenceEnum.class));
		
		return result;
	}
	 
	public void setDataReference(List<DataReferenceEnum> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Data-Reference is required");
			
		this.dataReference = new ArrayList<DataReference>();
		for(DataReferenceEnum curr:value)
			this.dataReference.add(new DataReferenceImpl(curr, null, null));
	}
	
	public List<IdentitySetEnum> getIdentitySet()
	{
		if(identitySet==null || identitySet.size()==0)
			return null;
		
		List<IdentitySetEnum> result=new ArrayList<IdentitySetEnum>();
		for(IdentitySet curr:identitySet)
			result.add(curr.getEnumerated(IdentitySetEnum.class));
		
		return result;
	}
	 
	public void setIdentitySet(List<IdentitySetEnum> value)
	{
		if(value==null || value.size()==0)
			this.identitySet = null;
		else
		{
			this.identitySet = new ArrayList<IdentitySet>();
			for(IdentitySetEnum curr:value)
				this.identitySet.add(new IdentitySetImpl(curr, null, null));
		}
	}
	
	public RequestedDomainEnum getRequestedDomain()
	{
		if(requestedDomain == null)
			return null;
		
		return requestedDomain.getEnumerated(RequestedDomainEnum.class);
	}
	
	public void setRequestedDomain(RequestedDomainEnum value)
	{
		if(value==null)
			this.requestedDomain = null;
		else
			this.requestedDomain = new RequestedDomainImpl(value, null, null);
	}
	
	public CurrentLocationEnum getCurrentLocation()
	{
		if(currentLocation == null)
			return null;
		
		return currentLocation.getEnumerated(CurrentLocationEnum.class);
	}
	
	public void setCurrentLocation(CurrentLocationEnum value)
	{
		if(value==null)
			this.currentLocation = null;
		else
			this.currentLocation = new CurrentLocationImpl(value, null, null);
	}
	
	public List<ByteBuf> getDSAITag()
	{
		if(dsaiTag==null || dsaiTag.size()==0)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(DSAITag curr:dsaiTag)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setDSAITag(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.dsaiTag = null;
		else
		{
			this.dsaiTag = new ArrayList<DSAITag>();
			for(ByteBuf curr:value)
				this.dsaiTag.add(new DSAITagImpl(curr, null, null));
		}
	}
	
	public SessionPriorityEnum getSessionPriority()
	{
		if(sessionPriority == null)
			return null;
		
		return sessionPriority.getEnumerated(SessionPriorityEnum.class);
	}
	
	public void setSessionPriority(SessionPriorityEnum value)
	{
		if(value==null)
			this.sessionPriority = null;
		else
			this.sessionPriority = new SessionPriorityImpl(value, null, null);
	}
	
	public RequestedNodes getRequestedNodes()
	{
		return requestedNodes;
	}
	
	public void setRequestedNodes(RequestedNodes value)
	{
		this.requestedNodes = value;
	}
	
	public ServingNodeIndicationEnum getServingNodeIndication()
	{
		if(servingNodeIndication == null)
			return null;
		
		return servingNodeIndication.getEnumerated(ServingNodeIndicationEnum.class);
	}
	
	public void setServingNodeIndication(ServingNodeIndicationEnum value)
	{
		if(value==null)
			this.servingNodeIndication = null;
		else
			this.servingNodeIndication = new ServingNodeIndicationImpl(value, null, null);
	}
	
	public PrePagingSupportedEnum getPrePagingSupported()
	{
		if(prePagingSupported == null)
			return null;
		
		return prePagingSupported.getEnumerated(PrePagingSupportedEnum.class);
	}
	
	public void setPrePagingSupported(PrePagingSupportedEnum value)
	{
		if(value==null)
			this.prePagingSupported = null;
		else
			this.prePagingSupported = new PrePagingSupportedImpl(value, null, null);
	}
	
	public LocalTimeZoneIndicationEnum getLocalTimeZoneIndication()
	{
		if(localTimeZoneIndication == null)
			return null;
		
		return localTimeZoneIndication.getEnumerated(LocalTimeZoneIndicationEnum.class);
	}
	
	public void setLocalTimeZoneIndication(LocalTimeZoneIndicationEnum value)
	{
		if(value==null)
			this.localTimeZoneIndication = null;
		else
			this.localTimeZoneIndication = new LocalTimeZoneIndicationImpl(value, null, null);
	}
		
	public UDRFlags getUDRFlags()
	{
		return udrFlags;
	}
	
	public void setUDRFlags(UDRFlags value)
	{
		this.udrFlags = value;
	}
	
	public CallReferenceInfo getCallReferenceInfo()
	{
		return this.callReferenceInfo;
	}
	
	public void setCallReferenceInfo(CallReferenceInfo value)
	{
		this.callReferenceInfo = value;
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(dataReference == null || dataReference.size()==0)
			return "Data-Reference is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(userIdentity);
		result.add(wildcardedPublicIdentity);
		result.add(wildcardedIMPU);
		result.add(serverName);
		
		if(serviceIndication!=null)
			result.addAll(serviceIndication);
		
		if(dataReference!=null)
			result.addAll(dataReference);
		
		if(identitySet!=null)
			result.addAll(identitySet);
		
		result.add(requestedDomain);
		result.add(currentLocation);
		
		if(dsaiTag!=null)
			result.addAll(dsaiTag);
		
		result.add(sessionPriority);
		result.add(username);
		result.add(requestedNodes);
		result.add(servingNodeIndication);
		result.add(prePagingSupported);
		result.add(localTimeZoneIndication);
		result.add(udrFlags);
		result.add(callReferenceInfo);
		result.add(ocSupportedFeatures);
		
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