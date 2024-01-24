package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredMTLRData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2547L, vendorId = KnownVendorIDs.TGPP_ID)
public class DeferredMTLRDataImpl extends DiameterGroupedAvpImpl implements DeferredMTLRData
{
	private DeferredLocationType deferredLocationType;
	
	private TerminationCause terminationCause;
	
	private ServingNode servingNode;
	
	protected DeferredMTLRDataImpl() 
	{
	}
	
	public DeferredMTLRDataImpl(DeferredLocationType deferredLocationType)
	{
		setDeferredLocationType(deferredLocationType);
	}
	
	public DeferredLocationType getDeferredLocationType()
	{
		return deferredLocationType;
	}
	
	public void setDeferredLocationType(DeferredLocationType value)
	{
		if(value==null)
			throw new IllegalArgumentException("Deferred-Location-Type is required");
		
		this.deferredLocationType = value;
	}
	
	public Long getTerminationCause()
	{
		if(terminationCause==null)
			return null;
		
		return terminationCause.getUnsigned();
	}
	
	public void setTerminationCause(Long value)
	{
		if(value==null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(value, null, null);			
	}
	
	public ServingNode getServingNode()
	{
		return servingNode;
	}
	
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(deferredLocationType==null)
			return "Deferred-Location-Type is required";
		
		return null;
	}
}