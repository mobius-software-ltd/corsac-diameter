package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.rx.AARequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CallingPartyAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ReservationPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.ReferenceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFApplicationIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFChargingIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFRequestedDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.GCSIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.IMSContentIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.IMSContentTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.IPDomainIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MCPTTIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MCVideoIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MPSActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MPSIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.PreEmptionControlInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RequiredAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RxRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SIPForkingIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ServiceInfoStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ServiceURNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SpecificActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CallingPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nt.ReferenceId;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFRequestedData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.GCSIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.IMSContentIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.IMSContentType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.IMSContentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.IPDomainId;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MCPTTIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MCVideoIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MPSAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MPSActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MPSIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.PreEmptionControlInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RxRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RxRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndication;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceInfoStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceInfoStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceURN;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;

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
@DiameterCommandImplementation(applicationId = 16777236, commandCode = 265, request = true)
public class AARequestImpl extends RxRequestImpl implements AARequest
{
	private IPDomainId ipDomainId;
	
	private AuthSessionState authSessionState;
	
	private AFApplicationIdentifier afApplicationIdentifier;
	
	private List<MediaComponentDescription> mediaComponentDescription;
	
	private ServiceInfoStatus serviceInfoStatus;
	
	private AFChargingIdentifier afChargingIdentifier;
	
	private SIPForkingIndication sipForkingIndication;
	
	private List<SpecificAction> specificAction;
	
	private List<SubscriptionId> subscriptionId;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private ReservationPriority reservationPriority;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private CalledStationId calledStationId;
	
	private ServiceURN serviceURN;
	
	private SponsoredConnectivityData sponsoredConnectivityData;
	
	private MPSIdentifier mpsIdentifier;
	
	private GCSIdentifier gcSIdentifier;
	
	private MCPTTIdentifier mcPTTIdentifier;
	
	private MCVideoIdentifier mcVideoIdentifier;
	
	private IMSContentIdentifier imsContentIdentifier;
	
	private IMSContentType imsContentType;
	
	private List<CallingPartyAddress> callingPartyAddress;
	
	private CalleeInformation calleeInformation;
	
	private RxRequestType rxRequestType;
	
	private List<RequiredAccessInfo> requiredAccessInfo;
	
	private AFRequestedData afRequestedData;
	
	private ReferenceId referenceId;
	
	private PreEmptionControlInfo preEmptionControlInfo;
	
