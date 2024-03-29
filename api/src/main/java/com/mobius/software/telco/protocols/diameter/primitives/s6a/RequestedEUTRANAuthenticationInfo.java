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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.11	Requested-EUTRAN-Authentication-Info
	The Requested-EUTRAN-Authentication-Info is of type Grouped. It shall contain the information related to the authentication requests for E-UTRAN.
	AVP format

	Requested-EUTRAN-Authentication-Info ::= <AVP header: 1408 10415>
			 [ Number-Of-Requested-Vectors ]
			 [ Immediate-Response-Preferred ]
			 [ Re-synchronization-Info ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REQUESTED_EUTRAN_AUTHENTICATION_INFO, vendorId = VendorIDs.TGPP_ID, name = "Requested-EUTRAN-Authentication-Info")
public interface RequestedEUTRANAuthenticationInfo extends DiameterGroupedAvp
{
	Long getNumberOfRequestedVectors();
	
	void setNumberOfRequestedVectors(Long value);	
	
	Long getImmediateResponsePreferred();
	
	void setImmediateResponsePreferred(Long value);
	
	ByteBuf getReSynchronizationInfo();
	
	void setReSynchronizationInfo(ByteBuf value);
}