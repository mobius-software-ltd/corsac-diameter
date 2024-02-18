package com.mobius.software.telco.protocols.diameter.impl.app.t6a;
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

import com.mobius.software.telco.protocols.diameter.app.t6a.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MODataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.MTDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ReportingInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConfigurationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConnectionManagementRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MODataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.MTDataRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ReportingInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777346L;
	
	private IDGenerator<?> idGenerator;
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public ConfigurationInformationRequest createConfigurationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConfigurationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}			
	
	public ConnectionManagementRequest createConnectionManagementRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConnectionManagementRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	public MODataRequest createMODataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new MODataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	public MTDataRequest createMTDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf bearerIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new MTDataRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, bearerIdentifier);
	}
	
	public ReportingInformationRequest createReportingInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReportingInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
}