	private MPSAction mpsAction;
	
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm, Boolean isRetransmit, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
	}
	
	@Override
	public ByteBuf getIPDomainId()
	{
		if(ipDomainId==null)
			return null;
		
		return this.ipDomainId.getValue();
	}
	
	@Override
	public void setIPDomainId(ByteBuf value)
	{
		if(value==null)
			this.ipDomainId = null;
		else
			this.ipDomainId = new IPDomainIdImpl(value, null, null);
	}			
	
	@Override
	public AuthSessionStateEnum getAuthSessionState()
	{
		if(authSessionState==null)
			return null;
		
		return this.authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}
	
	@Override
	public void setAuthSessionState(AuthSessionStateEnum value)
	{
		if(value==null)
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}				
	
	@Override
	public ByteBuf getAFApplicationIdentifier()
	{
		if(afApplicationIdentifier==null)
			return null;
		
		return this.afApplicationIdentifier.getValue();
	}
	
	@Override
	public void setAFApplicationIdentifier(ByteBuf value)
	{
		if(value==null)
			this.afApplicationIdentifier = null;
		else
			this.afApplicationIdentifier = new AFApplicationIdentifierImpl(value, null, null);
	}			
	
	@Override
	public List<MediaComponentDescription> getMediaComponentDescription()
	{
		return this.mediaComponentDescription;
	}
	
	@Override
	public void setMediaComponentDescription(List<MediaComponentDescription> value)
	{
		this.mediaComponentDescription = value;
	}
	
	@Override
	public ServiceInfoStatusEnum getServiceInfoStatus()
	{
		if(serviceInfoStatus==null)
			return null;
		
		return this.serviceInfoStatus.getEnumerated(ServiceInfoStatusEnum.class);
	}
	
	@Override
	public void setServiceInfoStatus(ServiceInfoStatusEnum value)
	{
		if(value==null)
			this.serviceInfoStatus = null;
		else
			this.serviceInfoStatus = new ServiceInfoStatusImpl(value, null, null);
	}				
	
	@Override
	public ByteBuf getAFChargingIdentifier()
	{
		if(afChargingIdentifier==null)
			return null;
		
		return this.afChargingIdentifier.getValue();
	}
	
	@Override
	public void setAFChargingIdentifier(ByteBuf value)
	{
		if(value==null)
			this.afChargingIdentifier = null;
		else
			this.afChargingIdentifier = new AFChargingIdentifierImpl(value, null, null);
	}			
		
	@Override
	public SIPForkingIndicationEnum getSIPForkingIndication()
	{
		if(sipForkingIndication==null)
			return null;
		
		return this.sipForkingIndication.getEnumerated(SIPForkingIndicationEnum.class);
	}
	
	@Override
	public void setSIPForkingIndication(SIPForkingIndicationEnum value)
	{
		if(value==null)
			this.sipForkingIndication = null;
		else
			this.sipForkingIndication = new SIPForkingIndicationImpl(value, null, null);
	}				
	
	@Override
	public List<SpecificActionEnum> getSpecificAction()
	{
		if(specificAction==null || specificAction.size()==0)
			return null;
		
		List<SpecificActionEnum> result=new ArrayList<SpecificActionEnum>();
		for(SpecificAction curr:specificAction)
			result.add(curr.getEnumerated(SpecificActionEnum.class));
		
		return result;
	}
	
	@Override
	public void setSpecificAction(List<SpecificActionEnum> value)
	{
		if(value==null)
			this.specificAction = null;
		else
		{
			this.specificAction = new ArrayList<SpecificAction>();
			for(SpecificActionEnum curr:value)
				this.specificAction.add(new SpecificActionImpl(curr, null, null));
		}
	}			
	
	@Override
	public List<SubscriptionId> getSubscriptionId()
	{
		return subscriptionId;
	}
	
	@Override
	public void setSubscriptionId(List<SubscriptionId> value)
	{
		this.subscriptionId = value;
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
	public ReservationPriorityEnum getReservationPriority()
	{
		if(reservationPriority==null)
			return null;
		
		return this.reservationPriority.getEnumerated(ReservationPriorityEnum.class);
	}
	
	@Override
	public void setReservationPriority(ReservationPriorityEnum value)
	{
		if(value==null)
			this.reservationPriority = null;
		else
			this.reservationPriority = new ReservationPriorityImpl(value, null, null);
	}				
	
	@Override
	public InetAddress getFramedIPAddress()
	{
		if(framedIPAddress==null)
			return null;
		
		return this.framedIPAddress.getAddress();
	}
	
	@Override
	public void setFramedIPAddress(Inet4Address value)
	{
		if(value==null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);
	}
	
	@Override
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return this.framedIPv6Prefix.getValue();
	}
	
	@Override
	public void setFramedIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	@Override
	public String getCalledStationId()
	{
		if(calledStationId==null)
			return null;
		
		return this.calledStationId.getString();
	}
	
	@Override
	public void setCalledStationId(String value)
	{
		if(value==null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getServiceURN()
	{
		if(serviceURN==null)
			return null;
		
		return this.serviceURN.getValue();
	}
	
	@Override
	public void setServiceURN(ByteBuf value)
	{
		if(value==null)
			this.serviceURN = null;
		else
			this.serviceURN = new ServiceURNImpl(value, null, null);
	}	
	
	@Override
	public SponsoredConnectivityData getSponsoredConnectivityData()
	{
		return this.sponsoredConnectivityData;
	}
	
	@Override
	public void setSponsoredConnectivityData(SponsoredConnectivityData value)
	{
		this.sponsoredConnectivityData = value;
	}
	
	@Override
	public ByteBuf getMPSIdentifier()
	{
		if(mpsIdentifier==null)
			return null;
		
		return this.mpsIdentifier.getValue();
	}
	
	@Override
	public void setMPSIdentifier(ByteBuf value)
	{
		if(value==null)
			this.mpsIdentifier = null;
		else
			this.mpsIdentifier = new MPSIdentifierImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getGCSIdentifier()
	{
		if(gcSIdentifier==null)
			return null;
		
		return this.gcSIdentifier.getValue();
	}
	
	@Override
	public void setGCSIdentifier(ByteBuf value)
	{
		if(value==null)
			this.gcSIdentifier = null;
		else
			this.gcSIdentifier = new GCSIdentifierImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getMCPTTIdentifier()
	{
		if(mcPTTIdentifier==null)
			return null;
		
		return this.mcPTTIdentifier.getValue();
	}
	
	@Override
	public void setMCPTTIdentifier(ByteBuf value)
	{
		if(value==null)
			this.mcPTTIdentifier = null;
		else
			this.mcPTTIdentifier = new MCPTTIdentifierImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getMCVideoIdentifier()
	{
		if(mcVideoIdentifier==null)
			return null;
		
		return this.mcVideoIdentifier.getValue();
	}
	
	@Override
	public void setMCVideoIdentifier(ByteBuf value)
	{
		if(value==null)
			this.mcVideoIdentifier = null;
		else
			this.mcVideoIdentifier = new MCVideoIdentifierImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getIMSContentIdentifier()
	{
		if(imsContentIdentifier==null)
			return null;
		
		return this.imsContentIdentifier.getValue();
	}
	
	@Override
	public void setIMSContentIdentifier(ByteBuf value)
	{
		if(value==null)
			this.imsContentIdentifier = null;
		else
			this.imsContentIdentifier = new IMSContentIdentifierImpl(value, null, null);
	}
	
	@Override
	public IMSContentTypeEnum getIMSContentType()
	{
		if(imsContentType==null)
			return null;
		
		return this.imsContentType.getEnumerated(IMSContentTypeEnum.class);
	}
	
	@Override
	public void setIMSContentType(IMSContentTypeEnum value)
	{
		if(value==null)
			this.imsContentType = null;
		else
			this.imsContentType = new IMSContentTypeImpl(value, null, null);
	}	
	
	@Override
	public List<String> getCallingPartyAddress()
	{
		if(callingPartyAddress==null || callingPartyAddress.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(CallingPartyAddress curr:callingPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setCallingPartyAddress(List<String> value)
	{
		if(value==null)
			this.callingPartyAddress = null;
		else
		{
			this.callingPartyAddress = new ArrayList<CallingPartyAddress>();
			for(String curr:value)
				this.callingPartyAddress.add(new CallingPartyAddressImpl(curr, null, null));
		}
	}						
	
	@Override
	public CalleeInformation getCalleeInformation()
	{
		return calleeInformation;
	}
	
	@Override
	public void setCalleeInformation(CalleeInformation value)
	{
		this.calleeInformation = value;
	}
	
	@Override
	public RxRequestTypeEnum getRxRequestType()
	{
		if(rxRequestType==null)
			return null;
		
		return this.rxRequestType.getEnumerated(RxRequestTypeEnum.class);
	}
	
	@Override
	public void setRxRequestType(RxRequestTypeEnum value)
	{
		if(value==null)
			this.rxRequestType = null;
		else
			this.rxRequestType = new RxRequestTypeImpl(value, null, null);
	}
	
	@Override
	public List<RequiredAccessInfoEnum> getRequiredAccessInfo()
	{
		if(requiredAccessInfo==null || requiredAccessInfo.size()==0)
			return null;
		
		List<RequiredAccessInfoEnum> result=new ArrayList<RequiredAccessInfoEnum>();
		for(RequiredAccessInfo curr:requiredAccessInfo)
			result.add(curr.getEnumerated(RequiredAccessInfoEnum.class));
		
		return result;
	}
	
	@Override
	public void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value)
	{
		if(value==null)
			this.requiredAccessInfo = null;
		else
		{
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
			for(RequiredAccessInfoEnum curr:value)
				this.requiredAccessInfo.add(new RequiredAccessInfoImpl(curr, null, null));
		}
	}							
	
	@Override
	public Long getAFRequestedData()
	{
		if(afRequestedData==null)
			return null;
		
		return this.afRequestedData.getUnsigned();
	}
	
	@Override
	public void setAFRequestedData(Long value)
	{
		if(value==null)
			this.afRequestedData = null;
		else
			this.afRequestedData = new AFRequestedDataImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getReferenceId()
	{
		if(referenceId==null)
			return null;
		
		return this.referenceId.getValue();
	}
	
	@Override
	public void setReferenceId(ByteBuf value)
	{
		if(value==null)
			this.referenceId = null;
		else
			this.referenceId = new ReferenceIdImpl(value, null, null);
	}
	
	@Override
	public Long getPreemptionControlInfo()
	{
		if(preEmptionControlInfo==null)
			return null;
		
		return this.preEmptionControlInfo.getUnsigned();
	}
	
	@Override
	public void setPreemptionControlInfo(Long value)
	{
		if(value==null)
			this.preEmptionControlInfo = null;
		else
			this.preEmptionControlInfo = new PreEmptionControlInfoImpl(value, null, null);
	}	
	
	@Override
	public MPSActionEnum getMPSAction()
	{
		if(mpsAction==null)
			return null;
		
		return this.mpsAction.getEnumerated(MPSActionEnum.class);
	}
	
	@Override
	public void setMPSAction(MPSActionEnum value)
	{
		if(value==null)
			this.mpsAction = null;
		else
			this.mpsAction = new MPSActionImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(destinationRealm);
      	result.add(destinationHost);
      	result.add(ipDomainId);
      	result.add(authSessionState);
      	result.add(afApplicationIdentifier);
      	
      	if(mediaComponentDescription!=null)
      		result.addAll(mediaComponentDescription);
      	
      	result.add(serviceInfoStatus);
      	result.add(afChargingIdentifier);
      	result.add(sipForkingIndication);
      	
      	if(specificAction!=null)
      		result.addAll(specificAction);
      	
      	if(subscriptionId!=null)
      		result.addAll(subscriptionId);
      	
      	result.add(ocSupportedFeatures);
      	
      	if(supportedFeatures!=null)
      		result.addAll(supportedFeatures);
      	
      	result.add(reservationPriority);
      	result.add(framedIPAddress);
      	result.add(framedIPv6Prefix);
      	result.add(calledStationId);
      	result.add(serviceURN);
      	result.add(sponsoredConnectivityData);
      	result.add(mpsIdentifier);
      	result.add(gcSIdentifier);
      	result.add(mcPTTIdentifier);
      	result.add(mcVideoIdentifier);
      	result.add(imsContentIdentifier);
      	result.add(imsContentType);
      	
      	if(callingPartyAddress!=null)
      		result.addAll(callingPartyAddress);
      	
      	result.add(calleeInformation);
      	result.add(rxRequestType);
      	
      	if(requiredAccessInfo!=null)
      		result.addAll(requiredAccessInfo);
      	
      	result.add(afRequestedData);
      	result.add(referenceId);
      	result.add(preEmptionControlInfo);
      	result.add(mpsAction);
      	result.add(originStateId);
      		
      	if(proxyInfo!=null)
      		result.addAll(proxyInfo);
      		
      	if(routeRecords!=null)
      		result.addAll(routeRecords);
      		
      	if(optionalAvps!=null)
      	{
      		for(List<DiameterAvp> curr:optionalAvps.values())
      			result.addAll(curr);
      	}
    		 
		return result;
	}
}