package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PrimaryChargingCollectionFunctionName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PrimaryEventChargingFunctionName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SecondaryChargingCollectionFunctionName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SecondaryEventChargingFunctionName;

/**
*
* @author yulian oifa
*
*/
public class ChargingInformationImpl extends DiameterGroupedAvpImpl implements ChargingInformation
{
	private PrimaryEventChargingFunctionName primaryEventChargingFunctionName;
	
	private SecondaryEventChargingFunctionName secondaryEventChargingFunctionName;
	
	private PrimaryChargingCollectionFunctionName primaryChargingCollectionFunctionName;
	
	private SecondaryChargingCollectionFunctionName secondaryChargingCollectionFunctionName;
	
	public ChargingInformationImpl()
	{
		
	}
	
	public String getPrimaryEventChargingFunctionName()
	{
		if(primaryEventChargingFunctionName==null)
			return null;
		
		return primaryEventChargingFunctionName.getUri();
	}
	
	public void setPrimaryEventChargingFunctionName(String value) throws InvalidAvpValueException
	{
		if(value == null)
			this.primaryEventChargingFunctionName = null;
		else
			this.primaryEventChargingFunctionName = new PrimaryEventChargingFunctionNameImpl(value, null, null);
	}
	
	public String getSecondaryEventChargingFunctionName()
	{
		if(secondaryEventChargingFunctionName==null)
			return null;
		
		return secondaryEventChargingFunctionName.getUri();
	}
	
	public void setSecondaryEventChargingFunctionName(String value) throws InvalidAvpValueException
	{
		if(value == null)
			this.secondaryEventChargingFunctionName = null;
		else
			this.secondaryEventChargingFunctionName = new SecondaryEventChargingFunctionNameImpl(value, null, null);
	}
	
	public String getPrimaryChargingCollectionFunctionName()
	{
		if(primaryChargingCollectionFunctionName==null)
			return null;
		
		return primaryChargingCollectionFunctionName.getUri();
	}
	
	public void setPrimaryChargingCollectionFunctionName(String value) throws InvalidAvpValueException
	{
		if(value == null)
			this.primaryChargingCollectionFunctionName = null;
		else
			this.primaryChargingCollectionFunctionName = new PrimaryChargingCollectionFunctionNameImpl(value, null, null);
	}
	
	public String getSecondaryChargingCollectionFunctionName()
	{
		if(secondaryChargingCollectionFunctionName==null)
			return null;
		
		return secondaryChargingCollectionFunctionName.getUri();
	}
	
	public void setSecondaryChargingCollectionFunctionName(String value) throws InvalidAvpValueException
	{
		if(value == null)
			this.secondaryChargingCollectionFunctionName = null;
		else
			this.secondaryChargingCollectionFunctionName = new SecondaryChargingCollectionFunctionNameImpl(value, null, null);
	}
}