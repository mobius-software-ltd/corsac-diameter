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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.1 Access-Network-Information AVP
	The Access-Network-Information AVP (AVP code 1263) is of type OctetString and indicates one instance of the SIP Pheader "P-Access-Network-Info". In SIP, as per RFC 7315 [404], the content of the "P-Access-Network-Info" header is
	known as the access-net-spec. When multiple access-net-spec values are transported in a single "P-Access-Network-
	ETSI
	
	Info" header in comma-separated format, then multiple Access-Network-Information AVPs are used with one accessnet-spec value included in each AVP.
	For access types and access classes associated to 3GPP accesses:
		- For GERAN access, the cgi-3gpp field contains the CGI;
		- For UTRAN access, the utran-cell-id-3gpp field contains the LAI and CI, and the utran-sai-3gpp field contains the SAI;
		- For E-UTRAN access, the utran-cell-id-3gpp field contains the TAI and ECGI;
		- For NR access, the utran-cell-id-3gpp field contains the TAI and NCI.
	
	The SIP "P-Access-Network-Info" header specified in TS 24.229 [202] clause 7.2A.4 contains in particular:
	For access types and access classes associated to trusted WLAN access: the i-wlan-node-id field contains the BSSID,
	and when available, the operator-specific-GI field contains the Geographical Identifier.
	For access types and access classes associated to untrusted WLAN access, the i-wlan-node-id field contains the BSSID,
	and UE local IP address, ePDG IP Address, and TCP source port, UDP source port are contained in corresponding
	dedicated fields. 
 */
@DiameterAvpDefinition(code = 1263L, vendorId = KnownVendorIDs.TGPP_ID, name = "Access-Network-Information")
public interface AccessNetworkInformation extends DiameterOctetString
{
}