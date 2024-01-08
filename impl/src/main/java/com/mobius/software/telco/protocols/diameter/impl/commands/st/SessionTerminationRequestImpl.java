package com.mobius.software.telco.protocols.diameter.impl.commands.st;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
@DiameterCommandImplementation(applicationId = 16777349, commandCode = 275, request = true)
public class SessionTerminationRequestImpl extends AuthenticationRequestWithHostBase implements SessionTerminationRequest
{
	private DRMP drmp;
	
	protected List<DiameterClass> diameterClass;
	
	private TerminationCause terminationCause;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected SessionTerminationRequestImpl() 
	{
		super();
	}
	
	public SessionTerminationRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm, Boolean isRetransmit, String sessionID, Long authApplicationId, TerminationCauseEnum terminationCause)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setTerminationCause(terminationCause);
	}	

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
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
	
	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(this.terminationCause == null)
			return null;
		
		return this.terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Termination-Cause is required");
		
		this.terminationCause = new TerminationCauseImpl(value, null, null);
	}	
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(terminationCause==null)
			return "Termination-Cause is required";
		
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
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
	
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}