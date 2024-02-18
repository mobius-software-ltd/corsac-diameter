package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.91	Application-Detection-Information AVP 
	The Application-Detection-Information AVP (AVP code 1098) is of type Grouped, and it is used to report once the start/stop of the application traffic, defined by TDF-Application-Identifier, has been detected, in case PCRF has subscribed for APPLICATION_START/APPLICATION_STOP Event-Triggers, unless a request to mute such a notification (Mute-Notification AVP) is part of the corresponding Charging-Rule-Definition AVP to the PCEF.
	The corresponding TDF-Application-Identifier AVP shall be included under Application-Detection-Information AVP. When the Event trigger indicates APPLICATION_START, the Flow-Information AVP for the detected application, if deducible, shall be included under Application-Detection-Information AVP. When the Flow-Information AVP is included, the TDF-Application-Instance-Identifier AVP shall also be included. The Flow-Information AVP, if present, shall contain the Flow-Description AVP and Flow-Direction AVP. Also, the corresponding Event-Trigger (APPLICATION_START or APPLICATION_STOP) shall be provided to PCRF. When the TDF-Application-Instance-Identifier AVP is included with an APPLICATION_START event, it shall also be included when the corresponding APPLICATION_STOP event is notified.
	AVP Format:

	Application-Detection-Information ::=      < AVP Header: 1098 >
		 { TDF-Application-Identifier }
		 [ TDF-Application-Instance-Identifier ]
		*[ Flow-Information ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APPLICATION_DETECTION_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Application-Detection-Information")
public interface ApplicationDetectionInformation extends DiameterGroupedAvp
{
	ByteBuf getTDFApplicationIdentifier();
	
	void setTDFApplicationIdentifier(ByteBuf value) throws MissingAvpException;	
	
	ByteBuf getTDFApplicationInstanceIdentifier();
	
	void setTDFApplicationInstanceIdentifier(ByteBuf value);	
	
	List<FlowInformation> getFlowInformation();
	
	void setFlowInformation(List<FlowInformation> value);
}