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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformationAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformationActionEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 570L, vendorId = KnownVendorIDs.TGPP_ID)
public class MAInformationImpl extends DiameterGroupedAvpImpl implements MAInformation
{
	private IPCANType ipCANType;
	
	private RATType ratType;
	
	private MAInformationAction maInformationAction;
	
	public MAInformationImpl()
	{
		
	}
	
	public IPCANTypeEnum getIPCANType()
	{
		if(ipCANType == null)
			return null;
		
		return ipCANType.getEnumerated(IPCANTypeEnum.class);
	}
	
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipCANType = null;
		else
			this.ipCANType = new IPCANTypeImpl(value, null, null);
	}
	
	public RATTypeEnum getRATType()
	{
		if(ratType == null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);
	}

	public MAInformationActionEnum getMAInformationAction()
	{
		if(maInformationAction == null)
			return null;
		
		return maInformationAction.getEnumerated(MAInformationActionEnum.class);
	}
	
	public void setMAInformationAction(MAInformationActionEnum value)
	{
		if(value==null)
			this.maInformationAction = null;
		else
			this.maInformationAction = new MAInformationActionImpl(value, null, null);
	}
}