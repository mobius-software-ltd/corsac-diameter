package com.mobius.software.telco.protocols.diameter.impl.commands.t6a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ConnectionActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ExtendedPCOImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CMRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ConnectionAction;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ConnectionActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ExtendedPCO;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TerminalInformation;

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
@DiameterCommandImplementation(applicationId = 16777346, commandCode = 8388732, request = true)
public class ConnectionManagementRequestImpl extends T6aRequestImpl implements ConnectionManagementRequest
{
	private UserIdentifier userIdentifier;
	
	private BearerIdentifier bearerIdentifier;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private CMRFlags cmrFlags;
	
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	
	private ConnectionAction connectionAction;
	
	private ServiceSelection serviceSelection;
	
	private ServingPLMNRateControl servingPLMNRateControl;
	
	private ExtendedPCO extendedPCO;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private RATType ratType;
	
	private TerminalInformation terminalInformation;
	
	private VisitedPLMNId visitedPLMNId;
	
	private APNRateControlStatus apnRateControlStatus;
	
	protected ConnectionManagementRequestImpl() 
	{
		super();
	}
	
	public ConnectionManagementRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,ByteBuf bearerIdentifier)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setBearerIdentifier(bearerIdentifier);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
		this.userIdentifier = value;
	}		
	
	@Override
	public ByteBuf getBearerIdentifier()
	{
		if(bearerIdentifier == null)
			return null;
		
		return bearerIdentifier.getValue();
	}
	
	@Override
	public void setBearerIdentifier(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Bearer-Identifier is required");
		
		this.bearerIdentifier = new BearerIdentifierImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public CMRFlags getCMRFlags()
	{
		return cmrFlags;
	}
	
	@Override
	public void setCMRFlags(CMRFlags value)
	{
		this.cmrFlags = value;
	}	
	
	@Override
	public Date getMaximumUEAvailabilityTime()
	{
		if(this.maximumUEAvailabilityTime==null)
			return null;
		
		return this.maximumUEAvailabilityTime.getDateTime();
	}
	
	@Override
	public void setMaximumUEAvailabilityTime(Date value)
	{
		if(value==null)
			this.maximumUEAvailabilityTime = null;
		else
			this.maximumUEAvailabilityTime = new MaximumUEAvailabilityTimeImpl(value, null, null);
	}
	
	@Override
	public ConnectionActionEnum getConnectionAction()
	{
		if(connectionAction == null)
			return null;
		
		return connectionAction.getEnumerated(ConnectionActionEnum.class);
	}
	
	@Override
	public void setConnectionAction(ConnectionActionEnum value)
	{
		if(value==null)
			this.connectionAction = null;
		else
			this.connectionAction = new ConnectionActionImpl(value, null, null);
	}
	
	@Override
	public String getServiceSelection()
	{
		if(this.serviceSelection==null)
			return null;
		
		return this.serviceSelection.getString();
	}
	
	@Override
	public void setServiceSelection(String value)
	{
		if(value==null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@Override
	public ServingPLMNRateControl getServingPLMNRateControl()
	{
		return this.servingPLMNRateControl;
	}
	
	@Override
	public void setServingPLMNRateControl(ServingPLMNRateControl value)
	{
		this.servingPLMNRateControl = value;
	}
	
	@Override
	public ByteBuf getExtendedPCO()
	{
		if(this.extendedPCO==null)
			return null;
		
		return this.extendedPCO.getValue();
	}
	
	@Override
	public void setExtendedPCO(ByteBuf value)
	{
		if(value==null)
			this.extendedPCO = null;
		else
			this.extendedPCO = new ExtendedPCOImpl(value, null, null);
	}
	
	@Override
	public String getTGPPChargingCharacteristics()
	{
		if(this.tgppChargingCharacteristics==null)
			return null;
		
		return this.tgppChargingCharacteristics.getString();
	}
	
	@Override
	public void setTGPPChargingCharacteristics(String value)
	{
		if(value==null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType == null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);
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
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	@Override
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value==null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}
	
	@Override
	public APNRateControlStatus getAPNRateControlStatus()
	{
		return this.apnRateControlStatus;
	}
	
	@Override
	public void setAPNRateControlStatus(APNRateControlStatus value)
	{
		this.apnRateControlStatus = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(bearerIdentifier == null)
			return "Bearer-Identifier is required";
		
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		return super.validate();
	}		
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(userIdentifier);
		result.add(bearerIdentifier);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(ocSupportedFeatures);
		
		result.add(cmrFlags);
		result.add(maximumUEAvailabilityTime);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(connectionAction);
		result.add(serviceSelection);
		result.add(servingPLMNRateControl);
		result.add(extendedPCO);
		result.add(tgppChargingCharacteristics);
		result.add(ratType);
		result.add(terminalInformation);
		result.add(visitedPLMNId);
		result.add(apnRateControlStatus);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}