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

import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NIDDSubmission;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SubmissionTime;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputOctets;

/**
*
* @author yulian oifa
*
*/
public class NIDDSubmissionImpl implements NIDDSubmission
{
	private SubmissionTime submissionTime;
	private EventTimestamp eventTimestamp;
	private AccountingInputOctets accountingInputOctets;
	private AccountingOutputOctets accountingOutputOctets;
	private ChangeCondition changeCondition;
		
	public NIDDSubmissionImpl()
	{
		
	}
	
	public Date getSubmissionTime()
	{
		if(submissionTime==null)
			return null;
		
		return submissionTime.getDateTime();
	}
	
	public void setSubmissionTime(Date value)
	{
		if(value==null)
			this.submissionTime = null;
		else
			this.submissionTime = new SubmissionTimeImpl(value, null, null);			
	}
	
	public Date getEventTimestamp()
	{
		if(eventTimestamp==null)
			return null;
		
		return eventTimestamp.getDateTime();
	}
	
	public void setEventTimestamp(Date value)
	{
		if(value==null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);			
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
	
	public Long getChangeCondition()
	{
		if(changeCondition==null)
			return null;
		
		return changeCondition.getUnsigned();
	}
	
	public void setChangeCondition(Long value)
	{
		if(value==null)
			this.changeCondition = null;
		else
			this.changeCondition = new ChangeConditionImpl(value, null, null);			
	}
}