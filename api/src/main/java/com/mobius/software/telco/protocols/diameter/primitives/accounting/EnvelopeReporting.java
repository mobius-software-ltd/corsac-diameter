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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.61 Envelope-Reporting AVP
	This Envelope-Reporting AVP (AVP code 1268) is of type Enumerated and is used in the CCA[INITIAL] to indicate
	whether the client shall report the start and end of each time envelope, in those cases in which quota is consumed in
	envelopes. It can take the values:

	0 DO_NOT_REPORT_ENVELOPES
	1 REPORT_ENVELOPES
	2 REPORT_ENVELOPES_WITH_VOLUME
	3 REPORT_ENVELOPES_WITH_EVENTS
	4 REPORT_ENVELOPES_WITH_VOLUME_AND_EVENTS

	If this AVP is not included in the CCA[Initial] then the client shall not report the individual envelopes.
	If this AVP is included within the Offline-Charging AVP, the value shall dictate the mechanism by which offline
	charging information is generated. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ENVELOPE_REPORTING, vendorId = VendorIDs.TGPP_ID, name = "Envelope-Reporting")
public interface EnvelopeReporting extends DiameterEnumerated<EnvelopeReportingEnum>
{
}