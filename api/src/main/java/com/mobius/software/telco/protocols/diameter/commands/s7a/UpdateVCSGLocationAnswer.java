package com.mobius.software.telco.protocols.diameter.commands.s7a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UVAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNCSGSubscriptionData;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.22	Update-VCSG-Location-Answer (UVA) Command
	The Update-VCSG-Location-Answer (UVA) command, indicated by the Command-Code field set to 8388638 and the 'R' bit cleared in the Command Flags field, is sent from CSS to MME or SGSN.
	Message Format

	< Update-VCSG-Location-Answer> ::=	< Diameter Header: 8388638, PXY,  >
			 < Session-Id >
			 [ DRMP ]
			 [ Vendor-Specific-Application-Id ]
			 [ Result-Code ]
			 [ Experimental-Result ]
			 [ Error-Diagnostic ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			*[ Supported-Features ]
			*[ VPLMN-CSG-Subscription-Data ]
			 [ UVA-Flags ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S7A, commandCode = CommandCodes.UPDATE_VCSG_LOCATION, request = false, proxyable = true, name="Update-VCSG-Location-Answer")
public interface UpdateVCSGLocationAnswer extends S7aAnswer
{
	ErrorDiagnosticEnum getErrorDiagnostic();
	 
	void setErrorDiagnostic(ErrorDiagnosticEnum value);
	
	List<VPLMNCSGSubscriptionData> getVPLMNCSGSubscriptionData();
	 
	void setVPLMNCSGSubscriptionData(List<VPLMNCSGSubscriptionData> value);
		
	UVAFlags getUVAFlags();
	
	void setUVAFlags(UVAFlags value);
}