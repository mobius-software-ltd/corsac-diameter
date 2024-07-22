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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AFCorrelationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncementInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Envelope;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeReporting;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSFurnishChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaConsumptionTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaHoldingTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RefundInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReportingReason;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReportingReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Trigger;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VolumeQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TGPPMultipleServicesCreditControlImpl extends DiameterAvpImpl implements TGPPMultipleServicesCreditControl
{
	private GrantedServiceUnit grantedServiceUnit;
	
	private RequestedServiceUnit requestedServiceUnit;
	
	private List<UsedServiceUnit> usedServiceUnit;
	
	private List<ServiceIdentifier> serviceIdentifier;
	
	private RatingGroup ratingGroup;
	
	private List<GSUPoolReference> gsuPoolReference;
	
	private ValidityTime validityTime;
	
	private ResultCode resultCode;
	
	private FinalUnitIndication finalUnitIndication;
	
	private TimeQuotaThreshold timeQuotaThreshold;
	
	private VolumeQuotaThreshold volumeQuotaThreshold;
	
	private UnitQuotaThreshold unitQuotaThreshold;
	
	private QuotaHoldingTime quotaHoldingTime;
	
	private QuotaConsumptionTime quotaConsumptionTime;
	
	private List<ReportingReason> reportingReason;
	
	private Trigger trigger;
	
	private PSFurnishChargingInformation psFurnishChargingInformation;
	
	private RefundInformation refundInformation;
	
	private List<AFCorrelationInformation> afCorrelationInformation;
	
	private List<Envelope> envelope;
	
	private EnvelopeReporting envelopeReporting;
	
	private TimeQuotaMechanism timeQuotaMechanism;
	
	private List<ServiceSpecificInfo> serviceSpecificInfo;
	
	private QoSInformation qosInformation;
	
	private List<AnnouncementInformation> announcementInformation;
	
	private TGPPRATType tgppRATType;
	
	private RelatedTrigger relatedTrigger;
	
	protected TGPPMultipleServicesCreditControlImpl() 
	{
	}
	
	public TGPPMultipleServicesCreditControlImpl(GrantedServiceUnit grantedServiceUnit, RequestedServiceUnit requestedServiceUnit, List<UsedServiceUnit> usedServiceUnit, List<Long> serviceIdentifier, Long ratingGroup, List<GSUPoolReference> gsuPoolReference, Long validityTime, Long resultCode, FinalUnitIndication finalUnitIndication)
	{
		this.grantedServiceUnit = grantedServiceUnit;
		
		this.requestedServiceUnit = requestedServiceUnit;
		
		this.usedServiceUnit = usedServiceUnit;
		
		if(serviceIdentifier!=null && serviceIdentifier.size()>0)
		{
			this.serviceIdentifier = new ArrayList<ServiceIdentifier>(serviceIdentifier.size());
			for(Long curr:serviceIdentifier)
				this.serviceIdentifier.add(new ServiceIdentifierImpl(curr, null, null));
		}
		
		if(ratingGroup != null)
			this.ratingGroup = new RatingGroupImpl(ratingGroup, null, null);
		
		this.gsuPoolReference = gsuPoolReference;
		
		if(validityTime != null)
			this.validityTime = new ValidityTimeImpl(validityTime, null, null);
		
		if(resultCode != null)
			this.resultCode = new ResultCodeImpl(resultCode, null, null);
		
		this.finalUnitIndication = finalUnitIndication;
	}
	
	@Override
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return this.grantedServiceUnit;
	}
	
	@Override
	public void setGrantedServiceUnit(GrantedServiceUnit value)
	{
		this.grantedServiceUnit = value;
	}
	
	@Override
	public RequestedServiceUnit getRequestedServiceUnit()	
	{
		return this.requestedServiceUnit;
	}

	@Override
	public void setRequestedServiceUnit(RequestedServiceUnit value)
	{
		this.requestedServiceUnit = value;
	}
	
	@Override
	public List<UsedServiceUnit> getUsedServiceUnit()
	{
		return this.usedServiceUnit;
	}

	@Override
	public void setUsedServiceUnit(List<UsedServiceUnit> value)
	{
		this.usedServiceUnit = value;
	}
	
	@Override
	public List<Long> getServiceIdentifier()
	{
		if(this.serviceIdentifier == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ServiceIdentifier curr:serviceIdentifier)
			result.add(curr.getUnsigned());
		
		return result;
	}

	@Override
	public void setServiceIdentifier(List<Long> value)
	{
		if(value == null || value.size()==0)
			this.serviceIdentifier = null;
		else
		{
			this.serviceIdentifier = new ArrayList<ServiceIdentifier>(value.size());
			for(Long curr:value)
				this.serviceIdentifier.add(new ServiceIdentifierImpl(curr, null, null));
		}
	}
	
	@Override
	public Long getRatingGroup()
	{
		if(this.ratingGroup == null)
			return null;
		
		return this.ratingGroup.getUnsigned();
	}

	@Override
	public void setRatingGroup(Long value)
	{
		if(value == null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
			
	@Override
	public List<GSUPoolReference> getGSUPoolReference()
	{
		return this.gsuPoolReference;
	}

	@Override
	public void setGSUPoolReference(List<GSUPoolReference> value)
	{
		this.gsuPoolReference = value;
	}
	
	@Override
	public Long getValidityTime()
	{
		if(this.validityTime == null)
			return null;
		
		return this.validityTime.getUnsigned();
	}

	@Override
	public void setValidityTime(Long value)
	{
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}
			
	@Override
	public Long getResultCode()
	{
		if(this.resultCode == null)
			return null;
		
		return this.resultCode.getUnsigned();
	}

	@Override
	public void setResultCode(Long value)
	{
		if(value == null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(value, null, null);
	}
			
	@Override
	public FinalUnitIndication getFinalUnitIndication()
	{
		return this.finalUnitIndication;
	}

	@Override
	public void setFinalUnitIndication(FinalUnitIndication value)
	{
		this.finalUnitIndication = value;
	}
	
	@Override
	public Long getTimeQuotaThreshold()
	{
		if(this.timeQuotaThreshold == null)
			return null;
		
		return this.timeQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setTimeQuotaThreshold(Long value)
	{
		if(value == null)
			this.timeQuotaThreshold = null;
		else
			this.timeQuotaThreshold = new TimeQuotaThresholdImpl(value, null, null);
	}     
	
	@Override
	public Long getVolumeQuotaThreshold()
	{
		if(this.volumeQuotaThreshold == null)
			return null;
		
		return this.volumeQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setVolumeQuotaThreshold(Long value)
	{
		if(value == null)
			this.volumeQuotaThreshold = null;
		else
			this.volumeQuotaThreshold = new VolumeQuotaThresholdImpl(value, null, null);
	}        
	
	@Override
	public Long getUnitQuotaThreshold()
	{
		if(this.unitQuotaThreshold == null)
			return null;
		
		return this.unitQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setUnitQuotaThreshold(Long value)
	{
		if(value == null)
			this.unitQuotaThreshold = null;
		else
			this.unitQuotaThreshold = new UnitQuotaThresholdImpl(value, null, null);
	}           
	
	@Override
	public Long getQuotaHoldingTime()
	{
		if(this.quotaHoldingTime == null)
			return null;
		
		return this.quotaHoldingTime.getUnsigned();
	}
	
	@Override
	public void setQuotaHoldingTime(Long value)
	{
		if(value == null)
			this.quotaHoldingTime = null;
		else
			this.quotaHoldingTime = new QuotaHoldingTimeImpl(value, null, null);
	}              
	
	@Override
	public Long getQuotaConsumptionTime()
	{
		if(this.quotaConsumptionTime == null)
			return null;
		
		return this.quotaConsumptionTime.getUnsigned();
	}
	
	@Override
	public void setQuotaConsumptionTime(Long value)
	{
		if(value == null)
			this.quotaConsumptionTime = null;
		else
			this.quotaConsumptionTime = new QuotaConsumptionTimeImpl(value, null, null);
	}                   
		
	@Override
	public List<ReportingReasonEnum> getReportingReason()
	{
		if(this.reportingReason == null || this.reportingReason.size()==0)
			return null;
		
		List<ReportingReasonEnum> result = new ArrayList<ReportingReasonEnum>();
		for(ReportingReasonEnum curr: result)
			result.add(curr);
		
		return result;
	}
	
	@Override
	public void setReportingReason(List<ReportingReasonEnum> value)
	{
		if(value == null || value.size()==0)
			this.reportingReason = null;
		else
		{
			this.reportingReason = new ArrayList<ReportingReason>();
			for(ReportingReasonEnum curr:value)
				this.reportingReason.add(new ReportingReasonImpl(curr, null, null));
		}
	}
		
	@Override
	public Trigger getTrigger()
	{
		return this.trigger;
	}
	
	@Override
	public void setTrigger(Trigger value)
	{
		this.trigger = value;
	}
		
	@Override
	public PSFurnishChargingInformation getPSFurnishChargingInformation()
	{
		return this.psFurnishChargingInformation;
	}
	
	@Override
	public void setPSFurnishChargingInformation(PSFurnishChargingInformation value) 
	{
		this.psFurnishChargingInformation = value;
	}
		
	@Override
	public ByteBuf getRefundInformation()
	{
		if(this.refundInformation == null)
			return null;
		
		return this.refundInformation.getValue();
	}
	
	@Override
	public void setRefundInformation(ByteBuf value)
	{
		if(value == null)
			this.refundInformation = null;
		else
			this.refundInformation = new RefundInformationImpl(value, null, null);
	} 
	
	@Override
	public List<AFCorrelationInformation> getAFCorrelationInformation()
	{
		return this.afCorrelationInformation;
	}
	
	@Override
	public void setAFCorrelationInformation(List<AFCorrelationInformation> value)
	{
		this.afCorrelationInformation = value;
	}
	
	@Override
	public List<Envelope> getEnvelope()
	{
		return this.envelope;
	}
	
	@Override
	public void setEnvelope(List<Envelope> value)
	{
		this.envelope = value;
	}
	
	@Override
	public EnvelopeReportingEnum getEnvelopeReporting()
	{
		if(this.envelopeReporting == null)
			return null;
		
		return this.envelopeReporting.getEnumerated(EnvelopeReportingEnum.class);
	}
	
	@Override
	public void setEnvelopeReporting(EnvelopeReportingEnum value)
	{
		if(value == null)
			this.envelopeReporting = null;
		else
			this.envelopeReporting = new EnvelopeReportingImpl(value, null, null);
	}      
	
	@Override
	public TimeQuotaMechanism getTimeQuotaMechanism()
	{
		return this.timeQuotaMechanism;
	}
	
	@Override
	public void setTimeQuotaMechanism(TimeQuotaMechanism value)
	{
		this.timeQuotaMechanism = value;
	}
	
	@Override
	public List<ServiceSpecificInfo> getServiceSpecificInfo()
	{
		return this.serviceSpecificInfo;
	}
	
	@Override
	public void setServiceSpecificInfo(List<ServiceSpecificInfo> value)
	{
		this.serviceSpecificInfo = value;
	}
	
	@Override
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	@Override
	public List<AnnouncementInformation> getAnnouncementInformation()
	{
			return this.announcementInformation;
	}
	
	@Override
	public void setAnnouncementInformation(List<AnnouncementInformation> value)
	{
		this.announcementInformation = value;
	}
	
	@Override
	public ByteBuf getTGPPRATType()
	{
		if(this.tgppRATType == null)
			return null;
		
		return this.tgppRATType.getValue();
	}
	
	@Override
	public void setTGPPRATType(ByteBuf value)
	{
		if(value == null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);
	}
	
	@Override
	public RelatedTrigger getRelatedTrigger()
	{
		return this.relatedTrigger;
	}
	
	@Override
	public void setRelatedTrigger(RelatedTrigger value)
	{
		this.relatedTrigger = value;
	}
}