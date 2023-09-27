package com.mobius.software.telco.protocols.diameter.impl.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.BSSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5580.LocationDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5580.LocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5580.OperatorNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BSSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5580.LocationData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5580.LocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5580.OperatorName;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1526L, vendorId = KnownVendorIDs.TGPP_ID)
public class AccessNetworkInfoImpl extends DiameterGroupedAvpImpl implements AccessNetworkInfo
{
	private SSID ssid;
	
	private BSSID bssid;
	
	private LocationInformation locationInformation;
	
	private LocationData locationData;
	
	private OperatorName operatorName;
	
	private LogicalAccessID logicalAccessID;
	
	public AccessNetworkInfoImpl()
	{
		
	}
	
	public String getSSID()
	{
		if(ssid==null)
			return null;
		
		return ssid.getString();
	}
	 
	public void setSSID(String value)
	{
		if(value == null)
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
		if(value == null)
			this.bssid = null;
		else
			this.bssid = new BSSIDImpl(value, null, null);
	}
	
	public ByteBuf getLocationInformation()
	{
		if(locationInformation==null)
			return null;
		
		return locationInformation.getValue();
	}
	
	public void setLocationInformation(ByteBuf value)
	{
		if(value == null)
			this.locationInformation = null;
		else
			this.locationInformation = new LocationInformationImpl(value, null, null);
	}
	
	public ByteBuf getLocationData()
	{
		if(locationData==null)
			return null;
		
		return locationData.getValue();
	}
	
	public void setLocationData(ByteBuf value)
	{
		if(value == null)
			this.locationData = null;
		else
			this.locationData = new LocationDataImpl(value, null, null);
	}
	
	public ByteBuf getOperatorName()
	{
		if(operatorName==null)
			return null;
		
		return operatorName.getValue();
	}
	
	public void setOperatorName(ByteBuf value)
	{
		if(value == null)
			this.operatorName = null;
		else
			this.operatorName = new OperatorNameImpl(value, null, null);
	}
	
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value == null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);
	}
}