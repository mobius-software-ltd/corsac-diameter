package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingIdentifierValueImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AccessNetworkChargingIdentifierGx;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANSessionChargingScope;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANSessionChargingScopeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifierValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1022L, vendorId = KnownVendorIDs.TGPP_ID)
public class AccessNetworkChargingIdentifierGxImpl extends DiameterGroupedAvpImpl implements AccessNetworkChargingIdentifierGx
{
	private AccessNetworkChargingIdentifierValue accessNetworkChargingIdentifierValue;
	private List<ChargingRuleBaseName> chargingRuleBaseName;
	private List<ChargingRuleName> chargingRuleName; 
	private IPCANSessionChargingScope ipcanSessionChargingScope;
	
	protected AccessNetworkChargingIdentifierGxImpl()
	{
		
	}
	
	public AccessNetworkChargingIdentifierGxImpl(ByteBuf accessNetworkChargingIdentifierValue)
	{
		if(accessNetworkChargingIdentifierValue==null)
			throw new IllegalArgumentException("Access-Network-Charging-Identifier-Value is required");
		
		this.accessNetworkChargingIdentifierValue = new AccessNetworkChargingIdentifierValueImpl(accessNetworkChargingIdentifierValue, null, null);				
	}
	
	public ByteBuf getAccessNetworkChargingIdentifierValue()
	{
		if(accessNetworkChargingIdentifierValue==null)
			return null;
		
		return accessNetworkChargingIdentifierValue.getValue();
	}
	
	public void setAccessNetworkChargingIdentifierValue(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Access-Network-Charging-Identifier-Value is required");
		
		this.accessNetworkChargingIdentifierValue = new AccessNetworkChargingIdentifierValueImpl(value, null, null);				
	}
	
	public List<String> getChargingRuleBaseName()
	{
		if(chargingRuleBaseName==null || chargingRuleBaseName.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ChargingRuleBaseName curr:chargingRuleBaseName)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setChargingRuleBaseName(List<String> value)
	{
		if(value==null || value.size()==0)
			this.chargingRuleBaseName = null;
		else
		{
			this.chargingRuleBaseName = new ArrayList<ChargingRuleBaseName>();
			for(String curr:value)
				this.chargingRuleBaseName.add(new ChargingRuleBaseNameImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getChargingRuleName()
	{
		if(chargingRuleName==null || chargingRuleName.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ChargingRuleName curr:chargingRuleName)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setChargingRuleName(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.chargingRuleName = null;
		else
		{
			this.chargingRuleName = new ArrayList<ChargingRuleName>();
			for(ByteBuf curr:value)
				this.chargingRuleName.add(new ChargingRuleNameImpl(curr, null, null));			
		}
	}
	
	public IPCANSessionChargingScopeEnum getIPCANSessionChargingScope()
	{
		if(ipcanSessionChargingScope==null)
			return null;
		
		return ipcanSessionChargingScope.getEnumerated(IPCANSessionChargingScopeEnum.class);
	}
	
	public void setIPCANSessionChargingScope(IPCANSessionChargingScopeEnum value)
	{
		if(value==null)
			this.ipcanSessionChargingScope = null;
		else
			this.ipcanSessionChargingScope = new IPCANSessionChargingScopeImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(accessNetworkChargingIdentifierValue==null)
			return "Access-Network-Charging-Identifier-Value is required";
		
		return null;
	}		  
}