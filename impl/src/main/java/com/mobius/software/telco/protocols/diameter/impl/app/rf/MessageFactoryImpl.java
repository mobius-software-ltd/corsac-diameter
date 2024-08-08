package com.mobius.software.telco.protocols.diameter.impl.app.rf;
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
import com.mobius.software.telco.protocols.diameter.app.rf.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rf.AccountingAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rf.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.ACCOUNTING;
	
	private DiameterStack stack;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public MessageFactoryImpl(DiameterStack stack, long applicationId)
	{
		this.stack = stack;
		this.applicationId = applicationId;
	}
	
	public AccountingRequest createAccountingRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		return new AccountingRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), applicationId, accountingRecordType, accountingRecordNumber);
	}
	
	public AccountingAnswer createAccountingAnswer(AccountingRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswerImpl result = new AccountingAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), request.getAccountingRecordType(), request.getAccountingRecordNumber());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AccountingAnswer createAccountingAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		AccountingAnswerImpl result = new AccountingAnswerImpl(originHost, originRealm, false, resultCode, sessionID, accountingRecordType, accountingRecordNumber);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}