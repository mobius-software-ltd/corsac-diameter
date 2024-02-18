package com.mobius.software.telco.protocols.diameter.app.gxx;
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

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInfoChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessTransferInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccumulatedCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdditionalContentInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressDomain;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCCostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCService;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCSubscriptionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationServerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BasicServiceCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPDTInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledIdentityChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CurrentTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DestinationInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EarlyMediaDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCause;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IncrementalCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterOperatorIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSRequestorID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMContentType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageBody;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageClass;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NIDDSubmission;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NNIInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NextTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NodeFunctionalityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantGroup;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCUserRole;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationReceptionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationTransmissionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioParameterSetInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateElement;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RealTimeTariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifierNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaComponent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPTimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ScaleFactor;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SupplementaryService;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCSpecificReduction;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstExchange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransmitterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.WLANOperatorId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessNetworkChargingIdentifierGx;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalPolicyInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CreditManagementStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowDirectionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRAInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRARemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterContent;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaNode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TFTPacketFilterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelHeaderFilter;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;

import io.netty.buffer.ByteBuf;


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) throws MissingAvpException, AvpOccursTooManyTimesException;
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException;
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException;
	
	public TGPPOCSpecificReduction getTGPPOCSpecificReduction();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public Load getLoad();
	
	public CreditManagementStatus getCreditManagementStatus();
	
	public ServiceInformation getServiceInformation();
	
	public TDFInformation getTDFInformation();
	
	public FixedUserLocationInfo getFixedUserLocationInfo();
	
	public PacketFilterInformation getPacketFilterInformation();
	
	public TFTPacketFilterInformation getTFTPacketFilterInformation();
	
	public PacketFilterContent getPacketFilterContent(String rule) throws InvalidAvpValueException;
	
	public PacketFilterContent getPacketFilterContent(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public TFTFilter getTFTFilter(String rule) throws InvalidAvpValueException;
	
	public TFTFilter getTFTFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public FlowInformation getFlowInformation();
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException;
	
	public RedirectInformation getRedirectInformation();
	
	public CalleeInformation getCalleeInformation();
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException;
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public ApplicationDetectionInformation getApplicationDetectionInformation(ByteBuf tdfApplicationIdentifier) throws MissingAvpException;
	
	public AccessNetworkChargingIdentifierGx getAccessNetworkChargingIdentifierGx(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException;
	
	public CoAInformation getCoAInformation(TunnelInformation tunnelInformation,InetAddress coAIPAddress) throws MissingAvpException;
	
	public TunnelInformation getTunnelInformation();
	
	public TunnelHeaderFilter getTunnelHeaderFilter(String rule) throws InvalidAvpValueException;
	
	public TunnelHeaderFilter getTunnelHeaderFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	public PresenceReportingAreaNode getPresenceReportingAreaNode();
	
	public EventReportIndication getEventReportIndication();
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException;
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException;
	
	public AreaScope getAreaScope();
	
	public ListOfMeasurements getListOfMeasurements();
	
	public ReportingTrigger getReportingTrigger();
	
	public MBSFNArea getMBSFNArea();
	
	public ChargingInformation getChargingInformation();
	
	public ChargingRuleRemove getChargingRuleRemove();
	
	public ChargingRuleInstall getChargingRuleInstall();
	
	public ChargingRuleReport getChargingRuleReport();
	
	public ChargingRuleDefinition getChargingRuleDefinition(ByteBuf chargingRuleName) throws MissingAvpException;
	
	public MonitoringFlags getMonitoringFlags();
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS();
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
	
	public QoSInformation getQoSInformation();
	
	public DefaultQoSInformation getDefaultQoSInformation();
	
	public UsageMonitoringInformation getUsageMonitoringInformation();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException;
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException;
	
	public ConditionalPolicyInformation getConditionalPolicyInformation();
	
	public PRAInstall getPRAInstall();
	
	public PRARemove getPRARemove();
	
	public RoutingRuleInstall getRoutingRuleInstall();
	
	public RoutingRuleRemove getRoutingRuleRemove();
	
	public RoutingRuleReport getRoutingRuleReport();
	
	public RoutingRuleDefinition getRoutingRuleDefinition(ByteBuf routingRuleIdentifier) throws MissingAvpException;
	
	public RoutingFilter getRoutingFilter(FlowDescription flowDescription,FlowDirectionEnum flowDirection) throws MissingAvpException;
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException;
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException;
	
	//ServiceInformation - standard
	
	public AoCInformation getAoCInformation();
				
	public PSInformation getPSInformation();
		
	public IMSInformation getIMSInformation(NodeFunctionalityEnum nodeFunctionality) throws MissingAvpException;
		
	public MMSInformation getMMSInformation();
		
	public LCSInformation getLCSInformation();
		
	public PoCInformation getPoCInformation();
		
	public MBMSInformation getMBMSInformation();
		
	public SMSInformation getSMSInformation();
		
	public VCSInformation getVCSInformation();
		
	public MMTelInformation getMMTelInformation();
		
	public ProSeInformation getProSeInformation();
		
	public ServiceGenericInformation getServiceGenericInformation();
		
	public IMInformation getIMInformation();
		
	public DCDInformation getDCDInformation();
		
	public M2MInformation getM2MInformation();
		
	public CPDTInformation getCPDTInformation();		
	
	//PSInformation - standard
	
	public TWANUserLocationInfo getTWANUserLocationInfo(String ssid) throws MissingAvpException;
	
	public UWANUserLocationInfo getUWANUserLocationInfo(InetAddress ueLocalIPAddress) throws MissingAvpException;
	
	public WLANOperatorId getWLANOperatorId();
	
	//IMSInformation - standard
	
	public EventType getEventType();
		
	public CalledIdentityChange getCalledIdentityChange();
		
	public TimeStamps getTimeStamps();
		
	public ApplicationServerInformation getApplicationServerInformation();
		
	public InterOperatorIdentifier getInterOperatorIdentifier();
		
	public SDPMediaComponent getSDPMediaComponent();
		
	public ServerCapabilities getServerCapabilities();
		
	public TrunkGroupID getTrunkGroupID();
		
	public ServiceSpecificInfo getServiceSpecificInfo();
		
	public MessageBody getMessageBody(String contentType,Long contentLength) throws MissingAvpException;
		
	public EarlyMediaDescription getEarlyMediaDescription();
		
	public SDPTimeStamps getSDPTimeStamps();
		
	public RealTimeTariffInformation getRealTimeTariffInformation();
		
	public TariffInformation getTariffInformation(CurrentTariff currentTariff) throws MissingAvpException;
		
	public CurrentTariff getCurrentTariff();
		
	public NextTariff getNextTariff();
		
	public ScaleFactor getScaleFactor(Long valueDigits) throws MissingAvpException;
		
	public RateElement getRateElement(CcUnitTypeEnum ccUnitType) throws MissingAvpException;
		
	public UnitCost getUnitCost(Long valueDigits) throws MissingAvpException;
		
	public NNIInformation getNNIInformation();
		
	public AccessNetworkInfoChange getAccessNetworkInfoChange();
		
	public AccessTransferInformation getAccessTransferInformation();
		
	public RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode(DiameterAddressTypeEnum addressType, ByteBuf value);
		
	//MMSInformation - standard
		
	public MessageClass getMessageClass();
		
	public MMContentType getMMContentType();
		
	public OriginatorAddress getOriginatorAddress();
		
	public AddressDomain getAddressDomain();
		
	public AdditionalContentInformation getAdditionalContentInformation();
		
	//LCSInformation - standard
		
	public LocationType getLocationType();
		
	public LCSClientID getLCSClientID();
		
	public LCSClientName getLCSClientName();
		
	public LCSRequestorID getLCSRequestorID();
		
	//PoCInformation - standard
		
	public TalkBurstExchange getTalkBurstExchange(Date pocChangeTime) throws MissingAvpException;
		
	public ParticipantGroup getParticipantGroup();
		
	public PoCUserRole getPoCUserRole();
		
	//SMSInformation - standard
		
	public SMSCAddress getSMSCAddress(DiameterAddressTypeEnum addressType, ByteBuf value);
		
	public OriginatorInterface getOriginatorInterface();
		
	public DestinationInterface getDestinationInterface();
		
	public RecipientInfo getRecipientInfo();
		
	public RecipientReceivedAddress getRecipientReceivedAddress();
			
	public OriginatorReceivedAddress getOriginatorReceivedAddress();
		
	public SMDeviceTriggerInformation getSMDeviceTriggerInformation();
		
	public ServingNode getServingNode();
		
	//VCSInformation - standard
		
	public BasicServiceCode getBasicServiceCode();
		
	public ISUPCause getISUPCause();
		
	//MMTelInformation - standard
		
	public SupplementaryService getSupplementaryService();
		
	public AoCSubscriptionInformation getAoCSubscriptionInformation();
		
	public AoCCostInformation getAoCCostInformation();
		
	public AoCService getAoCService();
		
	public IncrementalCost getIncrementalCost(Long valueDigits) throws MissingAvpException;
		
	public AccumulatedCost getAccumulatedCost(Long valueDigits) throws MissingAvpException;
		
	//ProSeInformation - standard
		
	public WLANLinkLayerId getWLANLinkLayerId();
		
	public CoverageInfo getCoverageInfo();
		
	public LocationInfo getLocationInfo();
		
	public RadioParameterSetInfo getRadioParameterSetInfo();
		
	public TransmitterInfo getTransmitterInfo();
		
	public ProSeDirectCommunicationTransmissionDataContainer getProSeDirectCommunicationTransmissionDataContainer();
		
	public ProSeDirectCommunicationReceptionDataContainer getProSeDirectCommunicationReceptionDataContainer();
		
	//CPDTInformation - standard
		
	public NIDDSubmission getNIDDSubmission();
}