package com.mobius.software.telco.protocols.diameter.impl.app.slg;
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
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.slg.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.slg.LocationReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.slg.ProvideLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.slg.LocationReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.slg.ProvideLocationRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LocationEventEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SLgLocationTypeEnum;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.SLG;
	
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
	
	public ProvideLocationRequest createProvideLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,SLgLocationTypeEnum slgLocationType,LCSEPSClientName lcsEPSClientName,LCSClientTypeEnum lcsClientType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ProvideLocationRequest request = new ProvideLocationRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, slgLocationType, lcsEPSClientName, lcsClientType); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}			
	
	public LocationReportRequest createLocationReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,LocationEventEnum locationEvent) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		LocationReportRequest request = new LocationReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, locationEvent); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
}