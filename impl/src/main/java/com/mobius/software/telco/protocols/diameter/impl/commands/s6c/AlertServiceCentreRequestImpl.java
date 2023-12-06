package com.mobius.software.telco.protocols.diameter.impl.commands.s6c;

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSGMSCAlertEventImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SCAddressImpl;
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
@DiameterCommandImplementation(applicationId = 16777312, commandCode = 8388648, request = true)
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
	
	public AlertServiceCentreRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String scAddress,UserIdentifier userIdentifier)
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
	public void setSCAddress(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("SC-Address is required");
		
		this.scAddress = new SCAddressImpl(value);
	}
	
	@Override
	public UserIdentifier getUserIdentifier() 
	{
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
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
	public Long getSMSGMSCAlertEvent()
	{
		if(smSGMSCAlertEvent == null)
			return null;
		
		return smSGMSCAlertEvent.getUnsigned();
	}
	
	@Override
	public void setSMSGMSCAlertEvent(Long value)
	{
		if(value == null)
			this.smSGMSCAlertEvent = null;
		else
			this.smSGMSCAlertEvent = new SMSGMSCAlertEventImpl(value, null, null);
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
	public String validate()
	{
		if(scAddress == null)
			return "SC-Address is required";
		
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		return super.validate();
	}	
}