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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeAllowedPLMN;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3701L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeSubscriptionDataImpl extends DiameterGroupedAvpImpl implements ProSeSubscriptionData
{
	private ProSePermission proSePermission;
	
	private List<ProSeAllowedPLMN> proSeAllowedPLMN;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	protected ProSeSubscriptionDataImpl()
	{
		super();
	}
	
	public ProSeSubscriptionDataImpl(Long proSePermission)
	{
		if(proSePermission == null)
			throw new IllegalArgumentException("ProSe-Permission is required");
		
		this.proSePermission = new ProSePermissionImpl(proSePermission, null, null);
		
	}
	
	public Long getProSePermission()
	{
		if(proSePermission==null)
			return null;
		
		return proSePermission.getUnsigned();
	}
	
	public void setProSePermission(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("ProSe-Permission is required");
		
		this.proSePermission = new ProSePermissionImpl(value, null, null);
		
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
	public String validate()
	{
		if(proSePermission == null)
			return "ProSe-Permission is required";
		
		return null;
	}
}