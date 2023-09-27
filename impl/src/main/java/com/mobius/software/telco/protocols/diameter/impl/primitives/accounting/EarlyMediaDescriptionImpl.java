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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EarlyMediaDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaComponent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPSessionDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPTimeStamps;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1272L, vendorId = KnownVendorIDs.TGPP_ID)
public class EarlyMediaDescriptionImpl implements EarlyMediaDescription
{
	private SDPTimeStamps sdpTimeStamps; 
	private List<SDPMediaComponent> sdpMediaComponent;
	private List<SDPSessionDescription> sdpSessionDescription;
		
	public EarlyMediaDescriptionImpl()
	{
		
	}
	
	public SDPTimeStamps getSDPTimeStamps()
	{
		return sdpTimeStamps;
	}
	
	public void setSDPTimeStamps(SDPTimeStamps value)
	{
		this.sdpTimeStamps = value;			
	}
	
	public List<SDPMediaComponent> getSDPMediaComponent()
	{
		return sdpMediaComponent;
	}
	
	public void setSDPMediaComponent(List<SDPMediaComponent> value)
	{
		this.sdpMediaComponent = value;
	}
	
	public List<String> getSDPSessionDescription()
	{
		if(sdpSessionDescription==null || sdpSessionDescription.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SDPSessionDescription curr:sdpSessionDescription)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setSDPSessionDescription(List<String> value)
	{
		if(value==null || value.size()==0)
			this.sdpSessionDescription = null;
		else
		{
			this.sdpSessionDescription = new ArrayList<SDPSessionDescription>();
			for(String curr:value)
				this.sdpSessionDescription.add(new SDPSessionDescriptionImpl(curr, null, null));
		}
	}	
}