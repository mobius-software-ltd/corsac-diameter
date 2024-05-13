package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NNIInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NNIType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NNITypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NeighbourNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelationshipMode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelationshipModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SessionDirection;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SessionDirectionEnum;

/**
*
* @author yulian oifa
*
*/
public class NNIInformationImpl extends DiameterAvpImpl implements NNIInformation
{
	private SessionDirection sessionDirection;
	private NNIType nniType;
	private RelationshipMode relationshipMode;
	private NeighbourNodeAddress neighbourNodeAddress;
		
	public NNIInformationImpl()
	{
		
	}
	
	public SessionDirectionEnum getSessionDirection()
	{
		if(sessionDirection==null)
			return null;
		
		return sessionDirection.getEnumerated(SessionDirectionEnum.class);
	}
	
	public void setSessionDirection(SessionDirectionEnum value)
	{
		if(value==null)
			this.sessionDirection = null;
		else
			this.sessionDirection = new SessionDirectionImpl(value, null, null);			
	}
	
	public NNITypeEnum getNNIType()
	{
		if(nniType==null)
			return null;
		
		return nniType.getEnumerated(NNITypeEnum.class);
	}
	
	public void setNNIType(NNITypeEnum value)
	{
		if(value==null)
			this.nniType = null;
		else
			this.nniType = new NNITypeImpl(value, null, null);			
	}
	
	public RelationshipModeEnum getRelationshipMode()
	{
		if(relationshipMode==null)
			return null;
		
		return relationshipMode.getEnumerated(RelationshipModeEnum.class);
	}
	
	public void setRelationshipMode(RelationshipModeEnum value)
	{
		if(value==null)
			this.relationshipMode = null;
		else
			this.relationshipMode = new RelationshipModeImpl(value, null, null);			
	}
	
	public InetAddress getNeighbourNodeAddress()
	{
		if(neighbourNodeAddress==null)
			return null;
		
		return neighbourNodeAddress.getAddress();
	}
	
	public void setNeighbourNodeAddress(InetAddress value)
	{
		if(value==null)
			this.neighbourNodeAddress = null;
		else
			this.neighbourNodeAddress = new NeighbourNodeAddressImpl(value, null, null);			
	}
}