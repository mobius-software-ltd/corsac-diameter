package com.mobius.software.telco.protocols.diameter.impl.commands.s15;

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
import java.util.ArrayList;
import java.util.List;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.HeNBLocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s15.CSServiceQoSRequestOperationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.HeNBLocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestOperation;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestOperationEnum;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;

public class CreditControlRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlRequestImpl implements CreditControlRequest
{

	private DRMP drmp;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<CSServiceQoSRequestIdentifier> csServiceQoSRequestIdentifier;
	
	private CSServiceQoSRequestOperation csServiceQoSRequestOperation;
	
	private HeNBLocalIPAddress heNBLocalIPAddress;
	
	private QoSInformation qosInformation;
	
	private UDPSourcePort udpSourcePort;
	
	protected CreditControlRequestImpl() 
	{
		super();
		
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
	}
	

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	
	@Override
	public List<CSServiceQoSRequestIdentifier> getCSServiceQoSRequestIdentifier()
	{
		return this.csServiceQoSRequestIdentifier;
	}
	 
	@Override
	public void setCSServiceQoSRequestIdentifier(List<CSServiceQoSRequestIdentifier> value)
	{
		this.csServiceQoSRequestIdentifier = value;
	}
	
	@Override
	public CSServiceQoSRequestOperationEnum getCSServiceQoSRequestOperation() 
	{
		if(csServiceQoSRequestOperation==null)
			return null;
		
		return csServiceQoSRequestOperation.getEnumerated(CSServiceQoSRequestOperationEnum.class);
	}

	@Override
	public void setCSServiceQoSRequestOperation(CSServiceQoSRequestOperationEnum value) 
	{
		if(value==null)
			this.csServiceQoSRequestOperation = null;
		else
			this.csServiceQoSRequestOperation = new CSServiceQoSRequestOperationImpl(value, null, null);
	}
	
	@Override
	public InetAddress getHeNBLocalIPAddress()
	{
		if(heNBLocalIPAddress==null)
			return null;
		
		return heNBLocalIPAddress.getAddress();
	}
	
	@Override
	public void setHeNBLocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.heNBLocalIPAddress = null;
		else
			this.heNBLocalIPAddress = new HeNBLocalIPAddressImpl(value, null, null);			
	}
	
	@Override
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}

	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return udpSourcePort.getUnsigned();
	}
	
	@Override
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);			
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(ocSupportedFeatures);
		
		if(csServiceQoSRequestIdentifier!=null)
			result.addAll(csServiceQoSRequestIdentifier);
		
		result.add(csServiceQoSRequestOperation);
		result.add(destinationHost);
		result.add(heNBLocalIPAddress);
		result.add(originStateId);
		result.add(qosInformation);
		result.add(udpSourcePort);
		
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


