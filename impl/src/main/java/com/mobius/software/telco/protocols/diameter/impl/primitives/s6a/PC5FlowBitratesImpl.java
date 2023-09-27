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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GuaranteedFlowBitrates;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MaximumFlowBitrates;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PC5FlowBitrates;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1714L, vendorId = KnownVendorIDs.TGPP_ID)
public class PC5FlowBitratesImpl extends DiameterGroupedAvpImpl implements PC5FlowBitrates
{
	private GuaranteedFlowBitrates guaranteedFlowBitrates;
	
	private MaximumFlowBitrates maximumFlowBitrates;
	
	public PC5FlowBitratesImpl()
	{
		
	}
	
	public Integer getGuaranteedFlowBitrates()
	{
		if(guaranteedFlowBitrates==null)
			return null;
		
		return guaranteedFlowBitrates.getInteger();
	}
	
	public void setGuaranteedFlowBitrates(Integer value)
	{
		if(value==null)
			this.guaranteedFlowBitrates = null;
		else
			this.guaranteedFlowBitrates = new GuaranteedFlowBitratesImpl(value, null, null);
	}
	
	public Integer getMaximumFlowBitrates()
	{
		if(maximumFlowBitrates==null)
			return null;
		
		return maximumFlowBitrates.getInteger();
	}
	
	public void setMaximumFlowBitrates(Integer value)
	{
		if(value==null)
			this.maximumFlowBitrates = null;
		else
			this.maximumFlowBitrates = new MaximumFlowBitratesImpl(value, null, null);
	}
}