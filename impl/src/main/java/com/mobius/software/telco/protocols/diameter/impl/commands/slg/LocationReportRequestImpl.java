package com.mobius.software.telco.protocols.diameter.impl.commands.slg;

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.slg.LocationReportRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CellGlobalIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMEIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ServiceAreaIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AccuracyFulfilmentIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AgeOfLocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.BarometricPressureImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.CivicAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.ECGIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.EUTRANPositioningDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSQoSClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSServiceTypeIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LRRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LocationEventImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.OneXRTTRCIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PseudonymIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.ReportingAmountImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.VelocityEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.GMLCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMEI;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AgeOfLocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.slg.BarometricPressure;
import com.mobius.software.telco.protocols.diameter.primitives.slg.CivicAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredMTLRData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DelayedLocationReportingData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ECGI;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.EUTRANPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoSClass;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoSClassEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSServiceTypeID;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LocationEvent;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LocationEventEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.OneXRTTRCID;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PseudonymIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PseudonymIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingAmount;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VelocityEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.slh.GMLCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777255, commandCode = 8388621, request = true)
public class LocationReportRequestImpl extends SlgRequestImpl implements LocationReportRequest
{
	private LocationEvent locationEvent;
	 
	private LCSEPSClientName lcsEPSClientName;
	
	private MSISDN msisdn;
	
	private IMEI imei;
	 
	private LocationEstimate locationEstimate;
	
	private AccuracyFulfilmentIndicator accuracyFulfilmentIndicator;
	
	private AgeOfLocationEstimate ageOfLocationEstimate;
	
	private VelocityEstimate velocityEstimate;
	
	private EUTRANPositioningData eutranPositioningData;
	
	private ECGI ecgi;
	 
	private GERANPositioningInfo geranPositioningInfo;
	 
	private CellGlobalIdentity cellGlobalIdentity;
	 
	private UTRANPositioningInfo utranPositioningInfo;
	 
	private ServiceAreaIdentity serviceAreaIdentity;
	 
	private LCSServiceTypeID lcsServiceTypeID;
	
	private PseudonymIndicator pseudonymIndicator;
	
	private LCSQoSClass lcsQoSClass;
	
	private ServingNode servingNode;
	 
	private LRRFlags lrrFlags;
	
	private LCSReferenceNumber lcsReferenceNumber;
	
	private DeferredMTLRData deferredMTLRData;
	
	private GMLCAddress gmlcAddress;
	
	private ReportingAmount reportingAmount;
	
	private PeriodicLDRInfo periodicLDRInformation;
	
	private ESMLCCellInfo esmlcCellInfo;
	
	private OneXRTTRCID onexRTTRCID;
	
	private DelayedLocationReportingData delayedLocationReportingData;
	 
	private CivicAddress civicAddress;
	 
	private BarometricPressure barometricPressure;
	
	protected LocationReportRequestImpl() 
	{
		super();
	}
	
