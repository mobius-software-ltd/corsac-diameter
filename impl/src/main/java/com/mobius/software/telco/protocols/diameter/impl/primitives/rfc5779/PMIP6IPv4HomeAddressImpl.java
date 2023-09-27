package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5779;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5779.PMIP6IPv4HomeAddress;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 505L, vendorId = -1L)
public class PMIP6IPv4HomeAddressImpl extends DiameterAddressImpl implements PMIP6IPv4HomeAddress
{
	protected PMIP6IPv4HomeAddressImpl()
	{
		super();
	}

	protected PMIP6IPv4HomeAddressImpl(Integer minLength, Integer maxLength)
	{
		super(minLength, maxLength);
	}

	public PMIP6IPv4HomeAddressImpl(InetAddress value, Integer minLength, Integer maxLength)
	{
		super(value, minLength, maxLength);
	}
}