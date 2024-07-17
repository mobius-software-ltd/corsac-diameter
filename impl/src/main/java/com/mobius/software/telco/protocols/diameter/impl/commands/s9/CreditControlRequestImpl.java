package com.mobius.software.telco.protocols.diameter.impl.commands.s9;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPP2BSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetworkRequestSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterOperationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSNegotiationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSUpgradeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9.MultipleBBERFActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgrade;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgradeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.MultipleBBERFAction;
import com.mobius.software.telco.protocols.diameter.primitives.s9.MultipleBBERFActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionEnforcementInfo;

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
public class CreditControlRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlRequestImpl implements CreditControlRequest
{
	private DRMP drmp;
	
	private List<SubscriptionId> subscriptionId;

	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private QoSInformation qosInformation;
	
	private List<QoSRuleReport> qosRuleReport;
	
	private List<ANGWAddress> anGWAddress;
	
	private NetworkRequestSupport networkRequestSupport;
	
	private List<PacketFilterInformation> packetFilterInformation;
	
	private PacketFilterOperation packetFilterOperation;
	
	private List<SubsessionEnforcementInfo> subsessionEnforcementInfo;
	
	private IPCANType ipcanType;
	
	private RATType ratType;
	
	private TerminationCause terminationCause;
	
	private UserEquipmentInfo userEquipmentInfo;
	
	private QoSNegotiation qosNegotiation;
	
	private QoSUpgrade qosUpgrade;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private TGPPSGSNAddress tgppSGSNAddress;
	
	private TGPPSGSNIPv6Address tgppSGSNIPv6Address;
	
	private RAI rai;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private TGPP2BSID tgpp2BSID;
	
	private List<EventTrigger> eventTrigger;
	
	private MultipleBBERFAction multipleBBERFAction;
	
	private UserCSGInformation userCSGInformation;
	
