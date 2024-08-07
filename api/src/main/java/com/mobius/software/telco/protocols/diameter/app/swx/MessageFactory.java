package com.mobius.software.telco.protocols.diameter.app.swx;
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

import com.mobius.software.telco.protocols.diameter.commands.swx.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;

public interface MessageFactory
{
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, Long sipNumberAuthItems,SIPAuthDataItem sIPAuthDataItem) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public MultimediaAuthAnswer createMultimediaAuthAnswer(MultimediaAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode,String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MultimediaAuthAnswer createMultimediaAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID,String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;			

	public PushProfileAnswer createPushProfileAnswer(PushProfileRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushProfileAnswer createPushProfileAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm, String destinationHost, String destinationRealm, String username, DeregistrationReason deregistrationReason) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(RegistrationTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username,ServerAssignmentTypeEnum serverAssignmentType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ServerAssignmentAnswer createServerAssignmentAnswer(ServerAssignmentRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCodeString, String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ServerAssignmentAnswer createServerAssignmentAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID,String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
}