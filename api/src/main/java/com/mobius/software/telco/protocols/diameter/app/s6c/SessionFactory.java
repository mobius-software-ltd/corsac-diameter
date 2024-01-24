package com.mobius.software.telco.protocols.diameter.app.s6c;
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

import com.mobius.software.telco.protocols.diameter.commands.s6c.AlertServiceCentreRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.ReportSMDeliveryStatusRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6c.SendRoutingInfoForSMRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

public interface SessionFactory
{
	public AlertServiceCentreRequest createAlertServiceCentreRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,String scAddress,UserIdentifier userIdentifier);			
	
	public ReportSMDeliveryStatusRequest createReportSMDeliveryStatusRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,String scAddress, SMDeliveryOutcome smDeliveryOutcome);
	
	public SendRoutingInfoForSMRequest createSendRoutingInfoForSMRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,AuthSessionStateEnum authSessionState);
}