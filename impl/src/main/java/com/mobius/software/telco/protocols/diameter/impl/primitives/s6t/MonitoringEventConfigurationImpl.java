package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ChargedPartyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DLBufferingSuggestedPacketCountImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargedParty;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DLBufferingSuggestedPacketCount;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AssociationType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AssociationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ExcludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IncludeIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumDetectionTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumNumberOfReports;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringDuration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PLMNIDRequested;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PLMNIDRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletionExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3122L, vendorId = KnownVendorIDs.TGPP_ID)
public class MonitoringEventConfigurationImpl extends DiameterGroupedAvpImpl implements MonitoringEventConfiguration
{
	private SCEFReferenceID scefReferenceID;
	private SCEFReferenceIDExt scefReferenceIDExt;
	private SCEFID scefID;
	private MonitoringType monitoringType;
	private List<SCEFReferenceIDForDeletion> scefReferenceIDForDeletion;
	private List<SCEFReferenceIDForDeletionExt> scefReferenceIDForDeletionExt;
	private MaximumNumberOfReports maximumNumberOfReports;
	private MonitoringDuration monitoringDuration;
	private ChargedParty chargedParty;
	private MaximumDetectionTime maximumDetectionTime;
	private UEReachabilityConfiguration ueReachabilityConfiguration;
	private LocationInformationConfiguration locationInformationConfiguration;
	private AssociationType associationType;
	private DLBufferingSuggestedPacketCount dlBufferingSuggestedPacketCount;
	private PLMNIDRequested plmnIDRequested;
	private MTCProviderInfo mtcProviderInfo;
	private PDNConnectivityStatusConfiguration pdnConnectivityStatusConfiguration;
	private ExcludeIdentifiers excludeIdentifiers;
	private IncludeIdentifiers includeIdentifiers;
					 
	protected MonitoringEventConfigurationImpl() 
	{
	}
	
