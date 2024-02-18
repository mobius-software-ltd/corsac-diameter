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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WebRTCAuthenticationFunctionName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WebRTCWebServerFunctionName;

/**
*
* @author yulian oifa
*
*/
public class AllowedWAFWWSFIdentitiesImpl extends DiameterGroupedAvpImpl implements AllowedWAFWWSFIdentities
{
	private List<WebRTCAuthenticationFunctionName> webRTCAuthenticationFunctionName;
	
	private List<WebRTCWebServerFunctionName> webRTCWebServerFunctionName;
	
	public AllowedWAFWWSFIdentitiesImpl()
	{
		
	}
	
	public List<String> getWebRTCAuthenticationFunctionName()
	{
		if(webRTCAuthenticationFunctionName==null || webRTCAuthenticationFunctionName.size()==0)
			return null;
		
		List<String> result = new  ArrayList<String>();
		for(WebRTCAuthenticationFunctionName curr:webRTCAuthenticationFunctionName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setWebRTCAuthenticationFunctionName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.webRTCAuthenticationFunctionName = null;
		else
		{
			this.webRTCAuthenticationFunctionName = new ArrayList<WebRTCAuthenticationFunctionName>();
			for(String curr:value)
				this.webRTCAuthenticationFunctionName.add(new WebRTCAuthenticationFunctionNameImpl(curr, null, null));
		}
	}
	
	public List<String> getWebRTCWebServerFunctionName()
	{
		if(webRTCWebServerFunctionName==null || webRTCWebServerFunctionName.size()==0)
			return null;
		
		List<String> result = new  ArrayList<String>();
		for(WebRTCWebServerFunctionName curr:webRTCWebServerFunctionName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setWebRTCWebServerFunctionName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.webRTCWebServerFunctionName = null;
		else
		{
			this.webRTCWebServerFunctionName = new ArrayList<WebRTCWebServerFunctionName>();
			for(String curr:value)
				this.webRTCWebServerFunctionName.add(new WebRTCWebServerFunctionNameImpl(curr, null, null));
		}
	}
}