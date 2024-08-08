package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778a;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.app.rfc5778a.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Answer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Request;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.AccountingAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.MIP6AnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.MIP6RequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778a.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.MIP6A;
	
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
	
	public MIP6Request createMIP6Request(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthRequestTypeEnum authRequestType,List<InetAddress> mipMobileNodeAddress,MIP6AgentInfo mip6AgentInfo,InetAddress mipCareofAddress) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		return new MIP6RequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, authRequestType, mipMobileNodeAddress, mip6AgentInfo, mipCareofAddress);
	}
	
	@Override
	public MIP6Answer createMIP6Answer(MIP6Request request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		MIP6Answer result = new MIP6AnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, request.getAuthRequestType());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public MIP6Answer createMIP6Answer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		MIP6Answer result = new MIP6AnswerImpl(originHost, originRealm, false, resultCode, sessionID, authApplicationId, authRequestType);
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
	public ReAuthRequest createReAuthRequest(MIP6Request initialRequest, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
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
	public AbortSessionRequest createAbortSessionRequest(MIP6Request request) throws MissingAvpException, AvpNotSupportedException
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
	public SessionTerminationRequest creatSessionTerminationRequest(MIP6Request request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
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