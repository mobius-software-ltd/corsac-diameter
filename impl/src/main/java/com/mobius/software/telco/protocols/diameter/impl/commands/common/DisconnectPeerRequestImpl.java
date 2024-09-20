package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterMessageBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DisconnectCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;

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
public class DisconnectPeerRequestImpl extends DiameterMessageBase implements DisconnectPeerRequest
{
	private DisconnectCause disconnectCause;
	
	protected DisconnectPeerRequestImpl() 
	{
		super();
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setUsernameAllowed(false);
		setOriginStateIdAllowed(false);
	}
		
	public DisconnectPeerRequestImpl(String originHost,String originRealm,Boolean isRetransmit, DisconnectCauseEnum disconnectCause) throws MissingAvpException
	{
		super(originHost, originRealm, isRetransmit);
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setUsernameAllowed(false);
		setOriginStateIdAllowed(false);
		
		setDisconnectCause(disconnectCause);
	}

	@Override
	public DisconnectCauseEnum getDisconnectCause() 
	{
		if(this.disconnectCause == null)			
			return null;
		
		return this.disconnectCause.getEnumerated(DisconnectCauseEnum.class);
	}

	@Override
	public void setDisconnectCause(DisconnectCauseEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Disconnect-Cause is required", Arrays.asList(new DiameterAvp[] { new DisconnectCauseImpl() } ));
	
		this.disconnectCause = new DisconnectCauseImpl(value, null, null);	
	}		
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(disconnectCause==null)
			return new MissingAvpException("Disconnect-Cause is required", Arrays.asList(new DiameterAvp[] { new DisconnectCauseImpl() } ));
			
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(originHost);
		result.add(originRealm);
		result.add(disconnectCause);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}