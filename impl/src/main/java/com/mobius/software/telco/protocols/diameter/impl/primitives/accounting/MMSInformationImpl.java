package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.RecipientAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.VASIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.VASPIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Adaptations;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AdaptationsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AuxApplicInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentClass;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ContentClassEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DRMContent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DRMContentEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DeliveryReportRequested;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DeliveryReportRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMBoxStorageRequested;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMBoxStorageRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMContentType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageClass;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageSize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Priority;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReadReplyReportRequested;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReadReplyReportRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReplyApplicID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SubmissionTime;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.VASID;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.VASPID;

/**
*
* @author yulian oifa
*
*/
public class MMSInformationImpl extends DiameterAvpImpl implements MMSInformation
{
	private OriginatorAddress originatorAddress;
	private List<RecipientAddress> recipientAddress;
	private SubmissionTime submissionTime;
	private MMContentType mmContentType;
	private Priority priority;
	private MessageID messageID;
	private MessageType messageType;
	private MessageSize messageSize;
	private MessageClass messageClass;
	private DeliveryReportRequested deliveryReportRequested;
	private ReadReplyReportRequested readReplyReportRequested;
	private MMBoxStorageRequested mmBoxStorageRequested;
	private ApplicID applicID;
	private ReplyApplicID replyApplicID;
	private AuxApplicInfo auxApplicInfo;
	private ContentClass contentClass;
	private DRMContent drmContent;
	private Adaptations adaptations;
	private VASPID vaspId;
	private VASID vasId;
			
	public MMSInformationImpl()
	{
		
	}
	
	public OriginatorAddress getOriginatorAddress()
	{
		return originatorAddress;
	}
	
	public void setOriginatorAddress(OriginatorAddress value)
	{
		this.originatorAddress = value;
	}
	
