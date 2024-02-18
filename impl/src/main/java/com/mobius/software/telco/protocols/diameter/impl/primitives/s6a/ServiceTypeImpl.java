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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GMLCRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GMLCRestrictionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NotificationToUEUser;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NotificationToUEUserEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceTypeIdentity;

/**
*
* @author yulian oifa
*
*/
public class ServiceTypeImpl extends DiameterGroupedAvpImpl implements ServiceType
{
	private ServiceTypeIdentity serviceTypeIdentity;
	
	private GMLCRestriction gmlcRestriction;
	
	private NotificationToUEUser notificationToUEUser;
	
	protected ServiceTypeImpl()
	{
		
	}
	
	public ServiceTypeImpl(Long serviceTypeIdentity) throws MissingAvpException
	{
		setServiceTypeIdentity(serviceTypeIdentity);
	}
	
	public Long getServiceTypeIdentity()
	{
		if(serviceTypeIdentity==null)
			return null;
		
		return serviceTypeIdentity.getUnsigned();
	}
	
	public void setServiceTypeIdentity(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Type-Identity is required is required", Arrays.asList(new DiameterAvp[] { new ServiceTypeIdentityImpl() }));
			
		this.serviceTypeIdentity = new ServiceTypeIdentityImpl(value, null, null);	
	}	
	
	public GMLCRestrictionEnum getGMLCRestriction()
	{
		if(gmlcRestriction==null)
			return null;
		
		return gmlcRestriction.getEnumerated(GMLCRestrictionEnum.class);
	}
	
	public void setGMLCRestriction(GMLCRestrictionEnum value)
	{
		if(value==null)
			this.gmlcRestriction = null;
		else
			this.gmlcRestriction = new GMLCRestrictionImpl(value, null, null);			
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(serviceTypeIdentity==null)
			return new MissingAvpException("Service-Type-Identity is required is required", Arrays.asList(new DiameterAvp[] { new ServiceTypeIdentityImpl() }));
		
		return null;
	}
}