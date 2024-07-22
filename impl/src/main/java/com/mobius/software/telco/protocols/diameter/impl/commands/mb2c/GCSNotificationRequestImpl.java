package com.mobius.software.telco.protocols.diameter.impl.commands.mb2c;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventNotification;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIExpiry;

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
public class GCSNotificationRequestImpl extends MB2CRequestImpl implements GCSNotificationRequest
{
	private TMGIExpiry tmgiExpiry;
	
	private List<MBMSBearerEventNotification> mbmsBearerEventNotification;
	
	protected GCSNotificationRequestImpl() 
	{
		super();
	}
	
	public GCSNotificationRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, authSessionState);
	}
	
	@Override
	public TMGIExpiry getTMGIExpiry()
	{
		return this.tmgiExpiry;
	}
	
	@Override
	public void setTMGIExpiry(TMGIExpiry value)
	{
		this.tmgiExpiry = value;
	}
	
	@Override
	public List<MBMSBearerEventNotification> getMBMSBearerEventNotification()
	{
		return mbmsBearerEventNotification;
	}
	
	@Override
	public void setMBMSBearerEventNotification(List<MBMSBearerEventNotification> value)
	{
		this.mbmsBearerEventNotification = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
      	result.add(authApplicationId);
      	result.add(authSessionState);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(destinationRealm);
      	result.add(destinationHost);
      	result.add(originStateId);
      	
      	if(proxyInfo!=null)
      		result.addAll(proxyInfo);
      		
      	if(routeRecords!=null)
      		result.addAll(routeRecords);
      		
      	result.add(tmgiExpiry);
      	
      	
      	if(mbmsBearerEventNotification!=null)
          	result.addAll(mbmsBearerEventNotification);
      	
      	result.add(restartCounter);
      	
      	if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
      	
      	return result;
	}
}