	public List<String> getRecipientAddress()
	{
		if(recipientAddress==null || recipientAddress.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(RecipientAddress curr:recipientAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setRecipientAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.recipientAddress = null;
		else
		{
			this.recipientAddress = new ArrayList<RecipientAddress>();
			for(String curr:value)
				this.recipientAddress.add(new RecipientAddressImpl(curr, null, null));
		}
	}
	
	public Date getSubmissionTime()
	{
		if(submissionTime==null)
			return null;
		
		return submissionTime.getDateTime();
	}
	
	public void setSubmissionTime(Date value)
	{
		if(value==null)
			this.submissionTime = null;
		else
			this.submissionTime = new SubmissionTimeImpl(value, null, null);			
	}
	
	public MMContentType getMMContentType()
	{
		return mmContentType;
	}
	
	public void setMMContentType(MMContentType value)
	{
		this.mmContentType = value;
	}
	
	public PriorityEnum getPriority()
	{
		if(priority==null)
			return null;
		
		return priority.getEnumerated(PriorityEnum.class);
	}
	
	public void setPriority(PriorityEnum value)
	{
		if(value==null)
			this.priority = null;
		else
			this.priority = new PriorityImpl(value, null, null);			
	}
	
	public String getMessageID()
	{
		if(messageID==null)
			return null;
		
		return messageID.getString();
	}
	
	public void setMessageID(String value)
	{
		if(value==null)
			this.messageID = null;
		else
			this.messageID = new MessageIDImpl(value, null, null);			
	}
	
	public MessageTypeEnum getMessageType()
	{
		if(messageType==null)
			return null;
		
		return messageType.getEnumerated(MessageTypeEnum.class);
	}
	
	public void setMessageType(MessageTypeEnum value)
	{
		if(value==null)
			this.messageType = null;
		else
			this.messageType = new MessageTypeImpl(value, null, null);			
	}
	
	public Long getMessageSize()
	{
		if(messageSize==null)
			return null;
		
		return messageSize.getUnsigned();
	}
	
	public void setMessageSize(Long value)
	{
		if(value==null)
			this.messageSize = null;
		else
			this.messageSize = new MessageSizeImpl(value, null, null);			
	}
	
	public MessageClass getMessageClass()
	{
		return messageClass;
	}
	
	public void setMessageClass(MessageClass value)
	{
		this.messageClass = value;		
	}
	
	public DeliveryReportRequestedEnum getDeliveryReportRequested()
	{
		if(deliveryReportRequested==null)
			return null;
		
		return deliveryReportRequested.getEnumerated(DeliveryReportRequestedEnum.class);
	}
	
	public void setDeliveryReportRequested(DeliveryReportRequestedEnum value)
	{
		if(value==null)
			this.deliveryReportRequested = null;
		else
			this.deliveryReportRequested = new DeliveryReportRequestedImpl(value, null, null);			
	}
	
	public ReadReplyReportRequestedEnum getReadReplyReportRequested()
	{
		if(readReplyReportRequested==null)
			return null;
		
		return readReplyReportRequested.getEnumerated(ReadReplyReportRequestedEnum.class);
	}
	
	public void setReadReplyReportRequested(ReadReplyReportRequestedEnum value)
	{
		if(value==null)
			this.readReplyReportRequested = null;
		else
			this.readReplyReportRequested = new ReadReplyReportRequestedImpl(value, null, null);			
	}
	
	public MMBoxStorageRequestedEnum getMMBoxStorageRequested()
	{
		if(mmBoxStorageRequested==null)
			return null;
		
		return mmBoxStorageRequested.getEnumerated(MMBoxStorageRequestedEnum.class);
	}
	
	public void setMMBoxStorageRequested(MMBoxStorageRequestedEnum value)
	{
		if(value==null)
			this.mmBoxStorageRequested = null;
		else
			this.mmBoxStorageRequested = new MMBoxStorageRequestedImpl(value, null, null);			
	}
	
	public String getApplicID()
	{
		if(applicID==null)
			return null;
		
		return applicID.getString();
	}
	
	public void setApplicID(String value)
	{
		if(value==null)
			this.applicID = null;
		else
			this.applicID = new ApplicIDImpl(value, null, null);			
	}
	
	public String getReplyApplicID()
	{
		if(replyApplicID==null)
			return null;
		
		return replyApplicID.getString();
	}
	
	public void setReplyApplicID(String value)
	{
		if(value==null)
			this.replyApplicID = null;
		else
			this.replyApplicID = new ReplyApplicIDImpl(value, null, null);			
	}
	
	public String getAuxApplicInfo()
	{
		if(auxApplicInfo==null)
			return null;
		
		return auxApplicInfo.getString();
	}
	
	public void setAuxApplicInfo(String value)
	{
		if(value==null)
			this.auxApplicInfo = null;
		else
			this.auxApplicInfo = new AuxApplicInfoImpl(value, null, null);			
	}
	
	public ContentClassEnum getContentClass()
	{
		if(contentClass==null)
			return null;
		
		return contentClass.getEnumerated(ContentClassEnum.class);
	}
	
	public void setContentClass(ContentClassEnum value)
	{
		if(value==null)
			this.contentClass = null;
		else
			this.contentClass = new ContentClassImpl(value, null, null);			
	}
	
	public DRMContentEnum getDRMContent()
	{
		if(drmContent==null)
			return null;
		
		return drmContent.getEnumerated(DRMContentEnum.class);
	}
	
	public void setDRMContent(DRMContentEnum value)
	{
		if(value==null)
			this.drmContent = null;
		else
			this.drmContent = new DRMContentImpl(value, null, null);			
	}
	
	public AdaptationsEnum getAdaptations()
	{
		if(adaptations==null)
			return null;
		
		return adaptations.getEnumerated(AdaptationsEnum.class);
	}
	
	public void setAdaptations(AdaptationsEnum value)
	{
		if(value==null)
			this.adaptations = null;
		else
			this.adaptations = new AdaptationsImpl(value, null, null);			
	}
	
	public String getVASPId()
	{
		if(vaspId==null)
			return null;
		
		return vaspId.getString();
	}
	
	public void setVASPId(String value)
	{
		if(value==null)
			this.vaspId = null;
		else
			this.vaspId = new VASPIDImpl(value, null, null);			
	}
	
	public String getVASId()
	{
		if(vasId==null)
			return null;
		
		return vasId.getString();
	}
	
	public void setVASId(String value)
	{
		if(value==null)
			this.vasId = null;
		else
			this.vasId = new VASIDImpl(value, null, null);			
	}
}