package com.mobius.software.telco.protocols.diameter.impl.commands.swx;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerAssignmentTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentType;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

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
@DiameterCommandImplementation(applicationId = 16777265, commandCode = 301, request = true)
public class ServerAssignmentRequestImpl extends SwxRequestImpl implements ServerAssignmentRequest
{
	private ServiceSelection serviceSelection;
    
	private ContextIdentifier contextIdentifier;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	private ServerAssignmentType serverAssignmentType;
	
	private List<ActiveAPN> activeAPN;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private TerminalInformation terminalInformation;
	
	private EmergencyServices emergencyServices;
	
	protected ServerAssignmentRequestImpl() 
	{
		super();
	}
	
	public ServerAssignmentRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String userName,ServerAssignmentTypeEnum serverAssignmentType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setServerAssignmentType(serverAssignmentType);
		
		setUsername(userName);
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}

	@Override
	public String getServiceSelection() 
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}

	@Override
	public void setServiceSelection(String value) 
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}

	@Override
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	@Override
	public void setContextIdentifier(Long value)
	{
		if(value == null)
			this.contextIdentifier = null;
		else
			this.contextIdentifier = new ContextIdentifierImpl(value, null, null);
	}	
	
	@Override
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return this.mip6AgentInfo;
	}
	
	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
	}
	
	@Override
	public ByteBuf getVisitedNetworkIdentifier() 
	{
		if(visitedNetworkIdentifier==null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	@Override
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value == null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);
	}
	
	@Override
	public ServerAssignmentTypeEnum getServerAssignmentType() 
	{
		if(serverAssignmentType == null)
			return null;
		
		return serverAssignmentType.getEnumerated(ServerAssignmentTypeEnum.class);
	}

	@Override
	public void setServerAssignmentType(ServerAssignmentTypeEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Server-Assignment-Type is required");
		
		this.serverAssignmentType = new ServerAssignmentTypeImpl(value, null, null);
	}
	
	@Override
	public List<ActiveAPN> getActiveAPN()
	{
		return activeAPN;
	}
	
	@Override
	public void setActiveAPN(List<ActiveAPN> value)
	{
		this.activeAPN = value;
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
	 
	@Override
	public Long getEmergencyServices()
	{
		if(emergencyServices==null)
			return null;

		return emergencyServices.getUnsigned();
	}

	@Override
	public void setEmergencyServices(Long value)
	{
		if(value == null)
			this.emergencyServices = null;
		else
			this.emergencyServices = new EmergencyServicesImpl(value, null, null);
	}
    
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
		if(serverAssignmentType == null)
			return "Server-Assignment-Type is required";
		
		return super.validate();
	}
}