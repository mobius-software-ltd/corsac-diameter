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
	17.7.13	Additional-MBMS-Trace-Info AVP
	The Additional-MBMS-Trace-Info AVP (AVP Code 910) is of type OctetString. This AVP contains Trace Reference2, Trace Recording Session Reference, Triggering Events in BM-SC, Trace Depth for BM-SC, List of interfaces in BM-SC, Trace Activity Control For BM-SC which are all part of the Additional MBMS Trace Info IE as specified in TS 29.060 [24].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ADDITIONAL_MBMS_TRACE_INFO, vendorId = VendorIDs.TGPP_ID, name = "Additional-MBMS-Trace-Info")
public interface AdditionalMBMSTraceInfo extends DiameterOctetString
{
}