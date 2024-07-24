package com.mobius.software.telco.protocols.diameter.impl.app.s6c;
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
import com.mobius.software.telco.protocols.diameter.app.s6c.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.ReportSMDeliveryStatusAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6c.ReportSMDeliveryStatusRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.SendRoutingInfoForSMAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6c.SendRoutingInfoForSMRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.AlertServiceCentreAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.AlertServiceCentreRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.ReportSMDeliveryStatusAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.ReportSMDeliveryStatusRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.SendRoutingInfoForSMAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.SendRoutingInfoForSMRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.S6C;
	
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
	
	public AlertServiceCentreRequest createAlertServiceCentreRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String scAddress,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		AlertServiceCentreRequest request = new AlertServiceCentreRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, scAddress, userIdentifier); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public AlertServiceCentreAnswer createAlertServiceCentreAnswer(AlertServiceCentreRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AlertServiceCentreAnswerImpl result = new  AlertServiceCentreAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public AlertServiceCentreAnswer createAlertServiceCentreAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AlertServiceCentreAnswerImpl result = new  AlertServiceCentreAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}			
	
	public ReportSMDeliveryStatusRequest createReportSMDeliveryStatusRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,String scAddress, SMDeliveryOutcome smDeliveryOutcome) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ReportSMDeliveryStatusRequest request = new ReportSMDeliveryStatusRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, scAddress, smDeliveryOutcome); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}

	@Override
	public ReportSMDeliveryStatusAnswer createReportSMDeliveryStatusAnswer(ReportSMDeliveryStatusRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportSMDeliveryStatusAnswerImpl result = new  ReportSMDeliveryStatusAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public ReportSMDeliveryStatusAnswer createReportSMDeliveryStatusAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ReportSMDeliveryStatusAnswerImpl result = new  ReportSMDeliveryStatusAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public SendRoutingInfoForSMRequest createSendRoutingInfoForSMRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		SendRoutingInfoForSMRequest request = new SendRoutingInfoForSMRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED); 
		request.setVendorSpecificApplicationId(appId);
		return request;		
	}

	@Override
	public SendRoutingInfoForSMAnswer createSendRoutingInfoForSMAnswer(SendRoutingInfoForSMRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		SendRoutingInfoForSMAnswerImpl result = new  SendRoutingInfoForSMAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public SendRoutingInfoForSMAnswer createSendRoutingInfoForSMAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		SendRoutingInfoForSMAnswerImpl result = new  SendRoutingInfoForSMAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}