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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedRegisteredIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.LooseRouteIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PriviledgedSenderIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.4	Server-Assignment-Answer (SAA) Command
	The Server-Assignment-Answer (SAA) command, indicated by the Command-Code field set to 301 and the 'R' bit cleared in the Command Flags field, is sent by a server in response to the Server-Assignment-Request command. The Experimental-Result AVP may contain one of the values defined in clause 6.2. If Result-Code or Experimental-Result does not inform about an error, the User-Data AVP shall contain the information that the S-CSCF needs to give service to the user.
	Message Format

	<Server-Assignment-Answer> ::=	< Diameter Header: 301, PXY, 16777216 >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ User-Name ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ Supported-Features ]
				 [ User-Data ]
				 [ Charging-Information ]
				 [ Associated-Identities ]
				 [ Loose-Route-Indication ]
				*[ SCSCF-Restoration-Info ]
				 [ Associated-Registered-Identities ]
				 [ Server-Name ]
				 [ Wildcarded-Public-Identity ]
				 [ Priviledged-Sender-Indication ]
				 [ Allowed-WAF-WWSF-Identities ]
				*[ AVP ]
				 [ Failed-AVP ]

 */
@DiameterCommandDefinition(applicationId = 16777216, commandCode = 301, request = false, proxyable = true, name="Server-Assignment-Answer")
public interface ServerAssignmentAnswer extends CxDxAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	List<UserData> getUserData();
	
	void setUserData(List<UserData> value);	
	
	ChargingInformation getChargingInformation();
	 
	void setChargingInformation(ChargingInformation value);
	
	AssociatedIdentities getAssociatedIdentities();
	 
	void setAssociatedIdentities(AssociatedIdentities value);
	
	LooseRouteIndicationEnum getLooseRouteIndication();
	 
	void setLooseRouteIndication(LooseRouteIndicationEnum value);
	
	List<SCSCFRestorationInfo> getSCSCFRestorationInfo();
	 
	void setSCSCFRestorationInfo(List<SCSCFRestorationInfo> value);
	
	AssociatedRegisteredIdentities getAssociatedRegisteredIdentities();
	 
	void setAssociatedRegisteredIdentities(AssociatedRegisteredIdentities value);
	
	String getServerName();
	 
	void setServerName(String value);
	
	String getWildcardedPublicIdentity();
	 
	void setWildcardedPublicIdentity(String value);
	
	PriviledgedSenderIndicationEnum getPriviledgedSenderIndication();
	 
	void setPriviledgedSenderIndication(PriviledgedSenderIndicationEnum value);
	
	AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities();
	 
	void setAllowedWAFWWSFIdentities(AllowedWAFWWSFIdentities value);	
}