package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.66	Suggested-Network-Configuration
	The Suggested-Network-Configuration AVP is of type Grouped, and it shall contain the details for configuration for Suggested Network configuration.
	AVP format:

	Suggested-Network-Configuration::=	<AVP header: 3170 10415>
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 { SCEF-ID }
			 [ Subscribed-Periodic-RAU-TAU-Timer ]
			 [ Active-Time ]
			 [ DL-Buffering-Suggested-Packet-Count ]
			 [ MTC-Provider-Info ]
			*[ SCEF-Reference-ID-for-Deletion ]
			*[ SCEF-Reference-ID-for-Deletion-Ext ]
			*[AVP]

	If the values of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion are the same, no Network Parameter Configurations AVP(s) shall be present, that is, SCEF-Reference-ID-for-Deletion takes precedence. If the values of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion are not the same, Network Parameter Configurations AVP(s) are related to SCEF-Reference-ID.
	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext and SCEF-Reference-ID-for-Deletion-Ext AVPs shall be used insted of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion respectively; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
 */
@DiameterAvpDefinition(code = 3170L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Suggested-Network-Configuration")
public interface SuggestedNetworkConfiguration extends DiameterGroupedAvp
{
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);	
	
	Long getSubscribedPeriodicRAUTAUTimer();
	
	void setSubscribedPeriodicRAUTAUTimer(Long value);
	
	Long getActiveTime();
	
	void setActiveTime(Long value);
	
	Integer getDLBufferingSuggestedPacketCount();
	
	void setDLBufferingSuggestedPacketCount(Integer value);
	
	MTCProviderInfo getMTCProviderInfo();
	
	void setMTCProviderInfo(MTCProviderInfo value);
	
	List<Long> getSCEFReferenceIDForDeletion();
	
	void setSCEFReferenceIDForDeletion(List<Long> value);
	
	List<Long> getSCEFReferenceIDForDeletionExt();
	
	void setSCEFReferenceIDForDeletionExt(List<Long> value);
}