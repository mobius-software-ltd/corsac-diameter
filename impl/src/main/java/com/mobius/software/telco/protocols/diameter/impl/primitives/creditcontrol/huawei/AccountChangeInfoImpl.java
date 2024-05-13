package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountBalanceChange;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountChangeInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountDate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountDateChange;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CurrentAccountBalance;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MeasureType;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AccountChangeInfoImpl extends DiameterAvpImpl implements AccountChangeInfo 
{
	private AccountID accountID;
	
	private AccountType accountType;
	
	private CurrentAccountBalance currentAccountBalance;
	
	private AccountBalanceChange accountBalanceChange;	
	
	private AccountDate accountDate;
	
	private AccountDateChange accountDateChange;
	
	private MeasureType measureType;
	
	protected AccountChangeInfoImpl()
	{
		
	}
	
	public AccountChangeInfoImpl(ByteBuf accountID, Long accountType, Long currentAccountBalance, Long accountBalanceChange, ByteBuf accountDate, Long accountDateChange, Long measureType) throws MissingAvpException
	{
		setAccountID(accountID);
		
		setAccountType(accountType);
		
		setCurrentAccountBalance(currentAccountBalance);
		
		setAccountBalanceChange(accountBalanceChange);
		
		setAccountDate(accountDate);
		
		setAccountDateChange(accountDateChange);
		
		setMeasureType(measureType);
	}
	
	@Override
	public ByteBuf getAccountID()
	{
		if(accountID==null)
			return null;
		
		return accountID.getValue();
	}
	
	@Override
	public void setAccountID(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Account-Id is required", Arrays.asList(new DiameterAvp[] { new AccountIDImpl() }));
			
		this.accountID = new AccountIDImpl(value);
	}
	
	@Override
	public Long getAccountType()
	{
		if(accountType==null)
			return null;
		
		return accountType.getUnsigned();
	}
	
	@Override
	public void setAccountType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Account-Type is required", Arrays.asList(new DiameterAvp[] { new AccountTypeImpl() }));
			
		this.accountType = new AccountTypeImpl(value, null, null);
	}
	
	@Override
	public Long getCurrentAccountBalance()
	{
		if(currentAccountBalance==null)
			return null;
		
		return currentAccountBalance.getLong();
	}
	
	@Override
	public void setCurrentAccountBalance(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Current-Account-Balance is required", Arrays.asList(new DiameterAvp[] { new CurrentAccountBalanceImpl() }));
			
		this.currentAccountBalance = new CurrentAccountBalanceImpl(value, null, null);
	}
	
	@Override
	public Long getAccountBalanceChange()
	{
		if(accountBalanceChange==null)
			return null;
		
		return accountBalanceChange.getLong();
	}
	
	@Override
	public void setAccountBalanceChange(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Account-Balance-Change is required", Arrays.asList(new DiameterAvp[] { new AccountBalanceChangeImpl() }));
			
		this.accountBalanceChange = new AccountBalanceChangeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getAccountDate()
	{
		if(accountDate==null)
			return null;
		
		return accountDate.getValue();
	}
	
	@Override
	public void setAccountDate(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Account-Date is required", Arrays.asList(new DiameterAvp[] { new AccountDateImpl() }));
			
		this.accountDate = new AccountDateImpl(value);
	}
	
	@Override
	public Long getAccountDateChange()
	{
		if(accountDateChange==null)
			return null;
		
		return accountDateChange.getUnsigned();
	}
	
	@Override
	public void setAccountDateChange(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Account-Date-Change is required", Arrays.asList(new DiameterAvp[] { new AccountDateChangeImpl() }));
			
		this.accountDateChange = new AccountDateChangeImpl(value, null, null);
	}
	
	@Override
	public Long getMeasureType()
	{
		if(measureType==null)
			return null;
		
		return measureType.getUnsigned();
	}
	
	@Override
	public void setMeasureType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Measure-Type is required", Arrays.asList(new DiameterAvp[] { new MeasureTypeImpl() }));
			
		this.measureType = new MeasureTypeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(accountID==null)
			return new MissingAvpException("Account-Id is required", Arrays.asList(new DiameterAvp[] { new AccountIDImpl() }));
		
		if(accountType==null)
			return new MissingAvpException("Account-Type is required", Arrays.asList(new DiameterAvp[] { new AccountTypeImpl() }));
		
		if(currentAccountBalance==null)
			return new MissingAvpException("Current-Account-Balance is required", Arrays.asList(new DiameterAvp[] { new CurrentAccountBalanceImpl() }));
		
		if(accountBalanceChange==null)
			return new MissingAvpException("Account-Balance-Change is required", Arrays.asList(new DiameterAvp[] { new AccountBalanceChangeImpl() }));
		
		if(accountDate==null)
			return new MissingAvpException("Account-Date is required", Arrays.asList(new DiameterAvp[] { new AccountDateImpl() }));
		
		if(accountDateChange==null)
			return new MissingAvpException("Account-Date-Change is required", Arrays.asList(new DiameterAvp[] { new AccountDateChangeImpl() }));
		
		if(measureType==null)
			return new MissingAvpException("Measure-Type is required", Arrays.asList(new DiameterAvp[] { new MeasureTypeImpl() }));
		
		return null;
	}
}