package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rx.AAAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetLocAccessSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.NIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RetryIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AcceptableServiceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NID;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RetryInterval;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceAuthorizationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrusted;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

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
@DiameterCommandImplementation(applicationId = 16777236, commandCode = 271, request = false)
public class AAAnswerImpl extends RxAnswerImpl implements AAAnswer
{
	private AuthSessionState authSessionState;
	
	private List<AccessNetworkChargingIdentifier> accessNetworkChargingIdentifier;
	
	private AccessNetworkChargingAddress accessNetworkChargingAddress;
	
	private AcceptableServiceInfo acceptableServiceInfo;
	
	private List<ANGWAddress> anGWAddress;
	
	private ANTrusted anTrusted;
	
	private ServiceAuthorizationInfo serviceAuthorizationInfo;
	
	private IPCANType ipcanType;
	
	private MAInformation maInformation;
	
	private NetLocAccessSupport netLocAccessSupport;
	
	private RATType ratType;
	
	private List<Flows> flows;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private List<SubscriptionId> subscriptionId;
	
	private UserEquipmentInfo userEquipmentInfo;
	
	private UserEquipmentInfoExtension userEquipmentInfoExtension;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private NID nid;
	
	private List<DiameterClass> diameterClass;	
	
	private RetryInterval retryInterval;
	
	private List<Load> load;
	
