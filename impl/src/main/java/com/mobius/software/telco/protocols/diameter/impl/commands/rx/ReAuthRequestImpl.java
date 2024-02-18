package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetLocAccessSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RANNASReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TCPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AbortCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.NIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SpecificActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TCPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NID;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;
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
public class ReAuthRequestImpl extends RxRequestImpl implements ReAuthRequest
{
	private List<SpecificAction> specificAction;
	
	private List<AccessNetworkChargingIdentifier> accessNetworkChargingIdentifier;
	
	private AccessNetworkChargingAddress accessNetworkChargingAddress;
	
	private List<ANGWAddress> anGWAddress;
	
	private ANTrusted anTrusted;
	
	private List<Flows> flows;
	
	private List<SubscriptionId> subscriptionId;
	
	private AbortCause abortCause;
	
	private IPCANType ipcanType;
	
	public MAInformation maInformation;
	
	private NetLocAccessSupport netLocAccessSupport;
	
	private RATType ratType;
	
	private SponsoredConnectivityData sponsoredConnectivityData;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private List<RANNASReleaseCause> ranNASReleaseCause;

	private List<FiveGSRANNASReleaseCause> fiveGSRANNASReleaseCause;

	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private NID nid;
	
	private TWANIdentifier twanIdentifier;
	
	private TCPSourcePort tcpSourcePort;
	
	private UDPSourcePort udpSourcePort;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private WirelineUserLocationInfo wirelineUserLocationInfo;
				
	private List<DiameterClass> diameterClass;

	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID,List<SpecificActionEnum> specificAction) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		
		setSpecificAction(specificAction);
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
	public void setSpecificAction(List<SpecificActionEnum> value) throws MissingAvpException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("Specific-Action is required is required", Arrays.asList(new DiameterAvp[] { new SpecificActionImpl() }));
		
		this.specificAction = new ArrayList<SpecificAction>();
		for(SpecificActionEnum curr:value)
			this.specificAction.add(new SpecificActionImpl(curr, null, null));
	}
	
	@Override
	public List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier()
	{
		return this.accessNetworkChargingIdentifier;
	}
	
	@Override
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
	public void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new ANGWAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}
		
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
	
	@Override
	public AbortCauseEnum getAbortCause()
	{
		if(abortCause==null)
			return null;
		
		return this.abortCause.getEnumerated(AbortCauseEnum.class);
	}
	
	@Override
	public void setAbortCause(AbortCauseEnum value)
	{
		if(value==null)
			this.abortCause = null;
		else
			this.abortCause = new AbortCauseImpl(value, null, null);
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
	public ByteBuf getTGPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return this.tgppUserLocationInfo.getValue();
	}
	
	@Override
	public void setTGPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	@Override
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return this.userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTGPPMSTimeZone()
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return this.tgppMSTimeZone.getValue();
	}
	
	@Override
	public void setTGPPMSTimeZone(ByteBuf value)
	{
		if(value==null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
	}	

	@Override
	public List<ByteBuf> getRANNASReleaseCause()
	{
		if(ranNASReleaseCause==null || ranNASReleaseCause.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RANNASReleaseCause curr:ranNASReleaseCause)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setRANNASReleaseCause(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ranNASReleaseCause = null;
		else
		{
			this.ranNASReleaseCause = new ArrayList<RANNASReleaseCause>();
			for(ByteBuf curr:value)
				this.ranNASReleaseCause.add(new RANNASReleaseCauseImpl(curr, null, null));
		}
	}
	
	@Override
	public List<FiveGSRANNASReleaseCause> getFiveGSRANNASReleaseCause()
	{
		return this.fiveGSRANNASReleaseCause;
	}

	@Override
	public void setFiveGSRANNASReleaseCause(List<FiveGSRANNASReleaseCause> value)
	{
		this.fiveGSRANNASReleaseCause = value;
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
	public ByteBuf getTWANIdentifier()
	{
		if(twanIdentifier==null)
			return null;
		
		return this.twanIdentifier.getValue();
	}
	
	@Override
	public void setTWANIdentifier(ByteBuf value)
	{
		if(value==null)
			this.twanIdentifier = null;
		else
			this.twanIdentifier = new TWANIdentifierImpl(value, null, null);
	}	
	
	@Override
	public Long getTCPSourcePort()
	{
		if(tcpSourcePort==null)
			return null;
		
		return this.tcpSourcePort.getUnsigned();
	}
	
	@Override
	public void setTCPSourcePort(Long value)
	{
		if(value==null)
			this.tcpSourcePort = null;
		else
			this.tcpSourcePort = new TCPSourcePortImpl(value, null, null);
	}	
	
	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return this.udpSourcePort.getUnsigned();
	}
	
	@Override
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);
	}	
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return this.ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);
	}
				
	@Override
	public WirelineUserLocationInfo getWirelineUserLocationInfo()
	{
		return this.wirelineUserLocationInfo;
	}
				
	@Override
	public void setWirelineUserLocationInfo(WirelineUserLocationInfo value)
	{
		this.wirelineUserLocationInfo = value;
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(specificAction==null || specificAction.size()==0)
			return new MissingAvpException("Specific-Action is required is required", Arrays.asList(new DiameterAvp[] { new SpecificActionImpl() }));
		
		if(anGWAddress!=null && anGWAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(anGWAddress);
			
			return new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		
		if(specificAction!=null)
			result.addAll(specificAction);
			
		result.add(ocSupportedFeatures);
		
		if(accessNetworkChargingIdentifier!=null)
			result.addAll(accessNetworkChargingIdentifier);
			
		result.add(accessNetworkChargingAddress);
		
		if(anGWAddress!=null)
			result.addAll(anGWAddress);
			
		result.add(anTrusted);
		
		if(flows!=null)
			result.addAll(flows);
			
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
			
		result.add(abortCause);
		result.add(ipcanType);
		result.add(maInformation);
		result.add(netLocAccessSupport);
		result.add(ratType);
		result.add(sponsoredConnectivityData);
		result.add(tgppUserLocationInfo);
		result.add(userLocationInfoTime);
		result.add(tgppMSTimeZone);
		
		if(ranNASReleaseCause!=null)
			result.addAll(ranNASReleaseCause);
		
		if(fiveGSRANNASReleaseCause!=null)
			result.addAll(fiveGSRANNASReleaseCause);
		
		result.add(tgppSGSNMCCMNC);
		result.add(nid);
		result.add(twanIdentifier);
		result.add(tcpSourcePort);
		result.add(udpSourcePort);
		result.add(ueLocalIPAddress);
		result.add(wirelineUserLocationInfo);
		result.add(originStateId);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
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