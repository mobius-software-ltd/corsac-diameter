package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRealtimeRequiredImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRecordNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRecordTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRealtimeRequired;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRealtimeRequiredEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordNumber;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingSubSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 0, commandCode = 271, request = false)
public class AccountingAnswerImpl extends DiameterAnswerWithSessionBase implements AccountingAnswer
{
	private AccountingRecordType accountingRecordType;
	
	private AccountingRecordNumber accountingRecordNumber;
	
	private AcctApplicationId acctApplicationId;
	
	private VendorSpecificApplicationId vendorSpecificApplicationId;
	
	private AccountingSubSessionId accountingSubSessionId;
	
	private AcctSessionId acctSessionId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private AcctInterimInterval acctInterimInterval;
	
	private AccountingRealtimeRequired accountingRealtimeRequired;
	
	private EventTimestamp eventTimestamp;
	
	private boolean vendorSpecificApplicationIdAllowed = true;
	private boolean accountingSubSessionIdAllowed = true;
	private boolean acctSessionIdAllowed = true;
	private boolean acctMultiSessionIdAllowed = true;
	private boolean accountingRealtimeRequiredAllowed = true;
	
	protected AccountingAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AccountingAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		setAccountingRecordType(accountingRecordType);
		
		setAccountingRecordNumber(accountingRecordNumber);		
	}

	protected void setVendorSpecificApplicationIdAllowed(boolean allowed) 
	{
		this.vendorSpecificApplicationIdAllowed = allowed;
	}

	protected void setAccountingSubSessionIdAllowed(boolean allowed) 
	{
		this.accountingSubSessionIdAllowed = allowed;
	}

	protected void setAcctSessionIdAllowed(boolean allowed) 
	{
		this.acctSessionIdAllowed = allowed;
	}

	protected void setAcctMultiSessionIdAllowed(boolean allowed) 
	{
		this.acctMultiSessionIdAllowed = allowed;
	}

	protected void setAccountingRealtimeRequiredAllowed(boolean allowed) 
	{
		this.accountingRealtimeRequiredAllowed = allowed;
	}

	@Override
	public AccountingRecordTypeEnum getAccountingRecordType() 
	{
		if(accountingRecordType==null)
			return null;
		
		return accountingRecordType.getEnumerated(AccountingRecordTypeEnum.class);
	}

	@Override
	public void setAccountingRecordType(AccountingRecordTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Accounting-Record-Type is required");
		
		this.accountingRecordType = new AccountingRecordTypeImpl(value, null, null);
	}

	@Override
	public Long getAccountingRecordNumber() 
	{
		if(accountingRecordNumber==null)
			return null;
		
		return accountingRecordNumber.getUnsigned();
	}

	@Override
	public void setAccountingRecordNumber(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Accounting-Record-Number is required");	
		
		this.accountingRecordNumber = new AccountingRecordNumberImpl(value, null, null);
	}

	@Override
	public Long getAcctApplicationId() 
	{
		if(acctApplicationId==null)
			return null;
		
		return acctApplicationId.getUnsigned();
	}

	@Override
	public void setAcctApplicationId(Long value) 
	{
		if(value==null)
			this.acctApplicationId = null;
		else
			this.acctApplicationId = new AcctApplicationIdImpl(value, null, null);
	}

	@Override
	public VendorSpecificApplicationId getVendorSpecificApplicationId() throws AvpNotSupportedException
	{
		if(!vendorSpecificApplicationIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		else
			return vendorSpecificApplicationId;
	}

	@Override
	public void setVendorSpecificApplicationId(VendorSpecificApplicationId value) throws AvpNotSupportedException
	{
		if(!vendorSpecificApplicationIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		else
			this.vendorSpecificApplicationId = value;
	}

	@Override
	public Long getAccountingSubSessionId() throws AvpNotSupportedException
	{
		if(!accountingSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
			
		if(this.accountingSubSessionId==null)
			return null;
		
		return this.accountingSubSessionId.getLong();
	}

	@Override
	public void setAccountingSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!accountingSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.accountingSubSessionId = null;
		else
			this.accountingSubSessionId = new AccountingSubSessionIdImpl(value, null, null);
	}

	@Override
	public ByteBuf getAcctSessionId() throws AvpNotSupportedException 
	{
		if(!acctSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.acctSessionId==null)
			return null;
		
		return this.acctSessionId.getValue();
	}

	@Override
	public void setAcctSessionId(ByteBuf value) throws AvpNotSupportedException 
	{
		if(!acctSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.acctSessionId = null;
		else
			this.acctSessionId = new AcctSessionIdImpl(value, null, null);			
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
	}

	@Override
	public Long getAcctInterimInterval() 
	{
		if(this.acctInterimInterval==null)
			return null;
		
		return this.acctInterimInterval.getUnsigned();
	}

	@Override
	public void setAcctInterimInterval(Long value) 
	{
		if(value == null)
			this.acctInterimInterval = null;
		else
			this.acctInterimInterval = new AcctInterimIntervalImpl(value, null, null);
	}

	@Override
	public AccountingRealtimeRequiredEnum getAccountingRealtimeRequired() throws AvpNotSupportedException 
	{
		if(!accountingRealtimeRequiredAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.accountingRealtimeRequired == null)
			return null;
		
		return this.accountingRealtimeRequired.getEnumerated(AccountingRealtimeRequiredEnum.class);
	}

	@Override
	public void setAccountingRealtimeRequired(AccountingRealtimeRequiredEnum value) throws AvpNotSupportedException 
	{
		if(!accountingRealtimeRequiredAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value==null)
			this.accountingRealtimeRequired = null;
		else 
			this.accountingRealtimeRequired = new AccountingRealtimeRequiredImpl(value, null, null);
	}
	
	@Override
	public Date getEventTimestamp() 
	{
		if(eventTimestamp == null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) 
	{
		if(value == null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(accountingRecordType==null)
			return "Accounting-Record-Type is required";
		
		if(accountingRecordNumber==null)
			return "Accounting-Record-Number is required";
		
		return super.validate();
	}
}