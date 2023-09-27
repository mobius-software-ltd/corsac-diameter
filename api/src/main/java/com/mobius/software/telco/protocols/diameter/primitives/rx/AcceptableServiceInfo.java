package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 *	5.3.24	Acceptable-Service-Info AVP
	The Acceptable-Service-Info AVP (AVP code 526) is of type Grouped, and contains the maximum bandwidth for an AF session and/or for specific media components that will be authorized by the PCRF. The Max-Requested-Bandwidth-DL AVP, the Max-Requested-Bandwidth-UL AVP, the Extended-Max-Requested-BW-DL AVP and the Extended-Max-Requested-BW-UL AVP (see clause 4.4.10)directly within the Acceptable-Service-Info AVP indicate the acceptable bandwidth for the entire AF session. The Max-Requested-Bandwidth-DL AVP, Max-Requested-Bandwidth-UL AVP, Extended-Max-Requested-BW-DL AVP and Extended-Max-Requested-BW-UL AVP within a Media-Component-Description AVP included in the Acceptable-Service-Info AVP indicate the acceptable bandwidth for the corresponding media component.
	If the acceptable bandwidth applies to one or more media components, only the Media-Component-Description AVP will be provided. If the acceptable bandwidth applies to the whole AF session, only the Max-Requested-Bandwidth-DL AVP the Max-Requested-Bandwidth-UL AVP, the Extended-Max-Requested-BW-DL AVP and the Extended-Max-Requested-BW-DL AVP will be included.
	
		Acceptable-Service-Info::= < AVP Header: 526 >
			*[ Media-Component-Description]
			 [ Max-Requested-Bandwidth-DL ]
			 [ Max-Requested-Bandwidth-UL ]
			 [ Extended-Max-Requested-BW-DL ]
			 [ Extended-Max-Requested-BW-UL ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 526L, vendorId = KnownVendorIDs.TGPP_ID, name = "Acceptable-Service-Info")
public interface AcceptableServiceInfo extends DiameterGroupedAvp
{
	List<MediaComponentDescription> getMediaComponentDescription();
	
	void setMediaComponentDescription(List<MediaComponentDescription> value);
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);	
	
	Long getExtendedMaxRequestedBandwidthDL();
	
	void setExtendedMaxRequestedBandwidthDL(Long value);	
	
	Long getExtendedMaxRequestedBandwidthUL();
	
	void setExtendedMaxRequestedBandwidthUL(Long value);
}