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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.130	PRA-Install AVP (3GPP-EPS access type)
	The PRA-Install AVP (AVP code 2845) is of type Grouped, and it is used to provision a list of new or updated Presence Reporting Area(s) for an IP-CAN session.
	AVP Format:
	PRA-Install ::= 	< AVP Header: 2845 >
		*[ Presence-Reporting-Area-Information ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 2845L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PRA-Install")
public interface PRAInstall extends DiameterGroupedAvp
{
	List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value);				  
}