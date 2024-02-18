package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RANNASReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnhancedDiagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANNASReleaseCause;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class EnhancedDiagnosticsImpl implements EnhancedDiagnostics
{
	private List<RANNASReleaseCause> ranNASReleaseCause;
	
	public EnhancedDiagnosticsImpl()
	{
		
	}
	
	public List<ByteBuf> getRANNASReleaseCause()
	{
		if(ranNASReleaseCause==null || ranNASReleaseCause.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RANNASReleaseCause curr:ranNASReleaseCause)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setRANNASReleaseCause(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ranNASReleaseCause = null;
		else
		{
			this.ranNASReleaseCause = new ArrayList<RANNASReleaseCause>();
			for(ByteBuf curr:value)
				this.ranNASReleaseCause.add(new RANNASReleaseCauseImpl(curr, null, null));
		}
	}	
}