package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSClassIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1431L, vendorId = KnownVendorIDs.TGPP_ID)
public class EPSSubscribedQoSProfileImpl extends DiameterGroupedAvpImpl implements EPSSubscribedQoSProfile
{
	private QoSClassIdentifier qoSClassIdentifier;
	
	private AllocationRetentionPriority allocationRetentionPriority;
	
	protected EPSSubscribedQoSProfileImpl()
	{
		
	}
	
	public EPSSubscribedQoSProfileImpl(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority)
	{
		if(qoSClassIdentifier==null)
			throw new IllegalArgumentException("QoS-Class-Identifier is required");
		
		if(allocationRetentionPriority==null)
			throw new IllegalArgumentException("Allocation-Retention-Priority is required");
		
		this.qoSClassIdentifier = new QoSClassIdentifierImpl(qoSClassIdentifier, null, null);
		
		this.allocationRetentionPriority = allocationRetentionPriority;				
	}
	
	public QoSClassIdentifierEnum getQoSClassIdentifier()
	{
		if(qoSClassIdentifier==null)
			return null;
		
		return qoSClassIdentifier.getEnumerated(QoSClassIdentifierEnum.class);
	}
	
	public void setQoSClassIdentifier(QoSClassIdentifierEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("QoS-Class-Identifier is required");
		
		this.qoSClassIdentifier = new QoSClassIdentifierImpl(value, null, null);
		
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority()
	{
		return allocationRetentionPriority;
	}
	
	public void setAllocationRetentionPriority(AllocationRetentionPriority value)
	{
		if(value==null)
			throw new IllegalArgumentException("Allocation-Retention-Priority is required");
		
		this.allocationRetentionPriority = value;				
	}
	
	@DiameterValidate
	public String validate()
	{
		if(qoSClassIdentifier==null)
			return "QoS-Class-Identifier is required";
		
		if(allocationRetentionPriority==null)
			return "Allocation-Retention-Priority is required";
		
		return null;
	}
}