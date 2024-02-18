package com.mobius.software.telco.protocols.diameter.commands.pc6;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.8	ProSe-Match-Answer (PMA) Command
	The ProSe-Match-Answer (PMA) Command, indicated by the Command-Code field set to 8388670 and the "R" bit cleared in the Command Flags field, is sent from the ProSe Function in Local PLMN to the ProSe Function in the HPLMN. 
	Message Format

	< ProSe-Match-Answer > ::=	< Diameter Header: 8388670, PXY, 16777340 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 [ Result-Code ]
			 [ Experimental-Result ] 
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ Match-Report ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC6, commandCode = CommandCodes.PROSE_MATCH, request = false, proxyable = true, name="ProSe-Match-Answer")
public interface ProSeMatchAnswer extends Pc6Answer
{
	List<MatchReport> getMatchReport();
	 
	void setMatchReport(List<MatchReport> value);
}