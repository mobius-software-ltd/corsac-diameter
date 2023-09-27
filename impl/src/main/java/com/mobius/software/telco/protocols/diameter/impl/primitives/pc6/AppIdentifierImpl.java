package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AppIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.OSAppID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.OSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3840L, vendorId = KnownVendorIDs.TGPP_ID)
public class AppIdentifierImpl extends DiameterGroupedAvpImpl implements AppIdentifier
{
	private OSID osID;
	private OSAppID osAppID;
	 
	protected AppIdentifierImpl() 
	{
	}
	
	public AppIdentifierImpl(ByteBuf osID,String osAppID)
	{
		if(osID==null)
			throw new IllegalArgumentException("OS-ID is required");
		
		if(osAppID==null)
			throw new IllegalArgumentException("OS-App-ID is required");
		
		this.osID = new OSIDImpl(osID, null, null);				
		
		this.osAppID = new OSAppIDImpl(osAppID, null, null);
	}
	
	public ByteBuf getOSID()
	{
		if(osID==null)
			return null;
		
		return osID.getValue();
	}
	
	public void setOSID(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("OS-ID is required");
		
		this.osID = new OSIDImpl(value, null, null);						
	}
	
	public String getOSAppID()
	{
		if(osAppID==null)
			return null;
		
		return osAppID.getString();
	}
	
	public void setOSAppID(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("OS-App-ID is required");
		
		this.osAppID = new OSAppIDImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(osID==null)
			return "OS-ID is required";
		
		if(osAppID==null)
			return "OS-App-ID is required";
		
		return null;
	}
}