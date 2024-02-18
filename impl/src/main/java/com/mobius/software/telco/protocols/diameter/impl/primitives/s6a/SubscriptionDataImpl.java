package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ActiveTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfigurationProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentAccessRestrictionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AerialUESubscriptionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AerialUESubscriptionInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.BroadcastLocationAssistanceDataTypes;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CallBarringInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CoreNetworkRestrictions;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DLBufferingSuggestedPacketCount;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GPRSSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HPLMNODB;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IABOperationPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IABOperationPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ICSIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ICSIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTUserConsent;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTUserConsentEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MPSPriority;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NetworkAccessMode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NetworkAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OperatorDeterminedBarring;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PagingTimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RATFrequencySelectionPriorityID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RegionalSubscriptionZoneCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RelayNodeIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RelayNodeIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RoamingRestrictedDueToUnsupportedFeature;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RoamingRestrictedDueToUnsupportedFeatureEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.STNSR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceGapTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedARPI;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedPeriodicRAUTAUTimer;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedVSRVCC;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscribedVSRVCCEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriberStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriberStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TeleserviceList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.V2XSubscriptionDataNr;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNLIPAAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNLIPAAllowedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ActiveTime;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SubscriptionDataImpl extends DiameterGroupedAvpImpl implements SubscriptionData
{
	private SubscriberStatus subscriberStatus;
	private MSISDN msisdn;
	private AMSISDN aMSISDN;
	private STNSR stnsr;
	private ICSIndicator icsIndicator;
	private NetworkAccessMode networkAccessMode;
	private OperatorDeterminedBarring operatorDeterminedBarring;
	private HPLMNODB hplmODB;
	private List<RegionalSubscriptionZoneCode> regionalSubscriptionZoneCode;
	private AccessRestrictionData accessRestrictionData;
	private APNOIReplacement apnOIReplacement;
	private LCSInfo lcsInfo;
	private TeleserviceList teleserviceList;
	private List<CallBarringInfo> callBarringInfo;
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	private AMBR ambr;
	private APNConfigurationProfile apnConfigurationProfile;
	private RATFrequencySelectionPriorityID ratFrequencySelectionPriorityID;
	private TraceData traceData;
	private GPRSSubscriptionData gprsSubscriptionData;
	private List<CSGSubscriptionData> csgSubscriptionData;
	private RoamingRestrictedDueToUnsupportedFeature roamingRestrictedDueToUnsupportedFeature;
	private SubscribedPeriodicRAUTAUTimer subscribedPeriodicRAUTAUTimer;
	private MPSPriority mpsPriority;
	private VPLMNLIPAAllowed vplmNLIPAAllowed;
	private RelayNodeIndicator relayNodeIndicator;
	private MDTUserConsent mdtUserConsent;
	private SubscribedVSRVCC subscribedVSRVCC;
	private ProSeSubscriptionData proSeSubscriptionData;
	private SubscriptionDataFlags subscriptionDataFlags;
	private List<AdjacentAccessRestrictionData> adjacentAccessRestrictionData;
	private DLBufferingSuggestedPacketCount dlBufferingSuggestedPacketCount;
	private List<IMSIGroupId> imsiGroupId;
	private UEUsageType ueUsageType;
	private List<AESECommunicationPattern> aesECommunicationPattern;
	private List<MonitoringEventConfiguration> monitoringEventConfiguration;
	private EmergencyInfo emergencyInfo;
	private V2XSubscriptionData v2xSubscriptionData;
	private V2XSubscriptionDataNr v2xSubscriptionDataNr;
	private List<EDRXCycleLength> eDRXCycleLength;
	private ExternalIdentifier externalIdentifier;
	private ActiveTime activeTime;
	private ServiceGapTime serviceGapTime;
	private BroadcastLocationAssistanceDataTypes broadcastLocationAssistanceDataTypes;
	private AerialUESubscriptionInformation aerialUESubscriptionInformation;
	private CoreNetworkRestrictions coreNetworkRestrictions;
	private List<PagingTimeWindow> pagingTimeWindow;
	private SubscribedARPI subscribedARPI;
	private IABOperationPermission iabOperationPermission;
	
	public SubscriptionDataImpl()
	{
		
	}
	
	public SubscriberStatusEnum getSubscriberStatus()
	{
		if(subscriberStatus == null)
			return null;
		
		return subscriberStatus.getEnumerated(SubscriberStatusEnum.class);
	}
	
	public void setSubscriberStatus(SubscriberStatusEnum value)
	{
		if(value == null)
			this.subscriberStatus = null;
		else
			this.subscriberStatus = new SubscriberStatusImpl(value, null, null);
	}
	
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	public String getAMSISDN()
	{
		if(aMSISDN == null)
			return null;
		
		return aMSISDN.getAddress();
	}
	
	public void setAMSISDN(String value)
	{
		if(value == null)
			this.aMSISDN = null;
		else
			this.aMSISDN = new AMSISDNImpl(value);
	}
	
	public String getSTNSR()
	{
		if(stnsr == null)
			return null;
		
		return stnsr.getAddress();
	}
	
	public void setSTNSR(String value)
	{
		if(value == null)
			this.stnsr = null;
		else
			this.stnsr = new STNSRImpl(value);
	}
	
	public ICSIndicatorEnum getICSIndicator()
	{
		if(icsIndicator == null)
			return null;
		
		return icsIndicator.getEnumerated(ICSIndicatorEnum.class);
	}
	
	public void setICSIndicator(ICSIndicatorEnum value)
	{
		if(value == null)
			this.icsIndicator = null;
		else
			this.icsIndicator = new ICSIndicatorImpl(value, null, null);
	}
	
	public NetworkAccessModeEnum getNetworkAccessMode()
	{
		if(networkAccessMode == null)
			return null;
		
		return networkAccessMode.getEnumerated(NetworkAccessModeEnum.class);
	}
	
	public void setNetworkAccessMode(NetworkAccessModeEnum value)
	{
		if(value == null)
			this.networkAccessMode = null;
		else
			this.networkAccessMode = new NetworkAccessModeImpl(value, null, null);
	}
	
	public OperatorDeterminedBarring getOperatorDeterminedBarring()
	{
		return operatorDeterminedBarring;
	}
	
	public void setOperatorDeterminedBarring(OperatorDeterminedBarring value)
	{
		this.operatorDeterminedBarring = value;
	}
	
	public HPLMNODB getHPLMNODB()
	{
		return hplmODB;
	}
	
	public void setHPLMNODB(HPLMNODB value)
	{
		this.hplmODB = value;
	}
	
	public List<ByteBuf> getRegionalSubscriptionZoneCode()
	{
		if(regionalSubscriptionZoneCode == null || regionalSubscriptionZoneCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RegionalSubscriptionZoneCode curr:regionalSubscriptionZoneCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setRegionalSubscriptionZoneCode(List<ByteBuf> value) throws AvpOccursTooManyTimesException
	{
		if(value == null || value.size()==0)
			this.regionalSubscriptionZoneCode = null;
		else if(value.size()>10)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(ByteBuf curr:value)
				failedAvps.add(new RegionalSubscriptionZoneCodeImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 10 Regional-Subscription-Zone-Code are allowed", failedAvps);
		}
		else
		{
			this.regionalSubscriptionZoneCode = new ArrayList<RegionalSubscriptionZoneCode>();
			for(ByteBuf curr:value)
				this.regionalSubscriptionZoneCode.add(new RegionalSubscriptionZoneCodeImpl(curr, null, null));					
		}
	}
	
	public AccessRestrictionData getAccessRestrictionData()
	{
		return accessRestrictionData;
	}
	
	public void setAccessRestrictionData(AccessRestrictionData value)
	{
		this.accessRestrictionData = value;
	}
	
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement == null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	public void setAPNOIReplacement(String value)
	{
		if(value == null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);
	}
	
	public LCSInfo getLCSInfo()
	{
		return lcsInfo;
	}
	
	public void setLCSInfo(LCSInfo value)
	{
		this.lcsInfo = value;
	}
	
	public TeleserviceList getTeleserviceList()
	{
		return teleserviceList;
	}
	
	public void setTeleserviceList(TeleserviceList value)
	{
		this.teleserviceList = value;
	}
	
	public List<CallBarringInfo> getCallBarringInfo()
	{
		return callBarringInfo;
	}
	
	public void setCallBarringInfo(List<CallBarringInfo> value)
	{
		this.callBarringInfo = value;
	}
	
	public String getTGPPChargingCharacteristics()
	{
		if(tgppChargingCharacteristics == null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}
	
	public void setTGPPChargingCharacteristics(String value)
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	public AMBR getAMBR()
	{
		return ambr;
	}
	
	public void setAMBR(AMBR value)
	{
		this.ambr = value;
	}
	
	public APNConfigurationProfile getAPNConfigurationProfile()
	{
		return apnConfigurationProfile;
	}
	
	public void setAPNConfigurationProfile(APNConfigurationProfile value)
	{
		this.apnConfigurationProfile = value;
	}
	
	public Long getRATFrequencySelectionPriorityID()
	{
		if(ratFrequencySelectionPriorityID == null)
			return null;
		
		return ratFrequencySelectionPriorityID.getUnsigned();
	}
	
	public void setRATFrequencySelectionPriorityID(Long value)
	{
		if(value == null)
			this.ratFrequencySelectionPriorityID = null;
		else
			this.ratFrequencySelectionPriorityID = new RATFrequencySelectionPriorityIDImpl(value, null, null);
	}
	
	public TraceData getTraceData()
	{
		return traceData;
	}
	
	public void setTraceData(TraceData value)
	{
		this.traceData = value;
	}
	
	public GPRSSubscriptionData getGPRSSubscriptionData()
	{
		return gprsSubscriptionData;
	}
	
	public void setGPRSSubscriptionData(GPRSSubscriptionData value)
	{
		this.gprsSubscriptionData = value;
	}
	
	public List<CSGSubscriptionData> getCSGSubscriptionData()
	{
		return csgSubscriptionData;
	}
	
	public void setCSGSubscriptionData(List<CSGSubscriptionData> value)
	{
		this.csgSubscriptionData = value;
	}
	
	public RoamingRestrictedDueToUnsupportedFeatureEnum getRoamingRestrictedDueToUnsupportedFeature()
	{
		if(roamingRestrictedDueToUnsupportedFeature == null)
			return null;
		
		return roamingRestrictedDueToUnsupportedFeature.getEnumerated(RoamingRestrictedDueToUnsupportedFeatureEnum.class);
	}
	
	public void setRoamingRestrictedDueToUnsupportedFeature(RoamingRestrictedDueToUnsupportedFeatureEnum value)
	{
		if(value == null)
			this.roamingRestrictedDueToUnsupportedFeature = null;
		else
			this.roamingRestrictedDueToUnsupportedFeature = new RoamingRestrictedDueToUnsupportedFeatureImpl(value, null, null);
	}
	
	public Long getSubscribedPeriodicRAUTAUTimer()
	{
		if(subscribedPeriodicRAUTAUTimer == null)
			return null;
		
		return subscribedPeriodicRAUTAUTimer.getUnsigned();
	}
	
	public void setSubscribedPeriodicRAUTAUTimer(Long value)
	{
		if(value == null)
			this.subscribedPeriodicRAUTAUTimer = null;
		else
			this.subscribedPeriodicRAUTAUTimer = new SubscribedPeriodicRAUTAUTimerImpl(value, null, null);
	}	
	
	public MPSPriority getMPSPriority()
	{
		return mpsPriority;
	}
	
	public void setMPSPriority(MPSPriority value)
	{
		this.mpsPriority = value;
	}
	
	public VPLMNLIPAAllowedEnum getVPLMNLIPAAllowed()
	{
		if(vplmNLIPAAllowed == null)
			return null;
		
		return vplmNLIPAAllowed.getEnumerated(VPLMNLIPAAllowedEnum.class);
	}
	
	public void setVPLMNLIPAAllowed(VPLMNLIPAAllowedEnum value)
	{
		if(value == null)
			this.vplmNLIPAAllowed = null;
		else
			this.vplmNLIPAAllowed = new VPLMNLIPAAllowedImpl(value, null, null);
	}
	
	public RelayNodeIndicatorEnum getRelayNodeIndicator()
	{
		if(relayNodeIndicator == null)
			return null;
		
		return relayNodeIndicator.getEnumerated(RelayNodeIndicatorEnum.class);
	}
	
	public void setRelayNodeIndicator(RelayNodeIndicatorEnum value)
	{
		if(value == null)
			this.relayNodeIndicator = null;
		else
			this.relayNodeIndicator = new RelayNodeIndicatorImpl(value, null, null);
	}
	
	public MDTUserConsentEnum getMDTUserConsent()
	{
		if(mdtUserConsent == null)
			return null;
		
		return mdtUserConsent.getEnumerated(MDTUserConsentEnum.class);
	}
	
	public void setMDTUserConsent(MDTUserConsentEnum value)
	{
		if(value == null)
			this.mdtUserConsent = null;
		else
			this.mdtUserConsent = new MDTUserConsentImpl(value, null, null);
	}
	
	public SubscribedVSRVCCEnum getSubscribedVSRVCC()
	{
		if(subscribedVSRVCC == null)
			return null;
		
		return subscribedVSRVCC.getEnumerated(SubscribedVSRVCCEnum.class);
	}
	
	public void setSubscribedVSRVCC(SubscribedVSRVCCEnum value)
	{
		if(value == null)
			this.subscribedVSRVCC = null;
		else
			this.subscribedVSRVCC = new SubscribedVSRVCCImpl(value, null, null);
	}
	
	public ProSeSubscriptionData getProSeSubscriptionData()
	{
		return proSeSubscriptionData;
	}
	
	public void setProSeSubscriptionData(ProSeSubscriptionData value)
	{
		this.proSeSubscriptionData = value;
	}
	
	public SubscriptionDataFlags getSubscriptionDataFlags()
	{
		return subscriptionDataFlags;
	}
	
	public void setSubscriptionDataFlags(SubscriptionDataFlags value)
	{
		this.subscriptionDataFlags = value;
	}
	
	public List<AdjacentAccessRestrictionData> getAdjacentAccessRestrictionData()
	{
		return adjacentAccessRestrictionData;
	}
	
	public void setAdjacentAccessRestrictionData(List<AdjacentAccessRestrictionData> value)
	{
		this.adjacentAccessRestrictionData = value;
	}
	
	public Integer getDLBufferingSuggestedPacketCount()
	{
		if(dlBufferingSuggestedPacketCount == null)
			return null;
		
		return dlBufferingSuggestedPacketCount.getInteger();
	}
	
	public void setDLBufferingSuggestedPacketCount(Integer value)
	{
		if(value == null)
			this.dlBufferingSuggestedPacketCount = null;
		else
			this.dlBufferingSuggestedPacketCount = new DLBufferingSuggestedPacketCountImpl(value, null, null);
	}
	
	public List<IMSIGroupId> getIMSIGroupId()
	{
		return imsiGroupId;
	}
	
	public void setIMSIGroupId(List<IMSIGroupId> value)
	{
		this.imsiGroupId = value;
	}
	
	public Long getUEUsageType()
	{
		if(ueUsageType == null)
			return null;
		
		return ueUsageType.getUnsigned();
	}
	
	public void setUEUsageType(Long value)
	{
		if(value == null)
			this.ueUsageType = null;
		else
			this.ueUsageType = new UEUsageTypeImpl(value, null, null);
	}
	
	public List<AESECommunicationPattern> getAESECommunicationPattern()
	{
		return aesECommunicationPattern;
	}
	
	public void setAESECommunicationPattern(List<AESECommunicationPattern> value)
	{
		this.aesECommunicationPattern = value;
	}
	
	public List<MonitoringEventConfiguration> getMonitoringEventConfiguration()
	{
		return monitoringEventConfiguration;
	}
	
	public void setMonitoringEventConfiguration(List<MonitoringEventConfiguration> value)
	{
		this.monitoringEventConfiguration = value;
	}
	
	public EmergencyInfo getEmergencyInfo()
	{
		return emergencyInfo;
	}
	
	public void setEmergencyInfo(EmergencyInfo value)
	{
		this.emergencyInfo = value;
	}
	
	public V2XSubscriptionData getV2XSubscriptionData()
	{
		return v2xSubscriptionData;
	}
	
	public void setV2XSubscriptionData(V2XSubscriptionData value)
	{
		this.v2xSubscriptionData = value;
	}
	
	public V2XSubscriptionDataNr getV2XSubscriptionDataNr()
	{
		return v2xSubscriptionDataNr;
	}
	
	public void setV2XSubscriptionDataNr(V2XSubscriptionDataNr value)
	{
		this.v2xSubscriptionDataNr = value;
	}
	
	public List<EDRXCycleLength> getEDRXCycleLength()
	{
		return eDRXCycleLength;
	}
	
	public void setEDRXCycleLength(List<EDRXCycleLength> value)
	{
		this.eDRXCycleLength = value;
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier == null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value == null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
	}
	
	public Long getActiveTime()
	{
		if(activeTime == null)
			return null;
		
		return activeTime.getUnsigned();
	}
	
	public void setActiveTime(Long value)
	{
		if(value == null)
			this.activeTime = null;
		else
			this.activeTime = new ActiveTimeImpl(value, null, null);
	}
	
	public Long getServiceGapTime()
	{
		if(serviceGapTime == null)
			return null;
		
		return serviceGapTime.getUnsigned();
	}
	
	public void setServiceGapTime(Long value)
	{
		if(value == null)
			this.serviceGapTime = null;
		else
			this.serviceGapTime = new ServiceGapTimeImpl(value, null, null);
	}
	
	public BroadcastLocationAssistanceDataTypes getBroadcastLocationAssistanceDataTypes()
	{
		return broadcastLocationAssistanceDataTypes;
	}
	
	public void setBroadcastLocationAssistanceDataTypes(BroadcastLocationAssistanceDataTypes value)
	{
		this.broadcastLocationAssistanceDataTypes = value;
	}
	
	public AerialUESubscriptionInformationEnum getAerialUESubscriptionInformation()
	{
		if(aerialUESubscriptionInformation == null)
			return null;
		
		return aerialUESubscriptionInformation.getEnumerated(AerialUESubscriptionInformationEnum.class);
	}
	
	public void setAerialUESubscriptionInformation(AerialUESubscriptionInformationEnum value)
	{
		if(value == null)
			this.aerialUESubscriptionInformation = null;
		else
			this.aerialUESubscriptionInformation = new AerialUESubscriptionInformationImpl(value, null, null);
	}
	
	public Long getCoreNetworkRestrictions()
	{
		if(coreNetworkRestrictions == null)
			return null;
		
		return coreNetworkRestrictions.getUnsigned();
	}
	
	public void setCoreNetworkRestrictions(Long value)
	{
		if(value == null)
			this.coreNetworkRestrictions = null;
		else
			this.coreNetworkRestrictions = new CoreNetworkRestrictionsImpl(value, null, null);
	}
	
	public List<PagingTimeWindow> getPagingTimeWindow()
	{
		return pagingTimeWindow;
	}
	
	public void setPagingTimeWindow(List<PagingTimeWindow> value)
	{
		this.pagingTimeWindow = value;
	}
	
	public Long getSubscribedARPI()
	{
		if(subscribedARPI == null)
			return null;
		
		return subscribedARPI.getUnsigned();
	}
	
	public void setSubscribedARPI(Long value)
	{
		if(value == null)
			this.subscribedARPI = null;
		else
			this.subscribedARPI = new SubscribedARPIImpl(value, null, null);
	}
	
	public IABOperationPermissionEnum getIABOperationPermission()
	{
		if(iabOperationPermission == null)
			return null;
		
		return iabOperationPermission.getEnumerated(IABOperationPermissionEnum.class);
	}
	
	public void setIABOperationPermission(IABOperationPermissionEnum value)
	{
		if(value == null)
			this.iabOperationPermission = null;
		else
			this.iabOperationPermission = new IABOperationPermissionImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(regionalSubscriptionZoneCode!=null && regionalSubscriptionZoneCode.size()>10)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(regionalSubscriptionZoneCode);
			return new AvpOccursTooManyTimesException("Up to 50 Regional-Subscription-Zone-Code are allowed", failedAvps);
		}
		
		return null;
	}
}