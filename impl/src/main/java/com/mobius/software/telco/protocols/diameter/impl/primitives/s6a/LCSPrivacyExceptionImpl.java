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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExternalClient;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LCSPrivacyException;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NotificationToUEUser;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NotificationToUEUserEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PLMNClient;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PLMNClientEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceType;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class LCSPrivacyExceptionImpl extends DiameterGroupedAvpImpl implements LCSPrivacyException
{
	private SSCode ssCode;
	
	private SSStatus ssStatus;
	
	private NotificationToUEUser notificationToUEUser;
	
	private List<ExternalClient> externalClient;
	
	private List<PLMNClient> plmnClient;
	
	private List<ServiceType> serviceType;
	
	protected LCSPrivacyExceptionImpl()
	{
		
	}
	
	public LCSPrivacyExceptionImpl(ByteBuf ssCode,ByteBuf ssStatus) throws MissingAvpException
	{
		setSSCode(ssCode);
		
		setSSStatus(ssStatus);
	}
	
	public ByteBuf getSSCode()
	{
		if(ssCode==null)
			return null;
		
		return ssCode.getValue();
	}
	
	public void setSSCode(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SS-Code is required", Arrays.asList(new DiameterAvp[] { new SSCodeImpl() }));
			
		this.ssCode = new SSCodeImpl(value, null, null);	
	}
	
	public ByteBuf getSSStatus()
	{
		if(ssStatus==null)
			return null;
		
		return ssStatus.getValue();
	}
	
	public void setSSStatus(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SS-Status is required", Arrays.asList(new DiameterAvp[] { new SSStatusImpl() }));
			
		this.ssStatus = new SSStatusImpl(value, null, null);
	}
	
	public NotificationToUEUserEnum getNotificationToUEUser()
	{
		if(notificationToUEUser==null)
			return null;
		
		return notificationToUEUser.getEnumerated(NotificationToUEUserEnum.class);
	}
	
	public void setNotificationToUEUser(NotificationToUEUserEnum value)
	{
		if(value==null)
			this.notificationToUEUser = null;
		else
			this.notificationToUEUser = new NotificationToUEUserImpl(value, null, null);
	}
	
	public List<ExternalClient> getExternalClient()
	{
		return this.externalClient;
	}
	
	public void setExternalClient(List<ExternalClient> value)
	{
		this.externalClient = value;
	}
	
	public List<PLMNClientEnum> getPLMNClient()
	{
		if(plmnClient==null || plmnClient.size()==0)
			return null;
		
		List<PLMNClientEnum> result=new ArrayList<PLMNClientEnum>();
		for(PLMNClient curr:plmnClient)
			result.add(curr.getEnumerated(PLMNClientEnum.class));
			
		return result;
	}
	
	public void setPLMNClient(List<PLMNClientEnum> value)
	{
		if(value==null || value.size()==0)
			this.plmnClient=null;
		else
		{
			this.plmnClient = new ArrayList<PLMNClient>();
			for(PLMNClientEnum curr:value)
				this.plmnClient.add(new PLMNClientImpl(curr, null, null));
		}
	}
	
	public List<ServiceType> getServiceType()
	{
		return serviceType;
	}
	
	public void setServiceType(List<ServiceType> value)
	{
		this.serviceType = value; 
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ssCode==null)
			return new MissingAvpException("SS-Code is required", Arrays.asList(new DiameterAvp[] { new SSCodeImpl() }));
		
		if(ssStatus==null)
			return new MissingAvpException("SS-Status is required", Arrays.asList(new DiameterAvp[] { new SSStatusImpl() }));
		
		return null;
	}
}