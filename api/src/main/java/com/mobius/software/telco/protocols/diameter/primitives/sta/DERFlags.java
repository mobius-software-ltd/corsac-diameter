package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.3.20	DER-Flags
	The DER-Flags AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.2.3.20/1:
	Table 5.2.3.20/1: DER-Flags

	Bit Name
	Description

	0 NSWO-Capability-Indication
	This bit, when set, indicates to the 3GPP AAA proxy/server that the TWAN supports non-seamless WLAN offload service (see clause 16 of 3GPP TS 23.402 [3]).

	1 TWAN-S2a-Connectivity-Indicator
	This bit is only applicable to the TWAN authentication and authorization procedure, when authorizing the SCM for EPC access.
	When set, it indicates to the 3GPP AAA Server that the TWAN has completed the necessary S2a network connectivity actions, and the 3GPP AAA Sever can finalize the EAP conversation by sending a final EAP 'Success' or 'Failure' response to the TWAN.

	2 IMEI-Check-Required-In-VPLMN
	This bit is only applicable to the TWAN authentication and authorization procedure, when the UE and the network support Mobile Equipment Identity signalling over trusted WLAN.
	When set, it indicates to the 3GPP AAA Server that the 3GPP AAA Server shall retrieve the IMEI(SV) from the UE and return it to the VPLMN with the IMEI-Check-Request-In-VPLMN bit set in the DEA-Flags.

	3 IMEI-Check-Request-In-VPLMN
	This bit is only applicable to the TWAN authentication and authorization procedure, when the UE and the network support Mobile Equipment Identity signalling over trusted WLAN.
	When set, it indicates that the 3GPP AAA Proxy shall perform the IMEI(SV) check in the VPLMN and send the IMEI check result to the 3GPP AAA Server.
	
	4 Emergency-Capability-Indication
	This bit, when set, indicates to the 3GPP AAA Server that the TWAN supports IMS emergency sessions (see clause 4.5.7 of 3GPP TS 23.402 [3]).

	5 ERP-Support-Indication
	This bit, when set, indicates to the 3GPP AAA proxy/server that the non-3GPP access network supports EAP extensions for the EAP Re-authentication Protocol (ERP).

	6 ERP-Re-Authentication
	This bit, when set, indicates to the 3GPP AAA proxy/server that the authentication request is sent for EAP re-authentication based on ERP.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 1520L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "DER-Flags")
public interface DERFlags extends DiameterUnsigned32
{
}