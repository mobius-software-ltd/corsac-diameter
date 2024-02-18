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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AppIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.OSAppID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.OSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AppIdentifierImpl extends DiameterGroupedAvpImpl implements AppIdentifier
{
	private OSID osID;
	private OSAppID osAppID;
	 
	protected AppIdentifierImpl() 
	{
	}
	
	public AppIdentifierImpl(ByteBuf osID,String osAppID) throws MissingAvpException
	{
		setOSID(osID);
		
		setOSAppID(osAppID);
	}
	
	public ByteBuf getOSID()
	{
		if(osID==null)
			return null;
		
		return osID.getValue();
	}
	
	public void setOSID(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("OS-ID is required", Arrays.asList(new DiameterAvp[] { new OSIDImpl() }));
			
		this.osID = new OSIDImpl(value, null, null);						
	}
	
	public String getOSAppID()
	{
		if(osAppID==null)
			return null;
		
		return osAppID.getString();
	}
	
	public void setOSAppID(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("OS-App-ID is required", Arrays.asList(new DiameterAvp[] { new OSAppIDImpl() }));
		
		this.osAppID = new OSAppIDImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(osID==null)
			return new MissingAvpException("OS-ID is required", Arrays.asList(new DiameterAvp[] { new OSIDImpl() }));
		
		if(osAppID==null)
			return new MissingAvpException("OS-App-ID is required", Arrays.asList(new DiameterAvp[] { new OSAppIDImpl() }));
		
		return null;
	}
}