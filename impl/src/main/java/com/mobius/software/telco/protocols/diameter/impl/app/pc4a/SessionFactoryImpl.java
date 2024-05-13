package com.mobius.software.telco.protocols.diameter.impl.app.pc4a;
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
import com.mobius.software.telco.protocols.diameter.app.pc4a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeInitialLocationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeNotifyRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeSubscriberInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.ProSeInitialLocationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.ProSeNotifyRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.ProSeSubscriberInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.ResetRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.UpdateProSeSubscriberDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.PC4A;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
	}
	
	public ProSeInitialLocationInformationRequest createProSeInitialLocationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ProSeInitialLocationInformationRequest request = new ProSeInitialLocationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}		
	
	public ProSeNotifyRequest createProSeNotifyRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ProSeNotifyRequest request = new ProSeNotifyRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public ProSeSubscriberInformationRequest createProSeSubscriberInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ProSeSubscriberInformationRequest request = new ProSeSubscriberInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public ResetRequest createResetRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws AvpNotSupportedException, MissingAvpException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ResetRequest request = new ResetRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString());
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public UpdateProSeSubscriberDataRequest createUpdateProSeSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		UpdateProSeSubscriberDataRequest request = new UpdateProSeSubscriberDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
}