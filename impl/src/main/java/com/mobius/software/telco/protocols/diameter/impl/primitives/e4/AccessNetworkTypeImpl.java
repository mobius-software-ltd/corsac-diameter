package com.mobius.software.telco.protocols.diameter.impl.primitives.e4;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AccessNetworkType;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AggregationNetworkType;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AggregationNetworkTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class AccessNetworkTypeImpl implements AccessNetworkType
{
	private NASPortType nasPortType;
	
	private AggregationNetworkType aggregationNetworkType;
	
	protected AccessNetworkTypeImpl()
	{
		
	}
	
	public AccessNetworkTypeImpl(NASPortTypeEnum nasPortType) throws MissingAvpException
	{
		setNASPortType(nasPortType);
	}
	
	public NASPortTypeEnum getNASPortType()
	{
		if(nasPortType==null)
			return null;
		
		return nasPortType.getEnumerated(NASPortTypeEnum.class);
	}
	
	public void setNASPortType(NASPortTypeEnum value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("NAS-Port-Type is required", Arrays.asList(new DiameterAvp[] { new NASPortTypeImpl() }));
			
		this.nasPortType = new NASPortTypeImpl(value, null, null);
		
	}
	
	public AggregationNetworkTypeEnum getAggregationNetworkType()
	{
		if(aggregationNetworkType==null)
			return null;
		
		return aggregationNetworkType.getEnumerated(AggregationNetworkTypeEnum.class);
	}
	
	public void setAggregationNetworkType(AggregationNetworkTypeEnum value)
	{
		if(value == null)
			this.aggregationNetworkType = null;
		else
			this.aggregationNetworkType = new AggregationNetworkTypeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(nasPortType == null)
			return new MissingAvpException("NAS-Port-Type is required", Arrays.asList(new DiameterAvp[] { new NASPortTypeImpl() }));
		
		return null;
	}
}