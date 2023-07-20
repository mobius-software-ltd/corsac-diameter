package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginStateIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginStateId;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
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
@DiameterCommandImplementation(applicationId = -1, commandCode = 271, request = true)
public class AccountingRequestImpl extends DiameterRequestWithSessionAndRealmBase implements AccountingRequest
{
	private AccountingRecordType accountingRecordType;
	
	private AccountingRecordNumber accountingRecordNumber;
	
	private AcctApplicationId acctApplicationId;
	
	private VendorSpecificApplicationId vendorSpecificApplicationId;
	
	private UserName username;
	
	private AccountingSubSessionId accountingSubSessionId;
	
	private AcctSessionId acctSessionId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private AcctInterimInterval acctInterimInterval;
	
	private AccountingRealtimeRequired accountingRealtimeRequired;
	
	private OriginStateId originStateId;
	
	private EventTimestamp eventTimestamp;
	
	private List<ProxyInfo> proxyInfo;
	
	public List<RouteRecord> routeRecords;
	
	private boolean vendorSpecificApplicationIdAllowed = true;
	private boolean accountingSubSessionIdAllowed = true;
	private boolean acctSessionIdAllowed = true;
	private boolean acctMultiSessionIdAllowed = true;
	private boolean accountingRealtimeRequiredAllowed = true;
	
	protected AccountingRequestImpl() 
	{
		super();
		setDestinationHostAllowed(false);
	}
		
	public AccountingRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber)
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit, sessionID);
		setDestinationHostAllowed(false);
		
		if(accountingRecordType==null)
			throw new IllegalArgumentException("Accounting-Record-Type is required");
		
		if(accountingRecordNumber==null)
			throw new IllegalArgumentException("Accounting-Record-Number is required");	
		
		this.accountingRecordType = new AccountingRecordTypeImpl(accountingRecordType, null, null);
		
		this.accountingRecordNumber = new AccountingRecordNumberImpl(accountingRecordNumber, null, null);
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
	public void setAccountingRecordType(AccountingRecordTypeEnum accountingRecordType) 
	{
		if(accountingRecordType==null)
			throw new IllegalArgumentException("Accounting-Record-Type is required");
		
		this.accountingRecordType = new AccountingRecordTypeImpl(accountingRecordType, null, null);		
	}

	@Override
	public Long getAccountingRecordNumber() 
	{
		if(accountingRecordNumber==null)
			return null;
		
		return accountingRecordNumber.getUnsigned();
	}

	@Override
	public void setAccountingRecordNumber(Long accountingRecordNumber) 
	{
		if(accountingRecordNumber==null)
			throw new IllegalArgumentException("Accounting-Record-Number is required");	
		
		this.accountingRecordNumber = new AccountingRecordNumberImpl(accountingRecordNumber, null, null);
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
	public String getUsername() 
	{
		if(this.username==null)
			return null;
		
		return this.username.getString();
	}

	@Override
	public void setUsername(String value) 
	{
		if(value==null)
			this.username = null;
		else
			this.username = new UserNameImpl(value, null, null);
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
	public void setAccountingRealtimeRequired(AccountingRealtimeRequiredEnum accountingRealtimeRequiredEnum) throws AvpNotSupportedException 
	{
		if(!accountingRealtimeRequiredAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(accountingRealtimeRequiredEnum==null)
			this.accountingRealtimeRequired = null;
		else 
			this.accountingRealtimeRequired = new AccountingRealtimeRequiredImpl(accountingRealtimeRequiredEnum, null, null);
	}

	@Override
	public Long getOriginStateId() 
	{
		if(this.originStateId == null)
			return null;
		
		return this.originStateId.getUnsigned();
	}

	@Override
	public void setOriginStateId(Long value) 
	{
		if(value == null)
			this.originStateId = null;
		else
			this.originStateId = new OriginStateIdImpl(value, null, null);
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
	public List<ProxyInfo> getProxyInfo() 
	{
		return this.proxyInfo;
	}

	@Override
	public void setProxyInfo(List<ProxyInfo> value) 
	{
		this.proxyInfo = value;
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
	public String validate()
	{
		if(accountingRecordType==null)
			return "Accounting-Record-Type is required";
		
		if(accountingRecordNumber==null)
			return "Accounting-Record-Number is required";
		
		return super.validate();
	}
}