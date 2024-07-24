package com.mobius.software.telco.protocols.diameter.app.e4;
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

import com.mobius.software.telco.protocols.diameter.commands.e4.PushNotificationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.e4.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.e4.UserDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.e4.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

public interface MessageFactory
{
	public UserDataRequest createUserDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws AvpNotSupportedException, MissingAvpException, AvpOccursTooManyTimesException;	
	
	public UserDataAnswer createUserDataAnswer(UserDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UserDataAnswer createUserDataAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushNotificationRequest createPushNotificationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushNotificationAnswer createPushNotificationAnswer(PushNotificationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public PushNotificationAnswer createPushNotificationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
}