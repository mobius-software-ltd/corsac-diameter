package com.mobius.software.telco.protocols.diameter.commands.s6m;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.4	Subscriber-Information-Answer (SIA) Command
	The Subscriber-Information-Answer (SIA) command, indicated by the Command-Code field set to 8388641 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the MTC-IWF or from the HSS to the MTC-AAA.
	Message Format:
	
	< Subscriber-Information-Answer> ::=	< Diameter Header: 8388641, PXY, 16777310 >
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
				*[ User-Identifier ]
				 [ Service-Data ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6M, commandCode = CommandCodes.SUBSCRIBER_INFORMATION, request = false, proxyable = true, name="Subscriber-Information-Answer")
public interface SubscriberInformationAnswer extends S6mAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	List<UserIdentifier> getUserIdentifier();
	 
	void setUserIdentifier(List<UserIdentifier> value);
	
	ServiceData getServiceData();
	 
	void setServiceData(ServiceData value);		
}