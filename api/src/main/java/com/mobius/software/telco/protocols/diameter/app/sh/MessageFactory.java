package com.mobius.software.telco.protocols.diameter.app.sh;
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

import com.mobius.software.telco.protocols.diameter.commands.sh.ProfileUpdateAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sh.ProfileUpdateRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.PushNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sh.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.SubscribeNotificationsAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sh.SubscribeNotificationsRequest;
import com.mobius.software.telco.protocols.diameter.commands.sh.UserDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sh.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SubsReqTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

public interface MessageFactory
{
	public ProfileUpdateRequest createProfileUpdateRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, ByteBuf userData,List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;	
	
	public ProfileUpdateAnswer createProfileUpdateAnswer(ProfileUpdateRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProfileUpdateAnswer createProfileUpdateAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushNotificationRequest createPushNotificationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentity userIdentity, ByteBuf userData) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public PushNotificationAnswer createPushNotificationAnswer(PushNotificationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushNotificationAnswer createPushNotificationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public SubscribeNotificationsRequest createSubscribeNotificationsRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, SubsReqTypeEnum subsReqType, List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;			
	
	public SubscribeNotificationsAnswer createSubscribeNotificationsAnswer(SubscribeNotificationsRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public SubscribeNotificationsAnswer createSubscribeNotificationsAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UserDataRequest createUserDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentity userIdentity, List<DataReferenceEnum> dataReference) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public UserDataAnswer createUserDataAnswer(UserDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UserDataAnswer createUserDataAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
}