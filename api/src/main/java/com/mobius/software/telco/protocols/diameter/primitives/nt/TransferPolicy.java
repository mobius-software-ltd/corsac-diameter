package com.mobius.software.telco.protocols.diameter.primitives.nt;
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
 * 	5.3.8	Transfer-Policy AVP
	The Transfer-Policy AVP (AVP code 4207) is of type Grouped. It indicates the transfer policy determined by the PCRF.
	Transfer-Policy ::= < AVP Header: 4207 >
                   { Transfer-Policy-Id }
                   [ Time-Window ]
                   [ Rating-Group ]
                   [ Max-Requested-Bandwidth-DL ]
                   [ Max-Requested-Bandwidth-UL ]
                  *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TRANSFER_POLICY, vendorId = VendorIDs.TGPP_ID, name = "Transfer-Policy")
public interface TransferPolicy extends DiameterGroupedAvp
{
	Long getTransferPolicyId();
	
	void setTransferPolicyId(Long value) throws MissingAvpException;
	
	TimeWindow getTimeWindow();
	
	void setTimeWindow(TimeWindow value);
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);
	
	Long getMaxRequestedBandwidthDL();
	
	void setMaxRequestedBandwidthDL(Long value);
	
	Long getMaxRequestedBandwidthUL();
	
	void setMaxRequestedBandwidthUL(Long value);
}