package com.mobius.software.telco.protocols.diameter.impl.commands.slg;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.slg.ProvideLocationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CellGlobalIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ServiceAreaIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AccuracyFulfilmentIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.AgeOfLocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.BarometricPressureImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.CivicAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.ECGIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.EUTRANPositioningDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.PLAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.VelocityEstimateImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AgeOfLocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.slg.BarometricPressure;
import com.mobius.software.telco.protocols.diameter.primitives.slg.CivicAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ECGI;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.EUTRANPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VelocityEstimate;
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
@DiameterCommandImplementation(applicationId = 16777255, commandCode = 8388620, request = false)
public class ProvideLocationAnswerImpl extends SlgAnswerImpl implements ProvideLocationAnswer
{
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
	 
	private ServingNode servingNode;
	 
	private PLAFlags plaFlags;
	 
	private ESMLCCellInfo esmlcCellInfo;
	 
	private CivicAddress civicAddress;
	 
	private BarometricPressure barometricPressure;
	
	protected ProvideLocationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ProvideLocationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	public Long getPLAFlags()
	{
		if(plaFlags == null)
			return null;
		
		return plaFlags.getUnsigned();
	}
	 
	@Override
	public void setPLAFlags(Long value)
	{
		if(value == null)
			this.plaFlags = null;
		else
			this.plaFlags = new PLAFlagsImpl(value, null, null);
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
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(locationEstimate);
		result.add(accuracyFulfilmentIndicator);
		result.add(ageOfLocationEstimate);
		result.add(velocityEstimate);
		result.add(eutranPositioningData);
		result.add(ecgi);
		result.add(geranPositioningInfo);
		result.add(cellGlobalIdentity);
		result.add(utranPositioningInfo);
		result.add(serviceAreaIdentity);
		result.add(servingNode);
		result.add(plaFlags);
		result.add(esmlcCellInfo);
		result.add(civicAddress);
		result.add(barometricPressure);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}