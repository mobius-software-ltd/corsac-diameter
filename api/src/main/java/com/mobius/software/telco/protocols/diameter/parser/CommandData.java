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

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;

/**
*
* @author yulian oifa
*
*/
public class CommandData implements ChildData
{
	private List<AvpData> orderedAvpData;
	private String name;
	private ConcurrentHashMap<DiameterAvpKey,AvpData> avpData;
	private Class<?> clazz;
	private Integer commandCode;
	private Long applicationID;
	private Method validateMethod;
	private Method orderMethod;
	private Boolean isRequest;
	private Boolean isProxyable;
	
	public CommandData(Class<?> clazz,String name,Integer commandCode, Long applicationID, Method validateMethod,Method orderMethod,Boolean isRequest,Boolean isProxyable)
	{
		this.clazz = clazz;
		this.name = name;
		this.commandCode = commandCode;
		this.applicationID = applicationID;
		this.validateMethod = validateMethod;
		this.orderMethod = orderMethod;
		this.isProxyable = isProxyable;
		this.isRequest = isRequest;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
	
	public void setAvpData(ConcurrentHashMap<DiameterAvpKey,AvpData> avpData)
	{
		this.avpData = avpData;
	}
	
	public Boolean getIsRequest()
	{
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest)
	{
		this.isRequest = isRequest;
	}

	public Boolean getIsProxyable()
	{
		return isProxyable;
	}

	public void setIsProxyable(Boolean isProxyable)
	{
		this.isProxyable = isProxyable;
	}	
	
	public void setOrderedAvpData(List<AvpData> orderedAvpData)
	{
		this.orderedAvpData = orderedAvpData;
	}
	
	public List<AvpData> getAvpOrderedData()
	{
		return orderedAvpData;
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

	public Integer getCommandCode()
	{
		return commandCode;
	}

	public void setCommandCode(Integer commandCode)
	{
		this.commandCode = commandCode;
	}

	public Long getApplicationID()
	{
		return applicationID;
	}

	public void setApplicationID(Long applicationID)
	{
		this.applicationID = applicationID;
	}		
}