package com.mobius.software.telco.protocols.diameter.primitives.rfc4004;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.5.  MIP-Feature-Vector AVP

   	The MIP-Feature-Vector AVP (AVP Code 337) is of type Unsigned32 and
   	is added with flag values set by the foreign agent or by the AAAF
   	owned by the same administrative domain as the foreign agent.  The
   	foreign agent SHOULD include MIP-Feature-Vector AVP within the AMR
   	message it sends to the AAAF.

      Flag values currently defined include the following:

            1   Mobile-Node-Home-Address-Requested
            2   Home-Address-Allocatable-Only-in-Home-Realm
            4   Home-Agent-Requested
            8   Foreign-Home-Agent-Available
            16  MN-HA-Key-Request
            32  MN-FA-Key-Request
            64  FA-HA-Key-Request
            128 Home-Agent-In-Foreign-Network
            256 Co-Located-Mobile-Node

   	The flags are set according to the following rules.

   	If the mobile node includes a valid home address (i.e., one not equal
   	to 0.0.0.0 or 255.255.255.255) in its Registration Request, the
   	foreign agent sets the Mobile-Node-Home-Address-Requested flag in the
   	MIP-Feature-Vector AVP to zero.

   	If the mobile node sets the home agent field equal to 255.255.255.255
   	in its Registration Request, the foreign agent sets both the Home-
   	Agent-Requested flag and the Home-Address-Allocatable-Only-in-Home-
   	Realm flag to one in the MIP-Feature-Vector AVP.
   	
   	If the mobile node sets the home agent field equal to 0.0.0.0 in its
   	Registration Request, the foreign agent sets the Home-Agent-Requested
   	flag to one and zeroes the Home-Address-Allocatable-Only-in-Home-
   	Realm flag in the MIP-Feature-Vector AVP.

   	Whenever the foreign agent sets either the
   	Mobile-Node-Home-Address-Requested flag or the Home-Agent-Requested
   	flag to one, it MUST set the MN-HA-Key-Request flag to one.  The MN-
   	HA-Key-Request flag is also set to one if the mobile node includes a
   	"Generalized MN-HA Key Generation Nonce Request" [MIPKEYS] extension,
   	with the subtype set to AAA.

   	If the mobile node includes a "Generalized MN-FA Key Generation Nonce
   	Request" [MIPKEYS] extension with the AAA subtype (1) in its
   	Registration Request, the foreign agent sets the MN-FA-Key-Request
   	flag to one in the MIP-Feature-Vector AVP.

   	If the mobile node requests a home agent in the foreign network
   	either by setting the home address field to all ones, or by
   	specifying a home agent in the foreign network, and the AAAF
   	authorizes the request, the AAAF MUST set the Home-Agent-In-Foreign-
   	Network bit to one.

   	If the AAAF is willing and able to assign a home agent in the foreign
   	network, the AAAF sets the Foreign-Home-Agent-Available flag to one.

   	If the Home Agent receives a Registration Request from the mobile
   	node indicating that the MN is acting as a co-located mobile node,
   	the home agent sets the Co-Located-Mobile-Node bit to one.

   	If the foreign agent's local policy allows it to receive AAA session
   	keys and it does not have any existing FA-HA key with the home agent,
   	the foreign agent MAY set the FA-HA-Key-Request flag.

   	The foreign agent MUST NOT set the Foreign-Home-Agent-Available and
   	Home-Agent-In-Foreign-Network flag both to one.

   	When the AAAF receives the AMR message, it MUST first verify that the
   	sender was an authorized foreign agent.  The AAAF then takes any
   	actions indicated by the settings of the MIP-Feature-Vector AVP
   	flags.  The AAAF then MAY set additional flags.  Only the AAAF may
   	set the Foreign-Home-Agent-Available and Home-Agent-In-Foreign-
   	Network flags to one.  This is done according to local administrative
   	policy.  When the AAAF has finished setting additional flags
   	according to its local policy, then the AAAF transmits the AMR with
   	the possibly modified MIP-Feature-Vector AVP to the AAAH.   	   
 */
@DiameterAvpDefinition(code = AvpCodes.MIP_FEATURE_VECTOR, vendorId = -1, name = "MIP-Feature-Vector")
public interface MIPFeatureVector extends DiameterUnsigned32
{
}