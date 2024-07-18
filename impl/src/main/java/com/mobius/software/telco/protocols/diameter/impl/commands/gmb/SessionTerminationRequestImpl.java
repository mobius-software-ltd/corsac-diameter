package com.mobius.software.telco.protocols.diameter.impl.commands.gmb;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gmb.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.AdditionalMBMSTraceInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.AdditionalMBMSTraceInfo;

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
public class SessionTerminationRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.SessionTerminationRequestImpl implements SessionTerminationRequest
{
	private AdditionalMBMSTraceInfo additionalMBMSTraceInfo;
	   
	protected SessionTerminationRequestImpl() 
	{
		super();
	}
		
	public SessionTerminationRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, terminationCause);
	}
	
	@Override
	public ByteBuf getAdditionalMBMSTraceInfo() 
	{
		if(additionalMBMSTraceInfo == null)
			return null;
		
		return additionalMBMSTraceInfo.getValue();
	}

	@Override
	public void setAdditionalMBMSTraceInfo(ByteBuf value) 
	{
		if(value == null)
			this.additionalMBMSTraceInfo = null;
		else
			this.additionalMBMSTraceInfo = new AdditionalMBMSTraceInfoImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(authApplicationId);
		result.add(terminationCause);
		result.add(destinationHost);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(additionalMBMSTraceInfo);		
		
		return result;
	}
}