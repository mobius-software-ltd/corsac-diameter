package com.mobius.software.telco.protocols.diameter.impl.primitives.s6c;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPName;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPSBISupportIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPSBISupportIndicatorEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3344L, vendorId = KnownVendorIDs.TGPP_ID)
public class SMSF3GPPAddressImpl extends DiameterGroupedAvpImpl implements SMSF3GPPAddress
{
	private SMSF3GPPNumber smsf3GPPNumber;
	
	private SMSF3GPPName smsf3GPPName;
	
	private SMSF3GPPRealm smsf3GPPRealm;
	
	private SMSF3GPPSBISupportIndicator smsf3GPPSBISupportIndicator;
	
	public SMSF3GPPAddressImpl()
	{
		
	}
	
	public String getSMSF3GPPNumber()
	{
		if(smsf3GPPNumber == null)
			return null;
		
		return smsf3GPPNumber.getAddress();
	}
	
	public void setSMSF3GPPNumber(String value)
	{
		if(value == null)
			this.smsf3GPPNumber = null;
		else
			this.smsf3GPPNumber = new SMSF3GPPNumberImpl(value);
	}
	
	public String getSMSF3GPPName()
	{
		if(smsf3GPPName == null)
			return null;
		
		return smsf3GPPName.getIdentity();
	}
	
	public void setSMSF3GPPName(String value)
	{
		if(value == null)
			this.smsf3GPPName = null;
		else
			this.smsf3GPPName = new SMSF3GPPNameImpl(value, null, null);
	}
	
	public String getSMSF3GPPRealm()
	{
		if(smsf3GPPRealm == null)
			return null;
		
		return smsf3GPPRealm.getIdentity();
	}
	
	public void setSMSF3GPPRealm(String value)
	{
		if(value == null)
			this.smsf3GPPRealm = null;
		else
			this.smsf3GPPRealm = new SMSF3GPPRealmImpl(value, null, null);
	}
	
	public SMSF3GPPSBISupportIndicatorEnum getSMSF3GPPSBISupportIndicator()
	{
		if(smsf3GPPSBISupportIndicator == null)
			return null;
		
		return smsf3GPPSBISupportIndicator.getEnumerated(SMSF3GPPSBISupportIndicatorEnum.class);
	}
	
	public void setSMSF3GPPSBISupportIndicator(SMSF3GPPSBISupportIndicatorEnum value)
	{
		if(value == null)
			this.smsf3GPPSBISupportIndicator = null;
		else
			this.smsf3GPPSBISupportIndicator = new SMSF3GPPSBISupportIndicatorImpl(value, null, null);
	}
}