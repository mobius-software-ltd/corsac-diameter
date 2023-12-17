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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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
@DiameterAvpImplementation(code = 20349L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class AccountChangeInfoImpl implements AccountChangeInfo 
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
	
	public AccountChangeInfoImpl(ByteBuf accountID, Long accountType, Long currentAccountBalance, Long accountBalanceChange, ByteBuf accountDate, Long accountDateChange, Long measureType)
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
	public void setAccountID(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Account-Id is required");
		
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
	public void setAccountType(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Account-Type is required");
		
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
	public void setCurrentAccountBalance(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Current-Account-Balance is required");
		
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
	public void setAccountBalanceChange(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Account-Balance-Change is required");
		
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
	public void setAccountDate(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Account-Date is required");
		
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
	public void setAccountDateChange(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Account-Date-Change is required");
		
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
	public void setMeasureType(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Measure-Type is required");
		
		this.measureType = new MeasureTypeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(accountID==null)
			return "Account-Id is required";
		
		if(accountType==null)
			return "Account-Type is required";
		
		if(currentAccountBalance==null)
			return "Current-Account-Balance is required";
		
		if(accountBalanceChange==null)
			return "Account-Balance-Change is required";
		
		if(accountDate==null)
			return "Account-Date is required";
		
		if(accountDateChange==null)
			return "Account-Date-Change is required";
		
		if(measureType==null)
			return "Measure-Type is required";
		
		return null;
	}
}