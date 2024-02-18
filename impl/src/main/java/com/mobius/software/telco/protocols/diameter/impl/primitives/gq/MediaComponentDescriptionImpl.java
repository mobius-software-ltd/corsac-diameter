package com.mobius.software.telco.protocols.diameter.impl.primitives.gq;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFApplicationIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaComponentNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RRBandwidthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RSBandwidthImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaSubComponent;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RRBandwidth;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RSBandwidth;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MediaComponentDescriptionImpl extends DiameterGroupedAvpImpl implements MediaComponentDescription
{
	private MediaComponentNumber mediaComponentNumber;
	
	private List<MediaSubComponent> mediaSubComponent;
	
	private AFApplicationIdentifier afApplicationIdentifier;
	
	private MediaType mediaType;
	
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	private FlowStatus flowStatus;
	
	private RSBandwidth rsBandwidth;
	
	private RRBandwidth rrBandwidth;
		
	protected MediaComponentDescriptionImpl()
	{
		
	}
	
	public MediaComponentDescriptionImpl(Long mediaComponentNumber) throws MissingAvpException
	{
		setMediaComponentNumber(mediaComponentNumber);
	}
	
	public Long getMediaComponentNumber()
	{
		if(mediaComponentNumber == null)
			return null;
		
		return mediaComponentNumber.getUnsigned();
	}
	
	public void setMediaComponentNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Media-Component-Number is required", Arrays.asList(new DiameterAvp[] { new MediaComponentNumberImpl() }));
		
		this.mediaComponentNumber = new MediaComponentNumberImpl(value, null, null);
	}
	
	public List<MediaSubComponent> getMediaSubComponent()
	{
		return mediaSubComponent;
	}
	
	public void setMediaSubComponent(List<MediaSubComponent> value)
	{
		this.mediaSubComponent = value;
	}
	
	public ByteBuf getAFApplicationIdentifier()
	{
		if(afApplicationIdentifier == null)
			return null;
		
		return afApplicationIdentifier.getValue();
	}
	
	public void setAFApplicationIdentifier(ByteBuf value)
	{
		if(value == null)
			this.afApplicationIdentifier = null;
		else
			this.afApplicationIdentifier = new AFApplicationIdentifierImpl(value, null, null);
	}
	
	public MediaTypeEnum getMediaType()
	{
		if(mediaType == null)
			return null;
		
		return mediaType.getEnumerated(MediaTypeEnum.class);
	}
	
	public void setMediaType(MediaTypeEnum value)
	{
		if(value == null)
			this.mediaType = null;
		else
			this.mediaType = new MediaTypeImpl(value, null, null);
	}	
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL == null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);
	}	
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL == null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);
	}
	
	public FlowStatusEnum getFlowStatus()
	{
		if(flowStatus == null)
			return null;
		
		return flowStatus.getEnumerated(FlowStatusEnum.class);
	}
	
	public void setFlowStatus(FlowStatusEnum value)
	{
		if(value == null)
			this.flowStatus = null;
		else
			this.flowStatus = new FlowStatusImpl(value, null, null);
	}
	
	public Long getRSBandwidth()
	{
		if(rsBandwidth == null)
			return null;
		
		return rsBandwidth.getUnsigned();
	}
	
	public void setRSBandwidth(Long value)
	{
		if(value == null)
			this.rsBandwidth = null;
		else
			this.rsBandwidth = new RSBandwidthImpl(value, null, null);
	}
	
	public Long getRRBandwidth()
	{
		if(rrBandwidth == null)
			return null;
		
		return rrBandwidth.getUnsigned();
	}
	
	public void setRRBandwidth(Long value)
	{
		if(value == null)
			this.rrBandwidth = null;
		else
			this.rrBandwidth = new RRBandwidthImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mediaComponentNumber==null)
			return new MissingAvpException("Media-Component-Number is required", Arrays.asList(new DiameterAvp[] { new MediaComponentNumberImpl() }));
		
		return null;
	}
}