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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeSourceIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeUEID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransmitterInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TransmitterInfoImpl implements TransmitterInfo
{
	private ProSeSourceIPAddress proSeSourceIPAddress;
	private ProSeUEID proSeUEID;
		
	public TransmitterInfoImpl()
	{
		
	}
	
	public InetAddress getProSeSourceIPAddress()
	{
		if(proSeSourceIPAddress==null)
			return null;
		
		return proSeSourceIPAddress.getAddress();
	}
	
	public void setProSeSourceIPAddress(InetAddress value)
	{
		if(value==null)
			this.proSeSourceIPAddress = null;
		else
			this.proSeSourceIPAddress = new ProSeSourceIPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getProSeUEID()
	{
		if(proSeUEID==null)
			return null;
		
		return proSeUEID.getValue();
	}
	
	public void setProSeUEID(ByteBuf value)
	{
		if(value==null)
			this.proSeUEID = null;
		else
			this.proSeUEID = new ProSeUEIDImpl(value, null, null);			
	}
}