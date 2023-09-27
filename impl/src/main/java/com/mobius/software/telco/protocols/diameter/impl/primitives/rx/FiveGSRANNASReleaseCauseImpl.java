package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGMMCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSMCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPCause;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 572L, vendorId = KnownVendorIDs.TGPP_ID)
public class FiveGSRANNASReleaseCauseImpl extends DiameterGroupedAvpImpl implements FiveGSRANNASReleaseCause
{
	private FiveGMMCause fiveGMMCause;
	
	private FiveGSMCause fiveGSMCause;
	
	private NGAPCause ngapCause;
	
	public FiveGSRANNASReleaseCauseImpl()
	{
		
	}
	
	public Long get5GMMCause()
	{
		if(fiveGMMCause == null)
			return null;
		
		return fiveGMMCause.getUnsigned();
	}
	
	public void set5GMMCause(Long value)
	{
		if(value==null)
			this.fiveGMMCause = null;
		else
			this.fiveGMMCause = new FiveGMMCauseImpl(value, null, null);
	}
	
	public Long get5GSMCause()
	{
		if(fiveGSMCause == null)
			return null;
		
		return fiveGSMCause.getUnsigned();
	}
	
	public void set5GSMCause(Long value)
	{
		if(value==null)
			this.fiveGSMCause = null;
		else
			this.fiveGSMCause = new FiveGSMCauseImpl(value, null, null);
	}
	
	public NGAPCause getNGAPCause()
	{
		return ngapCause;
	}
	
	public void setNGAPCause(NGAPCause value)
	{
		this.ngapCause = value;
	}
}