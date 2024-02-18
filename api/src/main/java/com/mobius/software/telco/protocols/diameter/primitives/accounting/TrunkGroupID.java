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
 * 	7.2.237	Trunk-Group-ID AVP
	The Trunk-Group-ID AVP (AVP code 851) is of type Grouped and identifies the incoming and outgoing PSTN legs.
	It has the following ABNF grammar:
	
	Trunk-Group-ID :: =	 <AVP Header: 851>
			[ Incoming-Trunk-Group-ID ]
			[ Outgoing-Trunk-Group-ID ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TRUNK_GROUP_ID, vendorId = VendorIDs.TGPP_ID, name = "Trunk-Group-ID")
public interface TrunkGroupID extends DiameterAvp
{
	String getIncomingTrunkGroupID();
	
	void setIncomingTrunkGroupID(String value);
	
	String getOutgoingTrunkGroupID();
	
	void setOutgoingTrunkGroupID(String value);
}