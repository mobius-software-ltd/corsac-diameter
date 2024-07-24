package com.mobius.software.telco.protocols.diameter.app.sgd;
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

import com.mobius.software.telco.protocols.diameter.commands.sgd.MOForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MOForwardShortMessageRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MTForwardShortMessageAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgd.MTForwardShortMessageRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

public interface MessageFactory
{
	public MOForwardShortMessageRequest createMOForwardShortMessageRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, UserIdentifier userIdentifier, ByteBuf smRPUI) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public MOForwardShortMessageAnswer createMOForwardShortMessageAnswer(MOForwardShortMessageRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MOForwardShortMessageAnswer createMOForwardShortMessageAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MTForwardShortMessageRequest createMTForwardShortMessageRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String scAddress,ByteBuf smRPUI) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public MTForwardShortMessageAnswer createMTForwardShortMessageAnswer(MTForwardShortMessageRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public MTForwardShortMessageAnswer createMTForwardShortMessageAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;		
}