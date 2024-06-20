package com.mobius.software.telco.protocols.diameter.impl.commands.s9atag;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.SessionReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestImpl implements ReAuthRequest
{
	private DRMP drmp;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<ChargingRuleInstall> chargingRuleInstall;
	
	private List<ChargingRuleRemove> chargingRuleRemove;
	
	private SessionReleaseCause sessionReleaseCause;
	
	protected ReAuthRequestImpl() 
	{
		super();		
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);		
	}
	
	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
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
	public List<ChargingRuleInstall> getChargingRuleInstall()
	{
		return this.chargingRuleInstall;
	}
	
	@Override
	public void setChargingRuleInstall(List<ChargingRuleInstall> value)
	{
		this.chargingRuleInstall = value;
	}
	
	@Override
	public List<ChargingRuleRemove> getChargingRuleRemove()
	{
		return this.chargingRuleRemove;
	}
	
	@Override
	public void setChargingRuleRemove(List<ChargingRuleRemove> value)
	{
		this.chargingRuleRemove = value;
	}
	
	@Override
	public SessionReleaseCauseEnum getSessionReleaseCause()
	{
		if(sessionReleaseCause==null)
			return null;
		
		return sessionReleaseCause.getEnumerated(SessionReleaseCauseEnum.class);
	}
	
	@Override
	public void setSessionReleaseCause(SessionReleaseCauseEnum value)
	{
		if(value==null)
			this.sessionReleaseCause = null;
		else
			this.sessionReleaseCause = new SessionReleaseCauseImpl(value, null, null);			
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(reAuthRequestType);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		
		if(chargingRuleInstall!=null)
			result.addAll(chargingRuleInstall);
		
		if(chargingRuleRemove!=null)
			result.addAll(chargingRuleRemove);
		
		result.add(sessionReleaseCause);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}