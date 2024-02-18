package com.mobius.software.telco.protocols.diameter.commands.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.6	Authentication-Information-Answer (AIA) Command
	The Authentication-Information-Answer (AIA) command, indicated by the Command-Code field set to318 and the 'R' bit cleared in the Command Flags field, is sent from HSS to MME or SGSN.
	Message Format

	< Authentication-Information-Answer> ::=	< Diameter Header: 318, PXY, 16777251 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ Error-Diagnostic ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ Supported-Features]
				 [ Authentication-Info ]
				 [ UE-Usage-Type ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6A, commandCode = CommandCodes.AUTHENTICATION, request = false, proxyable = true, name="Authentication-Information-Answer")
public interface AuthenticationInformationAnswer extends S6aAnswer
{
	ErrorDiagnosticEnum getErrorDiagnostic();
	 
	void setErrorDiagnostic(ErrorDiagnosticEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 	
	AuthenticationInfo getAuthenticationInfo();
	
	void setAuthenticationInfo(AuthenticationInfo value);
	
	Long getUEUsageType();
	 
	void setUEUsageType(Long value);
}