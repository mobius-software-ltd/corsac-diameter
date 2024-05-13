package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthMessageID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthSubServiceKey;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthUserState;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AuthVoiceID;

/**
*
* @author yulian oifa
*
*/
public class AuthInformationImpl extends DiameterAvpImpl implements AuthInformation
{
	private AuthResultCode authResultCode;
	
	private AuthUserState authUserState;
	
	private AuthAction authAction;
		
	private AuthVoiceID authVoiceID;
	
	private AuthMessageID authMessageID;
	
	private AuthSubServiceKey authSubServiceKey;
	
	public AuthInformationImpl()
	{
		
	}
	
	@Override
	public Long getAuthResultCode()
	{
		if(authResultCode==null)
			return null;
		
		return authResultCode.getUnsigned();
	}
	
	@Override
	public void setAuthResultCode(Long value)
	{
		if(value==null)
			this.authResultCode = null;
		else
			this.authResultCode = new AuthResultCodeImpl(value, null, null);
	}	
	
	@Override
	public String getAuthUserState()
	{
		if(authUserState==null)
			return null;
		
		return authUserState.getString();
	}
	
	@Override
	public void setAuthUserState(String value)
	{
		if(value==null)
			this.authUserState = null;
		else
			this.authUserState = new AuthUserStateImpl(value);
	}		
	
	@Override
	public String getAuthAction()
	{
		if(authAction==null)
			return null;
		
		return authAction.getString();
	}
	
	@Override
	public void setAuthAction(String value)
	{
		if(value==null)
			this.authAction = null;
		else
			this.authAction = new AuthActionImpl(value);
	}	
	
	@Override
	public Long getAuthVoiceID()
	{
		if(authVoiceID==null)
			return null;
		
		return authVoiceID.getUnsigned();
	}
	
	@Override
	public void setAuthVoiceID(Long value)
	{
		if(value==null)
			this.authVoiceID = null;
		else
			this.authVoiceID = new AuthVoiceIDImpl(value, null, null);
	}	
	
	@Override
	public Long getAuthMessageID()
	{
		if(authMessageID==null)
			return null;
		
		return authMessageID.getUnsigned();
	}
	
	@Override
	public void setAuthMessageID(Long value)
	{
		if(value==null)
			this.authMessageID = null;
		else
			this.authMessageID = new AuthMessageIDImpl(value, null, null);
	}		
	
	@Override
	public String getAuthSubServiceKey()
	{
		if(authSubServiceKey==null)
			return null;
		
		return authSubServiceKey.getString();
	}
	
	@Override
	public void setAuthSubServiceKey(String value)
	{
		if(value==null)
			this.authSubServiceKey = null;
		else
			this.authSubServiceKey = new AuthSubServiceKeyImpl(value);
	}
}