package com.mobius.software.telco.protocols.diameter.commands.swx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.swx.Non3GPPUserData;

/**
*
* @author yulian oifa
*
*/

/*
 * 	The Server-Assignment-Answer (SAA) command, indicated by the Command-Code field set to 301 and the 'R' bit cleared in the Command Flags field, is sent by the HSS to the 3GPP AAA Server to confirm the registration, de‑registration, user profile download or restoration procedure. The Result-Code or Experimental-Result AVP may contain one of the values defined in clause 6.2 of 3GPP TS 29.229 [24] in addition to the values defined in IETF RFC 6733 [58].
	Message Format
	< Server-Assignment-Answer > ::=	< Diameter Header: 301, PXY, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { User-Name}
			 [ Non-3GPP-User-Data ]
			 [ 3GPP-AAA-Server-Name ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ] ]
			*[ Load ]
			*[ Supported-Features ]
			…
			*[ AVP ]

	NOTE:	As the Diameter commands described in this specification have been defined based on the former specification of the Diameter base protocol, the Vendor-Specific-Application-Id AVP is still listed as a required AVP (an AVP indicated as {AVP}) in the command code format specifications defined in this specification to avoid backward compatibility issues, even if the use of this AVP has been deprecated in the new specification of the Diameter base protocol (IETF RFC 6733 [58]).
 */
@DiameterCommandDefinition(applicationId = 16777265, commandCode = 301, request = false, proxyable = true, name="Server-Assignment-Answer")
public interface ServerAssignmentAnswer extends SwxAnswer
{
	Non3GPPUserData getNon3GPPUserData();
	 
	void setNon3GPPUserData(Non3GPPUserData value);
	
	String get3GPPAAAServerName();
	
	void set3GPPAAAServerName(String value);
					 
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);	 			
}