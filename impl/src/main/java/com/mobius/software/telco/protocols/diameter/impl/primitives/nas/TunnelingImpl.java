package com.mobius.software.telco.protocols.diameter.impl.primitives.nas;
/*
 * Mobius Software LTD
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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelAssignmentId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelClientAuthId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelClientEndpoint;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelMediumType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelMediumTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelPassword;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelPreference;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelPrivateGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelServerAuthId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelServerEndpoint;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.TunnelTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TunnelingImpl implements Tunneling
{
	private TunnelType tunnelType;
	
	private TunnelMediumType tunnelMediumType;
	
	private TunnelClientEndpoint tunnelClientEndpoint;
	
	private TunnelServerEndpoint tunnelServerEndpoint;
	
	private TunnelPreference tunnelPreference;
	
	private TunnelClientAuthId tunnelClientAuthId;
	
	private TunnelServerAuthId tunnelServerAuthId;
	
	private TunnelAssignmentId tunnelAssignmentId;
	
	private TunnelPassword tunnelPassword;
	
	private TunnelPrivateGroupId tunnelPrivateGroupId;
    		
	protected TunnelingImpl()
	{
	}
	
	public TunnelingImpl(TunnelTypeEnum tunnelType, TunnelMediumTypeEnum tunnelMediumType,String tunnelClientEndpoint,String tunnelServerEndpoint) throws MissingAvpException 
	{
		setTunnelType(tunnelType);
		
		setTunnelMediumType(tunnelMediumType);
		
		setTunnelClientEndpoint(tunnelClientEndpoint);
		
		setTunnelServerEndpoint(tunnelServerEndpoint);			
	}
	
	public TunnelTypeEnum getTunnelType()
	{
		if(tunnelType == null)
			return null;
		
		return tunnelType.getEnumerated(TunnelTypeEnum.class);
	}
	
	public void setTunnelType(TunnelTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Tunnel-Type is required is required", Arrays.asList(new DiameterAvp[] { new TunnelTypeImpl() }));
		
		this.tunnelType = new TunnelTypeImpl(value, null, null);				
	}
	
	public TunnelMediumTypeEnum getTunnelMediumType()
	{
		if(tunnelMediumType == null)
			return null;
		
		return tunnelMediumType.getEnumerated(TunnelMediumTypeEnum.class);
	}
	
	public void setTunnelMediumType(TunnelMediumTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Tunnel-Medium-Type is required is required", Arrays.asList(new DiameterAvp[] { new TunnelMediumTypeImpl() }));
		
		this.tunnelMediumType = new TunnelMediumTypeImpl(value, null, null);				
	}
	
	public String getTunnelClientEndpoint()
	{
		if(tunnelClientEndpoint == null)
			return null;
		
		return tunnelClientEndpoint.getString();
	}
	
	public void setTunnelClientEndpoint(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Tunnel-Client-Endpoint is required is required", Arrays.asList(new DiameterAvp[] { new TunnelClientEndpointImpl() }));
			
		this.tunnelClientEndpoint = new TunnelClientEndpointImpl(value, null, null);				
	}	
	
	public String getTunnelServerEndpoint()
	{
		if(tunnelServerEndpoint == null)
			return null;
		
		return tunnelServerEndpoint.getString();
	}
	
	public void setTunnelServerEndpoint(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Tunnel-Server-Endpoint is required is required", Arrays.asList(new DiameterAvp[] { new TunnelServerEndpointImpl() }));
			
		this.tunnelServerEndpoint = new TunnelServerEndpointImpl(value, null, null);		
	}	
	
	public Long getTunnelPreference()
	{
		if(tunnelPreference == null)
			return null;
		
		return tunnelPreference.getUnsigned();
	}
	
	public void setTunnelPreference(Long value)
	{
		if(value!=null)
			this.tunnelPreference = new TunnelPreferenceImpl(value, null, null);
		else
			this.tunnelPreference = null;
	}
	
	public String getTunnelClientAuthId()
	{
		if(tunnelClientAuthId == null)
			return null;
		
		return tunnelClientAuthId.getString();
	}
	
	public void setTunnelClientAuthId(String value)
	{
		if(value!=null)
			this.tunnelClientAuthId = new TunnelClientAuthIdImpl(value, null, null);
		else
			this.tunnelClientAuthId = null;
	}	
	
	public String getTunnelServerAuthId()
	{
		if(tunnelServerAuthId == null)
			return null;
		
		return tunnelServerAuthId.getString();
	}
	
	public void setTunnelServerAuthId(String value)
	{
		if(value!=null)
			this.tunnelServerAuthId = new TunnelServerAuthIdImpl(value, null, null);
		else
			this.tunnelServerAuthId = null;
	}
	
	public ByteBuf getTunnelAssignmentId()
	{
		if(tunnelAssignmentId == null)
			return null;
		
		return tunnelAssignmentId.getValue();
	}
	
	public void setTunnelAssignmentId(ByteBuf value)
	{
		if(value!=null)
			this.tunnelAssignmentId = new TunnelAssignmentIdImpl(value, null, null);
		else
			this.tunnelAssignmentId = null;
	}
	
	public ByteBuf getTunnelPassword()
	{
		if(tunnelPassword == null)
			return null;
		
		return tunnelPassword.getValue();
	}
	
	public void setTunnelPassword(ByteBuf value)
	{
		if(value!=null)
			this.tunnelPassword = new TunnelPasswordImpl(value, null, null);
		else
			this.tunnelPassword = null;
	}
	
	public ByteBuf getTunnelPrivateGroupId()
	{
		if(tunnelPrivateGroupId == null)
			return null;
		
		return tunnelPrivateGroupId.getValue();
	}
	
	public void setTunnelPrivateGroupId(ByteBuf value)
	{
		if(value!=null)
			this.tunnelPrivateGroupId = new TunnelPrivateGroupIdImpl(value, null, null);
		else
			this.tunnelPrivateGroupId = null;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tunnelType==null)
			return new MissingAvpException("Tunnel-Type is required is required", Arrays.asList(new DiameterAvp[] { new TunnelTypeImpl() }));
		
		if(tunnelMediumType==null)
			return new MissingAvpException("Tunnel-Medium-Type is required is required", Arrays.asList(new DiameterAvp[] { new TunnelMediumTypeImpl() }));
		
		if(tunnelClientEndpoint==null)
			return new MissingAvpException("Tunnel-Client-Endpoint is required is required", Arrays.asList(new DiameterAvp[] { new TunnelClientEndpointImpl() }));
		
		if(tunnelServerEndpoint==null)
			return new MissingAvpException("Tunnel-Server-Endpoint is required is required", Arrays.asList(new DiameterAvp[] { new TunnelServerEndpointImpl() }));
		
		return null;
	}
}