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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterEnumeratedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class TGPPOCRequestTypeImpl extends DiameterEnumeratedImpl<TGPPOCRequestTypeEnum> implements TGPPOCRequestType
{
	protected TGPPOCRequestTypeImpl()
	{
		super();
	}

	protected TGPPOCRequestTypeImpl(Integer minValue, Integer maxValue)
	{
		super(minValue, maxValue);
	}

	public TGPPOCRequestTypeImpl(TGPPOCRequestTypeEnum value, Integer minValue, Integer maxValue)
	{
		super(value, minValue, maxValue);
	}
}