	protected CreditControlRequestImpl() 
	{
		super();
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, Long.valueOf(ApplicationIDs.S9), ccRequestType, ccRequestNumber);
	}

	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
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
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	@Override
	public List<QoSRuleReport> getQoSRuleReport()
	{
		return this.qosRuleReport;
	}
	
	@Override
	public void setQoSRuleReport(List<QoSRuleReport> value)
	{
		this.qosRuleReport = value;
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
	public NetworkRequestSupportEnum getNetworkRequestSupport()
	{
		if(networkRequestSupport==null)
			return null;
		
		return networkRequestSupport.getEnumerated(NetworkRequestSupportEnum.class);
	}
	
	@Override
	public void setNetworkRequestSupport(NetworkRequestSupportEnum value)
	{
		if(value==null)
			this.networkRequestSupport = null;
		else
			this.networkRequestSupport = new NetworkRequestSupportImpl(value, null, null);
	}
	
	@Override
	public List<PacketFilterInformation> getPacketFilterInformation()
	{
		return this.packetFilterInformation;
	}
	 
	@Override
	public void setPacketFilterInformation(List<PacketFilterInformation> value)
	{
		this.packetFilterInformation = value;
	}
	
	@Override
	public PacketFilterOperationEnum getPacketFilterOperation()
	{
		if(packetFilterOperation==null)
			return null;
		
		return packetFilterOperation.getEnumerated(PacketFilterOperationEnum.class);
	}
	
	@Override
	public void setPacketFilterOperation(PacketFilterOperationEnum value)
	{
		if(value==null)
			this.packetFilterOperation = null;
		else
			this.packetFilterOperation = new PacketFilterOperationImpl(value, null, null);
	}
	
	@Override
	public List<SubsessionEnforcementInfo> getSubsessionEnforcementInfo()
	{
		return this.subsessionEnforcementInfo;
	}
	 
	@Override
	public void setSubsessionEnforcementInfo(List<SubsessionEnforcementInfo> value)
	{
		this.subsessionEnforcementInfo = value;
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
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum value) 
	{
		if(value == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(value, null, null);
	}
	
	@Override
	public UserEquipmentInfo getUserEquipmentInfo()
	{
		return this.userEquipmentInfo;
	}
	
	@Override
	public void setUserEquipmentInfo(UserEquipmentInfo value)
	{
		this.userEquipmentInfo = value;
	}
	
	@Override
	public QoSNegotiationEnum getQoSNegotiation()
	{
		if(qosNegotiation==null)
			return null;
		
		return qosNegotiation.getEnumerated( QoSNegotiationEnum.class);
	}
	
	@Override
	public void setQoSNegotiation(QoSNegotiationEnum value)
	{
		if(value==null)
			this.qosNegotiation = null;
		else
			this.qosNegotiation = new QoSNegotiationImpl(value, null, null);
	}
	
	@Override
	public QoSUpgradeEnum getQoSUpgrade()
	{
		if(qosUpgrade==null)
			return null;
		
		return qosUpgrade.getEnumerated(QoSUpgradeEnum.class);
	}
	
	@Override
	public void setQoSUpgrade(QoSUpgradeEnum value)
	{
		if(value==null)
			this.qosUpgrade = null;
		else
			this.qosUpgrade = new QoSUpgradeImpl(value, null, null);
	}
	
	@Override
	public String getTGPPSGSNMCCMNC() 
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}

	@Override
	public void setTGPPSGSNMCCMNC(String value) 
	{
		if(value == null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTGPPSGSNAddress() 
	{
		if(tgppSGSNAddress==null)
			return null;
		
		return tgppSGSNAddress.getValue();
	}

	@Override
	public void setTGPPSGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppSGSNAddress = null;
		else
			this.tgppSGSNAddress = new TGPPSGSNAddressImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPSGSNIPv6Address() 
	{
		if(tgppSGSNIPv6Address==null)
			return null;
		
		return tgppSGSNIPv6Address.getValue();
	}

	@Override
	public void setTGPPSGSNIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppSGSNIPv6Address = null;
		else
			this.tgppSGSNIPv6Address = new TGPPSGSNIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public String getRAI()
	{
		if(rai==null)
			return null;
		
		return rai.getString();
	}
	
	@Override
	public void setRAI(String value)
	{
		if(value==null)
			this.rai = null;
		else
			this.rai = new RAIImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPUserLocationInfo() 
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}

	@Override
	public void setTGPPUserLocationInfo(ByteBuf value) 
	{
		if(value == null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPMSTimeZone() 
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}

	@Override
	public void setTGPPMSTimeZone(ByteBuf value) 
	{
		if(value == null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTGPP2BSID() 
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	@Override
	public void setTGPP2BSID(ByteBuf value) 
	{
		if(value == null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);
	}
	
	@Override
	public List<EventTriggerEnum> getEventTrigger()
	{
		if(eventTrigger==null || eventTrigger.size()==0)
			return null;
		
		List<EventTriggerEnum> result = new ArrayList<EventTriggerEnum>();
		for(EventTrigger curr:eventTrigger)
			result.add(curr.getEnumerated(EventTriggerEnum.class));
		
		return result;
	}
	
	@Override
	public void setEventTrigger(List<EventTriggerEnum> value)
	{
		if(value==null || value.size()==0)
			this.eventTrigger = null;
		else
		{
			this.eventTrigger = new ArrayList<EventTrigger>();
			for(EventTriggerEnum curr:value)
				this.eventTrigger.add(new EventTriggerImpl(curr, null, null));			
		}
	}
	
	@Override
	public MultipleBBERFActionEnum getMultipleBBERFAction() 
	{
		if(multipleBBERFAction==null)
			return null;
		
		return multipleBBERFAction.getEnumerated(MultipleBBERFActionEnum.class);
	}

	@Override
	public void setMultipleBBERFAction(MultipleBBERFActionEnum value) 
	{
		if(value == null)
			this.multipleBBERFAction = null;
		else
			this.multipleBBERFAction = new MultipleBBERFActionImpl(value, null, null);
	}
	
	@Override
	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	@Override
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
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
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(destinationHost);
		result.add(originStateId);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		result.add(framedIPAddress);
		result.add(framedIPv6Prefix);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ocSupportedFeatures);
		result.add(qosInformation);
		
		if(qosRuleReport!=null)
			result.addAll(qosRuleReport);
		
		if(anGWAddress!=null)
			result.addAll(anGWAddress);
		
		result.add(networkRequestSupport);
		
		if(packetFilterInformation!=null)
			result.addAll(packetFilterInformation);
		
		result.add(packetFilterOperation);
		
		if(subsessionEnforcementInfo!=null)
			result.addAll(subsessionEnforcementInfo);
		
		result.add(ipcanType);
		result.add(ratType);
		result.add(terminationCause);
		result.add(userEquipmentInfo);
		result.add(qosNegotiation);
		result.add(qosUpgrade);
		result.add(tgppSGSNMCCMNC);
		result.add(tgppSGSNAddress);
		result.add(tgppSGSNIPv6Address);
		result.add(rai);
		result.add(tgppUserLocationInfo);
		result.add(tgppMSTimeZone);
		result.add(tgpp2BSID);
		
		if(eventTrigger!=null)
			result.addAll(eventTrigger);
		
		result.add(multipleBBERFAction);
		result.add(userCSGInformation);
		
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