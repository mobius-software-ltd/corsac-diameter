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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NrCgi;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSCellInfo;

/**
*
* @author yulian oifa
*
*/
public class PSCellInfoImpl extends DiameterAvpImpl implements PSCellInfo
{
	private NrCgi nrCgi;
	
	public PSCellInfoImpl()
	{
		
	}
	
	public String getNrCgi()
	{
		if(nrCgi==null)
			return null;
		
		return nrCgi.getString();
	}
	
	public void setNrCgi(String value)
	{
		if(value==null)
			this.nrCgi = null;
		else
			this.nrCgi = new NrCgiImpl(value, null, null);			
	}
}