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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupUserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationUpdate;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIRFlags;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.7	NIDD Information Request (NIR) Command
	The NIDD Information Request (NIR) command, indicated by the Command-Code field set to 8388726 and the "R" bit set in the Command Flags field, is sent from the SCEF to the HSS. It may also be sent from the HSS to the SCEF when the feature "NIDD Authorization Update" is commonly supported by the HSS and the SCEF.
	Message Format:

	< NIDD-Information-Request > ::=	< Diameter Header: 8388726, REQ, PXY, 16777345 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Identifier }
				 [ OC-Supported-Features ]
				*[ Supported-Features ]
				 [ NIDD-Authorization-Request ]
				 [ NIDD-Authorization-Update ]
				 [ NIR-Flags ]
				*[ Group-User-Identifier ]
				 [ MTC-Provider-Info ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6T, commandCode = CommandCodes.NIDD_INFORMATION, request = true, proxyable = true, name="NIDD-Information-Request")
public interface NIDDInformationRequest extends S6tRequest
{
	UserIdentifier getUserIdentifier();
	
	void setUserIdentifier(UserIdentifier value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 
	
	NIDDAuthorizationRequest getNIDDAuthorizationRequest();
	
	void setNIDDAuthorizationRequest(NIDDAuthorizationRequest value);
	
	NIDDAuthorizationUpdate getNIDDAuthorizationUpdate();
	
	void setNIDDAuthorizationUpdate(NIDDAuthorizationUpdate value);
	
	NIRFlags getNIRFlags();
	
	void setNIRFlags(NIRFlags value);
	
	List<GroupUserIdentifier> getGroupUserIdentifier();
	
	void setGroupUserIdentifier(List<GroupUserIdentifier> value);	
	
	MTCProviderInfo getMTCProviderInfo();
	
	void setMTCProviderInfo(MTCProviderInfo value);
}