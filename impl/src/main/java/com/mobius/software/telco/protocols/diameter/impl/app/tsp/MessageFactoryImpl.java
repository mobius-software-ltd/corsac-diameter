package com.mobius.software.telco.protocols.diameter.impl.app.tsp;
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
import com.mobius.software.telco.protocols.diameter.app.tsp.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.tsp.DeviceActionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.tsp.DeviceActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.tsp.DeviceNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.tsp.DeviceNotificationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.tsp.DeviceActionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.tsp.DeviceActionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.tsp.DeviceNotificationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.tsp.DeviceNotificationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.TSP;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	private Long authApplicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator,long authApplicationId, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
		this.authApplicationId = authApplicationId;
	}
	
	public DeviceNotificationRequest createDeviceNotificationRequest(String originHost,String originRealm,String destinationHost, String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new DeviceNotificationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public DeviceNotificationAnswer createDeviceNotificationAnswer(DeviceNotificationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeviceNotificationAnswerImpl result = new  DeviceNotificationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public DeviceNotificationAnswer createDeviceNotificationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeviceNotificationAnswerImpl result = new  DeviceNotificationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public DeviceActionRequest createDeviceActionRequest(String originHost,String originRealm,String destinationHost, String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new DeviceActionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public DeviceActionAnswer createDeviceActionAnswer(DeviceActionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeviceActionAnswerImpl result = new  DeviceActionAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public DeviceActionAnswer createDeviceActionAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeviceActionAnswerImpl result = new  DeviceActionAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, authApplicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
}