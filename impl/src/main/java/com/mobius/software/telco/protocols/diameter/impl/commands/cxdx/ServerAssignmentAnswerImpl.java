package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.LooseRouteIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PriviledgedSenderIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.WildcardedPublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedRegisteredIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.LooseRouteIndication;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.LooseRouteIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PriviledgedSenderIndication;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PriviledgedSenderIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserData;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WildcardedPublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 301, request = false)
public class ServerAssignmentAnswerImpl extends CxDxAnswerImpl implements ServerAssignmentAnswer
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private List<UserData> userData;
	
	private ChargingInformation chargingInformation;
	 
	private AssociatedIdentities associatedIdentities;
	 
	private LooseRouteIndication looseRouteIndication;
	 
	private List<SCSCFRestorationInfo> scscfRestorationInfo;
	 
	private AssociatedRegisteredIdentities associatedRegisteredIdentities;
	
	private ServerName serverName;
	
	private WildcardedPublicIdentity wildcardedPublicIdentity;
	 
	private PriviledgedSenderIndication priviledgedSenderIndication;
	 
	private AllowedWAFWWSFIdentities allowedWAFWWSFIdentities;
	 
	protected ServerAssignmentAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ServerAssignmentAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	
	@Override
	public List<UserData> getUserData()
	{
		return userData;
	}
	
	@Override
	public void setUserData(List<UserData> value)
	{
		this.userData = value;
	}
	
	public ChargingInformation getChargingInformation()
	{
		return this.chargingInformation;
	}
	 
	public void setChargingInformation(ChargingInformation value)
	{
		this.chargingInformation = value;
	}
	
	public AssociatedIdentities getAssociatedIdentities()
	{
		return associatedIdentities;
	}
	 
	public void setAssociatedIdentities(AssociatedIdentities value)
	{
		this.associatedIdentities = value;
	}
	
	public LooseRouteIndicationEnum getLooseRouteIndication()
	{
		if(looseRouteIndication==null)
			return null;
		
		return looseRouteIndication.getEnumerated(LooseRouteIndicationEnum.class);
	}
	 
	public void setLooseRouteIndication(LooseRouteIndicationEnum value)
	{
		if(value == null)
			this.looseRouteIndication = null;
		else
			this.looseRouteIndication = new LooseRouteIndicationImpl(value, null, null);
	}
	
	public List<SCSCFRestorationInfo> getSCSCFRestorationInfo()
	{
		return this.scscfRestorationInfo;
	}
	 
	public void setSCSCFRestorationInfo(List<SCSCFRestorationInfo> value)
	{
		this.scscfRestorationInfo = value;				
	}
	
	public AssociatedRegisteredIdentities getAssociatedRegisteredIdentities()
	{
		return associatedRegisteredIdentities;
	}
	 
	public void setAssociatedRegisteredIdentities(AssociatedRegisteredIdentities value)
	{
		this.associatedRegisteredIdentities = value;
	}
		
	@Override
	public String getServerName() 
	{
		if(serverName == null)
			return null;
		
		return serverName.getString();
	}
	
	@Override
	public void setServerName(String value)
	{
		if(value == null)
			this.serverName = null;
		else
			this.serverName = new ServerNameImpl(value, null, null);
	}
	
	public String getWildcardedPublicIdentity()
	{
		if(wildcardedPublicIdentity == null)
			return null;
		
		return wildcardedPublicIdentity.getString();
	}
	 
	public void setWildcardedPublicIdentity(String value)
	{
		if(value == null)
			this.wildcardedPublicIdentity = null;
		else
			this.wildcardedPublicIdentity = new WildcardedPublicIdentityImpl(value, null, null);
	}
	
	public PriviledgedSenderIndicationEnum getPriviledgedSenderIndication()
	{
		if(priviledgedSenderIndication == null)
			return null;
		
		return priviledgedSenderIndication.getEnumerated(PriviledgedSenderIndicationEnum.class);
	}
	 
	public void setPriviledgedSenderIndication(PriviledgedSenderIndicationEnum value)
	{
		if(value == null)
			this.priviledgedSenderIndication = null;
		else
			this.priviledgedSenderIndication = new PriviledgedSenderIndicationImpl(value, null, null);
	}
	
	public AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities()
	{
		return this.allowedWAFWWSFIdentities;
	}
	 
	public void setAllowedWAFWWSFIdentities(AllowedWAFWWSFIdentities value)
	{
		this.allowedWAFWWSFIdentities = value;
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
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(userData!=null)
			result.addAll(userData);
		
		result.add(chargingInformation);
		result.add(associatedIdentities);
		result.add(looseRouteIndication);
		
		if(scscfRestorationInfo!=null)
			result.addAll(scscfRestorationInfo);
		
		result.add(associatedRegisteredIdentities);
		result.add(serverName);
		result.add(wildcardedPublicIdentity);
		result.add(priviledgedSenderIndication);
		result.add(allowedWAFWWSFIdentities);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		return result;
	}
}