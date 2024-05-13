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

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ApplicationPortIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ClientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DataCodingScheme;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MTCIWFAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfMessagesSent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatorSCCPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReplyPathRequested;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReplyPathRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDischargeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMMessageType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMMessageTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMProtocolId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSNodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSResult;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMStatus;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMUserDataHeader;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ApplicationPortIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SMSInformationImpl extends DiameterAvpImpl implements SMSInformation
{
	private SMSNode smsNode;
	private ClientAddress clientAddress;
	private OriginatorSCCPAddress originatorSCCPAddress;
	private SMSCAddress smscAddress;
	private DataCodingScheme dataCodingScheme;
	private SMDischargeTime smDischargeTime;
	private SMMessageType smMessageType;
	private OriginatorInterface originatorInterface;
	private SMProtocolId smProtocolID;
	private ReplyPathRequested replyPathRequested;
	private SMStatus smStatus;
	private SMUserDataHeader smUserDataHeader;
	private NumberOfMessagesSent numberOfMessagesSent; 
	private SMSequenceNumber smSequenceNumber;
 	private List<RecipientInfo> recipientInfo;
	private OriginatorReceivedAddress originatorReceivedAddress;
	private SMServiceType smServiceType;
	private SMSResult smsResult;
	private SMDeviceTriggerIndicator smDeviceTriggerIndicator;
	private SMDeviceTriggerInformation smDeviceTriggerInformation;
	private MTCIWFAddress mtcIWFAddress;
	private ApplicationPortIdentifier applicationPortIdentifier;
	private ExternalIdentifier externalIdentifier; 
			
	public SMSInformationImpl()
	{
		
	}
	
	public SMSNodeEnum getSMSNode()
	{
		if(smsNode==null)
			return null;
		
		return smsNode.getEnumerated(SMSNodeEnum.class);
	}
	
	public void setSMSNode(SMSNodeEnum value)
	{
		if(value==null)
			this.smsNode = null;
		else
			this.smsNode = new SMSNodeImpl(value, null, null);			
	}
	
	public InetAddress getClientAddress()
	{
		if(clientAddress==null)
			return null;
		
		return clientAddress.getAddress();
	}
	
	public void setClientAddress(InetAddress value)
	{
		if(value==null)
			this.clientAddress = null;
		else
			this.clientAddress = new ClientAddressImpl(value, null, null);			
	}
	
	public String getOriginatorSCCPAddress()
	{
		if(originatorSCCPAddress==null)
			return null;
		
		return originatorSCCPAddress.getE164();
	}
	
	public void setOriginatorSCCPAddress(String value)
	{
		if(value==null)
			this.originatorSCCPAddress = null;
		else
			this.originatorSCCPAddress = new OriginatorSCCPAddressImpl(value, null, null);			
	}
	
	public SMSCAddress getSMSCAddress()
	{
		return this.smscAddress;
	}
	
	public void setSMSCAddress(SMSCAddress value)
	{
		this.smscAddress = value;
	}
	
	public Integer getDataCodingScheme()
	{
		if(dataCodingScheme==null)
			return null;
		
		return dataCodingScheme.getInteger();
	}
	
	public void setDataCodingScheme(Integer value)
	{
		if(value==null)
			this.dataCodingScheme = null;
		else
			this.dataCodingScheme = new DataCodingSchemeImpl(value, null, null);			
	}
	
	public Date getSMDischargeTime()
	{
		if(smDischargeTime==null)
			return null;
		
		return smDischargeTime.getDateTime();
	}
	
	public void setSMDischargeTime(Date value)
	{
		if(value==null)
			this.smDischargeTime = null;
		else
			this.smDischargeTime = new SMDischargeTimeImpl(value, null, null);			
	}
	
	public SMMessageTypeEnum getSMMessageType()
	{
		if(smMessageType==null)
			return null;
		
		return smMessageType.getEnumerated(SMMessageTypeEnum.class);
	}
	
	public void setSMMessageType(SMMessageTypeEnum value)
	{
		if(value==null)
			this.smMessageType = null;
		else
			this.smMessageType = new SMMessageTypeImpl(value, null, null);			
	}
	
	public OriginatorInterface getOriginatorInterface()
	{
		return this.originatorInterface;
	}
	
	public void setOriginatorInterface(OriginatorInterface value)
	{
		this.originatorInterface = value;
	}
	
	public ByteBuf getSMProtocolId()
	{
		if(smProtocolID==null)
			return null;
		
		return smProtocolID.getValue();
	}
	
	public void setSMProtocolId(ByteBuf value)
	{
		if(value==null)
			this.smProtocolID = null;
		else
			this.smProtocolID = new SMProtocolIdImpl(value, null, null);			
	}
	
	public ReplyPathRequestedEnum getReplyPathRequested()
	{
		if(replyPathRequested==null)
			return null;
		
		return replyPathRequested.getEnumerated(ReplyPathRequestedEnum.class);
	}
	
	public void setReplyPathRequested(ReplyPathRequestedEnum value)
	{
		if(value==null)
			this.replyPathRequested = null;
		else
			this.replyPathRequested = new ReplyPathRequestedImpl(value, null, null);			
	}
	
	public ByteBuf getSMStatus()
	{
		if(smStatus==null)
			return null;
		
		return smStatus.getValue();
	}
	
	public void setSMStatus(ByteBuf value)
	{
		if(value==null)
			this.smStatus = null;
		else
			this.smStatus = new SMStatusImpl(value, null, null);			
	}
	
	public ByteBuf getSMUserDataHeader()
	{
		if(smUserDataHeader==null)
			return null;
		
		return smUserDataHeader.getValue();
	}
	
	public void setSMUserDataHeader(ByteBuf value)
	{
		if(value==null)
			this.smUserDataHeader = null;
		else
			this.smUserDataHeader = new SMUserDataHeaderImpl(value, null, null);			
	}
	
	public Long getNumberOfMessagesSent()
	{
		if(numberOfMessagesSent==null)
			return null;
		
		return numberOfMessagesSent.getUnsigned();
	}
	
	public void setNumberOfMessagesSent(Long value)
	{
		if(value==null)
			this.numberOfMessagesSent = null;
		else
			this.numberOfMessagesSent = new NumberOfMessagesSentImpl(value, null, null);			
	}
	
	public Long getSMSequenceNumber()
	{
		if(smSequenceNumber==null)
			return null;
		
		return smSequenceNumber.getUnsigned();
	}
	
	public void setSMSequenceNumber(Long value)
	{
		if(value==null)
			this.smSequenceNumber = null;
		else
			this.smSequenceNumber = new SMSequenceNumberImpl(value, null, null);			
	}
	
	public List<RecipientInfo> getRecipientInfo()
	{
		return this.recipientInfo;
	}
	
	public void setRecipientInfo(List<RecipientInfo> value)
	{
		this.recipientInfo = value;
	}
	
	public OriginatorReceivedAddress getOriginatorReceivedAddress()
	{
		return this.originatorReceivedAddress;
	}
	
	public void setOriginatorReceivedAddress(OriginatorReceivedAddress value)
	{
		this.originatorReceivedAddress = value;
	}
	
	public SMServiceTypeEnum getSMServiceType()
	{
		if(smServiceType==null)
			return null;
		
		return smServiceType.getEnumerated(SMServiceTypeEnum.class);
	}
	
	public void setSMServiceType(SMServiceTypeEnum value)
	{
		if(value==null)
			this.smServiceType = null;
		else
			this.smServiceType = new SMServiceTypeImpl(value, null, null);			
	}
	
	public Long getSMSResult()
	{
		if(smsResult==null)
			return null;
		
		return smsResult.getUnsigned();
	}
	
	public void setSMSResult(Long value)
	{
		if(value==null)
			this.smsResult = null;
		else
			this.smsResult = new SMSResultImpl(value, null, null);			
	}
	
	public SMDeviceTriggerIndicatorEnum getSMDeviceTriggerIndicator()
	{
		if(smDeviceTriggerIndicator==null)
			return null;
		
		return smDeviceTriggerIndicator.getEnumerated(SMDeviceTriggerIndicatorEnum.class);
	}
	
	public void setSMDeviceTriggerIndicator(SMDeviceTriggerIndicatorEnum value)
	{
		if(value==null)
			this.smDeviceTriggerIndicator = null;
		else
			this.smDeviceTriggerIndicator = new SMDeviceTriggerIndicatorImpl(value, null, null);			
	}
	
	public SMDeviceTriggerInformation getSMDeviceTriggerInformation()
	{
		return this.smDeviceTriggerInformation;
	}
	
	public void setSMDeviceTriggerInformation(SMDeviceTriggerInformation value)
	{
		this.smDeviceTriggerInformation = value;
	}
	
	public InetAddress getMTCIWFAddress()
	{
		if(mtcIWFAddress==null)
			return null;
		
		return mtcIWFAddress.getAddress();
	}
	
	public void setMTCIWFAddress(InetAddress value)
	{
		if(value==null)
			this.mtcIWFAddress = null;
		else
			this.mtcIWFAddress = new MTCIWFAddressImpl(value, null, null);			
	}
	
	public Long getApplicationPortIdentifier()
	{
		if(applicationPortIdentifier==null)
			return null;
		
		return applicationPortIdentifier.getUnsigned();
	}
	
	public void setApplicationPortIdentifier(Long value)
	{
		if(value==null)
			this.applicationPortIdentifier = null;
		else
			this.applicationPortIdentifier = new ApplicationPortIdentifierImpl(value, null, null);			
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value==null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);			
	}
}