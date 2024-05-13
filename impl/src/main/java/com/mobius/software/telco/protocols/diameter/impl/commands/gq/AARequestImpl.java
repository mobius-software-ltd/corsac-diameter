package com.mobius.software.telco.protocols.diameter.impl.commands.gq;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gq.AARequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFChargingIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SIPForkingIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SpecificActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.FlowGrouping;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndication;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;

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
public class AARequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestImpl implements AARequest
{
	protected List<MediaComponentDescription> mediaComponentDescription;
	
	protected List<FlowGrouping> flowGrouping;
    
	protected AFChargingIdentifier afChargingIdentifier;
	
	protected SIPForkingIndication sipForkingIndication;
	
	protected List<SpecificAction> specificAction;
	
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authApplicationId);
	}

	@Override
	public List<MediaComponentDescription> getMediaComponentDescription()
	{
		return this.mediaComponentDescription;
	}
	
	@Override
	public void setMediaComponentDescription(List<MediaComponentDescription> value)
	{
		this.mediaComponentDescription = value;
	}
	
	@Override
	public List<FlowGrouping> getFlowGrouping()
	{
		return this.flowGrouping;
	}
	
	@Override
	public void setFlowGrouping(List<FlowGrouping> value)
	{
		this.flowGrouping = value;
	}
	
	@Override
	public ByteBuf getAFChargingIdentifier()
	{
		if(afChargingIdentifier==null)
			return null;
		
		return afChargingIdentifier.getValue();
	}
	
	@Override
	public void setAFChargingIdentifier(ByteBuf value)
	{
		if(value==null)
			this.afChargingIdentifier = null;
		else
			this.afChargingIdentifier = new AFChargingIdentifierImpl(value, null, null);
	}
	
	@Override
	public SIPForkingIndicationEnum getSIPForkingIndication()
	{
		if(sipForkingIndication==null)
			return null;
		
		return sipForkingIndication.getEnumerated(SIPForkingIndicationEnum.class);
	}
	
	@Override
	public void setSIPForkingIndication(SIPForkingIndicationEnum value)
	{
		if(value==null)
			this.sipForkingIndication = null;
		else
			this.sipForkingIndication = new SIPForkingIndicationImpl(value, null, null);
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
	public void setSpecificAction(List<SpecificActionEnum> value)
	{
		if(value==null || value.size()==0)
			this.specificAction = null;
		else
		{
			this.specificAction = new ArrayList<SpecificAction>();
			for(SpecificActionEnum curr:value)
				this.specificAction.add(new SpecificActionImpl(curr, null, null));
		}
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
      	result.add(originHost);
      	result.add(originRealm);
      	result.add(destinationRealm);
      	
      	if(mediaComponentDescription!=null)
      		result.addAll(mediaComponentDescription);
      		
      	if(flowGrouping!=null)
      		result.addAll(flowGrouping);
      		
      	result.add(afChargingIdentifier);
      	result.add(sipForkingIndication);
      	
      	if(specificAction!=null)
      		result.addAll(specificAction);
      		
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