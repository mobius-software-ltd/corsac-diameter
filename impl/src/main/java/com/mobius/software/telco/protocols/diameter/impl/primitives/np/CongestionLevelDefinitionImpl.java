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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelRange;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelSetId;

/**
*
* @author yulian oifa
*
*/
public class CongestionLevelDefinitionImpl extends DiameterGroupedAvpImpl implements CongestionLevelDefinition
{
	private CongestionLevelSetId congestionLevelSetId;
	
	private CongestionLevelRange congestionLevelRange;
	
	protected CongestionLevelDefinitionImpl()
	{
		
	}
	
	public CongestionLevelDefinitionImpl(Long congestionLevelSetId,CongestionLevelRange congestionLevelRange) throws MissingAvpException
	{
		setCongestionLevelSetId(congestionLevelSetId);
		
		setCongestionLevelRange(congestionLevelRange);
	}
	
	public Long getCongestionLevelSetId()
	{
		if(congestionLevelSetId==null)
			return null;
		
		return this.congestionLevelSetId.getUnsigned();
	}
	
	public void setCongestionLevelSetId(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Congestion-Level-Set-Id is required", Arrays.asList(new DiameterAvp[] { new CongestionLevelSetIdImpl() }));
			
		this.congestionLevelSetId = new CongestionLevelSetIdImpl(value, null, null);		
	}
	
	public CongestionLevelRange getCongestionLevelRange()
	{
		return this.congestionLevelRange;
	}
	
	public void setCongestionLevelRange(CongestionLevelRange value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Congestion-Level-Set-Range is required", Arrays.asList(new DiameterAvp[] { new CongestionLevelRangeImpl() }));
			
		this.congestionLevelRange = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(congestionLevelSetId == null)
			return new MissingAvpException("Congestion-Level-Set-Id is required", Arrays.asList(new DiameterAvp[] { new CongestionLevelSetIdImpl() }));
		
		if(congestionLevelRange == null)
			return new MissingAvpException("Congestion-Level-Set-Range is required", Arrays.asList(new DiameterAvp[] { new CongestionLevelRangeImpl() }));
		
		return null;
	}
}