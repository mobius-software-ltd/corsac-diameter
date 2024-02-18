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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferPolicy;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferPolicyId;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;

/**
*
* @author yulian oifa
*
*/
public class TransferPolicyImpl extends DiameterGroupedAvpImpl implements TransferPolicy
{
	private TransferPolicyId transferPolicyId;
	
	private TimeWindow timeWindow;
	
	private RatingGroup ratingGroup;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	protected TransferPolicyImpl() 
	{
	}
	
	public TransferPolicyImpl(Long transferPolicyId) throws MissingAvpException
	{
		setTransferPolicyId(transferPolicyId);
	}
	
	public Long getTransferPolicyId()
	{
		if(transferPolicyId==null)
			return null;
		
		return transferPolicyId.getUnsigned();
	}
	
	public void setTransferPolicyId(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Transfer-Policy-Id is required is required", Arrays.asList(new DiameterAvp[] { new TransferPolicyIdImpl() }));
		
		this.transferPolicyId = new TransferPolicyIdImpl(value, null, null);				
	}
	
	public TimeWindow getTimeWindow()
	{
		return this.timeWindow;
	}
	
	public void setTimeWindow(TimeWindow value)
	{
		this.timeWindow = value;
	}
	
	public Long getRatingGroup()
	{
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value)
	{
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL==null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL==null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(transferPolicyId==null)
			return new MissingAvpException("Transfer-Policy-Id is required is required", Arrays.asList(new DiameterAvp[] { new TransferPolicyIdImpl() }));
		
		return null;
	}
}