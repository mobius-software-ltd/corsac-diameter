package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DiversionCount;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DiversionReason;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DiversionReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SDPMediaIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SDPMediaIdentifierEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 876L, vendorId = KnownVendorIDs.TGPP_ID)
public class IMSInformationImpl extends com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.IMSInformationImpl implements IMSInformation 
{
	private DiversionReason diversionReason;
	
	private DiversionCount diversionCount;
	
	private SDPMediaIdentifier sdpMediaIdentifier;
	
	public IMSInformationImpl()
	{
	}
	
	@Override
	public DiversionReasonEnum getDiversionReason()
	{
		if(diversionReason==null)
			return null;
		
		return diversionReason.getEnumerated(DiversionReasonEnum.class);
	}
	
	@Override
	public void setDiversionReason(DiversionReasonEnum value)
	{
		if(value==null)
			this.diversionReason = null;
		else
			this.diversionReason = new DiversionReasonImpl(value, null, null);
	}
	
	@Override
	public Long getDiversionCount()
	{
		if(diversionCount==null)
			return null;
		
		return diversionCount.getUnsigned();
	}
	
	@Override
	public void setDiversionCount(Long value)
	{
		if(value==null)
			this.diversionCount = null;
		else
			this.diversionCount = new DiversionCountImpl(value, null, null);
	}
	
	@Override
	public SDPMediaIdentifierEnum getSDPMediaIdentifier()
	{
		if(sdpMediaIdentifier==null)
			return null;
		
		return sdpMediaIdentifier.getEnumerated(SDPMediaIdentifierEnum.class);
	}
	
	@Override
	public void setSDPMediaIdentifier(SDPMediaIdentifierEnum value)
	{
		if(value==null)
			this.sdpMediaIdentifier = null;
		else
			this.sdpMediaIdentifier = new SDPMediaIdentifierImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		//required to clear the parent validation of field that is not used for Huawei
		return null;
	}
}