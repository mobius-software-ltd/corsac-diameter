package com.mobius.software.telco.protocols.diameter.impl.commands.slh;

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.slh.LCSRoutingInfoAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.GMLCAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.LMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.PPRAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.RIAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.slh.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.slh.GMLCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slh.LMSI;
import com.mobius.software.telco.protocols.diameter.primitives.slh.PPRAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slh.RIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

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
@DiameterCommandImplementation(applicationId = 16777255, commandCode = 8388620, request = false)
public class LCSRoutingInfoAnswerImpl extends SlhAnswerImpl implements LCSRoutingInfoAnswer
{
	private MSISDN msisdn;
	
	private LMSI lmsi;
	 
	private ServingNode servingNode;
	 
	private List<AdditionalServingNode> additionalServingNode;
	 
	private GMLCAddress gmlcAddress;
	
	private PPRAddress pprAddress;
	
	private RIAFlags riaFlags;
	
	protected LCSRoutingInfoAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public LCSRoutingInfoAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	@Override
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
		
	@Override
	public ByteBuf getLMSI()
	{
		if(lmsi == null)
			return null;
		
		return lmsi.getValue();
	}
	 
	@Override
	public void setLMSI(ByteBuf value)
	{
		if(value == null)
			this.lmsi = null;
		else
			this.lmsi = new LMSIImpl(value, null, null);
	}
	
	@Override
	public ServingNode getServingNode()
	{
		return this.servingNode;
	}
	 
	@Override
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;
	}

	@Override
	public List<AdditionalServingNode> getAdditionalServingNode()
	{
		return this.additionalServingNode;
	}
	 
	@Override
	public void setAdditionalServingNode(List<AdditionalServingNode> value)
	{
		this.additionalServingNode = value;
	}
	
	@Override
	public InetAddress getGMLCAddress()
	{
		if(gmlcAddress == null)
			return null;
		
		return gmlcAddress.getAddress();
	}
	
	@Override
	public void setGMLCAddress(InetAddress value)
	{
		if(value == null)
			this.gmlcAddress = null;
		else
			this.gmlcAddress = new GMLCAddressImpl(value, null, null);
	}
	
	@Override
	public InetAddress getPPRAddress()
	{
		if(pprAddress == null)
			return null;
		
		return pprAddress.getAddress();
	}
	
	@Override
	public void setPPRAddress(InetAddress value)
	{
		if(value == null)
			this.pprAddress = null;
		else
			this.pprAddress = new PPRAddressImpl(value, null, null);
	}
	
	@Override
	public Long getRIAFlags()
	{
		if(riaFlags == null)
			return null;
		
		return riaFlags.getUnsigned();
	}
	 
	@Override
	public void setRIAFlags(Long value)
	{
		if(value == null)
			this.riaFlags = null;
		else
			this.riaFlags = new RIAFlagsImpl(value, null, null);
	}
}