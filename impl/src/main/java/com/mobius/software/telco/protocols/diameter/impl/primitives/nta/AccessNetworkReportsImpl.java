package com.mobius.software.telco.protocols.diameter.impl.primitives.nta;

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

import java.util.Date;
import java.util.List;
import java.net.InetAddress;
import java.util.ArrayList;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetLocAccessSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TCPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TCPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.nta.AccessNetworkReports;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

import io.netty.buffer.ByteBuf;

public class AccessNetworkReportsImpl extends DiameterGroupedAvpImpl implements AccessNetworkReports
{
	private MSISDN msisdn;
	
	private List<ExternalIdentifier> externalIdentifier;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private TCPSourcePort tcpSourcePort;
	
	private UDPSourcePort udpSourcePort;
	
	private NetLocAccessSupport netLocAccessSupport;
	
	public AccessNetworkReportsImpl() 
	{
		
	}
	
	@Override	
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	 
	@Override	
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);	
	}
	
	public List<String> getExternalIdentifier()
	{
		if(externalIdentifier==null || externalIdentifier.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ExternalIdentifier curr:externalIdentifier)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setExternalIdentifier(List<String> value)
	{
		if(value==null || value.size()==0)
			this.externalIdentifier = null;
		else
		{
			this.externalIdentifier = new ArrayList<ExternalIdentifier>();
			for(String curr:value)
				this.externalIdentifier.add(new ExternalIdentifierImpl(curr, null, null));
		}
	}
	
	public ByteBuf getTGPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void setTGPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	
	@Override
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return this.userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	
	}	
	
	public String getTGPPSGSNMCCMNC()
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}
	
	public void setTGPPSGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPMSTimeZone()
	{
		if(tgppMSTimeZone == null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}
	
	@Override
	public void setTGPPMSTimeZone(ByteBuf value)
	{
		if(value == null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
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
	
	@Override
	public Long getTCPSourcePort()
	{
		if(tcpSourcePort==null)
			return null;
		
		return tcpSourcePort.getUnsigned();
	}
	
	@Override
	public void setTCPSourcePort(Long value)
	{
		if(value==null)
			this.tcpSourcePort = null;
		else
			this.tcpSourcePort = new TCPSourcePortImpl(value, null, null);			
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

	
	@Override
	public NetLocAccessSupportEnum getNetLocAccessSupport()
	{
		if(netLocAccessSupport==null)
			return null;
		
		return this.netLocAccessSupport.getEnumerated(NetLocAccessSupportEnum.class);
	}
	
	@Override
	public void setNetLocAccessSupport(NetLocAccessSupportEnum value)
	{
		if(value == null)
			this.netLocAccessSupport = null;
		else
			this.netLocAccessSupport = new NetLocAccessSupportImpl(value, null, null);
	}
	
}

 



