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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountDate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CCCredit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.LifeCycleState;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AccountInfoImpl extends DiameterAvpImpl implements AccountInfo 
{
	protected AccountID accountID;
	
	protected AccountType accountType;
	
	protected CCMoney ccMoney;
	
	protected CCCredit ccCredit;
	
	protected AccountDate accountDate;
	
	protected LifeCycleState lifeCycleState;
	
	public AccountInfoImpl()
	{
		
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
			this.accountID = null;
		else
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
			this.accountType = null;
		else
			this.accountType = new AccountTypeImpl(value, null, null);
	}
	
	@Override
	public CCMoney getCCMoney()
	{
		return this.ccMoney;
	}
	
	@Override
	public void setCCMoney(CCMoney value)
	{
		this.ccMoney = value;
	}
	
	@Override
	public CCCredit getCCCredit()
	{
		return this.ccCredit;
	}
	
	@Override
	public void setCCCredit(CCCredit value)
	{
		this.ccCredit = value;
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
			this.accountDate = null;
		else
			this.accountDate = new AccountDateImpl(value);
	}
	
	@Override
	public Long getLifeCycleState()
	{
		if(lifeCycleState==null)
			return null;
		
		return lifeCycleState.getUnsigned();
	}
	
	@Override
	public void setLifeCycleState(Long value)
	{
		if(value==null)
			this.lifeCycleState = null;
		else
			this.lifeCycleState = new LifeCycleStateImpl(value, null, null);
	}			
}