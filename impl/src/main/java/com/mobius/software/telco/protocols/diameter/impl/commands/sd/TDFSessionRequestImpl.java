package com.mobius.software.telco.protocols.diameter.impl.commands.sd;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificRequestWithHostBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.DynamicAddressFlagExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.DynamicAddressFlagImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDNConnectionChargingIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPP2BSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CSGInformationReportingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OfflineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OnlineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RevalidationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtension;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtensionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDNConnectionChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReporting;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Offline;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Online;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RevalidationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
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
public class TDFSessionRequestImpl extends VendorSpecificRequestWithHostBase implements TDFSessionRequest
{
	private DRMP drmp;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<SubscriptionId> subscriptionId;

	private List<SupportedFeatures> supportedFeatures;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private IPCANType ipcanType;
	
	private RATType ratType;
	
	private ANTrusted anTrusted;
	
	private UserEquipmentInfo userEquipmentInfo;
	
	private UserEquipmentInfoExtension userEquipmentInfoExtension;
	
	private QoSInformation qosInformation;
	
	private List<ANGWAddress> anGWAddress;
	
	private TGPPSGSNAddress tgppSGSNAddress;
	
	private TGPPSGSNIPv6Address tgppSGSNIPv6Address;
	
	private TGPPGGSNAddress tgppGGSNAddress;
	
	private TGPPGGSNIPv6Address tgppGGSNIPv6Address;
	
	private TGPPSelectionMode tgppSelectionMode;
	
	private DynamicAddressFlag dynamicAddressFlag;
	
	private DynamicAddressFlagExtension dynamicAddressFlagExtension;
	
	private PDNConnectionChargingID pdnConnectionChargingID;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private RAI rai;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private FixedUserLocationInfo fixedUserLocationInfo;
	
	private UserCSGInformation userCSGInformation;
	
	private TWANIdentifier twanIdentifier;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private CalledStationId calledStationId;
	
	private ChargingInformation chargingInformation;
	
	private Online online;
	
	private Offline offline;
	
	private List<ADCRuleInstall> adcRuleInstall;
	
	private RevalidationTime revalidationTime;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private List<CSGInformationReporting> csgInformationReporting;
	
	private List<EventTrigger> eventTrigger;
	
	private PresenceReportingAreaInformation presenceReportingAreaInformation;
	
	private LogicalAccessID logicalAccessID;
	
	private PhysicalAccessID physicalAccessID;
	
	private TGPP2BSID tgpp2BSID;
	
	protected TDFSessionRequestImpl() 
	{
		super();
	}
	
