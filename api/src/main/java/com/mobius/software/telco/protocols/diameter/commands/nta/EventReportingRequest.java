package com.mobius.software.telco.protocols.diameter.commands.nta;

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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReports;

/* A.6.6.4	Event-Reporting-Request (ERR) command
 The ERR command, indicated by the Command-Code field set to 8388736 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the SCEF as part of event monitoring report procedure.
 Message Format:
 <ER-Request> ::= <Diameter Header: 8388736, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Destination-Host }
                 [ OC-Supported-Features ]
                 [ Event-Reports ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ AVP ]
      
*/

@DiameterCommandDefinition(applicationId = ApplicationIDs.NTA, commandCode = CommandCodes.EVENT_REPORTING, request = true, proxyable = true, name="Event-Reporting-Request")
public interface EventReportingRequest extends NtaRequest
{
	EventReports getEventReports();
	
	void setEventReports(EventReports value);
}
