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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedGBRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedGBRUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.GuaranteedBitrateDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.GuaranteedBitrateUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1016L, vendorId = KnownVendorIDs.TGPP_ID)
public class QoSInformationImpl extends DiameterGroupedAvpImpl implements QoSInformation
{
	private QoSClassIdentifier qosClassIdentifier;
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL; 
	private ExtendedMaxRequestedBWUL extendedMaxRequestedBWUL;
	private ExtendedMaxRequestedBWDL extendedMaxRequestedBWDL;
	private GuaranteedBitrateUL guaranteedBitrateUL;
	private GuaranteedBitrateDL guaranteedBitrateDL;
	private ExtendedGBRUL extendedGBRUL;
	private ExtendedGBRDL extendedGBRDL;
	private BearerIdentifier bearerIdentifier;
	private AllocationRetentionPriority allocationRetentionPriority;
	private APNAggregateMaxBitrateUL apnAggregateMaxBitrateUL;
	private APNAggregateMaxBitrateDL apnAggregateMaxBitrateDL;
	private ExtendedAPNAMBRUL extendedAPNAMBRUL;
	private ExtendedAPNAMBRDL extendedAPNAMBRDL;
	private List<ConditionalAPNAggregateMaxBitrate> conditionalAPNAggregateMaxBitrate;
		
	public QoSInformationImpl()
	{
		
	}
	
	public QoSClassIdentifierEnum getQoSClassIdentifier()
	{
		if(qosClassIdentifier==null)
			return null;
		
		return qosClassIdentifier.getEnumerated(QoSClassIdentifierEnum.class);
	}
	
	public void setQoSClassIdentifier(QoSClassIdentifierEnum value)
	{
		if(value==null)
			this.qosClassIdentifier = null;
		else
			this.qosClassIdentifier = new QoSClassIdentifierImpl(value, null, null);			
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL==null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);			
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL==null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);			
	}
	
	public Long getExtendedMaxRequestedBWUL()
	{
		if(extendedMaxRequestedBWUL==null)
			return null;
		
		return extendedMaxRequestedBWUL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBWUL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRUL = null;
		else
			this.extendedAPNAMBRUL = new ExtendedAPNAMBRULImpl(value, null, null);			
	}
	
	public Long getExtendedMaxRequestedBWDL()
	{
		if(extendedMaxRequestedBWDL==null)
			return null;
		
		return extendedMaxRequestedBWDL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBWDL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRDL = null;
		else
			this.extendedAPNAMBRDL = new ExtendedAPNAMBRDLImpl(value, null, null);			
	}
	
	public Long getGuaranteedBitrateUL()
	{
		if(guaranteedBitrateUL==null)
			return null;
		
		return guaranteedBitrateUL.getUnsigned();
	}
	
	public void setGuaranteedBitrateUL(Long value)
	{
		if(value==null)
			this.guaranteedBitrateUL = null;
		else
			this.guaranteedBitrateUL = new GuaranteedBitrateULImpl(value, null, null);			
	}
	
	public Long getGuaranteedBitrateDL()
	{
		if(guaranteedBitrateDL==null)
			return null;
		
		return guaranteedBitrateDL.getUnsigned();
	}
	
	public void setGuaranteedBitrateDL(Long value)
	{
		if(value==null)
			this.guaranteedBitrateDL = null;
		else
			this.guaranteedBitrateDL = new GuaranteedBitrateDLImpl(value, null, null);			
	}
	
	public Long getExtendedGBRUL()
	{
		if(extendedGBRUL==null)
			return null;
		
		return extendedGBRUL.getUnsigned();
	}
	
	public void setExtendedGBRUL(Long value)
	{
		if(value==null)
			this.extendedGBRUL = null;
		else
			this.extendedGBRUL = new ExtendedGBRULImpl(value, null, null);			
	}
	
	public Long getExtendedGBRDL()
	{
		if(extendedGBRDL==null)
			return null;
		
		return extendedGBRDL.getUnsigned();
	}
	
	public void setExtendedGBRDL(Long value)
	{
		if(value==null)
			this.extendedGBRDL = null;
		else
			this.extendedGBRDL = new ExtendedGBRDLImpl(value, null, null);			
	}
	
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier==null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	public void setBearerIdentifier(ByteBuf value)
	{
		if(value==null)
			this.bearerIdentifier = null;
		else
			this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);			
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority()
	{
		return allocationRetentionPriority;
	}
	
	public void setAllocationRetentionPriority(AllocationRetentionPriority value)
	{
		this.allocationRetentionPriority = value;
	}
	
	public Long getAPNAggregateMaxBitrateUL()
	{
		if(apnAggregateMaxBitrateUL==null)
			return null;
		
		return apnAggregateMaxBitrateUL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateUL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateUL = null;
		else
			this.apnAggregateMaxBitrateUL = new APNAggregateMaxBitrateULImpl(value, null, null);			
	}
	
	public Long getAPNAggregateMaxBitrateDL()
	{
		if(apnAggregateMaxBitrateDL==null)
			return null;
		
		return apnAggregateMaxBitrateDL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateDL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateDL = null;
		else
			this.apnAggregateMaxBitrateDL = new APNAggregateMaxBitrateDLImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRUL()
	{
		if(extendedAPNAMBRUL==null)
			return null;
		
		return extendedAPNAMBRUL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRUL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRUL = null;
		else
			this.extendedAPNAMBRUL = new ExtendedAPNAMBRULImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRDL()
	{
		if(extendedAPNAMBRDL==null)
			return null;
		
		return extendedAPNAMBRDL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRDL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRDL = null;
		else
			this.extendedAPNAMBRDL = new ExtendedAPNAMBRDLImpl(value, null, null);			
	}
	
	public List<ConditionalAPNAggregateMaxBitrate> getConditionalAPNAggregateMaxBitrate()
	{
		return conditionalAPNAggregateMaxBitrate;
	}
	
	public void setConditionalAPNAggregateMaxBitrate(List<ConditionalAPNAggregateMaxBitrate> value)
	{
		this.conditionalAPNAggregateMaxBitrate = value;
	}
}