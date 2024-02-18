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

import java.util.Arrays;
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.TariffTimeChangeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CurrentTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NextTariff;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffTimeChange;

/**
*
* @author yulian oifa
*
*/
public class TariffInformationImpl implements TariffInformation
{
	private CurrentTariff currentTariff;
	private TariffTimeChange tariffTimeChange;
	private NextTariff nextTariff;
			
	protected TariffInformationImpl() 
	{
	}
	
	public TariffInformationImpl(CurrentTariff currentTariff) throws MissingAvpException
	{
		setCurrentTariff(currentTariff);
	}
	
	public CurrentTariff getCurrentTariff()
	{
		return currentTariff;
	}
	
	public void setCurrentTariff(CurrentTariff value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Current-Tariff is required is required", Arrays.asList(new DiameterAvp[] { new CurrentTariffImpl() }));
		
		this.currentTariff = value;
	}
	
	public Date getTariffTimeChange()
	{
		if(tariffTimeChange==null)
			return null;
		
		return tariffTimeChange.getDateTime();
	}
	
	public void setTariffTimeChange(Date value)
	{
		if(value==null)
			this.tariffTimeChange = null;
		else
			this.tariffTimeChange = new TariffTimeChangeImpl(value, null, null);			
	}
	
	public NextTariff getNextTariff()
	{
		return nextTariff;
	}
	
	public void setNextTariff(NextTariff value)
	{
		this.nextTariff = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(currentTariff==null)
			return new MissingAvpException("Current-Tariff is required is required", Arrays.asList(new DiameterAvp[] { new CurrentTariffImpl() }));
		
		return null;
	}
}