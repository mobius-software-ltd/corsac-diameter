package com.mobius.software.telco.protocols.diameter.impl.app.gxx;
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

import com.mobius.software.telco.protocols.diameter.app.gxx.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccessNetworkInfoChangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccessTransferInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AccumulatedCostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AdditionalContentInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AddressDomainImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCCostInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCSubscriptionInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ApplicationServerInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.BasicServiceCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CPDTInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CalledIdentityChangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CoverageInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CurrentTariffImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.DestinationInterfaceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.EarlyMediaDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.EventTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.IMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ISUPCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.IncrementalCostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.InterOperatorIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSClientIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSClientNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSRequestorIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.M2MInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MBMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MMContentTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MMTelInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MessageBodyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MessageClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.NIDDSubmissionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.NNIInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.NextTariffImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorInterfaceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorReceivedAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ParticipantGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PoCInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PoCUserRoleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeDirectCommunicationReceptionDataContainerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeDirectCommunicationTransmissionDataContainerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RadioParameterSetInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RateElementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RealTimeTariffInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RecipientInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RecipientReceivedAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RelatedIMSChargingIdentifierNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SDPMediaComponentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SDPTimeStampsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SMDeviceTriggerInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SMSCAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ScaleFactorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServiceInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServiceSpecificInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SupplementaryServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPPOCSpecificReductionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TWANUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TalkBurstExchangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TariffInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TimeStampsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TransmitterInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TrunkGroupIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UWANUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UnitCostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.VCSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.WLANOperatorIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CCMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RestrictionFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ChargingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AccessNetworkChargingIdentifierGxImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ApplicationDetectionInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CoAInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalPolicyInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CreditManagementStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.DefaultEPSBearerQoSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.DefaultQoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventReportIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.FixedUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.FlowInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MonitoringFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PRAInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PRARemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterContentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PacketFilterInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RedirectInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleInstallImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleRemoveImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RoutingRuleReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TDFInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TFTFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TFTPacketFilterInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TunnelHeaderFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TunnelInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UsageMonitoringInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.DCDInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.IMInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.ServiceGenericInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANLinkLayerIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.CalleeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AreaScopeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ListOfMeasurementsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MBSFNAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MDTConfigurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ReportingTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ServingNodeImpl;
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

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		return new UserEquipmentInfoExtensionImpl(imeiSV, mac, eui64, modifiedEUI64, imei);
	}
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException
	{
		return new UserEquipmentInfoImpl(userEquipmentInfoType, userEquipmentInfoValue);
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public TGPPOCSpecificReduction getTGPPOCSpecificReduction()
	{
		return new TGPPOCSpecificReductionImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public CreditManagementStatus getCreditManagementStatus()
	{
		return new CreditManagementStatusImpl();
	}
	
	public ServiceInformation getServiceInformation()
	{
		return new ServiceInformationImpl();
	}
	
	public TDFInformation getTDFInformation()
	{
		return new TDFInformationImpl();
	}
	
	public FixedUserLocationInfo getFixedUserLocationInfo()
	{
		return new FixedUserLocationInfoImpl();
	}
	
	public PacketFilterInformation getPacketFilterInformation()
	{
		return new PacketFilterInformationImpl();
	}
	
	public TFTPacketFilterInformation getTFTPacketFilterInformation()
	{
		return new TFTPacketFilterInformationImpl();
	}
	
	public PacketFilterContent getPacketFilterContent(String rule) throws InvalidAvpValueException
	{
		return new PacketFilterContentImpl(rule, null, null);
	}
	
	public PacketFilterContent getPacketFilterContent(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new PacketFilterContentImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null); 
	}
	
	public TFTFilter getTFTFilter(String rule) throws InvalidAvpValueException
	{
		return new TFTFilterImpl(rule, null, null);
	}
	
	public TFTFilter getTFTFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new TFTFilterImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public FlowInformation getFlowInformation()
	{
		return new FlowInformationImpl();
	}
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException
	{
		return new FlowsImpl(mediaComponentNumber);
	}
	
	public RedirectInformation getRedirectInformation()
	{
		return new RedirectInformationImpl();
	}
	
	public CalleeInformation getCalleeInformation()
	{
		return new CalleeInformationImpl();
	}
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(rule, null, null);
	}
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public ApplicationDetectionInformation getApplicationDetectionInformation(ByteBuf tdfApplicationIdentifier) throws MissingAvpException
	{
		return new ApplicationDetectionInformationImpl(tdfApplicationIdentifier);
	}
	
	public AccessNetworkChargingIdentifierGx getAccessNetworkChargingIdentifierGx(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException
	{
		return new AccessNetworkChargingIdentifierGxImpl(accessNetworkChargingIdentifierValue);
	}
	
	public CoAInformation getCoAInformation(TunnelInformation tunnelInformation,InetAddress coAIPAddress) throws MissingAvpException
	{
		return new CoAInformationImpl(tunnelInformation, coAIPAddress);
	}
	
	public TunnelInformation getTunnelInformation()
	{
		return new TunnelInformationImpl();
	}
	
	public TunnelHeaderFilter getTunnelHeaderFilter(String rule) throws InvalidAvpValueException
	{
		return new TunnelHeaderFilterImpl(rule, null, null);
	}
	
	public TunnelHeaderFilter getTunnelHeaderFilter(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts,
			DiameterRuleAddress to, List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new TunnelHeaderFilterImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation()
	{
		return new PresenceReportingAreaInformationImpl();
	}
	
	public PresenceReportingAreaNode getPresenceReportingAreaNode()
	{
		return new PresenceReportingAreaNodeImpl();
	}
	
	public EventReportIndication getEventReportIndication()
	{
		return new EventReportIndicationImpl();
	}
	
	public TraceData getTraceData(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException
	{
		return new TraceDataImpl(traceReference, traceDepth, traceNETypeList, traceEventList, traceCollectionEntity);
	}
	
	public MDTConfiguration getMDTConfiguration(JobTypeEnum jobType) throws MissingAvpException
	{
		return new MDTConfigurationImpl(jobType);
	}
	
	public AreaScope getAreaScope()
	{
		return new AreaScopeImpl();
	}
	
	public ListOfMeasurements getListOfMeasurements()
	{
		return new ListOfMeasurementsImpl();
	}
	
	public ReportingTrigger getReportingTrigger()
	{
		return new ReportingTriggerImpl();
	}
	
	public MBSFNArea getMBSFNArea()
	{
		return new MBSFNAreaImpl();
	}
	
	public ChargingInformation getChargingInformation()
	{
		return new ChargingInformationImpl();
	}
	
	public ChargingRuleRemove getChargingRuleRemove()
	{
		return new ChargingRuleRemoveImpl();
	}
	
	public ChargingRuleInstall getChargingRuleInstall()
	{
		return new ChargingRuleInstallImpl();
	}
	
	public ChargingRuleReport getChargingRuleReport()
	{
		return new ChargingRuleReportImpl();
	}
	
	public ChargingRuleDefinition getChargingRuleDefinition(ByteBuf chargingRuleName) throws MissingAvpException
	{
		return new ChargingRuleDefinitionImpl(chargingRuleName);
	}
	
	public MonitoringFlags getMonitoringFlags()
	{
		return new MonitoringFlagsImpl();
	}
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		return new FinalUnitIndicationImpl(finalUnitAction);
	}
	
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS()
	{
		return new DefaultEPSBearerQoSImpl();
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate()
	{
		return new ConditionalAPNAggregateMaxBitrateImpl();
	}
	
	public QoSInformation getQoSInformation()
	{
		return new QoSInformationImpl();
	}
	
	public DefaultQoSInformation getDefaultQoSInformation()
	{
		return new DefaultQoSInformationImpl();
	}
	
	public UsageMonitoringInformation getUsageMonitoringInformation()
	{
		return new UsageMonitoringInformationImpl();
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException
	{
		return new CCMoneyImpl(unitValue);
	}
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException
	{
		return new UnitValueImpl(valueDigits);
	}
	
	public ConditionalPolicyInformation getConditionalPolicyInformation()
	{
		return new ConditionalPolicyInformationImpl();
	}
	
	public PRAInstall getPRAInstall()
	{
		return new PRAInstallImpl();
	}
	
	public PRARemove getPRARemove()
	{
		return new PRARemoveImpl();
	}
	
	public RoutingRuleInstall getRoutingRuleInstall()
	{
		return new RoutingRuleInstallImpl();
	}
	
	public RoutingRuleRemove getRoutingRuleRemove()
	{
		return new RoutingRuleRemoveImpl();
	}
	
	public RoutingRuleReport getRoutingRuleReport()
	{
		return new RoutingRuleReportImpl();
	}
	
	public RoutingRuleDefinition getRoutingRuleDefinition(ByteBuf routingRuleIdentifier) throws MissingAvpException
	{
		return new RoutingRuleDefinitionImpl(routingRuleIdentifier);
	}
	
	public RoutingFilter getRoutingFilter(FlowDescription flowDescription,FlowDirectionEnum flowDirection) throws MissingAvpException
	{
		return new RoutingFilterImpl(flowDescription, flowDirection);
	}
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		return new UserCSGInformationImpl(csgId, csgAccessMode);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException
	{
		return new RestrictionFilterRuleImpl(rule, null, null);				
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new RestrictionFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException
	{
		return new RedirectServerImpl(redirectAddressType, redirectServerAddress);
	}
	
	//ServiceInformation - standard
	
	public AoCInformation getAoCInformation()
	{
		return new AoCInformationImpl();
	}
				
	public PSInformation getPSInformation()
	{
		return new PSInformationImpl();
	}
		
	public IMSInformation getIMSInformation(NodeFunctionalityEnum nodeFunctionality) throws MissingAvpException
	{
		return new IMSInformationImpl(nodeFunctionality);
	}
		
	public MMSInformation getMMSInformation()
	{
		return new MMSInformationImpl();
	}
		
	public LCSInformation getLCSInformation()
	{
		return new LCSInformationImpl();
	}
		
	public PoCInformation getPoCInformation()
	{
		return new PoCInformationImpl();
	}
		
	public MBMSInformation getMBMSInformation()
	{
		return new MBMSInformationImpl();
	}
		
	public SMSInformation getSMSInformation()
	{
		return new SMSInformationImpl();
	}
		
	public VCSInformation getVCSInformation()
	{
		return new VCSInformationImpl();
	}
		
	public MMTelInformation getMMTelInformation()
	{
		return new MMTelInformationImpl();
	}
		
	public ProSeInformation getProSeInformation()
	{
		return new ProSeInformationImpl();
	}
		
	public ServiceGenericInformation getServiceGenericInformation()
	{
		return new ServiceGenericInformationImpl();
	}
		
	public IMInformation getIMInformation()
	{
		return new IMInformationImpl();
	}
		
	public DCDInformation getDCDInformation()
	{
		return new DCDInformationImpl();
	}
		
	public M2MInformation getM2MInformation()
	{
		return new M2MInformationImpl();
	}
		
	public CPDTInformation getCPDTInformation()
	{
		return new CPDTInformationImpl();
	}		
	
	//PSInformation - standard
	
	public TWANUserLocationInfo getTWANUserLocationInfo(String ssid) throws MissingAvpException
	{
		return new TWANUserLocationInfoImpl(ssid);
	}
	
	public UWANUserLocationInfo getUWANUserLocationInfo(InetAddress ueLocalIPAddress) throws MissingAvpException
	{
		return new UWANUserLocationInfoImpl(ueLocalIPAddress);
	}
	
	public WLANOperatorId getWLANOperatorId()
	{
		return new WLANOperatorIdImpl();
	}
	
	//IMSInformation - standard
	
	public EventType getEventType()
	{
		return new EventTypeImpl();
	}
		
	public CalledIdentityChange getCalledIdentityChange()
	{
		return new CalledIdentityChangeImpl();
	}
		
	public TimeStamps getTimeStamps()
	{
		return new TimeStampsImpl();
	}
		
	public ApplicationServerInformation getApplicationServerInformation()
	{
		return new ApplicationServerInformationImpl();
	}
		
	public InterOperatorIdentifier getInterOperatorIdentifier()
	{
		return new InterOperatorIdentifierImpl();
	}
		
	public SDPMediaComponent getSDPMediaComponent()
	{
		return new SDPMediaComponentImpl();
	}
		
	public ServerCapabilities getServerCapabilities()
	{
		return new ServerCapabilitiesImpl();
	}
		
	public TrunkGroupID getTrunkGroupID()
	{
		return new TrunkGroupIDImpl();
	}
		
	public ServiceSpecificInfo getServiceSpecificInfo()
	{
		return new ServiceSpecificInfoImpl();
	}
		
	public MessageBody getMessageBody(String contentType,Long contentLength) throws MissingAvpException
	{
		return new MessageBodyImpl(contentType, contentLength);
	}
		
	public EarlyMediaDescription getEarlyMediaDescription()
	{
		return new EarlyMediaDescriptionImpl();
	}
		
	public SDPTimeStamps getSDPTimeStamps()
	{
		return new SDPTimeStampsImpl();
	}
		
	public RealTimeTariffInformation getRealTimeTariffInformation()
	{
		return new RealTimeTariffInformationImpl();
	}
		
	public TariffInformation getTariffInformation(CurrentTariff currentTariff) throws MissingAvpException
	{
		return new TariffInformationImpl(currentTariff);
	}
		
	public CurrentTariff getCurrentTariff()
	{
		return new CurrentTariffImpl();
	}
		
	public NextTariff getNextTariff()
	{
		return new NextTariffImpl();
	}
		
	public ScaleFactor getScaleFactor(Long valueDigits) throws MissingAvpException
	{
		return new ScaleFactorImpl(valueDigits);
	}
		
	public RateElement getRateElement(CcUnitTypeEnum ccUnitType) throws MissingAvpException
	{
		return new RateElementImpl(ccUnitType);
	}
		
	public UnitCost getUnitCost(Long valueDigits) throws MissingAvpException
	{
		return new UnitCostImpl(valueDigits);
	}
		
	public NNIInformation getNNIInformation()
	{
		return new NNIInformationImpl();
	}
		
	public AccessNetworkInfoChange getAccessNetworkInfoChange()
	{
		return new AccessNetworkInfoChangeImpl();
	}
		
	public AccessTransferInformation getAccessTransferInformation()
	{
		return new AccessTransferInformationImpl();
	}
		
	public RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode(DiameterAddressTypeEnum addressType, ByteBuf value)
	{
		return new RelatedIMSChargingIdentifierNodeImpl(addressType, value, null, null);
	}
		
	//MMSInformation - standard
		
	public MessageClass getMessageClass()
	{
		return new MessageClassImpl();
	}
		
	public MMContentType getMMContentType()
	{
		return new MMContentTypeImpl();
	}
		
	public OriginatorAddress getOriginatorAddress()
	{
		return new OriginatorAddressImpl();
	}
		
	public AddressDomain getAddressDomain()
	{
		return new AddressDomainImpl();
	}
		
	public AdditionalContentInformation getAdditionalContentInformation()
	{
		return new AdditionalContentInformationImpl();
	}
		
	//LCSInformation - standard
		
	public LocationType getLocationType()
	{
		return new LocationTypeImpl();
	}
		
	public LCSClientID getLCSClientID()
	{
		return new LCSClientIDImpl();
	}
		
	public LCSClientName getLCSClientName()
	{
		return new LCSClientNameImpl();
	}
		
	public LCSRequestorID getLCSRequestorID()
	{
		return new LCSRequestorIDImpl();
	}
		
	//PoCInformation - standard
		
	public TalkBurstExchange getTalkBurstExchange(Date pocChangeTime) throws MissingAvpException
	{
		return new TalkBurstExchangeImpl(pocChangeTime);
	}
		
	public ParticipantGroup getParticipantGroup()
	{
		return new ParticipantGroupImpl();
	}
		
	public PoCUserRole getPoCUserRole()
	{
		return new PoCUserRoleImpl();
	}
		
	//SMSInformation - standard
		
	public SMSCAddress getSMSCAddress(DiameterAddressTypeEnum addressType, ByteBuf value)
	{
		return new SMSCAddressImpl(addressType, value, null, null);
	}
		
	public OriginatorInterface getOriginatorInterface()
	{
		return new OriginatorInterfaceImpl();
	}
		
	public DestinationInterface getDestinationInterface()
	{
		return new DestinationInterfaceImpl();
	}
		
	public RecipientInfo getRecipientInfo()
	{
		return new RecipientInfoImpl();
	}
		
	public RecipientReceivedAddress getRecipientReceivedAddress()
	{
		return new RecipientReceivedAddressImpl();
	}
			
	public OriginatorReceivedAddress getOriginatorReceivedAddress()
	{
		return new OriginatorReceivedAddressImpl();
	}
		
	public SMDeviceTriggerInformation getSMDeviceTriggerInformation()
	{
		return new SMDeviceTriggerInformationImpl();
	}
		
	public ServingNode getServingNode()
	{
		return new ServingNodeImpl();
	}
		
	//VCSInformation - standard
		
	public BasicServiceCode getBasicServiceCode()
	{
		return new BasicServiceCodeImpl();
	}
		
	public ISUPCause getISUPCause()
	{
		return new ISUPCauseImpl();
	}
		
	//MMTelInformation - standard
		
	public SupplementaryService getSupplementaryService()
	{
		return new SupplementaryServiceImpl();
	}
		
	public AoCSubscriptionInformation getAoCSubscriptionInformation()
	{
		return new AoCSubscriptionInformationImpl();
	}
		
	public AoCCostInformation getAoCCostInformation()
	{
		return new AoCCostInformationImpl();
	}
		
	public AoCService getAoCService()
	{
		return new AoCServiceImpl();
	}
		
	public IncrementalCost getIncrementalCost(Long valueDigits) throws MissingAvpException
	{
		return new IncrementalCostImpl(valueDigits);
	}
		
	public AccumulatedCost getAccumulatedCost(Long valueDigits) throws MissingAvpException
	{
		return new AccumulatedCostImpl(valueDigits);
	}
		
	//ProSeInformation - standard
		
	public WLANLinkLayerId getWLANLinkLayerId()
	{
		return new WLANLinkLayerIdImpl();
	}
		
	public CoverageInfo getCoverageInfo()
	{
		return new CoverageInfoImpl();
	}
		
	public LocationInfo getLocationInfo()
	{
		return new LocationInfoImpl();
	}
		
	public RadioParameterSetInfo getRadioParameterSetInfo()
	{
		return new RadioParameterSetInfoImpl();
	}
		
	public TransmitterInfo getTransmitterInfo()
	{
		return new TransmitterInfoImpl();
	}
		
	public ProSeDirectCommunicationTransmissionDataContainer getProSeDirectCommunicationTransmissionDataContainer()
	{
		return new ProSeDirectCommunicationTransmissionDataContainerImpl();
	}
		
	public ProSeDirectCommunicationReceptionDataContainer getProSeDirectCommunicationReceptionDataContainer()
	{
		return new ProSeDirectCommunicationReceptionDataContainerImpl();
	}
		
	//CPDTInformation - standard
		
	public NIDDSubmission getNIDDSubmission()
	{
		return new NIDDSubmissionImpl();
	}
}