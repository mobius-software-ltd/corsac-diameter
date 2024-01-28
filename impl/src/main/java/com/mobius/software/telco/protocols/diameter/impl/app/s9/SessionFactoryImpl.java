package com.mobius.software.telco.protocols.diameter.impl.app.s9;
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

import com.mobius.software.telco.protocols.diameter.app.s9.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.s9.CreditControlRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s9.TriggerEstablishmentRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777267L;
	
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
	
	public CreditControlRequest createCreditControlRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		return new CreditControlRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, ccRequestType, ccRequestNumber);
	}	
	
	public TriggerEstablishmentRequest createTriggerEstablishmentRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState)
	{
		return new TriggerEstablishmentRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), applicationId, authSessionState);
	}
}