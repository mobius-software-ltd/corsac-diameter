package com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.huawei;
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

import java.util.Date;
import java.util.List;

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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorInterfaceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OriginatorReceivedAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ParticipantGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PoCInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PoCUserRoleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeDirectCommunicationReceptionDataContainerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeDirectCommunicationTransmissionDataContainerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ProSeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RadioParameterSetInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RateElementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RealTimeTariffInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RecipientAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RecipientInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RecipientReceivedAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.RelatedIMSChargingIdentifierNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SDPMediaComponentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SDPTimeStampsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SMDeviceTriggerInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SMSCAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ScaleFactorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServiceSpecificInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.SupplementaryServiceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TalkBurstExchangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TariffInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TimeStampsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TransmitterInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TrunkGroupIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UnitCostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.VCSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CCMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CostInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GSUPoolReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesCreditControlImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.QoSFinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RestrictionFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.AccountChangeInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.AccountInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.AnnouncementDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.AuthInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.BalanceInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CCCreditImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.ChargeMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CommunityInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CreditUseNotificationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CumInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CumMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.CumUnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.IMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.INInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.NoticeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.P2PSMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.POSAccountNotifyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.PPSAccountNotifyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.PSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.RechargeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.SMSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.ServiceInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.ServiceParameterInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei.UserBasicInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.DCDInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.IMInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.ServiceGenericInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANLinkLayerIdImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledIdentityChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CurrentTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DestinationInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EarlyMediaDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EventType;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantGroup;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCUserRole;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationReceptionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationTransmissionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioParameterSetInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RateElement;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RealTimeTariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifierNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaComponent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPTimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ScaleFactor;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SupplementaryService;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstExchange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransmitterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountChangeInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AnnouncementData;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CCCredit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChargeMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CommunityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CreditUseNotification;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CumUnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.INInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NoticeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.P2PSMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.POSAccountNotify;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PPSAccountNotify;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RechargeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.UserBasicInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements com.mobius.software.telco.protocols.diameter.app.creditcontrol.huawei.AvpFactory
{
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException
	{
		return new UserEquipmentInfoImpl(userEquipmentInfoType, userEquipmentInfoValue);
	}
	
	public ServiceInformation getServiceInformation()
	{
		return new ServiceInformationImpl();
	}
	
	public MultipleServicesCreditControl getMultipleServicesCreditControl()
	{
		return new MultipleServicesCreditControlImpl();
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	public RequestedServiceUnit getRequestedServiceUnit()
	{
		return new RequestedServiceUnitImpl();
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		return new FinalUnitIndicationImpl(finalUnitAction);
	}
	
	public QoSFinalUnitIndication getQoSFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		return new QoSFinalUnitIndicationImpl(finalUnitAction);
	}
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode) throws MissingAvpException
	{
		return new CostInformationImpl(unitValue, currencyCode);
	}
	
	public GSUPoolReference getGSUPoolReference(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue) throws MissingAvpException
	{
		return new GSUPoolReferenceImpl(gsuPoolIdentifier, ccUnitType, unitValue);
	}
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException
	{
		return new CCMoneyImpl(unitValue);
	}
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException
	{
		return new UnitValueImpl(valueDigits);
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
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	//ServiceInformation - Huawei
	
	public PSInformation getPSInformation()
	{
		return new PSInformationImpl();
	}
	
	public INInformation getINInformation()
	{
		return new INInformationImpl();
	}
	
	public P2PSMSInformation getP2PSMSInformation()
	{
		return new P2PSMSInformationImpl();
	}
	
	public IMSInformation getIMSInformation()
	{
		return new IMSInformationImpl();
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
	
	//INInformation - Huawei
	
	public AuthInformation getAuthInformation()
	{
		return new AuthInformationImpl();
	}
	
	public BalanceInfo getBalanceInfo(Integer balanceCategory, Long balanceID, Long balanceType, Long currentBalance, Date balanceDate, Long measureType) throws MissingAvpException
	{
		return new BalanceInfoImpl(balanceCategory, balanceID, balanceType, currentBalance, balanceDate, measureType);
	}
	
	public ServiceParameterInfo getServiceParameterInfo(Long serviceParameterType, Long serviceParameterValue) throws MissingAvpException
	{
		return new ServiceParameterInfoImpl(serviceParameterType, serviceParameterValue);
	}
	
	public CreditUseNotification getCreditUseNotification()
	{
		return new CreditUseNotificationImpl();
	}
	
	public PPSAccountNotify getPPSAccountNotify()
	{
		return new PPSAccountNotifyImpl();
	}
	
	public POSAccountNotify getPOSAccountNotify()
	{
		return new POSAccountNotifyImpl();
	}
	
	public UserBasicInfo getUserBasicInfo()
	{
		return new UserBasicInfoImpl();				
	}
	
	public CommunityInformation getCommunityInformation()
	{
		return new CommunityInformationImpl();
	}
	
	public AnnouncementData getAnnouncementData()
	{
		return new AnnouncementDataImpl();
	}
	
	public NoticeInformation getNoticeInformation()
	{
		return new NoticeInformationImpl();				
	}
	
	public AccountInfo getAccountInfo()
	{
		return new AccountInfoImpl();
	}
	
	public CCCredit getCCCredit(UnitValue unitValue) throws MissingAvpException
	{
		return new CCCreditImpl(unitValue);
	}
	
	public RechargeInformation getRechargeInformation()
	{
		return new RechargeInformationImpl();
	}
	
	public ChargeMoney getChargeMoney()
	{
		return new ChargeMoneyImpl();
	}
	
	public AccountChangeInfo getAccountChangeInfo(ByteBuf accountID, Long accountType, Long currentAccountBalance, Long accountBalanceChange, ByteBuf accountDate, Long accountDateChange, Long measureType) throws MissingAvpException
	{
		return new AccountChangeInfoImpl(accountID, accountType, currentAccountBalance, accountBalanceChange, accountDate, accountDateChange, measureType);
	}
	
	public CumInfo getCumInfo()
	{
		return new CumInfoImpl();
	}
	
	public CumMoney getCumMoney(CumUnitValue cumUnitValue) throws MissingAvpException
	{
		return new CumMoneyImpl(cumUnitValue);
	}
	
	public CumUnitValue getCumUnitValue(Long cumValueDigits) throws MissingAvpException
	{
		return new CumUnitValueImpl(cumValueDigits);
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
	
	//SMSInformation - Huawei
	
	public RecipientAddress getRecipientAddress()
	{
		return new RecipientAddressImpl();
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
	
	public AoCInformation getAoCInformation()
	{
		return new AoCInformationImpl();
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