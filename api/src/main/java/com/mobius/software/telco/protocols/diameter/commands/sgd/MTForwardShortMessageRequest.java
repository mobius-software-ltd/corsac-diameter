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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.TFRFlags;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.2.5	MT-Forward-Short-Message-Request (TFR) Command
	The MT-Forward-Short-Message-Request (TFR) command, indicated by the Command-Code field set to 8388646 and the "R" bit set in the Command Flags field, is sent from the SMS-GMSC to the MME / SGSN (transiting an SMS Router, if present).
	Message Format

	< MT-Forward-Short-Message-Request > ::=	< Diameter Header: 8388646, REQ, PXY, 16777313 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Host }
				 { Destination-Realm }
				 { User-Name }
				*[ Supported-Features ]
				 [ SMSMI-Correlation-ID ]
				 { SC-Address }
				 { SM-RP-UI }
				 [ MME-Number-for-MT-SMS ]
				 [ SGSN-Number ]
				 [ TFR-Flags ]
				 [ SM-Delivery-Timer ]
				 [ SM-Delivery-Start-Time ]
				 [ Maximum-Retransmission-Time ]
				 [ SMS-GMSC-Address ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SGD, commandCode = CommandCodes.MT_FORWARD_SHORT_MESSAGE, request = true, proxyable = true, name="MT-Forward-Short-Message-Request")
public interface MTForwardShortMessageRequest extends SgdRequest
{
	SMSMICorrelationID getSMSMICorrelationID();
	
	void setSMSMICorrelationID(SMSMICorrelationID value);
	
	String getSCAddress();
	
	void setSCAddress(String value) throws MissingAvpException;
	
	ByteBuf getSMRPUI();
	
	void setSMRPUI(ByteBuf value) throws MissingAvpException;
	
	String getMMENumberForMTSMS();
	 
	void setMMENumberForMTSMS(String value);
	 		
	String getSGSNNumber();
	
	void setSGSNNumber(String value);
	
	TFRFlags getTFRFlags();
	
	void setTFRFlags(TFRFlags value);	
	
	Long getSMDeliveryTimer();
	 
	void setSMDeliveryTimer(Long value);
	
	Date getSMDeliveryStartTime();
	 
	void setSMDeliveryStartTime(Date value);
	
	Date getMaximumRetransmissionTime();
	 
	void setMaximumRetransmissionTime(Date value);
	
	String getSMSGMSCAddress();
	 
	void setSMSGMSCAddress(String value);
}