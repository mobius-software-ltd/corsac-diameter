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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.FiveQI;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5FlowBitrates;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5QoSFlow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5Range;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1712L, vendorId = KnownVendorIDs.TGPP_ID)
public class PC5QoSFlowImpl extends DiameterGroupedAvpImpl implements PC5QoSFlow
{
	private FiveQI fiveQI;
	
	private PC5FlowBitrates pc5FlowBitrates;
	
	private PC5Range pc5Range;
	
	protected PC5QoSFlowImpl()
	{
		
	}
	
	public PC5QoSFlowImpl(Integer fiveQI)
	{
		if(fiveQI==null)
			throw new IllegalArgumentException("5QI is required");
		
		this.fiveQI = new FiveQIImpl(fiveQI, null, null);
	}
	
	public Integer getFiveQI()
	{
		if(fiveQI==null)
			return null;
		
		return fiveQI.getInteger();
	}
	
	public void setFiveQI(Integer value)
	{
		if(value==null)
			throw new IllegalArgumentException("5QI is required");
		
		this.fiveQI = new FiveQIImpl(value, null, null);	
	}
	
	public PC5FlowBitrates getPC5FlowBitrates()
	{
		return pc5FlowBitrates;
	}
	
	public void setPC5FlowBitrates(PC5FlowBitrates value)
	{
		this.pc5FlowBitrates = value;
	}
	
	public Integer getPC5Range()
	{
		if(pc5Range==null)
			return null;
		
		return pc5Range.getInteger();				
	}
	
	public void setPC5Range(Integer value)
	{
		if(value==null)
			this.pc5Range = null;
		else
			this.pc5Range = new PC5RangeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(fiveQI==null)
			return "5QI is required";
		
		return null;
	}
}