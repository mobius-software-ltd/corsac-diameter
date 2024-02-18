package com.mobius.software.telco.protocols.diameter.impl.commands.gqtag;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AAAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthGracePeriodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthorizationLifetimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ReservationPriorityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthGracePeriod;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthorizationLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;

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
public class AAAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements AAAnswer
{
	protected BindingInformation bindingInformation;
	
	protected ReservationPriority reservationPriority;
	
	protected AuthorizationLifetime authorizationLifetime;
	
	protected AuthGracePeriod authGracePeriod;
	
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
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
	public Long getAuthGracePeriod() 
	{
		if(authGracePeriod == null)
			return null;
		
		return authGracePeriod.getUnsigned();
	}

	@Override
	public void setAuthGracePeriod(Long value) 
	{
		if(value == null)
			this.authGracePeriod = null;
		else
			this.authGracePeriod = new AuthGracePeriodImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(bindingInformation);
		result.add(reservationPriority);
		result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(authorizationLifetime);
        result.add(authGracePeriod);
		result.add(failedAvp);
        
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
        
		return result;
	}
}