package com.mobius.software.telco.protocols.diameter.impl.app.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.app.rfc4740.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.LocationInfoAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.LocationInfoRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.MultimediaAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.MultimediaAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.PushProfileAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.PushProfileRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.RegistrationTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.RegistrationTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.ServerAssignmentAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.ServerAssignmentRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.UserAuthorizationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.UserAuthorizationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataAlreadyAvailableEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SIP_APPLICATION;
	
	private DiameterStack stack;
	
	private Long applicationId = APPLICATION_ID;
	private Long authApplicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public MessageFactoryImpl(DiameterStack stack,long authApplicationId, long applicationId)
	{
		this.stack = stack;
		this.applicationId = applicationId;
		this.authApplicationId = authApplicationId;
	}
	
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException
	{
		return new LocationInfoRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState, sipAOR);
	}
	
	@Override
	public LocationInfoAnswer createLocationInfoAnswer(LocationInfoRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		LocationInfoAnswerImpl result = new LocationInfoAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(),authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public LocationInfoAnswer createLocationInfoAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		LocationInfoAnswerImpl result = new LocationInfoAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR, String sipMethod) throws MissingAvpException, AvpNotSupportedException
	{
		return new MultimediaAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState, sipAOR, sipMethod);
	}
	
	@Override
	public MultimediaAuthAnswer createMultimediaAuthAnswer(MultimediaAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MultimediaAuthAnswerImpl result = new MultimediaAuthAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public MultimediaAuthAnswer createMultimediaAuthAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MultimediaAuthAnswerImpl result = new MultimediaAuthAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost, String destinationRealm, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		return new PushProfileRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState);
	}
	
	@Override
	public PushProfileAnswer createPushProfileAnswer(PushProfileRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PushProfileAnswerImpl result = new PushProfileAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(),authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}	

	@Override
	public PushProfileAnswer createPushProfileAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PushProfileAnswerImpl result = new PushProfileAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,SIPDeregistrationReason sipDeregistrationReason) throws MissingAvpException, AvpNotSupportedException
	{
		return new RegistrationTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState, sipDeregistrationReason);
	}
	
	@Override
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(RegistrationTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		RegistrationTerminationAnswerImpl result = new RegistrationTerminationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(),authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		RegistrationTerminationAnswerImpl result = new RegistrationTerminationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState, SIPServerAssignmentTypeEnum sipServerAssignmentType,SIPUserDataAlreadyAvailableEnum sipUserDataAlreadyAvailable) throws MissingAvpException, AvpNotSupportedException
	{
		return new ServerAssignmentRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState, sipServerAssignmentType, sipUserDataAlreadyAvailable);
	}
	
	@Override
	public ServerAssignmentAnswer createServerAssignmentAnswer(ServerAssignmentRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ServerAssignmentAnswerImpl result = new ServerAssignmentAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(),  authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ServerAssignmentAnswer createServerAssignmentAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ServerAssignmentAnswerImpl result = new ServerAssignmentAnswerImpl(originHost, originRealm, false, resultCode,  sessionID,authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException
	{
		return new UserAuthorizationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authSessionState, sipAOR);
	}
	
	@Override
	public UserAuthorizationAnswer createUserAuthorizationAnswer(UserAuthorizationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		UserAuthorizationAnswerImpl result = new UserAuthorizationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public UserAuthorizationAnswer createUserAuthorizationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		UserAuthorizationAnswerImpl result = new UserAuthorizationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
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