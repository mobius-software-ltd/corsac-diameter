package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMEI;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SoftwareVersion;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TGPP2MEID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1401L, vendorId = KnownVendorIDs.TGPP_ID)
public class TerminalInformationImpl extends DiameterGroupedAvpImpl implements TerminalInformation
{
	private IMEI imei;
	
	private TGPP2MEID tgpp2MEID;
	
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
	
	public ByteBuf get3GPP2MEID()
	{
		if(tgpp2MEID == null)
			return null;
		
		return tgpp2MEID.getValue();
	}
	
	public void set3GPP2MEID(ByteBuf value)
	{
		if(value == null)
			this.tgpp2MEID = null;
		else
			this.tgpp2MEID = new TGPP2MEIDImpl(value, null, null);
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