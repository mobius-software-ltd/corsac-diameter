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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.112A	NNI-Information AVP
	The NNI-Information AVP (AVP code 2703) is of type Grouped and holds information about the NNI used for interconnection and roaming. 

	It has the following ABNF grammar:

	NNI-Information :: = 	  < AVP Header: 2703>
			[ Session-Direction ]
			[ NNI-Type ]
			[ Relationship-Mode ]
			[ Neighbour-Node-Address ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NNI_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "NNI-Information")
public interface NNIInformation extends DiameterAvp
{
	SessionDirectionEnum getSessionDirection();
	
	void setSessionDirection(SessionDirectionEnum value);
	
	NNITypeEnum getNNIType();
	
	void setNNIType(NNITypeEnum value);
	
	RelationshipModeEnum getRelationshipMode();
	
	void setRelationshipMode(RelationshipModeEnum value);
	
	InetAddress getNeighbourNodeAddress();
	
	void setNeighbourNodeAddress(InetAddress value);
}