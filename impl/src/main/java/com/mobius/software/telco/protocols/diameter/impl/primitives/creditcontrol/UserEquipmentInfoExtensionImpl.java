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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class UserEquipmentInfoExtensionImpl extends DiameterGroupedAvpImpl implements UserEquipmentInfoExtension
{
	private UserEquipmentInfoIMEISV imeiSV;
	
	private UserEquipmentInfoMAC mac;
	
	private UserEquipmentInfoEUI64 eui64;
	
	private UserEquipmentInfoModifiedEUI64 modifiedEUI64;
	
	private UserEquipmentInfoIMEI imei;
	
	public UserEquipmentInfoExtensionImpl() 
	{
	}
	
	public UserEquipmentInfoExtensionImpl(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) throws MissingAvpException, AvpOccursTooManyTimesException 
	{
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>(); 
		Integer itemsDefined = 0;
		if(imeiSV!=null)
		{
			itemsDefined ++;
			this.imeiSV = new UserEquipmentInfoIMEISVImpl(imeiSV, null, null);
			avps.add(this.imeiSV);
		}
		
		if(mac!=null)
		{
			itemsDefined ++;
			this.mac = new UserEquipmentInfoMACImpl(mac, null, null);
			avps.add(this.mac);
		}
		
		if(eui64!=null)
		{
			itemsDefined ++;
			this.eui64 = new UserEquipmentInfoEUI64Impl(eui64, null, null);
			avps.add(this.eui64);
		}
		
		if(modifiedEUI64!=null)
		{
			itemsDefined ++;
			this.modifiedEUI64 = new UserEquipmentInfoModifiedEUI64Impl(modifiedEUI64, null, null);
			avps.add(this.modifiedEUI64);
		}
		
		if(imei!=null)
		{
			itemsDefined ++;
			this.imei = new UserEquipmentInfoIMEIImpl(imei, null, null);
			avps.add(this.imei);
		}
		
		if(itemsDefined==0)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		if(itemsDefined>1)
			throw new AvpOccursTooManyTimesException("User-Equipment-Info-Extension requires exactly one child to be defined",  avps);		
	}
	
	public ByteBuf getIMEISV()
	{
		if(imeiSV==null)
			return null;
		
		return imeiSV.getValue();
	}
	
	public void setIMEISV(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		this.imeiSV = new UserEquipmentInfoIMEISVImpl(value, null, null);				
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
	
	public void setMAC(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		this.mac = new UserEquipmentInfoMACImpl(value, null, null);				
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
	
	public void setEUI64(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		this.eui64 = new UserEquipmentInfoEUI64Impl(value, null, null);				
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
	
	public void setModifiedEUI64(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		this.modifiedEUI64 = new UserEquipmentInfoModifiedEUI64Impl(value, null, null);				
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
	
	public void setIMEI(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		this.imei = new UserEquipmentInfoIMEIImpl(value, null, null);				
		this.imeiSV = null;
		this.mac = null;
		this.eui64 = null;
		this.modifiedEUI64 = null;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
		
		Integer itemsDefined = 0;
		if(imeiSV!=null)
		{
			itemsDefined ++;
			avps.add(imeiSV);
		}
		
		if(mac!=null)
		{
			itemsDefined ++;
			avps.add(mac);
		}
		
		if(eui64!=null)
		{
			itemsDefined ++;
			avps.add(eui64);
		}
		
		if(modifiedEUI64!=null)
		{
			itemsDefined ++;
			avps.add(modifiedEUI64);
		}
		
		if(imei!=null)
		{
			itemsDefined ++;
			avps.add(imei);
		}
		
		if(itemsDefined==0)
			return new MissingAvpException("User-Equipment-Info-Extension requires exactly one child to be defined", Arrays.asList(new DiameterAvp[] {}));
		
		if(itemsDefined!=1)
			return  new AvpOccursTooManyTimesException("User-Equipment-Info-Extension requires exactly one child to be defined", avps);
			
		return null;
	}
}