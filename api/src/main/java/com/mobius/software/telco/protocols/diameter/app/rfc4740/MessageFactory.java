package com.mobius.software.telco.protocols.diameter.app.rfc4740;
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


import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataAlreadyAvailableEnum;

public interface MessageFactory
{
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException;	
	
	public LocationInfoAnswer createLocationInfoAnswer(LocationInfoRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public LocationInfoAnswer createLocationInfoAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR, String sipMethod) throws MissingAvpException, AvpNotSupportedException;
	
	public MultimediaAuthAnswer createMultimediaAuthAnswer(MultimediaAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthAnswer createMultimediaAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost, String destinationRealm, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException;			
	
	public PushProfileAnswer createPushProfileAnswer(PushProfileRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileAnswer createPushProfileAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,SIPDeregistrationReason sipDeregistrationReason) throws MissingAvpException, AvpNotSupportedException;

	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(RegistrationTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode,Long authSessionState) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authSessionState) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState, SIPServerAssignmentTypeEnum sipServerAssignmentType,SIPUserDataAlreadyAvailableEnum sipUserDataAlreadyAvailable) throws MissingAvpException, AvpNotSupportedException;

	public ServerAssignmentAnswer createServerAssignmentAnswer(ServerAssignmentRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentAnswer createServerAssignmentAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException;

	public UserAuthorizationAnswer createUserAuthorizationAnswer(UserAuthorizationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;		
	
	public UserAuthorizationAnswer createUserAuthorizationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public ReAuthRequest createReAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;		
	
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;		
	
	public AbortSessionRequest createAbortSessionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationRequest createSessionTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID,TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
}
