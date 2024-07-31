package com.mobius.software.telco.protocols.diameter.app.pc2;
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

import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;

public interface MessageFactory
{
	public ProXimityApplicationRequest createProXimityApplicationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;	
	
	public ProXimityApplicationAnswer createProXimityApplicationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;

	public ProXimityApplicationAnswer createProXimityApplicationAnswer(ProXimityApplicationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;

	public ProXimityActionRequest createProXimityActionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;
	
	public ProXimityActionAnswer createProXimityActionAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode, String sessionID,  Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;

	public ProXimityActionAnswer createProXimityActionAnswer(ProXimityActionRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, Long authApplicationId, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException;
}