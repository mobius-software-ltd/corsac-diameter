package com.mobius.software.telco.protocols.diameter.parser;
/*
 * Mobius Software LTD, Open Source Cloud Communications
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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;

/**
*
* @author yulian oifa
*
*/
public class AvpData implements ChildData
{
	private Class<?> clazz;
	private Field field;
	private List<AvpData> orderedAvpData;
	private ConcurrentHashMap<DiameterAvpKey,AvpData> avpData;
	private Method validateMethod;
	private Method orderMethod;
	private Method encodeMethod;
	private Method decodeMethod;
	private Method lengthMethod;
	private Long vendorID;
	private Long avpID;
	private Boolean isMust;
	
	public AvpData(Class<?> clazz,Field field,Long vendorID, Long avpID, Boolean isMust, Method validateMethod, Method orderMethod, Method encodeMethod, Method decodeMethod, Method lengthMethod)
	{
		this.clazz = clazz;
		this.field = field;
		this.vendorID = vendorID;
		this.avpID = avpID;
		this.isMust = isMust;
		this.validateMethod = validateMethod;
		this.encodeMethod = encodeMethod;
		this.decodeMethod = decodeMethod;
		this.lengthMethod = lengthMethod;
	}

	public Method getValidateMethod()
	{
		return validateMethod;
	}

	public void setValidateMethod(Method validateMethod)
	{
		this.validateMethod = validateMethod;
	}

	public Method getOrderMethod()
	{
		return orderMethod;
	}

	public void setOrderMethod(Method orderMethod)
	{
		this.orderMethod = orderMethod;
	}

	public Method getEncodeMethod()
	{
		return encodeMethod;
	}

	public void setEncodeMethod(Method encodeMethod)
	{
		this.encodeMethod = encodeMethod;
	}

	public Method getDecodeMethod()
	{
		return decodeMethod;
	}

	public void setDecodeMethod(Method decodeMethod)
	{
		this.decodeMethod = decodeMethod;
	}

	public Method getLengthMethod()
	{
		return lengthMethod;
	}

	public void setLengthMethod(Method lengthMethod)
	{
		this.lengthMethod = lengthMethod;
	}	
	
	public void setOrderedAvpData(List<AvpData> orderedAvpData)
	{
		this.orderedAvpData = orderedAvpData;
	}
	
	public List<AvpData> getAvpOrderedData()
	{
		return orderedAvpData;
	}	
	
	public void setAvpData(ConcurrentHashMap<DiameterAvpKey,AvpData> avpData)
	{
		this.avpData = avpData;
	}
	
	public void setAvpData(DiameterAvpKey avpKey,AvpData avpData)
	{
		if(this.avpData == null)
			this.avpData=new ConcurrentHashMap<DiameterAvpKey, AvpData>();
		
		this.avpData.put(avpKey, avpData);
	}
	
	public ConcurrentHashMap<DiameterAvpKey,AvpData> getAvpData()
	{
		return avpData;
	}
	
	public AvpData getAvp(DiameterAvpKey avpKey)
	{
		if(this.avpData == null)
			return null;
		
		return this.avpData.get(avpKey);
	}

	public Class<?> getClazz()
	{
		return clazz;
	}

	public void setClazz(Class<?> clazz)
	{
		this.clazz = clazz;
	}

	public Field getField()
	{
		return field;
	}

	public void setField(Field field)
	{
		this.field = field;
	}

	public Long getVendorID()
	{
		return vendorID;
	}

	public void setVendorID(Long vendorID)
	{
		this.vendorID = vendorID;
	}

	public Long getAvpID()
	{
		return avpID;
	}

	public void setAvpID(Long avpID)
	{
		this.avpID = avpID;
	}

	public Boolean getIsMust()
	{
		return isMust;
	}

	public void setIsMust(Boolean isMust)
	{
		this.isMust = isMust;
	}			
}