package com.mobius.software.telco.protocols.diameter.impl.commands.t6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConnectionManagementAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDNConnectionChargingIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ExtendedPCOImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDNConnectionChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ExtendedPCO;

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
public class ConnectionManagementAnswerImpl extends T6aAnswerImpl implements ConnectionManagementAnswer
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private PDNConnectionChargingID pdnConnectionChargingID;
	
	private ExtendedPCO extendedPCO;
	
	private APNRateControlStatus apnRateControlStatus;
	
	protected ConnectionManagementAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ConnectionManagementAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@Override
	public Long getPDNConnectionChargingID() 
	{
		if(pdnConnectionChargingID==null)
			return null;
		
		return pdnConnectionChargingID.getUnsigned();
	}
	
	@Override
	public void setPDNConnectionChargingID(Long value)
	{	
		if(value==null)
			this.pdnConnectionChargingID = null;
		else
			this.pdnConnectionChargingID = new PDNConnectionChargingIDImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getExtendedPCO()
	{
		if(extendedPCO == null)
			return null;
		
		return extendedPCO.getValue();
	}
	
	@Override
	public void setExtendedPCO(ByteBuf value)
	{
		if(value == null)
			this.extendedPCO = null;
		else
			this.extendedPCO = new ExtendedPCOImpl(value, null, null);	
	}
	
	@Override
	public APNRateControlStatus getAPNRateControlStatus() 
	{
		return apnRateControlStatus;
	}
	
	@Override
	public void setAPNRateControlStatus(APNRateControlStatus value)
	{
		this.apnRateControlStatus = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(pdnConnectionChargingID);
		result.add(extendedPCO);
		result.add(apnRateControlStatus);
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}