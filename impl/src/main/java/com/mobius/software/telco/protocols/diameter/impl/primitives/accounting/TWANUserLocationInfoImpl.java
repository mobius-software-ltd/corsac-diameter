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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.SSIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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
@DiameterAvpImplementation(code = 2714L, vendorId = KnownVendorIDs.TGPP_ID)
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
	
	public TWANUserLocationInfoImpl(String ssid)
	{
		if(ssid==null)
			throw new IllegalArgumentException("SSID is required");
		
		this.ssid = new SSIDImpl(ssid, null, null);
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
			throw new IllegalArgumentException("SSID is required");
		
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
	public String validate()
	{
		if(ssid==null)
			return "SSID is required";
		
		return null;
	}	
}