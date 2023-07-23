package com.mobius.software.telco.protocols.diameter.impl.commands.rf;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 3, commandCode = 271, request = false)
public class AccountingAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AccountingAnswerImpl implements AccountingAnswer
{
	protected AccountingAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingSubSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);	
		setAccountingRealtimeRequiredAllowed(false);
	}
	
	public AccountingAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, accountingRecordType, accountingRecordNumber);
		setExperimentalResultAllowed(true);
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingSubSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setAccountingRealtimeRequiredAllowed(false);
	}
}