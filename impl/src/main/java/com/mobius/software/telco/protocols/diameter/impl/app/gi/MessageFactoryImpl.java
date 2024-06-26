package com.mobius.software.telco.protocols.diameter.impl.app.gi;
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
import com.mobius.software.telco.protocols.diameter.app.gi.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.gi.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AAAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AARequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AccountingAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.NASREQ;
	
	private IDGenerator<?> idGenerator;
	
	private Long authApplicationId = APPLICATION_ID;
	private Long accApplicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator, long authApplicationId, long accApplicationId)
	{
		this.idGenerator = idGenerator;
		this.authApplicationId = authApplicationId;
		this.accApplicationId = accApplicationId;
	}
	
	public AARequest createAARequest(String originHost,String originRealm,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new AARequestImpl(originHost, originRealm, destinationRealm, false, idGenerator.generateID().toString(), authApplicationId);
	}

	@Override
	public AAAnswer createAAAnswer(AARequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AAAnswer result = new AAAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, request.getAuthRequestType());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AAAnswer createAAAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		AAAnswer result = new AAAnswerImpl(originHost, originRealm, false, resultCode, sessionID, authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public AccountingRequest createAccountingRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		return new AccountingRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), accountingRecordType, accountingRecordNumber, accApplicationId);
	}

	@Override
	public AccountingAnswer createAccountingAnswer(AccountingRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswerImpl result = new AccountingAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), request.getAccountingRecordType(), request.getAccountingRecordNumber(), accApplicationId);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AccountingAnswer createAccountingAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswer result = new AccountingAnswerImpl(originHost, originRealm, false, resultCode, sessionID, accountingRecordType, accountingRecordNumber, accApplicationId);
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
	public SessionTerminationRequest createSessionTerminationRequest(String originHost, String originRealm, String destinationRealm, String sessionID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(originHost, originRealm, destinationRealm, false, sessionID, authApplicationId, terminationCause);
	}

	@Override
	public SessionTerminationRequest creatSessionTerminationRequest(AARequest request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(request.getOriginHost(), request.getOriginRealm(), request.getDestinationRealm(), false, request.getSessionId(), authApplicationId, terminationCause);
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