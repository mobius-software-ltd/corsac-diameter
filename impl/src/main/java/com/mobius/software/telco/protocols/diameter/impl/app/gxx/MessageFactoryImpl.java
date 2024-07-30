package com.mobius.software.telco.protocols.diameter.impl.app.gxx;
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
import com.mobius.software.telco.protocols.diameter.app.gxx.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.gxx.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gxx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gxx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gxx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.gxx.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gxx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gxx.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gxx.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.CreditControlAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.CreditControlRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gxx.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.GXX;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
	}
	
	public CreditControlRequest createCreditControlRequest(String originHost,String originRealm,String destinationHost, String destinationRealm,CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		return new CreditControlRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, ccRequestType, ccRequestNumber);
	}
	
	@Override
	public CreditControlAnswer createCreditControlAnswer(CreditControlRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		CreditControlAnswerImpl result = new CreditControlAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(), applicationId, request.getCcRequestType(), request.getCcRequestNumber());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public CreditControlAnswer createCreditControlAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		CreditControlAnswerImpl result = new CreditControlAnswerImpl(originHost,originRealm,false, resultCode, sessionID, applicationId, ccRequestType, ccRequestNumber);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	@Override
	public ReAuthRequest createReAuthRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId, reAuthRequestType);
	}

	@Override
	public ReAuthRequest createReAuthRequest(CreditControlRequest initialRequest, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(initialRequest.getDestinationHost(), initialRequest.getDestinationRealm(), initialRequest.getOriginHost(), initialRequest.getOriginRealm(), false, initialRequest.getSessionId(), applicationId, reAuthRequestType);
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
	public AbortSessionRequest createAbortSessionRequest(CreditControlRequest request) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(request.getDestinationHost(), request.getDestinationRealm(), request.getOriginHost(), request.getOriginRealm(), false, request.getSessionId(), applicationId);
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
		return new SessionTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId, terminationCause);
	}

	@Override
	public SessionTerminationRequest creatSessionTerminationRequest(CreditControlRequest request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return new SessionTerminationRequestImpl(request.getOriginHost(), request.getOriginRealm(), request.getDestinationHost(),request.getDestinationRealm(), false, request.getSessionId(), applicationId, terminationCause);
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