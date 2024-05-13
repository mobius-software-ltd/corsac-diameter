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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCCostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCSubscriptionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;

/**
*
* @author yulian oifa
*
*/
public class AoCInformationImpl extends DiameterAvpImpl implements AoCInformation
{
	private AoCCostInformation aocCostInformation;
	private TariffInformation tariffInformation;
	private AoCSubscriptionInformation aocSubscriptionInformation;
	   
	public AoCInformationImpl()
	{
		
	}
	
	public AoCCostInformation getAoCCostInformation()
	{
		return aocCostInformation;
	}
	
	public void setAoCCostInformation(AoCCostInformation value)
	{
		this.aocCostInformation = value;
	}
	
	public TariffInformation getTariffInformation()
	{
		return tariffInformation;
	}
	
	public void setTariffInformation(TariffInformation value)
	{
		this.tariffInformation = value;
	}	
	
	public AoCSubscriptionInformation getAoCSubscriptionInformation()
	{
		return aocSubscriptionInformation;
	}
	
	public void setAoCSubscriptionInformation(AoCSubscriptionInformation value)
	{
		this.aocSubscriptionInformation = value;
	}
}