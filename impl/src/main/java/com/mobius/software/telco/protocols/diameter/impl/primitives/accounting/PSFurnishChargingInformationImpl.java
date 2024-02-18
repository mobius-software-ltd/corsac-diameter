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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSAppendFreeFormatData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSAppendFreeFormatDataEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSFreeFormatData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSFurnishChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class PSFurnishChargingInformationImpl implements PSFurnishChargingInformation
{
	private TGPPChargingId tgppChargingId;
	private PSFreeFormatData psFreeFormatData;
	private PSAppendFreeFormatData psAppendFreeFormatData;
		
	protected PSFurnishChargingInformationImpl() 
	{
	}
	
	public PSFurnishChargingInformationImpl(ByteBuf tgppChargingId,ByteBuf psFreeFormatData) throws MissingAvpException
	{
		setTGPPChargingId(tgppChargingId);
		
		setPSFreeFormatData(psFreeFormatData);
	}
	
	public ByteBuf getTGPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	public void setTGPPChargingId(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("3GPP-Charging-Id is required", Arrays.asList(new DiameterAvp[] { new TGPPChargingIdImpl() }));
		
		this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);		
	}
	
	public ByteBuf getPSFreeFormatData()
	{
		if(psFreeFormatData==null)
			return null;
		
		return psFreeFormatData.getValue();
	}
	
	public void setPSFreeFormatData(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("PS-Free-Format-Data is required", Arrays.asList(new DiameterAvp[] { new PSFreeFormatDataImpl() }));
		
		this.psFreeFormatData = new PSFreeFormatDataImpl(value, null, null);
	}
	
	public PSAppendFreeFormatDataEnum getPSAppendFreeFormatData()
	{
		if(psAppendFreeFormatData==null)
			return null;
		
		return psAppendFreeFormatData.getEnumerated(PSAppendFreeFormatDataEnum.class);
	}
	
	public void setPSAppendFreeFormatData(PSAppendFreeFormatDataEnum value)
	{
		if(value==null)
			this.psAppendFreeFormatData = null;
		else
			this.psAppendFreeFormatData = new PSAppendFreeFormatDataImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tgppChargingId==null)
			return new MissingAvpException("3GPP-Charging-Id is required", Arrays.asList(new DiameterAvp[] { new TGPPChargingIdImpl() }));
		
		if(psFreeFormatData==null)
			return new MissingAvpException("PS-Free-Format-Data is required", Arrays.asList(new DiameterAvp[] { new PSFreeFormatDataImpl() }));
		
		return null;
	}
}