package com.mobius.software.telco.protocols.diameter.commands.cip;
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
/* 
	3.5 Re-Auth-Answer
	The Re-Auth-Answer (RAA) is indicated by the command code set to 258 and
	the ‘R’ bit is cleared in the command flag field. It is sent as a response to the
	Re-Auth-Request.
	
	The Auth-Application-Id for CIP/IP applies (16777232). As this
	is a standard Diameter Base Protocol command there will be no
	Vendor-Specific-Application-Id added.
	
		<RAA> ::= < Diameter Header: 258, PXY>
				< Session-Id >
				{ Result-Code }
				{ Origin-Host }
				{ Origin-Realm }
			   *[ Failed-AVP ]
		       *[ AVP ]
 */

@DiameterCommandDefinition(applicationId = ApplicationIDs.CIP, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{
	
}