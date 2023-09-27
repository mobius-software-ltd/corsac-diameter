package com.mobius.software.telco.protocols.diameter.impl.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelRange;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelSetId;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4002L, vendorId = KnownVendorIDs.TGPP_ID)
public class CongestionLevelDefinitionImpl extends DiameterGroupedAvpImpl implements CongestionLevelDefinition
{
	private CongestionLevelSetId congestionLevelSetId;
	
	private CongestionLevelRange congestionLevelRange;
	
	protected CongestionLevelDefinitionImpl()
	{
		
	}
	
	public CongestionLevelDefinitionImpl(Long congestionLevelSetId,Long congestionLevelRange)
	{
		if(congestionLevelSetId == null)
			throw new IllegalArgumentException("Congestion-Level-Set-Id is required");
		
		if(congestionLevelRange == null)
			throw new IllegalArgumentException("Congestion-Level-Range is required");
		
		this.congestionLevelSetId = new CongestionLevelSetIdImpl(congestionLevelSetId, null, null);
		
		this.congestionLevelRange = new CongestionLevelRangeImpl(congestionLevelRange, null, null);
	}
	
	public Long getCongestionLevelSetId()
	{
		if(congestionLevelSetId==null)
			return null;
		
		return this.congestionLevelSetId.getUnsigned();
	}
	
	public void setCongestionLevelSetId(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Congestion-Level-Set-Id is required");
		
		this.congestionLevelSetId = new CongestionLevelSetIdImpl(value, null, null);		
	}
	
	public Long getCongestionLevelRange()
	{
		if(congestionLevelRange==null)
			return null;
		
		return this.congestionLevelRange.getUnsigned();
	}
	
	public void setCongestionLevelRange(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Congestion-Level-Range is required");
		
		this.congestionLevelRange = new CongestionLevelRangeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(congestionLevelSetId == null)
			return "Congestion-Level-Set-Id is required";
		
		if(congestionLevelRange == null)
			return "Congestion-Level-Range is required";
		
		return null;
	}
}