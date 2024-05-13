package com.mobius.software.telco.protocols.diameter.impl.commands.s6c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSGMSCAlertEvent;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

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
public class AlertServiceCentreRequestImpl extends S6cRequestImpl implements AlertServiceCentreRequest
{
	private SCAddress scAddress;
	
	private UserIdentifier userIdentifier;
	
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	
	private SMSMICorrelationID smSMICorrelationID;
	
	private SMSGMSCAlertEvent smSGMSCAlertEvent;
	
	private ServingNode servingNode;
	
	protected AlertServiceCentreRequestImpl() 
	{
		super();
	}
	
	public AlertServiceCentreRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String scAddress,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setSCAddress(scAddress);
		
		setUserIdentifier(userIdentifier);
	}
	
	@Override
	public String getSCAddress()
	{
		if(scAddress == null)
			return null;
		
		return scAddress.getAddress();
	}
	
	@Override
	public void setSCAddress(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SC-Address is required", Arrays.asList(new DiameterAvp[] { new SCAddressImpl() }));
			
		this.scAddress = new SCAddressImpl(value);
	}
	
	@Override
	public UserIdentifier getUserIdentifier() 
	{
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
			
		this.userIdentifier = value;
	}
	
	@Override
	public SMSMICorrelationID getSMSMICorrelationID()
	{
		return this.smSMICorrelationID;
	}
	 
	@Override
	public void setSMSMICorrelationID(SMSMICorrelationID value)
	{
		this.smSMICorrelationID = value;
	}	
	
	@Override
	public Date getMaximumUEAvailabilityTime()
	{
		if(maximumUEAvailabilityTime == null)
			return null;
		
		return maximumUEAvailabilityTime.getDateTime();
	}
	
	@Override
	public void setMaximumUEAvailabilityTime(Date value)
	{
		if(value == null)
			this.maximumUEAvailabilityTime = null;
		else
			this.maximumUEAvailabilityTime = new MaximumUEAvailabilityTimeImpl(value, null, null);
	}
	
	@Override
	public SMSGMSCAlertEvent getSMSGMSCAlertEvent()
	{
		return smSGMSCAlertEvent;
	}
	
	@Override
	public void setSMSGMSCAlertEvent(SMSGMSCAlertEvent value)
	{
		this.smSGMSCAlertEvent = value;
	}
	
	@Override
	public ServingNode getServingNode()
	{
		return servingNode;
	}
	
	@Override
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;
	}		
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(scAddress == null)
			return new MissingAvpException("SC-Address is required", Arrays.asList(new DiameterAvp[] { new SCAddressImpl() }));
		
		if(userIdentifier == null)
			return new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
		
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
		result.add(scAddress);
		result.add(userIdentifier);
		result.add(smSMICorrelationID);
		result.add(maximumUEAvailabilityTime);
		result.add(smSGMSCAlertEvent);
		result.add(servingNode);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
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