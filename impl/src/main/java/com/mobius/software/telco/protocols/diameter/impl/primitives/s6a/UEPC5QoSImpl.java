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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5LinkAMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5QoSFlow;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEPC5QoS;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1711L, vendorId = KnownVendorIDs.TGPP_ID)
public class UEPC5QoSImpl extends DiameterGroupedAvpImpl implements UEPC5QoS
{
	private List<PC5QoSFlow> pc5QoSFlow;
	
	private PC5LinkAMBR pc5LinkAMBR;
	
	protected UEPC5QoSImpl()
	{
		
	}
	
	public UEPC5QoSImpl(List<PC5QoSFlow> pc5QoSFlow)
	{
		if(pc5QoSFlow == null || pc5QoSFlow.size()==0)
			throw new IllegalArgumentException("PC5-QoS-Flow is required");
		
		this.pc5QoSFlow = pc5QoSFlow;
	}
	
	public List<PC5QoSFlow> getPC5QoSFlow()
	{
		return pc5QoSFlow;
	}
	
	public void setPC5QoSFlow(List<PC5QoSFlow> value)
	{
		if(value == null || value.size()==0)
			throw new IllegalArgumentException("PC5-QoS-Flow is required");
		
		this.pc5QoSFlow = value;
	}
	
	public Integer getPC5LinkAMBR()
	{
		if(pc5LinkAMBR==null)
			return null;
		
		return pc5LinkAMBR.getInteger();
	}
	
	public void setPC5LinkAMBR(Integer value)
	{
		if(value == null)
			this.pc5LinkAMBR = null;
		else
			this.pc5LinkAMBR = new PC5LinkAMBRImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(pc5QoSFlow==null || pc5QoSFlow.size()==0)
			return "PC5-QoS-Flow is required";
		
		return null;
	}
}