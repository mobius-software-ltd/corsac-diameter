package com.mobius.software.telco.protocols.diameter.impl.app.swx;
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
import com.mobius.software.telco.protocols.diameter.app.swx.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.swx.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.MultimediaAuthAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.MultimediaAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.PushProfileAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.PushProfileRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.RegistrationTerminationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.RegistrationTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.ServerAssignmentAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.swx.ServerAssignmentRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SWX;
	
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
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, Long sipNumberAuthItems,SIPAuthDataItem sIPAuthDataItem) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		MultimediaAuthRequest request = new MultimediaAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username, sipNumberAuthItems, sIPAuthDataItem); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public MultimediaAuthAnswer createMultimediaAuthAnswer(MultimediaAuthRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MultimediaAuthAnswerImpl result = new MultimediaAuthAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public MultimediaAuthAnswer createMultimediaAuthAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		MultimediaAuthAnswerImpl result = new MultimediaAuthAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED,username);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, String username) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		PushProfileRequest request = new PushProfileRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public PushProfileAnswer createPushProfileAnswer(PushProfileRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PushProfileAnswerImpl result = new PushProfileAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public PushProfileAnswer createPushProfileAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		PushProfileAnswerImpl result = new PushProfileAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}		
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm, String destinationHost, String destinationRealm, String username, DeregistrationReason deregistrationReason) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		RegistrationTerminationRequest request = new RegistrationTerminationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username, deregistrationReason); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(RegistrationTerminationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		RegistrationTerminationAnswerImpl result = new  RegistrationTerminationAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public RegistrationTerminationAnswer createRegistrationTerminationAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		RegistrationTerminationAnswerImpl result = new  RegistrationTerminationAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, String username,ServerAssignmentTypeEnum serverAssignmentType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ServerAssignmentRequest request = new ServerAssignmentRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username, serverAssignmentType); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public ServerAssignmentAnswer createServerAssignmentAnswer(ServerAssignmentRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ServerAssignmentAnswerImpl result = new  ServerAssignmentAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED,username);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}
	
	@Override
	public ServerAssignmentAnswer createServerAssignmentAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,String username) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ServerAssignmentAnswerImpl result = new  ServerAssignmentAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED, username);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}