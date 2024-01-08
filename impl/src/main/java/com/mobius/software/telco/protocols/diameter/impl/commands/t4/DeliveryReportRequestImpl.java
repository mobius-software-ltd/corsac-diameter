package com.mobius.software.telco.protocols.diameter.impl.commands.t4;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeliveryReportRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMRPSMEAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.AbsentSubscriberDiagnosticT4Impl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.SMDeliveryOutcomeT4Impl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPSMEA;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.AbsentSubscriberDiagnosticT4;
import com.mobius.software.telco.protocols.diameter.primitives.t4.AbsentSubscriberDiagnosticT4Enum;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4Enum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ReferenceNumber;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777311, commandCode = 8388644, request = true)
public class DeliveryReportRequestImpl extends T4RequestImpl implements DeliveryReportRequest
{
	private UserIdentifier userIdentifier;
	
	private SMRPSMEA smRPSMEA;
	
	private SMDeliveryOutcomeT4 smDeliveryOutcomeT4;
	
	private AbsentSubscriberDiagnosticT4 absentSubscriberDiagnosticT4;
	
	private ReferenceNumber referenceNumber;
	
	protected DeliveryReportRequestImpl() 
	{
		super();
	}
	
	public DeliveryReportRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,ByteBuf smRPSMEA,SMDeliveryOutcomeT4Enum smDeliveryOutcomeT4)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setSMRPSMEA(smRPSMEA);
		
		setSMDeliveryOutcomeT4(smDeliveryOutcomeT4);
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
	public ByteBuf getSMRPSMEA()
	{
		if(smRPSMEA == null)
			return null;
		
		return smRPSMEA.getValue();
	}
	
	@Override
	public void setSMRPSMEA(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("SM-RP-SMEA is required");
		
		this.smRPSMEA = new SMRPSMEAImpl(value, null, null);
	}
	
	@Override
	public SMDeliveryOutcomeT4Enum getSMDeliveryOutcomeT4()
	{
		if(smDeliveryOutcomeT4 == null)
			return null;
		
		return smDeliveryOutcomeT4.getEnumerated(SMDeliveryOutcomeT4Enum.class);
	}
	 
	@Override
	public void setSMDeliveryOutcomeT4(SMDeliveryOutcomeT4Enum value)
	{
		if(value == null)
			throw new IllegalArgumentException("SM-Delivery-Outcome-T4 is required");
		
		this.smDeliveryOutcomeT4 = new SMDeliveryOutcomeT4Impl(value, null, null);
	}
	
	@Override
	public AbsentSubscriberDiagnosticT4Enum getAbsentSubscriberDiagnosticT4()
	{
		if(absentSubscriberDiagnosticT4 == null)
			return null;
		
		return absentSubscriberDiagnosticT4.getEnumerated(AbsentSubscriberDiagnosticT4Enum.class);
	}
	
	@Override
	public void setAbsentSubscriberDiagnosticT4(AbsentSubscriberDiagnosticT4Enum value)
	{
		if(value == null)
			this.absentSubscriberDiagnosticT4 = null;
		else
			this.absentSubscriberDiagnosticT4 = new AbsentSubscriberDiagnosticT4Impl(value, null, null);
	}
	
	@Override
	public Long getReferenceNumber()
	{
		if(referenceNumber == null)
			return null;
		
		return referenceNumber.getUnsigned();
	}
	
	@Override
	public void setReferenceNumber(Long value)
	{
		if(value == null)
			this.referenceNumber = null;
		else
			this.referenceNumber = new ReferenceNumberImpl(value, null, null);	
	}
	
	@DiameterValidate
	public String validate()
	{
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		if(smRPSMEA == null)
			return "SM-RP-SMEA is required";
		
		if(smDeliveryOutcomeT4 == null)
			return "SM-Delivery-Outcome-T4 is required";
		
		return super.validate();
	}		
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(userIdentifier);
		result.add(smRPSMEA);
		result.add(smDeliveryOutcomeT4);
		result.add(absentSubscriberDiagnosticT4);
		result.add(referenceNumber);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}