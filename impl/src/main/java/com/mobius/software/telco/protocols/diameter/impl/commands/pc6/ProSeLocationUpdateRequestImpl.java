package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeLocationUpdateRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetedEPUID;

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
public class ProSeLocationUpdateRequestImpl extends Pc6RequestImpl implements ProSeLocationUpdateRequest
{
	private TargetedEPUID targetedEPUID;
	
	private LocationEstimate locationEstimate;
	
	protected ProSeLocationUpdateRequestImpl() 
	{
		super();
	}
	
	public ProSeLocationUpdateRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String targetedEPUID,ByteBuf locationEstimate) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setLocationEstimate(locationEstimate);
		
		setTargetedEPUID(targetedEPUID);
	}
	
	@Override	
	public String getTargetedEPUID()
	{
		if(targetedEPUID == null)
			return null;
		
		return targetedEPUID.getString();
	}
	
	@Override	
	public void setTargetedEPUID(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Targeted-EPUID is required is required", Arrays.asList(new DiameterAvp[] { new TargetedEPUIDImpl() }));
		
		this.targetedEPUID = new TargetedEPUIDImpl(value, null, null);
	}
	
	@Override	
	public ByteBuf getLocationEstimate()
	{
		if(locationEstimate == null)
			return null;
		
		return locationEstimate.getValue();
	}
	 
	@Override	
	public void setLocationEstimate(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Location-Estimate is required is required", Arrays.asList(new DiameterAvp[] { new LocationEstimateImpl() }));
			
		this.locationEstimate = new LocationEstimateImpl(value, null, null);
	}
		
	@DiameterValidate
	public DiameterException validate()
	{
		if(targetedEPUID == null)
			return new MissingAvpException("Targeted-EPUID is required is required", Arrays.asList(new DiameterAvp[] { new TargetedEPUIDImpl() }));
		
		if(locationEstimate == null)
			return new MissingAvpException("Location-Estimate is required is required", Arrays.asList(new DiameterAvp[] { new LocationEstimateImpl() }));
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ocSupportedFeatures);
		result.add(targetedEPUID);
		result.add(locationEstimate);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}	
}