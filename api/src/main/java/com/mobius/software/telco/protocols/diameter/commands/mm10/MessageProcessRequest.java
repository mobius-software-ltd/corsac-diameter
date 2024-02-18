package com.mobius.software.telco.protocols.diameter.commands.mm10;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterfaceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReplyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEventEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.1	Message-Process-Request (MPR) Command
	The Message-Process-Request (MPR) command, indicated by the Command-Code field set to 311 and the ‘R’ bit set in the Command Flags field, is sent by a Diameter client to a Diameter server in order to request the processing of a multimedia message.
	Message Format

	<Message-Process-Request> ::=	< Diameter Header: 311, REQ, PXY, 16777226 >
			 < Session-Id >
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Host }
			 { Destination-Realm }
			 { Event-Timestamp }
			 { Trigger-Event }
			 { Served-User-Identity }
			 [ 3GPP-IMSI ]
			 [ Sender-Address ]
			*{ Initial-Recipient-Address }
			 { Originating-Interface }
			 [ Service-Key]
			 [ Delivery-Report ]
			 [ Read-Reply ]
			 [ Sender-Visibility ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MM10, commandCode = CommandCodes.MESSAGE_PROCESS, request = true, proxyable = true, name="Message-Process-Request")
public interface MessageProcessRequest extends VendorSpecificRequest
{
	public AuthSessionStateEnum getAuthSessionState(); 
	
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException; 
	
	Date getEventTimestamp();
	
	void setEventTimestamp(Date value) throws MissingAvpException;
	
	TriggerEventEnum getTriggerEvent();
	
	void setTriggerEvent(TriggerEventEnum value) throws MissingAvpException;
	
	public ServedUserIdentity getServedUserIdentity();
	
	void setServedUserIdentity(ServedUserIdentity value) throws MissingAvpException;

	public String getTGPPIMSI();
	 
	void setTGPPIMSI(String value);

	String getSenderAddress();
	
	void setSenderAddress(String value);	
	
	List<InitialRecipientAddress> getInitialRecipientAddress();
	
	void setInitialRecipientAddress(List<InitialRecipientAddress> value) throws MissingAvpException;
	
	OriginatingInterfaceEnum getOriginatingInterface();
	
	void setOriginatingInterface(OriginatingInterfaceEnum value) throws MissingAvpException;
	
	String getServiceKey();
	
	void setServiceKey(String value);

	DeliveryReportEnum getDeliveryReport();
	
	void setDeliveryReport(DeliveryReportEnum value);	
	
	public ReadReplyEnum getReadReply();
	
	void setReadReply(ReadReplyEnum value);
	
	public SenderVisibilityEnum getSenderVisibility();
	
	void setSenderVisibility(SenderVisibilityEnum value);
}