package com.mobius.software.telco.protocols.diameter.impl.app.pc6;
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

import com.mobius.software.telco.protocols.diameter.app.pc6.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPPOCSpecificReductionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeDirectAllowedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.AppIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.AssistanceinfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ChangeOfAreaTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.CodeReceivingSecurityMaterialImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.CodeSendingSecurityMaterialImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryAuthResponseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.LocationUpdateTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.MatchReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.MatchReportInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.MatchRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.P2PFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.PMRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.PRRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.PeriodicLocationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeAppCodeInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeAppCodeSuffixRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeDiscoveryFilterImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeRestrictedCodeSuffixRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANAssistanceInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANLinkLayerIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WLANLinkLayerIdListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.WiFiP2PAssistanceInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ServiceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.UserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCSpecificReduction;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeDirectAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AppIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AssistanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ChangeOfAreaType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.CodeReceivingSecurityMaterial;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.CodeSendingSecurityMaterial;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthResponse;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateEventTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.LocationUpdateTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReport;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReportInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.P2PFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PMRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PeriodicLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeDiscoveryFilter;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ReportCardinalityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANAssistanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerIdList;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WiFiP2PAssistanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType)
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public TGPPOCSpecificReduction getTGPPOCSpecificReduction()
	{
		return new TGPPOCSpecificReductionImpl();
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public AssistanceInfo getAssistanceInfo()
	{
		return new AssistanceinfoImpl();
	}
	
	public WLANAssistanceInfo getWLANAssistanceInfo()
	{
		return new WLANAssistanceInfoImpl();
	}
	
	public WiFiP2PAssistanceInfo getWiFiP2PAssistanceInfo()
	{
		return new WiFiP2PAssistanceInfoImpl();
	}
	
	public WLANLinkLayerIdList getWLANLinkLayerIdList()
	{
		return new WLANLinkLayerIdListImpl();
	}
	
	public WLANLinkLayerId getWLANLinkLayerId()
	{
		return new WLANLinkLayerIdImpl();
	}
	
	public P2PFeatures getP2PFeatures()
	{
		return new P2PFeaturesImpl();
	}
	
	public ProSeDirectAllowed getProSeDirectAllowed()
	{
		return new ProSeDirectAllowedImpl();
	}
	
	public UserIdentity getUserIdentity(String publicIdentity, String msisdn, String externalIdentifier)
	{
		return new UserIdentityImpl(publicIdentity, msisdn, externalIdentifier);
	}
	
	public DiscoveryAuthResponse getDiscoveryAuthResponse(DiscoveryTypeEnum discoveryType)
	{
		return new DiscoveryAuthResponseImpl(discoveryType);
	}
	
	public DiscoveryAuthRequest getDiscoveryAuthRequest(DiscoveryTypeEnum discoveryType)
	{
		return new DiscoveryAuthRequestImpl(discoveryType);
	}
	
	public MatchReport getMatchReport(DiscoveryTypeEnum discoveryType)
	{
		return new MatchReportImpl(discoveryType);
	}
	
	public MatchReportInfo getMatchReportInfo(DiscoveryTypeEnum discoveryType)
	{
		return new MatchReportInfoImpl(discoveryType);
	}
	
	public MatchRequest getMatchRequest(DiscoveryTypeEnum discoveryType)
	{
		return new MatchRequestImpl(discoveryType);
	}
	
	public LocationUpdateTrigger getLocationUpdateTrigger(LocationUpdateEventTypeEnum locationUpdateEventType)
	{
		return new LocationUpdateTriggerImpl(locationUpdateEventType);
	}
	
	public CodeReceivingSecurityMaterial getCodeReceivingSecurityMaterial()
	{
		return new CodeReceivingSecurityMaterialImpl();
	}
	
	public CodeSendingSecurityMaterial getCodeSendingSecurityMaterial()
	{
		return new CodeSendingSecurityMaterialImpl();
	}
	
	public ProSeDiscoveryFilter getProSeDiscoveryFilter(ByteBuf filterId,String proSeAppId,Long proSeValidityTimer,ByteBuf proSeAppCode)
	{
		return new ProSeDiscoveryFilterImpl(filterId, proSeAppId, proSeValidityTimer, proSeAppCode);
	}
	
	public ServiceResult getServiceResult()
	{
		return new ServiceResultImpl();
	}
	
	public ProSeRestrictedCodeSuffixRange getProSeRestrictedCodeSuffixRange(ByteBuf beginningSuffix)
	{
		return new ProSeRestrictedCodeSuffixRangeImpl(beginningSuffix);
	}
	
	public ProSeAppCodeSuffixRange getProSeAppCodeSuffixRange(ByteBuf beginningSuffix)
	{
		return new ProSeAppCodeSuffixRangeImpl(beginningSuffix);
	}
	
	public AppIdentifier getAppIdentifier(ByteBuf osID,String osAppID)
	{
		return new AppIdentifierImpl(osID, osAppID);
	}
	
	public ProSeAppCodeInfo getProSeAppCodeInfo(ByteBuf proSeAppCode,ByteBuf mic,Long utcBasedCounter)
	{
		return new ProSeAppCodeInfoImpl(proSeAppCode, mic, utcBasedCounter);
	}
	
	public PeriodicLocationType getPeriodicLocationType(Long locationReportIntervalTime,Long totalNumberOfReports)
	{
		return new PeriodicLocationTypeImpl(locationReportIntervalTime, totalNumberOfReports);
	}
	
	public ChangeOfAreaType getChangeOfAreaType(LocationUpdateEventTriggerEnum locationUpdateEventTrigger,ReportCardinalityEnum reportCardinality)
	{
		return new ChangeOfAreaTypeImpl(locationUpdateEventTrigger, reportCardinality);
	}
	
	public PMRFlags getPMRFlags()
	{
		return new PMRFlagsImpl();
	}
	
	public PRRFlags getPRRFlags()
	{
		return new PRRFlagsImpl();
	}
}
