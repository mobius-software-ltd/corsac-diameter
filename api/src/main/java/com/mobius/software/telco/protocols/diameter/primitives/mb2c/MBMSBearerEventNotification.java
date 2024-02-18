package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
 * 	6.4.5	MBMS‑Bearer‑Event‑Notification AVP
	The MBMS‑Bearer‑Event-Notification AVP (AVP code 3503) is of type Grouped. It is used by the BM‑SC to notify the GCS AS about an MBMS bearer event.
	AVP Format:
	MBMS-Bearer-Event-Notification::=    < AVP Header: 3503 >
                                     { TMGI}
                                     { MBMS-Flow-Identifier }
                                     { MBMS-Bearer-Event }
                                     [ MBMS-Bearer-Event-Diagnostic-Info ]
                                    *[ Userplane-Protocol‑Result ]
                                    *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_EVENT_NOTIFICATION, vendorId = VendorIDs.TGPP_ID, name = "MBMS‑Bearer‑Event‑Notification")
public interface MBMSBearerEventNotification extends DiameterGroupedAvp
{
	ByteBuf getTMGI();
	
	void setTMGI(ByteBuf value) throws MissingAvpException;	
	
	ByteBuf getMBMSFlowIdentifier();
	
	void setMBMSFlowIdentifier(ByteBuf value) throws MissingAvpException;
	
	MBMSBearerEvent getMBMSBearerEvent();
	
	void setMBMSBearerEvent(MBMSBearerEvent value) throws MissingAvpException;
	
	MBMSBearerEventDiagnosticInfoEnum getMBMSBearerEventDiagnosticInfo();
	
	void setMBMSBearerEventDiagnosticInfo(MBMSBearerEventDiagnosticInfoEnum value);
	
	List<UserplaneProtocolResult> getUserplaneProtocolResult();
	
	void setUserplaneProtocolResult(List<UserplaneProtocolResult> value);
}