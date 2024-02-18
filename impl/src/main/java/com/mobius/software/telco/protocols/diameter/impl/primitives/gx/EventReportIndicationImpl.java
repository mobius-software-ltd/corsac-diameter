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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPP2BSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.HeNBLocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceReference;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrusted;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class EventReportIndicationImpl extends DiameterGroupedAvpImpl implements EventReportIndication
{
	private ANTrusted anTrusted;
	private List<EventTrigger> eventTrigger;
	private UserCSGInformation userCSGInformation; 
	private IPCANType ipcanType;
	private List<ANGWAddress> anGWAddress;
	private TGPPSGSNAddress tgppSGSNAddress;
	private TGPPSGSNIPv6Address tgppSGSNIpv6Address;
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC; 
	private FramedIPAddress framedIPAddress; 
	private RATType ratType;
	private RAI rai;
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private TraceData traceData;
	private TraceReference traceReference;
	private TGPP2BSID tgpp2BSID;
	private TGPPMSTimeZone tgppMSTimeZone;
	private RoutingIPAddress routingIPAddress;
	private UELocalIPAddress ueLocalIPAddress;
	private HeNBLocalIPAddress heNBLocalIPAddress;
	private UDPSourcePort udpSourcePort;
	private PresenceReportingAreaInformation presenceReportingAreaInformation;
		
	public EventReportIndicationImpl()
	{
		
	}
	
	public ANTrustedEnum getANTrusted()
	{
		if(anTrusted==null)
			return null;
		
		return anTrusted.getEnumerated(ANTrustedEnum.class);
	}
	
	public void setANTrusted(ANTrustedEnum value)
	{
		if(value==null)
			this.anTrusted = null;
		else
			this.anTrusted = new ANTrustedImpl(value, null, null);			
	}
	
	public List<EventTriggerEnum> getEventTrigger()
	{
		if(eventTrigger==null || eventTrigger.size()==0)
			return null;
		
		List<EventTriggerEnum> result = new ArrayList<EventTriggerEnum>();
		for(EventTrigger curr:eventTrigger)
			result.add(curr.getEnumerated(EventTriggerEnum.class));
		
		return result;
	}
	
	public void setEventTrigger(List<EventTriggerEnum> value)
	{
		if(value==null || value.size()==0)
			this.eventTrigger = null;
		else
		{
			this.eventTrigger = new ArrayList<EventTrigger>();
			for(EventTriggerEnum curr:value)
				this.eventTrigger.add(new EventTriggerImpl(curr, null, null));			
		}
	}
	
	public UserCSGInformation getUserCSGInformation()
	{
		return userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	public IPCANTypeEnum getIPCANType()
	{
		if(ipcanType==null)
			return null;
		
		return ipcanType.getEnumerated(IPCANTypeEnum.class);
	}
	
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipcanType = null;
		else
			this.ipcanType = new IPCANTypeImpl(value, null, null);			
	}
	
	public List<InetAddress> getANGWAddress()
	{
		if(anGWAddress==null || anGWAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(ANGWAddress curr:anGWAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new ANGWAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}
		
		if(value==null)
			this.anGWAddress = null;
		else
		{
			this.anGWAddress = new ArrayList<ANGWAddress>();
			for(InetAddress curr:value)
				this.anGWAddress.add(new ANGWAddressImpl(curr,null,null));		
		}
	}
	
	public ByteBuf get3GPPSGSNAddress()
	{
		if(tgppSGSNAddress==null)
			return null;
		
		return tgppSGSNAddress.getValue();
	}
	
	public void set3GPPSGSNAddress(ByteBuf value)
	{
		if(value==null)
			this.tgppSGSNAddress = null;
		else
			this.tgppSGSNAddress = new TGPPSGSNAddressImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPSGSNIpv6Address()
	{
		if(tgppSGSNIpv6Address==null)
			return null;
		
		return tgppSGSNIpv6Address.getValue();
	}
	
	public void set3GPPSGSNIpv6Address(ByteBuf value)
	{
		if(value==null)
			this.tgppSGSNIpv6Address = null;
		else
			this.tgppSGSNIpv6Address = new TGPPSGSNIPv6AddressImpl(value, null, null);			
	}
	
	public String get3GPPSGSNMCCMNC()
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}
	
	public void set3GPPSGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);			
	}
	
	public Inet4Address getFramedIPAddress()
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}
	
	public void setFramedIPAddress(Inet4Address value)
	{
		if(value==null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);			
	}
	
	public RATTypeEnum getRATType()
	{
		if(ratType==null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);			
	}
	
	public String getRAI()
	{
		if(rai==null)
			return null;
		
		return rai.getString();
	}
	
	public void setRAI(String value)
	{
		if(value==null)
			this.rai = null;
		else
			this.rai = new RAIImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	public TraceData getTraceData()
	{
		return traceData;
	}
	
	public void setTraceData(TraceData value)
	{
		this.traceData = value;		
	}
	
	public ByteBuf getTraceReference()
	{
		if(traceReference==null)
			return null;
		
		return traceReference.getValue();
	}
	
	public void setTraceReference(ByteBuf value)
	{
		if(value==null)
			this.traceReference = null;
		else
			this.traceReference = new TraceReferenceImpl(value, null, null);			
	}
	
	public ByteBuf getTGPP2BSID()
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	public void setTGPP2BSID(ByteBuf value)
	{
		if(value==null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPMSTimeZone()
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}
	
	public void set3GPPMSTimeZone(ByteBuf value)
	{
		if(value==null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);			
	}
	
	public InetAddress getRoutingIPAddress()
	{
		if(routingIPAddress==null)
			return null;
		
		return routingIPAddress.getAddress();
	}
	
	public void setRoutingIPAddress(InetAddress value)
	{
		if(value==null)
			this.routingIPAddress = null;
		else
			this.routingIPAddress = new RoutingIPAddressImpl(value, null, null);			
	}
	
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return ueLocalIPAddress.getAddress();
	}
	
	public void setUELocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);			
	}
	
	public InetAddress getHeNBLocalIPAddress()
	{
		if(heNBLocalIPAddress==null)
			return null;
		
		return heNBLocalIPAddress.getAddress();
	}
	
	public void setHeNBLocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.heNBLocalIPAddress = null;
		else
			this.heNBLocalIPAddress = new HeNBLocalIPAddressImpl(value, null, null);			
	}
	
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return udpSourcePort.getUnsigned();
	}
	
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);			
	}
	
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation()
	{
		return presenceReportingAreaInformation;
	}
	
	public void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value)
	{
		this.presenceReportingAreaInformation = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(anGWAddress!=null && anGWAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(anGWAddress);
			
			return new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}

		return null;
	}		  		  
}