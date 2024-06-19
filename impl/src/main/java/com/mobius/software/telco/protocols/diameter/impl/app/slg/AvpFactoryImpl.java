package com.mobius.software.telco.protocols.diameter.impl.app.slg;
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

import com.mobius.software.telco.protocols.diameter.app.slg.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AreaDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AreaEventInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.DeferredLocationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.DeferredMTLRDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.DelayedLocationReportingDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.ESMLCCellInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.GERANPositioningInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSEPSClientNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSPrivacyCheckNonSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSPrivacyCheckSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSQoSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSRequestorNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LRAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LRRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.MotionEventInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PLAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PLMNIDListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PLRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PeriodicLDRInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.ReportingPLMNListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.UTRANPositioningInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.LCSCapabilitiesSetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.ServingNodeImpl;
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
/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList); 
	}
	
	public LCSEPSClientName getLCSEPSClientName()
	{
		return new LCSEPSClientNameImpl();
	}
	
	public LCSRequestorName getLCSRequestorName()
	{
		return new LCSRequestorNameImpl();
	}
	
	public LCSQoS getLCSQoS()
	{
		return new LCSQoSImpl();
	}
	
	public LCSPrivacyCheckNonSession getLCSPrivacyCheckNonSession(LCSPrivacyCheckEnum lcsPrivacyCheck) throws MissingAvpException
	{
		return new LCSPrivacyCheckNonSessionImpl(lcsPrivacyCheck);
	}
	
	public LCSPrivacyCheckSession getLCSPrivacyCheckSession(LCSPrivacyCheckEnum lcsPrivacyCheck) throws MissingAvpException
	{
		return new LCSPrivacyCheckSessionImpl(lcsPrivacyCheck);
	}
	
	public DeferredLocationType getDeferredLocationType()
	{
		return new DeferredLocationTypeImpl();
	}
	
	public DeferredMTLRData getDeferredMTLRData(DeferredLocationType deferredLocationType) throws MissingAvpException
	{
		return new DeferredMTLRDataImpl(deferredLocationType);
	}
	
	public AreaEventInfo getAreaEventInfo(AreaDefinition areaDefinition) throws MissingAvpException
	{
		return new AreaEventInfoImpl(areaDefinition);
	}
	
	public AreaDefinition getAreaDefinition(List<Area> area) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		return new AreaDefinitionImpl(area);
	}
	
	public Area getArea(Long areaType, ByteBuf areaIdentification) throws MissingAvpException
	{
		return new AreaImpl(areaType, areaIdentification); 
	}
	
	public PeriodicLDRInfo getPeriodicLDRInfo(Long reportingAmount,Long reportingInterval) throws MissingAvpException
	{
		return new PeriodicLDRInfoImpl(reportingAmount, reportingInterval);
	}
	
	public ReportingPLMNList getReportingPLMNList(List<PLMNIDList> plmnIDList) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		return new ReportingPLMNListImpl(plmnIDList);
	}
	
	public PLMNIDList getPLMNIDList(ByteBuf visitedPLMNId) throws MissingAvpException
	{
		return new PLMNIDListImpl(visitedPLMNId);
	}
	
	public MotionEventInfo getMotionEventInfo(Long linearDistance) throws MissingAvpException
	{
		return new MotionEventInfoImpl(linearDistance);
	}
	
	public GERANPositioningInfo getGERANPositioningInfo()
	{
		return new GERANPositioningInfoImpl();
	}
	
	public UTRANPositioningInfo getUTRANPositioningInfo()
	{
		return new UTRANPositioningInfoImpl();
	}
	
	public ESMLCCellInfo getESMLCCellInfo()
	{
		return new ESMLCCellInfoImpl();
	}
	
	public ServingNode getServingNode()
	{
		return new ServingNodeImpl();
	}
	
	public LCSCapabilitiesSets getLCSCapabilitiesSets()
	{
		return new LCSCapabilitiesSetsImpl();
	}
	
	public DelayedLocationReportingData getDelayedLocationReportingData()
	{
		return new DelayedLocationReportingDataImpl();
	}
	
	public PLRFlags getPLRFlags()
	{
		return new PLRFlagsImpl(); 
	}
	
	public PLAFlags getPLAFlags()
	{
		return new PLAFlagsImpl();
	}
	
	public LRRFlags getLRRFlags()
	{
		return new LRRFlagsImpl();
	}
	
	public LRAFlags getLRAFlags()
	{
		return new LRAFlagsImpl();
	}
}