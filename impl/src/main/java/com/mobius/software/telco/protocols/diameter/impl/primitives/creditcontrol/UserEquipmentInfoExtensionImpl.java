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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoEUI64;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoIMEI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoIMEISV;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoMAC;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoModifiedEUI64;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 653L, vendorId = -1)
public class UserEquipmentInfoExtensionImpl extends DiameterGroupedAvpImpl implements UserEquipmentInfoExtension
{
	private UserEquipmentInfoIMEISV imeiSV;
	
	private UserEquipmentInfoMAC mac;
	
	private UserEquipmentInfoEUI64 eui64;
	
	private UserEquipmentInfoModifiedEUI64 modifiedEUI64;
	
	private UserEquipmentInfoIMEI imei;
	
	protected UserEquipmentInfoExtensionImpl() 
	{
	}
	
	public UserEquipmentInfoExtensionImpl(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) 
	{
		Integer itemsDefined = 0;
		if(imeiSV!=null)
		{
			itemsDefined ++;
			this.imeiSV = new UserEquipmentInfoIMEISVImpl(imeiSV, null, null);
		}
		
		if(mac!=null)
		{
			itemsDefined ++;
			this.mac = new UserEquipmentInfoMACImpl(mac, null, null);
		}
		
		if(eui64!=null)
		{
			itemsDefined ++;
			this.eui64 = new UserEquipmentInfoEUI64Impl(eui64, null, null);
		}
		
		if(modifiedEUI64!=null)
		{
			itemsDefined ++;
			this.modifiedEUI64 = new UserEquipmentInfoModifiedEUI64Impl(modifiedEUI64, null, null);
		}
		
		if(imei!=null)
		{
			itemsDefined ++;
			this.imei = new UserEquipmentInfoIMEIImpl(imei, null, null);
		}
		
		if(itemsDefined!=1)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");		
	}
	
	public ByteBuf getIMEISV()
	{
		if(imeiSV==null)
			return null;
		
		return imeiSV.getValue();
	}
	
	public void setIMEISV(ByteBuf imeiSV)
	{
		if(this.imeiSV!=null && imeiSV==null)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");
		
		this.imeiSV = new UserEquipmentInfoIMEISVImpl(imeiSV, null, null);				
		this.mac = null;
		this.eui64 = null;
		this.modifiedEUI64 = null;
		this.imei = null;
	}
	
	public ByteBuf getMAC()
	{
		if(mac==null)
			return null;
		
		return mac.getValue();
	}
	
	public void setMAC(ByteBuf mac)
	{
		if(this.mac!=null && mac==null)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");
		
		this.mac = new UserEquipmentInfoMACImpl(mac, null, null);				
		this.imeiSV = null;
		this.eui64 = null;
		this.modifiedEUI64 = null;
		this.imei = null;
	}
	
	public ByteBuf getEUI64()
	{
		if(eui64==null)
			return null;
		
		return eui64.getValue();
	}
	
	public void setEUI64(ByteBuf eui64)
	{
		if(this.eui64!=null && eui64==null)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");
		
		this.eui64 = new UserEquipmentInfoEUI64Impl(eui64, null, null);				
		this.imeiSV = null;
		this.mac = null;
		this.modifiedEUI64 = null;
		this.imei = null;
	}
	
	public ByteBuf getModifiedEUI64()
	{
		if(modifiedEUI64==null)
			return null;
		
		return modifiedEUI64.getValue();
	}
	
	public void setModifiedEUI64(ByteBuf modifiedEUI64)
	{
		if(this.modifiedEUI64!=null && modifiedEUI64==null)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");
		
		this.modifiedEUI64 = new UserEquipmentInfoModifiedEUI64Impl(modifiedEUI64, null, null);				
		this.imeiSV = null;
		this.mac = null;
		this.eui64 = null;
		this.imei = null;
	}
	
	public ByteBuf getIMEI()
	{
		if(imei==null)
			return null;
		
		return imei.getValue();
	}
	
	public void setIMEI(ByteBuf imei)
	{
		if(this.imei!=null && imei==null)
			throw new IllegalArgumentException("User-Equipment-Info-Extension requires exactly one child to be defined");
		
		this.imei = new UserEquipmentInfoIMEIImpl(imei, null, null);				
		this.imeiSV = null;
		this.mac = null;
		this.eui64 = null;
		this.modifiedEUI64 = null;
	}
	
	@DiameterValidate
	public String validate()
	{
		Integer itemsDefined = 0;
		if(imeiSV!=null)
			itemsDefined ++;
		
		if(mac!=null)
			itemsDefined ++;
		
		if(eui64!=null)
			itemsDefined ++;
		
		if(modifiedEUI64!=null)
			itemsDefined ++;
		
		if(imei!=null)
			itemsDefined ++;
		
		if(itemsDefined!=1)
			return "User-Equipment-Info-Extension requires exactly one child to be defined";
		
		return null;
	}
}