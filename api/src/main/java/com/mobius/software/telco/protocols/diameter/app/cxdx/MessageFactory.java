package com.mobius.software.telco.protocols.diameter.app.cxdx;
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

import com.mobius.software.telco.protocols.diameter.commands.cxdx.LocationInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserDataAlreadyAvailableEnum;

public interface MessageFactory
{
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String publicIdentity) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public LocationInfoAnswer createLocationInfoAnswer(LocationInfoRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public LocationInfoAnswer createLocationInfoAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, String publicIdentity,Long sipNumberAuthItems,SIPAuthDataItem sIPAuthDataItem, String serverName) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public MultimediaAuthAnswer createMultimediaAuthAnswer(MultimediaAuthRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthAnswer createMultimediaAuthAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;			
	
	public PushProfileAnswer createPushProfileAnswer(PushProfileRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileAnswer createPushProfileAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, DeregistrationReason deregistrationReason) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(RegistrationTerminationRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, String serverName, ServerAssignmentTypeEnum serverAssignmentType,UserDataAlreadyAvailableEnum userDataAlreadyAvailable) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public ServerAssignmentAnswer createServerAssignmentAnswer(ServerAssignmentRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentAnswer createServerAssignmentAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public UserAuthorizationAnswer createUserAuthorizationAnswer(UserAuthorizationRequest request,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;		
	
	public UserAuthorizationAnswer createUserAuthorizationAnswer(String originHost,String originRealm,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
}