package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
 * 	6.3.4	ProSe-Allowed-PLMN
	The ProSe-Allowed-PLMN AVP is of type Group. It shall contain the PLMN where the UE is authorised to announce or monitor or 
	both for ProSe Discovery or to use ProSe direct communication.
	AVP format
	ProSe-Allowed-PLMN ::= <AVP header: 3703 10415>
		 [ Visited-PLMN-Id ]
		 [ Authorized-Discovery-Range ]
		 [ ProSe-Direct-Allowed ]
		*[AVP]

	The Authorized-Discovery-Range Information Element should only be present if the Visited-PLMN-Id is the PLMN-Id of the HPLMN; otherwise it should be absent.
 */
@DiameterAvpDefinition(code = 3703L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-Allowed-PLMN")
public interface ProSeAllowedPLMN extends DiameterGroupedAvp
{
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	Long getAuthorizedDiscoveryRange();
	
	void setAuthorizedDiscoveryRange(Long value);	
	
	ProSeDirectAllowed getProSeDirectAllowed();
	
	void setProSeDirectAllowed(ProSeDirectAllowed value);
}