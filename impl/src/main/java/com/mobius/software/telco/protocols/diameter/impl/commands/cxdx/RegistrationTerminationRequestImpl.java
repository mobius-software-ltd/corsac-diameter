package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.DeregistrationReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RTRFlags;

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
public class RegistrationTerminationRequestImpl extends CxDxRequestImpl implements RegistrationTerminationRequest
{
	private AssociatedIdentities associatedIdentities;
	
	private List<PublicIdentity> publicIdentity;
	
	private DeregistrationReason deregistrationReason;
	
	private RTRFlags rtrFlags;
	
	protected RegistrationTerminationRequestImpl() 
	{
		super();
	}
	
	public RegistrationTerminationRequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String username, DeregistrationReason deregistrationReason) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authSessionState);

		setUsername(username);
		
		setDeregistrationReason(deregistrationReason);
	}
	
	@Override
	public void setUsername(String value) throws MissingAvpException, AvpNotSupportedException
	{
		if(value==null)
			throw new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
			
		super.setUsername(value);
	}

	public AssociatedIdentities getAssociatedIdentities()
	{
		return this.associatedIdentities;
	}
	 
	public void setAssociatedIdentities(AssociatedIdentities value)
	{
		this.associatedIdentities = value;
	}
	
	public List<String> getPublicIdentity()
	{
		if(publicIdentity==null || publicIdentity.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(PublicIdentity curr:publicIdentity)
			result.add(curr.getString());
		
		return result;
	}
			
	public void setPublicIdentity(List<String> value)
	{
		if(value==null || value.size()==0)
			this.publicIdentity = null;
		
		this.publicIdentity = new ArrayList<PublicIdentity>();
		for(String curr:value)
			this.publicIdentity.add(new PublicIdentityImpl(curr, null, null));
	}
					
	@Override
	public DeregistrationReason getDeregistrationReason()
	{
		return deregistrationReason;
	}
	
	@Override
	public void setDeregistrationReason(DeregistrationReason value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Deregistration-Reason is required is required", Arrays.asList(new DiameterAvp[] { new DeregistrationReasonImpl() }));
		
		this.deregistrationReason = value;
	}
	
	public RTRFlags getRTRFlags()
	{
		return rtrFlags;
	}
	
	public void setRTRFlags(RTRFlags value)
	{
		this.rtrFlags = value;		
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(username == null)
			return new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		if(deregistrationReason == null)
			return new MissingAvpException("Deregistration-Reason is required is required", Arrays.asList(new DiameterAvp[] { new DeregistrationReasonImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(username);
		
		result.add(associatedIdentities);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(publicIdentity!=null)
			result.addAll(publicIdentity);
		
		result.add(deregistrationReason);
		result.add(rtrFlags);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}