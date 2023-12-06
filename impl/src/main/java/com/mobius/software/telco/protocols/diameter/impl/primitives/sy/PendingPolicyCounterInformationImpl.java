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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatus;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2905L, vendorId = KnownVendorIDs.TGPP_ID)
public class PendingPolicyCounterInformationImpl extends DiameterGroupedAvpImpl implements PendingPolicyCounterInformation
{
	private PolicyCounterStatus policyCounterStatus;
	
	private PendingPolicyCounterChangeTime pendingPolicyCounterChangeTime;
	
	public PendingPolicyCounterInformationImpl()
	{
	}
	
	public PendingPolicyCounterInformationImpl(String policyCounterStatus,Date pendingPolicyCounterChangeTime)
	{
		if(policyCounterStatus==null)
			throw new IllegalArgumentException("Policy-Counter-Status is required");
		
		if(pendingPolicyCounterChangeTime==null)
			throw new IllegalArgumentException("Pending-Policy-Counter-Change-Time is required");
		
		this.policyCounterStatus = new PolicyCounterStatusImpl(policyCounterStatus, null, null);				
		
		this.pendingPolicyCounterChangeTime = new PendingPolicyCounterChangeTimeImpl(pendingPolicyCounterChangeTime, null, null);
	}
	
	public String getPolicyCounterStatus()
	{
		if(policyCounterStatus==null)
			return null;
		
		return policyCounterStatus.getString();
	}
	
	public void setPolicyCounterStatus(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Policy-Counter-Status is required");
		
		this.policyCounterStatus = new PolicyCounterStatusImpl(value, null, null);
	}
	
	public Date getPendingPolicyCounterChangeTime()
	{
		if(pendingPolicyCounterChangeTime==null)
			return null;
		
		return pendingPolicyCounterChangeTime.getDateTime();
	}

	public void setPendingPolicyCounterChangeTime(Date value)
	{
		if(value==null)
			throw new IllegalArgumentException("Pending-Policy-Counter-Change-Time is required");
		
		this.pendingPolicyCounterChangeTime = new PendingPolicyCounterChangeTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(policyCounterStatus==null)
			return "Transfer-Policy-Id is required";
		
		if(pendingPolicyCounterChangeTime==null)
			return "Pending-Policy-Counter-Change-Time is required";
		
		return null;
	}
}