package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.FECResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.UserplaneProtocolResult;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

/**
*
* @author yulian oifa
*
*/
public class UserplaneProtocolResultImpl extends DiameterGroupedAvpImpl implements UserplaneProtocolResult
{
	private List<FlowDescription> flowDescription;
	
	private ROHCResult rohcResult;
	
	private FECResult fecResult;
	
	public UserplaneProtocolResultImpl()
	{
		
	}
	
	public List<FlowDescription> getFlowDescription()
	{
		return flowDescription;
	}
	
	public void setFlowDescription(List<FlowDescription> value)
	{
		this.flowDescription = value;				
	}
	
	public ROHCResult getROHCResult()
	{
		return rohcResult;
	}
	
	public void setROHCResult(ROHCResult value)
	{
		this.rohcResult = value;			
	}
	
	public FECResult getFECResult()
	{
		return fecResult;
	}
	
	public void setFECResult(FECResult value)
	{
		this.fecResult = value;			
	}
}