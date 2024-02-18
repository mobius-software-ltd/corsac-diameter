package com.mobius.software.telco.protocols.diameter.commands.s6c;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSGMSCAlertEvent;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2.5	Alert-Service-Centre-Request (ALR) Command
	The Alert-Service-Centre-Request (ALR) command, indicated by the Command-Code field set to 8388648 and the "R" bit set in the Command Flags field, is sent from the HSS to the SMS-IWMSC and from the MME or SGSN to the SMS-GMSC (possibly via an SMS Router).
	Message Format:

	< Alert-Service-Centre-Request > ::=	< Diameter Header: 8388648, REQ, PXY, 16777312 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { SC-Address }
				 { User-Identifier }
				 [ SMSMI-Correlation-ID ]
				 [ Maximum-UE-Availability-Time ]
				 [ SMS-GMSC-Alert-Event ]
				 [ Serving-Node ]
				*[ Supported-Features ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6C, commandCode = CommandCodes.ALERT_SERVICE_CENTRE, request = true, proxyable = true, name="Alert-Service-Centre-Request")
public interface AlertServiceCentreRequest extends S6cRequest
{
	String getSCAddress();
	
	void setSCAddress(String value) throws MissingAvpException;
	
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value) throws MissingAvpException;
	 		
	SMSMICorrelationID getSMSMICorrelationID();
	
	void setSMSMICorrelationID(SMSMICorrelationID value);
	
	Date getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(Date value);
	
	SMSGMSCAlertEvent getSMSGMSCAlertEvent();
	
	void setSMSGMSCAlertEvent(SMSGMSCAlertEvent value);	
	
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
}