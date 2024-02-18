package com.mobius.software.telco.protocols.diameter.commands.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.OFRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2.3	MO-Forward-Short-Message-Request (OFR) Command
	The MO-Forward-Short-Message-Request (OFR) command, indicated by the Command-Code field set to 8388645 and the "R" bit set in the Command Flags field, is sent from the MME / SGSN to the SMS-IWMSC and it is also sent from the SMS-IWMSC to the MTC-IWF.
	Message Format

	< MO-Forward-Short-Message-Request > ::=	< Diameter Header: 8388645, REQ, PXY, 16777313 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { SC-Address }
				 [ OFR-Flags ]
				*[ Supported-Features ]
				 { User-Identifier }
				 [ EPS-Location-Information ]
				 { SM-RP-UI }
				 [ SMSMI-Correlation-ID ]
				 [ SM-Delivery-Outcome ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SGD, commandCode = CommandCodes.MO_FORWARD_SHORT_MESSAGE, request = true, proxyable = true, name="MO-Forward-Short-Message-Request")
public interface MOForwardShortMessageRequest extends SgdRequest
{
	String getSCAddress();
	
	void setSCAddress(String value);
	
	OFRFlags getOFRFlags();
	
	void setOFRFlags(OFRFlags value);	
	
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value) throws MissingAvpException;
	
	EPSLocationInformation getEPSLocationInformation();
	 
	void setEPSLocationInformation(EPSLocationInformation value);
	 		
	ByteBuf getSMRPUI();
	
	void setSMRPUI(ByteBuf value) throws MissingAvpException;
	
	SMSMICorrelationID getSMSMICorrelationID();
	
	void setSMSMICorrelationID(SMSMICorrelationID value);
	
	SMDeliveryOutcome getSMDeliveryOutcome();
	
	void setSMDeliveryOutcome(SMDeliveryOutcome value);
}