package com.mobius.software.telco.protocols.diameter.impl.app.s6m;
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
import com.mobius.software.telco.protocols.diameter.app.s6m.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6m.SubscriberInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6m.SubscriberInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6m.SubscriberInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6m.SubscriberInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.S6M;
	
	private  DiameterStack stack;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public SubscriberInformationRequest createSubscriberInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,SIRFlags sirFlags) throws MissingAvpException, AvpNotSupportedException
	{
		return new SubscriberInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, sirFlags);
	}
	
	@Override
	public SubscriberInformationAnswer createSubscriberInformationAnswer (SubscriberInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		SubscriberInformationAnswerImpl result = new  SubscriberInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SubscriberInformationAnswer createSubscriberInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		SubscriberInformationAnswerImpl result = new  SubscriberInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
}