package com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeAllowedPLMN;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;

/**
*
* @author yulian oifa
*
*/
public class ProSeSubscriptionDataImpl extends DiameterGroupedAvpImpl implements ProSeSubscriptionData
{
	private ProSePermission proSePermission;
	
	private List<ProSeAllowedPLMN> proSeAllowedPLMN;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	protected ProSeSubscriptionDataImpl()
	{
		super();
	}
	
	public ProSeSubscriptionDataImpl(ProSePermission proSePermission) throws MissingAvpException
	{
		setProSePermission(proSePermission);		
	}
	
	public ProSePermission getProSePermission()
	{
		return proSePermission;
	}
	
	public void setProSePermission(ProSePermission value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("ProSe-Permission is required is required", Arrays.asList(new DiameterAvp[] { new ProSePermissionImpl() }));
		
		this.proSePermission = value;		
	}
	
	public List<ProSeAllowedPLMN> getProSeAllowedPLMN()
	{
		return proSeAllowedPLMN;
	}
	
	public void setProSeAllowedPLMN(List<ProSeAllowedPLMN> value)
	{
		this.proSeAllowedPLMN = value;
	}
	
	public String getTGPPChargingCharacteristics()
	{
		if(tgppChargingCharacteristics == null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}
	
	public void setTGPPChargingCharacteristics(String value)
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(proSePermission == null)
			return new MissingAvpException("ProSe-Permission is required is required", Arrays.asList(new DiameterAvp[] { new ProSePermissionImpl() }));
		
		return null;
	}
}