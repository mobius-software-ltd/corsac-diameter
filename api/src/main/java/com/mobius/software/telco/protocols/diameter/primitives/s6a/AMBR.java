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
 * 	7.3.41	AMBR
	The AMBR AVP is of type Grouped.
	It shall contain the maximum requested bandwidth for Uplink and Downlink traffic. The Max-Requested-Bandwidth-(UL/DL) AVPs shall encode the bandwidth value in bits per second, having an upper limit of 4294967295 bits per second. The Extended-Max-Requested-BW-(UL/DL) AVPs shall encode the bandwidth value in kilobits (1000 bits) per second, having an upper limit of 4294967295 kilobits per second.
	When the maximum bandwidth value to be set for UL (or DL, respectively) traffic is lower than 4294967296 bits per second, the Max-Requested-Bandwidth-UL (or -DL, respectively) AVP shall be present, and set to the requested bandwidth value in bits per second, and the Extended-Max-Requested-BW-UL (or -DL, respectively) AVP shall be absent.
	When the maximum bandwidth value to be set for UL (or DL, respectively) traffic is higher than 4294967295 bits per second, the Max-Requested-Bandwidth-UL (or DL, respectively) AVP shall be present, and set to its upper limit 4294967295, and the Extended-Max-Requested-BW-UL (or -DL, respectively) shall be present, and set to the requested bandwidth value in kilobits (1000 bits) per second.
	
	NOTE:	The value applicable for Max-Requested-Bandwidth-UL (or DL, respectively) is between 1 and 4294967295 bits per second, and the value applicable for Extended-Max-Requested-BW-UL (or -DL, respectively) is between 4294968 and 4294967295 kilobits per second. The AMBR AVP cannot indicate the requested bandwidth between 4294967296 and 4294967999 bits per second, and any larger value that cannot be represented in the granularity of kilobits per second.

	AVP format
 
 	AMBR ::= <AVP header: 1435 10415>
			 { Max-Requested-Bandwidth-UL }
			 { Max-Requested-Bandwidth-DL }
			 [ Extended-Max-Requested-BW-UL ]
			 [ Extended-Max-Requested-BW-DL ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AMBR, vendorId = VendorIDs.TGPP_ID, name = "AMBR")
public interface AMBR extends DiameterGroupedAvp
{
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value) throws MissingAvpException;	
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value) throws MissingAvpException;	
	
	Long getExtendedMaxRequestedBWUL();
	
	void setExtendedMaxRequestedBWUL(Long value);	
	
	Long getExtendedMaxRequestedBWDL();
	
	void setExtendedMaxRequestedBWDL(Long value);	
}