package com.mobius.software.telco.protocols.diameter.impl.commands.t4;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeviceTriggerRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMRPSMEAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.TriggerActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ApplicationPortIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.OldReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.PayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.PriorityIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPSMEA;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerAction;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ApplicationPortIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.OldReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.Payload;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndication;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;
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
@DiameterCommandImplementation(applicationId = 16777311, commandCode = 8388643, request = true)
public class DeviceTriggerRequestImpl extends T4RequestImpl implements DeviceTriggerRequest
{
	private UserIdentifier userIdentifier;
	
	private SMRPSMEA smRPSMEA;
	
	private Payload payload;
	
	private ServingNode servingNode;
	
	private List<AdditionalServingNode> additionalServingNode;
	
	private ReferenceNumber referenceNumber;
	
	private ValidityTime validityTime;
	
	private PriorityIndication priorityIndication;
	
	private ApplicationPortIdentifier smsApplicationPortID;
	
	private OldReferenceNumber oldReferenceNumber;
	
	private TriggerAction triggerAction;
	
	protected DeviceTriggerRequestImpl() 
	{
		super();
	}
	
	public DeviceTriggerRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,ByteBuf smRPSMEA,ByteBuf payload)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setSMRPSMEA(smRPSMEA);
		
		setPayload(payload);
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
	public ByteBuf getPayload()
	{
		if(payload == null)
			return null;
		
		return payload.getValue();
	}
	 
	@Override
	public void setPayload(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Payload is required");
		
		this.payload = new PayloadImpl(value, null, null);
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
	
	@Override
	public List<AdditionalServingNode> getAdditionalServingNode()
	{
		return this.additionalServingNode;
	}
	 
	@Override
	public void setAdditionalServingNode(List<AdditionalServingNode> value)
	{
		this.additionalServingNode = value;
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
	
	@Override
	public Long getValidityTime()
	{
		if(validityTime == null)
			return null;
		
		return validityTime.getUnsigned();
	}
	
	@Override
	public void setValidityTime(Long value)
	{
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}
	
	@Override
	public PriorityIndicationEnum getPriorityIndication()
	{
		if(priorityIndication == null)
			return null;
		
		return priorityIndication.getEnumerated(PriorityIndicationEnum.class);
	}
	
	@Override
	public void setPriorityIndication(PriorityIndicationEnum value)
	{
		if(value == null)
			this.priorityIndication = null;
		else
			this.priorityIndication = new PriorityIndicationImpl(value, null, null);
	}
	
	@Override
	public Long getSMSApplicationPortID()
	{
		if(smsApplicationPortID == null)
			return null;
		
		return smsApplicationPortID.getUnsigned();
	}
	
	@Override
	public void setSMSApplicationPortID(Long value)
	{
		if(value == null)
			this.smsApplicationPortID = null;
		else
			this.smsApplicationPortID = new ApplicationPortIdentifierImpl(value, null, null);
	}	
	
	@Override
	public Long getOldReferenceNumber()
	{
		if(oldReferenceNumber == null)
			return null;
		
		return oldReferenceNumber.getUnsigned();
	}
	
	@Override
	public void setOldReferenceNumber(Long value)
	{
		if(value == null)
			this.oldReferenceNumber = null;
		else
			this.oldReferenceNumber = new OldReferenceNumberImpl(value, null, null);
	}
	
	@Override
	public TriggerActionEnum getTriggerAction()
	{
		if(triggerAction == null)
			return null;
		
		return triggerAction.getEnumerated(TriggerActionEnum.class);
	}
	
	@Override
	public void setTriggerAction(TriggerActionEnum value)
	{
		if(value == null)
			this.triggerAction = null;
		else
			this.triggerAction = new TriggerActionImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		if(smRPSMEA == null)
			return "SM-RP-SMEA is required";
		
		if(payload == null)
			return "Payload is required";
		
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
		result.add(payload);
		result.add(servingNode);
		
		if(additionalServingNode!=null)
			result.addAll(additionalServingNode);
		
		result.add(referenceNumber);
		result.add(validityTime);
		result.add(priorityIndication);
		result.add(smsApplicationPortID);
		result.add(oldReferenceNumber);
		result.add(triggerAction);
		
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