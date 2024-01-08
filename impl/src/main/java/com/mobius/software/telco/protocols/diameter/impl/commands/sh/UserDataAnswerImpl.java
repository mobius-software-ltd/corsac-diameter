package com.mobius.software.telco.protocols.diameter.impl.commands.sh;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sh.UserDataAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.WildcardedIMPUImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.WildcardedPublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.UserDataImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WildcardedIMPU;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WildcardedPublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserData;

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
@DiameterCommandImplementation(applicationId = 16777217, commandCode = 306, request = false)
public class UserDataAnswerImpl extends ShAnswerImpl implements UserDataAnswer
{
	private WildcardedPublicIdentity wildcardedPublicIdentity;
	
	private WildcardedIMPU wildcardedIMPU;
	
	private UserData userData;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	protected UserDataAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public UserDataAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	public String getWildcardedPublicIdentity()
	{
		if(wildcardedPublicIdentity==null)
			return null;
		
		return wildcardedPublicIdentity.getString();
	}
	
	public void setWildcardedPublicIdentity(String value)
	{
		if(value==null)
			this.wildcardedPublicIdentity = null;
		else
			this.wildcardedPublicIdentity = new WildcardedPublicIdentityImpl(value, null, null);
	}

	public String getWildcardedIMPU()
	{
		if(wildcardedIMPU==null)
			return null;
		
		return wildcardedIMPU.getString();
	}
	
	public void setWildcardedIMPU(String value)
	{
		if(value==null)
			this.wildcardedIMPU = null;
		else
			this.wildcardedIMPU = new WildcardedIMPUImpl(value, null, null);
	}
	
	public ByteBuf getUserData()
	{
		if(userData==null)
			return null;
		
		return userData.getValue();
	}
	
	public void setUserData(ByteBuf value)
	{
		if(value==null)
			this.userData = null;
		else
			this.userData = new UserDataImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	 		
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	public void setLoad(List<Load> value)
	{
		this.load = value;
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
		
		result.add(wildcardedPublicIdentity);
		result.add(wildcardedIMPU);
		result.add(userData);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
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