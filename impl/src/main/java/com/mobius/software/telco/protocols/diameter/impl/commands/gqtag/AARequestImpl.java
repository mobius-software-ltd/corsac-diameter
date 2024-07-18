package com.mobius.software.telco.protocols.diameter.impl.commands.gqtag;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AARequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.AuthorizationPackageIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.LatchingIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.OverbookingIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ReservationPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ServiceClassImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.AuthorizationPackageId;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.LatchingIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gq.LatchingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.OverbookingIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gq.OverbookingIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ServiceClass;

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
public class AARequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.gq.AARequestImpl implements AARequest
{
	protected BindingInformation bindingInformation;
	
	protected LatchingIndication latchingIndication;
	
	protected ReservationPriority reservationPriority;
	
	protected GloballyUniqueAddress globallyUniqueAddress;
	
	protected ServiceClass serviceClass;
	
	protected AuthorizationLifetime authorizationLifetime;
	
	protected OverbookingIndicator overbookingIndicator;
	
	protected List<AuthorizationPackageId> authorizationPackageId;
	
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
	}

	@Override
	public BindingInformation getBindingInformation()
	{
		return this.bindingInformation;
	}
	
	@Override
	public void setBindingInformation(BindingInformation value)
	{
		this.bindingInformation = value;
	}
	
	@Override
	public LatchingIndicationEnum getLatchingIndication()
	{
		if(latchingIndication==null)
			return null;
		
		return latchingIndication.getEnumerated(LatchingIndicationEnum.class);
	}
	
	@Override
	public void setLatchingIndication(LatchingIndicationEnum value)
	{
		if(value==null)
			this.latchingIndication = null;
		else
			this.latchingIndication = new LatchingIndicationImpl(value, null, null); 	
	}
	
	@Override
	public ReservationPriorityEnum getReservationPriority()
	{
		if(reservationPriority==null)
			return null;
		
		return reservationPriority.getEnumerated(ReservationPriorityEnum.class);
	}
	
	@Override
	public void setReservationPriority(ReservationPriorityEnum value)
	{
		if(value==null)
			this.reservationPriority = null;
		else
			this.reservationPriority = new ReservationPriorityImpl(value, null, null); 			
	}
	
	@Override
	public GloballyUniqueAddress getGloballyUniqueAddress()
	{
		return this.globallyUniqueAddress;
	}
	
	@Override
	public void setGloballyUniqueAddress(GloballyUniqueAddress value)
	{
		this.globallyUniqueAddress = value;
	}
	
	@Override
	public String getServiceClass()
	{
		if(serviceClass==null)
			return null;
		
		return serviceClass.getString();
	}
	
	@Override
	public void setServiceClass(String value)
	{
		if(value==null)
			this.serviceClass = null;
		else
			this.serviceClass = new ServiceClassImpl(value, null, null);
	}

	@Override
	public Long getAuthorizationLifetime() 
	{
		if(authorizationLifetime == null)
			return null;
		
		return authorizationLifetime.getUnsigned();
	}

	@Override
	public void setAuthorizationLifetime(Long value) 
	{
		if(value == null)
			this.authorizationLifetime = null;
		else
			this.authorizationLifetime = new AuthorizationLifetimeImpl(value, null, null);
	}
	
	@Override
	public OverbookingIndicatorEnum getOverbookingIndicator()
	{
		if(overbookingIndicator==null)
			return null;
		
		return overbookingIndicator.getEnumerated(OverbookingIndicatorEnum.class);
	}
	
	@Override
	public void setOverbookingIndicator(OverbookingIndicatorEnum value)
	{
		if(value==null)
			this.overbookingIndicator = null;
		else
			this.overbookingIndicator = new OverbookingIndicatorImpl(value, null, null);
	}
	
	@Override
	public List<String> getAuthorizationPackageId()
	{
		if(authorizationPackageId==null || authorizationPackageId.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(AuthorizationPackageId curr:authorizationPackageId)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setAuthorizationPackageId(List<String> value)
	{
		if(value==null || value.size()==0)
			this.authorizationPackageId = null;
		else
		{
			this.authorizationPackageId = new ArrayList<AuthorizationPackageId>();
			for(String curr:value)
				this.authorizationPackageId.add(new AuthorizationPackageIdImpl(curr, null, null));
		}
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(destinationRealm);
      	result.add(destinationHost);
      	
      	if(mediaComponentDescription!=null)
      		result.addAll(mediaComponentDescription);
      		
      	if(flowGrouping!=null)
      		result.addAll(flowGrouping);
      		
      	result.add(afChargingIdentifier);
      	result.add(sipForkingIndication);
      	
      	if(specificAction!=null)
      		result.addAll(specificAction);
      		
      	result.add(username);
      	result.add(bindingInformation);
      	result.add(latchingIndication);
      	result.add(reservationPriority);
      	result.add(globallyUniqueAddress);
      	result.add(serviceClass);
      	result.add(authorizationLifetime);
      	
      	if(proxyInfo!=null)
      		result.addAll(proxyInfo);
      		
      	if(routeRecords!=null)
      		result.addAll(routeRecords);
      		
      	result.add(overbookingIndicator);
      	
      	if(authorizationPackageId!=null)
      		result.addAll(authorizationPackageId);
      		
      	if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
      	
      	return result;
	}
}