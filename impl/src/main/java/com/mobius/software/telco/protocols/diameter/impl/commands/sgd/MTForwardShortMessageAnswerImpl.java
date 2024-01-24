package com.mobius.software.telco.protocols.diameter.impl.commands.sgd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MTForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.AbsentUserDiagnosticSMImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.RequestedRetransmissionTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMRPUIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.AbsentUserDiagnosticSM;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.RequestedRetransmissionTime;
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
@DiameterCommandImplementation(applicationId = 16777313, commandCode = 8388646, request = false)
public class MTForwardShortMessageAnswerImpl extends SgdAnswerImpl implements MTForwardShortMessageAnswer
{
	private AbsentUserDiagnosticSM absentUserDiagnosticSM;
	 
	private SMDeliveryFailureCause smDeliveryFailureCause;
	
	private SMRPUI smRPUI;
	
	private RequestedRetransmissionTime requestedRetransmissionTime;
	
	private UserIdentifier userIdentifier;
	
	private EPSLocationInformation epsLocationInformation;
	
	protected MTForwardShortMessageAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
	}
	
	public MTForwardShortMessageAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(true);
	}
	
	@Override
	public Long getAbsentUserDiagnosticSM()
	{
		if(absentUserDiagnosticSM == null)
			return null;
		
		return absentUserDiagnosticSM.getUnsigned();
	}
	 
	@Override
	public void setAbsentUserDiagnosticSM(Long value)
	{
		if(value == null)
			this.absentUserDiagnosticSM = null;
		else
			this.absentUserDiagnosticSM = new AbsentUserDiagnosticSMImpl(value, null, null);
	}
	
	@Override
	public SMDeliveryFailureCause getSMDeliveryFailureCause()
	{
		return this.smDeliveryFailureCause;
	}
	 
	@Override
	public void setSMDeliveryFailureCause(SMDeliveryFailureCause value)
	{
		this.smDeliveryFailureCause = value;
	}
	
	@Override
	public ByteBuf getSMRPUI()
	{
		if(smRPUI == null)
			return null;
		
		return smRPUI.getValue();
	}
	
	@Override
	public void setSMRPUI(ByteBuf value)
	{
		if(value == null)
			this.smRPUI = null;
		else
			this.smRPUI = new SMRPUIImpl(value, null, null);
	}
	
	@Override
	public UserIdentifier getUserIdentifier() 
	{
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			this.userIdentifier = null;
		else
			this.userIdentifier = value;
	}
	
	@Override
	public Date getRequestedRetransmissionTime()
	{
		if(requestedRetransmissionTime == null)
			return null;
		
		return requestedRetransmissionTime.getDateTime();
	}
	 
	@Override
	public void setRequestedRetransmissionTime(Date value)
	{
		if(value == null)
			this.requestedRetransmissionTime = null;
		else
			this.requestedRetransmissionTime = new RequestedRetransmissionTimeImpl(value, null, null);
	}
	
	@Override
	public EPSLocationInformation getEPSLocationInformation()
	{
		return this.epsLocationInformation;
	}
	 
	@Override
	public void setEPSLocationInformation(EPSLocationInformation value)
	{
		this.epsLocationInformation = value;
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
		
		result.add(absentUserDiagnosticSM);
		result.add(smDeliveryFailureCause);
		result.add(smRPUI);
		result.add(requestedRetransmissionTime);
		result.add(userIdentifier);
		result.add(epsLocationInformation);
		
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