package com.mobius.software.telco.protocols.diameter.impl.app.pc2;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.app.pc2.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityActionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityActionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityApplicationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityApplicationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.PC2;
	
	private DiameterStack stack;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public MessageFactoryImpl(DiameterStack stack, long applicationId)
	{
		this.stack = stack;
		this.applicationId = applicationId;
	}
	
	public ProXimityApplicationRequest createProXimityApplicationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ProXimityApplicationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
	}
	
	@Override
	public ProXimityApplicationAnswer createProXimityApplicationAnswer(ProXimityApplicationRequest request,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException 
	{
		ProXimityApplicationAnswerImpl result = new ProXimityApplicationAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode,  request.getSessionId(),authApplicationId,AuthSessionStateEnum.NO_STATE_MAINTAINED,proSeRequestType);
		 result.setHopByHopIdentifier(hopByHopIdentifier);
		 result.setEndToEndIdentifier(endToEndIdentifier);
		 return result;
	}

	@Override
	public ProXimityApplicationAnswer createProXimityApplicationAnswer(String originHost, String originRealm,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,String sessionID, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		ProXimityApplicationAnswerImpl result = new ProXimityApplicationAnswerImpl(originHost,originRealm, false, resultCode, sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	
	public ProXimityActionRequest createProXimityActionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ProXimityActionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
	}
	
	@Override
	public ProXimityActionAnswer createProXimityActionAnswer(ProXimityActionRequest request,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException 
	{
		 ProXimityActionAnswerImpl result = new ProXimityActionAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(), authApplicationId,AuthSessionStateEnum.NO_STATE_MAINTAINED,proSeRequestType);
		 result.setHopByHopIdentifier(hopByHopIdentifier);
		 result.setEndToEndIdentifier(endToEndIdentifier);
		 return result;
	}

	@Override
	public ProXimityActionAnswer createProXimityActionAnswer(String originHost, String originRealm,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,String sessionID, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		ProXimityActionAnswerImpl result = new ProXimityActionAnswerImpl(originHost,originRealm, false, resultCode, sessionID,authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

}