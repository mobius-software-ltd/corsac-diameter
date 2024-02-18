package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.11	MBMS-Session-Identity  AVP
	The MBMS-Session-Identity AVP (AVP code 908) is of type OctetString. Its length is one octet.  It is allocated by the BM-SC. Together with TMGI it identifies a transmission of a specific MBMS session.  The initial transmission and subsequent retransmissions of the MBMS session will use the same values of these parameters. This AVP is optional within the Gmb interface.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_SERVICE_IDENTITY, vendorId = VendorIDs.TGPP_ID, name = "MBMS-Session-Identity")
public interface MBMSSessionIdentity extends DiameterOctetString
{
}