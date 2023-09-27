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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CoAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1039L, vendorId = KnownVendorIDs.TGPP_ID)
public class CoAInformationImpl extends DiameterGroupedAvpImpl implements CoAInformation
{
	private TunnelInformation tunnelInformation;
	private CoAIPAddress coAIPAddress;
	
	protected CoAInformationImpl()
	{
		
	}
	
	public CoAInformationImpl(TunnelInformation tunnelInformation,InetAddress coAIPAddress)
	{
		if(tunnelInformation==null)
			throw new IllegalArgumentException("Tunnel-Information is required");
		
		if(coAIPAddress==null)
			throw new IllegalArgumentException("CoA-IP-Address is required");
		
		this.tunnelInformation = tunnelInformation;				
		
		this.coAIPAddress = new CoAIPAddressImpl(coAIPAddress, null, null);
	}
	
	public TunnelInformation getTunnelInformation()
	{
		return tunnelInformation;
	}
	
	public void setTunnelInformation(TunnelInformation value)
	{
		if(value==null)
			throw new IllegalArgumentException("Tunnel-Information is required");
		
		this.tunnelInformation = value;			
	}
	
	public InetAddress getCoAIPAddress()
	{
		if(coAIPAddress==null)
			return null;
		
		return coAIPAddress.getAddress();
	}
	
	public void setCoAIPAddress(InetAddress value)
	{
		if(value==null)
			throw new IllegalArgumentException("CoA-IP-Address is required");
		
		this.coAIPAddress = new CoAIPAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(tunnelInformation==null)
			return "Tunnel-Information is required";
		
		if(coAIPAddress==null)
			return "CoA-IP-Address is required";
		
		return null;
	}		  		  
}