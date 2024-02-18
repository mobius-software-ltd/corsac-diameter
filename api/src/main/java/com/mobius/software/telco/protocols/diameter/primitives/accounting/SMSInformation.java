package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.211	SMS-Information AVP
	The SMS-Information AVP (AVP code 2000) is of type Grouped. Its purpose is to allow the transmission of additional SMS service specific information elements. 
	It has the following ABNF grammar:
         
	SMS-Information :: = < AVP Header: 2000>
			[ SMS-Node ]
			[ Client-Address ]
			[ Originator-SCCP-Address ]
			[ SMSC-Address ]
			[ Data-Coding-Scheme ]
			[ SM-Discharge-Time ]
			[ SM-Message-Type ]
			[ Originator-Interface ]
			[ SM-Protocol-ID ]
			[ Reply-Path-Requested ]
			[ SM-Status ]
			[ SM-User-Data-Header ]
			[ Number-Of-Messages-Sent ] 
			[ SM-Sequence-Number ]
 		* 	[ Recipient-Info ]
			[ Originator-Received-Address ]
			[ SM-Service-Type ]
			[ SMS-Result ]
			[ SM-Device-Trigger-Indicator ]
			[ SM-Device-Trigger-Information ]
			[ MTC-IWF-Address ]
			[ Application-Port-Identifier ]
			[ External-Identifier ] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SMS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "SMS-Information")
public interface SMSInformation extends DiameterAvp
{
	SMSNodeEnum getSMSNode();
	
	void setSMSNode(SMSNodeEnum value);
	
	InetAddress getClientAddress();
	
	void setClientAddress(InetAddress value);
	
	String getOriginatorSCCPAddress();
	
	void setOriginatorSCCPAddress(String value);
	
	SMSCAddress getSMSCAddress();
	
	void setSMSCAddress(SMSCAddress value);
	
	Integer getDataCodingScheme();
	
	void setDataCodingScheme(Integer value);
	
	Date getSMDischargeTime();
	
	void setSMDischargeTime(Date value);
	
	SMMessageTypeEnum getSMMessageType();
	
	void setSMMessageType(SMMessageTypeEnum value);
	
	OriginatorInterface getOriginatorInterface();
	
	void setOriginatorInterface(OriginatorInterface value);
	
	ByteBuf getSMProtocolId();
	
	void setSMProtocolId(ByteBuf value);
	
	ReplyPathRequestedEnum getReplyPathRequested();
	
	void setReplyPathRequested(ReplyPathRequestedEnum value);
	
	ByteBuf getSMStatus();
	
	void setSMStatus(ByteBuf value);
	
	ByteBuf getSMUserDataHeader();
	
	void setSMUserDataHeader(ByteBuf value);
	
	Long getNumberOfMessagesSent();
	
	void setNumberOfMessagesSent(Long value);
	
	Long getSMSequenceNumber();
	
	void setSMSequenceNumber(Long value);
	
	List<RecipientInfo> getRecipientInfo();
	
	void setRecipientInfo(List<RecipientInfo> value);
	
	OriginatorReceivedAddress getOriginatorReceivedAddress();
	
	void setOriginatorReceivedAddress(OriginatorReceivedAddress value);
	
	SMServiceTypeEnum getSMServiceType();
	
	void setSMServiceType(SMServiceTypeEnum value);
	
	Long getSMSResult();
	
	void setSMSResult(Long value);
	
	SMDeviceTriggerIndicatorEnum getSMDeviceTriggerIndicator();
	
	void setSMDeviceTriggerIndicator(SMDeviceTriggerIndicatorEnum value);
	
	SMDeviceTriggerInformation getSMDeviceTriggerInformation();
	
	void setSMDeviceTriggerInformation(SMDeviceTriggerInformation value);
	
	InetAddress getMTCIWFAddress();
	
	void setMTCIWFAddress(InetAddress value);
	
	Long getApplicationPortIdentifier();
	
	void setApplicationPortIdentifier(Long value);
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
}