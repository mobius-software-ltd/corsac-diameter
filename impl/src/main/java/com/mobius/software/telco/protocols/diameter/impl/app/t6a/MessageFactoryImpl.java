package com.mobius.software.telco.protocols.diameter.impl.app.t6a;
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
import com.mobius.software.telco.protocols.diameter.app.t6a.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConfigurationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MODataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MODataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MTDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MTDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ReportingInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ReportingInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConfigurationInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConfigurationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConnectionManagementAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConnectionManagementRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MODataAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MODataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MTDataAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MTDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ReportingInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ReportingInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.T6A;
	
	private IDGenerator<?> idGenerator;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public ConfigurationInformationRequest createConfigurationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConfigurationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public ConfigurationInformationAnswer createConfigurationInformationAnswer(ConfigurationInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConfigurationInformationAnswerImpl result = new ConfigurationInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	
	@Override
	public ConfigurationInformationAnswer createConfigurationInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConfigurationInformationAnswerImpl result = new ConfigurationInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public ConnectionManagementRequest createConnectionManagementRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConnectionManagementRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	@Override
	public ConnectionManagementAnswer createConnectionManagementAnswer(ConnectionManagementRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConnectionManagementAnswerImpl result = new ConnectionManagementAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ConnectionManagementAnswer createConnectionManagementAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConnectionManagementAnswerImpl result = new ConnectionManagementAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public MODataRequest createMODataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new MODataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	@Override
	public MODataAnswer createMODataAnswer(MODataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MODataAnswerImpl result = new MODataAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public MODataAnswer createMODataAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MODataAnswerImpl result = new MODataAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public MTDataRequest createMTDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new MTDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	@Override
	public MTDataAnswer createMTDataAnswer(MTDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MTDataAnswerImpl result = new MTDataAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public MTDataAnswer createMTDataAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MTDataAnswerImpl result = new MTDataAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public ReportingInformationRequest createReportingInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReportingInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public ReportingInformationAnswer createReportingInformationAnswer(ReportingInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportingInformationAnswerImpl result = new ReportingInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ReportingInformationAnswer createReportingInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportingInformationAnswerImpl result = new ReportingInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}