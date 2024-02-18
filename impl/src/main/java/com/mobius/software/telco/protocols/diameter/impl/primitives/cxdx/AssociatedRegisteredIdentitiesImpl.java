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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedRegisteredIdentities;

/**
*
* @author yulian oifa
*
*/
public class AssociatedRegisteredIdentitiesImpl extends DiameterGroupedAvpImpl implements AssociatedRegisteredIdentities
{
	private List<UserName> userName;
	
	public AssociatedRegisteredIdentitiesImpl()
	{
		
	}
	
	public List<String> getUserName()
	{
		if(userName==null || userName.size()==0)
			return null;
		
		List<String> result = new  ArrayList<String>();
		for(UserName curr:userName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setUserName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.userName = null;
		else
		{
			this.userName = new ArrayList<UserName>();
			for(String curr:value)
				this.userName.add(new UserNameImpl(curr, null, null));
		}
	}
}