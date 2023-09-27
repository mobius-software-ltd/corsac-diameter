package com.mobius.software.telco.protocols.diameter.impl.primitives.pc2;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetPDUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetRPAUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.BannedUserTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetPDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetRPAUID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3611L, vendorId = KnownVendorIDs.TGPP_ID)
public class BannedUserTargetImpl extends DiameterGroupedAvpImpl implements BannedUserTarget
{
	private TargetRPAUID targetRPAUID;
	private TargetPDUID targetPDUID;

	protected BannedUserTargetImpl() 
	{
	}
	
	public BannedUserTargetImpl(String targetRPAUID,ByteBuf targetPDUID)
	{
		if(targetRPAUID==null)
			throw new IllegalArgumentException("Target-RPAUID is required");
		
		if(targetPDUID==null)
			throw new IllegalArgumentException("Target-PDUID is required");
		
		this.targetRPAUID = new TargetRPAUIDImpl(targetRPAUID, null, null);				
		
		this.targetPDUID = new TargetPDUIDImpl(targetPDUID, null, null);
	}
	
	public String getTargetRPAUID()
	{
		if(targetRPAUID==null)
			return null;
		
		return targetRPAUID.getString();
	}
	
	public void setTargetRPAUID(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Target-RPAUID is required");
		
		this.targetRPAUID = new TargetRPAUIDImpl(value, null, null);						
	}
	
	public ByteBuf getTargetPDUID()
	{
		if(targetPDUID==null)
			return null;
		
		return targetPDUID.getValue();
	}
	
	public void TargetPDUID(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Target-PDUID is required");
		
		this.targetPDUID = new TargetPDUIDImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(targetRPAUID==null)
			return "Target-RPAUID is required";
		
		if(targetPDUID==null)
			return "Target-PDUID is required";
		
		return null;
	}
}