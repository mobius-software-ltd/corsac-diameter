package com.mobius.software.telco.protocols.diameter.app.s15;
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

import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;

public interface MessageFactory
{
	public CreditControlRequest createCreditControlRequest(String originHost,String originRealm,String destinationHost, String destinationRealm, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException;
	
	public CreditControlAnswer createCreditControlAnswer(CreditControlRequest request,Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public CreditControlAnswer createCreditControlAnswer(String originHost,String originRealm,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthRequest createReAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID,ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthRequest createReAuthRequest(CreditControlRequest initialRequest,ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request,Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;		
	
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;	
	
	public AbortSessionRequest createAbortSessionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionRequest createAbortSessionRequest(CreditControlRequest request) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationRequest createSessionTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String sessionID,TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationRequest creatSessionTerminationRequest(CreditControlRequest request,TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request,Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException;
	
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;
}