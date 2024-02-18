package com.mobius.software.telco.protocols.diameter.impl.app.s6t;
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

import com.mobius.software.telco.protocols.diameter.app.s6t.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6t.NIDDInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ReportingInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ConfigurationInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.NIDDInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ReportingInformationRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777345L;
	
	private IDGenerator<?> idGenerator;
	
	public SessionFactoryImpl(IDGenerator<?> idGenerator)
	{
		this.idGenerator = idGenerator;
	}
	
	public ConfigurationInformationRequest createConfigurationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new ConfigurationInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier);
	}			
	
	public NIDDInformationRequest createNIDDInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		return new NIDDInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier);
	}
	
	public ReportingInformationRequest createReportingInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException
	{
		return new ReportingInformationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
	}
}