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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.19	MB2U-Security AVP
	The MB2U‑Security AVP (AVP code 3517) is of type Unsigned32. It is used to indicate whether the usage of a security protocol for the MB2‑U interface is requested (when send by the GCS AS) or decided (when send by the BM‑SC).
	The following values are defined in this specification:

	0 (No security):
	This value shall be used to indicate that the usage of no security protocol for the MB2‑U interface is requested or decided. "0" is the default value that shall be used if the AVP is omitted.

	1 (Security):
	This value shall be used to indicate that the usage of a security protocol for the MB2 U interface is requested or decided.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MB2U_SECURITY, vendorId = VendorIDs.TGPP_ID, name = "MB2U-Security")
public interface MB2USecurity extends DiameterUnsigned32
{
}