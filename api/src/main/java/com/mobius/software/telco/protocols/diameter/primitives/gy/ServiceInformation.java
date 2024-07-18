package com.mobius.software.telco.protocols.diameter.primitives.gy;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;



/*
	  		3.2.6 Diameter Gy CCR – Service-Information grouped AVP
		Grouped AVP format as defined in TS 32.29. Strikethrough formatted AVPs are not included in CCR.
		
				Service-Information :: = < AVP Header: 873>
						[ PS-Information ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Service-Information")
public interface ServiceInformation extends DiameterAvp 
{
	PSInformation getPSInformation();
}