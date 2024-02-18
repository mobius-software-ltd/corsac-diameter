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
 * 	5.3.61	IMS-Content-Type AVP
	The IMS-Content-Type AVP (AVP code 564) is of type Enumerated, and it indicates the type of IMS communication service the AF session refers to. The following values are defined:

	NO_CONTENT_DETAIL (0)
		This value is used to indicate that no information about the type of IMS communication service is being provided

	CAT (1)
		This value is used to indicate that the type of IMS communication service is Customized Alerting Tones

	CONFERENCE (2)
		This value is used to indicate that the type of IMS communication service is 3PTY conference
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_CONTENT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "IMS-Content-Type")
public interface IMSContentType extends DiameterEnumerated<IMSContentTypeEnum>
{
}