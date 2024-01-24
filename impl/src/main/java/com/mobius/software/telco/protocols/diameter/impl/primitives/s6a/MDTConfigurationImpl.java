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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CollectionPeriodRRMLTE;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CollectionPeriodRRMLTEEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CollectionPeriodRRMUMTS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CollectionPeriodRRMUMTSEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EventThresholdEvent1F;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EventThresholdEvent1I;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EventThresholdRSRP;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EventThresholdRSRQ;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.JobTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ListOfMeasurements;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LoggingDuration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LoggingDurationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LoggingInterval;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LoggingIntervalEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MBSFNArea;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTAllowedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MeasurementPeriodLTE;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MeasurementPeriodLTEEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MeasurementPeriodUMTS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MeasurementPeriodUMTSEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MeasurementQuantity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PositioningMethod;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportAmount;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportAmountEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportInterval;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportIntervalEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReportingTrigger;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1622L, vendorId = KnownVendorIDs.TGPP_ID)
public class MDTConfigurationImpl extends DiameterGroupedAvpImpl implements MDTConfiguration
{
	private JobType jobType;
	private AreaScope areaScope;
	private ListOfMeasurements listOfMeasurements;
	private ReportingTrigger reportingTrigger;
	private ReportInterval reportInterval;
	private ReportAmount reportAmount;
	private EventThresholdRSRP eventThresholdRSRP;
	private EventThresholdRSRQ eventThresholdRSRQ;
	private LoggingInterval loggingInterval;
	private LoggingDuration loggingDuration;
	private MeasurementPeriodLTE measurementPeriodLTE;
	private MeasurementPeriodUMTS measurementPeriodUMTS;
	private CollectionPeriodRRMLTE collectionPeriodRRMLTE;
	private CollectionPeriodRRMUMTS collectionPeriodRRMUMTS;
	private PositioningMethod positioningMethod;
	private MeasurementQuantity measurementQuantity;
	private EventThresholdEvent1F eventThresholdEvent1F;
	private EventThresholdEvent1I eventThresholdEvent1I;
	private List<MDTAllowedPLMNId> mdtAllowedPLMNId;
	private List<MBSFNArea> mbsfnArea;
			
	protected MDTConfigurationImpl()
	{
		
	}
	
	public MDTConfigurationImpl(JobTypeEnum jobType)
	{
		if(jobType==null)
			throw new IllegalArgumentException("Job-Type is required");
		
		this.jobType = new JobTypeImpl(jobType, null, null);		
	}
	
	public JobTypeEnum getJobType()
	{
		if(jobType == null)
			return null;
		
		return jobType.getEnumerated(JobTypeEnum.class);
	}
	
	public void setJobType(JobTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Job-Type is required");
		
		this.jobType = new JobTypeImpl(value, null, null);		
	}
	
	public AreaScope getAreaScope()
	{
		return areaScope;
	}
	
	public void setAreaScope(AreaScope value)
	{
		this.areaScope = value;
	}
	
	public ListOfMeasurements getListOfMeasurements()
	{
		return listOfMeasurements;
	}
	
	public void setListOfMeasurements(ListOfMeasurements value)
	{
		this.listOfMeasurements = value;
	}
	
	public ReportingTrigger getReportingTrigger()
	{
		return reportingTrigger;
	}
	
	public void setReportingTrigger(ReportingTrigger value)
	{
		this.reportingTrigger = value;
	}
	
	public ReportIntervalEnum getReportInterval()
	{
		if(reportInterval == null)
			return null;
		
		return reportInterval.getEnumerated(ReportIntervalEnum.class);
	}
	
	public void setReportInterval(ReportIntervalEnum value)
	{
		if(value == null)
			this.reportInterval = null;
		else
			this.reportInterval = new ReportIntervalImpl(value, null, null);
	}
	
	public ReportAmountEnum getReportAmount()
	{
		if(reportAmount == null)
			return null;
		
		return reportAmount.getEnumerated(ReportAmountEnum.class);
	}
	
	public void setReportAmount(ReportAmountEnum value)
	{
		if(value == null)
			this.reportAmount = null;
		else
			this.reportAmount = new ReportAmountImpl(value, null, null);
	}
	
	public Long getEventThresholdRSRP()
	{
		if(eventThresholdRSRP == null)
			return null;
		
		return eventThresholdRSRP.getUnsigned();
	}
	
	public void setEventThresholdRSRP(Long value)
	{
		if(value == null)
			this.eventThresholdRSRP = null;
		else
			this.eventThresholdRSRP = new EventThresholdRSRPImpl(value, null, null);
	}
	
	public Long getEventThresholdRSRQ()
	{
		if(eventThresholdRSRQ == null)
			return null;
		
		return eventThresholdRSRQ.getUnsigned();
	}
	
	public void setEventThresholdRSRQ(Long value)
	{
		if(value == null)
			this.eventThresholdRSRQ = null;
		else
			this.eventThresholdRSRQ = new EventThresholdRSRQImpl(value, null, null);
	}
	
	public LoggingIntervalEnum getLoggingInterval()
	{
		if(loggingInterval == null)
			return null;
		
		return loggingInterval.getEnumerated(LoggingIntervalEnum.class);
	}
	
