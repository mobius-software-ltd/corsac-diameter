package com.mobius.software.telco.protocols.diameter.impl.app.gy;
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

import com.mobius.software.telco.protocols.diameter.app.gy.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AFCorrelationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.RequestedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.ServiceInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.TGPPMultipleServicesCreditControlImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gy.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowsImpl;
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

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	
	@Override
	public SubscriptionId getSubscriptionId()
	{
		return new SubscriptionIdImpl();
	}
	
	@Override
	public TGPPMultipleServicesCreditControl getTGPPMultipleServicesCreditControl()
	{
		return new TGPPMultipleServicesCreditControlImpl();
	}
	
	@Override
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	@Override
	public RequestedServiceUnit getRequestedServiceUnit()
	{
		return new RequestedServiceUnitImpl();
	}
	
	@Override
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	
	public FinalUnitIndication getFinalUnitIndication() 
	{
		return new FinalUnitIndicationImpl();
	}
	
	public RedirectServer getRedirectServer()
	{
		return new RedirectServerImpl();
	}
	
	public UserEquipmentInfo getUserEquipmentInfo() 
	{
		return new UserEquipmentInfoImpl();
	}
	
	public ServiceInformation getServiceInformation()
	{
		return new ServiceInformationImpl();
	}
	
	public Trigger getTrigger()
	{
		return new TriggerImpl();
	}
	
	public AFCorrelationInformation getAFCorrelationInformation()
	{
		return new AFCorrelationInformationImpl();
	}
	
	public Flows getFlows()
	{
		return new FlowsImpl();
	}
	
	public QoSInformation getQoSInformation()
	{
		return new QoSInformationImpl();
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority()
	{
		return new AllocationRetentionPriorityImpl();
	}
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate()
	{
		return new ConditionalAPNAggregateMaxBitrateImpl();
	}

	
}

	

