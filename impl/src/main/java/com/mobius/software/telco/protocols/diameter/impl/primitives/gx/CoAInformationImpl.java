package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import java.net.InetAddress;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;

/**
*
* @author yulian oifa
*
*/
public class CoAInformationImpl extends DiameterGroupedAvpImpl implements CoAInformation
{
	private TunnelInformation tunnelInformation;
	private CoAIPAddress coAIPAddress;
	
	protected CoAInformationImpl()
	{
		
	}
	
	public CoAInformationImpl(TunnelInformation tunnelInformation,InetAddress coAIPAddress) throws MissingAvpException
	{
		setTunnelInformation(tunnelInformation);
		
		setCoAIPAddress(coAIPAddress);
	}
	
	public TunnelInformation getTunnelInformation()
	{
		return tunnelInformation;
	}
	
	public void setTunnelInformation(TunnelInformation value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Tunnel-Information is required", Arrays.asList(new DiameterAvp[] { new TunnelInformationImpl() }));
			
		this.tunnelInformation = value;			
	}
	
	public InetAddress getCoAIPAddress()
	{
		if(coAIPAddress==null)
			return null;
		
		return coAIPAddress.getAddress();
	}
	
	public void setCoAIPAddress(InetAddress value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("CoA-IP-Address is required", Arrays.asList(new DiameterAvp[] { new CoAIPAddressImpl() }));
			
		this.coAIPAddress = new CoAIPAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tunnelInformation==null)
			return new MissingAvpException("Tunnel-Information is required", Arrays.asList(new DiameterAvp[] { new TunnelInformationImpl() }));
		
		if(coAIPAddress==null)
			return new MissingAvpException("CoA-IP-Address is required", Arrays.asList(new DiameterAvp[] { new CoAIPAddressImpl() }));
		
		return null;
	}	  		  
}