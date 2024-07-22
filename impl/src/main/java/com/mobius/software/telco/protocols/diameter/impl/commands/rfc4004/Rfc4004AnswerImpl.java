package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.net.InetAddress;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.Rfc4004Answer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegReplyImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPRegReply;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public class Rfc4004AnswerImpl extends AuthenticationAnswerImpl implements Rfc4004Answer
{
	protected AcctMultiSessionId acctMultiSessionId;
	
	protected MIPRegReply mipRegReply;
	
	protected MIPHomeAgentAddress mipHomeAgentAddress;
	
	protected MIPMobileNodeAddress mipMobileNodeAddress;
	
	protected Rfc4004AnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public Rfc4004AnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		setAuthApplicationId(authApplicationId);
	}
	
	@Override
	public String getAcctMultiSessionId() 
	{
		if(acctMultiSessionId == null)
			return null;
		
		return acctMultiSessionId.getString();
	}
	
	@Override
	public void setAcctMultiSessionId(String value)
	{
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMIPRegReply() 
	{
		if(mipRegReply == null)
			return null;
		
		return mipRegReply.getValue();
	}
	
	@Override
	public void setMIPRegReply(ByteBuf value)
	{
		if(value == null)
			this.mipRegReply = null;
		else
			this.mipRegReply = new MIPRegReplyImpl(value, null, null);
	}
	
	@Override
	public InetAddress getMIPHomeAgentAddress()
	{
		if(mipHomeAgentAddress == null)
			return null;
		
		return mipHomeAgentAddress.getAddress();
	}
	
	@Override
	public void setMIPHomeAgentAddress(InetAddress value)
	{
		if(value == null)
			this.mipHomeAgentAddress = null;
		else
			this.mipHomeAgentAddress = new MIPHomeAgentAddressImpl(value, null, null);
	}
	
	@Override
	public InetAddress getMIPMobileNodeAddress()
	{
		if(mipMobileNodeAddress == null)
			return null;
		
		return mipMobileNodeAddress.getAddress();
	}
	
	@Override
	public void setMIPMobileNodeAddress(InetAddress value)
	{
		if(value == null)
			this.mipMobileNodeAddress = null;
		else
			this.mipMobileNodeAddress = new MIPMobileNodeAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authApplicationId==null)
			return new MissingAvpException("Auth-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
		
		return super.validate();
	}
}