	protected AAAnswerImpl() 
	{
		super();
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);		
	}
	
	public AuthSessionStateEnum getAuthSessionState()
	{
		if(authSessionState==null)
			return null;
		
		return this.authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}
	
	public void setAuthSessionState(AuthSessionStateEnum value)
	{
		if(value==null)
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}	
	
	public List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier()
	{
		return this.accessNetworkChargingIdentifier;
	}
	
	public void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value)
	{
		this.accessNetworkChargingIdentifier = value;
	}

	@Override
	public InetAddress getAccessNetworkChargingAddress()
	{
		if(accessNetworkChargingAddress==null)
			return null;
		
		return this.accessNetworkChargingAddress.getAddress();
	}
	
	@Override
	public void setAccessNetworkChargingAddress(InetAddress value)
	{
		if(value==null)
			this.accessNetworkChargingAddress = null;
		else
			this.accessNetworkChargingAddress = new AccessNetworkChargingAddressImpl(value, null, null);
	}	
	
	public AcceptableServiceInfo getAcceptableServiceInfo()
	{
		return acceptableServiceInfo;
	}
	
	public void setAcceptableServiceInfo(AcceptableServiceInfo value)
	{
		this.acceptableServiceInfo = value;
	}
	
	@Override
	public List<InetAddress> getANGWAddress()
	{
		if(anGWAddress==null || anGWAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(ANGWAddress curr:anGWAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
	public void setANGWAddress(List<InetAddress> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 AN-GW-Address allowed");
		
		if(value==null)
			this.anGWAddress = null;
		else
		{
			this.anGWAddress = new ArrayList<ANGWAddress>();
			for(InetAddress curr:value)
				this.anGWAddress.add(new ANGWAddressImpl(curr, null, null));
		}
	}
	
	@Override
	public ANTrustedEnum getANTrusted()
	{
		if(anTrusted==null)
			return null;
		
		return this.anTrusted.getEnumerated(ANTrustedEnum.class);
	}
	
	@Override
	public void setANTrusted(ANTrustedEnum value)
	{
		if(value==null)
			this.anTrusted = null;
		else
			this.anTrusted = new ANTrustedImpl(value, null, null);
	}		
	
	public ServiceAuthorizationInfo getServiceAuthorizationInfo()
	{
		return this.serviceAuthorizationInfo;
	}
	
	public void setServiceAuthorizationInfo(ServiceAuthorizationInfo value)
	{
		this.serviceAuthorizationInfo = value;
	}	
	
	@Override
	public IPCANTypeEnum getIPCANType()
	{
		if(ipcanType==null)
			return null;
		
		return this.ipcanType.getEnumerated(IPCANTypeEnum.class);
	}
	
	@Override
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipcanType = null;
		else
			this.ipcanType = new IPCANTypeImpl(value, null, null);
	}	
	
	@Override
	public MAInformation getMAInformation()
	{
		return maInformation;
	}
	
	@Override
	public void setMAInformation(MAInformation value)
	{
		this.maInformation = value;
	}
	
	@Override
	public NetLocAccessSupportEnum getNetLocAccessSupport()
	{
		if(netLocAccessSupport==null)
			return null;
		
		return this.netLocAccessSupport.getEnumerated(NetLocAccessSupportEnum.class);
	}
	
	@Override
	public void setNetLocAccessSupport(NetLocAccessSupportEnum value)
	{
		if(value==null)
			this.netLocAccessSupport = null;
		else
			this.netLocAccessSupport = new NetLocAccessSupportImpl(value, null, null);
	}	
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType==null)
			return null;
		
		return this.ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);
	}	
	
	@Override
	public List<Flows> getFlows()
	{
		return flows;
	}
	
	@Override
	public void setFlows(List<Flows> value)
	{
		this.flows = value;
	}
	
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public List<SubscriptionId> getSubscriptionId()
	{
		return this.subscriptionId;
	}
	
	@Override
	public void setSubscriptionId(List<SubscriptionId> value)
	{
		this.subscriptionId = value;
	}
	
	public UserEquipmentInfo getUserEquipmentInfo()
	{
		return this.userEquipmentInfo;
	}
	
	public void setUserEquipmentInfo(UserEquipmentInfo value)
	{
		this.userEquipmentInfo = value;
	}

	public UserEquipmentInfoExtension getUserEquipmentInfoExtension()
	{
		return this.userEquipmentInfoExtension;
	}
	
	public void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value)
	{
		this.userEquipmentInfoExtension = value;
	}
	
	@Override
	public String get3GPPSGSNMCCMNC()
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return this.tgppSGSNMCCMNC.getString();
	}
	
	@Override
	public void set3GPPSGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getNID()
	{
		if(nid==null)
			return null;
		
		return this.nid.getValue();
	}
	
	@Override
	public void setNID(ByteBuf value)
	{
		if(value==null)
			this.nid = null;
		else
			this.nid = new NIDImpl(value, null, null);
	}
	
	@Override
	public List<ByteBuf> getDiameterClass()
	{
		if(diameterClass==null || diameterClass.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(DiameterClass curr:diameterClass)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:value)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
	}
	
	public Long getRetryInterval()
	{
		if(retryInterval==null)
			return null;
		
		return this.retryInterval.getUnsigned();
	}
	
	public void setRetryInterval(Long value)
	{
		if(value==null)
			this.retryInterval = null;
		else
			this.retryInterval = new RetryIntervalImpl(value, null, null);
	}	
	
	public List<Load> getLoad()
	{
		return this.load;
	}
	
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(anGWAddress!=null && anGWAddress.size()>2)
			return "Up to 2 AN-GW-Address allowed";
		
		return super.validate();
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
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		
		if(accessNetworkChargingIdentifier!=null)
        	result.addAll(accessNetworkChargingIdentifier);
        
		result.add(accessNetworkChargingAddress);
		result.add(acceptableServiceInfo);
		
		if(anGWAddress!=null)
        	result.addAll(anGWAddress);
        
        result.add(anTrusted);
		result.add(serviceAuthorizationInfo);
        result.add(ipcanType);
        result.add(maInformation);
        result.add(netLocAccessSupport);
        result.add(ratType);
        
        if(flows!=null)
        	result.addAll(flows);
        
        result.add(ocSupportedFeatures);
        result.add(ocOLR);
        
        if(supportedFeatures!=null)
        	result.addAll(supportedFeatures);
        
        if(subscriptionId!=null)
        	result.addAll(subscriptionId);
        
        result.add(userEquipmentInfo);
        result.add(userEquipmentInfoExtension);
        result.add(tgppSGSNMCCMNC);
        result.add(nid);
        
        if(diameterClass!=null)
        	result.addAll(diameterClass);
        
        result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(failedAvp);
        result.add(retryInterval);
		result.add(originStateId);
		
        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(redirectHostUsage);
        result.add(redirectMaxCacheTime);
        
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(load!=null)
			result.addAll(load);

		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}