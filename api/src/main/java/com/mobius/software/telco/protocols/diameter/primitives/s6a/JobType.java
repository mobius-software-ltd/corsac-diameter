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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.137	Job-Type
	The Job-Type AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Job-Type.
	
	The Job type is a conditional mandatory parameter. The condition is either MDT or RLF or RCEF data collection
	functionality is supported. It defines if a single trace job, a combined MDT and trace job or RLF report collection job or
	RCEF report collection job is activated. This parameter also defines the MDT mode. The Job type parameter is an
	enumerated type with the following values:

	- Immediate MDT only (0);

	- Logged MDT only (1);

	- Trace only (2);

	- Immediate MDT and Trace (3);

	- RLF reports only (4) ;

	- RCEF reports only (5).

	- Logged MBSFN MDT (6).

	NOTE 1: The Job type "RLF reports only" and "RCEF reports only" are applicable only in management based trace
	activation in E-UTRAN and NG-RAN.

	NOTE 2: Logged MBSFN MDT is applicable only for activation in E-UTRAN. 
 */
@DiameterAvpDefinition(code = 1623L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Job-Type")
public interface JobType extends DiameterEnumerated<JobTypeEnum>
{
}