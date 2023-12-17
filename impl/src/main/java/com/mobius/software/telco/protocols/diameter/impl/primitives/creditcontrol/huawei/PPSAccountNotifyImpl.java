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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PPSAccountNotify;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PPSMaxCredit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PPSNotifyMode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PPSUsedCredit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ValidityDate2;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 21177L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class PPSAccountNotifyImpl implements PPSAccountNotify
{
	private PPSNotifyMode ppsNotifyMode;
	
	private PPSUsedCredit ppsUsedCredit;
	
	private PPSMaxCredit ppsMaxCredit;
	
	private ValidityDate2 validityDate2;
	
	public PPSAccountNotifyImpl()
	{
		
	}
	
	@Override
	public Integer getPPSNotifyMode()
	{
		if(ppsNotifyMode==null)
			return null;
		
		return ppsNotifyMode.getInteger();
	}
	
	@Override
	public void setPPSNotifyMode(Integer value)
	{
		if(value==null)
			this.ppsNotifyMode = null;
		else
			this.ppsNotifyMode = new PPSNotifyModeImpl(value, null, null);
	}		
	
	@Override
	public Long getPPSUsedCredit()
	{
		if(ppsUsedCredit==null)
			return null;
		
		return ppsUsedCredit.getLong();
	}
	
	@Override
	public void setPPSUsedCredit(Long value)
	{
		if(value==null)
			this.ppsUsedCredit = null;
		else
			this.ppsUsedCredit = new PPSUsedCreditImpl(value, null, null);
	}		
	
	@Override
	public Long getPPSMaxCredit()
	{
		if(ppsMaxCredit==null)
			return null;
		
		return ppsMaxCredit.getLong();
	}
	
	@Override
	public void setPPSMaxCredit(Long value)
	{
		if(value==null)
			this.ppsMaxCredit = null;
		else
			this.ppsMaxCredit = new PPSMaxCreditImpl(value, null, null);
	}			
	
	@Override
	public ByteBuf getValidityDate2()
	{
		if(validityDate2==null)
			return null;
		
		return validityDate2.getValue();
	}
	
	@Override
	public void setValidityDate2(ByteBuf value)
	{
		if(value==null)
			this.validityDate2 = null;
		else
			this.validityDate2 = new ValidityDate2Impl(value);
	}
}