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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.RDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2.7	Report-SM-Delivery-Status-Request (RDR) Command
	The Report-SM-Delivery-Status-Request (RDR) command, indicated by the Command-Code field set to 8388649 and the "R" bit set in the Command Flags field, is sent from SMS-GMSC or IP-SM-GW to HSS.
	Message Format:

	< Report-SM-Delivery-Status-Request > ::=	< Diameter Header: 8388649, REQ, PXY, 16777312 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				*[ Supported-Features ]
				 { User-Identifier }
				 [ SMSMI-Correlation-ID ]
				 { SC-Address }
				 { SM-Delivery-Outcome }
				 [ RDR-Flags ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6C, commandCode = CommandCodes.REPORT_SM_DELIVERY_STATUS, request = true, proxyable = true, name="Report-SM-Delivery-Status-Request")
public interface ReportSMDeliveryStatusRequest extends S6cRequest
{
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value) throws MissingAvpException;
	 		
	SMSMICorrelationID getSMSMICorrelationID();
	
	void setSMSMICorrelationID(SMSMICorrelationID value);
	
	String getSCAddress();
	
	void setSCAddress(String value) throws MissingAvpException;
	
	SMDeliveryOutcome getSMDeliveryOutcome();
	
	void setSMDeliveryOutcome(SMDeliveryOutcome value) throws MissingAvpException;
	
	RDRFlags getRDRFlags();
	
	void setRDRFlags(RDRFlags value);	
}