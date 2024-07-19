package com.mobius.software.telco.protocols.diameter.app.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
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


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException;
	
	public ServiceInformation getServiceInformation();
	
	public TGPPMultipleServicesCreditControl getMultipleServicesCreditControl(GrantedServiceUnit grantedServiceUnit, RequestedServiceUnit requestedServiceUnit, List<UsedServiceUnit> usedServiceUnit, List<Long> serviceIdentifier, Long ratingGroup, List<GSUPoolReference> gsuPoolReference, Long validityTime, Long resultCode, FinalUnitIndication finalUnitIndication);
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public RequestedServiceUnit getRequestedServiceUnit();
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	public QoSFinalUnitIndication getQoSFinalUnitIndication(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode) throws MissingAvpException;
	
	public GSUPoolReference getGSUPoolReference(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue) throws MissingAvpException;
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException;
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException;		
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws InvalidAvpValueException;
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException;
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress) throws MissingAvpException;
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	//ServiceInformation - Huawei
	
	public PSInformation getPSInformation();
	
	public INInformation getINInformation();
	
	public P2PSMSInformation getP2PSMSInformation();
	
	public IMSInformation getIMSInformation();
	
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
	
	//INInformation - Huawei
	
	public AuthInformation getAuthInformation();
	
	public BalanceInfo getBalanceInfo(Integer balanceCategory, Long balanceID, Long balanceType, Long currentBalance, Date balanceDate, Long measureType) throws MissingAvpException;
	
	public ServiceParameterInfo getServiceParameterInfo(Long serviceParameterType, Long serviceParameterValue) throws MissingAvpException;
	
	public CreditUseNotification getCreditUseNotification();
	
	public PPSAccountNotify getPPSAccountNotify();
	
	public POSAccountNotify getPOSAccountNotify();
	
	public UserBasicInfo getUserBasicInfo();
	
	public CommunityInformation getCommunityInformation();
	
	public AnnouncementData getAnnouncementData();
	
	public NoticeInformation getNoticeInformation();
	
	public AccountInfo getAccountInfo();
	
	public CCCredit getCCCredit(UnitValue unitValue) throws MissingAvpException;
	
	public RechargeInformation getRechargeInformation();
	
	public ChargeMoney getChargeMoney();
	
	public AccountChangeInfo getAccountChangeInfo(ByteBuf accountID, Long accountType, Long currentAccountBalance, Long accountBalanceChange, ByteBuf accountDate, Long accountDateChange, Long measureType) throws MissingAvpException;
	
	public CumInfo getCumInfo();
	
	public CumMoney getCumMoney(CumUnitValue cumUnitValue) throws MissingAvpException;
	
	public CumUnitValue getCumUnitValue(Long cumValueDigits) throws MissingAvpException;
	
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
	
	//SMSInformation - Huawei
	
	public RecipientAddress getRecipientAddress(); 
	
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
	
	public AoCInformation getAoCInformation();
	
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
