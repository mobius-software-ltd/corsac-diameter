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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.80	Updated-Network-Configuration
	The Updated-Network-Configuration AVP is of type Grouped. If not included inside Group-Report-Item AVP, it shall contain only the Network Parameter Configurations which were received in a previous CIR command and have been updated due to a new CIR command. If included inside Group-Report-Item AVP, it shall contain the current values applied in the network for each group member.
	AVP format:

	Updated-Network-Configuration::=	<AVP header: 3184 10415>
			 { SCEF-ID }
			 [ SCEF-Reference-ID ]
			 [ SCEF-Reference-ID-Ext ]
			*[ SCEF-Reference-ID-for-Deletion ]
			*[ SCEF-Reference-ID-for-Deletion-Ext ]
			 [ Subscribed-Periodic-RAU-TAU-Timer ]
			 [ Active-Time ]
			 [ DL-Buffering-Suggested-Packet-Count ]
			*[AVP]

	At least one reference ID (either in SCEF-Reference-ID or in SCEF-Reference-ID-Ext) or a reference ID for deletion (either in SCEF-Reference-ID-for-Deletion or in SCEF-Reference-ID-for-Deletion-Ext) shall be present.
	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext and SCEF-Reference-ID-for-Deletion-Ext AVPs shall be used insted of SCEF-Reference-ID and SCEF-Reference-ID-for-Deletion respectively.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UPDATED_NETWORK_CONFIGURATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Updated-Network-Configuration")
public interface UpdatedNetworkConfiguration extends DiameterGroupedAvp
{
	String getSCEFID();
	
	void setSCEFID(String value) throws MissingAvpException;	
	
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	List<Long> getSCEFReferenceIDForDeletion();
	
	void setSCEFReferenceIDForDeletion(List<Long> value);
	
	List<Long> getSCEFReferenceIDForDeletionExt();
	
	void setSCEFReferenceIDForDeletionExt(List<Long> value);
	
	Long getSubscribedPeriodicRAUTAUTimer();
	
	void setSubscribedPeriodicRAUTAUTimer(Long value);
	
	Long getActiveTime();
	
	void setActiveTime(Long value);
	
	Integer getDLBufferingSuggestedPacketCount();
	
	void setDLBufferingSuggestedPacketCount(Integer value);
}