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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.77A IMS-Visited-Network-Identifier AVP
	The IMS-Visited-Network-Identifier AVP (AVP code 2713) is of type UTF8String and contains the contents of the SIP
	P-header "P-Visited-Network-ID". with the value according to 3GPP TS 24.229 [202]
	- For the roaming architecture for voice over IMS with local breakout, the value of IMS-Visited-NetworkIdentifier AVP is a pre-provisioned string that identifies the network of the P-CSCF at the home network.
	- For the roaming architecture for voice over IMS with home routed traffic, IMS-Visited-Network-Identifier AVP
	is a string that identifies the visited network of the UE including an indication that the P-CSCF is located in the
	home network. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_VISITED_NETWORK_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "IMS-Visited-Network-Identifier")
public interface IMSVisitedNetworkIdentifier extends DiameterUTF8String
{
}