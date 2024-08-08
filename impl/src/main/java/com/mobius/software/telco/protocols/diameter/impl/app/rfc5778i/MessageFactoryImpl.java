package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778i;
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
import com.mobius.software.telco.protocols.diameter.app.rfc5778i.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.AccountingAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.EAPAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.EAPRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778i.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
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
	public static final long APPLICATION_ID=ApplicationIDs.MIP6I;
	
	private DiameterStack stack;

	private Long applicationId = APPLICATION_ID;
	private Long authApplicationId = APPLICATION_ID;
	private Long accApplicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public MessageFactoryImpl(DiameterStack stack, long applicationId,long authApplicationId, long accApplicationId)
	{
		this.stack = stack;
		this.applicationId = applicationId;
		this.authApplicationId = authApplicationId;
		this.accApplicationId = accApplicationId;
	}
	
	public EAPRequest createEAPRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException
	{
		return new EAPRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authRequestType, eapPayload);
	}
	
	@Override
	public EAPAnswer createEAPAnswer(EAPRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		EAPAnswer result = new EAPAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, request.getAuthRequestType());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public EAPAnswer createEAPAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		EAPAnswer result = new EAPAnswerImpl(originHost, originRealm, false, resultCode, sessionID, authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public AccountingRequest createAccountingRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		return new AccountingRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), accountingRecordNumber, accountingRecordType, accApplicationId);
	}

	@Override
	public AccountingAnswer createAccountingAnswer(AccountingRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswerImpl result = new AccountingAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), request.getAccountingRecordType(), request.getAccountingRecordNumber());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AccountingAnswer createAccountingAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswer result = new AccountingAnswerImpl(originHost, originRealm, false, resultCode, sessionID, accountingRecordType, accountingRecordNumber);
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
	public ReAuthRequest createReAuthRequest(EAPRequest initialRequest, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
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
	public AbortSessionRequest createAbortSessionRequest(EAPRequest request) throws MissingAvpException, AvpNotSupportedException
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
	public SessionTerminationRequest creatSessionTerminationRequest(EAPRequest request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(request.getOriginHost(), request.getOriginRealm(), request.getDestinationHost(), request.getDestinationRealm(), false, request.getSessionId(), authApplicationId, terminationCause);
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