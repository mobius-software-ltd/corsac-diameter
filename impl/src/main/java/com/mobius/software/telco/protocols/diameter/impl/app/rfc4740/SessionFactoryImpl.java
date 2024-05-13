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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.app.rfc4740.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.LocationInfoRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.MultimediaAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.PushProfileRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.RegistrationTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.ServerAssignmentRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.UserAuthorizationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataAlreadyAvailableEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SIP_APPLICATION;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
	}
	
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException
	{
		return new LocationInfoRequestImpl(originHost, originRealm, destinationHost, destinationRealm, null, destinationRealm, applicationId, authSessionState, sipAOR);
	}	
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR, String sipMethod) throws MissingAvpException, AvpNotSupportedException
	{
		return new MultimediaAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState, sipAOR, sipMethod);
	}
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationRealm, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		return new PushProfileRequestImpl(originHost, originRealm, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState);
	}			
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,SIPDeregistrationReason sipDeregistrationReason) throws MissingAvpException, AvpNotSupportedException
	{
		return new RegistrationTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState, sipDeregistrationReason);
	}
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState, SIPServerAssignmentTypeEnum sipServerAssignmentType,SIPUserDataAlreadyAvailableEnum sipUserDataAlreadyAvailable) throws MissingAvpException, AvpNotSupportedException
	{
		return new ServerAssignmentRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState, sipServerAssignmentType, sipUserDataAlreadyAvailable);
	}
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException
	{
		return new UserAuthorizationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState, sipAOR);
	}
}