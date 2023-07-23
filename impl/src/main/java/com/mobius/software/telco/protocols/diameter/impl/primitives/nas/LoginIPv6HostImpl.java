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

import java.net.Inet6Address;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterIpv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginIPv6Host;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 98L, vendorId = -1L)
public class LoginIPv6HostImpl extends DiameterIpv6AddressImpl implements LoginIPv6Host
{
	protected LoginIPv6HostImpl() 
	{
		super();
	}
	
	public LoginIPv6HostImpl(Inet6Address value) 
	{
		super(value);	
	}
}