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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDeliveryFailureCause;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2.4	MO-Forward-Short-Message-Answer (OFA) Command
	The MO-Forward-Short-Message-Answer Command (OFA) command, indicated by the Command-Code field set to 8388645 and the 'R' bit cleared in the Command Flags field, is sent from the SMS-IWMSC to the MME / SGSN and it is also sent from the MTC-IWF to the SMS-IWMSC.
	Message Format

	< MO-Forward-Short-Message-Answer > ::=	< Diameter Header: 8388645, PXY, 16777313 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				*[ Supported-Features ]
				 [ SM-Delivery-Failure-Cause ]
				 [ SM-RP-UI ]
				 [ External-Identifier ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777313, commandCode = 8388645, request = false, proxyable = true, name="MO-Forward-Short-Message-Answer")
public interface MOForwardShortMessageAnswer extends SgdAnswer
{
	SMDeliveryFailureCause getSMDeliveryFailureCause();
	 
	void setSMDeliveryFailureCause(SMDeliveryFailureCause value);
	
	ByteBuf getSMRPUI();
	
	void setSMRPUI(ByteBuf value);
	
	String getExternalIdentifier();
	 
	void setExternalIdentifier(String value);
}