package com.mobius.software.telco.protocols.diameter.primitives.nta;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;



/*A.6.3.5	Event-Configuration-Status AVP
  The Event-Configuration-Status AVP (AVP code 4213) is of type Grouped.
  It indicates the status for the monitoring event configuration.
  
  Event-Configuration-Status ::= < AVP Header: 4213 >
                   { Event-Configuration-State }
                   { Extended-SCEF-Reference-ID }
                  *[ AVP ]

*/

@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_NETWORK_REPORTS, vendorId = VendorIDs.TGPP_ID, name = "Event-Configuration-Status")
public interface EventConfigurationStatus extends DiameterGroupedAvp
{
	Long getEventConfigurationState();
	
	void setEventConfigurationState(Long value) throws MissingAvpException;
	
	Long getExtendedSCEFReferenceID();
	
	void setExtendedSCEFReferenceID(Long value) throws MissingAvpException;
}

