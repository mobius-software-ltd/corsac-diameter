package com.mobius.software.telco.protocols.diameter.impl.commands.sgmb;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSGGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSStartStopIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSUserDataModeIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSGWUDPPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.RestartCounterImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSGGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWUDPPort;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.RestartCounter;

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
public class ReAuthAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthAnswerImpl implements ReAuthAnswer
{
	private MBMSStartStopIndication mbmsStartStopIndication;
	
	private MBMSGGSNAddress mbmsGGSNAddress;	
	
	private MBMSGGSNIPv6Address mbmsGGSNIPv6Address;	
	
	private MBMSUserDataModeIndication mbmsUserDataModeIndication;	
	
	private MBMSGWUDPPort mbmsGWUDPPort;	
	
	private List<SupportedFeatures> supportedFeatures;
	
	private RestartCounter restartCounter;
	
	protected ReAuthAnswerImpl() 
	{
	}
	
	public ReAuthAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
	}
	
	@Override
	public MBMSStartStopIndicationEnum getMBMSStartStopIndication() 
	{
		if(mbmsStartStopIndication==null)
			return null;
		
		return mbmsStartStopIndication.getEnumerated(MBMSStartStopIndicationEnum.class);
	}	
	
	@Override
	public void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value) 
	{
		if(value == null)
			this.mbmsStartStopIndication = null;
		else
			this.mbmsStartStopIndication = new MBMSStartStopIndicationImpl(value, null, null);
	}
	
	@Override
	public Inet4Address getMBMSGGSNAddress()
	{
		if(mbmsGGSNAddress==null)
			return null;
		
		return mbmsGGSNAddress.getAddress();
	}	
	
	@Override
	public void setMBMSGGSNAddress(Inet4Address value) 
	{
		if(value == null)
			this.mbmsGGSNAddress = null;
		else
			this.mbmsGGSNAddress = new MBMSGGSNAddressImpl(value);
	}
	
	@Override
	public Inet6Address getMBMSGGSNIPv6Address()
	{
		if(mbmsGGSNIPv6Address==null)
			return null;
		
		return mbmsGGSNIPv6Address.getAddress();
	}	
	
	@Override
	public void setMBMSGGSNIPv6Address(Inet6Address value) 
	{
		if(value == null)
			this.mbmsGGSNIPv6Address = null;
		else
			this.mbmsGGSNIPv6Address = new MBMSGGSNIPv6AddressImpl(value);
	}
	
	@Override
	public MBMSUserDataModeIndicationEnum getMBMSUserDataModeIndication()
	{
		if(mbmsUserDataModeIndication==null)
			return null;
		
		return mbmsUserDataModeIndication.getEnumerated(MBMSUserDataModeIndicationEnum.class);
	}	
	
	@Override
	public void setMBMSUserDataModeIndication(MBMSUserDataModeIndicationEnum value) 
	{
		if(value == null)
			this.mbmsUserDataModeIndication = null;
		else
			this.mbmsUserDataModeIndication = new MBMSUserDataModeIndicationImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSGWUDPPort()
	{
		if(mbmsGWUDPPort==null)
			return null;
		
		return mbmsGWUDPPort.getValue();
	}	
	
	@Override
	public void setMBMSGWUDPPort(ByteBuf value) 
	{
		if(value == null)
			this.mbmsGWUDPPort = null;
		else
			this.mbmsGWUDPPort = new MBMSGWUDPPortImpl(value, null, null);
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures() 
	{
		return supportedFeatures;
	}

	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value) 
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public Long getRestartCounter()
	{
		if(restartCounter==null)
			return null;
		
		return restartCounter.getUnsigned();
	}
	
	@Override
	public void setRestartCounter(Long value)
	{
		if(value==null)
			this.restartCounter = null;
		else
			this.restartCounter = new RestartCounterImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(mbmsStartStopIndication);
		result.add(mbmsGGSNAddress);
		result.add(mbmsGGSNIPv6Address);
		result.add(mbmsUserDataModeIndication);
		result.add(mbmsGWUDPPort);
		result.add(originStateId);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(restartCounter);
		
		return result;
	}
}