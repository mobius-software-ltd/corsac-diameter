package com.mobius.software.telco.protocols.diameter.impl.primitives.s6m;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMRPSMEAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.PriorityIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPSMEA;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.T4Parameters;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndication;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class T4ParametersImpl extends DiameterGroupedAvpImpl implements T4Parameters
{
	private PriorityIndication priorityIndication;
	
	private SMRPSMEA smRPSMEA;
	
	public T4ParametersImpl()
	{
		
	}
	
	public PriorityIndicationEnum getPriorityIndication()
	{
		if(priorityIndication==null)
			return null;
		
		return priorityIndication.getEnumerated(PriorityIndicationEnum.class);
	}
	
	public void setPriorityIndication(PriorityIndicationEnum value)
	{
		if(value == null)
			this.priorityIndication = null;
		else
			this.priorityIndication = new PriorityIndicationImpl(value, null, null);
	}
	
	public ByteBuf getSMRPSMEA()
	{
		if(smRPSMEA == null)
			return null;
		
		return smRPSMEA.getValue();
	}
	
	public void setSMRPSMEA(ByteBuf value)
	{
		if(value == null)
			this.smRPSMEA = null;
		else
			this.smRPSMEA = new SMRPSMEAImpl(value, null, null);
	}
}