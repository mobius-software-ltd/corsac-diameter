package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AccessAvailabilityChangeReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPCIoTEPSOptimisationIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPCIoTEPSOptimisationIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Diagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnhancedDiagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedChangeConditionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrafficDataVolumes;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReason;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessAvailabilityChangeReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TrafficDataVolumesImpl implements TrafficDataVolumes
{
    private QoSInformation qosInformation;
	private AccountingInputOctets accountingInputOctets;
	private AccountingOutputOctets accountingOutputOctets;
	private ChangeCondition changeCondition;
	private ChangeTime changeTime;
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private UWANUserLocationInfo uwanUserLocationInfo;
	private TGPPChargingId tgppChargingId;
	private PresenceReportingAreaStatus presenceReportingAreaStatus; 
 	private List<PresenceReportingAreaInformation> presenceReportingAreaInformation;
	private UserCSGInformation userCSGInformation; 
	private TGPPRATType tgppRATType;
	private AccessAvailabilityChangeReason accessAvailabilityChangeReason;
	private RelatedChangeConditionInformation relatedChangeConditionInformation;
	private Diagnostics diagnostics;
	private EnhancedDiagnostics enhancedDiagnostics;
	private CPCIoTEPSOptimisationIndicator cpCIoTEPSOptimisationIndicator;
	private ServingPLMNRateControl servingPLMNRateControl;
	private APNRateControl apnRateControl;
		
	public TrafficDataVolumesImpl()
	{
		
	}
	
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	public Long getAccountingInputOctets()
	{
		if(accountingInputOctets==null)
			return null;
		
		return accountingInputOctets.getLong();
	}
	
	public void setAccountingInputOctets(Long value)
	{
		if(value==null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(value, null, null);			
	}
	
	public Long getAccountingOutputOctets()
	{
		if(accountingOutputOctets==null)
			return null;
		
		return accountingOutputOctets.getLong();
	}
	
	public void setAccountingOutputOctets(Long value)
	{
		if(value==null)
			this.accountingOutputOctets = null;
		else
			this.accountingOutputOctets = new AccountingOutputOctetsImpl(value, null, null);			
	}
	
	public Long getChangeCondition()
	{
		if(changeCondition==null)
			return null;
		
		return changeCondition.getUnsigned();
	}
	
	public void setChangeCondition(Long value)
	{
		if(value==null)
			this.changeCondition = null;
		else
			this.changeCondition = new ChangeConditionImpl(value, null, null);			
	}
	
	public Date getChangeTime()
	{
		if(changeTime==null)
			return null;
		
		return changeTime.getDateTime();
	}
	
	public void setChangeTime(Date value)
	{
		if(value==null)
			this.changeTime = null;
		else
			this.changeTime = new ChangeTimeImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	public UWANUserLocationInfo getUWANUserLocationInfo()
	{
		return this.uwanUserLocationInfo;
	}
	
	public void setUWANUserLocationInfo(UWANUserLocationInfo value)
	{
		this.uwanUserLocationInfo = value;
	}
	
	public ByteBuf get3GPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	public void set3GPPChargingId(ByteBuf value)
	{
		if(value==null)
			this.tgppChargingId = null;
		else
			this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);			
	}
	
	public PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus()
	{
		if(presenceReportingAreaStatus==null)
			return null;
		
		return presenceReportingAreaStatus.getEnumerated(PresenceReportingAreaStatusEnum.class);
	}
	
	public void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value)
	{
		if(value==null)
			this.presenceReportingAreaStatus = null;
		else
			this.presenceReportingAreaStatus = new PresenceReportingAreaStatusImpl(value, null, null);			
	}
	
	public List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}
	
	public void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value)
	{
		this.presenceReportingAreaInformation = value;
	}
	
	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	public ByteBuf get3GPPRATType()
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}
	
	public void set3GPPRATType(ByteBuf value)
	{
		if(value==null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);			
	}
	
	public AccessAvailabilityChangeReasonEnum getAccessAvailabilityChangeReason()
	{
		if(accessAvailabilityChangeReason==null)
			return null;
		
		return accessAvailabilityChangeReason.getEnumerated(AccessAvailabilityChangeReasonEnum.class);
	}
	
	public void setAccessAvailabilityChangeReason(AccessAvailabilityChangeReasonEnum value)
	{
		if(value==null)
			this.accessAvailabilityChangeReason = null;
		else
			this.accessAvailabilityChangeReason = new AccessAvailabilityChangeReasonImpl(value, null, null);			
	}
	
	public RelatedChangeConditionInformation getRelatedChangeConditionInformation()
	{
		return this.relatedChangeConditionInformation;
	}
	
	public void setRelatedChangeConditionInformation(RelatedChangeConditionInformation value)
	{
		this.relatedChangeConditionInformation = value;
	}
	
	public Integer getDiagnostics()
	{
		if(diagnostics==null)
			return null;
		
		return diagnostics.getInteger();
	}
	
	public void setDiagnostics(Integer value)
	{
		if(value==null)
			this.diagnostics = null;
		else
			this.diagnostics = new DiagnosticsImpl(value, null, null);			
	}
	
	public EnhancedDiagnostics getEnhancedDiagnostics()
	{
		return this.enhancedDiagnostics;
	}
	
	public void setEnhancedDiagnostics(EnhancedDiagnostics value)
	{
		this.enhancedDiagnostics = value;
	}
	
	public CPCIoTEPSOptimisationIndicatorEnum getCPCIoTEPSOptimisationIndicator()
	{
		if(cpCIoTEPSOptimisationIndicator==null)
			return null;
		
		return cpCIoTEPSOptimisationIndicator.getEnumerated(CPCIoTEPSOptimisationIndicatorEnum.class);
	}
	
	public void setCPCIoTEPSOptimisationIndicator(CPCIoTEPSOptimisationIndicatorEnum value)
	{
		if(value==null)
			this.cpCIoTEPSOptimisationIndicator = null;
		else
			this.cpCIoTEPSOptimisationIndicator = new CPCIoTEPSOptimisationIndicatorImpl(value, null, null);			
	}
	
	public ServingPLMNRateControl getServingPLMNRateControl()
	{
		return this.servingPLMNRateControl;
	}
	
	public void setServingPLMNRateControl(ServingPLMNRateControl value)
	{
		this.servingPLMNRateControl = value;
	}
	
	public APNRateControl getAPNRateControl()
	{
		return this.apnRateControl;
	}
	
	public void setAPNRateControl(APNRateControl value)
	{
		this.apnRateControl = value;		
	}
}