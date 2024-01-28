package com.mobius.software.telco.protocols.diameter.impl.commands.st;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.st.TDFSessionRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.st.RequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.st.RequestType;
import com.mobius.software.telco.protocols.diameter.primitives.st.RequestTypeEnum;

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
@DiameterCommandImplementation(applicationId = 16777349, commandCode = 8388637, request = true)
public class TDFSessionRequestImpl extends StRequestImpl implements TDFSessionRequest
{
	private RequestType requestType;
	
	private EventReportIndication eventReportIndication;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private CalledStationId calledStationId;
	
	private List<ADCRuleInstall> adcRuleInstall;
	
	private List<ADCRuleRemove> adcRuleRemove;
	
	private List<SupportedFeatures> supportedFeatures;
	
	protected TDFSessionRequestImpl() 
	{
		super();
	}
	
	public TDFSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID);
	}
	
	@Override
	public RequestTypeEnum getRequestType()
	{
		if(requestType==null)
			return null;
		
		return this.requestType.getEnumerated(RequestTypeEnum.class);
	}
	
	@Override
	public void setRequestType(RequestTypeEnum value)
	{
		if(value==null)
			this.requestType = null;
		else
			this.requestType = new RequestTypeImpl(value, null, null);
	}
	
	@Override
	public EventReportIndication getEventReportIndication()
	{
		return this.eventReportIndication;
	}
	
	@Override
	public void setEventReportIndication(EventReportIndication value)
	{
		this.eventReportIndication = value;
	}
	
	@Override
	public InetAddress getFramedIPAddress()
	{
		if(framedIPAddress==null)
			return null;
		
		return this.framedIPAddress.getAddress();
	}
	
	@Override
	public void setFramedIPAddress(Inet4Address value)
	{
		if(value==null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);
	}
	
	@Override
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return this.framedIPv6Prefix.getValue();
	}
	
	@Override
	public void setFramedIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
	}
	
	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String value) 
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	@Override
	public List<ADCRuleInstall> getADCRuleInstall()
	{
		return this.adcRuleInstall;
	}
	
	@Override
	public void setADCRuleInstall(List<ADCRuleInstall> value)
	{
		this.adcRuleInstall = value;
	}
	
	@Override
	public List<ADCRuleRemove> getADCRuleRemove()
	{
		return this.adcRuleRemove;
	}
	
	@Override
	public void setADCRuleRemove(List<ADCRuleRemove> value)
	{
		this.adcRuleRemove = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(requestType);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		result.add(eventReportIndication);
		result.add(framedIPAddress);
		result.add(framedIPv6Prefix);
		result.add(calledStationId);
		
		if(adcRuleInstall!=null)
			result.addAll(adcRuleInstall);
		
		if(adcRuleRemove!=null)
			result.addAll(adcRuleRemove);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
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