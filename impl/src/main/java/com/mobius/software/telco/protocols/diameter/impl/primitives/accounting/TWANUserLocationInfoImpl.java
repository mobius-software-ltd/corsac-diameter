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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.SSIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BSSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CivicAddressInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.WLANOperatorId;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TWANUserLocationInfoImpl implements TWANUserLocationInfo
{
	private SSID ssid;
	private BSSID bssid; 
	private CivicAddressInformation civicAddressInformation;
	private WLANOperatorId wlanOperatorId;
	private LogicalAccessID logicalAccessID;
	
	protected TWANUserLocationInfoImpl() 
	{
	}
	
	public TWANUserLocationInfoImpl(String ssid) throws MissingAvpException
	{
		setSSID(ssid);
	}
			
	public String getSSID()
	{
		if(ssid==null)
			return null;
		
		return ssid.getString();
	}
	
	public void setSSID(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SSID is required is required", Arrays.asList(new DiameterAvp[] { new SSIDImpl() }));
		
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
		if(ssid==null)
			return new MissingAvpException("SSID is required is required", Arrays.asList(new DiameterAvp[] { new SSIDImpl() }));
		
		return null;
	}	
}