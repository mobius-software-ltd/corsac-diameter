package com.mobius.software.telco.protocols.diameter.impl.primitives.mm10;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.VASID;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.VASPID;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1100L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServedUserIdentityImpl extends DiameterGroupedAvpImpl implements ServedUserIdentity
{
	private MSISDN msisdn;
	
	private VASPID vaspID;
	
	private VASID vasID;
	
	public ServedUserIdentityImpl()
	{
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
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
	
	public String getVASPID()
	{
		if(vaspID==null)
			return null;
		
		return vaspID.getString();
	}
	
	public void setVASPID(String value)
	{
		if(value==null)
			this.vaspID = null;
		else
			this.vaspID = new VASPIDImpl(value, null, null);			
	}
	
	public String getVASID()
	{
		if(vasID==null)
			return null;
		
		return vasID.getString();
	}
	
	public void setVASID(String value)
	{
		if(value==null)
			this.vasID = null;
		else
			this.vasID = new VASIDImpl(value, null, null);			
	}
}