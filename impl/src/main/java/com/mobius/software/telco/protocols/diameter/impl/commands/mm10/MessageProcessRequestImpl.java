package com.mobius.software.telco.protocols.diameter.impl.commands.mm10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.DeliveryReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.InitialRecipientAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.OriginatingInterfaceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ReadReplyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.SenderAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.SenderVisibilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ServedUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ServiceKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.TriggerEventImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReport;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterface;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterfaceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReply;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReplyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibility;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServiceKey;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEvent;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEventEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public class MessageProcessRequestImpl extends VendorSpecificRequestImpl implements MessageProcessRequest
{
	protected AuthSessionState authSessionState;
	
	private EventTimestamp eventTimestamp;
	
	private TriggerEvent triggerEvent;
	
	private ServedUserIdentity servedUserIdentity;
	
	private TGPPIMSI tgppIMSI;
	
	private SenderAddress senderAddress;
	
	private List<InitialRecipientAddress> initialRecipientAddress;
	
	private OriginatingInterface originatingInterface;
	
	private ServiceKey serviceKey;
	
	private DeliveryReport deliveryReport;
	
	private ReadReply readReply;
	
	private SenderVisibility senderVisibility;
	
	protected MessageProcessRequestImpl() 
	{
		super();
	}
	
	public MessageProcessRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState,Date eventTimestamp, TriggerEventEnum triggerEvent, ServedUserIdentity servedUserIdentity,List<InitialRecipientAddress> initialRecipientAddress,OriginatingInterfaceEnum originatingInterface) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID);		
		
		setAuthSessionState(authSessionState);
		
		setEventTimestamp(eventTimestamp);
		
		setTriggerEvent(triggerEvent);
		
		setServedUserIdentity(servedUserIdentity);
		
		setInitialRecipientAddress(initialRecipientAddress);
		
		setOriginatingInterface(originatingInterface);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException 
	{
		if(value == null)
			throw new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}

	@Override
	public Date getEventTimestamp() 
	{
		if(eventTimestamp==null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Event-Timestamp is required", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl() }));
		
		this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}
	
	@Override
	public TriggerEventEnum getTriggerEvent()
	{
		if(triggerEvent==null)
			return null;
		
		return this.triggerEvent.getEnumerated(TriggerEventEnum.class);
	}
	
	@Override
	public void setTriggerEvent(TriggerEventEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trigger-Event is required", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl() }));
			
		this.triggerEvent = new TriggerEventImpl(value, null, null);
	}

	@Override
	public ServedUserIdentity getServedUserIdentity()
	{
		return this.servedUserIdentity;
	}
	
	@Override
	public void setServedUserIdentity(ServedUserIdentity value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Served-User-Identity is required", Arrays.asList(new DiameterAvp[] { new ServedUserIdentityImpl() }));
			
		this.servedUserIdentity = value;
	}
	
	@Override
	public String getTGPPIMSI()
	{
		if(tgppIMSI==null)
			return null;
		
		return this.tgppIMSI.getString();
	}
	
	@Override
	public void setTGPPIMSI(String value)
	{
		if(value==null)
			this.tgppIMSI = null;
		else
			this.tgppIMSI = new TGPPIMSIImpl(value, null, null);
	}
	
	@Override
	public String getSenderAddress()
	{
		if(senderAddress==null)
			return null;
		
		return this.senderAddress.getString();
	}
	
	@Override
	public void setSenderAddress(String value)
	{
		if(value==null)
			this.senderAddress = null;
		else
			this.senderAddress = new SenderAddressImpl(value, null, null);
	}
	
	@Override
	public List<InitialRecipientAddress> getInitialRecipientAddress()
	{
		return this.initialRecipientAddress;
	}
	
	@Override
	public void setInitialRecipientAddress(List<InitialRecipientAddress> value) throws MissingAvpException
	{
		if(value==null || value.size()==0)
			throw new MissingAvpException("Initial-Recipient-Address is required", Arrays.asList(new DiameterAvp[] { new InitialRecipientAddressImpl() }));
			
		this.initialRecipientAddress = value;
	}
	
	@Override
	public OriginatingInterfaceEnum getOriginatingInterface()
	{
		if(originatingInterface==null)
			return null;
		
		return this.originatingInterface.getEnumerated(OriginatingInterfaceEnum.class);
	}
	
	@Override
	public void setOriginatingInterface(OriginatingInterfaceEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Originating-Interface is required", Arrays.asList(new DiameterAvp[] { new OriginatingInterfaceImpl() }));
			
		this.originatingInterface = new OriginatingInterfaceImpl(value, null, null);
	}
	
	@Override
	public String getServiceKey()
	{
		if(serviceKey==null)
			return null;
		
		return this.serviceKey.getString();
	}
	
	@Override
	public void setServiceKey(String value)
	{
		if(value==null)
			this.serviceKey = null;
		else
			this.serviceKey = new ServiceKeyImpl(value, null, null);
	}	
	
	@Override
	public DeliveryReportEnum getDeliveryReport() 
	{
		if(deliveryReport==null)
			return null;
		
		return deliveryReport.getEnumerated(DeliveryReportEnum.class);
	}

	@Override
	public void setDeliveryReport(DeliveryReportEnum value) 
	{
		if(value == null)
			this.deliveryReport = null;
		else
			this.deliveryReport = new DeliveryReportImpl(value, null, null);
	}
	
	@Override
	public ReadReplyEnum getReadReply() 
	{
		if(readReply==null)
			return null;
		
		return readReply.getEnumerated(ReadReplyEnum.class);
	}

	@Override
	public void setReadReply(ReadReplyEnum value) 
	{
		if(value == null)
			this.readReply = null;
		else
			this.readReply = new ReadReplyImpl(value, null, null);
	}
	
	@Override
	public SenderVisibilityEnum getSenderVisibility() 
	{
		if(senderVisibility==null)
			return null;
		
		return senderVisibility.getEnumerated(SenderVisibilityEnum.class);
	}

	@Override
	public void setSenderVisibility(SenderVisibilityEnum value) 
	{
		if(value == null)
			this.senderVisibility = null;
		else
			this.senderVisibility = new SenderVisibilityImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authSessionState == null)
			return new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
	
		if(eventTimestamp==null)
			return new MissingAvpException("Event-Timestamp is required", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl() }));
		
		if(triggerEvent==null)
			return new MissingAvpException("Trigger-Event is required", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl() }));
		
		if(servedUserIdentity==null)
			return new MissingAvpException("Served-User-Identity is required", Arrays.asList(new DiameterAvp[] { new ServedUserIdentityImpl() }));
		
		if(initialRecipientAddress==null || initialRecipientAddress.size()==0)
			return new MissingAvpException("Initial-Recipient-Address is required", Arrays.asList(new DiameterAvp[] { new InitialRecipientAddressImpl() }));
		
		if(originatingInterface==null)
			return new MissingAvpException("Originating-Interface is required", Arrays.asList(new DiameterAvp[] { new OriginatingInterfaceImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(eventTimestamp);
		result.add(triggerEvent);
		result.add(servedUserIdentity);
		result.add(tgppIMSI);
		result.add(senderAddress);
		
		if(initialRecipientAddress!=null)
			result.addAll(initialRecipientAddress);
		
		result.add(originatingInterface);
		result.add(serviceKey);
		result.add(deliveryReport);
		result.add(readReply);
		result.add(senderVisibility);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}