	public MonitoringEventConfigurationImpl(String scefID,MonitoringTypeEnum monitoringType)
	{
		if(scefID==null)
			throw new IllegalArgumentException("SCEF-ID is required");
		
		if(monitoringType==null)
			throw new IllegalArgumentException("Monitoring-Type is required");
				
		this.scefID = new SCEFIDImpl(scefID, null, null);						
		
		this.monitoringType = new MonitoringTypeImpl(monitoringType, null, null);
	}
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID == null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value)
	{
		if(value==null)
			this.scefReferenceID = null;
		else
			this.scefReferenceID = new SCEFReferenceIDImpl(value, null, null);						
	}
	
	public Long getSCEFReferenceIDExt()
	{
		if(scefReferenceIDExt == null)
			return null;
		
		return scefReferenceIDExt.getLong();
	}
	
	public void setSCEFReferenceIDExt(Long value)
	{
		if(value == null)
			this.scefReferenceIDExt = null;
		else
			this.scefReferenceIDExt = new SCEFReferenceIDExtImpl(value, null, null);
	}
	
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("SCEF-ID is required");
		
		this.scefID = new SCEFIDImpl(value, null, null);
	}	
	
	public MonitoringTypeEnum getMonitoringType()
	{
		if(monitoringType == null)
			return null;
		
		return monitoringType.getEnumerated(MonitoringTypeEnum.class);
	}
	
	public void setMonitoringType(MonitoringTypeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("Monitoring-Type is required");
		
		this.monitoringType = new MonitoringTypeImpl(value, null, null);
	}	
	
	public List<Long> getSCEFReferenceIDForDeletion()
	{
		if(scefReferenceIDForDeletion == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletion curr:scefReferenceIDForDeletion)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletion(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletion = null;
		else
		{
			this.scefReferenceIDForDeletion = new ArrayList<SCEFReferenceIDForDeletion>();
			for(Long curr:value)
				this.scefReferenceIDForDeletion.add(new SCEFReferenceIDForDeletionImpl(curr, null, null));			
		}
	}
	
	public List<Long> getSCEFReferenceIDForDeletionExt()
	{
		if(scefReferenceIDForDeletionExt == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletionExt curr:scefReferenceIDForDeletionExt)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletionExt(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletionExt = null;
		else
		{
			this.scefReferenceIDForDeletionExt = new ArrayList<SCEFReferenceIDForDeletionExt>();
			for(Long curr:value)
				this.scefReferenceIDForDeletionExt.add(new SCEFReferenceIDForDeletionExtImpl(curr, null, null));			
		}
	}
	
	public Long getMaximumNumberOfReports()
	{
		if(maximumNumberOfReports == null)
			return null;
		
		return maximumNumberOfReports.getUnsigned();
	}
	
	public void setMaximumNumberOfReports(Long value)
	{
		if(value == null)
			this.maximumNumberOfReports = null;
		else
			this.maximumNumberOfReports = new MaximumNumberOfReportsImpl(value, null, null);
	}
	
	public Date getMonitoringDuration()
	{
		if(monitoringDuration == null)
			return null;
		
		return monitoringDuration.getDateTime();
	}
	
	public void setMonitoringDuration(Date value)
	{
		if(value == null)
			this.monitoringDuration = null;
		else
			this.monitoringDuration = new MonitoringDurationImpl(value, null, null);
	}
	
	public String getChargedParty()
	{
		if(chargedParty == null)
			return null;
		
		return chargedParty.getString();
	}
	
	public void setChargedParty(String value)
	{
		if(value == null)
			this.chargedParty = null;
		else
			this.chargedParty = new ChargedPartyImpl(value, null, null);
	}
	
	public Long getMaximumDetectionTime()
	{
		if(maximumDetectionTime == null)
			return null;
		
		return maximumDetectionTime.getUnsigned();
	}
	
	public void setMaximumDetectionTime(Long value)
	{
		if(value == null)
			this.maximumDetectionTime = null;
		else
			this.maximumDetectionTime = new MaximumDetectionTimeImpl(value, null, null);
	}
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration()
	{
		return ueReachabilityConfiguration;
	}
	
	public void setUEReachabilityConfiguration(UEReachabilityConfiguration value)
	{
		this.ueReachabilityConfiguration = value;
	}
	
	public LocationInformationConfiguration getLocationInformationConfiguration()
	{
		return locationInformationConfiguration;
	}
	
	public void setLocationInformationConfiguration(LocationInformationConfiguration value)
	{
		this.locationInformationConfiguration = value;
	}
	
	public AssociationTypeEnum getAssociationType()
	{
		if(associationType == null)
			return null;
		
		return associationType.getEnumerated(AssociationTypeEnum.class);
	}
	
	public void setAssociationType(AssociationTypeEnum value)
	{
		if(value == null)
			this.associationType = null;
		else
			this.associationType = new AssociationTypeImpl(value, null, null);
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
	
	public PLMNIDRequestedEnum getPLMNIDRequested()
	{
		if(plmnIDRequested == null)
			return null;
		
		return plmnIDRequested.getEnumerated(PLMNIDRequestedEnum.class);
	}
	
	public void setPLMNIDRequested(PLMNIDRequestedEnum value)
	{
		if(value == null)
			this.plmnIDRequested = null;
		else
			this.plmnIDRequested = new PLMNIDRequestedImpl(value, null, null);
	}
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return mtcProviderInfo;
	}
	
	public void setMTCProviderInfo(MTCProviderInfo value)
	{
		this.mtcProviderInfo = value;
	}
	
	public PDNConnectivityStatusConfiguration getPDNConnectivityStatusConfiguration()
	{
		return pdnConnectivityStatusConfiguration;
	}
	
	public void setPDNConnectivityStatusConfiguration(PDNConnectivityStatusConfiguration value)
	{
		this.pdnConnectivityStatusConfiguration = value;
	}
	
	public ExcludeIdentifiers getExcludeIdentifiers()
	{
		return excludeIdentifiers;
	}
	
	public void setExcludeIdentifiers(ExcludeIdentifiers value)
	{
		this.excludeIdentifiers = value;
	}
	
	public IncludeIdentifiers getIncludeIdentifiers()
	{
		return includeIdentifiers;
	}
	
	public void setIncludeIdentifiers(IncludeIdentifiers value)
	{
		this.includeIdentifiers = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(scefID==null)
			return "SCEF-ID is required";
		
		if(monitoringType==null)
			return "Monitoring-Type is required";
		
		return null;
	}
}