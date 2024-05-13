package com.mobius.software.telco.protocols.diameter.impl.app.sh;
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

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.sh.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.sh.ProfileUpdateRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.SubscribeNotificationsRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.sh.ProfileUpdateRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sh.PushNotificationsRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sh.SubscribeNotificationsRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.sh.UserDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SH;
	
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
	
	public ProfileUpdateRequest createProfileUpdateRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, ByteBuf userData,List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ProfileUpdateRequest request = new ProfileUpdateRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentity, userData, dataReference); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
	
	public PushNotificationRequest createPushNotificationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, ByteBuf userData) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		PushNotificationRequest request = new PushNotificationsRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentity, userData); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public SubscribeNotificationsRequest createSubscribeNotificationsRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		SubscribeNotificationsRequest request = new SubscribeNotificationsRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentity, dataReference); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}			
	
	public UserDataRequest createRegistrationUserDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		UserDataRequest request = new UserDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentity, dataReference);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
}