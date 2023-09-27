package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.11	Number-Of-UE-Per-Location-Configuration
	The Number-Of-UE-Per-Location-Configuration AVP is of type Grouped. It shall contain the location information for which the number of UEs needs to be reported by the MME/SGSN.
	AVP format:

	Number-of-UE-Per-Location-Configuration ::= <AVP header: 4306 10415>
			 { EPS-Location-Information }
			 [ IMSI-Group-Id ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 4306L, vendorId = KnownVendorIDs.TGPP_ID, name = "Number-Of-UE-Per-Location-Configuration")
public interface NumberOfUEPerLocationConfiguration extends DiameterGroupedAvp
{
	EPSLocationInformation getEPSLocationInformation();
	
	void setEPSLocationInformation(EPSLocationInformation value);
	
	IMSIGroupId getIMSIGroupId();
	
	void setIMSIGroupId(IMSIGroupId value);
}