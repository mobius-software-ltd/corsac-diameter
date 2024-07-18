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

import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserDataAlreadyAvailableEnum;

public interface MessageFactory
{
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR, String sipMethod) throws MissingAvpException, AvpNotSupportedException;
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost, String destinationRealm, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException;			
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,SIPDeregistrationReason sipDeregistrationReason) throws MissingAvpException, AvpNotSupportedException;
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState, SIPServerAssignmentTypeEnum sipServerAssignmentType,SIPUserDataAlreadyAvailableEnum sipUserDataAlreadyAvailable) throws MissingAvpException, AvpNotSupportedException;
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException;
}