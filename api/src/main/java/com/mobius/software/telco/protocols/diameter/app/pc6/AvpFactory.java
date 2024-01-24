package com.mobius.software.telco.protocols.diameter.app.pc6;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType);
	
	public TGPPOCSpecificReduction getTGPPOCSpecificReduction();
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public AssistanceInfo getAssistanceInfo();
	
	public WLANAssistanceInfo getWLANAssistanceInfo();
	
	public WiFiP2PAssistanceInfo getWiFiP2PAssistanceInfo();
	
	public WLANLinkLayerIdList getWLANLinkLayerIdList();
	
	public WLANLinkLayerId getWLANLinkLayerId();
	
	public P2PFeatures getP2PFeatures();
	
	public ProSeDirectAllowed getProSeDirectAllowed();
	
	public UserIdentity getUserIdentity(String publicIdentity, String msisdn, String externalIdentifier);
	
	public DiscoveryAuthResponse getDiscoveryAuthResponse(DiscoveryTypeEnum discoveryType);
	
	public DiscoveryAuthRequest getDiscoveryAuthRequest(DiscoveryTypeEnum discoveryType);
	
	public MatchReport getMatchReport(DiscoveryTypeEnum discoveryType);
	
	public MatchReportInfo getMatchReportInfo(DiscoveryTypeEnum discoveryType);
	
	public MatchRequest getMatchRequest(DiscoveryTypeEnum discoveryType);
	
	public LocationUpdateTrigger getLocationUpdateTrigger(LocationUpdateEventTypeEnum locationUpdateEventType);
	
	public CodeReceivingSecurityMaterial getCodeReceivingSecurityMaterial();
	
	public CodeSendingSecurityMaterial getCodeSendingSecurityMaterial();
	
	public ProSeDiscoveryFilter getProSeDiscoveryFilter(ByteBuf filterId,String proSeAppId,Long proSeValidityTimer,ByteBuf proSeAppCode);
	
	public ServiceResult getServiceResult();
	
	public ProSeRestrictedCodeSuffixRange getProSeRestrictedCodeSuffixRange(ByteBuf beginningSuffix);
	
	public ProSeAppCodeSuffixRange getProSeAppCodeSuffixRange(ByteBuf beginningSuffix);
	
	public AppIdentifier getAppIdentifier(ByteBuf osID,String osAppID);
	
	public ProSeAppCodeInfo getProSeAppCodeInfo(ByteBuf proSeAppCode,ByteBuf mic,Long utcBasedCounter);
	
	public PeriodicLocationType getPeriodicLocationType(Long locationReportIntervalTime,Long totalNumberOfReports);
	
	public ChangeOfAreaType getChangeOfAreaType(LocationUpdateEventTriggerEnum locationUpdateEventTrigger,ReportCardinalityEnum reportCardinality);
	
	public PMRFlags getPMRFlags();
	
	public PRRFlags getPRRFlags();
}
