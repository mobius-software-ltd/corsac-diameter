package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsage;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 446L, vendorId = -1)
public class UsedServiceUnitImpl extends RequestedServiceUnitImpl implements UsedServiceUnit
{
	private TariffChangeUsage tariffChangeUsage;
	
	protected UsedServiceUnitImpl()
	{
		super();
	}
	
	public UsedServiceUnitImpl(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage)
	{
		super(ccTime, ccMoney, ccTotalOctets, ccInputOctets, ccOutputOctets, ccServiceSpecificUnits);
		
		if(tariffChangeUsage!=null)
			this.tariffChangeUsage = new TariffChangeUsageImpl(tariffChangeUsage, null, null);
	}
	
	public TariffChangeUsageEnum getTariffChangeUsage()
	{		
		if(tariffChangeUsage == null)
			return null;
		
		return tariffChangeUsage.getEnumerated(TariffChangeUsageEnum.class);
	}
	
	public void setTariffChangeUsage(TariffChangeUsageEnum tariffChangeUsage)
	{
		if(tariffChangeUsage == null)
			this.tariffChangeUsage = null;
		else
			this.tariffChangeUsage = new TariffChangeUsageImpl(tariffChangeUsage, null, null);
	}
}