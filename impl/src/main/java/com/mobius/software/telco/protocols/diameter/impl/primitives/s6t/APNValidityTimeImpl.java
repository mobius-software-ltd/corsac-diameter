package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.APNValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GrantedValidityTime;

/**
*
* @author yulian oifa
*
*/
public class APNValidityTimeImpl extends DiameterGroupedAvpImpl implements APNValidityTime
{
	private GrantedValidityTime grantedValidityTime;
	
	private ServiceSelection serviceSelection;
	
	protected APNValidityTimeImpl()
	{
		
	}
	
	public APNValidityTimeImpl(Date grantedValidityTime) throws MissingAvpException
	{
		setGrantedValidityTime(grantedValidityTime);
	}
	
	public Date getGrantedValidityTime()
	{
		if(grantedValidityTime == null)
			return null;
		
		return grantedValidityTime.getDateTime();
	}
	
	public void setGrantedValidityTime(Date value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Granted-Validity-Time is required", Arrays.asList(new DiameterAvp[] { new GrantedValidityTimeImpl() }));

		this.grantedValidityTime = new GrantedValidityTimeImpl(value, null, null);
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value==null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(grantedValidityTime==null)
			return new MissingAvpException("Granted-Validity-Time is required", Arrays.asList(new DiameterAvp[] { new GrantedValidityTimeImpl() }));
		
		return null;
	}
}