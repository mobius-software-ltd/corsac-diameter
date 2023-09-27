package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.1	Abort-Cause AVP
	The Abort-Cause AVP (AVP code 500) is of type Enumerated, and determines the cause of an abort session request (ASR) or of a RAR indicating a bearer release. The following values are defined:

	BEARER_RELEASED (0)
		This value is used when the bearer has been deactivated as a result from normal signalling handling. For GPRS the bearer refers to the PDP Context. It is also used when all the resource allocation corresponding to an AF session fails.

	INSUFFICIENT_SERVER_RESOURCES (1)
		This value is used to indicate that the server is overloaded and needs to abort the session.

	INSUFFICIENT_BEARER_RESOURCES (2)
		This value is used when the bearer has been deactivated due to insufficient bearer resources at a transport gateway (e.g. GGSN for GPRS).

	PS_TO_CS_HANDOVER (3)
		This value is used when the PCRF needs to initiate the AF session termination due to PS to CS handover.
	
	SPONSORED_DATA_CONNECTIVITY_ DISALLOWED (4)
		This value is used in the ASR when the PCRF needs to initiates the AF session termination due to the operator policy (e.g. disallowing the UE accessing the sponsored data connectivity in the roaming case).
 */
@DiameterAvpDefinition(code = 500L, vendorId = KnownVendorIDs.TGPP_ID, name = "Abort-Cause")
public interface AbortCause extends DiameterEnumerated<AbortCauseEnum>
{
}