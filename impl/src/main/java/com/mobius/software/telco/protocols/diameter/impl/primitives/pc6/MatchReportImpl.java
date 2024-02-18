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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReport;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PC5Tech;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeApplicationMetadata;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeMatchRefreshTimer;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeMetadataIndexMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeValidityTimer;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MatchReportImpl extends DiameterGroupedAvpImpl implements MatchReport
{
	private DiscoveryType discoveryType;
	private ProSeAppCode proSeAppCode;
	private ProSeMetadataIndexMask proSeMetadataIndexMask;
	private ProSeAppId proSeAppId;
	private ProSeValidityTimer proSeValidityTimer;
	private ProSeMatchRefreshTimer proSeMatchRefreshTimer;
	private ProSeApplicationMetadata proSeApplicationMetadata;
	private PC5Tech pc5Tech;
			 
	protected MatchReportImpl() 
	{
	}
	
	public MatchReportImpl(DiscoveryTypeEnum discoveryType) throws MissingAvpException
	{
		setDiscoveryType(discoveryType);
	}
	
	public DiscoveryTypeEnum getDiscoveryType()
	{
		if(discoveryType==null)
			return null;
		
		return discoveryType.getEnumerated(DiscoveryTypeEnum.class);
	}
	
	public void setDiscoveryType(DiscoveryTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Discovery-Type is required", Arrays.asList(new DiameterAvp[] { new DiscoveryTypeImpl() }));
		
		this.discoveryType = new DiscoveryTypeImpl(value, null, null);						
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value)
	{
		if(value==null)
			this.proSeAppCode = null;
		else
			this.proSeAppCode = new ProSeAppCodeImpl(value, null, null);			
	}
	
	public ByteBuf getProSeMetadataIndexMask()
	{
		if(proSeMetadataIndexMask==null)
			return null;
		
		return proSeMetadataIndexMask.getValue();
	}
	
	public void setProSeMetadataIndexMask(ByteBuf value)
	{
		if(value==null)
			this.proSeMetadataIndexMask = null;
		else
			this.proSeMetadataIndexMask = new ProSeMetadataIndexMaskImpl(value, null, null);			
	}
	
	public String getProSeAppId()
	{
		if(proSeAppId==null)
			return null;
		
		return proSeAppId.getString();
	}
	
	public void setProSeAppId(String value)
	{
		if(value==null)
			this.proSeAppId = null;
		else
			this.proSeAppId = new ProSeAppIdImpl(value, null, null);			
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
	
	public Long getProSeMatchRefreshTimer()
	{
		if(proSeMatchRefreshTimer==null)
			return null;
		
		return proSeMatchRefreshTimer.getUnsigned();
	}
	
	public void setProSeMatchRefreshTimer(Long value)
	{
		if(value==null)
			this.proSeMatchRefreshTimer = null;
		else
			this.proSeMatchRefreshTimer = new ProSeMatchRefreshTimerImpl(value, null, null);			
	}
	
	public String getProSeApplicationMetadata()
	{
		if(proSeApplicationMetadata==null)
			return null;
		
		return proSeApplicationMetadata.getString();
	}
	
	public void setProSeApplicationMetadata(String value)
	{
		if(value==null)
			this.proSeApplicationMetadata = null;
		else
			this.proSeApplicationMetadata = new ProSeApplicationMetadataImpl(value, null, null);			
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
	public DiameterException validate()
	{
		if(discoveryType==null)
			return new MissingAvpException("Discovery-Type is required", Arrays.asList(new DiameterAvp[] { new DiscoveryTypeImpl() }));
		
		return null;
	}
}