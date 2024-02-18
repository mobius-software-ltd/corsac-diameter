package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.42	Location-Update-Trigger
	The Location-Update-Trigger AVP is of type Grouped. It shall contain the type of event that will trigger a locate update procedure to forward the location of UE to the ProSe Function initiating the Proximity Request.
	The AVP format shall conform to:
		
	Location-Update-Trigger::=	<AVP header: 3823 10415>
		 { Location-Update-Event-Type }
		 [ Change-Of-Area-Type ]
		 [ Periodic-Location-Type ]
		*[AVP]

	The Change-Of-Area-Type AVP shall be present if the Location-Update-Event-Type AVP value is set to CHANGE_OR_AREA (1). Otherwise, it shall be absent.
	The Periodic-Location-Type AVP shall be present if the Location-Update-Event-Type AVP value is set to PERIODIC_LOCATION (2). Otherwise, it shall be absent.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOCATION_UPDATE_TRIGGER, vendorId = VendorIDs.TGPP_ID, name = "Location-Update-Trigger")
public interface LocationUpdateTrigger extends DiameterGroupedAvp
{
	LocationUpdateEventTypeEnum getLocationUpdateEventType();
	
	void setLocationUpdateEventType(LocationUpdateEventTypeEnum value) throws MissingAvpException;
	
	ChangeOfAreaType getChangeOfAreaType();
	
	void setChangeOfAreaType(ChangeOfAreaType value);
	
	PeriodicLocationType getPeriodicLocationType();
	
	void setPeriodicLocationType(PeriodicLocationType value);
}