package com.mobius.software.telco.protocols.diameter.impl.app.eap;
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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.app.eap.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.eap.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.eap.EAPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.eap.EAPAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.eap.EAPRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.EAP;
	
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
	
	public EAPRequest createEAPRequest(String originHost,String originRealm,String destinationRealm,String sessionID,AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException
	{
		return new EAPRequestImpl(originHost, originRealm, destinationRealm, sessionID, false, idGenerator.generateID().toString(), applicationId, authRequestType, eapPayload);
	}
	
	
	public EAPAnswer createEAPAnswer(EAPRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, Long authApplicationId, AuthRequestTypeEnum authRequestType) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		EAPAnswerImpl result = new  EAPAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public EAPAnswer createEAPAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,Long authApplicationId, AuthRequestTypeEnum authRequestType) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		EAPAnswerImpl result = new  EAPAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, authRequestType);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
}