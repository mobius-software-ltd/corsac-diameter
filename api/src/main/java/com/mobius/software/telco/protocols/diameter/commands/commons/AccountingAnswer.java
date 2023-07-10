package com.mobius.software.telco.protocols.diameter.commands.commons;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRealtimeRequiredEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = -1, commandCode = 271, request = false, proxyable = true, name="Accounting-Answer")
public interface AccountingAnswer extends DiameterAnswer
{
	AccountingRecordTypeEnum getAccountingRecordType();
	
	void setAccountingRecordType(AccountingRecordTypeEnum accountingRecordType);
	
	Long getAccountingRecordNumber();
	
	void setAccountingRecordNumber(Long accountingRecordNumber);
	
	public Long getAcctApplicationId();
	
	void setAcctApplicationIds(Long value);
	
	public VendorSpecificApplicationId getVendorSpecificApplicationId();
	
	void setVendorSpecificApplicationId(VendorSpecificApplicationId value);
	
	public String getUsername();
	
	void setUsername(String value);
	
	public Long getAccountingSubSessionId();
	
	void setAccountingSubSessionId(Long value);
	
	public ByteBuf getAcctSessionId();
	
	void setAcctSessionId(ByteBuf value);
	
	public String getAcctMultiSessionId();
	
	void setAcctMultiSessionId(String value);
	
	public Long getAcctInterimInterval();
	
	void setAcctInterimInterval(Long value);
	
	AccountingRealtimeRequiredEnum getAccountingRealtimeRequired();
	
	void setAccountingRealtimeRequired(AccountingRealtimeRequiredEnum accountingRealtimeRequiredEnum);
		  
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
}