package com.mobius.software.telco.protocols.diameter.commands.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FailedPCSCF;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.MultipleRegistrationIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserDataAlreadyAvailableEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.3	Server-Assignment-Request (SAR) Command
	The Server-Assignment-Request (SAR) command, indicated by the Command-Code field set to 301 and the 'R' bit set in the Command Flags field, is sent by a Diameter Multimedia client to a Diameter Multimedia server in order to request it to store the name of the server that is currently serving the user.
	Message Format

	<Server-Assignment-Request> ::=	< Diameter Header: 301, REQ, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			 [ User-Name ]
			 [ OC-Supported-Features ]
			*[ Supported-Features ]
			*[ Public-Identity ]
			 [ Wildcarded-Public-Identity ]
			 { Server-Name }
			 { Server-Assignment-Type }
			 { User-Data-Already-Available }
			 [ SCSCF-Restoration-Info ]
			 [ Multiple-Registration-Indication ]
			 [ Session-Priority ]
			 [ SAR-Flags ]
			 [ Failed-PCSCF ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777216, commandCode = 301, request = true, proxyable = true, name="Server-Assignment-Request")
public interface ServerAssignmentRequest extends CxDxRequest
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	List<String> getPublicIdentity();
	
	void setPublicIdentity(List<String> value);
	
	String getWildcardedPublicIdentity();
	
	void setWildcardedPublicIdentity(String value);
	
	String getServerName();
	
	void setServerName(String value);
	
	ServerAssignmentTypeEnum getServerAssignmentType();
	
	void setServerAssignmentType(ServerAssignmentTypeEnum value);
	
	UserDataAlreadyAvailableEnum getUserDataAlreadyAvailable();
	
	void setUserDataAlreadyAvailable(UserDataAlreadyAvailableEnum value);
	
	SCSCFRestorationInfo getSCSCFRestorationInfo();
	
	void setSCSCFRestorationInfo(SCSCFRestorationInfo value);
	
	MultipleRegistrationIndicationEnum getMultipleRegistrationIndication();
	
	void setMultipleRegistrationIndication(MultipleRegistrationIndicationEnum value);
	
	SessionPriorityEnum getSessionPriority();
	
	void setSessionPriority(SessionPriorityEnum value);	
	
	Long getSARFlags();
	
	void setSARFlags(Long value);
	
	FailedPCSCF getFailedPCSCF();
	
	void setFailedPCSCF(FailedPCSCF value);
}