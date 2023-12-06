package com.mobius.software.telco.protocols.diameter.impl.commands.s6c;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6c.ReportSMDeliveryStatusRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.RDRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.RDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
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
@DiameterCommandImplementation(applicationId = 16777312, commandCode = 8388649, request = true)
public class ReportSMDeliveryStatusRequestImpl extends S6cRequestImpl implements ReportSMDeliveryStatusRequest
{
	private UserIdentifier userIdentifier;
	
	private SMSMICorrelationID smSMICorrelationID;
	
	private SCAddress scAddress;
	
	private SMDeliveryOutcome smDeliveryOutcome;
	
	private RDRFlags rdrFlags;
	
	protected ReportSMDeliveryStatusRequestImpl() 
	{
		super();
	}
	
	public ReportSMDeliveryStatusRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,String scAddress, SMDeliveryOutcome smDeliveryOutcome)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setSCAddress(scAddress);		
		
		setSMDeliveryOutcome(smDeliveryOutcome);
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
	public SMDeliveryOutcome getSMDeliveryOutcome()
	{
		return smDeliveryOutcome;
	}
	
	@Override
	public void setSMDeliveryOutcome(SMDeliveryOutcome value)
	{
		if(value == null)
			throw new IllegalArgumentException("SM-Delivery-Outcome is required");
		
		this.smDeliveryOutcome = value;
	}
	
	@Override
	public Long getRDRFlags()
	{
		if(rdrFlags == null)
			return null;
		
		return rdrFlags.getUnsigned();
	}
	
	@Override
	public void setRDRFlags(Long value)
	{
		if(value == null)
			this.rdrFlags = null;
		else
			this.rdrFlags = new RDRFlagsImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(scAddress == null)
			return "SC-Address is required";
		
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		if(smDeliveryOutcome == null)
			return "SM-Delivery-Outcome is required";
		
		return super.validate();
	}	
}