package com.mobius.software.telco.protocols.diameter.app.rfc4004;
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

import com.mobius.software.telco.protocols.diameter.commands.rfc4004.AAMobileNodeAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.AAMobileNodeRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;

import io.netty.buffer.ByteBuf;

public interface MessageFactory
{
	public AAMobileNodeRequest createAAMobileNodeRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ByteBuf mipRegRequest, MIPMNAAAAuth mipMNAAAAuth) throws MissingAvpException, AvpNotSupportedException;
	
	public AAMobileNodeAnswer createAAMobileNodeAnswer(AAMobileNodeRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws MissingAvpException, AvpNotSupportedException;
	
	public AAMobileNodeAnswer createAAMobileNodeAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId ) throws MissingAvpException, AvpNotSupportedException;

	public HomeAgentMIPRequest createHomeAgentMIPRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,Long authorizationLifetime, AuthSessionStateEnum authSessionState,ByteBuf mipRegRequest, Long mipFeatureVector) throws MissingAvpException, AvpNotSupportedException;
	
	public HomeAgentMIPAnswer createHomeAgentMIPAnswer(HomeAgentMIPRequest request, Long hopByHopIdentifier, Long endToEndIdentifier, Long resultCode,Long authApplicationId) throws MissingAvpException, AvpNotSupportedException;
	
	public HomeAgentMIPAnswer createHomeAgentMIPAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID, Long authApplicationId) throws MissingAvpException, AvpNotSupportedException;

}