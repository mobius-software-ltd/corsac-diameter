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
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPName;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPSBISupportIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPSBISupportIndicatorEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3345L, vendorId = KnownVendorIDs.TGPP_ID)
public class SMSFNon3GPPAddressImpl extends DiameterGroupedAvpImpl implements SMSFNon3GPPAddress
{
	private SMSFNon3GPPNumber smsfNon3GPPNumber;
	
	private SMSFNon3GPPName smsfNon3GPPName;
	
	private SMSFNon3GPPRealm smsfNon3GPPRealm;
	
	private SMSFNon3GPPSBISupportIndicator smsfNon3GPPSBISupportIndicator;
	
	public SMSFNon3GPPAddressImpl()
	{
		
	}
	
	public String getSMSFNon3GPPNumber()
	{
		if(smsfNon3GPPNumber == null)
			return null;
		
		return smsfNon3GPPNumber.getAddress();
	}
	
	public void setSMSFNon3GPPNumber(String value)
	{
		if(value == null)
			this.smsfNon3GPPNumber = null;
		else
			this.smsfNon3GPPNumber = new SMSFNon3GPPNumberImpl(value);
	}
	
	public String getSMSFNon3GPPName()
	{
		if(smsfNon3GPPName == null)
			return null;
		
		return smsfNon3GPPName.getIdentity();
	}
	
	public void setSMSFNon3GPPName(String value)
	{
		if(value == null)
			this.smsfNon3GPPName = null;
		else
			this.smsfNon3GPPName = new SMSFNon3GPPNameImpl(value, null, null);
	}
	
	public String getSMSFNon3GPPRealm()
	{
		if(smsfNon3GPPRealm == null)
			return null;
		
		return smsfNon3GPPRealm.getIdentity();
	}
	
	public void setSMSFNon3GPPRealm(String value)
	{
		if(value == null)
			this.smsfNon3GPPRealm = null;
		else
			this.smsfNon3GPPRealm = new SMSFNon3GPPRealmImpl(value, null, null);
	}
	
	public SMSFNon3GPPSBISupportIndicatorEnum getSMSFNon3GPPSBISupportIndicator()
	{
		if(smsfNon3GPPSBISupportIndicator == null)
			return null;
		
		return smsfNon3GPPSBISupportIndicator.getEnumerated(SMSFNon3GPPSBISupportIndicatorEnum.class);
	}
	
	public void setSMSFNon3GPPSBISupportIndicator(SMSFNon3GPPSBISupportIndicatorEnum value)
	{
		if(value == null)
			this.smsfNon3GPPSBISupportIndicator = null;
		else
			this.smsfNon3GPPSBISupportIndicator = new SMSFNon3GPPSBISupportIndicatorImpl(value, null, null);
	}
}