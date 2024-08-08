package com.mobius.software.telco.protocols.diameter.impl.app.sgd;
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
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.sgd.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MOForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MOForwardShortMessageRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MTForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MTForwardShortMessageRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgd.MOForwardShortMessageAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgd.MOForwardShortMessageRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgd.MTForwardShortMessageAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgd.MTForwardShortMessageRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SGD;
	
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
	
	
	public MOForwardShortMessageRequest createMOForwardShortMessageRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentifier userIdentifier, ByteBuf smRPUI) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		MOForwardShortMessageRequest request = new MOForwardShortMessageRequestImpl(originHost,originRealm,destinationHost, destinationRealm,false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, smRPUI);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public MOForwardShortMessageAnswer createMOForwardShortMessageAnswer(MOForwardShortMessageRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MOForwardShortMessageAnswerImpl result = new MOForwardShortMessageAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public MOForwardShortMessageAnswer createMOForwardShortMessageAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MOForwardShortMessageAnswerImpl result = new MOForwardShortMessageAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public MTForwardShortMessageRequest createMTForwardShortMessageRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, String scAddress,ByteBuf smRPUI) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		MTForwardShortMessageRequest request = new MTForwardShortMessageRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED, scAddress, smRPUI); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public MTForwardShortMessageAnswer createMTForwardShortMessageAnswer(MTForwardShortMessageRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MTForwardShortMessageAnswerImpl result = new  MTForwardShortMessageAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public MTForwardShortMessageAnswer createMTForwardShortMessageAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MTForwardShortMessageAnswerImpl result = new  MTForwardShortMessageAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}