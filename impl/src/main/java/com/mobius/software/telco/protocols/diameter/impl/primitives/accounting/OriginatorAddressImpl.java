package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressDomain;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorAddress;

/**
*
* @author yulian oifa
*
*/
public class OriginatorAddressImpl extends DiameterAvpImpl implements OriginatorAddress
{
	private AddressType addressType;
	private AddressData addressData;
	private AddressDomain addresDomain;
		
	public OriginatorAddressImpl()
	{
		
	}
	
	public AddressTypeEnum getAddressType()
	{
		if(addressType==null)
			return null;
		
		return addressType.getEnumerated(AddressTypeEnum.class);
	}
	
	public void setAddressType(AddressTypeEnum value)
	{
		if(value==null)
			this.addressType = null;
		else
			this.addressType = new AddressTypeImpl(value, null, null);			
	}
	
	public String getAddressData()
	{
		if(addressData==null)
			return null;
		
		return addressData.getString();
	}
	
	public void setAddressData(String value)
	{
		if(value==null)
			this.addressData = null;
		else
			this.addressData = new AddressDataImpl(value, null, null);			
	}
	
	public AddressDomain getAddressDomain()
	{
		return addresDomain;
	}
	
	public void setAddressDomain(AddressDomain value)
	{
		this.addresDomain = value;
	}
}