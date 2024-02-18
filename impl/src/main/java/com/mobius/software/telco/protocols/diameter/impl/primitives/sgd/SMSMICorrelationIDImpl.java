package com.mobius.software.telco.protocols.diameter.impl.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.sgd.DestinationSIPURI;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.HSSID;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.OriginatingSIPURI;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

/**
*
* @author yulian oifa
*
*/
public class SMSMICorrelationIDImpl extends DiameterGroupedAvpImpl implements SMSMICorrelationID
{
	private HSSID hssID;
	
	private OriginatingSIPURI originatingSIPURI;
	
	private DestinationSIPURI destinationSIPURI;
	
	public SMSMICorrelationIDImpl()
	{
	}

	public String getHSSID()
	{
		if(hssID==null)
			return null;
		
		return hssID.getString();
	}
	
	public void setHSSID(String value)
	{
		if(value == null)
			this.hssID = null;
		else
			this.hssID = new HSSIDImpl(value, null, null);
	}
	
	public String getOriginatingSIPURI()
	{
		if(originatingSIPURI==null)
			return null;
		
		return originatingSIPURI.getString();
	}
	
	public void setOriginatingSIPURI(String value)
	{
		if(value == null)
			this.originatingSIPURI = null;
		else
			this.originatingSIPURI = new OriginatingSIPURIImpl(value, null, null);
	}
	
	public String getDestinationSIPURI()
	{
		if(destinationSIPURI==null)
			return null;
		
		return destinationSIPURI.getString();
	}
	
	public void setDestinationSIPURI(String value)
	{
		if(value == null)
			this.destinationSIPURI = null;
		else
			this.destinationSIPURI = new DestinationSIPURIImpl(value, null, null);
	}
}