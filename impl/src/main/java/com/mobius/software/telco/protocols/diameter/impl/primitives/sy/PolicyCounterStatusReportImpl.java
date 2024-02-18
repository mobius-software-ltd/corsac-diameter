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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PendingPolicyCounterInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatus;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatusReport;

/**
*
* @author yulian oifa
*
*/
public class PolicyCounterStatusReportImpl extends DiameterGroupedAvpImpl implements PolicyCounterStatusReport
{
	private PolicyCounterIdentifier policyCounterIdentifier;
	
	private PolicyCounterStatus policyCounterStatus;
	
	private List<PendingPolicyCounterInformation> pendingPolicyCounterInformation;
	
	protected PolicyCounterStatusReportImpl() 
	{
	}
	
	public PolicyCounterStatusReportImpl(String policyCounterIdentifier,String policyCounterStatus) throws MissingAvpException
	{
		setPolicyCounterIdentifier(policyCounterIdentifier);
		
		setPolicyCounterStatus(policyCounterStatus);		
	}
	
	public String getPolicyCounterIdentifier()
	{
		if(policyCounterIdentifier==null)
			return null;
		
		return policyCounterIdentifier.getString();
	}
	
	public void setPolicyCounterIdentifier(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Policy-Counter-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterIdentifierImpl() }));
		
		this.policyCounterIdentifier = new PolicyCounterIdentifierImpl(value, null, null);				
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
			throw new MissingAvpException("Policy-Counter-Status is required is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterStatusImpl() }));
		
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
	public DiameterException validate()
	{
		if(policyCounterIdentifier==null)
			return new MissingAvpException("Policy-Counter-Identifier is required is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterIdentifierImpl() }));
		
		if(policyCounterStatus==null)
			return new MissingAvpException("Policy-Counter-Status is required is required", Arrays.asList(new DiameterAvp[] { new PolicyCounterStatusImpl() }));
		
		return null;
	}
}