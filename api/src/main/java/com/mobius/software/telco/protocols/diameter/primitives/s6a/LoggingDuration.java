package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.146	Logging-Duration
	The Logging-Duration AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Logging Duration

	The parameter is mandatory if the the job type parameter is configured for Logged MDT or Logged MBSFN MDT. The
	parameter determines the validity of MDT logged configuration for IDLE. The timer starts at time of receiving
	configuration by the UE, and continues independent of UE state transitions and RAT or RPLMN changes.
	Detailed definition of the parameter is in TS 37.320 [30], TS 25.331 [31], TS 36.331 [32] and TS 38.331[43]:
	
	 The parameter is an enumerated type with the following values in UMTS and LTE:

	- 600 sec (0),

	- 1200 sec (1),

	- 2400 sec (2),

	- 3600 sec (3),

	- 5400 sec (4),

	- 7200 sec (5)

	The parameter is an enumerated type with the following values in NR:

	- 600 sec (6)

	- 1200 sec (7)

	- 2400 sec (8)

	- 3600 sec (9)

	- 5400 sec (10)

	- 7200 sec (11) 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOGGING_DURATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Logging-Duration")
public interface LoggingDuration extends DiameterEnumerated<LoggingDurationEnum>
{
}