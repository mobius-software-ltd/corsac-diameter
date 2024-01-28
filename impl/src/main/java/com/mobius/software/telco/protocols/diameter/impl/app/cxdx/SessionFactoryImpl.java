package com.mobius.software.telco.protocols.diameter.impl.app.cxdx;
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

import com.mobius.software.telco.protocols.diameter.app.cxdx.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.LocationInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.MultimediaAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.LocationInfoRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.MultimediaAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.PushProfileRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.RegistrationTerminationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.ServerAssignmentRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.UserAuthorizationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserDataAlreadyAvailableEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777216L;
	
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
	
	public LocationInfoRequest createLocationInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String publicIdentity)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		LocationInfoRequest request = new LocationInfoRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, publicIdentity);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public MultimediaAuthRequest createMultimediaAuthRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, String publicIdentity,Long sipNumberAuthItems,SIPAuthDataItem sIPAuthDataItem, String serverName)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		MultimediaAuthRequest request = new MultimediaAuthRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username, publicIdentity, sipNumberAuthItems, sIPAuthDataItem, serverName);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public PushProfileRequest createPushProfileRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		PushProfileRequest request = new PushProfileRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}			
	
	public RegistrationTerminationRequest createRegistrationTerminationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String username, DeregistrationReason deregistrationReason)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		RegistrationTerminationRequest request = new RegistrationTerminationRequestImpl(originHost, originRealm, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, username, deregistrationReason);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public ServerAssignmentRequest createServerAssignmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String serverName, ServerAssignmentTypeEnum serverAssignmentType,UserDataAlreadyAvailableEnum userDataAlreadyAvailable)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		ServerAssignmentRequest request = new ServerAssignmentRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, serverName, serverAssignmentType, userDataAlreadyAvailable);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public UserAuthorizationRequest createUserAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		UserAuthorizationRequest request = new UserAuthorizationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
}