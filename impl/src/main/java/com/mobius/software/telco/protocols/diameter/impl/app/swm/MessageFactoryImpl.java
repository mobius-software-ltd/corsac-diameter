package com.mobius.software.telco.protocols.diameter.impl.app.swm;
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
import com.mobius.software.telco.protocols.diameter.app.swm.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.swm.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.EAPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.AAAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.EAPAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.AARequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swm.EAPRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SWM;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	private Long authApplicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator,long authApplicationId, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
		this.authApplicationId = authApplicationId;
	}
	
	public AARequest createAARequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new AARequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authRequestType);
	}	
	
	@Override
	public AAAnswer createAAAnswer(AARequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		AAAnswer result = new AAAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AAAnswer createAAAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		AAAnswer result = new AAAnswerImpl(originHost, originRealm, false, resultCode, sessionID, authApplicationId,authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public EAPRequest createEAPRequest(String originHost,String originRealm,String destinationHost, String destinationRealm,AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException
	{
		return new EAPRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authRequestType, eapPayload);
	}
	
	@Override
	public EAPAnswer createEAPAnswer(EAPRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		EAPAnswer result = new EAPAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public EAPAnswer createEAPAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		EAPAnswer result = new EAPAnswerImpl(originHost, originRealm, false, resultCode, sessionID, authApplicationId,authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	@Override
	public ReAuthRequest createReAuthRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, authApplicationId, reAuthRequestType);
	}

	@Override
	public ReAuthRequest createReAuthRequest(AARequest initialRequest, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(initialRequest.getDestinationHost(), initialRequest.getDestinationRealm(), initialRequest.getOriginHost(), initialRequest.getOriginRealm(), false, initialRequest.getSessionId(), authApplicationId, reAuthRequestType);
	}

	@Override
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswer result = new ReAuthAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswer result = new ReAuthAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AbortSessionRequest createAbortSessionRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, authApplicationId);
	}

	@Override
	public AbortSessionRequest createAbortSessionRequest(AARequest request) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(request.getDestinationHost(), request.getDestinationRealm(), request.getOriginHost(), request.getOriginRealm(), false, request.getSessionId(), authApplicationId);
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswer result = new AbortSessionAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswer result = new AbortSessionAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationRequest createSessionTerminationRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, authApplicationId, terminationCause);
	}

	@Override
	public SessionTerminationRequest creatSessionTerminationRequest(AARequest request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(request.getOriginHost(), request.getOriginRealm(),request.getDestinationHost(), request.getDestinationRealm(), false, request.getSessionId(), authApplicationId, terminationCause);
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswerImpl result = new SessionTerminationAnswerImpl(request.getOriginHost(), request.getOriginRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswerImpl result = new SessionTerminationAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}