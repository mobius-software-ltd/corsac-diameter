package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAlertRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.AppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AppLayerUserId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AssistanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetedEPUID;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388674, request = true)
public class ProSeAlertRequestImpl extends Pc6RequestImpl implements ProSeAlertRequest
{
	private AppLayerUserId appLayerUserId;
	
	private TargetedEPUID targetedEPUID;
	
	private AssistanceInfo assistanceInfo;
	
	protected ProSeAlertRequestImpl() 
	{
		super();
	}
	
	public ProSeAlertRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String appLayerUserId,String targetedEPUID)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setAppLayerUserId(appLayerUserId);
		
		setTargetedEPUID(targetedEPUID);
	}
	
	@Override	
	public String getAppLayerUserId()
	{
		if(appLayerUserId == null)
			return null;
		
		return appLayerUserId.getString();
	}
	 
	@Override	
	public void setAppLayerUserId(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("App-Layer-User-Id is required");
		
		this.appLayerUserId = new AppLayerUserIdImpl(value, null, null);
	}
	
	@Override	
	public String getTargetedEPUID()
	{
		if(targetedEPUID == null)
			return null;
		
		return targetedEPUID.getString();
	}
	
	@Override	
	public void setTargetedEPUID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Targeted-EPUID is required");
		
		this.targetedEPUID = new TargetedEPUIDImpl(value, null, null);
	}
		
	@Override	
	public AssistanceInfo getAssistanceInfo()
	{
		return this.assistanceInfo;
	}
	
	@Override	
	public void setAssistanceInfo(AssistanceInfo value)
	{
		this.assistanceInfo = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(appLayerUserId == null)
			return "App-Layer-User-Id is required";
		
		if(targetedEPUID == null)
			return "Targeted-EPUID is required";
		
		return super.validate();
	}	
}