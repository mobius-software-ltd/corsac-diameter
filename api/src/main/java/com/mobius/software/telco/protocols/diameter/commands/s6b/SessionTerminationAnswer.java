package com.mobius.software.telco.protocols.diameter.commands.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.2.2.3.2	Session-Termination-Answer (STA) Command
	The Session-Termination-Answer (STA) command, indicated by the Command-Code field set to 275 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA server to a PDN GW. The Command Code value and ABNF are re-used from the IETF RFC 6733 [58] Session-Termination-Answer command.
	
	<Session-Termination-Answer> ::=	< Diameter Header: 275, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ AVP ]
			
	9.2.2.4.4	Session-Termination-Answer (STA) Command
	The Session-Termination-Answer (STA) command, indicated by the Command-Code field set to 275 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA Server/Proxy to an PDN GW. The Command Code value and ABNF are re-used from the IETF RFC 6733 [58] Session-Termination-Answer command.

	<Session-Termination-Answer> ::=	< Diameter Header: 275, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ AVP ]			
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6B, commandCode = CommandCodes.SESSION_TERMINATION, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends S6bAnswer
{
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
}