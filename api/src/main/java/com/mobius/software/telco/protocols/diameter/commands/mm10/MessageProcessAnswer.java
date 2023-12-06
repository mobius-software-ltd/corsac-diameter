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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReplyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ResultRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.Status;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.1.2	Message-Process-Answer (MPA) Command
	The Message-Process-Answer (MPA) command, indicated by the Command-Code field set to 311 and the ‘R’ bit cleared in the Command Flags field, is sent by the Diameter server in response to the Message-Process-Request command. The Result-Code or Experimental-Result AVP may contain one of the values defined in section 6.2 in addition to the values defined in RFC 3588 [4].
	Message Format

	< Message-Process-Answer > ::=		< Diameter Header: 311, PXY, 16777226  >
			 < Session-Id >
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Status ]
			*[ Result-Recipient-Address ]
			 [ Delivery-Report ]
			 [ Read-Reply ]
			 [ Billing-Information ]
			 [ Sender-Visibility ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777226, commandCode = 311, request = false, proxyable = true, name="Message-Process-Answer")
public interface MessageProcessAnswer extends VendorSpecificAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	Status getStatus();
	
	void setStatus(Status value);
	
	public List<ResultRecipientAddress> getResultRecipientAddress();
	 
	void setResultRecipientAddress(List<ResultRecipientAddress> value);
	
	DeliveryReportEnum getDeliveryReport();
	
	void setDeliveryReport(DeliveryReportEnum value);
	
	ReadReplyEnum getReadReply();
	
	void setReadReply(ReadReplyEnum value);
	
	String getBillingInformation();
	
	void setBillingInformation(String value);
	
	SenderVisibilityEnum getSenderVisibility();
	
	void setSenderVisibility(SenderVisibilityEnum value);					
}