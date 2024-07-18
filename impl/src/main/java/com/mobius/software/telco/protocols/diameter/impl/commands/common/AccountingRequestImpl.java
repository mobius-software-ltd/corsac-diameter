package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterRequestWithSessionAndRealmBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRealtimeRequiredImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRecordNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingRecordTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AccountingSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
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
public class AccountingRequestImpl extends DiameterRequestWithSessionAndRealmBase implements AccountingRequest
{
	protected AccountingRecordType accountingRecordType;
	
	protected AccountingRecordNumber accountingRecordNumber;
	
	protected AcctApplicationId acctApplicationId;
	
	protected VendorSpecificApplicationId vendorSpecificApplicationId;
	
	protected AccountingSubSessionId accountingSubSessionId;
	
	protected AcctSessionId acctSessionId;
	
	protected AcctMultiSessionId acctMultiSessionId;
	
	protected AcctInterimInterval acctInterimInterval;
	
	protected AccountingRealtimeRequired accountingRealtimeRequired;
	
	protected EventTimestamp eventTimestamp;
	
	protected List<RouteRecord> routeRecords;
	
	private boolean vendorSpecificApplicationIdAllowed = true;
	private boolean accountingSubSessionIdAllowed = true;
	private boolean acctSessionIdAllowed = true;
	private boolean acctMultiSessionIdAllowed = true;
	private boolean accountingRealtimeRequiredAllowed = true;
	
	protected AccountingRequestImpl() 
	{
		super();
	}
		
	public AccountingRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit, sessionID);
		
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
	public void setAccountingRecordType(AccountingRecordTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Accounting-Record-Type is required", Arrays.asList(new DiameterAvp[] { new AccountingRecordTypeImpl(value, null, null) }));
		
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
	public void setAccountingRecordNumber(Long value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Accounting-Record-Number is required", Arrays.asList(new DiameterAvp[] { new AccountingRecordNumberImpl(value, null, null) }));
		
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
	public void setAcctApplicationId(Long value) throws MissingAvpException 
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new VendorSpecificApplicationIdImpl() }));
		
		return vendorSpecificApplicationId;
	}

	@Override
	public void setVendorSpecificApplicationId(VendorSpecificApplicationId value) throws AvpNotSupportedException
	{
		if(!vendorSpecificApplicationIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { value }));
		
		this.vendorSpecificApplicationId = value;
	}

	@Override
	public Long getAccountingSubSessionId() throws AvpNotSupportedException
	{
		if(!accountingSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AccountingSubSessionIdImpl() }));
			
		if(this.accountingSubSessionId==null)
			return null;
		
		return this.accountingSubSessionId.getLong();
	}

	@Override
	public void setAccountingSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!accountingSubSessionIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AccountingSubSessionIdImpl(value, null, null) }));
			
		if(value == null)
			this.accountingSubSessionId = null;
		else
			this.accountingSubSessionId = new AccountingSubSessionIdImpl(value, null, null);
	}

	@Override
	public ByteBuf getAcctSessionId() throws AvpNotSupportedException 
	{
		if(!acctSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctSessionIdImpl() }));
		
		if(this.acctSessionId==null)
			return null;
		
		return this.acctSessionId.getValue();
	}

	@Override
	public void setAcctSessionId(ByteBuf value) throws AvpNotSupportedException 
	{
		if(!acctSessionIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctSessionIdImpl(value, null, null) }));
		
		if(value == null)
			this.acctSessionId = null;
		else
			this.acctSessionId = new AcctSessionIdImpl(value, null, null);			
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctMultiSessionIdImpl() }));
		
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctMultiSessionIdImpl(value, null, null) }));
			
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AccountingRealtimeRequiredImpl() }));
		
		if(this.accountingRealtimeRequired == null)
			return null;
		
		return this.accountingRealtimeRequired.getEnumerated(AccountingRealtimeRequiredEnum.class);
	}

	@Override
	public void setAccountingRealtimeRequired(AccountingRealtimeRequiredEnum value) throws AvpNotSupportedException 
	{
		if(!accountingRealtimeRequiredAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AccountingRealtimeRequiredImpl(value, null, null) }));
		
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

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(accountingRecordType==null)
			return new MissingAvpException("Accounting-Record-Type is required", Arrays.asList(new DiameterAvp[] { new AccountingRecordTypeImpl() }));
		
		if(accountingRecordNumber==null)
			return new MissingAvpException("Accounting-Record-Number is required", Arrays.asList(new DiameterAvp[] { new AccountingRecordNumberImpl() }));
		
		if(!vendorSpecificApplicationIdAllowed && vendorSpecificApplicationId !=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { vendorSpecificApplicationId }));
		
		if(!accountingSubSessionIdAllowed && accountingSubSessionId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { accountingSubSessionId }));
			
		if(!acctSessionIdAllowed && acctSessionId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { acctSessionId }));
		
		if(!acctMultiSessionIdAllowed && acctMultiSessionId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { acctMultiSessionId }));
		
		if(!accountingRealtimeRequiredAllowed && accountingRealtimeRequired!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { accountingRealtimeRequired }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(accountingRecordType);
		result.add(accountingRecordNumber);
		result.add(acctApplicationId);
		result.add(vendorSpecificApplicationId);
		result.add(username);
		result.add(destinationHost);
		result.add(accountingSubSessionId);
		result.add(acctSessionId);
		result.add(acctMultiSessionId);
		result.add(acctInterimInterval);
		result.add(accountingRealtimeRequired);
		result.add(originStateId);
		result.add(eventTimestamp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}