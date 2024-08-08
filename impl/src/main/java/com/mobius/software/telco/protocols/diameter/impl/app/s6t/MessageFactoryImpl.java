package com.mobius.software.telco.protocols.diameter.impl.app.s6t;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.app.s6t.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6t.NIDDInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6t.NIDDInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ReportingInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ReportingInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ConfigurationInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ConfigurationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.NIDDInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.NIDDInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ReportingInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ReportingInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.S6T;
	
	private  DiameterStack stack;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public ConfigurationInformationRequest createConfigurationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConfigurationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier);
	}
	
	@Override
	public ConfigurationInformationAnswer createConfigurationInformationAnswer(ConfigurationInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConfigurationInformationAnswerImpl result = new  ConfigurationInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ConfigurationInformationAnswer createConfigurationInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ConfigurationInformationAnswerImpl result = new  ConfigurationInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
	
	public NIDDInformationRequest createNIDDInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new NIDDInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier);
	}
	
	@Override
	public NIDDInformationAnswer createNIDDInformationAnswer(NIDDInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NIDDInformationAnswerImpl result = new  NIDDInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public NIDDInformationAnswer createNIDDInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NIDDInformationAnswerImpl result = new  NIDDInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
	
	public ReportingInformationRequest createReportingInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReportingInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, stack.generateNewSessionID(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
	
	@Override
	public ReportingInformationAnswer createReportingInformationAnswer(ReportingInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportingInformationAnswerImpl result = new  ReportingInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ReportingInformationAnswer createReportingInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportingInformationAnswerImpl result = new  ReportingInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
}