	public void setLoggingInterval(LoggingIntervalEnum value)
	{
		if(value == null)
			this.loggingInterval = null;
		else
			this.loggingInterval = new LoggingIntervalImpl(value, null, null);
	}
	
	public LoggingDurationEnum getLoggingDuration()
	{
		if(loggingDuration == null)
			return null;
		
		return loggingDuration.getEnumerated(LoggingDurationEnum.class);
	}
	
	public void setLoggingDuration(LoggingDurationEnum value)
	{
		if(value == null)
			this.loggingDuration = null;
		else
			this.loggingDuration = new LoggingDurationImpl(value, null, null);
	}
	
	public MeasurementPeriodLTEEnum getMeasurementPeriodLTE()
	{
		if(measurementPeriodLTE == null)
			return null;
		
		return measurementPeriodLTE.getEnumerated(MeasurementPeriodLTEEnum.class);
	}
	
	public void setMeasurementPeriodLTE(MeasurementPeriodLTEEnum value)
	{
		if(value == null)
			this.measurementPeriodLTE = null;
		else
			this.measurementPeriodLTE = new MeasurementPeriodLTEImpl(value, null, null);
	}
	
	public MeasurementPeriodUMTSEnum getMeasurementPeriodUMTS()
	{
		if(measurementPeriodUMTS == null)
			return null;
		
		return measurementPeriodUMTS.getEnumerated(MeasurementPeriodUMTSEnum.class);
	}
	
	public void setMeasurementPeriodUMTS(MeasurementPeriodUMTSEnum value)
	{
		if(value == null)
			this.measurementPeriodUMTS = null;
		else
			this.measurementPeriodUMTS = new MeasurementPeriodUMTSImpl(value, null, null);
	}
	
	public CollectionPeriodRRMLTEEnum getCollectionPeriodRRMLTE()
	{
		if(collectionPeriodRRMLTE == null)
			return null;
		
		return collectionPeriodRRMLTE.getEnumerated(CollectionPeriodRRMLTEEnum.class);
	}
	
	public void setCollectionPeriodRRMLTE(CollectionPeriodRRMLTEEnum value)
	{
		if(value == null)
			this.collectionPeriodRRMLTE = null;
		else
			this.collectionPeriodRRMLTE = new CollectionPeriodRRMLTEImpl(value, null, null);
	}
	
	public CollectionPeriodRRMUMTSEnum getCollectionPeriodRRMUMTS()
	{
		if(collectionPeriodRRMUMTS == null)
			return null;
		
		return collectionPeriodRRMUMTS.getEnumerated(CollectionPeriodRRMUMTSEnum.class);
	}
	
	public void setCollectionPeriodRRMUMTS(CollectionPeriodRRMUMTSEnum value)
	{
		if(value == null)
			this.collectionPeriodRRMUMTS = null;
		else
			this.collectionPeriodRRMUMTS = new CollectionPeriodRRMUMTSImpl(value, null, null);
	}
	
	public Long getPositioningMethod()
	{
		if(positioningMethod == null)
			return null;
		
		return positioningMethod.getUnsigned();
	}
	
	public void setPositioningMethod(Long value)
	{
		if(value == null)
			this.positioningMethod = null;
		else
			this.positioningMethod = new PositioningMethodImpl(value, null, null);
	}
	
	public Long getMeasurementQuantity()
	{
		if(measurementQuantity == null)
			return null;
		
		return measurementQuantity.getUnsigned();
	}
	
	public void setMeasurementQuantity(Long value)
	{
		if(value == null)
			this.measurementQuantity = null;
		else
			this.measurementQuantity = new MeasurementQuantityImpl(value, null, null);
	}
	
	public Integer getEventThresholdEvent1F()
	{
		if(eventThresholdEvent1F == null)
			return null;
		
		return eventThresholdEvent1F.getInteger();
	}
	
	public void setEventThresholdEvent1F(Integer value)
	{
		if(value == null)
			this.eventThresholdEvent1F = null;
		else
			this.eventThresholdEvent1F = new EventThresholdEvent1FImpl(value, null, null);
	}
	
	public Integer getEventThresholdEvent1I()
	{
		if(eventThresholdEvent1I == null)
			return null;
		
		return eventThresholdEvent1I.getInteger();
	}
	
	public void setEventThresholdEvent1I(Integer value)
	{
		if(value == null)
			this.eventThresholdEvent1I = null;
		else
			this.eventThresholdEvent1I = new EventThresholdEvent1IImpl(value, null, null);
	}

	public List<ByteBuf> getMDTAllowedPLMNId()
	{
		if(mdtAllowedPLMNId == null || mdtAllowedPLMNId.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(MDTAllowedPLMNId curr:mdtAllowedPLMNId)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setMDTAllowedPLMNId(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.mdtAllowedPLMNId = null;
		else
		{
			this.mdtAllowedPLMNId = new ArrayList<MDTAllowedPLMNId>();
			for(ByteBuf curr:value)
				this.mdtAllowedPLMNId.add(new MDTAllowedPLMNIdImpl(curr, null, null));
		}
	}
	
	public List<MBSFNArea> getMBSFNArea()
	{
		return mbsfnArea;
	}
	
	public void setMBSFNArea(List<MBSFNArea> value)
	{
		this.mbsfnArea = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(jobType==null)
			return "Job-Type is required";
		
		return null;
	}	
}