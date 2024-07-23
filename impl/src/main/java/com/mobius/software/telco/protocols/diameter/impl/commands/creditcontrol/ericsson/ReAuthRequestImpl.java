package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.ericsson;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GSUPoolIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;

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
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestImpl implements ReAuthRequest
{
	private GSUPoolIdentifier gsuPoolIdentifier;
	
	private ServiceIdentifier serviceIdentifier;
	
	private RatingGroup ratingGroup;
	
	protected ReAuthRequestImpl() 
	{
		super();
		setDestinationHostRequired(true);
	
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);
		
		setDestinationHostRequired(true);
		setDestinationHost(destinationHost);
	}

	@Override
	public Long getGSUPoolIdentifier()
	{
		if(gsuPoolIdentifier==null)
			return null;
		
		return gsuPoolIdentifier.getUnsigned();
	}
	
	@Override
	public void setGSUPoolIdentifier(Long value)
	{
		if(value==null)
			this.gsuPoolIdentifier = null;
		else
			this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(value, null, null);
	}
	
	@Override
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	@Override
	public void setServiceIdentifier(Long value)
	{
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);
	}

	@Override
	public Long getRatingGroup()
	{
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	@Override
	public void setRatingGroup(Long value)
	{
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		result.add(reAuthRequestType);
		result.add(username);
		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(gsuPoolIdentifier);
		result.add(serviceIdentifier);
		result.add(ratingGroup);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}