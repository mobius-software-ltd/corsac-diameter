package com.mobius.software.telco.protocols.diameter.impl.commands.gx;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.DynamicAddressFlagExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.DynamicAddressFlagImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDNConnectionChargingIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSNegotiationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSUpgradeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RANNASReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TCPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TGPPPSDataOffStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6b.MaximumWaitTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6b.OriginationTimeStampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtension;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtensionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDNConnectionChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSNegotiationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgrade;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgradeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TCPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TGPPPSDataOffStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TGPPPSDataOffStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.MaximumWaitTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6b.OriginationTimeStamp;
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
@DiameterCommandImplementation(applicationId = 16777238, commandCode = 272, request = true)
public class CreditControlRequestImpl extends AuthenticationRequestWithHostBase implements CreditControlRequest
{
	private DRMP drmp;
	
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private CreditManagementStatus creditManagementStatus;
	
	private List<SubscriptionId> subscriptionId;

	private OCSupportedFeatures ocSupportedFeatures;
	
	private ServiceInformation serviceInformation;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private TDFInformation tdfInformation;
	
	private NetworkRequestSupport networkRequestSupport;
	
	private List<PacketFilterInformation> packetFilterInformation;
	
	private PacketFilterOperation packetFilterOperation;
	
	private BearerIdentifier bearerIdentifier;
	
	private BearerOperation bearerOperation;
	
	private DynamicAddressFlag dynamicAddressFlag;
	
	private DynamicAddressFlagExtension dynamicAddressFlagExtension;
	
	private PDNConnectionChargingID pdnConnectionChargingID;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private IPCANType ipcanType;
	
	private TGPPRATType tgppRATType;
	
	private ANTrusted anTrusted;
	
	private RATType ratType;
	
	private TerminationCause terminationCause;
	
	private UserEquipmentInfo userEquipmentInfo;
	
	private UserEquipmentInfoExtension userEquipmentInfoExtension;
	
	private QoSInformation qosInformation;
	
	private QoSNegotiation qosNegotiation;
	
	private QoSUpgrade qosUpgrade;
	
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	
	private DefaultQoSInformation defaultQoSInformation;
	
	private List<ANGWAddress> anGWAddress;
	
	private ANGWStatus anGWStatus;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private TGPPSGSNAddress tgppSGSNAddress;
	
	private TGPPSGSNIPv6Address tgppSGSNIPv6Address;
	
	private TGPPGGSNAddress tgppGGSNAddress;
	
	private TGPPGGSNIPv6Address tgppGGSNIPv6Address;
	
	private TGPPSelectionMode tgppSelectionMode;
	
	private RAI rai;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private FixedUserLocationInfo fixedUserLocationInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private UserCSGInformation userCSGInformation;
	
	private TWANIdentifier twanIdentifier;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private List<RANNASReleaseCause> ranNASReleaseCause;

	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private CalledStationId calledStationId;
	
	private PDNConnectionID pdnConnectionID;
	
	private BearerUsage bearerUsage;
	
	private Online online;
	
	private Offline offline;
	
	private List<TFTPacketFilterInformation> tftPacketFilterInformation;
	
	private List<ChargingRuleReport> chargingRuleReport;
	
	private List<ApplicationDetectionInformation> applicationDetectionInformation;
	
	private List<EventTrigger> eventTrigger;
	
	private EventReportIndication eventReportIndication;
	
	private AccessNetworkChargingAddress accessNetworkChargingAddress;
	
	private List<AccessNetworkChargingIdentifierGx> accessNetworkChargingIdentifierGx;
	
	private List<CoAInformation> coaInformation;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private NBIFOMSupport nbifomSupport;
	
	private NBIFOMMode nbifomMode;
	
	private IPCANType defaultAccess;
	
	private OriginationTimeStamp originationTimeStamp;
	
	private MaximumWaitTime maximumWaitTime;
	
	private AccessAvailabilityChangeReason accessAvailabilityChangeReason;
	
	private RoutingRuleInstall routingRuleInstall;
	
	private RoutingRuleRemove routingRuleRemove;
	
	private HeNBLocalIPAddress heNBLocalIPAddress;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private UDPSourcePort udpSourcePort;
	
	private TCPSourcePort tcpSourcePort;
	
	private List<PresenceReportingAreaInformation> presenceReportingAreaInformation;
	
	private LogicalAccessID logicalAccessID;
	
	private PhysicalAccessID physicalAccessID;
	
	private TGPPPSDataOffStatus tgppPSDataOffStatus;
	
	protected CreditControlRequestImpl() 
	{
		super();
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, 16777238L);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}

	protected CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
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
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		this.ccRequestType = new CcRequestTypeImpl(value, null, null);		
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
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
	public ServiceInformation getServiceInformation() 
	{
		return this.serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation value) 
	{
		this.serviceInformation = value;
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
	public TDFInformation getTDFInformation()
	{
		return this.tdfInformation;
	}
	
	@Override
	public void setTDFInformation(TDFInformation value)
	{
		this.tdfInformation = value;
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
	public ByteBuf getTGPPRATType() 
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}

	@Override
	public void setTGPPRATType(ByteBuf value) 
	{
		if(value == null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);
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
	public DefaultQoSInformation getDefaultQoSInformation()
	{
		return this.defaultQoSInformation;
	}
	
	@Override
	public void setDefaultQoSInformation(DefaultQoSInformation value)
	{
		this.defaultQoSInformation = value;
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
	public EventReportIndication getEventReportIndication()
	{
		return this.eventReportIndication;
	}
	
	@Override
	public void setEventReportIndication(EventReportIndication value)
	{
		this.eventReportIndication = value;
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
	public Long getTCPSourcePort()
	{
		if(tcpSourcePort==null)
			return null;
		
		return tcpSourcePort.getUnsigned();
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
	public List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}
	
	@Override
	public void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value)
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
	public TGPPPSDataOffStatusEnum getTGPPPSDataOffStatus()
	{
		if(tgppPSDataOffStatus==null)
			return null;
		
		return tgppPSDataOffStatus.getEnumerated(TGPPPSDataOffStatusEnum.class);
	}
	
	@Override
	public void setTGPPPSDataOffStatus(TGPPPSDataOffStatusEnum value)
	{
		if(value==null)
			this.tgppPSDataOffStatus = null;
		else
			this.tgppPSDataOffStatus = new TGPPPSDataOffStatusImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ccRequestType==null)
			return "CC-Request-Type is required";
		
		if(ccRequestNumber==null)
			return "CC-Request-Request is required";
		
		if(anGWAddress!=null && anGWAddress.size()>2)
			return "Up to 2 AN-GW-Address allowed";
		
		return super.validate();
	}
}