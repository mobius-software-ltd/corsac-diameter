package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rx.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RequiredAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;

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
public class SessionTerminationRequestImpl extends RxRequestImpl implements SessionTerminationRequest
{
	private TerminationCause terminationCause;
	
	private List<RequiredAccessInfo> requiredAccessInfo;
	
	private List<DiameterClass> diameterClass;
	
	protected SessionTerminationRequestImpl() 
	{
		super();
	}
		
	public SessionTerminationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm, Boolean isRetransmit, String sessionID, Long authApplicationID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		
		setTerminationCause(terminationCause);
	}

	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(this.terminationCause == null)
			return null;
		
		return this.terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Termination-Cause is required is required", Arrays.asList(new DiameterAvp[] { new TerminationCauseImpl() }));
			
		this.terminationCause = new TerminationCauseImpl(value, null, null);
	}

	public List<RequiredAccessInfoEnum> getRequiredAccessInfo()
	{
		if(requiredAccessInfo==null || requiredAccessInfo.size()==0)
			return null;
		
		List<RequiredAccessInfoEnum> result = new ArrayList<RequiredAccessInfoEnum>();
		for(RequiredAccessInfo curr:requiredAccessInfo)
			result.add(curr.getEnumerated(RequiredAccessInfoEnum.class));
		
		return result;
	}

	public void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value)
	{
		if(value==null || value.size()==0)
			this.requiredAccessInfo = null;
		else
		{
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
			for(RequiredAccessInfoEnum curr:value)
				this.requiredAccessInfo.add(new RequiredAccessInfoImpl(curr, null, null));
		}
	}
	
	@Override
	public List<ByteBuf> getDiameterClass() 
	{
		if(this.diameterClass==null)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(DiameterClass currClass: this.diameterClass)
			result.add(currClass.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> value) 
	{
		if(value==null || value.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:value)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
	}		
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(terminationCause==null)
			return new MissingAvpException("Termination-Cause is required is required", Arrays.asList(new DiameterAvp[] { new TerminationCauseImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(authApplicationId);
		result.add(terminationCause);
		result.add(destinationHost);
		result.add(ocSupportedFeatures);
		
		if(requiredAccessInfo!=null)
			result.addAll(requiredAccessInfo);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}