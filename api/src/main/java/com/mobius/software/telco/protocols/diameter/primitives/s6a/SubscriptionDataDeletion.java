package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.208	Subscription-Data-Deletion
	The Subscription-Data-Deletion AVP is of type Grouped and indicates the shared subscription data that need to be deleted from the subscription profiles of the impacted subscribers.
	AVP format

	Subscription-Data-Deletion ::= <AVP header: 1685 10415>
			 { DSR-Flags }
			 [ SCEF-ID ]
			*[ Context-Identifier ]
			 [ Trace-Reference ]
			*[ TS-Code ]
			*[ SS-Code ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1685L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Subscription-Data-Deletion")
public interface SubscriptionDataDeletion extends DiameterGroupedAvp
{
	Long getDSRFlags();
	
	void setDSRFlags(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	List<Long> getContextIdentifier();
	
	void setContextIdentifier(List<Long> value);
	
	ByteBuf getTraceReference();
	
	void setTraceReference(ByteBuf value);
	
	List<ByteBuf> getTSCode();
	
	void setTSCode(List<ByteBuf> value);
	
	List<ByteBuf> getSSCode();
	
	void setSSCode(List<ByteBuf> value);
}