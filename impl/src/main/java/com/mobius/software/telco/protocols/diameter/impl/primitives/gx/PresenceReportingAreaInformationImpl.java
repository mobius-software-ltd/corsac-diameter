package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaElementsList;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaNode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2822L, vendorId = KnownVendorIDs.TGPP_ID)
public class PresenceReportingAreaInformationImpl extends DiameterGroupedAvpImpl implements PresenceReportingAreaInformation
{
	private PresenceReportingAreaIdentifier presenceReportingAreaIdentifier;
	private PresenceReportingAreaStatus presenceReportingAreaStatus;
	private PresenceReportingAreaElementsList presenceReportingAreaElementsList;
	private PresenceReportingAreaNode presenceReportingAreaNode;
		
	public PresenceReportingAreaInformationImpl()
	{
		
	}
	
	public ByteBuf getPresenceReportingAreaIdentifier()
	{
		if(presenceReportingAreaIdentifier==null)
			return null;
		
		return presenceReportingAreaIdentifier.getValue();
	}
	
	public void setPresenceReportingAreaIdentifier(ByteBuf value)
	{
		if(value==null)
			this.presenceReportingAreaIdentifier = null;
		else
			this.presenceReportingAreaIdentifier = new PresenceReportingAreaIdentifierImpl(value, null, null);			
	}
	
	public PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus()
	{
		if(presenceReportingAreaStatus==null)
			return null;
		
		return presenceReportingAreaStatus.getEnumerated(PresenceReportingAreaStatusEnum.class);
	}
	
	public void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value)
	{
		if(value==null)
			this.presenceReportingAreaStatus = null;
		else
			this.presenceReportingAreaStatus = new PresenceReportingAreaStatusImpl(value, null, null);			
	}
	
	public ByteBuf getPresenceReportingAreaElementsList()
	{
		if(presenceReportingAreaElementsList==null)
			return null;
		
		return presenceReportingAreaElementsList.getValue();
	}
	
	public void setPresenceReportingAreaElementsList(ByteBuf value)
	{
		if(value==null)
			this.presenceReportingAreaElementsList = null;
		else
			this.presenceReportingAreaElementsList = new PresenceReportingAreaElementsListImpl(value, null, null);			
	}
	
	public Long getPresenceReportingAreaNode()
	{
		if(presenceReportingAreaNode==null)
			return null;
		
		return presenceReportingAreaNode.getUnsigned();
	}
	
	public void setPresenceReportingAreaNode(Long value)
	{
		if(value==null)
			this.presenceReportingAreaNode = null;
		else
			this.presenceReportingAreaNode = new PresenceReportingAreaNodeImpl(value, null, null);			
	}
}