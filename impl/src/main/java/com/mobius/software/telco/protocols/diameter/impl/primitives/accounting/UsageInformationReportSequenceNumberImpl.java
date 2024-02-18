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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterInteger32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UsageInformationReportSequenceNumber;

/**
*
* @author yulian oifa
*
*/
public class UsageInformationReportSequenceNumberImpl extends DiameterInteger32Impl implements UsageInformationReportSequenceNumber
{
	protected UsageInformationReportSequenceNumberImpl()
	{
		super();
	}

	protected UsageInformationReportSequenceNumberImpl(Integer minValue, Integer maxValue)
	{
		super(minValue, maxValue);
	}

	public UsageInformationReportSequenceNumberImpl(Integer value, Integer minValue, Integer maxValue)
	{
		super(value, minValue, maxValue);
	}
}