package com.mobius.software.telco.protocols.diameter.impl.commands.gmb;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AAAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.AlternativeAPNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RequiredMBMSBearerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.AlternativeAPN;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RequiredMBMSBearerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;

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
@DiameterCommandImplementation(applicationId = 16777223, commandCode = 271, request = false)
public class AAAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements AAAnswer
{
	private AlternativeAPN alternativeAPN;
	
	private TGPPIMSI tgppIMSI;
	
	private TMGI tmgi;
	
	private RequiredMBMSBearerCapabilities requiredMBMSBearerCapabilities;
	
	
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public String getAlternativeAPN() 
	{
		if(alternativeAPN == null)
			return null;
		
		return alternativeAPN.getString();
	}

	@Override
	public void setAlternativeAPN(String value) 
	{
		if(value == null)
			this.alternativeAPN = null;
		else
			this.alternativeAPN = new AlternativeAPNImpl(value, null, null);
	}

	@Override
	public String getTGPPIMSI() 
	{
		if(tgppIMSI == null)
			return null;
		
		return tgppIMSI.getString();
	}

	@Override
	public void setTGPPIMSI(String value) 
	{
		if(value == null)
			this.tgppIMSI = null;
		else
			this.tgppIMSI = new TGPPIMSIImpl(value, null, null);
	}

	@Override
	public ByteBuf getTMGI() 
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}

	@Override
	public void setTMGI(ByteBuf value) 
	{
		if(value == null)
			this.tmgi = null;
		else
			this.tmgi = new TMGIImpl(value, null, null);
	}

	@Override
	public String getRequiredMBMSBearerCapabilities() 
	{
		if(requiredMBMSBearerCapabilities==null)
			return null;
		
		return requiredMBMSBearerCapabilities.getString();
	}

	@Override
	public void setRequiredMBMSBearerCapabilities(String value) 
	{
		if(value == null)
			this.requiredMBMSBearerCapabilities = null;
		else
			this.requiredMBMSBearerCapabilities = new RequiredMBMSBearerCapabilitiesImpl(value, null, null);
	}
}