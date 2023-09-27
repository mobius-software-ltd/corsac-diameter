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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.CodeReceivingSecurityMaterial;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.CodeSendingSecurityMaterial;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DUIK;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthResponse;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PC5Tech;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeDiscoveryFilter;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeValidityTimer;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3855L, vendorId = KnownVendorIDs.TGPP_ID)
public class DiscoveryAuthResponseImpl extends DiameterGroupedAvpImpl implements DiscoveryAuthResponse
{
	private DiscoveryType discoveryType;
	private List<ProSeDiscoveryFilter> proSeDiscoveryFilter;
	private VisitedPLMNId visitedPLMNId;
	private ProSeRestrictedCode proSeRestrictedCode;
	private ProSeValidityTimer proSeValidityTimer;
	private CodeSendingSecurityMaterial codeSendingSecurityMaterial;
	private CodeReceivingSecurityMaterial codeReceivingSecurityMaterial;
	private DUIK duik;
	private PC5Tech pc5Tech;
			
	protected DiscoveryAuthResponseImpl() 
	{
	}
	
	public DiscoveryAuthResponseImpl(DiscoveryTypeEnum discoveryType)
	{
		if(discoveryType==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(discoveryType, null, null);						
	}
	
	public DiscoveryTypeEnum getDiscoveryType()
	{
		if(discoveryType==null)
			return null;
		
		return discoveryType.getEnumerated(DiscoveryTypeEnum.class);
	}
	
	public void setDiscoveryType(DiscoveryTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(value, null, null);						
	}
	
	public List<ProSeDiscoveryFilter> getProSeDiscoveryFilter()
	{
		return proSeDiscoveryFilter;
	}
	
	public void setProSeDiscoveryFilter(List<ProSeDiscoveryFilter> value)
	{
		this.proSeDiscoveryFilter = value;
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId==null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value==null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);			
	}
	
	public ByteBuf getProSeRestrictedCode()
	{
		if(proSeRestrictedCode==null)
			return null;
		
		return proSeRestrictedCode.getValue();
	}
	
	public void setProSeRestrictedCode(ByteBuf value)
	{
		if(value==null)
			this.proSeRestrictedCode = null;
		else
			this.proSeRestrictedCode = new ProSeRestrictedCodeImpl(value, null, null);			
	}
	
	public Long getProSeValidityTimer()
	{
		if(proSeValidityTimer==null)
			return null;
		
		return proSeValidityTimer.getUnsigned();
	}
	
	public void setProSeValidityTimer(Long value)
	{
		if(value==null)
			this.proSeValidityTimer = null;
		else
			this.proSeValidityTimer = new ProSeValidityTimerImpl(value, null, null);			
	}
	
	public CodeSendingSecurityMaterial getCodeSendingSecurityMaterial()
	{
		return codeSendingSecurityMaterial;
	}
	
	public void setCodeSendingSecurityMaterial(CodeSendingSecurityMaterial value)
	{
		this.codeSendingSecurityMaterial = value;
	}
	
	public CodeReceivingSecurityMaterial getCodeReceivingSecurityMaterial()
	{
		return this.codeReceivingSecurityMaterial;
	}
	
	public void setCodeReceivingSecurityMaterial(CodeReceivingSecurityMaterial value)
	{
		this.codeReceivingSecurityMaterial = value;
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
	
	public ByteBuf getPC5Tech()
	{
		if(pc5Tech==null)
			return null;
		
		return pc5Tech.getValue();
	}
	
	public void setPC5Tech(ByteBuf value)
	{
		if(value==null)
			this.pc5Tech = null;
		else
			this.pc5Tech = new PC5TechImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(discoveryType==null)
			return "Discovery-Type is required";
		
		return null;
	}
}