	public LocationReportRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,LocationEventEnum locationEvent)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setLocationEvent(locationEvent);
	}
	
	@Override
	public LocationEventEnum getLocationEvent()
	{
		if(locationEvent == null)
			return null;
		
		return locationEvent.getEnumerated(LocationEventEnum.class);
	}
	 
	@Override
	public void setLocationEvent(LocationEventEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Location-Event is required");
			
		this.locationEvent = new LocationEventImpl(value, null, null);
	}			
	 		
	@Override
	public LCSEPSClientName getLCSEPSClientName()
	{
		return this.lcsEPSClientName;
	}
	
	@Override
	public void setLCSEPSClientName(LCSEPSClientName value)
	{
		this.lcsEPSClientName = value;
	}
	
	@Override
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	@Override
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	@Override
	public String getIMEI()
	{
		if(imei == null)
			return null;
		
		return imei.getString();
	}
	 
	@Override
	public void setIMEI(String value)
	{
		if(value == null)
			this.imei = null;
		else
			this.imei = new IMEIImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getLocationEstimate()
	{
		if(locationEstimate == null)
			return null;
		
		return locationEstimate.getValue();
	}
	
	@Override
	public void setLocationEstimate(ByteBuf value)
	{
		if(value == null)
			this.locationEstimate = null;
		else
			this.locationEstimate = new LocationEstimateImpl(value, null, null);
	}			
	
	@Override
	public AccuracyFulfilmentIndicatorEnum getAccuracyFulfilmentIndicator()
	{
		if(accuracyFulfilmentIndicator == null)
			return null;
		
		return accuracyFulfilmentIndicator.getEnumerated(AccuracyFulfilmentIndicatorEnum.class);
	}
	
	@Override
	public void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicatorEnum value)
	{
		if(value == null)
			this.accuracyFulfilmentIndicator = null;
		else
			this.accuracyFulfilmentIndicator = new AccuracyFulfilmentIndicatorImpl(value, null, null);
	}			
	
	@Override
	public Long getAgeOfLocationEstimate()
	{
		if(ageOfLocationEstimate == null)
			return null;
		
		return ageOfLocationEstimate.getUnsigned();
	}
	
	@Override
	public void setAgeOfLocationEstimate(Long value)
	{
		if(value == null)
			this.ageOfLocationEstimate = null;
		else
			this.ageOfLocationEstimate = new AgeOfLocationEstimateImpl(value, null, null);
	}			
	
	@Override
	public ByteBuf getVelocityEstimate()
	{
		if(velocityEstimate == null)
			return null;
		
		return velocityEstimate.getValue();
	}
	
	@Override
	public void setVelocityEstimate(ByteBuf value)
	{
		if(value == null)
			this.velocityEstimate = null;
		else
			this.velocityEstimate = new VelocityEstimateImpl(value, null, null);
	}		
	
	@Override
	public ByteBuf getEUTRANPositioningData()
	{
		if(eutranPositioningData == null)
			return null;
		
		return eutranPositioningData.getValue();
	}
	
	@Override
	public void setEUTRANPositioningData(ByteBuf value)
	{
		if(value == null)
			this.eutranPositioningData = null;
		else
			this.eutranPositioningData = new EUTRANPositioningDataImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getECGI()
	{
		if(ecgi == null)
			return null;
		
		return ecgi.getValue();
	}
	 
	@Override
	public void setECGI(ByteBuf value)
	{
		if(value == null)
			this.ecgi = null;
		else
			this.ecgi = new ECGIImpl(value, null, null);
	}
		
	@Override
	public GERANPositioningInfo getGERANPositioningInfo()
	{
		return this.geranPositioningInfo;
	}
	 
	@Override
	public void setGERANPositioningInfo(GERANPositioningInfo value)
	{
		this.geranPositioningInfo = value;
	}
	
	@Override
	public ByteBuf getCellGlobalIdentity()
	{
		if(cellGlobalIdentity == null)
			return null;
		
		return cellGlobalIdentity.getValue();
	}
	 
	@Override
	public void setCellGlobalIdentity(ByteBuf value)
	{
		if(value == null)
			this.cellGlobalIdentity = null;
		else
			this.cellGlobalIdentity = new CellGlobalIdentityImpl(value, null, null);
	}
	
	@Override
	public UTRANPositioningInfo getUTRANPositioningInfo()
	{
		return this.utranPositioningInfo;
	}
	 
	@Override
	public void setUTRANPositioningInfo(UTRANPositioningInfo value)
	{
		this.utranPositioningInfo = value;
	}
	
	@Override
	public ByteBuf getServiceAreaIdentity()
	{
		if(serviceAreaIdentity == null)
			return null;
		
		return serviceAreaIdentity.getValue();
	}
	 
	@Override
	public void setServiceAreaIdentity(ByteBuf value)
	{
		if(value == null)
			this.serviceAreaIdentity = null;
		else
			this.serviceAreaIdentity = new ServiceAreaIdentityImpl(value, null, null);
	}
	
	@Override
	public Long getLCSServiceTypeID()
	{
		if(lcsServiceTypeID == null)
			return null;
		
		return lcsServiceTypeID.getUnsigned();
	}
	
	@Override
	public void setLCSServiceTypeID(Long value)
	{
		if(value == null)
			this.lcsServiceTypeID = null;
		else
			this.lcsServiceTypeID = new LCSServiceTypeIDImpl(value, null, null);
	}		
	
	@Override
	public PseudonymIndicatorEnum getPseudonymIndicator()
	{
		if(pseudonymIndicator == null)
			return null;
		
		return pseudonymIndicator.getEnumerated(PseudonymIndicatorEnum.class);
	}
	
	@Override
	public void setPseudonymIndicator(PseudonymIndicatorEnum value)
	{
		if(value == null)
			this.pseudonymIndicator = null;
		else
			this.pseudonymIndicator = new PseudonymIndicatorImpl(value, null, null);
	}		
	
	@Override
	public LCSQoSClassEnum getLCSQoSClass()
	{
		if(lcsQoSClass == null)
			return null;
		
		return lcsQoSClass.getEnumerated(LCSQoSClassEnum.class);
	}
	
	@Override
	public void setLCSQoSClass(LCSQoSClassEnum value)
	{
		if(value == null)
			this.lcsQoSClass = null;
		else
			this.lcsQoSClass = new LCSQoSClassImpl(value, null, null);
	}	
	
	@Override
	public ServingNode getServingNode()
	{
		return this.servingNode;
	}
	 
	@Override
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;
	}
	
	@Override
	public Long getLRRFlags()
	{
		if(lrrFlags == null)
			return null;
		
		return lrrFlags.getUnsigned();
	}
	
	@Override
	public void setLRRFlags(Long value)
	{
		if(value == null)
			this.lrrFlags = null;
		else
			this.lrrFlags = new LRRFlagsImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getLCSReferenceNumber()
	{
		if(lcsReferenceNumber == null)
			return null;
		
		return lcsReferenceNumber.getValue();
	}
	
	@Override
	public void setLCSReferenceNumber(ByteBuf value)
	{
		if(value == null)
			this.lcsReferenceNumber = null;
		else
			this.lcsReferenceNumber = new LCSReferenceNumberImpl(value, null, null);
	}
	
	@Override
	public DeferredMTLRData getDeferredMTLRData()
	{
		return this.deferredMTLRData;
	}
	
	@Override
	public void setDeferredMTLRData(DeferredMTLRData value)
	{
		this.deferredMTLRData = value;
	}
	
	@Override
	public InetAddress getGMLCAddress()
	{
		if(gmlcAddress == null)
			return null;
		
		return gmlcAddress.getAddress();
	}
	
	@Override
	public void setGMLCAddress(InetAddress value)
	{
		if(value == null)
			this.gmlcAddress = null;
		else
			this.gmlcAddress = new GMLCAddressImpl(value, null, null);
	}
	
	@Override
	public Long getReportingAmount()
	{
		if(reportingAmount == null)
			return null;
		
		return reportingAmount.getUnsigned();
	}
	
	@Override
	public void setReportingAmount(Long value)
	{
		if(value == null)
			this.reportingAmount = null;
		else
			this.reportingAmount = new ReportingAmountImpl(value, null, null);
	}
	
	@Override
	public PeriodicLDRInfo getPeriodicLDRInformation()
	{
		return this.periodicLDRInformation;
	}
	
	@Override
	public void setPeriodicLDRInformation(PeriodicLDRInfo value)
	{
		this.periodicLDRInformation = value;
	}
	
	@Override
	public ESMLCCellInfo getESMLCCellInfo()
	{
		return this.esmlcCellInfo;
	}
	
	@Override
	public void setESMLCCellInfo(ESMLCCellInfo value)
	{
		this.esmlcCellInfo = value;
	}
	
	@Override
	public ByteBuf getOnexRTTRCID()
	{
		if(onexRTTRCID == null)
			return null;
		
		return onexRTTRCID.getValue();
	}
	
	@Override
	public void setOnexRTTRCID(ByteBuf value)
	{
		if(value == null)
			this.onexRTTRCID = null;
		else
			this.onexRTTRCID = new OneXRTTRCIDImpl(value, null, null);
	}
	
	@Override
	public DelayedLocationReportingData getDelayedLocationReportingData()
	{
		return this.delayedLocationReportingData;
	}
	 
	@Override
	public void setDelayedLocationReportingData(DelayedLocationReportingData value)
	{
		this.delayedLocationReportingData = value;
	}
	
	@Override
	public String getCivicAddress()
	{
		if(civicAddress == null)
			return null;
		
		return civicAddress.getString();
	}
	 
	@Override
	public void setCivicAddress(String value)
	{
		if(value == null)
			this.civicAddress = null;
		else
			this.civicAddress = new CivicAddressImpl(value, null, null);
	}
	
	@Override
	public Long getBarometricPressure()
	{
		if(barometricPressure == null)
			return null;
		
		return barometricPressure.getUnsigned();
	}
	 
	@Override
	public void setBarometricPressure(Long value)
	{
		if(value == null)
			this.barometricPressure = null;
		else
			this.barometricPressure = new BarometricPressureImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(locationEvent == null)
			return "Location-Event is required";
		
		return super.validate();
	}	
}