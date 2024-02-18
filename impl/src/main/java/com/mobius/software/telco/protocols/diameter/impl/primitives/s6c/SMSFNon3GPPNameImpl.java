package com.mobius.software.telco.protocols.diameter.impl.primitives.s6c;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPName;

/**
*
* @author yulian oifa
*
*/
public class SMSFNon3GPPNameImpl extends DiameterIdentityImpl implements SMSFNon3GPPName
{
	protected SMSFNon3GPPNameImpl()
	{
		super();
	}

	protected SMSFNon3GPPNameImpl(Integer minLength, Integer maxLength)
	{
		super(minLength, maxLength);
	}

	public SMSFNon3GPPNameImpl(String value, Integer minLength, Integer maxLength)
	{
		super(value, minLength, maxLength);
	}
}