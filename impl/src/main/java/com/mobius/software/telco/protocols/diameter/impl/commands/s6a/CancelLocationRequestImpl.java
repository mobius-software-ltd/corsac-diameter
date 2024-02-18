package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6a.CancelLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CancellationTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CLRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationTypeEnum;

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
public class CancelLocationRequestImpl extends S6aRequestImpl implements CancelLocationRequest
{
	private CancellationType cancellationType;
	
	private CLRFlags clrFlags;
	
	protected CancelLocationRequestImpl() 
	{
		super();
	}
	
	public CancelLocationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,CancellationTypeEnum cancellationType) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setCancellationType(cancellationType);
	}
	
	@Override
	public CancellationTypeEnum getCancellationType()
	{
		if(cancellationType == null)
			return null;
		
		return cancellationType.getEnumerated(CancellationTypeEnum.class);
	}
	
	@Override
	public void setCancellationType(CancellationTypeEnum value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Cancellation-Type is required", Arrays.asList(new DiameterAvp[] { new CancellationTypeImpl() }));
		
		this.cancellationType = new CancellationTypeImpl(value, null, null);
	}
	
	@Override
	public CLRFlags getCLRFlags()
	{
		return clrFlags;
	}
	
	@Override
	public void setCLRFlags(CLRFlags value)
	{
		this.clrFlags = value;
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(cancellationType == null)
			return new MissingAvpException("Cancellation-Type is required", Arrays.asList(new DiameterAvp[] { new CancellationTypeImpl() }));
		
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
		result.add(username);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(cancellationType);
		result.add(clrFlags);
		
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