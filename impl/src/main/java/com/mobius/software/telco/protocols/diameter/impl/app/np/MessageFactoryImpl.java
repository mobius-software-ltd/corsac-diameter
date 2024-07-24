package com.mobius.software.telco.protocols.diameter.impl.app.np;
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
import com.mobius.software.telco.protocols.diameter.app.np.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.AggregatedRUCIReportAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.AggregatedRUCIReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.ModifyUeContextAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.ModifyUeContextRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.NonAggregatedRUCIReportAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.NonAggregatedRUCIReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.NP;
	
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
	
	public ModifyUeContextRequest createModifyUeContextRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ModifyUeContextRequest request = new ModifyUeContextRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
	
	@Override
	public ModifyUeContextAnswer createModifyUeContextAnswer(ModifyUeContextRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ModifyUeContextAnswerImpl result = new  ModifyUeContextAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public ModifyUeContextAnswer createModifyUeContextAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		ModifyUeContextAnswerImpl result = new  ModifyUeContextAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public AggregatedRUCIReportRequest createAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		AggregatedRUCIReportRequest request = new AggregatedRUCIReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public AggregatedRUCIReportAnswer createAggregatedRUCIReportAnswer(AggregatedRUCIReportRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AggregatedRUCIReportAnswerImpl result = new  AggregatedRUCIReportAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public AggregatedRUCIReportAnswer createAggregatedRUCIReportAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		AggregatedRUCIReportAnswerImpl result = new  AggregatedRUCIReportAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
	
	public NonAggregatedRUCIReportRequest createNonAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		NonAggregatedRUCIReportRequest request = new NonAggregatedRUCIReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	@Override
	public NonAggregatedRUCIReportAnswer createNonAggregatedRUCIReportAnswer(NonAggregatedRUCIReportRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NonAggregatedRUCIReportAnswerImpl result = new  NonAggregatedRUCIReportAnswerImpl(request.getDestinationHost(), request.getDestinationRealm(), false, resultCode, request.getSessionId(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		result.setVendorSpecificApplicationId(request.getVendorSpecificApplicationId());
		return result;
	}

	@Override
	public NonAggregatedRUCIReportAnswer createNonAggregatedRUCIReportAnswer(String originHost, String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException
	{
		NonAggregatedRUCIReportAnswerImpl result = new  NonAggregatedRUCIReportAnswerImpl(originHost, originRealm, false, resultCode,  sessionID, AuthSessionStateEnum.NO_STATE_MAINTAINED);
		result.setHopByHopIdentifier(hopByHopIdentifier);
		result.setEndToEndIdentifier(endToEndIdentifier);
		return result;
	}
}