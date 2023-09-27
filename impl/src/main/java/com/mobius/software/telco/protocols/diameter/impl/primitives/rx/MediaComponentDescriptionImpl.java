package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ReservationPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MaxPLRDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MaxPLRULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PreEmptionCapabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PreEmptionVulnerabilityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MaxPLRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MaxPLRUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionCapability;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionVulnerability;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PreEmptionVulnerabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CodecData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;
import com.mobius.software.telco.protocols.diameter.primitives.rx.DesiredMaxLatency;
import com.mobius.software.telco.protocols.diameter.primitives.rx.DesiredMaxLoss;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxSupportedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxSupportedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMinDesiredBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMinDesiredBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMinRequestedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMinRequestedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FLUSIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxSupportedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxSupportedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaSubComponent;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MinDesiredBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MinDesiredBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MinRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MinRequestedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.PrioritySharingIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.rx.PrioritySharingIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RRBandwidth;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RSBandwidth;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyUL;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 517L, vendorId = KnownVendorIDs.TGPP_ID)
public class MediaComponentDescriptionImpl extends DiameterGroupedAvpImpl implements MediaComponentDescription
{
	private MediaComponentNumber mediaComponentNumber;
	
	private List<MediaSubComponent> mediaSubComponent;
	
	private AFApplicationIdentifier afApplicationIdentifier;
	
	private FLUSIdentifier flusIdentifier;
	
	private MediaType mediaType;
	
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	private MaxSupportedBandwidthUL maxSupportedBandwidthUL;
	
	private MaxSupportedBandwidthDL maxSupportedBandwidthDL;
	
	private MinDesiredBandwidthUL minDesiredBandwidthUL;
	
	private MinDesiredBandwidthDL minDesiredBandwidthDL;
	
	private MinRequestedBandwidthUL minRequestedBandwidthUL;
	
	private MinRequestedBandwidthDL minRequestedBandwidthDL;
	
	private ExtendedMaxRequestedBWUL extendedMaxRequestedBWUL;
	
	private ExtendedMaxRequestedBWDL extendedMaxRequestedBWDL;
	
	private ExtendedMaxSupportedBWUL extendedMaxSupportedBWUL;
	
	private ExtendedMaxSupportedBWDL extendedMaxSupportedBWDL;
	
	private ExtendedMinDesiredBWUL extendedMinDesiredBWUL; 
	
	private ExtendedMinDesiredBWDL extendedMinDesiredBWDL;
	
	private ExtendedMinRequestedBWUL extendedMinRequestedBWUL;
	
	private ExtendedMinRequestedBWDL extendedMinRequestedBWDL;
	
	private FlowStatus flowStatus;
	
	private PrioritySharingIndicator prioritySharingIndicator; 
	
	private PreEmptionCapability preEmptionCapability;
	
	private PreEmptionVulnerability preEmptionVulnerability;
	
	private ReservationPriority reservationPriority;
	
	private RSBandwidth rsBandwidth;
	
	private RRBandwidth rrBandwidth;
	
	private List<CodecData> codecData;
	
	private SharingKeyDL sharingKeyDL;
	
	private SharingKeyUL sharingKeyUL;
	
	private ContentVersion contentVersion;
	
	private MaxPLRDL maxPLRDL;
	
	private MaxPLRUL maxPLRUL;
	
	private DesiredMaxLatency desiredMaxLatency;
	
	private DesiredMaxLoss desiredMaxLoss;
		
	protected MediaComponentDescriptionImpl()
	{
		
	}
	
	public MediaComponentDescriptionImpl(Long mediaComponentNumber)
	{
		if(mediaComponentNumber==null)
			throw new IllegalArgumentException("Media-Component-Number is required");
		
		this.mediaComponentNumber = new MediaComponentNumberImpl(mediaComponentNumber, null, null);
	}
	
	public Long getMediaComponentNumber()
	{
		if(mediaComponentNumber == null)
			return null;
		
		return mediaComponentNumber.getUnsigned();
	}
	
