package com.mobius.software.telco.protocols.diameter.commands.rfc4004;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public interface Rfc4004Request extends AuthenticationRequest
{
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value) throws MissingAvpException;	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;
	
	ByteBuf getMIPRegRequest();
	
	void setMIPRegRequest(ByteBuf value) throws MissingAvpException;
	
	public Long getMIPFeatureVector();
	
	void setMIPFeatureVector(Long value) throws MissingAvpException;
	
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA();
	
	void setMIPOriginatingForeignAAA(MIPOriginatingForeignAAA value);	
	
	public InetAddress getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(InetAddress value);
	
	public InetAddress getMIPHomeAgentAddress();
	
	void setMIPHomeAgentAddress(InetAddress value);		
}