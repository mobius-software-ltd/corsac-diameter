package com.mobius.software.telco.protocols.diameter.impl.commands.pc2;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.AllowedSuffixesNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ApplicationDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.OriginAppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ProSeFunctionIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.TargetAppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeAppIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.RequestingEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetRPAUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.AllowedSuffixesNumber;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ApplicationData;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.OriginAppLayerUserId;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeFunctionID;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.TargetAppLayerUserId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.RequestingEPUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetRPAUID;

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
@DiameterCommandImplementation(applicationId = 16777350, commandCode = 8388676, request = true)
public class ProXimityActionRequestImpl extends Pc2RequestImpl implements ProXimityActionRequest
{
	private OriginAppLayerUserId originAppLayerUserId;
	
	private TargetAppLayerUserId targetAppLayerUserId;
	
	private RequestingEPUID requestingEPUID;
	
	private ProSeFunctionID proSeFunctionID;
	
	private ProSeAppId proSeAppId;
	
	private ApplicationData applicationData;
	
	private AllowedSuffixesNumber allowedSuffixNumber;
	
	private TargetRPAUID targetRPAUID;
	
	protected ProXimityActionRequestImpl() 
	{
		super();
	}
	
	public ProXimityActionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,Long authApplicationId, ProSeRequestTypeEnum proSeRequestType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, proSeRequestType);
	}
	
	@Override
	public String getOriginAppLayerUserId()
	{
		if(originAppLayerUserId == null)
			return null;
		
		return originAppLayerUserId.getString();
	}
	
	@Override
	public void setOriginAppLayerUserId(String value)
	{
		if(value == null)
			this.originAppLayerUserId = null;
		else
			this.originAppLayerUserId = new OriginAppLayerUserIdImpl(value, null, null);
	}
	
	@Override
	public String getTargetAppLayerUserId()
	{
		if(targetAppLayerUserId == null)
			return null;
		
		return targetAppLayerUserId.getString();
	}
	
	@Override
	public void setTargetAppLayerUserId(String value)
	{
		if(value == null)
			this.targetAppLayerUserId = null;
		else
			this.targetAppLayerUserId = new TargetAppLayerUserIdImpl(value, null, null);
	}
	      
	@Override
	public String getRequestingEPUID()
	{
		if(requestingEPUID == null)
			return null;
		
		return requestingEPUID.getString();
	}
	
	@Override
	public void setRequestingEPUID(String value)
	{
		if(value == null)
			this.requestingEPUID = null;
		else
			this.requestingEPUID = new RequestingEPUIDImpl(value, null, null);
	}
	      
	@Override
	public ByteBuf getProSeFunctionID()
	{
		if(proSeFunctionID == null)
			return null;
		
		return proSeFunctionID.getValue();
	}
	
	@Override
	public void setProSeFunctionID(ByteBuf value)
	{
		if(value == null)
			this.proSeFunctionID = null;
		else
			this.proSeFunctionID = new ProSeFunctionIDImpl(value, null, null);
	}
	
	@Override
	public String getProSeAppId()
	{
		if(proSeAppId == null)
			return null;
		
		return proSeAppId.getString();
	}
	
	@Override
	public void setProSeAppId(String value)
	{
		if(value == null)
			this.proSeAppId = null;
		else
			this.proSeAppId = new ProSeAppIdImpl(value, null, null);
	}
	
	@Override
	public String getApplicationData()
	{
		if(applicationData == null)
			return null;
		
		return applicationData.getString();
	}
	
	@Override
	public void setApplicationData(String value)
	{
		if(value == null)
			this.applicationData = null;
		else
			this.applicationData = new ApplicationDataImpl(value, null, null);
	}
	
	@Override
	public Long getAllowedSuffixNumber()
	{
		if(allowedSuffixNumber == null)
			return null;
		
		return allowedSuffixNumber.getUnsigned();
	}
	
	@Override
	public void setAllowedSuffixNumber(Long value)
	{
		if(value == null)
			this.allowedSuffixNumber = null;
		else
			this.allowedSuffixNumber = new AllowedSuffixesNumberImpl(value, null, null);
	}
	
	@Override
	public String getTargetRPAUID()
	{
		if(targetRPAUID == null)
			return null;
		
		return targetRPAUID.getString();
	}
	
	@Override
	public void setTargetRPAUID(String value)
	{
		if(value == null)
			this.targetRPAUID = null;
		else
			this.targetRPAUID = new TargetRPAUIDImpl(value, null, null);
	}
}