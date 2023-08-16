package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
	5 - 3GPP-GPRS Negotiated QoS profile
	Length: For GGSN, L ≤ 37 (release 7 or higher) or L ≤ 33 (release 6 or release 5) or L ≤ 27 (release 4 or release 99) or
	L = 11 (release 98). For P-GW, the length varies depending on the value of QCI. See below for details.
	QoS profile value: Text type
	UTF-8 encoded QoS profile syntax:
	"<Release indicator> – <release specific QoS IE UTF-8 encoding>"
	<Release indicator> = UTF-8 encoded number (two characters) :
	 For GGSN:
	"98" = Release 98
	"99"= Release 99 or release 4
	"05"= Release 5 or release 6
	"07"= Release 7 or higher
	For P-GW:
	"08"= Release 8 or higher
	 <release specific QoS profile UTF-8 encoding> = UTF-8 encoded QoS profile for the release indicated by
	 the release indicator.
	 The UTF-8 encoding of a QoS IE is defined as follows: each octet is described by 2 UTF-8 encoded
	characters, defining its hexadecimal representation.
	 For GGSN:
	 The QoS profile definition is in 3GPP TS 24.008 [54].
	 The release 98 QoS profile data is 3 octets long, which then results in a 6 octets UTF-8 encoded string.
	 The release 99 and release 4 QoS profile data is 11 octets long, which results in a 22 octets UTF-8 encoded
	string. 
	The release 5 and release 6 QoS profile data is 14 octets long, which results in a 28 octets UTF-8 encoded
	string.
	 The release 7 (and higher) QoS profile data is 16 octets long, which results in a 32 octets UTF-8 encoded
	string.
	For P-GW:
	 It contains the following QoS parameters associated with the EPS bearer:
	- QCI
	- ARP
	- GBR QoS information (UL/DL MBR, UL/DL GBR) or UL/DL APN-AMBR. In other words if the
	value of QCI indicates a GBR bearer, the GBR QoS information shall be present. If the value of QCI
	indicates a non-GBR bearer, the APN-AMBR information shall be present.
	The encoding of the EPS bearer QoS profile parameters is specified in 3GPP TS 29.274 [81]: ARP is
	specified in Bearer QoS IE; QCI, ULMBR, DL MBR, UL MBR and DL MBR are specified in Flow QoS IE;
	UL APN-AMBR and DL APN-AMBR are specified in AMBR IE. 
 */
@DiameterAvpDefinition(code = 5L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-GPRSNegotiated-QoSProfile")
public interface TGPPGPRSNegotiatedQoSProfile extends DiameterUTF8String
{
}