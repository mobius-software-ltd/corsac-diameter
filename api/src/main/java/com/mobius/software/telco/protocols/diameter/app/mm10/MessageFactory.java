package com.mobius.software.telco.protocols.diameter.app.mm10;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.OriginatingInterfaceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.TriggerEventEnum;

public interface MessageFactory
{
	public MessageProcessRequest createMessageProcessRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,Date eventTimestamp, TriggerEventEnum triggerEvent, ServedUserIdentity servedUserIdentity,List<InitialRecipientAddress> initialRecipientAddress,OriginatingInterfaceEnum originatingInterface) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public MessageProcessAnswer createMessageProcessAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException;

	public MessageProcessAnswer createMessageProcessAnswer(MessageProcessRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws MissingAvpException, AvpNotSupportedException;
}