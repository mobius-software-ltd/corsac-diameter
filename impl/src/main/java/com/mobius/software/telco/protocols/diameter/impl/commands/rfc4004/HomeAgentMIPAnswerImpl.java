package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFAtoHASPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFAtoMNSPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegReplyImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNSPI;
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
public class HomeAgentMIPAnswerImpl extends DiameterAnswerWithSessionBase implements HomeAgentMIPAnswer
{
	private AuthApplicationId authApplicationId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private MIPRegReply mipRegReply;
	
	private MIPHomeAgentAddress mipHomeAgentAddress;
	
	private MIPMobileNodeAddress mipMobileNodeAddress;
	
	private MIPFAtoHASPI mipFAtoHASPI;
	
	private MIPFAtoMNSPI mipFAtoMNSPI;
	
	protected HomeAgentMIPAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public HomeAgentMIPAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		setAuthApplicationId(authApplicationId);
	}

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId == null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public void setAuthApplicationId(Long value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Auth-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
			
		this.authApplicationId = new AuthApplicationIdImpl(value, null, null);
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
	
	@Override
	public Long getMIPFAtoHASPI()
	{
		if(mipFAtoHASPI == null)
			return null;
		
		return mipFAtoHASPI.getUnsigned();
	}
	
	@Override
	public void setMIPFAtoHASPI(Long value)
	{
		if(value == null)
			this.mipFAtoHASPI = null;
		else
			this.mipFAtoHASPI = new MIPFAtoHASPIImpl(value, null, null);
	}
	
	@Override
	public Long getMIPFAtoMNSPI()
	{
		if(mipFAtoMNSPI == null)
			return null;
		
		return mipFAtoMNSPI.getUnsigned();
	}
	
	@Override
	public void setMIPFAtoMNSPI(Long value)
	{
		if(value == null)
			this.mipFAtoMNSPI = null;
		else
			this.mipFAtoMNSPI = new MIPFAtoMNSPIImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authApplicationId==null)
			return new MissingAvpException("Auth-Application-Id is required", Arrays.asList(new DiameterAvp[] { new AuthApplicationIdImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(acctMultiSessionId);
		result.add(username);
        result.add(errorReportingHost);
        result.add(errorMessage);
        result.add(mipRegReply);
		result.add(mipHomeAgentAddress);
		result.add(mipMobileNodeAddress);
		result.add(mipFAtoHASPI);
		result.add(mipFAtoMNSPI);
		result.add(originStateId);
		
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
        
        return result;
	}
}