	public TDFSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID);		
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
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension()
	{
		return this.userEquipmentInfoExtension;
	}
	
	@Override
	public void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value)
	{
		this.userEquipmentInfoExtension = value;
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
	public ByteBuf getTGPPGGSNAddress() 
	{
		if(tgppGGSNAddress==null)
			return null;
		
		return tgppGGSNAddress.getValue();
	}

	@Override
	public void setTGPPGGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNAddress = null;
		else
			this.tgppGGSNAddress = new TGPPGGSNAddressImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTGPPGGSNIPv6Address() 
	{
		if(tgppGGSNIPv6Address==null)
			return null;
		
		return tgppGGSNIPv6Address.getValue();
	}

	@Override
	public void setTGPPGGSNIPv6Address(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNIPv6Address = null;
		else
			this.tgppGGSNIPv6Address = new TGPPGGSNIPv6AddressImpl(value, null, null);
	}
	
	@Override
	public String getTGPPSelectionMode() 
	{
		if(tgppSelectionMode==null)
			return null;
		
		return tgppSelectionMode.getString();
	}

	@Override
	public void setTGPPSelectionMode(String value) 
	{
		if(value == null)
			this.tgppSelectionMode = null;
		else
			this.tgppSelectionMode = new TGPPSelectionModeImpl(value, null, null);
	}
	
	@Override
	public DynamicAddressFlagEnum getDynamicAddressFlag()
	{
		if(dynamicAddressFlag==null)
			return null;
		
		return dynamicAddressFlag.getEnumerated(DynamicAddressFlagEnum.class);
	}
	
	@Override
	public void setDynamicAddressFlag(DynamicAddressFlagEnum value)
	{
		if(value==null)
			this.dynamicAddressFlag = null;
		else
			this.dynamicAddressFlag = new DynamicAddressFlagImpl(value, null, null);			
	}
	
	@Override
	public DynamicAddressFlagExtensionEnum getDynamicAddressFlagExtension()
	{
		if(dynamicAddressFlagExtension==null)
			return null;
		
		return dynamicAddressFlagExtension.getEnumerated(DynamicAddressFlagExtensionEnum.class);
	}
	
	@Override
	public void setDynamicAddressFlagExtension(DynamicAddressFlagExtensionEnum value)
	{
		if(value==null)
			this.dynamicAddressFlagExtension = null;
		else
			this.dynamicAddressFlagExtension = new DynamicAddressFlagExtensionImpl(value, null, null);			
	}
	
	@Override
	public Long getPDNConnectionChargingID()
	{
		if(pdnConnectionChargingID==null)
			return null;
		
		return pdnConnectionChargingID.getUnsigned();
	}
	
	@Override
	public void setPDNConnectionChargingID(Long value)
	{
		if(value==null)
			this.pdnConnectionChargingID = null;
		else
			this.pdnConnectionChargingID = new PDNConnectionChargingIDImpl(value, null, null);			
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
	public FixedUserLocationInfo getFixedUserLocationInfo()
	{
		return this.fixedUserLocationInfo;
	}
	
	@Override
	public void setFixedUserLocationInfo(FixedUserLocationInfo value)
	{
		this.fixedUserLocationInfo = value;
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
	
	@Override
	public ByteBuf getTWANIdentifier() 
	{
		if(twanIdentifier==null)
			return null;
		
		return twanIdentifier.getValue();
	}

	@Override
	public void setTWANIdentifier(ByteBuf value) 
	{
		if(value == null)
			this.twanIdentifier = null;
		else
			this.twanIdentifier = new TWANIdentifierImpl(value, null, null);
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
	public String getTGPPChargingCharacteristics() 
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}

	@Override
	public void setTGPPChargingCharacteristics(String value) 
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String value) 
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	@Override
	public ChargingInformation getChargingInformation()
	{
		return this.chargingInformation;
	}
	
	@Override
	public void setChargingInformation(ChargingInformation value)
	{
		this.chargingInformation = value;
	}
	
	@Override
	public OnlineEnum getOnline()
	{
		if(online==null)
			return null;
		
		return online.getEnumerated(OnlineEnum.class);
	}
	
	@Override
	public void setOnline(OnlineEnum value)
	{
		if(value==null)
			this.online = null;
		else
			this.online = new OnlineImpl(value, null, null);			
	}
	
	@Override
	public OfflineEnum getOffline()
	{
		if(offline==null)
			return null;
		
		return offline.getEnumerated(OfflineEnum.class);
	}
	
	@Override
	public void setOffline(OfflineEnum value)
	{
		if(value==null)
			this.offline = null;
		else
			this.offline = new OfflineImpl(value, null, null);			
	}
	
	@Override
	public List<ADCRuleInstall> getADCRuleInstall()
	{
		return this.adcRuleInstall;
	}
	
	@Override
	public void setADCRuleInstall(List<ADCRuleInstall> value)
	{
		this.adcRuleInstall = value;
	}
	
	@Override
	public Date getRevalidationTime()
	{
		if(revalidationTime==null)
			return null;
		
		return revalidationTime.getDateTime();
	}
	
	@Override
	public void setRevalidationTime(Date value)
	{
		if(value==null)
			this.revalidationTime = null;
		else
			this.revalidationTime = new RevalidationTimeImpl(value, null, null);			
	}
	
	@Override
	public List<UsageMonitoringInformation> getUsageMonitoringInformation()
	{
		return this.usageMonitoringInformation;
	}
	
	@Override
	public void setUsageMonitoringInformation(List<UsageMonitoringInformation> value)
	{
		this.usageMonitoringInformation = value;				
	}
	
	@Override
	public List<CSGInformationReportingEnum> getCSGInformationReporting()
	{
		if(this.csgInformationReporting==null || this.csgInformationReporting.size()==0)
			return null;
		
		List<CSGInformationReportingEnum> result=new ArrayList<CSGInformationReportingEnum>();
		for(CSGInformationReporting curr:this.csgInformationReporting)
			result.add(curr.getEnumerated(CSGInformationReportingEnum.class));
		
		return result;
	}
	
	@Override
	public void setCSGInformationReporting(List<CSGInformationReportingEnum> value)
	{
		if(value==null || value.size()==0)
			this.csgInformationReporting = null;
		else
		{
			this.csgInformationReporting = new ArrayList<CSGInformationReporting>();
			for(CSGInformationReportingEnum curr:value)
				this.csgInformationReporting.add(new CSGInformationReportingImpl(curr, null, null));
		}
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
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}
	
	@Override
	public void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value)
	{
		this.presenceReportingAreaInformation = value;
	}
	
	@Override
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	@Override
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	@Override
	public String getPhysicalAccessID()
	{
		if(physicalAccessID==null)
			return null;
		
		return physicalAccessID.getString();
	}
	
	@Override
	public void setPhysicalAccessID(String value)
	{
		if(value==null)
			this.physicalAccessID = null;
		else
			this.physicalAccessID = new PhysicalAccessIDImpl(value, null, null);			
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
		result.add(vendorSpecificApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(framedIPAddress);
		result.add(framedIPv6Prefix);
		result.add(ipcanType);
		result.add(ratType);
		result.add(anTrusted);
		result.add(userEquipmentInfo);
		result.add(userEquipmentInfoExtension);
		result.add(qosInformation);
		
		if(anGWAddress!=null)
			result.addAll(anGWAddress);
		
		result.add(tgppSGSNAddress);
		result.add(tgppSGSNIPv6Address);
		result.add(tgppGGSNAddress);
		result.add(tgppGGSNIPv6Address);
		result.add(tgppSelectionMode);
		result.add(dynamicAddressFlag);
		result.add(dynamicAddressFlagExtension);
		result.add(pdnConnectionChargingID);
		result.add(tgppSGSNMCCMNC);
		result.add(rai);
		result.add(tgppUserLocationInfo);
		result.add(fixedUserLocationInfo);
		result.add(userCSGInformation);
		result.add(twanIdentifier);
		result.add(tgppMSTimeZone);
		result.add(tgppChargingCharacteristics);
		result.add(calledStationId);
		result.add(chargingInformation);
		result.add(online);
		result.add(offline);
		
		if(adcRuleInstall!=null)
			result.addAll(adcRuleInstall);
		
		result.add(revalidationTime);
		
		if(usageMonitoringInformation!=null)
			result.addAll(usageMonitoringInformation);
		
		if(csgInformationReporting!=null)
			result.addAll(csgInformationReporting);
		
		if(eventTrigger!=null)
			result.addAll(eventTrigger);
		
		result.add(presenceReportingAreaInformation);
		result.add(logicalAccessID);
		result.add(physicalAccessID);
		result.add(tgpp2BSID);
		
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