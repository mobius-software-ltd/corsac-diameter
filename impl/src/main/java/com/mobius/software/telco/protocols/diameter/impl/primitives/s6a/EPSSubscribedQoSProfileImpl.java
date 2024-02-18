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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSClassIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;

/**
*
* @author yulian oifa
*
*/
public class EPSSubscribedQoSProfileImpl extends DiameterGroupedAvpImpl implements EPSSubscribedQoSProfile
{
	private QoSClassIdentifier qoSClassIdentifier;
	
	private AllocationRetentionPriority allocationRetentionPriority;
	
	protected EPSSubscribedQoSProfileImpl()
	{
		
	}
	
	public EPSSubscribedQoSProfileImpl(QoSClassIdentifierEnum qoSClassIdentifier,AllocationRetentionPriority allocationRetentionPriority) throws MissingAvpException
	{
		setQoSClassIdentifier(qoSClassIdentifier);
		
		setAllocationRetentionPriority(allocationRetentionPriority);
	}
	
	public QoSClassIdentifierEnum getQoSClassIdentifier()
	{
		if(qoSClassIdentifier==null)
			return null;
		
		return qoSClassIdentifier.getEnumerated(QoSClassIdentifierEnum.class);
	}
	
	public void setQoSClassIdentifier(QoSClassIdentifierEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("QoS-Class-Identifier is required", Arrays.asList(new DiameterAvp[] { new QoSClassIdentifierImpl() }));
			
		this.qoSClassIdentifier = new QoSClassIdentifierImpl(value, null, null);
		
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority()
	{
		return allocationRetentionPriority;
	}
	
	public void setAllocationRetentionPriority(AllocationRetentionPriority value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Allocation-Retention-Priority is required", Arrays.asList(new DiameterAvp[] { new AllocationRetentionPriorityImpl() }));
			
		this.allocationRetentionPriority = value;				
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(qoSClassIdentifier==null)
			return new MissingAvpException("QoS-Class-Identifier is required", Arrays.asList(new DiameterAvp[] { new QoSClassIdentifierImpl() }));
		
		if(allocationRetentionPriority==null)
			return new MissingAvpException("Allocation-Retention-Priority is required", Arrays.asList(new DiameterAvp[] { new AllocationRetentionPriorityImpl() }));
		
		return null;
	}
}