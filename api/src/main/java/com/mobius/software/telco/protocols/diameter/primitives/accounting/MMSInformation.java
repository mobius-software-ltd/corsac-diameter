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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.110	MMS-Information AVP
	The MMS-Information AVP (AVP code 877) is of type Grouped. Its purpose is to allow the transmission of additional MMS service specific information elements. 
	It has the following ABNF grammar:

	MMS-Information :: = 	< AVP Header: 877>
   			[ Originator-Address ]
 		* 	[ Recipient-Address ]
			[ Submission-Time ]
			[ MM-Content-Type ]
			[ Priority ]
			[ Message-ID ]
			[ Message-Type ]
			[ Message-Size ]
			[ Message-Class ]
			[ Delivery-Report-Requested ]
			[ Read-Reply-Report-Requested ]
			[ MMBox-Storage-Requested ]
			[ Applic-ID ]
			[ Reply-Applic-ID ]
			[ Aux-Applic-Info ]
			[ Content-Class ]
			[ DRM-Content ]
			[ Adaptations ]
			[ VASP-Id ]
			[ VAS-Id ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MMS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "MMS-Information")
public interface MMSInformation extends DiameterAvp
{
	OriginatorAddress getOriginatorAddress();
	
	void setOriginatorAddress(OriginatorAddress value);
	
	List<String> getRecipientAddress();
	
	void setRecipientAddress(List<String> value);
	
	Date getSubmissionTime();
	
	void setSubmissionTime(Date value);
	
	MMContentType getMMContentType();
	
	void setMMContentType(MMContentType value);
	
	PriorityEnum getPriority();
	
	void setPriority(PriorityEnum value);
	
	String getMessageID();
	
	void setMessageID(String value);
	
	MessageTypeEnum getMessageType();
	
	void setMessageType(MessageTypeEnum value);
	
	Long getMessageSize();
	
	void setMessageSize(Long value);
	
	MessageClass getMessageClass();
	
	void setMessageClass(MessageClass value);
	
	DeliveryReportRequestedEnum getDeliveryReportRequested();
	
	void setDeliveryReportRequested(DeliveryReportRequestedEnum value);
	
	ReadReplyReportRequestedEnum getReadReplyReportRequested();
	
	void setReadReplyReportRequested(ReadReplyReportRequestedEnum value);
	
	MMBoxStorageRequestedEnum getMMBoxStorageRequested();
	
	void setMMBoxStorageRequested(MMBoxStorageRequestedEnum value);
	
	String getApplicID();
	
	void setApplicID(String value);
	
	String getReplyApplicID();
	
	void setReplyApplicID(String value);
	
	String getAuxApplicInfo();
	
	void setAuxApplicInfo(String value);
	
	ContentClassEnum getContentClass();
	
	void setContentClass(ContentClassEnum value);
	
	DRMContentEnum getDRMContent();
	
	void setDRMContent(DRMContentEnum value);
	
	AdaptationsEnum getAdaptations();
	
	void setAdaptations(AdaptationsEnum value);
	
	String getVASPId();
	
	void setVASPId(String value);
	
	String getVASId();
	
	void setVASId(String value);
}