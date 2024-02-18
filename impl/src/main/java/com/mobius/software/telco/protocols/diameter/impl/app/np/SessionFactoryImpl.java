package com.mobius.software.telco.protocols.diameter.impl.app.np;
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

import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.app.np.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.AggregatedRUCIReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.ModifyUeContextRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.np.NonAggregatedRUCIReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777342L;
	
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
	
	public ModifyUeContextRequest createModifyUeContextRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ModifyUeContextRequest request = new ModifyUeContextRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
	
	public AggregatedRUCIReportRequest createAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		AggregatedRUCIReportRequest request = new AggregatedRUCIReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public NonAggregatedRUCIReportRequest createNonAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		NonAggregatedRUCIReportRequest request = new NonAggregatedRUCIReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED);
		request.setVendorSpecificApplicationId(appId);
		return request;
	}	
}