package com.mobius.software.telco.protocols.diameter.impl.app.nas;
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

import com.mobius.software.telco.protocols.diameter.app.nas.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.nas.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.nas.AARequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.nas.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=1L;
	
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
	
	public AARequest createAARequest(String originHost,String originRealm,String destinationRealm)
	{
		return new AARequestImpl(originHost, originRealm, destinationRealm, false, idGenerator.generateID().toString(), applicationId);
	}		
	
	public AccountingRequest createAccountingRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber)
	{
		return new AccountingRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), accountingRecordType, accountingRecordNumber, applicationId);
	}
}