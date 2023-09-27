package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.CodeReceivingSecurityMaterial;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DUCK;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DUIK;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DUSK;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.EncryptedBitmask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MICCheckIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MICCheckIndicatorEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3860L, vendorId = KnownVendorIDs.TGPP_ID)
public class CodeReceivingSecurityMaterialImpl extends DiameterGroupedAvpImpl implements CodeReceivingSecurityMaterial
{
	private DUSK dusk;
	private DUIK duik;
	private MICCheckIndicator micCheckIndicator;
	private DUCK duck;
	private EncryptedBitmask encryptedBitmask;
			
	public CodeReceivingSecurityMaterialImpl()
	{
		
	}
	
	public ByteBuf getDUSK()
	{
		if(dusk==null)
			return null;
		
		return dusk.getValue();
	}
	
	public void setDUSK(ByteBuf value)
	{
		if(value==null)
			this.dusk = null;
		else
			this.dusk = new DUSKImpl(value, null, null);			
	}
	
	public ByteBuf getDUIK()
	{
		if(duik==null)
			return null;
		
		return duik.getValue();
	}
	
	public void setDUIK(ByteBuf value)
	{
		if(value==null)
			this.duik = null;
		else
			this.duik = new DUIKImpl(value, null, null);			
	}
	
	public MICCheckIndicatorEnum getMICCheckIndicator()
	{
		if(micCheckIndicator==null)
			return null;
		
		return micCheckIndicator.getEnumerated(MICCheckIndicatorEnum.class);
	}
	
	public void setMICCheckIndicator(MICCheckIndicatorEnum value)
	{
		if(value==null)
			this.micCheckIndicator = null;
		else
			this.micCheckIndicator = new MICCheckIndicatorImpl(value, null, null);			
	}
	
	public ByteBuf getDUCK()
	{
		if(duck==null)
			return null;
		
		return duck.getValue();
	}
	
	public void setDUCK(ByteBuf value)
	{
		if(value==null)
			this.duck = null;
		else
			this.duck = new DUCKImpl(value, null, null);			
	}
	
	public ByteBuf getEncryptedBitmask()
	{
		if(encryptedBitmask==null)
			return null;
		
		return encryptedBitmask.getValue();
	}
	
	public void setEncryptedBitmask(ByteBuf value)
	{
		if(value==null)
			this.encryptedBitmask = null;
		else
			this.encryptedBitmask = new EncryptedBitmaskImpl(value, null, null);			
	}
}