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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageStatus;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CoverageStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocalSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeDirectCommunicationReceptionDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioFrequency;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioResourcesIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RadioResourcesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UsageInformationReportSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.154Aa	ProSe-Direct-Communication-Reception-Data-Container AVP
	The ProSe-Direct-Communication-Reception-Data-Container AVP (AVP code 3461) is of type Grouped. Its purpose is to allow the transmission of the container to be reported for ProSe Charging. On encountering change on ProSe charging condition, this container  identifies the volume count for receiving within a ProSe group communication.
	It has the following ABNF grammar:
            
    ProSe-Direct-Communication-Reception-Data-Container :: =  < AVP Header: 3461>
		[ Local-Sequence-Number ]
		[ Coverage-Status ]
		[ 3GPP-User-Location-Info ]
		[ Accounting-Input-Octets ]
		[ Change-Time ]
		[ Change-Condition ]
		[ Visited-PLMN-Id ]
		[ Usage-Information-Report-Sequence-Number ]
		[ Radio-Resources-Indicator]
		[ Radio-Frequency ]
 */
@DiameterAvpImplementation(code = 3461L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeDirectCommunicationReceptionDataContainerImpl implements ProSeDirectCommunicationReceptionDataContainer
{
	private LocalSequenceNumber localSequenceNumber;
	private CoverageStatus coverageStatus;
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private AccountingInputOctets accountingInputOctets;
	private ChangeTime changeTime;
	private ChangeCondition changeCondition;
	private VisitedPLMNId visitedPLMNId;
	private UsageInformationReportSequenceNumber usageInformationReportSequenceNumber;
	private RadioResourcesIndicator radioResourcesIndicator;
	private RadioFrequency radioFrequency;
		
	public ProSeDirectCommunicationReceptionDataContainerImpl()
	{
		
	}
	
	public Long getLocalSequenceNumber()
	{
		if(localSequenceNumber==null)
			return null;
		
		return localSequenceNumber.getUnsigned();
	}
	
	public void setLocalSequenceNumber(Long value)
	{
		if(value==null)
			this.localSequenceNumber = null;
		else
			this.localSequenceNumber = new LocalSequenceNumberImpl(value, null, null);			
	}
	
	public CoverageStatusEnum getCoverageStatus()
	{
		if(coverageStatus==null)
			return null;
		
		return coverageStatus.getEnumerated(CoverageStatusEnum.class);
	}
	
	public void setCoverageStatus(CoverageStatusEnum value)
	{
		if(value==null)
			this.coverageStatus = null;
		else
			this.coverageStatus = new CoverageStatusImpl(value, null, null);			
	}
	
	public ByteBuf getTGPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void setTGPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
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
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId==null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value==null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);			
	}
	
	public Integer getUsageInformationReportSequenceNumber()
	{
		if(usageInformationReportSequenceNumber==null)
			return null;
		
		return usageInformationReportSequenceNumber.getInteger();
	}
	
	public void setUsageInformationReportSequenceNumber(Integer value)
	{
		if(value==null)
			this.usageInformationReportSequenceNumber = null;
		else
			this.usageInformationReportSequenceNumber = new UsageInformationReportSequenceNumberImpl(value, null, null);			
	}
	
	public RadioResourcesIndicatorEnum getRadioResourcesIndicator()
	{
		if(radioResourcesIndicator==null)
			return null;
		
		return radioResourcesIndicator.getEnumerated(RadioResourcesIndicatorEnum.class);
	}
	
	public void setRadioResourcesIndicator(RadioResourcesIndicatorEnum value)
	{
		if(value==null)
			this.radioResourcesIndicator = null;
		else
			this.radioResourcesIndicator = new RadioResourcesIndicatorImpl(value, null, null);			
	}
	
	public ByteBuf getRadioFrequency()
	{
		if(radioFrequency==null)
			return null;
		
		return radioFrequency.getValue();
	}
	
	public void setRadioFrequency(ByteBuf value)
	{
		if(value==null)
			this.radioFrequency = null;
		else
			this.radioFrequency = new RadioFrequencyImpl(value, null, null);			
	}
}