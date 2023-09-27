package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BasicServiceCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BearerCapability;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ForwardingPending;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ForwardingPendingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCause;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPLocationNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NetworkCallReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSFreeFormatData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StartOfCharging;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StartTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StopTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VLRNumber;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.242A	VCS-Information AVP
	The VCS-Information AVP (AVP code 3410) is of type Grouped. Its purpose is to allow the transmission of additional VCS service specific information elements. 
	It has the following ABNF grammar:

	VCS-Information :: = 	  < AVP Header: 3410>
			[ Bearer-Capability ]
			[ Network-Call-Reference-Number ]
			[ MSC-Address ]
			[ Basic-Service-Code ]
			[ ISUP-Location-Number ]
			[ VLR-Number ]
			[ Forwarding-Pending ]
			[ ISUP-Cause ]
			[ Start-Time ]
			[ Start-of-Charging ]
			[ Stop-Time ]
			[ PS-Free-Format-Data ]
 */
@DiameterAvpImplementation(code = 3410L, vendorId = KnownVendorIDs.TGPP_ID)
public class VCSInformationImpl implements VCSInformation
{
	private BearerCapability bearerCapability;
	private NetworkCallReferenceNumber networkCallReferenceNumber;
	private MSCAddress mscAddress;
	private BasicServiceCode basicServiceCode;
	private ISUPLocationNumber isupLocationNumber;
	private VLRNumber vlrNumber;
	private ForwardingPending forwardingPending;
	private ISUPCause isupCause;
	private StartTime startTime;
	private StartOfCharging startOfCharging;
	private StopTime stopTime;
	private PSFreeFormatData psFreeFormatData;
		
	public VCSInformationImpl()
	{
		
	}
	
	public ByteBuf getBearerCapability()
	{
		if(bearerCapability==null)
			return null;
		
		return bearerCapability.getValue();
	}
	
	public void setBearerCapability(ByteBuf value)
	{
		if(value==null)
			this.bearerCapability = null;
		else
			this.bearerCapability = new BearerCapabilityImpl(value, null, null);			
	}
	
	public ByteBuf getNetworkCallReferenceNumber()
	{
		if(networkCallReferenceNumber==null)
			return null;
		
		return networkCallReferenceNumber.getValue();
	}
	
	public void setNetworkCallReferenceNumber(ByteBuf value)
	{
		if(value==null)
			this.networkCallReferenceNumber = null;
		else
			this.networkCallReferenceNumber = new NetworkCallReferenceNumberImpl(value, null, null);			
	}
	
	public String getMSCAddress()
	{
		if(mscAddress==null)
			return null;
		
		return mscAddress.getAddress();
	}
	
	public void setMSCAddress(String value)
	{
		if(value==null)
			this.mscAddress = null;
		else
			this.mscAddress = new MSCAddressImpl(value);			
	}
	
	public BasicServiceCode getBasicServiceCode()
	{
		return this.basicServiceCode;
	}
	
	public void setBasicServiceCode(BasicServiceCode value)
	{
		this.basicServiceCode = value;
	}
	
	public String getISUPLocationNumber()
	{
		if(isupLocationNumber==null)
			return null;
		
		return isupLocationNumber.getAddress();
	}
	
	public void setISUPLocationNumber(String value)
	{
		if(value==null)
			this.isupLocationNumber = null;
		else
			this.isupLocationNumber = new ISUPLocationNumberImpl(value);			
	}
	
	public String getVLRNumber()
	{
		if(vlrNumber==null)
			return null;
		
		return vlrNumber.getAddress();
	}
	
	public void setVLRNumber(String value)
	{
		if(value==null)
			this.vlrNumber = null;
		else
			this.vlrNumber = new VLRNumberImpl(value);			
	}
	
	public ForwardingPendingEnum getForwardingPending()
	{
		if(forwardingPending==null)
			return null;
		
		return forwardingPending.getEnumerated(ForwardingPendingEnum.class);
	}
	
	public void setForwardingPending(ForwardingPendingEnum value)
	{
		if(value==null)
			this.forwardingPending = null;
		else
			this.forwardingPending = new ForwardingPendingImpl(value, null, null);			
	}
	
	public ISUPCause getISUPCause()
	{
		return this.isupCause;
	}
	
	public void setISUPCause(ISUPCause value)
	{
		this.isupCause = value;
	}
	
	public Date getStartTime()
	{
		if(startTime==null)
			return null;
		
		return startTime.getDateTime();
	}
	
	public void setStartTime(Date value)
	{
		if(value==null)
			this.startTime = null;
		else
			this.startTime = new StartTimeImpl(value, null, null);			
	}
	
	public Date getStartOfCharging()
	{
		if(startOfCharging==null)
			return null;
		
		return startOfCharging.getDateTime();
	}
	
	public void setStartOfCharging(Date value)
	{
		if(value==null)
			this.startOfCharging = null;
		else
			this.startOfCharging = new StartOfChargingImpl(value, null, null);			
	}
	
	public Date getStopTime()
	{
		if(stopTime==null)
			return null;
		
		return stopTime.getDateTime();
	}
	
	public void setStopTime(Date value)
	{
		if(value==null)
			this.stopTime = null;
		else
			this.stopTime = new StopTimeImpl(value, null, null);			
	}
	
	public ByteBuf getPSFreeFormatData()
	{
		if(psFreeFormatData==null)
			return null;
		
		return psFreeFormatData.getValue();
	}
	
	public void setPSFreeFormatData(ByteBuf value)
	{
		if(value==null)
			this.psFreeFormatData = null;
		else
			this.psFreeFormatData = new PSFreeFormatDataImpl(value, null, null);			
	}
}