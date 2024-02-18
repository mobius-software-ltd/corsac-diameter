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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ImmediateResponsePreferred;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NumberOfRequestedVectors;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ReSynchronizationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedEUTRANAuthenticationInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RequestedEUTRANAuthenticationInfoImpl extends DiameterGroupedAvpImpl implements RequestedEUTRANAuthenticationInfo
{
	private NumberOfRequestedVectors numberOfRequestedVectors;
	
	private ImmediateResponsePreferred immediateResponsePreferred;
	
	private ReSynchronizationInfo reSynchronizationInfo;
	
	public RequestedEUTRANAuthenticationInfoImpl()
	{
		
	}
	
	public Long getNumberOfRequestedVectors()
	{
		if(numberOfRequestedVectors == null)
			return null;
		
		return numberOfRequestedVectors.getUnsigned();
	}
	
	public void setNumberOfRequestedVectors(Long value)
	{
		if(value==null)
			this.numberOfRequestedVectors = null;
		else
			this.numberOfRequestedVectors = new NumberOfRequestedVectorsImpl(value, null, null);			
	}
	
	public Long getImmediateResponsePreferred()
	{
		if(immediateResponsePreferred == null)
			return null;
		
		return immediateResponsePreferred.getUnsigned();
	}
	
	public void setImmediateResponsePreferred(Long value)
	{
		if(value==null)
			this.immediateResponsePreferred = null;
		else
			this.immediateResponsePreferred = new ImmediateResponsePreferredImpl(value, null, null);			
	}
	
	public ByteBuf getReSynchronizationInfo()
	{
		if(reSynchronizationInfo == null)
			return null;
		
		return reSynchronizationInfo.getValue();
	}
	
	public void setReSynchronizationInfo(ByteBuf value)
	{
		if(value==null)
			this.reSynchronizationInfo = null;
		else
			this.reSynchronizationInfo = new ReSynchronizationInfoImpl(value, null, null);			
	}
}