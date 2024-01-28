package com.mobius.software.telco.protocols.diameter.impl.app.t4;
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

import com.mobius.software.telco.protocols.diameter.app.t4.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeliveryReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeviceTriggerRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.t4.DeliveryReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t4.DeviceTriggerRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4Enum;

import io.netty.buffer.ByteBuf;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=16777311L;
	
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
	
	public DeliveryReportRequest createDeliveryReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf smRPSMEA,SMDeliveryOutcomeT4Enum smDeliveryOutcomeT4)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		DeliveryReportRequest request = new DeliveryReportRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, smRPSMEA, smDeliveryOutcomeT4); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}			
	
	public DeviceTriggerRequest createDeviceTriggerRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,ByteBuf smRPSMEA,ByteBuf payload)
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(KnownVendorIDs.TGPP_ID, applicationId, null);
		DeviceTriggerRequest request = new DeviceTriggerRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, smRPSMEA, payload); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
}