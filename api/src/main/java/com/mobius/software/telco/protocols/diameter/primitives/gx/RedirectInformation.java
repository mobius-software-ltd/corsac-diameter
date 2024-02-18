package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.82	Redirect-Information AVP 
	The Redirect-Information AVP (AVP code 1085) is of type Grouped. It indicates whether the detected application traffic should be redirected to another controlled address. The Redirect-Information AVP is sent from the PCRF as a part of Charging-Rule-Definition AVP.
	If the Redirect-Information AVP includes the Redirect-Server-Address AVP, the Redirect-Address-Type AVP shall also be provided indicating the type of address given in the Redirect-Server-Address AVP.
	AVP Format:

	Redirect-Information ::= < AVP Header: 1085 >
		 [ Redirect-Support ]
		 [ Redirect-Address-Type ]
		 [ Redirect-Server-Address ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REDIRECT_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Redirect-Information")
public interface RedirectInformation extends DiameterGroupedAvp
{
	RedirectSupportEnum getRedirectSupport();
	
	void setRedirectSupport(RedirectSupportEnum value);	
	
	RedirectAddressTypeEnum getRedirectAddressType();
	
	void setRedirectAddressType(RedirectAddressTypeEnum value);	
	
	String getRedirectServerAddress();
	
	void setRedirectServerAddress(String value);
}