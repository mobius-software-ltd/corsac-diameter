package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc6734;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.Key;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyLifetime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyName;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeySPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.KeyingMaterial;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class KeyImpl extends DiameterGroupedAvpImpl implements Key
{
	public KeyType keyType;
	
	public KeyingMaterial keyingMaterial;
	
	public KeyLifetime keyLifetime;
	
	public KeyName keyName;
	
	public KeySPI keySPI;
	
	protected KeyImpl() 
	{
		super();
	}
	
	public KeyImpl(KeyTypeEnum keyType, ByteBuf keyingMaterial) throws MissingAvpException
	{
		setKeyType(keyType);
		
		setKeyingMaterial(keyingMaterial);
	}
	
	@Override
	public KeyTypeEnum getKeyType()
	{
		if(keyType == null)
			return null;
		
		return keyType.getEnumerated(KeyTypeEnum.class);
	}
	
	@Override
	public void setKeyType(KeyTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Key-Type is required", Arrays.asList(new DiameterAvp[] { new KeyTypeImpl() }));
			
		this.keyType = new KeyTypeImpl(value, null, null);		
	}
	
	@Override
	public ByteBuf getKeyingMaterial()
	{
		if(keyingMaterial == null)
			return null;
		
		return keyingMaterial.getValue();
	}
	
	@Override
	public void setKeyingMaterial(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Keying-Material is required", Arrays.asList(new DiameterAvp[] { new KeyingMaterialImpl() }));
			
		this.keyingMaterial = new KeyingMaterialImpl(value, null, null);		
	}
	
	@Override
	public Long getKeyLifetime()
	{
		if(keyLifetime == null)
			return null;
		
		return keyLifetime.getUnsigned();
	}
	
	@Override
	public void setKeyLifetime(Long value)
	{
		if(value==null)
			this.keyLifetime = null;
		else
			this.keyLifetime = new KeyLifetimeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getKeyName()
	{
		if(keyName == null)
			return null;
		
		return keyName.getValue();
	}
	
	@Override
	public void setKeyName(ByteBuf value)
	{
		if(value==null)
			this.keyName = null;
		else
			this.keyName = new KeyNameImpl(value, null, null);
	}
	
	@Override
	public Long getKeySPI()
	{
		if(keySPI == null)
			return null;
		
		return keySPI.getUnsigned();
	}
	
	@Override
	public void setKeySPI(Long value)
	{
		if(value==null)
			this.keySPI = null;
		else
			this.keySPI = new KeySPIImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(keyType == null)
			return new MissingAvpException("Key-Type is required", Arrays.asList(new DiameterAvp[] { new KeyTypeImpl() }));
		
		if(keyingMaterial == null)
			return new MissingAvpException("Keying-Material is required", Arrays.asList(new DiameterAvp[] { new KeyingMaterialImpl() }));
		
		return null;
	}
}