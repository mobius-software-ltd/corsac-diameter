package com.mobius.software.telco.protocols.diameter.impl.primitives.nt;
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
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferEndTime;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferStartTime;

/**
*
* @author yulian oifa
*
*/
public class TimeWindowImpl extends DiameterGroupedAvpImpl implements TimeWindow
{
	private TransferStartTime transferStartTime;
	
	private TransferEndTime transferEndTime;
	
	public TimeWindowImpl(Date transferStartTime,Date transferEndTime) throws MissingAvpException
	{
		setTransferStartTime(transferStartTime);
		
		setTransferEndTime(transferEndTime);
	}
	
	public Date getTransferStartTime()
	{
		if(transferStartTime==null)
			return null;
		
		return transferStartTime.getDateTime();
	}
	
	public void setTransferStartTime(Date value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Transfer-Start-Time is required is required", Arrays.asList(new DiameterAvp[] { new TransferStartTimeImpl() }));
			
		this.transferStartTime = new TransferStartTimeImpl(value, null, null);
	}
	
	public Date getTransferEndTime()
	{
		if(transferEndTime==null)
			return null;
		
		return transferEndTime.getDateTime();
	}

	public void setTransferEndTime(Date value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Transfer-End-Time is required is required", Arrays.asList(new DiameterAvp[] { new TransferEndTimeImpl() }));
			
		this.transferEndTime = new TransferEndTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(transferStartTime==null)
			return new MissingAvpException("Transfer-Start-Time is required is required", Arrays.asList(new DiameterAvp[] { new TransferStartTimeImpl() }));
		
		if(transferEndTime==null)
			return new MissingAvpException("Transfer-End-Time is required is required", Arrays.asList(new DiameterAvp[] { new TransferEndTimeImpl() }));
		
		return null;
	}
}