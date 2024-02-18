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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDeliveryFailureCause;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2.6	MT-Forward-Short-Message-Answer (TFA) Command
	The MT-Forward-Short-Message-Answer Command (TFA) command, indicated by the Command-Code field set to 8388646 and the 'R' bit cleared in the Command Flags field, is sent from the MME / SGSN to the SMS-GMSC (transiting an SMS Router, if present).
	Message Format

	< MT-Forward-Short-Message-Answer > ::=	< Diameter Header: 8388646, PXY, 16777313 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				*[ Supported-Features ]
				 [ Absent-User-Diagnostic-SM ]
				 [ SM-Delivery-Failure-Cause ]
				 [ SM-RP-UI ]
				 [ Requested-Retransmission-Time ]
				 [ User-Identifier ]
				 [ EPS-Location-Information ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
*/
@DiameterCommandDefinition(applicationId = ApplicationIDs.SGD, commandCode = CommandCodes.MT_FORWARD_SHORT_MESSAGE, request = false, proxyable = true, name="MT-Forward-Short-Message-Answer")
public interface MTForwardShortMessageAnswer extends SgdAnswer
{	
	Long getAbsentUserDiagnosticSM();
	 
	void setAbsentUserDiagnosticSM(Long value);
	
	SMDeliveryFailureCause getSMDeliveryFailureCause();
	 
	void setSMDeliveryFailureCause(SMDeliveryFailureCause value);
	
	ByteBuf getSMRPUI();
	
	void setSMRPUI(ByteBuf value);
	
	Date getRequestedRetransmissionTime();
	 
	void setRequestedRetransmissionTime(Date value);	
	
	UserIdentifier getUserIdentifier();
	 
	void setUserIdentifier(UserIdentifier value);
	
	EPSLocationInformation getEPSLocationInformation();
	 
	void setEPSLocationInformation(EPSLocationInformation value);
}