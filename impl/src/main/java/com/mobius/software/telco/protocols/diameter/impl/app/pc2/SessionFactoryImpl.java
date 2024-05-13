package com.mobius.software.telco.protocols.diameter.impl.app.pc2;
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
import com.mobius.software.telco.protocols.diameter.app.pc2.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityApplicationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityActionRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityApplicationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.PC2;
	
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
	
	public ProXimityApplicationRequest createProXimityApplicationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm, ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ProXimityApplicationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
	}		
	
	public ProXimityActionRequest createProXimityActionRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,ProSeRequestTypeEnum proSeRequestType) throws MissingAvpException, AvpNotSupportedException
	{
		return new ProXimityActionRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, AuthSessionStateEnum.NO_STATE_MAINTAINED, proSeRequestType);
	}
}