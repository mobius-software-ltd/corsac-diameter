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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.109	Presence-Reporting-Area-Information AVP (3GPP-EPS access type)
	The Presence-Reporting-Area-Information AVP (AVP code 2822) is of type Grouped, contains the information which describes a Presence Reporting Area. 
	The Presence-Reporting-Area-Identifier AVP defines a unique identifier for presence reporting area or presence reporting area set.
	The Presence-Reporting-Area-Status AVP indicates the status of UE for presence reporting area or the status of the presence reporting area.
	The Presence-Reporting-Area-Elements-List AVP contains, for a UE-dedicated presence area, the elements of the Presence Reporting Area. For a core network pre-configured presence reporting area, the element list shall not be present.
	When the presence area is UE-dedicated, the PCRF may acquire the presence reporting area information from the SPR.
	SPR.
	The Presence-Reporting-Area-Node AVP indicates the node(s) which subscribed to the UE status in the presence reporting area. This AVP is not applicable to the Gx interface.
	AVP Format:

	Presence-Reporting-Area-Information ::= < AVP Header: 2822 >
		[ Presence-Reporting-Area-Identifier ]
		[ Presence-Reporting-Area-Status ]
		[ Presence-Reporting-Area-Elements-List ]
		[ Presence-Reporting-Area-Node ]
	   *[ AVP ]
 */
@DiameterAvpDefinition(code = 2822L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "Presence-Reporting-Area-Information")
public interface PresenceReportingAreaInformation extends DiameterGroupedAvp
{
	ByteBuf getPresenceReportingAreaIdentifier();
	
	void setPresenceReportingAreaIdentifier(ByteBuf value);		
	
	PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus();
	
	void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value);	
	
	ByteBuf getPresenceReportingAreaElementsList();
	
	void setPresenceReportingAreaElementsList(ByteBuf value);	
	
	PresenceReportingAreaNode getPresenceReportingAreaNode();
	
	void setPresenceReportingAreaNode(PresenceReportingAreaNode value);			  
}