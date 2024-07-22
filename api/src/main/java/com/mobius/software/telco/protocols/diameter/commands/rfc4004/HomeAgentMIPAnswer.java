package com.mobius.software.telco.protocols.diameter.commands.rfc4004;
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

/**
*
* @author yulian oifa
*
*/

/*
 *  5.4.  Home-Agent-MIP-Answer

   	In response to a Home-Agent-MIP-Request, the Home Agent sends the
   	Home-Agent-MIP-Answer (HAA), indicated by the Command-Code field set
   	to 262 and the 'R' bit cleared in the Command Flags field, to its
   	local AAA server.  The User-Name MAY be included in the HAA if it is
   	present in the HAR.  If the home agent allocated a home address for
   	the mobile node, the address MUST be included in the MIP-Mobile-
   	Node-Address AVP.  The Result-Code AVP MAY contain one of the values
   	defined in section 6 instead of the values defined in [DIAMBASE].

    Message Format

    <Home-Agent-MIP-Answer> ::= < Diameter Header: 262, PXY >
                                     < Session-Id >
                                     { Auth-Application-Id }
                                     { Result-Code }
                                     { Origin-Host }
                                     { Origin-Realm }
                                     [ Acct-Multi-Session-Id ]
                                     [ User-Name ]
                                     [ Error-Reporting-Host ]
                                     [ Error-Message ]
                                     [ MIP-Reg-Reply ]
                                     [ MIP-Home-Agent-Address ]
                                     [ MIP-Mobile-Node-Address ]
                                     [ MIP-FA-to-HA-SPI ]
                                     [ MIP-FA-to-MN-SPI ]
                                     [ Origin-State-Id ]
                                   * [ Proxy-Info ]
                                   * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MOBILE_IPV4, commandCode = CommandCodes.HOME_AGENT_MIP, request = false, proxyable = true, name="Home-Agent-MIP-Answer")
public interface HomeAgentMIPAnswer extends Rfc4004Answer
{
	Long getMIPFAtoHASPI();
	
	void setMIPFAtoHASPI(Long value);
	
	Long getMIPFAtoMNSPI();
	
	void setMIPFAtoMNSPI(Long value);		
}