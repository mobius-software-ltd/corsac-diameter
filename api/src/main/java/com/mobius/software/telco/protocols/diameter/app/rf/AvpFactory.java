package com.mobius.software.telco.protocols.diameter.app.rf;
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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientAddress;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public ServiceInformation getServiceInformation();
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
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
			
	public RecipientAddress getRecipientAddress();
	
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