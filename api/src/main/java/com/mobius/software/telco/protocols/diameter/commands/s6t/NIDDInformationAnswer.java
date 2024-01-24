package com.mobius.software.telco.protocols.diameter.commands.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupUserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationResponse;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.8	NIDD-Information-Answer (NIA) Command
	The NIDD-Information-Answer (NIA) command, indicated by the Command-Code field set to 8388726 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the SCEF. It may also be sent from the SCEF to the HSS when the feature "NIDD Authorization Update" is commonly supported by the HSS and the SCEF.
	Message Format:

	< NIDD-Information-Answer > ::=	< Diameter Header: 8388726, PXY, 16777345 >
				 < Session-Id >
				 [ DRMP ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ Supported-Features ]
				 [ NIDD-Authorization-Response ]
				*[ Group-User-Identifier ]
				 [ NIA-Flags ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777345, commandCode = 8388726, request = false, proxyable = true, name="NIDD-Information-Answer")
public interface NIDDInformationAnswer extends S6tAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	NIDDAuthorizationResponse getNIDDAuthorizationResponse();
	 
	void setNIDDAuthorizationResponse(NIDDAuthorizationResponse value);	
	
	List<GroupUserIdentifier> getGroupUserIdentifier();
	 
	void setGroupUserIdentifier(List<GroupUserIdentifier> value);
	
	NIAFlags getNIAFlags();
	
	void setNIAFlags(NIAFlags value);
}