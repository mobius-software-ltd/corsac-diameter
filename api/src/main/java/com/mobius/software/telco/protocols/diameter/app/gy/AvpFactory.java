package com.mobius.software.telco.protocols.diameter.app.gy;
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


import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AFCorrelationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Trigger;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gy.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gy.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.gy.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.gy.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gy.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.gy.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SubscriptionId getSubscriptionId();
	
	public TGPPMultipleServicesCreditControl getTGPPMultipleServicesCreditControl();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public RequestedServiceUnit getRequestedServiceUnit();
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public FinalUnitIndication getFinalUnitIndication();
	
	public RedirectServer getRedirectServer();
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	public ServiceInformation getServiceInformation();
	
	public Trigger getTrigger();
	
	public AFCorrelationInformation getAFCorrelationInformation(ByteBuf afChargingIdentifier) throws MissingAvpException;
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException;
	
	public QoSInformation getQoSInformation();
	
	public AllocationRetentionPriority getAllocationRetentionPriority();
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
}
