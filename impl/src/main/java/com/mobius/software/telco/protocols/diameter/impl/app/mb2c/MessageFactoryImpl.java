package com.mobius.software.telco.protocols.diameter.impl.app.mb2c;
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
import com.mobius.software.telco.protocols.diameter.app.mb2c.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSActionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.mb2c.GCSActionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.mb2c.GCSActionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.mb2c.GCSNotificationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.mb2c.GCSNotificationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.MB2C;
	
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
	
	public GCSNotificationRequest createGCSNotificationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new GCSNotificationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public GCSNotificationAnswer createGCSNotificationAnswer(GCSNotificationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		GCSNotificationAnswerImpl result = new GCSNotificationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(),applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public GCSNotificationAnswer createGCSNotificationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		GCSNotificationAnswerImpl result = new GCSNotificationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public GCSActionRequest createGCSActionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new GCSActionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public GCSActionAnswer createGCSActionAnswer(GCSActionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		GCSActionAnswerImpl result = new GCSActionAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public GCSActionAnswer createGCSActionAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,Long authApplicationId) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		GCSActionAnswerImpl result = new GCSActionAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}