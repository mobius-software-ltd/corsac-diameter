package com.mobius.software.telco.protocols.diameter.impl.primitives.s6m;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.LMSIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.slh.LMSI;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class UserIdentifierImpl extends DiameterGroupedAvpImpl implements UserIdentifier
{
	private UserName userName;
	
	private MSISDN msisdn;
	
	private ExternalIdentifier externalIdentifier;
	
	private LMSI lmsi;
	
	public UserIdentifierImpl()
	{
		
	}
	
	public String getUserName()
	{
		if(userName==null)
			return null;
		
		return userName.getString();
	}
	
	public void setUserName(String value)
	{
		if(value==null)
			this.userName = null;
		else
			this.userName = new UserNameImpl(value, null, null);
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value==null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value==null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
	}
	
	public ByteBuf getLMSI()
	{
		if(lmsi==null)
			return null;
		
		return lmsi.getValue();
	}
	
	public void setLMSI(ByteBuf value)
	{
		if(value==null)
			this.lmsi = null;
		else
			this.lmsi = new LMSIImpl(value, null, null);
	}
}