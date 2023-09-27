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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GERANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UTRANVector;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1413L, vendorId = KnownVendorIDs.TGPP_ID)
public class AuthenticationInfoImpl extends DiameterGroupedAvpImpl implements AuthenticationInfo
{
	private List<EUTRANVector> eutranVector;
	
	private List<UTRANVector> utranVector;
	
	private List<GERANVector> geranVector;
	
	public AuthenticationInfoImpl()
	{
		
	}
	
	public List<EUTRANVector> getEUTRANVector()
	{
		return eutranVector;
	}
	
	public void setEUTRANVector(List<EUTRANVector> value)
	{
		this.eutranVector = value;
	}
	
	public List<UTRANVector> getUTRANVector()
	{
		return utranVector;
	}
	
	public void setUTRANVector(List<UTRANVector> value)
	{
		this.utranVector = value;
	}
	
	public List<GERANVector> getGERANVector()
	{
		return geranVector;
	}
	
	public void setGERANVector(List<GERANVector> value)
	{
		this.geranVector = value;
	}
}