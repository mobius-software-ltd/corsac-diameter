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


import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcServiceSpecificUnits;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcTotalOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;

/**
*
* @author yulian oifa
*
*/
public class RequestedServiceUnitImpl extends DiameterGroupedAvpImpl implements RequestedServiceUnit
{
	private CcTime ccTime;
	
	private CCMoney ccMoney;
	
	private CcTotalOctets ccTotalOctets;
	
	private CcInputOctets ccInputOctets;
	
	private CcOutputOctets ccOutputOctets;
	
	private CcServiceSpecificUnits ccServiceSpecificUnits;
	
	public RequestedServiceUnitImpl()
	{		
	}
	
	public Long getCCTime()
	{
		if(this.ccTime == null)
			return null;
		
		return this.ccTime.getUnsigned();
	}
	
	public void setCCTime(Long value)
	{
		if(value == null)
			this.ccTime = null;
		else
			this.ccTime = new CcTimeImpl(value, null, null);
	}
	
	public CCMoney getCCMoney()
	{
		return ccMoney;
	}
	
	public void setCCMoney(CCMoney value)
	{
		this.ccMoney = value;
	}
	
	public Long getCCTotalOctets()
	{
		if(this.ccTotalOctets == null)
			return null;
		
		return this.ccTotalOctets.getLong();
	}
	
	public void setCCTotalOctets(Long value)
	{
		if(value == null)
			this.ccTotalOctets = null;
		else
			this.ccTotalOctets = new CcTotalOctetsImpl(value, null, null);
	}
	
	public Long getCCInputOctets()
	{
		if(this.ccInputOctets == null)
			return null;
		
		return this.ccInputOctets.getLong();
	}
	
	public void setCCInputOctets(Long value)
	{
		if(value == null)
			this.ccInputOctets = null;
		else
			this.ccInputOctets = new CcInputOctetsImpl(value, null, null);
	}
	
	public Long getCCOutputOctets()
	{
		if(this.ccOutputOctets == null)
			return null;
		
		return this.ccOutputOctets.getLong();
	}
	
	public void setCCOutputOctets(Long value)
	{
		if(value == null)
			this.ccOutputOctets = null;
		else
			this.ccOutputOctets = new CcOutputOctetsImpl(value, null, null);
	}
	
	public Long getCCServiceSpecificUnits()
	{
		if(this.ccServiceSpecificUnits == null)
			return null;
		
		return this.ccServiceSpecificUnits.getLong();
	}
	
	public void setCCServiceSpecificUnits(Long value)
	{
		if(value == null)
			this.ccServiceSpecificUnits = null;
		else
			this.ccServiceSpecificUnits = new CcServiceSpecificUnitsImpl(value, null, null);
	}
}