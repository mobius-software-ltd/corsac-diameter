package com.mobius.software.telco.protocols.diameter.app.slg;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.slg.Area;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredMTLRData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DelayedLocationReportingData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckNonSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoS;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSRequestorName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.MotionEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLMNIDList;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slh.LCSCapabilitiesSets;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public LCSEPSClientName getLCSEPSClientName();
	
	public LCSRequestorName getLCSRequestorName();
	
	public LCSQoS getLCSQoS();
	
	public LCSPrivacyCheckNonSession getLCSPrivacyCheckNonSession(LCSPrivacyCheckEnum lcsPrivacyCheck) throws MissingAvpException;
	
	public LCSPrivacyCheckSession getLCSPrivacyCheckSession(LCSPrivacyCheckEnum lcsPrivacyCheck) throws MissingAvpException;
	
	public DeferredLocationType getDeferredLocationType();
	
	public DeferredMTLRData getDeferredMTLRData(DeferredLocationType deferredLocationType) throws MissingAvpException;
	
	public AreaEventInfo getAreaEventInfo(AreaDefinition areaDefinition) throws MissingAvpException;
	
	public AreaDefinition getAreaDefinition(List<Area> area) throws MissingAvpException, AvpOccursTooManyTimesException;
	
	public Area getArea(Long areaType, ByteBuf areaIdentification) throws MissingAvpException;
	
	public PeriodicLDRInfo getPeriodicLDRInfo(Long reportingAmount,Long reportingInterval) throws MissingAvpException;
	
	public ReportingPLMNList getReportingPLMNList(List<PLMNIDList> plmnIDList) throws MissingAvpException, AvpOccursTooManyTimesException;
	
	public PLMNIDList getPLMNIDList(ByteBuf visitedPLMNId) throws MissingAvpException;
	
	public MotionEventInfo getMotionEventInfo(Long linearDistance) throws MissingAvpException;
	
	public GERANPositioningInfo getGERANPositioningInfo();
	
	public UTRANPositioningInfo getUTRANPositioningInfo();
	
	public ESMLCCellInfo getESMLCCellInfo();
	
	public ServingNode getServingNode();
	
	public LCSCapabilitiesSets getLCSCapabilitiesSets();
	
	public DelayedLocationReportingData getDelayedLocationReportingData();
	
	public PLRFlags getPLRFlags();
	
	public PLAFlags getPLAFlags();
	
	public LRRFlags getLRRFlags();
	
	public LRAFlags getLRAFlags();
}