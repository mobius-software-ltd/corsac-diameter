package com.mobius.software.telco.protocols.diameter.impl.app.cip;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.cip.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.AbortSessionAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.AbortSessionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.ChargingInterrogationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.ChargingInterrogationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.ReAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.ReAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.SessionTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cip.SessionTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.CIP;
	
	private DiameterStack stack;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(DiameterStack stack)
	{
		this.stack = stack;
	}
	
	public MessageFactoryImpl(DiameterStack stack, long applicationId)
	{
		this.stack = stack;
		this.applicationId = applicationId;
	}
	
	public ChargingInterrogationRequest createChargingInterrogationRequest(String originHost,String originRealm, String destinationRealm, String chargingContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber,List<SubscriptionId> subscriptionId) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ChargingInterrogationRequest result = new ChargingInterrogationRequestImpl(originHost, originRealm, destinationRealm, false, stack.generateNewSessionID(),chargingContextId, ccRequestType, ccRequestNumber, subscriptionId);
		result.setVendorSpecificApplicationId(appId);
		return result;
	}
	
	@Override
	public ChargingInterrogationAnswer createChargingInterrogationAnswer(ChargingInterrogationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		ChargingInterrogationAnswerImpl result = new ChargingInterrogationAnswerImpl(request.getDestinationHost(),request.getDestinationRealm(),false, resultCode, request.getSessionId(), request.getCcRequestType(), request.getCcRequestNumber());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public ChargingInterrogationAnswer createChargingInterrogationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		ChargingInterrogationAnswerImpl result = new ChargingInterrogationAnswerImpl(originHost,originRealm,false, resultCode, sessionID, ccRequestType, ccRequestNumber);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	@Override
	public ReAuthRequest createReAuthRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId, reAuthRequestType);
	}

	@Override
	public ReAuthRequest createReAuthRequest(ChargingInterrogationRequest initialRequest, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReAuthRequestImpl(initialRequest.getDestinationHost(), initialRequest.getDestinationRealm(), initialRequest.getOriginHost(), initialRequest.getOriginRealm(), false, initialRequest.getSessionId(), applicationId, reAuthRequestType);
	}

	@Override
	public ReAuthAnswer createReAuthAnswer(ReAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswerImpl result = new ReAuthAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public ReAuthAnswer createReAuthAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		ReAuthAnswerImpl result = new ReAuthAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	@Override
	public AbortSessionRequest createAbortSessionRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId);
	}

	@Override
	public AbortSessionRequest createAbortSessionRequest(ChargingInterrogationRequest request) throws MissingAvpException, AvpNotSupportedException
	{
		return new AbortSessionRequestImpl(request.getDestinationHost(), request.getDestinationRealm(), request.getOriginHost(), request.getOriginRealm(), false, request.getSessionId(), applicationId);
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(AbortSessionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswerImpl result = new AbortSessionAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public AbortSessionAnswer createAbortSessionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		AbortSessionAnswerImpl result = new AbortSessionAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationRequest createSessionTerminationRequest(String originHost, String originRealm, String destinationHost, String destinationRealm, String sessionID, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, sessionID, applicationId, terminationCause);
	}

	@Override
	public SessionTerminationRequest creatSessionTerminationRequest(ChargingInterrogationRequest request, TerminationCauseEnum terminationCause) throws MissingAvpException, AvpNotSupportedException
	{
		return  new SessionTerminationRequestImpl(request.getOriginHost(), request.getOriginRealm(), request.getDestinationHost(), request.getDestinationRealm(), false, request.getSessionId(), applicationId, terminationCause);
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(SessionTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswer result = new SessionTerminationAnswerImpl(request.getOriginHost(), request.getOriginRealm(), false, resultCode, request.getSessionId());
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}

	@Override
	public SessionTerminationAnswer createSessionTerminationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		SessionTerminationAnswer result = new SessionTerminationAnswerImpl(originHost, originRealm, false, resultCode, sessionID);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}