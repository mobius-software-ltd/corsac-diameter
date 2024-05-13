package com.mobius.software.telco.protocols.diameter.impl.app.s6c;
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
import com.mobius.software.telco.protocols.diameter.app.s6c.SessionFactory;
import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.ReportSMDeliveryStatusRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.SendRoutingInfoForSMRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.AlertServiceCentreRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.ReportSMDeliveryStatusRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.s6c.SendRoutingInfoForSMRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

public class SessionFactoryImpl implements SessionFactory
{
	public static final long APPLICATION_ID=ApplicationIDs.S6C;
	
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
	
	public AlertServiceCentreRequest createAlertServiceCentreRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String scAddress,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		AlertServiceCentreRequest request = new AlertServiceCentreRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, scAddress, userIdentifier); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}			
	
	public ReportSMDeliveryStatusRequest createReportSMDeliveryStatusRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentifier userIdentifier,String scAddress, SMDeliveryOutcome smDeliveryOutcome) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		ReportSMDeliveryStatusRequest request = new ReportSMDeliveryStatusRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, scAddress, smDeliveryOutcome); 
		request.setVendorSpecificApplicationId(appId);
		return request;
	}
	
	public SendRoutingInfoForSMRequest createSendRoutingInfoForSMRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException
	{
		VendorSpecificApplicationId appId = new VendorSpecificApplicationIdImpl(VendorIDs.TGPP_ID, applicationId, null);
		SendRoutingInfoForSMRequest request = new SendRoutingInfoForSMRequestImpl(originHost, originRealm, destinationHost, destinationRealm, false, idGenerator.generateID().toString(), AuthSessionStateEnum.NO_STATE_MAINTAINED); 
		request.setVendorSpecificApplicationId(appId);
		return request;		
	}
}