package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificAnswer;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public abstract class VendorSpecificAnswerImpl extends DiameterAnswerWithSessionBase implements VendorSpecificAnswer
{
	private VendorSpecificApplicationId vendorSpecificApplicationId;
	
	protected VendorSpecificAnswerImpl() 
	{
		super();
	}
	
	public VendorSpecificAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);		
	}

	@Override
	public VendorSpecificApplicationId getVendorSpecificApplicationId() 
	{
		return vendorSpecificApplicationId;
	}

	@Override
	public void setVendorSpecificApplicationId(VendorSpecificApplicationId value) 
	{
		this.vendorSpecificApplicationId = value;
	}
}