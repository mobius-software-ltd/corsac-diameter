package com.mobius.software.telco.protocols.diameter.impl.app.rf;
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

import com.mobius.software.telco.protocols.diameter.app.rf.AvpFactory;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TWANUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TalkBurstExchangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TariffInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TimeStampsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TransmitterInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TrunkGroupIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UWANUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UnitCostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.VCSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.WLANOperatorIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.DCDInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.IMInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.oma.ServiceGenericInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANLinkLayerIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddressTypeEnum;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstExchange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransmitterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitCost;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.WLANOperatorId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public ServiceInformation getServiceInformation(List<SubscriptionId> subscriptionId)
	{
		return new ServiceInformationImpl(subscriptionId);
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
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
			
	public IMSInformation getIMSInformation(NodeFunctionalityEnum nodeFunctionality)
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
		
	public TWANUserLocationInfo getTWANUserLocationInfo(String ssid)
	{
		return new TWANUserLocationInfoImpl(ssid);
	}
		
	public UWANUserLocationInfo getUWANUserLocationInfo(InetAddress ueLocalIPAddress)
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
			
	public MessageBody getMessageBody(String contentType,Long contentLength)
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
			
	public TariffInformation getTariffInformation(CurrentTariff currentTariff)
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
			
	public ScaleFactor getScaleFactor(Long valueDigits)
	{
		return new ScaleFactorImpl(valueDigits);
	}
			
	public RateElement getRateElement(CcUnitTypeEnum ccUnitType)
	{
		return new RateElementImpl(ccUnitType);
	}
			
	public UnitCost getUnitCost(Long valueDigits)
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
			
	public TalkBurstExchange getTalkBurstExchange(Date pocChangeTime)
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
			
	public IncrementalCost getIncrementalCost(Long valueDigits)
	{
		return new IncrementalCostImpl(valueDigits);
	}
			
	public AccumulatedCost getAccumulatedCost(Long valueDigits)
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