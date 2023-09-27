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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.25 Associated-Party-Address AVP
	The Associated-Party-Address AVP (AVP code 2035) is of type UTF8String and is used for MMTel supplementary
	service. It holds the address (SIP URI or Tel URI) of the user, the MMTel supplementary service is provided to : the
	"forwarding party" for CDIV, the "transferor" for ECT, the "Pilot Identity" for Flexible Alerting (FA), the "Initiator
	party" for 3PTY. 
 */
@DiameterAvpDefinition(code = 2035L, vendorId = KnownVendorIDs.TGPP_ID, name = "Associated-Party-Address")
public interface AssociatedPartyAddress extends DiameterUTF8String
{
}