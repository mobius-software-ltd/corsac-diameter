package com.mobius.software.telco.protocols.diameter.commands.commons;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = -1, commandCode = 258, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends DiameterRequest
{  
	public Long getAuthApplicationId();
	
	void setAuthApplicationIds(Long value);
	
	public ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value);
	
	public String getUsername();
	
	void setUsername(String value);
	
	public Long getOriginStateId();
	
	void setOriginStateId(Long value);			
	
	public List<ProxyInfo> getProxyInfo();
	
	void setProxyInfo(List<ProxyInfo> value);

	public List<String> getRouteRecords();
	
	void setRouteRecords(List<String> value);
}