package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RANEndTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RANSecondaryRATUsageReport;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RANStartTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SecondaryRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputOctets;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1302L, vendorId = KnownVendorIDs.TGPP_ID)
public class RANSecondaryRATUsageReportImpl implements RANSecondaryRATUsageReport
{
	private SecondaryRATType secondaryRATType;
	private RANStartTimestamp ranStartTimestamp;
	private RANEndTimestamp ranEndTimestamp;
	private AccountingInputOctets accountingInputOctets;
	private AccountingOutputOctets accountingOutputOctets; 
	private TGPPChargingId tgppChargingId;
		
	public RANSecondaryRATUsageReportImpl()
	{
		
	}
	
	public ByteBuf getSecondaryRATType()
	{
		if(secondaryRATType==null)
			return null;
		
		return secondaryRATType.getValue();
	}
	
	public void setSecondaryRATType(ByteBuf value)
	{
		if(value==null)
			this.secondaryRATType = null;
		else
			this.secondaryRATType = new SecondaryRATTypeImpl(value, null, null);			
	}
	
	public Date getRANStartTimestamp()
	{
		if(ranStartTimestamp==null)
			return null;
		
		return ranStartTimestamp.getDateTime();
	}
	
	public void setRANStartTimestamp(Date value)
	{
		if(value==null)
			this.ranStartTimestamp = null;
		else
			this.ranStartTimestamp = new RANStartTimestampImpl(value, null, null);			
	}
	
	public Date getRANEndTimestamp()
	{
		if(ranEndTimestamp==null)
			return null;
		
		return ranEndTimestamp.getDateTime();
	}
	
	public void setRANEndTimestamp(Date value)
	{
		if(value==null)
			this.ranEndTimestamp = null;
		else
			this.ranEndTimestamp = new RANEndTimestampImpl(value, null, null);			
	}
	
	public Long getAccountingInputOctets()
	{
		if(accountingInputOctets==null)
			return null;
		
		return accountingInputOctets.getLong();
	}
	
	public void setAccountingInputOctets(Long value)
	{
		if(value==null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(value, null, null);			
	}
	
	public Long getAccountingOutputOctets()
	{
		if(accountingOutputOctets==null)
			return null;
		
		return accountingOutputOctets.getLong();
	}
	
	public void setAccountingOutputOctets(Long value)
	{
		if(value==null)
			this.accountingOutputOctets = null;
		else
			this.accountingOutputOctets = new AccountingOutputOctetsImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	public void set3GPPChargingId(ByteBuf value)
	{
		if(value==null)
			this.tgppChargingId = null;
		else
			this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);			
	}
}