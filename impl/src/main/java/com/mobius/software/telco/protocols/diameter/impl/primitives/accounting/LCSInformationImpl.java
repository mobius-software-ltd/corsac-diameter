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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 878L, vendorId = KnownVendorIDs.TGPP_ID)
public class LCSInformationImpl implements LCSInformation
{
	private LCSClientID lcsClientID;
	private LocationType locationType;
	private LocationEstimate locationEstimate;
	private PositioningData positioningData;
	private TGPPIMSI tgppIMSI;
	private MSISDN msisdn;
			
	public LCSInformationImpl()
	{
		
	}
	
	public LCSClientID getLCSClientID()
	{
		return lcsClientID;
	}
	
	public void setLCSClientID(LCSClientID value)
	{
		this.lcsClientID = value;
	}
	
	public LocationType getLocationType()
	{
		return locationType;
	}
	
	public void setLocationType(LocationType value)
	{
		this.locationType = value;
	}
	
	public ByteBuf getLocationEstimate()
	{
		if(locationEstimate==null)
			return null;
		
		return locationEstimate.getValue();
	}
	
	public void setLocationEstimate(ByteBuf value)
	{
		if(value==null)
			this.locationEstimate = null;
		else
			this.locationEstimate = new LocationEstimateImpl(value, null, null);			
	}
	
	public String getPositioningData()
	{
		if(positioningData==null)
			return null;
		
		return positioningData.getString();
	}
	
	public void setPositioningData(String value)
	{
		if(value==null)
			this.positioningData = null;
		else
			this.positioningData = new PositioningDataImpl(value, null, null);			
	}
	
	public String getTGPPIMSI()
	{
		if(tgppIMSI==null)
			return null;
		
		return tgppIMSI.getString();
	}
	
	public void setTGPPIMSI(String value)
	{
		if(value==null)
			this.tgppIMSI = null;
		else
			this.tgppIMSI = new TGPPIMSIImpl(value, null, null);			
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value==null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);			
	}
}