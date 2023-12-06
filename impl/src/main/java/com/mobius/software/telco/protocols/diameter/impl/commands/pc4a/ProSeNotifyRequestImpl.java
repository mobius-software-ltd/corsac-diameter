package com.mobius.software.telco.protocols.diameter.impl.commands.pc4a;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeNotifyRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.PNRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSePermissionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.PNRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

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
@DiameterCommandImplementation(applicationId = 16777336, commandCode = 8388666, request = true)
public class ProSeNotifyRequestImpl extends Pc4aRequestImpl implements ProSeNotifyRequest
{
	private ProSePermission proSePermission;
	
	private VisitedPLMNId visitedPLMNId;
	
	private PNRFlags pnrFlags;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected ProSeNotifyRequestImpl() 
	{
		super();
	}
	
	public ProSeNotifyRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override
	public Long getProSePermission()
	{
		if(proSePermission == null)
			return null;
		
		return proSePermission.getUnsigned();
	}
	
	@Override
	public void setProSePermission(Long value)
	{
		if(value == null)
			this.proSePermission = null;
		else
			this.proSePermission = new ProSePermissionImpl(value, null, null);	
	}
	
	@Override	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	@Override	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value == null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);	
	}
	
	@Override
	public Long getPNRFlags()
	{
		if(pnrFlags == null)
			return null;
		
		return pnrFlags.getUnsigned();
	}
	
	@Override
	public void setPNRFlags(Long value)
	{
		if(value == null)
			this.pnrFlags = null;
		else
			this.pnrFlags = new PNRFlagsImpl(value, null, null);	
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
}