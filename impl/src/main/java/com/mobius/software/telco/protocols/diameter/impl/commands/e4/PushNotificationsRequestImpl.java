package com.mobius.software.telco.protocols.diameter.impl.commands.e4;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.e4.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.IPConnectivityStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.InitialGateSettingIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.e4.QoSProfileIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.e4.AccessNetworkType;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.e4.IPConnectivityStatus;
import com.mobius.software.telco.protocols.diameter.primitives.e4.IPConnectivityStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.e4.InitialGateSettingDescription;
import com.mobius.software.telco.protocols.diameter.primitives.e4.InitialGateSettingID;
import com.mobius.software.telco.protocols.diameter.primitives.e4.QoSProfileDescription;
import com.mobius.software.telco.protocols.diameter.primitives.e4.QoSProfileID;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777231, commandCode = 309, request = true)
public class PushNotificationsRequestImpl extends E4RequestImpl implements PushNotificationRequest
{
	private GloballyUniqueAddress globallyUniqueAddress;
	
	private LogicalAccessID logicalAccessID;
	
	private PhysicalAccessID physicalAccessID;
	
	private AccessNetworkType accessNetworkType;
	
	private InitialGateSettingDescription initialGateSettingDescription;
	
	private List<QoSProfileDescription> qosProfileDescription;
	
	private IPConnectivityStatus ipConnectivityStatus;
	
	private QoSProfileID qosProfileID;
	
	private InitialGateSettingID initialGateSettingID;
	
	protected PushNotificationsRequestImpl() 
	{
		super();
	}
	
	public PushNotificationsRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
	}
	
	public GloballyUniqueAddress getGloballyUniqueAddress()
	{
		return this.globallyUniqueAddress;
	}
	
	public void setGloballyUniqueAddress(GloballyUniqueAddress value)
	{
		this.globallyUniqueAddress = value;
	}
	
	@Override
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	@Override
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	@Override
	public String getPhysicalAccessID()
	{
		if(physicalAccessID==null)
			return null;
		
		return physicalAccessID.getString();
	}
	
	@Override
	public void setPhysicalAccessID(String value)
	{
		if(value==null)
			this.physicalAccessID = null;
		else
			this.physicalAccessID = new PhysicalAccessIDImpl(value, null, null);			
	}
	
	public AccessNetworkType getAccessNetworkType()
	{
		return accessNetworkType;
	}
	
	public void setAccessNetworkType(AccessNetworkType value)
	{
		this.accessNetworkType = value;
	}
	
	public InitialGateSettingDescription getInitialGateSettingDescription()
	{
		return this.initialGateSettingDescription;
	}
	 
	public void setInitialGateSettingDescription(InitialGateSettingDescription value)
	{
		this.initialGateSettingDescription = value;
	}
	
	public List<QoSProfileDescription> getQoSProfileDescription()
	{
		return this.qosProfileDescription;
	}
	 
	public void setQoSProfileDescription(List<QoSProfileDescription> value)
	{
		this.qosProfileDescription = value;
	}
	
	public IPConnectivityStatusEnum getIPConnectivityStatus()
	{
		if(ipConnectivityStatus==null)
			return null;
		
		return ipConnectivityStatus.getEnumerated(IPConnectivityStatusEnum.class);
	}
	
	public void setIPConnectivityStatus(IPConnectivityStatusEnum value)
	{
		if(value==null)
			this.ipConnectivityStatus = null;
		else
			this.ipConnectivityStatus = new IPConnectivityStatusImpl(value, null, null);
	}

	public String getQoSProfileID()
	{
		if(qosProfileID==null)
			return null;
		
		return qosProfileID.getString();
	}
	
	public void setQoSProfileID(String value)
	{
		if(value==null)
			this.qosProfileID = null;
		else
			this.qosProfileID = new QoSProfileIDImpl(value, null, null);
	}
	 		
	public String getInitialGateSettingID()
	{
		if(initialGateSettingID==null)
			return null;
		
		return initialGateSettingID.getString();
	}
	 
	public void setInitialGateSettingID(String value)
	{
		if(value==null)
			this.initialGateSettingID = null;
		else
			this.initialGateSettingID = new InitialGateSettingIDImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(globallyUniqueAddress);
		result.add(username);
		result.add(logicalAccessID);
		result.add(physicalAccessID);
		result.add(accessNetworkType);
		result.add(initialGateSettingDescription);
		
		if(qosProfileDescription!=null)
			result.addAll(qosProfileDescription);
		
		result.add(ipConnectivityStatus);
		result.add(qosProfileID);
		result.add(initialGateSettingID);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}