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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.DownlinkRateLimit;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.UplinkRateLimit;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4310L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServingPLMNRateControlImpl extends DiameterGroupedAvpImpl implements ServingPLMNRateControl
{
	private UplinkRateLimit uplinkRateLimit;
	
	private DownlinkRateLimit downlinkRateLimit;
	
	public ServingPLMNRateControlImpl()
	{
		
	}
	
	public Long getUplinkRateLimit()
	{
		if(uplinkRateLimit == null)
			return null;
		
		return uplinkRateLimit.getUnsigned();
	}
	
	public void setUplinkRateLimit(Long value)
	{
		if(value == null)
			this.uplinkRateLimit = null;
		else
			this.uplinkRateLimit = new UplinkRateLimitImpl(value, null, null);
	}
	
	public Long getDownlinkRateLimit()
	{
		if(downlinkRateLimit == null)
			return null;
		
		return downlinkRateLimit.getUnsigned();
	}
	
	public void setDownlinkRateLimit(Long value)
	{
		if(value == null)
			this.downlinkRateLimit = null;
		else
			this.downlinkRateLimit = new DownlinkRateLimitImpl(value, null, null);
	}
}