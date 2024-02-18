package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.35	MBMS‑Bearer‑Event‑Diagnostic-Info AVP
	The MBMS‑Bearer‑Event-Diagnostic-Info AVP (AVP code 3533) is of type Enumerated. It indicates the diagnostic reason of an event notified. The following values are supported:
	
	TMGI-Expiry (0)
	The MBMS bearer was terminated due to the expiry of TMGI.

	MBMS-GW-Not-Establishment (1)
	The MBMS bearer was activated failure due to MBMS-GW is not established.

	SGmb-Transient-Path-Failure (2)
	The MBMS bearer was activated failure due to SGmb transient path failure.

	SGmb-Non-Transient-Path-Failure (3)
	The MBMS bearer was terminated due to SGmb non-transient path failure.

	MBMS-GW-User-Plane-Failure (4)
	The MBMS bearer was terminated due to User Plane Failure detected by the MBMS-GW.

	MBMS-GW-Permanent-Error (5)
	The MBMS bearer was terminated due to MBMS-GW Permanent Error response.

	MBMS-GW-Transient-Error (6)
	The MBMS bearer was activated failure due to MBMS-GW Transient Error response. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_EVENT_DIAGNOSTIC_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "MBMS‑Bearer‑Event‑Diagnostic-Info")
public interface MBMSBearerEventDiagnosticInfo extends DiameterEnumerated<MBMSBearerEventDiagnosticInfoEnum>
{
}