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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatus;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatusReport;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2903L, vendorId = KnownVendorIDs.TGPP_ID)
public class PolicyCounterStatusReportImpl extends DiameterGroupedAvpImpl implements PolicyCounterStatusReport
{
	private PolicyCounterIdentifier policyCounterIdentifier;
	
	private PolicyCounterStatus policyCounterStatus;
	
	private List<PendingPolicyCounterInformation> pendingPolicyCounterInformation;
	
	protected PolicyCounterStatusReportImpl() 
	{
	}
	
	public PolicyCounterStatusReportImpl(String policyCounterIdentifier,String policyCounterStatus)
	{
		if(policyCounterIdentifier==null)
			throw new IllegalArgumentException("Transfer-Policy-Id is required");
		
		if(policyCounterStatus==null)
			throw new IllegalArgumentException("Policy-Counter-Status is required");
		
		this.policyCounterIdentifier = new PolicyCounterIdentifierImpl(policyCounterIdentifier, null, null);				
		
		this.policyCounterStatus = new PolicyCounterStatusImpl(policyCounterStatus, null, null);
	}
	
	public String getPolicyCounterIdentifier()
	{
		if(policyCounterIdentifier==null)
			return null;
		
		return policyCounterIdentifier.getString();
	}
	
	public void setPolicyCounterIdentifier(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Policy-Counter-Identifier is required");
		
		this.policyCounterIdentifier = new PolicyCounterIdentifierImpl(value, null, null);				
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
	
	public List<PendingPolicyCounterInformation> getPendingPolicyCounterInformation()
	{
		return this.pendingPolicyCounterInformation;
	}
	
	public void setPendingPolicyCounterInformation(List<PendingPolicyCounterInformation> value)
	{
		this.pendingPolicyCounterInformation = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(policyCounterIdentifier==null)
			return "Policy-Counter-Identifier is required";
		
		if(policyCounterStatus==null)
			return "Policy-Counter-Status is required";
		
		return null;
	}
}