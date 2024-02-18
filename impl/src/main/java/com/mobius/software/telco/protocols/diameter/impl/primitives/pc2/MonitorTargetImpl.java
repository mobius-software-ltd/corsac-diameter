package com.mobius.software.telco.protocols.diameter.impl.primitives.pc2;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetRPAUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MetadataIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MetadataIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MonitorTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.PDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeCodeSuffixMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetRPAUID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MonitorTargetImpl extends DiameterGroupedAvpImpl implements MonitorTarget
{
	private TargetRPAUID targetRPAUID;
	private PDUID pduid;
	private MetadataIndicator metadataIndicator;
	private List<ProSeCodeSuffixMask> proSeCodeSuffixMask;
		
	protected MonitorTargetImpl() 
	{
	}
	
	public MonitorTargetImpl(String targetRPAUID,ByteBuf pduid) throws MissingAvpException
	{
		setTargetRPAUID(targetRPAUID);
		
		setPDUID(pduid);
	}
	
	public String getTargetRPAUID()
	{
		if(targetRPAUID==null)
			return null;
		
		return targetRPAUID.getString();
	}
	
	public void setTargetRPAUID(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Target-RPAUID is required", Arrays.asList(new DiameterAvp[] { new TargetRPAUIDImpl() }));
			
		this.targetRPAUID = new TargetRPAUIDImpl(value, null, null);
	}
	
	public ByteBuf getPDUID()
	{
		if(pduid==null)
			return null;
		
		return pduid.getValue();
	}
	
	public void setPDUID(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("PDUID is required", Arrays.asList(new DiameterAvp[] { new PDUIDImpl() }));
		
		this.pduid = new PDUIDImpl(value, null, null);
	}
	
	public MetadataIndicatorEnum getMetadataIndicator()
	{
		if(metadataIndicator==null)
			return null;
		
		return metadataIndicator.getEnumerated(MetadataIndicatorEnum.class);
	}
	
	public void setMetadataIndicator(MetadataIndicatorEnum value)
	{
		if(value == null)
			this.metadataIndicator = null;
		else
			this.metadataIndicator = new MetadataIndicatorImpl(value, null, null);			
	}
	
	public List<ProSeCodeSuffixMask> getProSeCodeSuffixMask()
	{
		return proSeCodeSuffixMask;
	}
	
	public void setProSeCodeSuffixMask(List<ProSeCodeSuffixMask> value)
	{
		this.proSeCodeSuffixMask = value;			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(targetRPAUID==null)
			return new MissingAvpException("Target-RPAUID is required", Arrays.asList(new DiameterAvp[] { new TargetRPAUIDImpl() }));
		
		if(pduid==null)
			return new MissingAvpException("PDUID is required", Arrays.asList(new DiameterAvp[] { new PDUIDImpl() }));
		
		return null;
	}
}