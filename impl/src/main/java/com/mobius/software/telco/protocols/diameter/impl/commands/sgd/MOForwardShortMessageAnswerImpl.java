package com.mobius.software.telco.protocols.diameter.impl.commands.sgd;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MOForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMRPUIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDeliveryFailureCause;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMRPUI;

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
public class MOForwardShortMessageAnswerImpl extends SgdAnswerImpl implements MOForwardShortMessageAnswer
{
	private SMDeliveryFailureCause smDeliveryFailureCause;
	
	private SMRPUI smRPUI;
	
	private ExternalIdentifier externalIdentifier;
	 
	protected MOForwardShortMessageAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
	}
	
	public MOForwardShortMessageAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(true);
	}
		
	@Override
	public SMDeliveryFailureCause getSMDeliveryFailureCause()
	{
		return smDeliveryFailureCause;
	}
	
	@Override
	public void setSMDeliveryFailureCause(SMDeliveryFailureCause value)
	{
		this.smDeliveryFailureCause = value;
	}
	
	@Override
	public ByteBuf getSMRPUI()
	{
		if(smRPUI==null)
			return null;
		
		return smRPUI.getValue();
	}
	
	@Override
	public void setSMRPUI(ByteBuf value)
	{
		if(value==null)
			this.smRPUI = null;
		else
			this.smRPUI = new SMRPUIImpl(value, null, null);
	}
	 		
	@Override
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	 
	@Override
	public void setExternalIdentifier(String value)
	{
		if(value==null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(smDeliveryFailureCause);
		result.add(smRPUI);
		result.add(externalIdentifier);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}