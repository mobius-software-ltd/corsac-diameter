package com.mobius.software.telco.protocols.diameter.impl.app.rfc5778;
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
import java.util.List;

import org.restcomm.cluster.IDGenerator;

import com.mobius.software.telco.protocols.diameter.app.rfc5778.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.EAPRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778.MIP6Request;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778.EAPRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778.MIP6RequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;

import io.netty.buffer.ByteBuf;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=8L;
	
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
	
	public MIP6Request createMIP6Request(String originHost,String originRealm,String destinationRealm,AuthRequestTypeEnum authRequestType,List<InetAddress> mipMobileNodeAddress,MIP6AgentInfo mip6AgentInfo,InetAddress mipCareofAddress) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		return new MIP6RequestImpl(originHost, originRealm, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authRequestType, mipMobileNodeAddress, mip6AgentInfo, mipCareofAddress);
	}		
	
	public EAPRequest createEAPRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException
	{
		return new EAPRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authRequestType, eapPayload);
	}
}