package com.mobius.software.telco.protocols.diameter.impl.app.sgmb;
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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.app.sgmb.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SGMB;
	
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
	
	public ReAuthRequest createReAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, reAuthRequestType);
	}
	
	@Override
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswerImpl result = new ReAuthAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswerImpl result = new ReAuthAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	@Override
	public AbortSessionRequest createAbortSessionRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId);
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswerImpl result = new AbortSessionAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswerImpl result = new AbortSessionAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationRequest createSessionTerminationRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId, terminationCause);
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswer result = new SessionTerminationAnswerImpl(request.getOriginHost(), request.getOriginRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswer result = new SessionTerminationAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}