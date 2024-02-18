package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.13 TFT-Filter AVP (3GPP-GPRS access type only)
	The TFT-Filter AVP (AVP code 1012) is of type IPFilterRule, and it contains the flow filter for one TFT packet filter.
	The TFT-Filter AVP is derived from the Traffic Flow Template (TFT) defined in 3GPP TS 24.008 [13]. The following
	information shall be sent:

	- Action shall be set to "permit".

	- Direction shall be set to "out".

	- Protocol shall be set to the value provided within the TFT packet filter parameter "Protocol Identifier/Next
	  Header Type". If the TFT packet filter parameter "Protocol Identifier/Next Header Type" is not provided within
      the TFT packet filter, Protocol shall be set to "ip". 

	- Source IP address (possibly masked). The source IP address shall be derived from TFT packet filter parameters
	  "Remote address" and "Subnet Mask". The source IP address shall be set to "any", if no such information is
	  provided in the TFT packet filter.

	- Source and/or destination port (single value, list or ranges). The information shall be derived from the
	  corresponding TFT packet filter remote and/or local port parameters. Source and/or destination port(s) shall be
	  omitted if the corresponding information is not provided in the TFT packet filter.

	- Destination IP address (possibly masked). The Destination IP address shall be derived from TFT packet filter
	  parameters "Local address" and "Subnet Mask". If no such information is provided in the TFT packet filter, the
	  Destination IP address shall be set to "assigned".
	  
	The IPFilterRule type shall be used with the following restrictions:

	- No options shall be used.

	- The invert modifier "!" for addresses shall not be used.
	  
	The direction "out" indicates that the IPFilterRule "source" parameters correspond to the TFT filter "remote" parameters
	in the packet filter and the IPFilterRule "destination" correspond to the TFT filter "local" (UE end) parameters. The
	TFT-Filter AVP applies in the direction(s) as specified in the accompanying Flow-Direction AVP.
	Destination IP address including the value provided by the UE may be provided within the TFT-Filter AVP when the
	ExtendedFilter feature is supported as described in clause 5.4.1.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TFT_FILTER, vendorId = VendorIDs.TGPP_ID, name = "TFT-Filter")
public interface TFTFilter extends DiameterIpFilterRule
{
}