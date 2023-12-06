package com.mobius.software.telco.protocols.diameter.impl.primitives.s9;
/*
 * Mobius Software LTD
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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPP2BSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ExperimentalResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AccessAvailabilityChangeReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerOperationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CreditManagementStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.HeNBLocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetworkRequestSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OfflineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OnlineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PDNConnectionIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterOperationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gxx.SessionLinkingIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9atag.UELocalIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReason;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessNetworkChargingIdentifierGx;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerOperation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsage;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.HeNBLocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMMode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetworkRequestSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Offline;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Online;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PDNConnectionID;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.SessionLinkingIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.SessionLinkingIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s9.MultipleBBERFAction;
import com.mobius.software.telco.protocols.diameter.primitives.s9.MultipleBBERFActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionEnforcementInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionId;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionOperation;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9atag.UELocalIPv6Prefix;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2201L, vendorId = KnownVendorIDs.TGPP_ID)
public class SubsessionEnforcementInfoImpl extends DiameterGroupedAvpImpl implements SubsessionEnforcementInfo
{
	private SubsessionId subsessionId;
	
	private SubsessionOperation subsessionOperation;
	
	private List<ANGWAddress> anGWAddress;
	
	private BearerIdentifier bearerIdentifier;
	
	private BearerOperation bearerOperation;
	
	private List<PacketFilterInformation> packetFilterInformation;
	
	private PacketFilterOperation packetFilterOperation;
	
	private QoSInformation qosInformation;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private List<CoAInformation> coaInformation;
	
	private CalledStationId calledStationId;
	
	private PDNConnectionID pdnConnectionID;
	
	private BearerUsage bearerUsage;
	
	private List<TFTPacketFilterInformation> tftPacketFilterInformation;
	
	private Online online;
	
	private Offline offline;
	
	private ResultCode resultCode;
	
	private ExperimentalResultCode experimentalResultCode;
	
	private List<ChargingRuleReport> chargingRuleReport;
	
	private CreditManagementStatus creditManagementStatus;
	
	private List<QoSRuleReport> qosRuleReport;
	
	private List<ApplicationDetectionInformation> applicationDetectionInformation;
	
	private IPCANType ipcanType;
	
	private RATType ratType;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private TGPPSGSNAddress tgppSGSNAddress;
	
	private TGPPSGSNIPv6Address tgppSGSNIPv6Address;
	
	private RAI rai;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private TGPP2BSID tgpp2BSID;
	
	private UserCSGInformation userCSGInformation;
	
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	
	private IPCANType defaultAccess;
	
	private NBIFOMMode nbifomMode;
	
	private NBIFOMSupport nbifomSupport;
		
	private AccessAvailabilityChangeReason accessAvailabilityChangeReason;
	
	private NetworkRequestSupport networkRequestSupport;
	
	private RoutingRuleInstall routingRuleInstall;
	
	private RoutingRuleRemove routingRuleRemove;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private LogicalAccessID logicalAccessID;
	
	private PhysicalAccessID physicalAccessID;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private MultipleBBERFAction multipleBBERFAction;
	
	private List<EventTrigger> eventTrigger;
	
	private AccessNetworkChargingAddress accessNetworkChargingAddress;
	
	private List<AccessNetworkChargingIdentifierGx> accessNetworkChargingIdentifierGx;
	
	private SessionLinkingIndicator sessionLinkingIndicator;
	
	private HeNBLocalIPAddress heNBLocalIPAddress;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private UELocalIPv6Prefix ueLocalIPv6Prefix;
	
	private UDPSourcePort udpSourcePort;
	
	private ANGWStatus anGWStatus;
	
	protected SubsessionEnforcementInfoImpl() 
	{
	}
	
	public SubsessionEnforcementInfoImpl(Long subsessionId)
	{
		if(subsessionId==null)
			throw new IllegalArgumentException("Subsession-Id is required");
		
		this.subsessionId = new SubsessionIdImpl(subsessionId, null, null);				
	}
	
	@Override
	public Long getSubsessionId()
	{
		if(subsessionId==null)
			return null;
		
		return subsessionId.getUnsigned();
	}
	
	@Override
	public void setSubsessionId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Subsession-Id required");
		
		this.subsessionId = new SubsessionIdImpl(value, null, null);				
	}
	
	@Override
	public SubsessionOperationEnum getSubsessionOperation()
	{
		if(subsessionOperation==null)
			return null;
		
		return subsessionOperation.getEnumerated(SubsessionOperationEnum.class);
	}
	
	@Override
	public void setSubsessionOperation(SubsessionOperationEnum value)
	{
		if(value==null)
			this.subsessionOperation = null;
		else
			this.subsessionOperation = new SubsessionOperationImpl(value, null, null);				
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
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier==null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	@Override
	public void setBearerIdentifier(ByteBuf value)
	{
		if(value==null)
			this.bearerIdentifier = null;
		else
			this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);			
	}
	
	@Override
	public BearerOperationEnum getBearerOperation()
	{
		if(bearerOperation==null)
			return null;
		
		return bearerOperation.getEnumerated(BearerOperationEnum.class);
	}
	
	@Override
	public void setBearerOperation(BearerOperationEnum value)
	{
		if(value==null)
			this.bearerOperation = null;
		else
			this.bearerOperation = new BearerOperationImpl(value, null, null);
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
	public List<CoAInformation> getCoAInformation()
	{
		return this.coaInformation;
	}
	
	@Override
	public void setCoAInformation(List<CoAInformation> value)
	{
		this.coaInformation = value;
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
	public ByteBuf getPDNConnectionID()
	{
		if(pdnConnectionID==null)
			return null;
		
		return pdnConnectionID.getValue();
	}
	
	@Override
	public void setPDNConnectionID(ByteBuf value)
	{
		if(value==null)
			this.pdnConnectionID = null;
		else
			this.pdnConnectionID = new PDNConnectionIDImpl(value, null, null);
	}
	
	@Override
	public BearerUsageEnum getBearerUsage()
	{
		if(bearerUsage==null)
			return null;
		
		return bearerUsage.getEnumerated(BearerUsageEnum.class);
	}
	
	@Override
	public void setBearerUsage(BearerUsageEnum value)
	{
		if(value==null)
			this.bearerUsage = null;
		else
			this.bearerUsage = new BearerUsageImpl(value, null, null);
	}	
	
	@Override
	public List<TFTPacketFilterInformation> getTFTPacketFilterInformation()
	{
		return this.tftPacketFilterInformation;
	}
	
	@Override
	public void setTFTPacketFilterInformation(List<TFTPacketFilterInformation> value)
	{
		this.tftPacketFilterInformation = value;
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
	public Long getResultCode()
	{
		if(this.resultCode==null)
			return null;
		
		return this.resultCode.getUnsigned();
	}
	
	@Override
	public void setResultCode(Long value)
	{
		if(value==null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(value, null, null);
	}

	@Override
	public Long getExperimentalResultCode() 
	{
		if(experimentalResultCode == null)
			return null;
		
		return experimentalResultCode.getUnsigned();
	}

	@Override
	public void setExperimentalResultCode(Long value) 
	{
		if(value==null)
			this.experimentalResultCode = null;
		else
			this.experimentalResultCode = new ExperimentalResultCodeImpl(value, null, null);
	}
	
	@Override
	public List<ChargingRuleReport> getChargingRuleReport()
	{
		return this.chargingRuleReport;
	}
	
	@Override
	public void setChargingRuleReport(List<ChargingRuleReport> value)
	{
		this.chargingRuleReport = value;
	}
	
	@Override
	public Long getCreditManagementStatus() 
	{
		if(creditManagementStatus==null)
			return null;
		
		return creditManagementStatus.getUnsigned();
	}
	
	@Override
	public void setCreditManagementStatus(Long value)
	{
		if(value==null)
			this.creditManagementStatus = null;
		else
			this.creditManagementStatus = new CreditManagementStatusImpl(value, null, null);
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
	public List<ApplicationDetectionInformation> getApplicationDetectionInformation()
	{
		return this.applicationDetectionInformation;
	}
	
	@Override
	public void setApplicationDetectionInformation(List<ApplicationDetectionInformation> value)
	{
		this.applicationDetectionInformation = value;
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
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS()
	{
		return defaultEPSBearerQoS;
	}
	
	@Override
	public void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value)
	{
		this.defaultEPSBearerQoS = value;
	}		
	
	@Override
	public IPCANTypeEnum getDefaultAccess()
	{
		if(defaultAccess==null)
			return null;
		
		return defaultAccess.getEnumerated(IPCANTypeEnum.class);
	}
	
	@Override
	public void setDefaultAccess(IPCANTypeEnum value)
	{
		if(value==null)
			this.defaultAccess = null;
		else
			this.defaultAccess = new IPCANTypeImpl(value, null, null);
	}
	
	@Override
	public NBIFOMModeEnum getNBIFOMMode()
	{
		if(nbifomMode==null)
			return null;
		
		return nbifomMode.getEnumerated(NBIFOMModeEnum.class);
	}
	
	@Override
	public void setNBIFOMMode(NBIFOMModeEnum value)
	{
		if(value==null)
			this.nbifomMode = null;
		else
			this.nbifomMode = new NBIFOMModeImpl(value, null, null);			
	}	
	
	@Override
	public NBIFOMSupportEnum getNBIFOMSupport()
	{
		if(nbifomSupport==null)
			return null;
		
		return nbifomSupport.getEnumerated(NBIFOMSupportEnum.class);
	}
	
	@Override
	public void setNBIFOMSupport(NBIFOMSupportEnum value)
	{
		if(value==null)
			this.nbifomSupport = null;
		else
			this.nbifomSupport = new NBIFOMSupportImpl(value, null, null);			
	}
	
	@Override
	public AccessAvailabilityChangeReasonEnum getAccessAvailabilityChangeReason()
	{
		if(accessAvailabilityChangeReason==null)
			return null;
		
		return accessAvailabilityChangeReason.getEnumerated(AccessAvailabilityChangeReasonEnum.class);
	}
	
	@Override
	public void setAccessAvailabilityChangeReason(AccessAvailabilityChangeReasonEnum value)
	{
		if(value==null)
			this.accessAvailabilityChangeReason = null;
		else
			this.accessAvailabilityChangeReason = new AccessAvailabilityChangeReasonImpl(value, null, null);			
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
	public RoutingRuleInstall getRoutingRuleInstall()
	{
		return this.routingRuleInstall;
	}
	
	@Override
	public void setRoutingRuleInstall(RoutingRuleInstall value)
	{
		this.routingRuleInstall = value;
	}
	
	@Override
	public RoutingRuleRemove getRoutingRuleRemove()
	{
		return this.routingRuleRemove;
	}
	
	@Override
	public void setRoutingRuleRemove(RoutingRuleRemove value)
	{
		this.routingRuleRemove = value;
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
	public MultipleBBERFActionEnum getMultipleBBERFAction()
	{
		if(multipleBBERFAction==null)
			return null;
		
		return multipleBBERFAction.getEnumerated(MultipleBBERFActionEnum.class);
	}
	
	@Override
	public void setMultipleBBERFAction(MultipleBBERFActionEnum value)
	{
		if(value==null)
			this.multipleBBERFAction = null;
		else
			this.multipleBBERFAction = new MultipleBBERFActionImpl(value, null, null);			
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
	public List<AccessNetworkChargingIdentifierGx> getAccessNetworkChargingIdentifierGx()
	{
		return this.accessNetworkChargingIdentifierGx;
	}
	
	@Override
	public void setAccessNetworkChargingIdentifierGx(List<AccessNetworkChargingIdentifierGx> value)
	{
		this.accessNetworkChargingIdentifierGx = value;
	}
	
	@Override
	public SessionLinkingIndicatorEnum getSessionLinkingIndicator()
	{
		if(sessionLinkingIndicator == null)
			return null;
		
		return sessionLinkingIndicator.getEnumerated(SessionLinkingIndicatorEnum.class);
	}
	
	@Override
	public void setSessionLinkingIndicator(SessionLinkingIndicatorEnum value)
	{
		if(value == null)
			this.sessionLinkingIndicator = null;
		else
			this.sessionLinkingIndicator = new SessionLinkingIndicatorImpl(value, null, null);
	}
	
	@Override
	public InetAddress getHeNBLocalIPAddress()
	{
		if(heNBLocalIPAddress==null)
			return null;
		
		return heNBLocalIPAddress.getAddress();
	}
	
	@Override
	public void setHeNBLocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.heNBLocalIPAddress = null;
		else
			this.heNBLocalIPAddress = new HeNBLocalIPAddressImpl(value, null, null);			
	}
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return ueLocalIPAddress.getAddress();
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
	public ByteBuf getUELocalIPv6Prefix()
	{
		if(ueLocalIPv6Prefix==null)
			return null;
		
		return ueLocalIPv6Prefix.getValue();
	}
	
	@Override
	public void setUELocalIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			this.ueLocalIPv6Prefix = null;
		else
			this.ueLocalIPv6Prefix = new UELocalIPv6PrefixImpl(value, null, null);			
	}
	
	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return udpSourcePort.getUnsigned();
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
	public ANGWStatusEnum getANGWStatus()
	{
		if(anGWStatus==null)
			return null;
		
		return anGWStatus.getEnumerated(ANGWStatusEnum.class);
	}
	
	@Override
	public void setANGWStatus(ANGWStatusEnum value)
	{
		if(value==null)
			this.anGWStatus = null;
		else
			this.anGWStatus = new ANGWStatusImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(subsessionId==null)
			return "Subsession-Id is required";
		
		if(anGWAddress!=null && anGWAddress.size()>2)
			return "Up to 2 AN-GW-Address allowed";
		
		return null;
	}
}