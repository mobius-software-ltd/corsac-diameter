package com.mobius.software.telco.protocols.diameter.impl.app.nta;
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
import com.mobius.software.telco.protocols.diameter.app.nta.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.nta.EventConfigurationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nta.EventConfigurationRequest;
import com.mobius.software.telco.protocols.diameter.commands.nta.EventReportingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nta.EventReportingRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.nta.EventConfigurationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.nta.EventConfigurationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.nta.EventReportingAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.nta.EventReportingRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.NTA;
	
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

	@Override
	public EventConfigurationRequest createEventConfigurationRequest(String originHost, String originRealm,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new EventConfigurationRequestImpl(originHost,originRealm, null, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public EventConfigurationAnswer createLocationInfoAnswer(EventConfigurationRequest request, Long resultCode) throws MissingAvpException, AvpNotSupportedException 
	{
		return new EventConfigurationAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(),AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public EventConfigurationAnswer createLocationInfoAnswer(String originHost, String originRealm, Long resultCode,String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		return new EventConfigurationAnswerImpl(originHost,originRealm, false, resultCode, sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public EventReportingRequest createEventReportingRequest(String originHost, String originRealm,String destinationHost, String destinationRealm) throws MissingAvpException, AvpNotSupportedException 
	{
		return new EventReportingRequestImpl(originHost, originRealm, destinationHost, destinationRealm,false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public EventReportingAnswer createEventReportingAnswer(EventReportingRequest request, Long resultCode) throws MissingAvpException, AvpNotSupportedException 
	{
		return new EventReportingAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(),AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}

	@Override
	public EventReportingAnswer createEventReportingAnswer(String originHost, String originRealm, Long resultCode,String sessionID) throws MissingAvpException, AvpNotSupportedException 
	{
		return new EventReportingAnswerImpl(originHost,originRealm, false, resultCode, sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
}