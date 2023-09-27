package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

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
@DiameterAvpDefinition(code = 3410L, vendorId = KnownVendorIDs.TGPP_ID, name = "VCS-Information")
public interface VCSInformation extends DiameterAvp
{
	ByteBuf getBearerCapability();
	
	void setBearerCapability(ByteBuf value);
	
	ByteBuf getNetworkCallReferenceNumber();
	
	void setNetworkCallReferenceNumber(ByteBuf value);
	
	String getMSCAddress();
	
	void setMSCAddress(String value);
	
	BasicServiceCode getBasicServiceCode();
	
	void setBasicServiceCode(BasicServiceCode value);
	
	String getISUPLocationNumber();
	
	void setISUPLocationNumber(String value);
	
	String getVLRNumber();
	
	void setVLRNumber(String value);
	
	ForwardingPendingEnum getForwardingPending();
	
	void setForwardingPending(ForwardingPendingEnum value);
	
	ISUPCause getISUPCause();
	
	void setISUPCause(ISUPCause value);
	
	Date getStartTime();
	
	void setStartTime(Date value);
	
	Date getStartOfCharging();
	
	void setStartOfCharging(Date value);
	
	Date getStopTime();
	
	void setStopTime(Date value);
	
	ByteBuf getPSFreeFormatData();
	
	void setPSFreeFormatData(ByteBuf value);
}