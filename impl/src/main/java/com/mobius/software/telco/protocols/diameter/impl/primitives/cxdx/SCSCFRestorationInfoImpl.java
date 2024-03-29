package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RegistrationTimeOut;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthenticationScheme;

/**
*
* @author yulian oifa
*
*/
public class SCSCFRestorationInfoImpl extends DiameterGroupedAvpImpl implements SCSCFRestorationInfo
{
	private UserName userName;
	
	private List<RestorationInfo> restorationInfo;
	
	private RegistrationTimeOut registrationTimeOut;
	
	private SIPAuthenticationScheme sipAuthenticationScheme;
	
	protected SCSCFRestorationInfoImpl()
	{
		
	}
	
	public SCSCFRestorationInfoImpl(String username,List<RestorationInfo> restorationInfo) throws MissingAvpException
	{
		setUserName(username);
		
		setRestorationInfo(restorationInfo);
	}
	
	public String getUserName()
	{
		if(userName==null)
			return null;
		
		return userName.getString();
	}
	
	public void setUserName(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("UserName is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		this.userName = new UserNameImpl(value, null, null);
	}
	
	public List<RestorationInfo> getRestorationInfo()
	{
		return restorationInfo;
	}
	
	public void setRestorationInfo(List<RestorationInfo> value) throws MissingAvpException
	{
		if(value==null || value.size()<1)
			throw new MissingAvpException("Restoration-Info is required is required", Arrays.asList(new DiameterAvp[] { new RestorationInfoImpl() }));
		
		this.restorationInfo = value;
	}
	
	public Date getRegistrationTimeOut()
	{
		if(registrationTimeOut==null)
			return null;
		
		return registrationTimeOut.getDateTime();
	}
	
	public void setRegistrationTimeOut(Date value)
	{
		if(value == null)
			this.registrationTimeOut = null;
		else
			this.registrationTimeOut = new RegistrationTimeOutImpl(value, null, null);
	}
	
	public String getSIPAuthenticationScheme()
	{
		if(sipAuthenticationScheme==null)
			return null;
		
		return sipAuthenticationScheme.getString();
	}
	
	public void setSIPAuthenticationScheme(String value)
	{
		if(value == null)
			this.sipAuthenticationScheme = null;
		else
			this.sipAuthenticationScheme = new SIPAuthenticationSchemeImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(userName==null)
			return new MissingAvpException("UserName is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		if(restorationInfo==null || restorationInfo.size()<1)
			return new MissingAvpException("Restoration-Info is required is required", Arrays.asList(new DiameterAvp[] { new RestorationInfoImpl() }));
		
		return null;
	}
}