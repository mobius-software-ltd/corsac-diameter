package com.mobius.software.telco.protocols.diameter.impl.commands.swx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.TGPPAAAServerNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TGPPAAAServerName;

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
@DiameterCommandImplementation(applicationId = 16777265, commandCode = 301, request = false)
public class ServerAssignmentAnswerImpl extends SwxAnswerImpl implements ServerAssignmentAnswer
{
	private Non3GPPUserData non3GPPUserData;
	
	private TGPPAAAServerName tgppAAAServerName;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	 
	protected ServerAssignmentAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ServerAssignmentAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AuthSessionStateEnum authSessionState, String userName)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
		
		setUsername(userName);
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}
	
	@Override
	public Non3GPPUserData getNon3GPPUserData()
	{
		return this.non3GPPUserData;
	}
	
	@Override
	public void setNon3GPPUserData(Non3GPPUserData value)
	{
		this.non3GPPUserData = value;
	}
	
	@Override
	public String get3GPPAAAServerName()
	{
		if(tgppAAAServerName==null)
			return null;
		
		return this.tgppAAAServerName.getIdentity();
	}
	
	@Override
	public void set3GPPAAAServerName(String value)
	{
		if(value==null)
			this.tgppAAAServerName = null;
		else
			this.tgppAAAServerName = new TGPPAAAServerNameImpl(value, null, null);
	}
					 
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	 		
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
    
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
		return super.validate();
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
		result.add(username);
		result.add(non3GPPUserData);
		result.add(tgppAAAServerName);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}