	public void setMediaComponentNumber(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Media-Component-Number is required");
		
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
	
	public ByteBuf getFLUSIdentifier()
	{
		if(flusIdentifier == null)
			return null;
		
		return flusIdentifier.getValue();
	}
	
	public void setFLUSIdentifier(ByteBuf value)
	{
		if(value == null)
			this.flusIdentifier = null;
		else
			this.flusIdentifier = new FLUSIdentifierImpl(value, null, null);
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
	
	public Long getMaxSuppportedBandwidthUL()
	{
		if(maxSupportedBandwidthUL == null)
			return null;
		
		return maxSupportedBandwidthUL.getUnsigned();
	}
	
	public void setMaxSuppportedBandwidthUL(Long value)
	{
		if(value == null)
			this.maxSupportedBandwidthUL = null;
		else
			this.maxSupportedBandwidthUL = new MaxSupportedBandwidthULImpl(value, null, null);
	}	
	
	public Long getMaxSuppportedBandwidthDL()
	{
		if(maxSupportedBandwidthDL == null)
			return null;
		
		return maxSupportedBandwidthDL.getUnsigned();
	}
	
	public void setMaxSuppportedBandwidthDL(Long value)
	{
		if(value == null)
			this.maxSupportedBandwidthDL = null;
		else
			this.maxSupportedBandwidthDL = new MaxSupportedBandwidthDLImpl(value, null, null);
	}
	
	public Long getMinDesiredBandwidthUL()
	{
		if(minDesiredBandwidthUL == null)
			return null;
		
		return minDesiredBandwidthUL.getUnsigned();
	}
	
	public void setMinDesiredBandwidthUL(Long value)
	{
		if(value == null)
			this.minDesiredBandwidthUL = null;
		else
			this.minDesiredBandwidthUL = new MinDesiredBandwidthULImpl(value, null, null);
	}	
	
	public Long getMinDesiredBandwidthDL()
	{
		if(minDesiredBandwidthDL == null)
			return null;
		
		return minDesiredBandwidthDL.getUnsigned();
	}
	
	public void setMinDesiredBandwidthDL(Long value)
	{
		if(value == null)
			this.minDesiredBandwidthDL = null;
		else
			this.minDesiredBandwidthDL = new MinDesiredBandwidthDLImpl(value, null, null);
	}
	
	public Long getMinRequestedBandwidthUL()
	{
		if(minRequestedBandwidthUL == null)
			return null;
		
		return minRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMinRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.minRequestedBandwidthUL = null;
		else
			this.minRequestedBandwidthUL = new MinRequestedBandwidthULImpl(value, null, null);
	}	
	
	public Long getMinRequestedBandwidthDL()
	{
		if(minRequestedBandwidthDL == null)
			return null;
		
		return minRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMinRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.minRequestedBandwidthDL = null;
		else
			this.minRequestedBandwidthDL = new MinRequestedBandwidthDLImpl(value, null, null);
	}
	
	public Long getExtendedMaxRequestedBandwidthUL()
	{
		if(extendedMaxRequestedBWUL == null)
			return null;
		
		return extendedMaxRequestedBWUL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.extendedMaxRequestedBWUL = null;
		else
			this.extendedMaxRequestedBWUL = new ExtendedMaxRequestedBWULImpl(value, null, null);
	}	
	
	public Long getExtendedMaxRequestedBandwidthDL()
	{
		if(extendedMaxRequestedBWDL == null)
			return null;
		
		return extendedMaxRequestedBWDL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.extendedMaxRequestedBWDL = null;
		else
			this.extendedMaxRequestedBWDL = new ExtendedMaxRequestedBWDLImpl(value, null, null);
	}
	
	public Long getExtendedMaxSuppportedBandwidthUL()
	{
		if(extendedMaxSupportedBWUL == null)
			return null;
		
		return extendedMaxSupportedBWUL.getUnsigned();
	}
	
	public void setExtendedMaxSuppportedBandwidthUL(Long value)
	{
		if(value == null)
			this.extendedMaxSupportedBWUL = null;
		else
			this.extendedMaxSupportedBWUL = new ExtendedMaxSupportedBWULImpl(value, null, null);
	}	
	
	public Long getExtendedMaxSuppportedBandwidthDL()
	{
		if(extendedMaxSupportedBWDL == null)
			return null;
		
		return extendedMaxSupportedBWDL.getUnsigned();
	}
	
	public void setExtendedMaxSuppportedBandwidthDL(Long value)
	{
		if(value == null)
			this.extendedMaxSupportedBWDL = null;
		else
			this.extendedMaxSupportedBWDL = new ExtendedMaxSupportedBWDLImpl(value, null, null);
	}
	
	public Long getExtendedMinDesiredBandwidthUL()
	{
		if(extendedMinDesiredBWUL == null)
			return null;
		
		return extendedMinDesiredBWUL.getUnsigned();
	}
	
	public void setExtendedMinDesiredBandwidthUL(Long value)
	{
		if(value == null)
			this.extendedMinDesiredBWUL = null;
		else
			this.extendedMinDesiredBWUL = new ExtendedMinDesiredBWULImpl(value, null, null);
	}	
	
	public Long getExtendedMinDesiredBandwidthDL()
	{
		if(extendedMinDesiredBWDL == null)
			return null;
		
		return extendedMinDesiredBWDL.getUnsigned();
	}
	
	public void setExtendedMinDesiredBandwidthDL(Long value)
	{
		if(value == null)
			this.extendedMinDesiredBWDL = null;
		else
			this.extendedMinDesiredBWDL = new ExtendedMinDesiredBWDLImpl(value, null, null);
	}
	
	public Long getExtendedMinRequestedBandwidthUL()
	{
		if(extendedMinRequestedBWUL == null)
			return null;
		
		return extendedMinRequestedBWUL.getUnsigned();
	}
	
	public void setExtendedMinRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.extendedMinRequestedBWUL = null;
		else
			this.extendedMinRequestedBWUL = new ExtendedMinRequestedBWULImpl(value, null, null);
	}	
	
	public Long getExtendedMinRequestedBandwidthDL()
	{
		if(extendedMinRequestedBWDL == null)
			return null;
		
		return extendedMinRequestedBWDL.getUnsigned();
	}
	
	public void setExtendedMinRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.extendedMinRequestedBWDL = null;
		else
			this.extendedMinRequestedBWDL = new ExtendedMinRequestedBWDLImpl(value, null, null);
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
	
	public PrioritySharingIndicatorEnum getPrioritySharingIndicator()
	{
		if(prioritySharingIndicator == null)
			return null;
		
		return prioritySharingIndicator.getEnumerated(PrioritySharingIndicatorEnum.class);
	}
	
	public void setPrioritySharingIndicator(PrioritySharingIndicatorEnum value)
	{
		if(value == null)
			this.prioritySharingIndicator = null;
		else
			this.prioritySharingIndicator = new PrioritySharingIndicatorImpl(value, null, null);
	}	
	
	public PreEmptionCapabilityEnum getPreEmptionCapability()
	{
		if(preEmptionCapability == null)
			return null;
		
		return preEmptionCapability.getEnumerated(PreEmptionCapabilityEnum.class);
	}
	
	public void setPreEmptionCapability(PreEmptionCapabilityEnum value)
	{
		if(value == null)
			this.preEmptionCapability = null;
		else
			this.preEmptionCapability = new PreEmptionCapabilityImpl(value, null, null);
	}	
	
	public PreEmptionVulnerabilityEnum getPreEmptionVulnerability()
	{
		if(preEmptionVulnerability == null)
			return null;
		
		return preEmptionVulnerability.getEnumerated(PreEmptionVulnerabilityEnum.class);
	}
	
	public void setPreEmptionVulnerability(PreEmptionVulnerabilityEnum value)
	{
		if(value == null)
			this.preEmptionVulnerability = null;
		else
			this.preEmptionVulnerability = new PreEmptionVulnerabilityImpl(value, null, null);
	}	
	
	public ReservationPriorityEnum getReservationPriority()
	{
		if(reservationPriority == null)
			return null;
		
		return reservationPriority.getEnumerated(ReservationPriorityEnum.class);
	}
	
	public void setReservationPriority(ReservationPriorityEnum value)
	{
		if(value == null)
			this.reservationPriority = null;
		else
			this.reservationPriority = new ReservationPriorityImpl(value, null, null);
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
	
	public List<ByteBuf> getCodecData()
	{
		if(codecData == null || codecData.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(CodecData curr:codecData)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setCodecData(List<ByteBuf> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Codec-Data may hold 0 to 2 items");
		
		if(value == null || value.size()==0)
			this.codecData = null;
		else
		{
			this.codecData = new ArrayList<CodecData>();
			for(ByteBuf curr:value)
				this.codecData.add(new CodecDataImpl(curr, null, null));
		}
	}
	
	public Long getSharingKeyDL()
	{
		if(sharingKeyDL == null)
			return null;
		
		return sharingKeyDL.getUnsigned();
	}
	
	public void setSharingKeyDL(Long value)
	{
		if(value == null)
			this.sharingKeyDL = null;
		else
			this.sharingKeyDL = new SharingKeyDLImpl(value, null, null);
	}
	
	public Long getSharingKeyUL()
	{
		if(sharingKeyUL == null)
			return null;
		
		return sharingKeyUL.getUnsigned();
	}
	
	public void setSharingKeyUL(Long value)
	{
		if(value == null)
			this.sharingKeyUL = null;
		else
			this.sharingKeyUL = new SharingKeyULImpl(value, null, null);
	}
	
	public Long getContentVersion()
	{
		if(contentVersion == null)
			return null;
		
		return contentVersion.getLong();
	}
	
	public void setContentVersion(Long value)
	{
		if(value == null)
			this.contentVersion = null;
		else
			this.contentVersion = new ContentVersionImpl(value, null, null);
	}
	
	public Long getMaxPLRDL()
	{
		if(maxPLRDL == null)
			return null;
		
		return maxPLRDL.getUnsigned();
	}
	
	public void setMaxPLRDL(Long value)
	{
		if(value == null)
			this.maxPLRDL = null;
		else
			this.maxPLRDL = new MaxPLRDLImpl(value, null, null);
	}
	
	public Long getMaxPLRUL()
	{
		if(maxPLRUL == null)
			return null;
		
		return maxPLRUL.getUnsigned();
	}
	
	public void setMaxPLRUL(Long value)
	{
		if(value == null)
			this.maxPLRUL = null;
		else
			this.maxPLRUL = new MaxPLRULImpl(value, null, null);
	}
	
	public Float getDesiredMaxLatency()
	{
		if(desiredMaxLatency == null)
			return null;
		
		return desiredMaxLatency.getFloat();
	}
	
	public void setDesiredMaxLatency(Float value)
	{
		if(value == null)
			this.desiredMaxLatency = null;
		else
			this.desiredMaxLatency = new DesiredMaxLatencyImpl(value, null, null);
	}
	
	public Float getDesiredMaxLoss()
	{
		if(desiredMaxLoss == null)
			return null;
		
		return desiredMaxLoss.getFloat();
	}
	
	public void setDesiredMaxLoss(Float value)
	{
		if(value == null)
			this.desiredMaxLoss = null;
		else
			this.desiredMaxLoss = new DesiredMaxLossImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(codecData!=null && codecData.size()>2)
			throw new IllegalArgumentException("Codec-Data may hold 0 to 2 items");
		
		if(mediaComponentNumber==null)
			return "Media-Component-Number is required";
		
		return null;
	}
}