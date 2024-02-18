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
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TCPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.SSIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BSSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CivicAddressInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.WLANOperatorId;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TCPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class UWANUserLocationInfoImpl implements UWANUserLocationInfo
{
	private UELocalIPAddress ueLocalIPAddress;
	private UDPSourcePort udpSourcePort;
	private SSID ssid;
	private BSSID bssid;
	private TCPSourcePort tcpSourcePort;
	private CivicAddressInformation civicAddressInformation;
	private WLANOperatorId wlanOperatorId;
	private LogicalAccessID logicalAccessID;
	
	protected UWANUserLocationInfoImpl() 
	{
	}
	
	public UWANUserLocationInfoImpl(InetAddress ueLocalIPAddress) throws MissingAvpException
	{
		setUELocalIPAddress(ueLocalIPAddress);
	}
			
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return ueLocalIPAddress.getAddress();
	}
	
	public void setUELocalIPAddress(InetAddress value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("UE-Local-IP-Address is required is required", Arrays.asList(new DiameterAvp[] { new UELocalIPAddressImpl() }));
			
		this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);		
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
	
	public String getSSID()
	{
		if(ssid==null)
			return null;
		
		return ssid.getString();
	}
	
	public void setSSID(String value)
	{
		if(value==null)
			this.ssid = null;
		else
			this.ssid = new SSIDImpl(value, null, null);			
	}
	
	public String getBSSID()
	{
		if(bssid==null)
			return null;
		
		return bssid.getString();
	}
	
	public void setBSSID(String value)
	{
		if(value==null)
			this.bssid = null;
		else
			this.bssid = new BSSIDImpl(value, null, null);			
	}
	
	public Long getTCPSourcePort()
	{
		if(tcpSourcePort==null)
			return null;
		
		return tcpSourcePort.getUnsigned();
	}
	
	public void setTCPSourcePort(Long value)
	{
		if(value==null)
			this.tcpSourcePort = null;
		else
			this.tcpSourcePort = new TCPSourcePortImpl(value, null, null);			
	}
	
	public ByteBuf getCivicAddressInformation()
	{
		if(civicAddressInformation==null)
			return null;
		
		return civicAddressInformation.getValue();
	}
	
	public void setCivicAddressInformation(ByteBuf value)
	{
		if(value==null)
			this.civicAddressInformation = null;
		else
			this.civicAddressInformation = new CivicAddressInformationImpl(value, null, null);			
	}
	
	public WLANOperatorId getWLANOperatorId()
	{
		return this.wlanOperatorId;
	}
	
	public void setWLANOperatorId(WLANOperatorId value)
	{
		this.wlanOperatorId = value;
	}
	
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ueLocalIPAddress==null)
			return new MissingAvpException("UE-Local-IP-Address is required is required", Arrays.asList(new DiameterAvp[] { new UELocalIPAddressImpl() }));
		
		return null;
	}	
}