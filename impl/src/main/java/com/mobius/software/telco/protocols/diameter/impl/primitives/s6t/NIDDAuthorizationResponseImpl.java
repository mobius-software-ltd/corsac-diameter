package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GrantedValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3151L, vendorId = KnownVendorIDs.TGPP_ID)
public class NIDDAuthorizationResponseImpl extends DiameterGroupedAvpImpl implements NIDDAuthorizationResponse
{
	private UserName userName;
	
	private MSISDN msisdn;
	
	private ExternalIdentifier externalIdentifier;
	
	private GrantedValidityTime grantedValidityTime;
	
	public NIDDAuthorizationResponseImpl()
	{
		
	}
	
	public String getUserName()
	{
		if(userName == null)
			return null;
		
		return userName.getString();
	}
	
	public void setUserName(String value)
	{
		if(value==null)
			this.userName = null;
		else
			this.userName = new UserNameImpl(value, null, null);
	}
	
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value==null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier == null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value==null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);
	}
	
	public Date getGrantedValidityTime()
	{
		if(grantedValidityTime == null)
			return null;
		
		return grantedValidityTime.getDateTime();
	}
	
	public void setGrantedValidityTime(Date value)
	{
		if(value==null)
			this.grantedValidityTime = null;
		else
			this.grantedValidityTime = new GrantedValidityTimeImpl(value, null, null);
	}
}