package com.mobius.software.telco.protocols.diameter.impl.commands.sh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sh.SubscribeNotificationsRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.DSAITagImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.DataReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.ExpiryTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.IdentitySetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.OneTimeNotificationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.SendDataIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.ServiceIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.SubsReqTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DSAITag;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReference;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ExpiryTime;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySet;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySetEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.OneTimeNotification;
import com.mobius.software.telco.protocols.diameter.primitives.sh.OneTimeNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SendDataIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SendDataIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServiceIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SubsReqType;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SubsReqTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777217, commandCode = 308, request = true)
public class SubscribeNotificationsRequestImpl extends ShRequestImpl implements SubscribeNotificationsRequest
{
	private List<ServiceIndication> serviceIndication;
	 
	private SendDataIndication sendDataIndication;
	
	private SubsReqType subsReqType;
	
	private ServerName serverName;
	
	private List<DataReference> dataReference;
	 
	private List<IdentitySet> identitySet;
	
	private ExpiryTime expiryTime;
	
	private List<DSAITag> dsaiTag;
	
	private OneTimeNotification oneTimeNotification;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected SubscribeNotificationsRequestImpl() 
	{
		super();
	}
	
	public SubscribeNotificationsRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, UserIdentity userIdentity, List<DataReferenceEnum> dataReference)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState, userIdentity);		
		
		setDataReference(dataReference);
	}
	
	public List<ByteBuf> getServiceIndication()
	{
		if(serviceIndication==null || serviceIndication.size()==0)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(ServiceIndication curr:serviceIndication)
			result.add(curr.getValue());
		
		return result;
	}
	 
	public void setServiceIndication(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.serviceIndication = null;
		else
		{
			this.serviceIndication = new ArrayList<ServiceIndication>();
			for(ByteBuf curr:value)
				this.serviceIndication.add(new ServiceIndicationImpl(curr, null, null));
		}
	}
	
	@Override
	public SendDataIndicationEnum getSendDataIndication() 
	{
		if(sendDataIndication == null)
			return null;
		
		return sendDataIndication.getEnumerated(SendDataIndicationEnum.class);
	}
	
	@Override
	public void setSendDataIndication(SendDataIndicationEnum value)
	{
		if(value == null)
			this.sendDataIndication = null;
		else
			this.sendDataIndication = new SendDataIndicationImpl(value, null, null);
	}
	
	@Override
	public String getServerName() 
	{
		if(serverName == null)
			return null;
		
		return serverName.getString();
	}
	
	@Override
	public void setServerName(String value)
	{
		if(value == null)
			this.serverName = null;
		else
			this.serverName = new ServerNameImpl(value, null, null);
	}
	
	public SubsReqTypeEnum getSubsReqType()
	{
		if(subsReqType == null)
			return null;
		
		return subsReqType.getEnumerated(SubsReqTypeEnum.class);
	}
	
	public void setSubsReqType(SubsReqTypeEnum value)
	{
		if(value == null)
			this.subsReqType = null;
		else
			this.subsReqType = new SubsReqTypeImpl(value, null, null);
	}
	
	public List<DataReferenceEnum> getDataReference()
	{
		if(dataReference==null || dataReference.size()==0)
			return null;
		
		List<DataReferenceEnum> result=new ArrayList<DataReferenceEnum>();
		for(DataReference curr:dataReference)
			result.add(curr.getEnumerated(DataReferenceEnum.class));
		
		return result;
	}
	 
	public void setDataReference(List<DataReferenceEnum> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Data-Reference is required");
			
		this.dataReference = new ArrayList<DataReference>();
		for(DataReferenceEnum curr:value)
			this.dataReference.add(new DataReferenceImpl(curr, null, null));
	}
	
	public List<IdentitySetEnum> getIdentitySet()
	{
		if(identitySet==null || identitySet.size()==0)
			return null;
		
		List<IdentitySetEnum> result=new ArrayList<IdentitySetEnum>();
		for(IdentitySet curr:identitySet)
			result.add(curr.getEnumerated(IdentitySetEnum.class));
		
		return result;
	}
	 
	public void setIdentitySet(List<IdentitySetEnum> value)
	{
		if(value==null || value.size()==0)
			this.identitySet = null;
		else
		{
			this.identitySet = new ArrayList<IdentitySet>();
			for(IdentitySetEnum curr:value)
				this.identitySet.add(new IdentitySetImpl(curr, null, null));
		}
	}
	
	public Date getExpiryTime()
	{
		if(expiryTime == null)
			return null;
		
		return expiryTime.getDateTime();
	}
	
	public void setExpiryTime(Date value)
	{
		if(value==null)
			this.expiryTime = null;
		else
			this.expiryTime = new ExpiryTimeImpl(value, null, null);
	}
	
	public List<ByteBuf> getDSAITag()
	{
		if(dsaiTag==null || dsaiTag.size()==0)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(DSAITag curr:dsaiTag)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setDSAITag(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.dsaiTag = null;
		else
		{
			this.dsaiTag = new ArrayList<DSAITag>();
			for(ByteBuf curr:value)
				this.dsaiTag.add(new DSAITagImpl(curr, null, null));
		}
	}
	
	public OneTimeNotificationEnum getOneTimeNotification()
	{
		if(oneTimeNotification == null)
			return null;
		
		return oneTimeNotification.getEnumerated(OneTimeNotificationEnum.class);
	}
	
	public void setOneTimeNotification(OneTimeNotificationEnum value)
	{
		if(value==null)
			this.oneTimeNotification = null;
		else
			this.oneTimeNotification = new OneTimeNotificationImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(dataReference == null || dataReference.size()==0)
			return "Data-Reference is required";
		
		return super.validate();
	}
}