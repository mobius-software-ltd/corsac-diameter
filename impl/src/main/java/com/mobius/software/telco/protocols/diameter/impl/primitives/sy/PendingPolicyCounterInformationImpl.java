package com.mobius.software.telco.protocols.diameter.impl.primitives.sy;
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
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatus;

/**
*
* @author yulian oifa
*
*/
public class PendingPolicyCounterInformationImpl extends DiameterGroupedAvpImpl implements PendingPolicyCounterInformation
{
	private PolicyCounterStatus policyCounterStatus;
	
	private PendingPolicyCounterChangeTime pendingPolicyCounterChangeTime;
	
	protected PendingPolicyCounterInformationImpl()
	{
	}
	
	public PendingPolicyCounterInformationImpl(String policyCounterStatus,Date pendingPolicyCounterChangeTime) throws MissingAvpException
	{
		setPolicyCounterStatus(policyCounterStatus);
		
		setPendingPolicyCounterChangeTime(pendingPolicyCounterChangeTime);
	}
	
	public String getPolicyCounterStatus()
	{
		if(policyCounterStatus==null)
			return null;
		
		return policyCounterStatus.getString();
	}
	
	public void setPolicyCounterStatus(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Policy-Counter-Status is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterStatusImpl() }));
		
		this.policyCounterStatus = new PolicyCounterStatusImpl(value, null, null);
	}
	
	public Date getPendingPolicyCounterChangeTime()
	{
		if(pendingPolicyCounterChangeTime==null)
			return null;
		
		return pendingPolicyCounterChangeTime.getDateTime();
	}

	public void setPendingPolicyCounterChangeTime(Date value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Pending-Policy-Counter-Change-Time is required", Arrays.asList(new DiameterAvp[] { new PendingPolicyCounterChangeTimeImpl() }));
		
		this.pendingPolicyCounterChangeTime = new PendingPolicyCounterChangeTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(policyCounterStatus==null)
			return new MissingAvpException("Policy-Counter-Status is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterStatusImpl() }));
		
		if(pendingPolicyCounterChangeTime==null)
			return new MissingAvpException("Pending-Policy-Counter-Change-Time is required", Arrays.asList(new DiameterAvp[] { new PendingPolicyCounterChangeTimeImpl() }));
		
		return null;
	}
}