package com.mobius.software.telco.protocols.diameter.impl.app.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.app.rfc4004.MessageFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.AAMobileNodeRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.HomeAgentMIPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004.AAMobileNodeRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004.HomeAgentMIPRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class MessageFactoryImpl implements MessageFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.MOBILE_IPV4;
	
	private IDGenerator<?> idGenerator;
	
	private Long applicationId = APPLICATION_ID;
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public MessageFactoryImpl(IDGenerator<?> idGenerator, long applicationId)
	{
		this.idGenerator = idGenerator;
		this.applicationId = applicationId;
	}
	
	public AAMobileNodeRequest createAAMobileNodeRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ByteBuf mipRegRequest, MIPMNAAAAuth mipMNAAAAuth) throws MissingAvpException, AvpNotSupportedException
	{
		return new AAMobileNodeRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, mipRegRequest, mipMNAAAAuth);
	}		
	
	public HomeAgentMIPRequest createHomeAgentMIPRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,Long authorizationLifetime, AuthSessionStateEnum authSessionState,ByteBuf mipRegRequest, Long mipFeatureVector) throws MissingAvpException, AvpNotSupportedException
	{
		return new HomeAgentMIPRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), mipFeatureVector, authorizationLifetime, authSessionState, mipRegRequest, mipFeatureVector);
	}	
}