package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6t.NIDDInformationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.NIAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupUserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationResponse;

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
@DiameterCommandImplementation(applicationId = 16777345, commandCode = 8388726, request = false)
public class NIDDInformationAnswerImpl extends S6tAnswerImpl implements NIDDInformationAnswer
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private NIDDAuthorizationResponse niddAuthorizationResponse;
	
	private List<GroupUserIdentifier> groupUserIdentifier;
	
	private NIAFlags niaFlags;
	
	protected NIDDInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public NIDDInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	
	@Override
	public NIDDAuthorizationResponse getNIDDAuthorizationResponse() 
	{
		return niddAuthorizationResponse;
	}
	
	@Override
	public void setNIDDAuthorizationResponse(NIDDAuthorizationResponse value)
	{	
		this.niddAuthorizationResponse = value;
	}
	
	@Override
	public List<GroupUserIdentifier> getGroupUserIdentifier() 
	{
		return groupUserIdentifier;
	}
	
	@Override
	public void setGroupUserIdentifier(List<GroupUserIdentifier> value)
	{
		this.groupUserIdentifier = value;
	}
	
	@Override
	public Long getNIAFlags()
	{
		if(niaFlags == null)
			return null;
		
		return niaFlags.getUnsigned();
	}
	
	@Override
	public void setNIAFlags(Long value)
	{
		if(value == null)
			this.niaFlags = null;
		else
			this.niaFlags = new NIAFlagsImpl(value, null, null);	
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(niddAuthorizationResponse);
		
		if(groupUserIdentifier!=null)
			result.addAll(groupUserIdentifier);
		
		result.add(niaFlags);
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}