package com.mobius.software.telco.protocols.diameter.commands.s6c;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2.8	Report-SM-Delivery-Status-Answer (RDA) Command
	The Report-SM-Delivery-Status-Answer (RDA) command, indicated by the Command-Code field set to 8388649 and the 'R' bit cleared in the Command Flags field, is sent from HSS to SMS-GMSC or IP-SM-GW.
	Message Format

	< Report-SM-Delivery-Status-Answer > ::=	< Diameter Header: 8388649, PXY, 16777312 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				*[ Supported-Features ]
				 [ User-Identifier ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777312, commandCode = 8388649, request = false, proxyable = true, name="Report-SM-Delivery-Status-Answer")
public interface ReportSMDeliveryStatusAnswer extends S6cAnswer
{	
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value);
}