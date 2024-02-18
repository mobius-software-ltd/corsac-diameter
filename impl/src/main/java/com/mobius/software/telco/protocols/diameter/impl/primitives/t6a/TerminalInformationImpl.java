package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMEIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SoftwareVersionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMEI;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SoftwareVersion;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TerminalInformation;

/**
*
* @author yulian oifa
*
*/
public class TerminalInformationImpl extends DiameterGroupedAvpImpl implements TerminalInformation
{
	private IMEI imei;
	
	private SoftwareVersion softwareVersion;
	
	public TerminalInformationImpl()
	{
		
	}
	
	public String getIMEI()
	{
		if(imei == null)
			return null;
		
		return imei.getString();
	}
	
	public void setIMEI(String value)
	{
		if(value == null)
			this.imei = null;
		else
			this.imei = new IMEIImpl(value, null, null);
	}
	
	public String getSoftwareVersion()
	{
		if(softwareVersion == null)
			return null;
		
		return softwareVersion.getString();
	}
	
	public void setSoftwareVersion(String value)
	{
		if(value == null)
			this.softwareVersion = null;
		else
			this.softwareVersion = new SoftwareVersionImpl(value, null, null);
	}
}