package com.mobius.software.telco.protocols.diameter.app.swd;
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

import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;

import io.netty.buffer.ByteBuf;

public interface MessageFactory
{
	public EAPRequest createEAPRequest(String originHost,String originRealm,String destinationHost, String destinationRealm,AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException;
	
	public EAPAnswer createEAPAnswer(EAPRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode,AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public EAPAnswer createEAPAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthRequest createReAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID,ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;		
	
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;		
	
	public AbortSessionRequest createAbortSessionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID) throws MissingAvpException, AvpNotSupportedException;

	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationRequest createSessionTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID,TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
}