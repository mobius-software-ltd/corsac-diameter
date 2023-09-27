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
 * 	7.3.168	Collection-Period-RRM-LTE
	The Collection-Period-RRM-LTE AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Collection period for RRM measurements LTE.

	This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and any of the bits
	2 (M2) or 3 (M3) of the list of measurements parameter (defined in Section 5.10.3) in LTE is set to 1. The parameter is
	used only in case of RAN side measurements whose configuration is determined by RRM.
	This measurement parameter defines the collection period that should be used to collect available measurement samples
	in case of RRM configured measurements. The same collection period should be used for all such measurements that
	are requested in the same MDT or combined Trace and MDT job.
	
	The parameter is an enumerated type with the following values:

	- 1024 ms (0),

	- 1280 ms (1),

	- 2048 ms (2),

	- 2560 ms (3),

	- 5120 ms (4),

	- 10240 ms (5),

	- 1 min (6).
	
	Some values may not be always available e.g., due to the large amount of logging they would generate in a highly
	loaded network. The selection of a specific subset of supported values at the eNB is vendor-specific.
 */
@DiameterAvpDefinition(code = 1657L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Collection-Period-RRM-LTE")
public interface CollectionPeriodRRMLTE extends DiameterEnumerated<CollectionPeriodRRMLTEEnum>
{
}