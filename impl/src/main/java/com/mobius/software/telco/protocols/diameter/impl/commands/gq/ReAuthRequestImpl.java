package com.mobius.software.telco.protocols.diameter.impl.commands.gq;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.gq.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AbortCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SpecificActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;

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
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private List<SpecificAction> specificAction;
	
	private List<AccessNetworkChargingIdentifier> accessNetworkChargingIdentifier;	
	
	private AccessNetworkChargingAddress accessNetworkChargingAddress;		
	
	private List<Flows> flows;
	
	private AbortCause abortCause;		
	
	
	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType,List<SpecificActionEnum> specificAction) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);
		
		setSpecificAction(specificAction);
	}
	
	@Override
	public List<SpecificActionEnum> getSpecificAction()
	{
		if(specificAction==null || specificAction.size()==0)
			return null;
		
		List<SpecificActionEnum> result=new ArrayList<SpecificActionEnum>();
		for(SpecificAction curr:specificAction)
			result.add(curr.getEnumerated(SpecificActionEnum.class));
		
		return result;
	}
	
	@Override
	public void setSpecificAction(List<SpecificActionEnum> value) throws MissingAvpException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("Specific-Action is required is required", Arrays.asList(new DiameterAvp[] { new SpecificActionImpl() }));
			
		this.specificAction = new ArrayList<SpecificAction>();
		for(SpecificActionEnum curr:value)
			this.specificAction.add(new SpecificActionImpl(curr, null, null));
	}
	
	@Override
	public List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier()
	{
		return this.accessNetworkChargingIdentifier;
	}
	
	@Override
	public void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value)
	{
		this.accessNetworkChargingIdentifier = value;
	}
	
	@Override
	public InetAddress getAccessNetworkChargingAddress()
	{
		if(accessNetworkChargingAddress==null)
			return null;
		
		return accessNetworkChargingAddress.getAddress();
	}
	
	@Override
	public void setAccessNetworkChargingAddress(InetAddress value)
	{
		if(value==null)
			this.accessNetworkChargingAddress = null;
		else
			this.accessNetworkChargingAddress = new AccessNetworkChargingAddressImpl(value, null, null);
	}
	
	@Override
	public List<Flows> getFlows()
	{
		return this.flows;
	}
	
	@Override
	public void setFlows(List<Flows> value)
	{
		this.flows = value;
	}
	
	@Override
	public AbortCauseEnum getAbortCause()
	{
		if(abortCause==null)
			return null;
		
		return this.abortCause.getEnumerated(AbortCauseEnum.class);
	}
	
	@Override
	public void setAbortCause(AbortCauseEnum value)
	{
		if(value == null)
			this.abortCause = null;
		else
			this.abortCause = new AbortCauseImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(specificAction==null || specificAction.size()==0)
			return new MissingAvpException("Specific-Action is required is required", Arrays.asList(new DiameterAvp[] { new SpecificActionImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		
		if(specificAction!=null)
			result.addAll(specificAction);
		
		if(accessNetworkChargingIdentifier!=null)
			result.addAll(accessNetworkChargingIdentifier);
			
		result.add(accessNetworkChargingAddress);
		
		if(flows!=null)
			result.addAll(flows);
		
		result.add(abortCause);
		result.add(originStateId);
		
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