package com.mobius.software.telco.protocols.diameter.impl.app.mm10;
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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.mm10.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.mm10.MessageProcessAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.mm10.MessageProcessRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterfaceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEventEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.MM10;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
	}
	
	public MessageProcessRequest createMessageProcessRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,Date eventTimestamp, TriggerEventEnum triggerEvent, ServedUserIdentity servedUserIdentity,List<InitialRecipientAddress> initialRecipientAddress,OriginatingInterfaceEnum originatingInterface) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		MessageProcessRequest request = new MessageProcessRequestImpl(originHost,originRealm,destinationHost,destinationRealm,false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED,eventTimestamp, triggerEvent, servedUserIdentity,initialRecipientAddress,originatingInterface);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
	
	public MessageProcessAnswer createMessageProcessAnswer(MessageProcessRequest request,Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		return new MessageProcessAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(),AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public MessageProcessAnswer createMessageProcessAnswer(String originHost, String originRealm, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		return new MessageProcessAnswerImpl(originHost,originRealm, false, resultCode, sessionID,AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
}