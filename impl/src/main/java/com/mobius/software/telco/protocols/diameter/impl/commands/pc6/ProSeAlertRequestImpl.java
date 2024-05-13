package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAlertRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.AppLayerUserIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
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
public class ProSeAlertRequestImpl extends Pc6RequestImpl implements ProSeAlertRequest
{
	private AppLayerUserId appLayerUserId;
	
	private TargetedEPUID targetedEPUID;
	
	private AssistanceInfo assistanceInfo;
	
	protected ProSeAlertRequestImpl() 
	{
		super();
	}
	
	public ProSeAlertRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String appLayerUserId,String targetedEPUID) throws MissingAvpException, AvpNotSupportedException
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
	public void setAppLayerUserId(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("App-Layer-User-Id is required is required", Arrays.asList(new DiameterAvp[] { new AppLayerUserIdImpl() }));
		
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
	public void setTargetedEPUID(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Targeted-EPUID is required is required", Arrays.asList(new DiameterAvp[] { new TargetedEPUIDImpl() }));
		
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
	public DiameterException validate()
	{
		if(appLayerUserId == null)
			return new MissingAvpException("App-Layer-User-Id is required is required", Arrays.asList(new DiameterAvp[] { new AppLayerUserIdImpl() }));
		
		if(targetedEPUID == null)
			return new MissingAvpException("Targeted-EPUID is required is required", Arrays.asList(new DiameterAvp[] { new TargetedEPUIDImpl() }));
		
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
		result.add(appLayerUserId);
		result.add(targetedEPUID);
		result.add(assistanceInfo);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}