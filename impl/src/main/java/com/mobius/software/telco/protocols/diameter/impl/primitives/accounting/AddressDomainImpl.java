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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AddressDomain;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DomainName;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSIMCCMNC;

/**
*
* @author yulian oifa
*
*/
public class AddressDomainImpl extends DiameterAvpImpl implements AddressDomain
{
	private DomainName domainName;
	private TGPPIMSIMCCMNC tgppIMSIMCCMNC;
		
	public AddressDomainImpl()
	{
		
	}
	
	public String getDomainName()
	{
		if(domainName==null)
			return null;
		
		return domainName.getString();
	}
	
	public void setDomainName(String value)
	{
		if(value==null)
			this.domainName = null;
		else
			this.domainName = new DomainNameImpl(value, null, null);			
	}
	
	public String getTGPPIMSIMCCMNC()
	{
		if(tgppIMSIMCCMNC==null)
			return null;
		
		return tgppIMSIMCCMNC.getString();
	}
	
	public void setTGPPIMSIMCCMNC(String value)
	{
		if(value==null)
			this.tgppIMSIMCCMNC = null;
		else
			this.tgppIMSIMCCMNC = new TGPPIMSIMCCMNCImpl(value, null, null);			
	}
}