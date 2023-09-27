package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NodeType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NodeTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedMonitoringEvents;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3143L, vendorId = KnownVendorIDs.TGPP_ID)
public class SupportedServicesImpl extends DiameterGroupedAvpImpl implements SupportedServices
{
	private SupportedMonitoringEvents supportedMonitoringEvents;
	
	private NodeType nodeType;
	
	public SupportedServicesImpl()
	{
		
	}
	
	public Long getSupportedMonitoringEvents()
	{
		if(supportedMonitoringEvents == null)
			return null;
		
		return supportedMonitoringEvents.getUnsigned();
	}
	
	public void setSupportedMonitoringEvents(Long value)
	{
		if(value==null)
			this.supportedMonitoringEvents = null;
		else
			this.supportedMonitoringEvents = new SupportedMonitoringEventsImpl(value, null, null);
	}
	
	public NodeTypeEnum getNodeType()
	{
		if(nodeType == null)
			return null;
		
		return nodeType.getEnumerated(NodeTypeEnum.class);
	}
	
	public void setNodeType(NodeTypeEnum value)
	{
		if(value==null)
			this.nodeType = null;
		else
			this.nodeType = new NodeTypeImpl(value, null, null);
	}
}