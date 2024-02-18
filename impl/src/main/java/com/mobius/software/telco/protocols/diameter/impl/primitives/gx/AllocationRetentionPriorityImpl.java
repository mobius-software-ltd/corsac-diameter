package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionCapability;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionVulnerability;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionVulnerabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PriorityLevel;

/**
*
* @author yulian oifa
*
*/
public class AllocationRetentionPriorityImpl extends DiameterGroupedAvpImpl implements AllocationRetentionPriority
{
	private PriorityLevel priorityLevel;
	private PreEmptionCapability preEmptionCapability;
	private PreEmptionVulnerability preEmptionVulnerability;

	public AllocationRetentionPriorityImpl()
	{
		
	}
	
	public AllocationRetentionPriorityImpl(Long priorityLevel) throws MissingAvpException
	{
		setPriorityLevel(priorityLevel);
	}
	
	public Long getPriorityLevel()
	{
		if(priorityLevel==null)
			return null;
		
		return priorityLevel.getUnsigned();
	}
	
	public void setPriorityLevel(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Priority-Level is required", Arrays.asList(new DiameterAvp[] { new PriorityLevelImpl() }));
		
		this.priorityLevel = new PriorityLevelImpl(value, null, null);				
	}
	
	public PreEmptionCapabilityEnum getPreEmptionCapability()
	{
		if(preEmptionCapability==null)
			return null;
		
		return preEmptionCapability.getEnumerated(PreEmptionCapabilityEnum.class);
	}
	
	public void setPreEmptionCapability(PreEmptionCapabilityEnum value)
	{
		if(value==null)
			this.preEmptionCapability = null;
		else
			this.preEmptionCapability = new PreEmptionCapabilityImpl(value, null, null);			
	}
	
	public PreEmptionVulnerabilityEnum getPreEmptionVulnerability()
	{
		if(preEmptionVulnerability==null)
			return null;
		
		return preEmptionVulnerability.getEnumerated(PreEmptionVulnerabilityEnum.class);
	}
	
	public void setPreEmptionVulnerability(PreEmptionVulnerabilityEnum value)
	{
		if(value==null)
			this.preEmptionVulnerability = null;
		else
			this.preEmptionVulnerability = new PreEmptionVulnerabilityImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(priorityLevel==null)
			return new MissingAvpException("Priority-Level is required", Arrays.asList(new DiameterAvp[] { new PriorityLevelImpl() }));
		
		return null;
	}
}