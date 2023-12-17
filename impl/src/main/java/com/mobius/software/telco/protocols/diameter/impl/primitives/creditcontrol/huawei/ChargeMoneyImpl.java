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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ActiveDay;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChargeMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MoneyValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NewMoney;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 20344L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class ChargeMoneyImpl implements ChargeMoney
{
	private MoneyValue moneyValue;
	
	private NewMoney newMoney;
	
	private ActiveDay activeDay;
	
	protected ChargeMoneyImpl()
	{
		
	}
	
	@Override
	public Long getMoneyValue()
	{
		if(moneyValue==null)
			return null;
		
		return moneyValue.getLong();
	}
	
	@Override
	public void setMoneyValue(Long value)
	{
		if(value==null)
			this.moneyValue = null;
		else
			this.moneyValue = new MoneyValueImpl(value, null, null);
	}
	
	@Override
	public Long getNewMoney()
	{
		if(newMoney==null)
			return null;
		
		return newMoney.getLong();
	}
	
	@Override
	public void setNewMoney(Long value)
	{
		if(newMoney==null)
			this.newMoney = null;
		else
			this.newMoney = new NewMoneyImpl(value, null, null);
	}
	
	@Override
	public Long getActiveDay()
	{
		if(activeDay==null)
			return null;
		
		return activeDay.getUnsigned();
	}
	
	@Override
	public void setActiveDay(Long value)
	{
		if(activeDay==null)
			this.activeDay = null;
		else
			this.activeDay = new ActiveDayImpl(value, null, null);
	}		
}