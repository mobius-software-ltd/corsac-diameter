package com.mobius.software.telco.protocols.diameter.impl.app.s6a;
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
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.s6a.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6a.AuthenticationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.AuthenticationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.CancelLocationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.CancelLocationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.DeleteSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.DeleteSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.InsertSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.InsertSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.NotifyAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.NotifyRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.PurgeUEAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.PurgeUERequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.ResetAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6a.UpdateLocationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6a.UpdateLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.AuthenticationInformationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.AuthenticationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.CancelLocationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.CancelLocationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.DeleteSubscriberDataAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.DeleteSubscriberDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.InsertSubscriberDataAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.InsertSubscriberDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.NotifyAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.NotifyRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.PurgeUEAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.PurgeUERequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.ResetAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.ResetRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.UpdateLocationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6a.UpdateLocationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULRFlags;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.S6A;
	
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
	
	public AuthenticationInformationRequest createAuthenticationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ByteBuf visitedPLMNId) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		AuthenticationInformationRequest request = new AuthenticationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, visitedPLMNId);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public AuthenticationInformationAnswer createAuthenticationInformationAnswer(AuthenticationInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AuthenticationInformationAnswerImpl result = new  AuthenticationInformationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public AuthenticationInformationAnswer createAuthenticationInformationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AuthenticationInformationAnswerImpl result = new  AuthenticationInformationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
	
	public CancelLocationRequest createCancelLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,CancellationTypeEnum cancellationType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		CancelLocationRequest request = new CancelLocationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, cancellationType); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public CancelLocationAnswer createCancelLocationAnswer(CancelLocationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		CancelLocationAnswerImpl result = new  CancelLocationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public CancelLocationAnswer createCancelLocationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		CancelLocationAnswerImpl result = new  CancelLocationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public DeleteSubscriberDataRequest createDeleteSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,DSRFlags dsrFlags) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		DeleteSubscriberDataRequest request = new DeleteSubscriberDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, dsrFlags); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public DeleteSubscriberDataAnswer createDeleteSubscriberDataAnswer(DeleteSubscriberDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeleteSubscriberDataAnswerImpl result = new  DeleteSubscriberDataAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public DeleteSubscriberDataAnswer createDeleteSubscriberDataAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		DeleteSubscriberDataAnswerImpl result = new  DeleteSubscriberDataAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public InsertSubscriberDataRequest createInsertSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,SubscriptionData subscriptionData) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		InsertSubscriberDataRequest request = new InsertSubscriberDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, subscriptionData);
		request.setVendorSpecificApplicationId(appId);
		return request; 
	}
	
	@Override
	public InsertSubscriberDataAnswer createInsertSubscriberDataAnswer(InsertSubscriberDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		InsertSubscriberDataAnswerImpl result = new  InsertSubscriberDataAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public InsertSubscriberDataAnswer createInsertSubscriberDataAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		InsertSubscriberDataAnswerImpl result = new  InsertSubscriberDataAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public NotifyRequest createNotifyRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		NotifyRequest request = new NotifyRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED); 
		request.setVendorSpecificApplicationId(appId);
		return request; 
	}
	
	@Override
	public NotifyAnswer createNotifyAnswer(NotifyRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NotifyAnswerImpl result = new  NotifyAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public NotifyAnswer createNotifyAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NotifyAnswerImpl result = new  NotifyAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public PurgeUERequest createPurgeUERequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		PurgeUERequest request = new PurgeUERequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public PurgeUEAnswer createPurgeUEAnswer(PurgeUERequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PurgeUEAnswerImpl result = new  PurgeUEAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public PurgeUEAnswer createPurgeUEAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PurgeUEAnswerImpl result = new  PurgeUEAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public ResetRequest createResetRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ResetRequest request = new ResetRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public ResetAnswer createResetAnswer(ResetRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ResetAnswerImpl result = new  ResetAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public ResetAnswer createResetAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ResetAnswerImpl result = new  ResetAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public UpdateLocationRequest createUpdateLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,RATTypeEnum ratType,ULRFlags ulrFlags,ByteBuf visitedPLMNId) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		UpdateLocationRequest request = new UpdateLocationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, ratType, ulrFlags, visitedPLMNId); 
		request.setVendorSpecificApplicationId(appId);
		return request; 
	}
	
	@Override
	public UpdateLocationAnswer createUpdateLocationAnswer(UpdateLocationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		UpdateLocationAnswerImpl result = new  UpdateLocationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public UpdateLocationAnswer createUpdateLocationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		UpdateLocationAnswerImpl result = new  UpdateLocationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}