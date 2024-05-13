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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NextBillDate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.POSAccountNotify;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.POSMaxCredit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.POSNotifyMode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.POSUsedCredit;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class POSAccountNotifyImpl extends DiameterAvpImpl implements POSAccountNotify
{
	private POSNotifyMode posNotifyMode;
	
	private POSUsedCredit posUsedCredit;
	
	private POSMaxCredit posMaxCredit;
	
	private NextBillDate nextBillDate;
	
	public POSAccountNotifyImpl()
	{
		
	}
	
	@Override
	public Integer getPOSNotifyMode()
	{
		if(posNotifyMode==null)
			return null;
		
		return posNotifyMode.getInteger();
	}
	
	@Override
	public void setPOSNotifyMode(Integer value)
	{
		if(value==null)
			this.posNotifyMode = null;
		else
			this.posNotifyMode = new POSNotifyModeImpl(value, null, null);
	}		
	
	@Override
	public Long getPOSUsedCredit()
	{
		if(posUsedCredit==null)
			return null;
		
		return posUsedCredit.getLong();
	}
	
	@Override
	public void setPOSUsedCredit(Long value)
	{
		if(value==null)
			this.posUsedCredit = null;
		else
			this.posUsedCredit = new POSUsedCreditImpl(value, null, null);
	}		
	
	@Override
	public Long getPOSMaxCredit()
	{
		if(posMaxCredit==null)
			return null;
		
		return posMaxCredit.getLong();
	}
	
	@Override
	public void setPOSMaxCredit(Long value)
	{
		if(value==null)
			this.posMaxCredit = null;
		else
			this.posMaxCredit = new POSMaxCreditImpl(value, null, null);
	}		
	
	@Override
	public ByteBuf getNextBillDate()
	{
		if(nextBillDate==null)
			return null;
		
		return nextBillDate.getValue();
	}
	
	@Override
	public void setNextBillDate(ByteBuf value)
	{
		if(value==null)
			this.nextBillDate = null;
		else
			this.nextBillDate = new NextBillDateImpl(value);
	}		
}